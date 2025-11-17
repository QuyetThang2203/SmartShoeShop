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



``````````````````````````````````````````````````````````````````
## Giai Đoạn 2: Thiết Kế Database Và Backend Với Firebase Và Room theo clean architecture

app/
└─ src/main/java/com/example/smartshoeshop/
├─ domain/                            # 🧠 Tầng nghiệp vụ (business logic)
│  ├─ entities/                       # 📦 Các mô hình dữ liệu thuần Kotlin (không phụ thuộc Android)
│  │  ├─ Product.kt                   # -> Lớp mô tả sản phẩm (id, tên, giá, hình ảnh...)
│  │  ├─ User.kt                      # -> Lớp mô tả thông tin người dùng
│  │  ├─ UserPreferences.kt           # -> Lớp lưu cài đặt người dùng (theme, ngôn ngữ...)
│  │  ├─ CartItem.kt                  # -> Mục trong giỏ hàng (sản phẩm, số lượng, size...)
│  │  └─ Order.kt                     # -> Đơn hàng (sản phẩm, tổng tiền, trạng thái...)
│  │
│  ├─ repositories/                   # 🔌 Các interface định nghĩa cách truy cập dữ liệu
│  │  ├─ ProductRepository.kt         # -> Định nghĩa hàm lấy sản phẩm, đồng bộ sản phẩm
│  │  ├─ UserPreferencesRepository.kt # -> Lấy và lưu cấu hình người dùng
│  │  ├─ CartRepository.kt            # -> Quản lý giỏ hàng
│  │  ├─ AuthRepository.kt            # -> Đăng nhập / đăng ký / đăng xuất
│  │  ├─ OrderRepository.kt           # -> Quản lý đơn hàng
│  │  └─ StorageRepository.kt         # -> Lưu trữ hình ảnh, file (Firebase Storage)
│  │
│  └─ usecases/                       # ⚙️ Mỗi UseCase đại diện cho 1 hành vi nghiệp vụ cụ thể
│     ├─ GetProductsUseCase.kt        # -> Lấy danh sách sản phẩm (từ local)
│     ├─ FetchProductsUseCase.kt      # -> Tải sản phẩm mới từ Firebase và lưu cache
│     ├─ GetUserPreferencesUseCase.kt # -> Lấy cấu hình người dùng
│     └─ SaveUserPreferencesUseCase.kt# -> Lưu cấu hình người dùng vào local
│
├─ data/                              # 💾 Tầng dữ liệu (Data Layer)
│  ├─ local/                          # 🏠 Dữ liệu lưu trữ cục bộ (Room Database)
│  │  ├─ AppDatabase.kt               # -> Cấu hình Room (chứa các DAO)
│  │  ├─ LocalDataSource.kt           # -> Lớp trung gian wrap các DAO để repository gọi dễ hơn
│  │  ├─ dao/                         # -> DAO = Data Access Object (truy vấn DB)
│  │  │  ├─ ProductDao.kt             # -> CRUD sản phẩm
│  │  │  ├─ UserPreferencesDao.kt     # -> CRUD cài đặt người dùng
│  │  │  └─ CartItemDao.kt            # -> CRUD giỏ hàng
│  │  └─ entities/                    # -> Entity = bảng trong Room
│  │     ├─ ProductEntity.kt          # -> Bảng sản phẩm
│  │     ├─ UserPreferencesEntity.kt  # -> Bảng lưu cài đặt người dùng
│  │     └─ CartItemEntity.kt         # -> Bảng giỏ hàng
│  │ 
│  │
│  ├─ remote/                         # ☁️ Dữ liệu từ server (Firebase / API)
│  │  ├─ FirebaseRemoteDataSource.kt  # -> Gọi Firestore, Auth, Storage
│  │  └─ models/                      # -> Model phản ánh dữ liệu từ Firebase
│  │     ├─ ProductModel.kt           # -> Cấu trúc JSON của sản phẩm trên Firebase
│  │     ├─ UserModel.kt              # -> Cấu trúc người dùng trên Firebase
│  │     └─ OrderModel.kt             # -> Cấu trúc đơn hàng trên Firebase
│  │
│  ├─ mappers/                        # 🔄 Chuyển đổi giữa Domain <-> Entity <-> Model
│  │  ├─ ProductMapper.kt             # -> Chuyển đổi ProductModel <-> ProductEntity <-> Product
│  │  ├─ UserMapper.kt                # -> Chuyển đổi UserModel <-> User
│  │  ├─ UserPreferencesMapper.kt     # -> Chuyển đổi giữa entity và domain cho preferences
│  │  ├─ CartItemMapper.kt            # -> Chuyển đổi CartItem giữa domain & entity
│  │  └─ OrderMapper.kt               # -> Chuyển đổi OrderModel <-> OrderEntity <-> Order
│  │
│  ├─ repositories/                   # 🧩 Triển khai cụ thể các repository interface trong domain
│  │  ├─ ProductRepositoryImpl.kt     # -> Dùng Local + Remote để lấy dữ liệu sản phẩm
│  │  ├─ UserPreferencesRepositoryImpl.kt # -> Triển khai lưu/lấy cài đặt người dùng
│  │  ├─ CartRepositoryImpl.kt        # -> Triển khai thao tác giỏ hàng
│  │  ├─ AuthRepositoryImpl.kt        # -> Triển khai đăng nhập/đăng ký Firebase
│  │  ├─ OrderRepositoryImpl.kt       # -> Triển khai xử lý đơn hàng
│  │  └─ StorageRepositoryImpl.kt     # -> Triển khai upload hình ảnh lên Firebase Storage
│
└─ (presentation/ui/di/utils)         # 🎨 Tầng hiển thị (ViewModel, UI, DI) — chưa hiển thị ở đây
                                      # -> ViewModel gọi UseCase
                                      # -> UI (Compose/Activity) observe StateFlow từ ViewModel
                                      # -> DI (Hilt/Koin) inject repository & usecase

