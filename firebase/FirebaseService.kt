package com.example.smartshoeshop.firebase

import android.net.Uri
import com.example.smartshoeshop.model.Order
import com.example.smartshoeshop.model.Product
import com.example.smartshoeshop.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.UUID

class FirebaseService {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val storage: FirebaseStorage = FirebaseStorage.getInstance()

    //Authentication
    suspend fun registerWithEmail(email: String, password: String): String? {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.uid
        } catch (e: Exception) {
            null
        }
    }

    suspend fun loginWithEmail(email:String, password: String): String? {
        return try{
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user?.uid
        } catch(e: Exception) {
            null
        }
    }

    suspend fun loginWithGoogle(idToken: String): String? {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = auth.signInWithCredential(credential).await()
            result.user?.uid
        } catch(e: Exception) {
            null
        }
    }

    fun logout() {
        auth.signOut()
    }

    //Firestore hoạt động theo mô hình Collection → Document → Field:
    //Firestore - Product
    suspend fun getProducts(): List<Product> {
        return firestore.collection("products").get().await()
            .documents.mapNotNull {it.toObject<Product>() }
    }

    suspend fun addProduct(product: Product): Boolean {
        return try {
            firestore.collection("products").
                document(product.id).set(product).await()
            true
        } catch(e: Exception) {
            false
        }
    }

    //Firestore - Users
    suspend fun getUser(userId: String): User? {
        return firestore.collection("users")
            .document(userId).get().await().toObject<User>()
    }

    suspend fun updateUserPreferences(userId: String, preferences: Map<String, Any>): Boolean {
        return try {
            firestore.collection("users")
                .document("userId")
                .update("preferences", preferences)
                .await()
            true
        } catch(e: Exception) {
            false
        }
    }

    //Firestore - Orders
    suspend fun addOrder(order: Order): Boolean {
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

    suspend fun getOrderForUser(userId: String): List<Order> {
        return firestore.collection("orders")
            .whereEqualTo("userId", userId)
            .get().await().documents.mapNotNull {it.toObject<Order>()}
    }

    //Storage - Upload Image
    suspend fun uploadImage(uri: Uri): String? {
        return try {
            val ref = storage.reference.child("images/${UUID.randomUUID()}/jpg")
            ref.putFile(uri).await()
            ref.downloadUrl.await().toString()
        } catch(e: Exception) {
            null
        }
    }
}