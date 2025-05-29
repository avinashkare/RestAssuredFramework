# 🧪 RestAssured API Automation Framework

This is a comprehensive and scalable **REST API Automation Framework** built using **Java + RestAssured + TestNG**. It follows modern software engineering practices like the **Service Object Model (SOM)**, **Builder pattern**, and integrates with **Allure Reports**, **Log4j2**, and **GitHub Actions CI/CD**.

---

## 📁 Project Structure (Real View)

```
RestAssuredFramework/
├── src/
│   ├── main/java/
│   │   ├── ie/api/filters/              # ➤ LoggingFilter.java (custom request/response logger)
│   │   └── utils/                       # ➤ Utility classes (e.g., token extractors)
│
│   └── test/java/
│       ├── ie/api/base/                # ➤ Service Object Model (SOM) classes
│       ├── ie/api/listeners/           # ➤ Log4j and Allure listeners
│       ├── ie/api/models/request/      # ➤ Request POJOs with Builder pattern
│       ├── ie/api/models/response/     # ➤ Response POJOs
│       └── ie/api/tests/               # ➤ TestNG test classes
│
├── logs/test.log                       # ➤ Central execution log (Log4j2)
├── suite.xml                           # ➤ TestNG suite file
├── pom.xml                             # ➤ Maven config
├── .github/workflows/maven.yml         # ➤ GitHub Actions CI pipeline
```

---

## 🔧 Key Features

### ✅ Service Object Model (SOM)
- Encapsulates service logic (like `AuthService`, `UserManagementService`) in reusable methods.
- Decouples test logic from API logic.

### ✅ POJOs + Builder Pattern
- Models for request/response (e.g., `LoginRequest`, `SignUpRequest`) use builder pattern for clean test code.

### ✅ Logging with Log4j2
- `log4j2.xml` under `resources` configures full request/response logging.
- Logs are written to `logs/test.log`.

### ✅ Filters
- `LoggingFilter.java` logs request URIs, payloads, and headers dynamically via RestAssured filters.

### ✅ Listeners
- `TestListeners.java` hooks into test lifecycle events.
- `AllureLogListener.java` auto-attaches `test.log` as an Allure report attachment.

### ✅ Allure Reporting
- Integrated using `io.qameta.allure:allure-testng`.
- Includes:
  - Test status
  - Steps and descriptions
  - Execution logs via attachment

### ✅ GitHub Actions CI
- `.github/workflows/maven.yml` automates:
  - Running tests on push/pull
  - Uploading logs
  - Publishing TestNG results

---

## 🚀 Usage

### Local Test Execution
```bash
mvn clean test -Dsuite=suite
```

### Generate Allure Report
```bash
allure generate target/allure-results --clean -o target/allure-report
allure serve target/allure-report
```

---

## 🧪 CI Output

- ✅ **TestNG HTML Reports**: Available under `target/surefire-reports`
- ✅ **Allure Reports**: Stored under `target/allure-report`
- ✅ **Logs**: Automatically attached in Allure UI

---

## 📌 Dependencies

- Java 17
- RestAssured 5.5.1
- TestNG 7.11.0
- Allure 2.24.0
- Log4j2 2.24.3
- Jackson (for JSON serialization)

---

## 🙌 Contributors

Developed and maintained by: `Avinash Kare`

---

