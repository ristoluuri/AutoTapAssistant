# AutoTapAssistant (Ad Skip Automation)

This project is an Android Accessibility-based automation tool designed to detect and press the **"Skip Ad"** button automatically in supported apps such as YouTube.  
It does **not remove or block ads** — it only taps the "Skip" button when it becomes visible on screen, similar to how a user would manually interact.

> **Note:** This project is for educational and personal use to learn Android Accessibility Services and Kotlin automation.  
> Sharing, distributing, or publishing modified versions targeting specific commercial apps may violate app Terms of Service.

---

## Features

- Detects on-screen "Skip Ad" button
- Simulates user tap via Android Accessibility Service
- Runs in background
- Toggle Start/Stop from UI
- Clean & simple Kotlin-based implementation

---

## Project Structure

```bash
app/src/main/
 ├─ java/com/example/skipper/
 │   ├─ MainActivity.kt               # UI toggle + permissions
 │   └─ SkipAdService/                # Folder for service files
 │        └─ SkipAdService.kt         # Accessibility service logic
 └─ AndroidManifest.xml               # Declares accessibility service
```
---

## 🛠 Tech Stack

- **Kotlin**
- **Android Accessibility Service**
- Android Studio
- Gradle Build System

---

## 🚀 Getting Started

### Requirements
- Android Studio installed
- Android device or emulator with Accessibility Services enabled

### Run Locally
1. Clone the repo
2. Open in Android Studio
3. Build & run the project on a device
4. Enable Accessibility permission for the app in device settings

---

## ⚠️ Legal & Ethical Notes

This app **does not remove ads** — it only clicks visible UI elements.  
However:

- Some platforms may consider automated ad-skipping a violation of terms
- Do not publish this on Google Play
- Use responsibly & at your own risk

This project is intended **only for learning automation & accessibility APIs**.

---

## 📖 About Me

Self-taught developer exploring automation, UX, and Android Accessibility services.  
Building practical tools to improve everyday workflows and learn system-level programming.

---

## ⭐ Future Ideas

- Configurable UI target detection
- Screen OCR trigger instead of text-match
- Multi-app support
- On-device ML model for UI element recognition

---

## 📬 Feedback / Contact

If you have feedback or learning suggestions, feel free to open an issue or message me!

---
