# DevOps On the Go

This project is a simple web application that demonstrates a basic DevOps workflow using Spring Boot, Docker, and GitHub Actions.

## Features

* **Spring Boot application:** A basic Spring Boot application that serves a single web page.
* **Dockerization:** The application is Dockerized for easy deployment.
* **CI/CD with GitHub Actions:** A GitHub Actions workflow is set up to automate the build, test, and deployment process.

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 21
* Maven

### Build and run

1.  Clone the repository:

    ```bash
    git clone https://github.com/automation-craftsman/devops-on-the-go.git
    ```

2.  Navigate to the project directory:

    ```bash
    cd devops-on-the-go
    ```

3.  Build the project:

    ```bash
    mvn clean package
    ```

4.  Run the application:

    ```bash
    java -jar target/app.jar
    ```

5.  Access the application in your web browser at `http://localhost:8081`.

## CI/CD with GitHub Actions

The GitHub Actions workflow is configured in `.github/workflows/ci.yml`. It automatically runs the following steps on every push to the `feature/*` branches:

* Checks out the code
* Sets up the Java environment
* Runs the linter
* Runs the code quality check
* Runs the unit tests
* Merges the code into the `dev` branch if all checks pass

## Contributing

Contributions are welcome! Please feel free to submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.