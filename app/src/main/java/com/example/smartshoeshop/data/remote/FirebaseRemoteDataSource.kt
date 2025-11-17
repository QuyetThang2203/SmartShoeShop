package com.example.smartshoeshop.data.remote

import android.net.Uri
import com.example.smartshoeshop.data.remote.models.OrderModel
import com.example.smartshoeshop.data.remote.models.ProductModel
import com.example.smartshoeshop.data.remote.models.UserModel
import com.example.smartshoeshop.domain.entities.UserPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.UUID


class FirebaseRemoteDataSource {
    // Tạo instance Firebase dùng chung trong class
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val storage: FirebaseStorage = FirebaseStorage.getInstance()

    // ---------------- AUTHENTICATION ----------------
    // Đăng ký bằng email & password, trả về userId nếu thành công
    suspend fun registerWithEmail(email: String, password: String): String? {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    suspend fun loginWithEmail(email: String, password: String): String? {
        return try {
            val result = auth.signInWithEmailAndPassword(email,password).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    // Đăng nhập Google bằng idToken
    suspend fun loginWithGoogle(idToken: String): String? {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = auth.signInWithCredential(credential).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    fun logout() {
        auth.signOut()
    }

    fun getCurrentUserId(): String? {
        return auth.currentUser?.uid
    }

    // ---------------- PRODUCTS ----------------
    // Lấy tất cả sản phẩm từ Firestore
    suspend fun getProducts(): List<ProductModel> {
        return firestore.collection("products")
            .get()
            .await()
            .documents
            .mapNotNull {
                it.toObject<ProductModel>() // Chuyển document → object
            }
    }

    suspend fun addProduct(product: ProductModel): Boolean {
        return try {
            firestore.collection("products")
                .document(product.id) // Dùng id làm docId
                .set(product)                        // Ghi dữ liệu
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // ---------------- USERS ----------------
    // Lấy thông tin user theo ID
    suspend fun getUser(userId: String): UserModel? {
        return firestore.collection("users")
            .document(userId)
            .get()
            .await()
            .toObject<UserModel>()
    }

    // Cập nhật preferences cho user
    // preferences: Map<"category", listOf("sport", "classic")>
    suspend fun updateUserPreferences(userId: String, preferences: Map<String, List<String>>): Boolean {
        return try {
            firestore.collection("users")
                .document(userId)
                .update("preferences", preferences) // update 1 field
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // ---------------- ORDERS ----------------
    suspend fun addOrder(order: OrderModel): Boolean {
        return try {
            firestore.collection("orders")
                .document(order.id)
                .set(order)
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getOrderForUser(userId: String): List<OrderModel> {
        return firestore.collection("orders")
            .whereEqualTo("user_id", userId)
            .get()
            .await()
            .documents.mapNotNull { it.toObject<OrderModel>() }
    }

    // ---------------- STORAGE ----------------
    // Upload ảnh lên Firebase Storage và trả về URL download
    suspend fun uploadImage(uri: Uri): String? {
        return try {
            val ref = storage.reference.child("image/${UUID.randomUUID()}.jpg")
            ref.putFile(uri).await()
            ref.downloadUrl.await().toString()
        } catch (e: Exception) {
            null
        }
    }
}