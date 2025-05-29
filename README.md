
# RestAssured API Automation Framework ✨

Welcome to the **RestAssured API Automation Framework** — a scalable, extensible, and clean architecture for testing REST APIs using Java, TestNG, Maven, and industry-level patterns. This framework is optimized for both local and CI-based executions.

---

## 🔎 Highlights

- ✅ Built with **Java 17** and **TestNG**
- ⚖️ Uses **Service Object Model (SOM)** to modularize API endpoints
- 🔊 **Log4j2 logging** for all test and framework events
- ⚠️ **Request/Response filtering** for transparent debugging
- ⚙️ **Custom listeners** for lifecycle hooks and Allure integration
- 🌍 Fully functional **GitHub Actions CI** pipeline
- 📊 Includes **TestNG Reports** and **Allure Reports**
- 📂 Uploads **log files** and reports as CI artifacts

---

## 🛠️ Technologies & Tools

| Layer | Tools / Patterns |
|------|------------------|
| Language | Java 17 |
| Test Framework | TestNG |
| HTTP Client | Rest-Assured |
| Build Tool | Maven |
| Reporting | Allure, TestNG XML + JUnit format |
| Logging | Log4j2 |
| CI/CD | GitHub Actions |

---

## 🚀 Project Structure Overview

```
RestAssuredFramework
├── src
│   ├── main
│   │   └── java
│   │       └── ie.api
│   │           ├── filters       # Request/Response Filters
│   │           ├── listeners     # Log attachment, Allure integration
│   │           ├── models        # Request/Response model classes
│   │           ├── services      # SOM: Service Layer for APIs
│   │           ├── utils         # Common utilities
│   └── test
│       └── java
│           └── ie.api.tests      # TestNG test classes
├── logs
│   └── test.log                  # Log4j2 log output
├── target
│   ├── allure-results            # Allure raw data
│   └── allure-report             # Generated HTML report
├── suite.xml                     # TestNG suite config
├── pom.xml                       # Maven dependencies
└── .github/workflows             # GitHub Actions CI/CD YAML
```

---

## 🔧 Key Components

### 1. 📌 Service Object Model (SOM)

Each API is abstracted into a **Service class** (like `LoginService`) that exposes well-named methods to send requests and parse responses. This makes the tests readable and decoupled from endpoint logic.

```java
public class LoginService {
    public Response login(String username, String password) {
        return given()
                .spec(requestSpec())
                .body(new LoginRequest(username, password))
                .post("/api/auth/signin");
    }
}
```

### 2. 🔊 Log4j2 Logging

All framework events, payloads, and HTTP transactions are logged to `logs/test.log`. Logger is initialized using:

```java
private static final Logger logger = LogManager.getLogger(SomeClass.class);
```

### 3. 🔠 Filters (Rest-Assured)

Custom filters log all requests/responses automatically:
```java
RequestLoggingFilter.requestLogger(logger);
ResponseLoggingFilter.responseLogger(logger);
```

### 4. 🔍 Models + Builder Pattern

- Request/Response bodies are modeled using POJOs
- Builder pattern helps construct complex payloads fluently:

```java
LoginRequest.builder()
    .username("john")
    .password("pass")
    .build();
```

### 5. ⚖️ Listeners

- Custom TestNG listeners like `TestListeners` and `AllureLogListener`
- Hooks into `onTestSuccess`, `onTestFailure`, and `onExecutionFinish`
- Dynamically attaches `logs/test.log` as Allure attachment using:

```java
Allure.addAttachment("Execution Log", new FileInputStream("logs/test.log"));
```

---

## 📊 Reporting

### ✅ TestNG XML Reports

- JUnit-style reports generated in `target/surefire-reports/junitreports`
- Integrated with GitHub Actions using:
```yaml
- name: Publish Test Report
  uses: dorny/test-reporter@v1
```

### 🌟 Allure Reports

- Allure results collected in `target/allure-results`
- Report generated and uploaded via GitHub Actions:
```yaml
- run: allure generate target/allure-results --clean -o target/allure-report
- uses: actions/upload-artifact@v4.6.2
```
- **Execution log is viewable inside the Allure report as an attachment**

---

## ♻️ CI/CD: GitHub Actions

### Pipeline Features:
- Maven build and test execution
- Log file upload (`logs/test.log`)
- TestNG results publishing
- Allure report generation and artifact upload

**No GitHub token or secrets needed.**

---

## ⚡ How to Run

```bash
mvn clean test -Dsuite=suite
allure serve target/allure-results
```

Or just push to `main` branch — GitHub Actions will do the rest 🚀

---

## 🔹 Future Enhancements
- [ ] Add test coverage reports
- [ ] Include Swagger validation
- [ ] Dockerized execution
- [ ] Auto email/slack reporting
- [ ] Test data injection via Excel/JSON/YAML

---

## 🎉 Maintainer
Built with ❤️ by [Your Name] for scalable, industry-level API testing.

---

Need enhancements, help with CI integration, or cross-browser execution? Open an issue or ping the maintainer.
