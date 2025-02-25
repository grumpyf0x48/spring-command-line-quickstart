# spring-command-line-quickstart

[![Build](https://github.com/grumpyf0x48/spring-command-line-quickstart/actions/workflows/build.yml/badge.svg)](https://github.com/grumpyf0x48/spring-command-line-quickstart/actions/workflows/build.yml)
[![Build](https://github.com/grumpyf0x48/spring-command-line-quickstart/actions/workflows/native_build.yml/badge.svg)](https://github.com/grumpyf0x48/spring-command-line-quickstart/actions/workflows/native_build.yml)

**spring-command-line-quickstart** is a template repository to bootstrap a new Java command line application using:

- Java 21
- Spring Boot
- Lombok to ease dependencies injection
- Gradle 8 with Kotlin DSL for build
- Maven Central for dependencies
- Picocli for command line arguments parsing
- Picocli Code Generation for Bash completion script generation
- JUnit 5 and Mockito for tests
- GitHub workflow for running tests and uploading artifacts
- EditorConfig for code formatting
- Renovate for dependencies update

## Run application

```shell
./gradlew run "--args=--help"

> Task :run
Usage: Command [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```

```shell
./build/native/nativeCompile/spring_command_line_quickstart --help
Usage: Command [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```
