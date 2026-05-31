# The Crypto Tracker App
![Android Studio](https://github.com/Angel43v3r/AD340-Assignments-TheSkylineMessenger/blob/master/Android_Studio_icon.png)
## Assignment 15 - Crypto Tracker App in Android
### AD340 - Mobile Application Development
### North Seattle College (Spring 2026)
### Date: May 31, 2026


## Table Of Contents
1. [Objective](#objective)
2. [How to Use](#how-to-use)
3. [Getting Started](#getting-started)
4. [Assignment Instruction](#assignment-instruction)
5. [Version Control](#version-control-github)
6. [Contributing](#contributing)
7. [License](#license)


## Objective
An Android application that fetches real-time cryptocurrency data from a public API, parses the JSON response using Ktor, and displays it in a clean, scrollable list.


## How to Use
### Prerequisites
Make sure you have the following installed:
- **Visual Studio Code (VS Code)**
    - You can use any editor, VSC is recommended for this project. You can download from [VS Code official website](https://code.visualstudio.com/).

- **Android Studio**
    - **Android Studio** is required to run the app on an Android emulator or a physical device.
    - It provides the Android SDK, emulator, and build tools needed for React Native development.
    - You can download from the [Android Studio official website](https://developer.android.com/studio).

### Installation & Environment Setup
#### 1. Clone the Repository
In the folder you want to save your project in, run:

```bash
git clone git@github.com:Angel43v3r/AD340-CryptoTracker.git
```

#### 2. Navigate to the app folder:

```
cd AD340-CryptoTracker
```

#### 3. Navigate to the folder
```
cd <Folder_Name>
```

#### 4. Now, let’s initialize a modern Android project template.


**STEP 1:** Open Android Studio and select `File` -> `New` -> `New Project`.

**STEP 2:** Choose `Empty Views Activity` (This is crucial!).

**STEP 3:** Configure the project:

```text
Name: AD340-CryptoTracker

Package name: com.example.cryptotracker

Minimum SDK: API 24 (Android 7.0) or higher.

Build configuration language: Kotlin DSL (build.gradle.kts).
```

**STEP 4:** Click Finish

- Wait for Gradle to finish "syncing" (this may take a few minutes on the first run).


## Getting Started
### STEP 1: Go to `File` -> `New` -> `New Project` -> Select `Empty View Activity`

### STEP 2: Go to `Project` -> `AD340-CryptoTracker` folder -> `app` -> `src` -> `main` -> `AndroidManifest.xml`

### STEP 3: In `AndroidManifext.xml` add the permission line
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### STEP 4: In `build.gradle.kts` app/ level replace the dependencies { } block with the following:
```kotlin
plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.example.cryptotracker"
  compileSdk = 36

  defaultConfig {
    applicationId = "com.example.cryptotracker"
    minSdk = 24
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}

dependencies {
  implementation(libs.androidx.activity.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.core.ktx)
  implementation(libs.material)

  // Ktor - HTTP Client
  implementation("io.ktor:ktor-client-android:2.3.7")
  implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
  implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

  // Kotlin Serialization (JSON parsing)
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

  // Coroutines (async network calls)
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.androidx.junit)
}
```
What did we update:
- dependencies
- plugins
- compileSdk

We also added:
- kotlin options

* Make sure to match the kotlin version in your `libs.versions.toml` file*

### STEP 5: In `libs.versions.toml` gradle folder replace with this block
```toml
[versions]
agp = "8.5.2"
coreKtx = "1.15.0"
junit = "4.13.2"
junitVersion = "1.3.0"
espressoCore = "3.7.0"
appcompat = "1.7.1"
material = "1.12.0"
activityKtx = "1.9.0"
constraintlayout = "2.2.1"
kotlin = "2.1.20"

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "appcompat" }
material = { group = "com.google.android.material", name = "material", version.ref = "material" }
androidx-activity-ktx = { group = "androidx.activity", name = "activity-ktx", version.ref = "activityKtx" }
androidx-constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "constraintlayout" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
```

### STEP 6: In `build.gradle.kts` root level, add
```kotlin
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.serialization) apply false
}
```
### STEP 7: Go to `File` -> `Invalidate Caches`
Check `Clear file system cache and Local History`
Click `Invalidate and Restart`

### STEP 8: Go to `File` -> `Sync Project with Gradle Files`

### STEP 9: Go to gradle.properties and add
```kotlin
android.useAndroidX=true
```
Then click `Sync Now`

### STEP 10: In `app/src/main/java/com.example.cryptotracker` folder,
Create the files needed for the assignment. Follow Assignment Instruction.
- CryptoCoin.kt (Data Model)
- KtorClient (HTTP client)
- CryptoAdapter (RecyclerView Adapter)

### STEP 11: Create the Item Layout.
Navigate to `app/src/main/res/layout`
Create file `item_crypto_coin.xml`

### STEP 12: Update `activity_main.xml`

### STEP 13: Update `MainActivity.kt` then Run the app

## Assignment Instruction

![Crypto App Image 1]()

### Task 1: Project Setup & Dependencies
Add the required Internet permissions to your `AndroidManifest.xml`

Add the necessary dependencies in your `build.gradle.kts`

### Task 2: Define the Data Model
You will be using the `CoinGecko Simple Price API` (or a mock equivalent).

https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1Links to an external site.

Create a Kotlin data class annotated with `@Serializable` to match the JSON structure.

### Task 3: Configure the Ktor HTTP Client
Create a singleton KtorClient object or class to initialize the engine with JSON content negotiation.

### Task 4: Design the UI
**Item Layout:** Design a custom row layout containing `TextViews` for the Coin Name, Symbol, Price, and 24h Change.

**Main Layout:** Place a `RecyclerView` and a `ProgressBar` (to show a loading state) inside the layout.

### Task 5: Create the RecyclerView Adapter
Implement a custom `RecyclerView.Adapter` and `ViewHolder` to bind the list of CryptoCoin objects to your UI items.

### Task 6: Fetch and Display Data (MainActivity)
In your `MainActivity`, use lifecycle-aware Coroutines (lifecycleScope.launch) to perform the network call asynchronously and update the UI.


## Version Control (GitHub)
### GitHub Initial Setup
#### 1. Open Android Studio
#### 2. Select `File` -> `Git` -> `Share Project On GitHub`

### To Commit:
Select `File` -> `Git` -> `GitHub` -> Commit

### To Push:
Select `File` -> `Git` -> `GitHub` -> Pull

### To Pull:
Select `File` -> `Git` -> `GitHub` -> Pull


## Contributing
Developed By: **Jovy Ann Nelson**

Instructor: **BC Ko**

Course: **AD340 - Mobile Application Development**

College: **North Seattle College**

Term: **Spring 2026**

Date: **May 25, 2026** to **May 31, 2026**


## License

This project is licensed under the MIT License. Please refer to the [LICENSE](https://github.com/Angel43v3r/AD340-neverForget/blob/master/LICENSE) for more details.
