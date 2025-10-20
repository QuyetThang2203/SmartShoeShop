# Cây Thư Mục Dự Án SmartShoeShop Qua Từng Giai Đoạn

## Giai Đoạn 1: Chuẩn Bị Và Thiết Lập Dự Án
Mục tiêu: Thiết lập dự án cơ bản với cấu hình ban đầu.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── MainActivity.kt                # Activity chính khởi tạo Jetpack Compose
│   │   │   │   ├── MainApplication.kt            # Khởi tạo Firebase (nếu cần)
│   │   │   ├── res/
│   │   │   │   ├── drawable/                    # Icons, splash screen images
│   │   │   │   ├── layout/                      # Empty hoặc không dùng (Compose-based)
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml              # Theme colors
│   │   │   │   │   ├── strings.xml             # String resources
│   │   │   │   │   ├── themes.xml              # Material3 theme
│   │   │   ├── AndroidManifest.xml              # Permissions (Internet, Storage) 
│   │   ├── androidTest/                         # UI tests (trống lúc này)
│   │   ├── test/                               # Unit tests (trống lúc này)
│   ├── build.gradle.kts                        # Dependencies: Compose, Firebase, Room
├── gradle/
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar
│   │   ├── gradle-wrapper.properties
├── build.gradle.kts                            # Project-level Gradle
├── settings.gradle.kts                         # Project settings
├── .gitignore                                  # Git ignore rules
```

**Lưu ý**: Tệp `google-services.json` sẽ được thêm vào `app/` sau khi tạo Firebase project.

## Giai Đoạn 2: Thiết Kế Database Và Backend Với Firebase Và Room
Mục tiêu: Thêm các package và tệp liên quan đến database và Firebase.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── ProductDao.kt       # DAO cho Product
│   │   │   │   │   │   ├── UserPreferencesDao.kt # DAO cho user preferences
│   │   │   │   │   │   ├── CartItemDao.kt     # DAO cho giỏ hàng
│   │   │   │   │   ├── entity/
│   │   │   │   │   │   ├── Product.kt         # Entity cho sản phẩm
│   │   │   │   │   │   ├── UserPreferences.kt # Entity cho preferences
│   │   │   │   │   │   ├── CartItem.kt        # Entity cho giỏ hàng
│   │   │   │   │   ├── AppDatabase.kt         # Room Database
│   │   │   │   ├── firebase/
│   │   │   │   │   ├── FirebaseService.kt     # Firebase Auth, Firestore, Storage
│   │   │   │   ├── model/                    # Data classes cho Firebase
│   │   │   │   │   ├── Product.kt            # Data class cho sản phẩm
│   │   │   │   │   ├── User.kt               # Data class cho người dùng
│   │   │   │   │   ├── Order.kt              # Data class cho đơn hàng
│   │   │   │   ├── repository/
│   │   │   │   │   ├── ProductRepository.kt  # Repository kết hợp Room và Firebase
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   ├── test/
│   ├── build.gradle.kts
│   ├── google-services.json                   # Firebase config
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Các tệp trong `model/` có thể trùng tên với `entity/` nhưng có mục đích khác (entity cho Room, model cho Firebase).

## Giai Đoạn 3: Xây Dựng UI Với Jetpack Compose
Mục tiêu: Thêm các Composable screens và navigation.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   ├── firebase/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── components/
│   │   │   │   │   │   ├── ProductCard.kt    # Composable cho card sản phẩm
│   │   │   │   │   │   ├── SearchBar.kt      # Composable cho thanh tìm kiếm
│   │   │   │   │   ├── screens/
│   │   │   │   │   │   ├── HomeScreen.kt     # Danh sách sản phẩm
│   │   │   │   │   │   ├── ProductDetailScreen.kt # Chi tiết sản phẩm
│   │   │   │   │   │   ├── CartScreen.kt     # Giỏ hàng
│   │   │   │   │   │   ├── ProfileScreen.kt  # Hồ sơ người dùng
│   │   │   │   │   │   ├── LoginScreen.kt    # Đăng nhập
│   │   │   │   │   │   ├── RegisterScreen.kt # Đăng ký
│   │   │   │   │   │   ├── ChatbotScreen.kt  # Giao diện chatbot
│   │   │   │   │   ├── navigation/
│   │   │   │   │   │   ├── NavGraph.kt      # Navigation setup
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/                 # Thêm ảnh sản phẩm mẫu
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── themes.xml           # Cập nhật theme cho Material3
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   │   ├── ui/
│   │   │   │   ├── HomeScreenTest.kt        # UI test cho HomeScreen
│   │   ├── test/
│   │   ├── build.gradle.kts                 # Thêm Coil cho images
│   ├── google-services.json
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Thư mục `components/` chứa các Composable tái sử dụng để tránh lặp code.

## Giai Đoạn 4: Triển Khai Mô Hình MVVM
Mục tiêu: Thêm ViewModels để kết nối UI và repository.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   ├── firebase/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── ui/
│   │   │   │   ├── viewmodel/
│   │   │   │   │   ├── ProductViewModel.kt   # ViewModel cho sản phẩm
│   │   │   │   │   ├── CartViewModel.kt     # ViewModel cho giỏ hàng
│   │   │   │   │   ├── ChatbotViewModel.kt  # ViewModel cho chatbot
│   │   │   │   │   ├── RecommendationViewModel.kt # ViewModel cho tư vấn AI
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   ├── test/
│   │   │   ├── viewmodel/
│   │   │   │   ├── ProductViewModelTest.kt  # Unit test cho ProductViewModel
│   │   ├── build.gradle.kts
│   ├── google-services.json
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Thêm unit tests trong `test/viewmodel/` để kiểm tra logic ViewModel.

## Giai Đoạn 5: Phát Triển Chatbot Và Hệ Thống Tư Vấn Sản Phẩm Sử Dụng AI
Mục tiêu: Thêm các tệp liên quan đến AI và chatbot.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   ├── firebase/
│   │   │   │   │   ├── DialogflowService.kt  # Tích hợp Dialogflow cho chatbot
│   │   │   │   ├── model/
│   │   │   │   │   ├── ChatMessage.kt       # Data class cho tin nhắn chatbot
│   │   │   │   ├── repository/
│   │   │   │   │   ├── RecommendationRepository.kt # Repository cho tư vấn AI
│   │   │   │   ├── ui/
│   │   │   │   ├── viewmodel/
│   │   │   │   ├── ai/
│   │   │   │   │   ├── RecommendationEngine.kt # Logic tư vấn AI
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   ├── assets/
│   │   │   │   ├── model.tflite            # Model TensorFlow Lite (nếu dùng)
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   ├── test/
│   │   ├── build.gradle.kts                 # Thêm ML Kit hoặc Dialogflow dependency
│   ├── google-services.json
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Tệp `model.tflite` là tùy chọn nếu dùng TensorFlow Lite.

## Giai Đoạn 6: Testing Và Debug
Mục tiêu: Mở rộng thư mục test.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   ├── firebase/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── ui/
│   │   │   │   ├── viewmodel/
│   │   │   │   ├── ai/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   ├── assets/
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   │   ├── ui/
│   │   │   │   ├── ProductDetailScreenTest.kt # Thêm UI test
│   │   │   │   ├── ChatbotScreenTest.kt     # Thêm UI test
│   │   ├── test/
│   │   │   ├── repository/
│   │   │   │   ├── ProductRepositoryTest.kt # Unit test cho repository
│   │   │   ├── viewmodel/
│   │   │   │   ├── CartViewModelTest.kt    # Thêm unit test
│   │   ├── build.gradle.kts
│   ├── google-services.json
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Thêm Mockito hoặc Robolectric nếu cần mock dependencies.

## Giai Đoạn 7: Deployment Và Bảo Trì
Mục tiêu: Thêm cấu hình cho deployment.

```
SmartShoeShop/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/smartshoeshop/
│   │   │   │   ├── database/
│   │   │   │   ├── firebase/
│   │   │   │   │   ├── CrashlyticsService.kt # Firebase Crashlytics
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── ui/
│   │   │   │   ├── viewmodel/
│   │   │   │   ├── ai/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── MainApplication.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_launcher_foreground.png # Icon cho Play Store
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml         # Cập nhật app name, description
│   │   │   ├── assets/
│   │   │   ├── AndroidManifest.xml
│   │   ├── androidTest/
│   │   ├── test/
│   │   ├── proguard-rules.pro              # Proguard cho minify
│   │   ├── build.gradle.kts                # Cấu hình signingConfigs
│   ├── google-services.json
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
```

**Lưu ý**: Tệp `proguard-rules.pro` để tối ưu hóa và bảo vệ code khi release.



* Full project structure
  SmartShoeShop/
  ├── app/
  │   ├── src/
  │   │   ├── main/
  │   │   │   ├── java/com/example/smartshoeshop/
  │   │   │   │   ├── ai/
  │   │   │   │   │   ├── RecommendationEngine.kt      # Logic tư vấn AI
  │   │   │   │   ├── database/
  │   │   │   │   │   ├── dao/
  │   │   │   │   │   │   ├── ProductDao.kt           # DAO cho Product
  │   │   │   │   │   │   ├── UserPreferencesDao.kt   # DAO cho user preferences
  │   │   │   │   │   │   ├── CartItemDao.kt         # DAO cho giỏ hàng
  │   │   │   │   │   ├── entity/
  │   │   │   │   │   │   ├── Product.kt             # Entity cho sản phẩm
  │   │   │   │   │   │   ├── UserPreferences.kt     # Entity cho preferences
  │   │   │   │   │   │   ├── CartItem.kt            # Entity cho giỏ hàng
  │   │   │   │   │   ├── AppDatabase.kt             # Room Database
  │   │   │   │   ├── firebase/
  │   │   │   │   │   ├── FirebaseService.kt         # Firebase Auth, Firestore, Storage
  │   │   │   │   │   ├── DialogflowService.kt       # Tích hợp Dialogflow cho chatbot
  │   │   │   │   │   ├── CrashlyticsService.kt      # Firebase Crashlytics
  │   │   │   │   ├── model/
  │   │   │   │   │   ├── Product.kt                # Data class cho sản phẩm
  │   │   │   │   │   ├── User.kt                   # Data class cho người dùng
  │   │   │   │   │   ├── Order.kt                  # Data class cho đơn hàng
  │   │   │   │   │   ├── ChatMessage.kt            # Data class cho tin nhắn chatbot
  │   │   │   │   ├── repository/
  │   │   │   │   │   ├── ProductRepository.kt      # Repository cho sản phẩm
  │   │   │   │   │   ├── RecommendationRepository.kt # Repository cho tư vấn AI
  │   │   │   │   ├── ui/
  │   │   │   │   │   ├── components/
  │   │   │   │   │   │   ├── ProductCard.kt        # Composable cho card sản phẩm
  │   │   │   │   │   │   ├── SearchBar.kt          # Composable cho thanh tìm kiếm
  │   │   │   │   │   ├── screens/
  │   │   │   │   │   │   ├── HomeScreen.kt         # Danh sách sản phẩm
  │   │   │   │   │   │   ├── ProductDetailScreen.kt # Chi tiết sản phẩm
  │   │   │   │   │   │   ├── CartScreen.kt         # Giỏ hàng
  │   │   │   │   │   │   ├── ProfileScreen.kt      # Hồ sơ người dùng
  │   │   │   │   │   │   ├── LoginScreen.kt        # Đăng nhập
  │   │   │   │   │   │   ├── RegisterScreen.kt     # Đăng ký
  │   │   │   │   │   │   ├── ChatbotScreen.kt      # Giao diện chatbot
  │   │   │   │   │   ├── navigation/
  │   │   │   │   │   │   ├── NavGraph.kt           # Navigation setup
  │   │   │   │   ├── viewmodel/
  │   │   │   │   │   ├── ProductViewModel.kt       # ViewModel cho sản phẩm
  │   │   │   │   │   ├── CartViewModel.kt          # ViewModel cho giỏ hàng
  │   │   │   │   │   ├── ChatbotViewModel.kt       # ViewModel cho chatbot
  │   │   │   │   │   ├── RecommendationViewModel.kt # ViewModel cho tư vấn AI
  │   │   │   │   ├── MainActivity.kt               # Activity chính
  │   │   │   │   ├── MainApplication.kt            # Khởi tạo Firebase
  │   │   │   ├── res/
  │   │   │   │   ├── drawable/
  │   │   │   │   │   ├── ic_launcher_foreground.png # Icon ứng dụng
  │   │   │   │   │   ├── splash_background.xml     # Splash screen background
  │   │   │   │   ├── layout/                      # Không dùng (Compose-based)
  │   │   │   │   ├── values/
  │   │   │   │   │   ├── colors.xml               # Theme colors
  │   │   │   │   │   ├── strings.xml              # String resources
  │   │   │   │   │   ├── themes.xml               # Material3 theme
  │   │   │   ├── assets/
  │   │   │   │   ├── model.tflite                 # Model TensorFlow Lite (tùy chọn)
  │   │   │   ├── AndroidManifest.xml               # Permissions (Internet, Storage)
  │   │   ├── androidTest/
  │   │   │   ├── ui/
  │   │   │   │   ├── HomeScreenTest.kt            # UI test cho HomeScreen
  │   │   │   │   ├── ProductDetailScreenTest.kt   # UI test cho ProductDetailScreen
  │   │   │   │   ├── ChatbotScreenTest.kt         # UI test cho ChatbotScreen
  │   │   ├── test/
  │   │   │   ├── repository/
  │   │   │   │   ├── ProductRepositoryTest.kt    # Unit test cho repository
  │   │   │   ├── viewmodel/
  │   │   │   │   ├── ProductViewModelTest.kt     # Unit test cho ProductViewModel
  │   │   │   │   ├── CartViewModelTest.kt        # Unit test cho CartViewModel
  │   │   ├── proguard-rules.pro                   # Proguard cho release
  │   │   ├── build.gradle.kts                     # Dependencies và signingConfigs
  │   ├── google-services.json                     # Firebase config
  ├── gradle/
  │   ├── wrapper/
  │   │   ├── gradle-wrapper.jar
  │   │   ├── gradle-wrapper.properties
  ├── build.gradle.kts                             # Project-level Gradle
  ├── settings.gradle.kts                          # Project settings
  ├── .gitignore                                   # Git ignore rules