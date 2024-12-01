
# Mobile Test Automation Project

This project is a web test automation framework built using **Page Object Model (POM)**,  **Selenium**, **TestNG**, and integrated with **Allure** for reporting. 
## Project Summary  

This project demonstrates how to use the **Page Object Model (POM)** to build a scalable test automation framework. 

The `RegressionSuite.xml` file is designed to be easily integrated with CI tools, enabling seamless automation workflows.  

Additionally, one test is intentionally designed to fail, showcasing how **Allure Reporting** effectively represents failures with screenshots. Allure Reports provide clear and client-friendly results, making it easier to share insights and outcomes.


## Prerequisites

Ensure the following are installed on your system:

1. **Java JDK 11 or higher**: Download and install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).
2. **Maven 3.6 or higher**:
   - Check if Maven is installed:
     ```bash
     mvn -v
     ```
   - If not installed, follow the [Maven installation guide](https://maven.apache.org/install.html).
3. **Allure**:
   - Install Allure command-line tool:
     ```bash
     npm install -g allure-commandline --save-dev  # Windows
     ```

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone [https://github.com/jveljanoski/jovica-mobile-project.git](https://github.com/jveljanoski/jovica-web-project.git)
   cd jovica-web-project
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

## Running Tests

To execute all tests in the regression suite, use the following command (example):

```bash
mvn test -DsuiteXmlFile="C:\Users\your_account\Documents\Automation\jovica-web-project\src\Regression.xml"
```

After running the tests, you can generate and open the Allure report to view the results. Follow these steps:

**Navigate to the project directory**  
   Open a terminal or command prompt and go to the project directory (example):
```bash
   cd C:\Users\your_account\Documents\Automation\jovica-web-project
```
   

## Tasks 
- I used prompts like: "Improve text for step 1" (as an example).
- GPT definitely helps in writing manual tests faster.
- All test cases can be automated (depending on the project requirements).



and `src/test/java/com/companyname/app/utils/AppiumDriver.java` update the the values as per your environment

- **NodeExePath**: Your system nodejs path 
- **AppiumPath**: Your system appium path
- **ANDROID_HOME**: Your system sdk path
- **JAVA_HOME**: Your system java path
