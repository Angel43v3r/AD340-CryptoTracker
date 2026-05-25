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
### STEP 1: Go to `File` -> `New` -> `New Project` -> Select `Empty Activity`

### STEP 2: Go to `Project` -> `AD340-CryptoTracker` folder -> `app` -> `build.gradle.kts`

### STEP 3: In `app/build.gradle.kts` under **dependencies** add
```kotlin

```

Also add this under **plugins**
```kotlin

```

### STEP 4: In `build.gradle.kts` root level add
```kotlin

```

*NOTE: Check your kotlin version under gradle/libs.version.toml*

### STEP 5: In `libs.versions.toml` gradle folder add
```toml

```

### STEP 6: In `gradle.properties` add
```kotlin

```
### STEP 7: Go to `File` -> `Sync Project with Gradle Files`

### STEP 8: In `app/src/main/java/com.example.ad340_neverforget` folder,
Create the files needed for the assignment. Follow Assignment Instruction.
- MainActivity.kt
- ?


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