``````
DAO thực thi SQL (do Room tạo code).

LocalDataSource gọi DAO.

RepositoryImpl gọi LocalDataSource (và có thể gọi cả Firebase).

Domain (UseCase) gọi Repository.

UI (ViewModel) gọi UseCase.


``````````````````````````````````````````````````````````````````



``````````````````````````````````````````````````````````````````
app/src/main/java/com/example/smartshoeshop/
     ├─ domain/                                  // 🧠 Tầng nghiệp vụ (logic thuần, không phụ thuộc Android)
     │  ├─ entities/                             // 🧩 Các data class mô tả đối tượng trong app (Product, User,...)
     │  │  ├─ Product.kt
     │  │  ├─ UserPreferences.kt
     │  │  ├─ CartItem.kt
     │  │  ├─ User.kt
     │  │  └─ Order.kt                          // chứa cả OrderProduct data class (sản phẩm trong đơn hàng)
     │  │
     │  ├─ repositories/                         // 🔌 Interface định nghĩa hành vi mà tầng Data phải thực hiện (port)
     │  │  ├─ ProductRepository.kt
     │  │  ├─ UserPreferencesRepository.kt
     │  │  ├─ CartRepository.kt
     │  │  ├─ AuthRepository.kt
     │  │  ├─ OrderRepository.kt
     │  │  └─ StorageRepository.kt
     │  │
     │  ├─ usecases/                             // ⚙️ Các trường hợp sử dụng (1 hành động nghiệp vụ)
     │  │  ├─ product/
     │  │  │  ├─ GetProductsUseCase.kt           // Lấy danh sách sản phẩm
     │  │  │  ├─ FetchProductsUseCase.kt         // Gọi API để cập nhật dữ liệu
     │  │  │  └─ GetProductByIdUseCase.kt
     │  │  ├─ preferences/
     │  │  │  ├─ GetUserPreferencesUseCase.kt
     │  │  │  └─ SaveUserPreferencesUseCase.kt
     │  │  ├─ cart/
     │  │  │  ├─ GetCartItemsUseCase.kt
     │  │  │  ├─ AddCartItemUseCase.kt
     │  │  │  └─ DeleteCartItemUseCase.kt
     │  │  ├─ auth/
     │  │  │  ├─ LoginWithEmailUseCase.kt
     │  │  │  └─ LoginWithGoogleUseCase.kt
     │  │  └─ order/
     │  │     ├─ AddOrderUseCase.kt
     │  │     └─ GetOrdersForUserUseCase.kt
     │  │
     │  └─ di/
     │     └─ DomainModule.kt                    // 🔧 Cung cấp use case (nếu cần inject riêng ở tầng domain)
     │
     ├─ data/                                   // 💾 Tầng dữ liệu (Data layer) - nơi xử lý thật với DB & Firebase
     │  ├─ local/                               // 📦 Dữ liệu lưu trữ cục bộ (Room)
     │  │  ├─ AppDatabase.kt                    // Khởi tạo Room Database
     │  │  ├─ LocalDataSource.kt                // Lớp trung gian gọi đến DAO
     │  │  ├─ dao/
     │  │  │  ├─ ProductDao.kt
     │  │  │  ├─ UserPreferencesDao.kt
     │  │  │  └─ CartItemDao.kt
     │  │  └─ entities/                         // Entity mapping cho Room
     │  │     ├─ ProductEntity.kt
     │  │     ├─ UserPreferencesEntity.kt
     │  │     └─ CartItemEntity.kt
     │  │
     │  ├─ remote/                              // 🌐 Dữ liệu từ Firebase / API
     │  │  ├─ FirebaseRemoteDataSource.kt        // Lấy dữ liệu từ Firestore
     │  │  ├─ FirebaseAuthDataSource.kt          // Xử lý đăng nhập Firebase Auth
     │  │  └─ models/
     │  │     ├─ ProductModel.kt
     │  │     ├─ UserModel.kt
     │  │     └─ OrderModel.kt
     │  │
     │  ├─ mappers/                             // 🔄 Chuyển đổi giữa Entity <-> Domain <-> Model
     │  │  ├─ ProductMapper.kt
     │  │  ├─ UserPreferencesMapper.kt
     │  │  ├─ CartItemMapper.kt
     │  │  ├─ UserMapper.kt
     │  │  └─ OrderMapper.kt
     │  │
     │  ├─ repositories/                         // 🧩 Implement các interface trong domain.repositories
     │  │  ├─ ProductRepositoryImpl.kt
     │  │  ├─ UserPreferencesRepositoryImpl.kt
     │  │  ├─ CartRepositoryImpl.kt
     │  │  ├─ AuthRepositoryImpl.kt
     │  │  ├─ OrderRepositoryImpl.kt
     │  │  └─ StorageRepositoryImpl.kt
     │  │
     │  └─ di/
     │     ├─ DatabaseModule.kt                  // @Provides Room, DAO (Singleton)
     │     ├─ RemoteModule.kt                    // @Provides Firebase instance
     │     └─ RepositoryModule.kt                // @Binds Impl -> Interface (Singleton)
     │
     ├─ datastore/                               // ⚙️ DataStore để lưu thông tin user cục bộ (lightweight)
     │  ├─ preferences/
     │  │  ├─ UserPreferencesStore.kt            // Lớp quản lý DataStore
     │  │  └─ DataStoreKeys.kt                   // Khai báo các key lưu trữ
     │  ├─ proto/
     │  │  ├─ UserPreferencesProto.kt            // Nếu dùng ProtoDataStore
     │  │  └─ UserPreferencesProtoSerializer.kt
     │  └─ di/
     │     └─ DatastoreModule.kt                 // @Provides DataStore instance
     │
     └─ presentation/                            // 🎨 Tầng giao diện (MVVM + UI logic)
        ├─ base/                                 // 🧱 Base class dùng chung
        │  ├─ BaseFragment.kt
        │  ├─ BaseActivity.kt
        │  ├─ BaseViewModel.kt
        │  └─ BaseAdapter.kt
        │
        ├─ navigation/                           // 🚀 Điều hướng (Navigation Component)
        │  ├─ AppNavigator.kt                    // Interface trừu tượng
        │  ├─ NavControllerAppNavigator.kt       // Cài đặt cụ thể bằng NavController
        │  └─ NavExtensions.kt                   // Tiện ích mở rộng (extensions)
        │
        ├─ screen/                               // 🖼️ Mỗi màn hình theo module
        │  ├─ product/
        │  │  ├─ ProductListFragment.kt
        │  │  ├─ ProductDetailFragment.kt
        │  │  └─ adapters/
        │  │     └─ ProductAdapter.kt
        │  │
        │  ├─ cart/
        │  │  └─ CartFragment.kt
        │  │
        │  ├─ auth/
        │  │  ├─ LoginFragment.kt
        │  │  └─ RegisterFragment.kt
        │  │
        │  ├─ order/
        │  │  └─ OrdersFragment.kt
        │  │
        │  └─ settings/
        │     └─ PreferencesFragment.kt
        │
        ├─ state/                                // 📊 UI State (immutable state pattern)
        │  ├─ product/
        │  │  ├─ ProductListState.kt
        │  │  └─ ProductDetailState.kt
        │  ├─ cart/
        │  │  └─ CartState.kt
        │  ├─ auth/
        │  │  └─ AuthState.kt
        │  └─ order/
        │     └─ OrdersState.kt
        │
        ├─ viewmodel/                            // 🧠 ViewModel (Hilt inject UseCase)
        │  ├─ product/
        │  │  ├─ ProductListViewModel.kt
        │  │  └─ ProductDetailViewModel.kt
        │  ├─ cart/
        │  │  └─ CartViewModel.kt
        │  ├─ auth/
        │  │  └─ AuthViewModel.kt
        │  ├─ order/
        │  │  └─ OrdersViewModel.kt
        │  └─ settings/
        │     └─ PreferencesViewModel.kt
        │
        ├─ util/                                 // 🧰 Tiện ích UI (extension, binding,...)
        │  ├─ Extensions.kt
        │  ├─ BindingAdapters.kt
        │  └─ ViewUtils.kt
        │
        └─ di/                                   // ⚙️ Dependency Injection cho presentation layer
           ├─ PresentationModule.kt              // @Binds cho ActivityComponent
           └─ ViewModelModule.kt                 // @Provides cho ViewModelComponent
``````````````````````````````````````````````````````````````````



