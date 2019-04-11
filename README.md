# Web UI Automation

This project includes 3 tests for  [https://www.check24.de/](https://www.check24.de/).

The technology stack that is used:
* Selenium Webdriver
 * JAVA
 * Maven 
 * Extent Reports

### Prerequisites

In order to use these tests you need to install following software:


* [Maven](https://maven.apache.org/)
* [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK)


### Installing

After cloning the project from Githab, you can either build it in your IDE (IntelliJ IDEA or Eclipse) or just go to the project folder and type in command line "mvn clean install".

## Parameters
At the catalogue **\src\test\resources** you can find **selenium.properties** file where you can specify base URL of the project, reports folder and browser where the test is executed. 

## Running the tests

You can execute tests either in IDE or just go to the project folder and type in command line "mvn test"  


## Results and reports

After every execution a folder named with timestamp is created where you can find HTML reports along with some statistics and with screenshots in cases of failed tests. 

## Tests

The following assumptions and simplifications have been made due to the lack of time and limited task::
* Menu at the right top corner is out of scope. It can be tested by separate cases because all necessary pages can be reached by separate URLs.
* Only three tests are required according to the QA Challenge description. At the same time 'registration page validation' is in scope. That is why simple example of validation was added to the test with successful registration.
* Deleting of test account has been added after login test in order to avoid creation a new account every tests run.
* Testing of Main page is out of scope - Travel section is reachable from Login page. Because the words "Selecting the 'Travel' section" is in the task description, Travel section is not got by URL directly, but is selected from Login page.


### Tests Descriptions

###### registerTest

This test opens Registration page, execute simple validation of text boxes, then fill them by valid data and register a new user. 

Checkings:
* Red border of text boxes and error messages next to them when email is invalid, password is short, repeated password does not match entered.
* Account page opens after successful registration.
* Message about successful registration is displayed.

###### loginSuccessDeleteAccountTest
runs only after successful finish of registerTest.

This test opens Login page, logs in as the user created during previous test, opens Personal Data page and deletes this account. 

Checkings:
* Account page opens after successful logging in.
* Message about successful logging in is displayed.
* Message about successful removing account is displayed.


###### searchTravelTest

This test opens Login page, clicks 'Travel' section link, fill Search form and performs search. 

Checkings:
* Travel page opens after click to the link.
* Results page opens after successful search.
* At least 1 result item is displayed.

## Author

 **Alexander Ognev** 

