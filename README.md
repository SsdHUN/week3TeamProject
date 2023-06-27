# AUTOMATED TESTING OF JIRA WEB APPLICATION

As a part of my professional journey, I had the opportunity to perform automated testing of the Jira web application using Java, Selenium, and Jenkins. This task involved ensuring the accuracy and reliability of critical functionalities, including login, registration, issue creation, issue browsing, issue editing.

## Technologies Used

- Java: The programming language used for implementing the test automation framework.
- Selenium: A powerful tool for automating web browsers, used to interact with the Jira web application.
- Jenkins: A popular continuous integration tool used for automating the build and testing processes.

## Dependencies

The following dependencies are required and can be added to the `pom.xml` file in your project:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>VERSION</version>
    </dependency>
    <!-- Add other dependencies here -->
</dependencies>
```

Please replace VERSION with your desired Selenium version which is 4.8.1 or later

## Getting Started

To get started with this automated testing framework, follow these steps:

1. Clone the repository: `https://github.dev/SsdHUN/week3TeamProject`
2. Set up the necessary dependencies by updating the `pom.xml` file with the required dependencies.
3. Create an initialization file (e.g., `init.properties`) in the root of the project with the following properties:

   ```properties
   base_URL=https://jira-auto.codecool.metastage.net/
   username=your-username
   password=your-password
   ```

   Replace the username and password with a valid username and password.

4. Build and run the tests using your preferred Java development environment or command-line tools.
