# Demo project of the [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/) website parametrized tests
 
This repository contains a suite of parameterized tests written in Java using JUnit 5, Selenide, and Selenoid. These tests aim to validate various elements on the [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/) website, including the main page title, login button, and top menu options, for multiple languages.


## Table of Contents
- [CSV File Search Test](#csv-test)
- [Enum Source Test](#enum-test)
- [Method Source Test](#method-test)
- [How to Run](#run)

---

### CSV File Search Test <a id="csv-test"></a>

This test uses a CSV file as a data source to parameterize test cases, checking the main page title, login button text, and top menu options for different languages.

### Enum Source Test <a id="enum-test"></a>

An enum (`Language`) is used as a source for parameterization, verifying the correct selection of languages on the website and checking the title and login button.

### Method Source Test <a id="method-test"></a>

This test uses a method as a source to provide a stream of language-menu option combinations, ensuring that the top menu displays the expected buttons for each language. It also checks the main page title and login button.

<br>

> These tests follow a parameterized testing approach, enabling the validation of various website elements in multiple languages, making the test suite flexible and easily extensible.

<br>

---

## Running Tests <a id="run"></a>

To execute tests on Selenoid, use the following command:

```bash
./gradlew clean test -Dhost=remote
```

<br>

To run tests locally, use the following command:

```bash
./gradlew clean test -Dhost=local
```
