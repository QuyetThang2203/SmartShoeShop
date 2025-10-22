package com.example.smartshoeshop.data.remote

import android.net.Uri
import com.example.smartshoeshop.data.remote.models.OrderModel
import com.example.smartshoeshop.data.remote.models.ProductModel
import com.example.smartshoeshop.data.remote.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.UUID

class FirebaseRemoteDataSource {
    // Khởi tạo các đối tượng của Firebase: Authentication, Firestore and Storage
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val storage: FirebaseStorage = FirebaseStorage.getInstance()

    // Authentication
    suspend fun registerWithEmail(email: String, password: String): String? {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await() // await() giúp chờ kết quả trả về - nghĩa là chương trình tạm dừng ở đây cho đến khi Firebase trả kết quả về
            result.user?.uid // uid -> trả về ID duy nhất của người dùng trên Firebase
        } catch(e: Exception) {
            null
        }
    }

    suspend fun loginWithEmail(email: String, password: String): String? {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    suspend fun loginWithGoogle(idToken: String): String? { // idToken: là chuỗi mã định danh mà Google trả về sau khi người dùng đăng nhập qua tài khoản Google
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null) // tạo thông tin xác thực từ idToken
            val result = auth.signInWithCredential(credential).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    fun logOut() {
        return auth.signOut()
    }

    fun getUserCurrentId(): String? {
        return auth.currentUser?.uid
    }

    // Firestore - Product
    suspend fun getProducts(): List<ProductModel> {
        return firestore.collection("products") // hiểu như bảng chứa nhiều sản phẩm
            .get() // yêu cầu firestore lấy toàn bộ dữ liệu
            .await() // đợi kết quả trả về
            .documents // sau khi lấy xong, .documents chứa danh sách tất cả document trong collection("products")
            .mapNotNull {it.toObject<ProductModel>() } // loại bỏ các phần tử null và chuyển dữ liệu JSON thành Object Kotlin kiểu ProductModel
    }

    suspend fun addProduct(product: ProductModel): Boolean {
        return try {
            firestore.collection("products")
                .document(product.id) // Chỉ định document có id là product.id - Nếu chưa có thì Firestore tự tạo document mới với id đó - Nếu có rồi thì sẽ ghi đè lên
                .set(product) // Lưu toàn bộ thông tin product vào document (dưới dạng JSON)
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // Firestore - User
    suspend fun getUser(userId: String): UserModel? {
        return firestore.collection("users")
            .document(userId)
            .get()
            .await()
            .toObject<UserModel>() // Chuyển dữ liệu JSON sang Object Kolin kiểu UserModel
    }

    suspend fun updateUserPreferences(userId: String, preferences: Map<String, List<String>>): Boolean {
        return try {
            firestore.collection("users")
                .document(userId)
                .update("preferences", preferences) // chỉ cập nhật trường preferences - chưa có thì tự tạo - có rồi thì ghi đè
                .await()
            true
        } catch(e: Exception) {
            false
        }
    }

    // Firestore - Order
    suspend fun addOrder(order: OrderModel): Boolean {
        return try {
            firestore.collection("orders")
                .document(order.id)
                .set(order)
                .await()
            true
        } catch(e: Exception) {
            false
        }
    }

    suspend fun getOrdersForUser(userId: String): List<OrderModel> {
        return firestore.collection("orders")
            .whereEqualTo("user_id", userId)
            .get()
            .await() // await chờ hàm bất đồng bộ get() đến khi firestore trả dữ liệu về
            .documents
            .mapNotNull{ it.toObject<OrderModel>()}
    }
    // Storage

    suspend fun uploadImage(uri: Uri): String? { // uri là đường dẫn hình ảnh trên điện thoại
        return try {
            val ref = storage.reference.child("/image/${UUID.randomUUID()}.jpg") // Tạo đường dẫn trên thư mục gốc trên FireStorage để lưu ảnh
            ref.putFile(uri).await() // tải ảnh uri lên vị trí reference trên Fire Storage và chờ
            ref.downloadUrl.await().toString() // chờ firebase trả link về và chuyển thành String
        } catch(e: Exception) {
            null
        }
    }
}