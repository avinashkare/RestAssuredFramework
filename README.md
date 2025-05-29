
# 🚀 RestAssured API Automation Framework

A robust, scalable REST API test automation framework built with **Java**, **RestAssured**, and **TestNG**, using modern design principles like **Service Object Model (SOM)** and **Builder Pattern**, with fully integrated **Allure reporting**, **log capturing**, and **CI/CD via GitHub Actions**.

---

## 📂 Project Structure

```
RestAssuredFramework/
├── src/
│   ├── main/java/ie/api/filters         # Custom RestAssured request/response filters
│   ├── main/java/ie/api/listeners       # Allure + TestNG listeners (e.g., log attachment)
│   ├── main/java/ie/api/models          # POJOs for request/response with builder support
│   └── main/java/ie/api/services        # SOM classes (API clients)
├── src/test/java/ie/api/tests           # TestNG-based test classes
├── logs/test.log                        # Centralized Log4j2 execution log
├── suite.xml                            # TestNG suite file
├── pom.xml                              # Maven dependencies and plugin config
└── .github/workflows/maven.yml          # GitHub Actions CI pipeline
```

---

## 🔧 Core Features

### ✅ 1. **Service Object Model (SOM)**
- Abstracts API endpoints into reusable classes under `services/`
- Keeps test methods readable and logic separated

### ✅ 2. **Builder Pattern for Payloads**
- Models in `models/` follow the builder pattern for payload creation
- Ensures readable and maintainable request construction

```java
LoginRequest body = LoginRequest.builder()
    .username("john2007")
    .password("john2007")
    .build();
```

### ✅ 3. **Log4j2 Centralized Logging**
- All requests, responses, and test events logged to `logs/test.log`
- Implemented via `TestListeners` and custom `LoggingFilter`

### ✅ 4. **Custom Filters**
- Filters log base URI, headers, request/response body
- Implemented in `ie.api.filters.LoggingFilter`

### ✅ 5. **TestNG Listeners**
- `AllureLogListener` attaches execution log to Allure report
- `TestListeners` log test method start/end with descriptions

### ✅ 6. **Allure Reports Integration**
- Automatically generated after test runs
- Includes:
  - Test steps
  - Request & response logs (via filters)
  - Attached `test.log`

```bash
mvn clean test -Dsuite=suite
allure serve target/allure-results
```

---

## ✅ CI/CD with GitHub Actions

GitHub Actions pipeline (`.github/workflows/maven.yml`) includes:

- ✅ JDK setup
- ✅ Maven test run
- ✅ Upload of:
  - 🧪 TestNG JUnit-style reports
  - 📄 Allure results (with log attachment)
  - 📦 Logs directory

---

## 📄 Reporting

### 🧪 TestNG Reports
- Generated under:
  - `target/surefire-reports/`
  - `test-output/emailable-report.html`

### 🧬 Allure Reports
- View command:
  ```bash
  allure serve target/allure-results
  ```
- Includes:
  - Each test case as an Allure step
  - Attached execution log from `logs/test.log`
  - Clean visual breakdown

---

## 🧪 Running Tests

```bash
mvn clean test -Dsuite=suite
```

> Make sure `suite.xml` points to the correct class names and listeners are registered.

---

## 📦 Build with Maven

```bash
mvn clean install
```

---

## 👥 Contributing

- Follow clean code and modular practices
- Prefer builder pattern over raw POJOs
- Abstract endpoints and reusables into `services/`

---

## 🧾 License

MIT – feel free to fork and improve!

---

## 🙌 Acknowledgments

Special thanks to contributors and those helping maintain long-term test frameworks for APIs at scale 🚀
