# TomatoJam

# Before running tests:
Make sure that browser drivers are set in the system properties 
* Download *chrome* or *firefox* driver
* Unzip it in any folder 
* For Windows: 
  * Type *advanced system settings* in the search box (beside the Windows start button), clicks View advanced system settings.
  * Select *Advance tab*, clicks *Environment Variables*
  * In System variables, find PATH, clicks edit and append path to the folder with drivers to the end.
  * Click OK

# How to run the tests in the terminal: 
1. Go to the project folder
2. `mvn clean test -Dsurefire.suiteXmlFiles=testsSuite.xml` to run the test
Additional parameters: 
* run tests in a specific browser(chrome is default): `-Dbrowser=chrome firefox`
