# Generative AI - Use Case #7

![GitHub Actions Status](https://github.com/username/repository/workflows/CI/badge.svg) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gabrielguimaraes_generative-ai-case-07&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=gabrielguimaraes_generative-ai-case-07) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gabrielguimaraes_generative-ai-case-07&metric=coverage)](https://sonarcloud.io/summary/new_code?id=gabrielguimaraes_generative-ai-case-07)

## Introduction

The "Generative AI - Use Case #7" project aims to significantly boost the quality and safety of Java applications by implementing a rigorous unit testing framework. Built on JUnit 5, our extensive unit tests cover individual methods and functions for entities like `Student` and `Player`, making sure the code is resilient and reliable.

Each test suite contains subsets such as "Positive Tests," "Negative Tests," and "Corner Cases," providing comprehensive coverage of the code's behavior under diverse conditions. The common configurations executed before and after each test within a suite make certain that our testing environment is isolated and clean. This guarantees both effective and efficient testing.

## Prerequisites

- Java JDK 17 (Corretto)
- Maven
- Git

### Java Installation

#### For macOS and Linux:
You can download and install [Amazon Corretto JDK 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html) and then set it up.
```shell
$ tar -xzf corretto-17.x.x.x-linux-x64.tar.gz
$ sudo mv jdk-17.x.x /usr/lib/jvm
$ export PATH=$PATH:/usr/lib/jvm/jdk-17.x.x/bin
```

#### For Windows:
Download [Amazon Corretto JDK 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html) and run the installer.

## Clone the Repository

To clone the repository, use the following git command:
```shell
$ git clone https://github.com/gabrielguimaraes/generative-ai-case-07.git
```

## How to Build and Run Tests

Navigate to the project directory:
```shell
$ cd generative-ai-case-07
```

### Build the Project

For all operating systems:
```shell
$ ./mvnw clean install
```

### Run Tests

For all operating systems, you can run the unit tests using the Maven Wrapper like so:
```shell
$ ./mvnw clean test
```

## Generate and View JaCoCo Reports

JaCoCo is used for checking code coverage of the project's tests. To generate a JaCoCo report, navigate to the project directory:

```shell
$ cd generative-ai-case-07
```

Run the following command to generate the JaCoCo code coverage report:

```shell
$ ./mvnw clean verify
```

This will create a report in `target/site/jacoco/index.html`. To view the report, open the `index.html` file with a web browser:

```shell
$ open target/site/jacoco/index.html
```

> Note: The `open` command works on macOS and some Linux distributions. On Windows, you can navigate to the directory and double-click `index.html` to open it, or use your preferred command to open files.

This report will give you detailed information about code coverage, which can help you identify areas of the code that may not be adequately tested.