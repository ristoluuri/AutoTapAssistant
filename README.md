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

app/src/main/
```bash
src/
├─ java/com/example/skipper/
│ ├─ MainActivity.kt # UI toggle + permissions
│ └─ SkipAdService.kt # Accessibility service logic
└─ AndroidManifest.xml # Declares accessibility service
```
