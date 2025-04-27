# Playwright Java Automation Project

## 📌 Project Overview
This is a **Test Automation Framework** built using **Playwright with Java**. It supports automated UI testing of web applications, leveraging **Maven** for dependency management and **TestNG** for test execution.

## 🛠️ Tech Stack
- **Programming Language**: Java 11+
- **Automation Framework**: Playwright
- **Build Tool**: Maven
- **Test Runner**: TestNG 

## 📂 Project Structure
```
project-root
│── src
│   ├── main/java (Main framework utilities)
│   ├── test/java (Test scripts)
│── pom.xml (Maven dependencies)
│── testng.xml (TestNG suite file)
│── README.md (Project documentation)
```

## 🚀 Getting Started

### 1️⃣ Prerequisites
- Install **JDK 11+** and set up `JAVA_HOME`
- Install **Maven**
- Install **Node.js** (required for Playwright browsers)
  ```sh
  npm install -g playwright
  ```

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/your-repo
```

### 3️⃣ Install Dependencies
```sh
mvn clean install
```

### 4️⃣ Run Tests
#### ✅ Using Maven
```sh
mvn test
```
#### ✅ Using TestNG
```sh
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```


#### **Extent Reports**
Check the `reports/` directory after execution.

## 🛠️ Configuration
### **Browser Configuration** (Modify in `config.properties`)
```
browser=chromium  # Options: chromium, firefox, webkit
headless=true     # Set false for UI mode
``

---
🚀 Happy Testing with **Playwright & Java**! 🎯

