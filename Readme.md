# Your Java Project Title

This project contains a set of unit tests written in Java using JUnit 5. The project uses Maven for dependency management and build automation.

## Prerequisites

- Git

## Steps to Run the Project

### Clone the Repository

First, clone this GitHub repository to your local machine.

```bash
git clone https://github.com/gabrielguimaraes/generative-ai-case-07.git
cd generative-ai-case-07
```

### Install Java 17 (Corretto JDK)

You'll need Java 17 to build and run this project. You can download Amazon Corretto JDK 17 from [here](https://aws.amazon.com/corretto/).

#### On Linux/Mac

You can set the `JAVA_HOME` environment variable for the current session as follows (replace `/path/to/amazon-corretto-17` with the actual path where you extracted or installed Corretto JDK):

```bash
export JAVA_HOME=/path/to/amazon-corretto-17
export PATH=$JAVA_HOME/bin:$PATH
```

#### On Windows

You can set the `JAVA_HOME` environment variable as follows:

```cmd
set JAVA_HOME=C:\\path\\to\\amazon-corretto-17
set PATH=%JAVA_HOME%\\bin;%PATH%
```

**Note:** Installing JDKs locally per project is not as straightforward as Maven or Node.js and usually involves manipulating `JAVA_HOME` as shown above.

### Run the Project Using Maven Wrapper

This project uses Maven Wrapper, so you don't need to install Maven on your machine. The following command should work on all operating systems.

#### On Linux/Mac:

```bash
./mvnw clean test
```

#### On Windows:

```cmd
mvnw.cmd clean test
```

This will clean the project, download all necessary dependencies, and execute the unit tests.
