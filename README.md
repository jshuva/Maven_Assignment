# MavenAssingment

**Course:** MCDA 5512 – Current Practise in Computer & Data Science  
**Assignment:** Maven Assignment  
**Student:** ASUS ROG STRIX  
**Due Date:** 8th March 2026

---

## Overview

This project demonstrates the fundamentals of **Apache Maven** — a powerful build automation and dependency management tool widely used in Java development. Maven follows the **Convention over Configuration** principle, using a standard project layout and a `pom.xml` descriptor to manage builds, dependencies, plugins, and packaging.

The application accepts a **lowercase string** from the user, capitalizes it, and outputs its **MD5 hex digest** — showcasing how Maven pulls third-party libraries from Maven Central and bundles them into a deployable JAR.

### What This Project Demonstrates
- Creating a Maven project from scratch with a custom `groupId` and `artifactId`
- Declaring external **dependencies** in `pom.xml` (Apache Commons Lang3 + Apache Commons Codec)
- Building with `mvn clean package` and producing both a plain JAR and a **fat/shaded JAR**
- Writing **JUnit 5 unit tests** that Maven runs automatically during the build
- Using the **maven-shade-plugin** to create a self-contained executable JAR

### Expected Program Output
```
This program will capitalize the input string and generate hex hex!
Enter a string: smu
Capitalized string is: Smu
MD5 Hex is: 3773300c2f413cc7136f8d74b305519c
```

---

## Project Details

| Field        | Value              |
|--------------|--------------------|
| groupId      | `com.smu.mscda`    |
| artifactId   | `MavenAssingment`  |
| version      | `3.11.8`           |
| Java version | 21 (LTS)           |
| Maven version| 3.9.6+             |

---

## Project Structure

```
MavenAssingment/
├── pom.xml                          ← Maven build descriptor
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   └── java/
    │       └── com/smu/mscda/
    │           └── App.java         ← Main application
    └── test/
        └── java/
            └── com/smu/mscda/
                └── AppTest.java     ← JUnit 5 unit tests
```

---

## Dependencies

| Library | Version | Scope | Purpose |
|---------|---------|-------|---------|
| `org.apache.commons:commons-lang3` | 3.14.0 | compile | `StringUtils.capitalize()` — first-letter capitalization |
| `commons-codec:commons-codec` | 1.17.0 | compile | `DigestUtils.md5Hex()` — MD5 hash generation |
| `org.junit.jupiter:junit-jupiter` | 5.11.0 | test | JUnit 5 unit testing framework |

Maven downloads all dependencies automatically from **Maven Central** on the first build.

---

## Prerequisites

- **Java JDK 21+** — [Download from Oracle](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven 3.9.6+** — [Download from Apache](https://maven.apache.org/download.cgi)

Verify installations:
```bash
java -version
mvn -version
```

---

## Build

```bash
mvn clean package
```

This command:
1. **Cleans** the `target/` directory
2. **Compiles** `App.java` and `AppTest.java`
3. **Runs** all JUnit tests (fails the build if any test fails)
4. **Packages** two JARs in `target/`:
   - `MavenAssingment-3.11.8.jar` — standard JAR (dependencies not included)
   - `MavenAssingment-3.11.8-shaded.jar` — fat/uber JAR with all dependencies bundled *(Bonus)*

---

## Running Tests

Maven runs tests automatically during `mvn clean package`. To run tests only:
```bash
mvn test
```

### Test Coverage (`AppTest.java`)
| Test | Description |
|------|-------------|
| `testCapitalize_smu` | Verifies `"smu"` → `"Smu"` |
| `testCapitalize_multiWord` | Verifies first-char-only behaviour with multi-word input |
| `testCapitalize_empty` | Verifies empty string returns empty |
| `testMd5Hex_smu` | Verifies MD5 of `"smu"` matches reference `3773300c2f413cc7136f8d74b305519c` |
| `testMd5Hex_caseSensitive` | Verifies `"smu"` and `"Smu"` produce different hashes |
| `testMd5Hex_length` | Verifies MD5 hex output is always 32 characters |

---

## Run the Application

### Shaded JAR (Bonus — self-contained, no classpath setup needed)
```bash
java -jar target/MavenAssingment-3.11.8-shaded.jar
```

Type your lowercase string when prompted, then press Enter.

### Example Session
```
This program will capitalize the input string and generate hex hex!
Enter a string: smu
Capitalized string is: Smu
MD5 Hex is: 3773300c2f413cc7136f8d74b305519c
```

---

## Bonus — maven-shade-plugin

The `maven-shade-plugin` (configured in `pom.xml`) bundles the application and all its dependencies into a single executable JAR, making distribution and execution simple:

```bash
java -jar target/MavenAssingment-3.11.8-shaded.jar
```

No classpath setup required — everything is self-contained in one file.

---

## Submission Checklist

| # | Requirement | Status |
|---|-------------|--------|
| 1 | GitHub repository link | ✅ (see repo URL above) |
| 2 | Source code ZIP file | ✅ Submit `MavenAssingment.zip` |
| 3 | Screenshot: `mvn clean package` → BUILD SUCCESS | ✅ See screenshots folder |
| 4 | Screenshot: JUnit test results (all 6 tests passing) | ✅ See screenshots folder |
| 5 | Screenshot: Program execution output | ✅ See screenshots folder |
| 6 | Screenshot: Bonus shaded JAR execution | ✅ See screenshots folder |

---

## Build Results

```
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] Total time:  7.376 s
[INFO] Finished at: 2026-03-04T19:29:53-04:00
```

### Confirmed Program Execution Output
```
This program will capitalize the input string and generate hex hex!
Enter a string: smu
Capitalized string is: Smu
MD5 Hex is: 3773300c2f413cc7136f8d74b305519c
```

### JARs Produced
| JAR | Description |
|-----|-------------|
| `target/MavenAssingment-3.11.8.jar` | Standard JAR (dependencies separate) |
| `target/MavenAssingment-3.11.8-shaded.jar` | Uber/fat JAR — fully self-contained ✅ Bonus |

---

## Summary

- ✅ `mvn clean package` → **BUILD SUCCESS**
- ✅ All **6 JUnit 5 tests** pass (`Failures: 0, Errors: 0`)
- ✅ Shaded JAR executes and produces correct output
- ✅ MD5 of `"smu"` → `3773300c2f413cc7136f8d74b305519c`

