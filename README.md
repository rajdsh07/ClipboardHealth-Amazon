# ClipboardHealth-Amazon

This project uses Selenium WebDriver with TestNG framework and written in Java. The purpose of the project is to find second highest priced SAMSUNG television from Amazon E-commerce. As part of this assignment, I have completed all the steps(1-9) which were mentioned. I tried to complete major portion of the checklist but not able to fulfill things like page layer management due to time constraint. I have not used sendKeys and Keys because I believe we should only use these features when we are typing something and then using "ENTER" key to find results. Apart from that I have used Maven dependencies to streamline automation tests. Also, I have added one interesting feature which moves mouse cursor to corner so, it would not disturb testers executing test run. 

Prerequisites:
  >=JDK8 installed
  >=TestNG

Features:
  >Usage of Maven repository
  >Chrome browser configured
  >WebDriverManager configured
  >TestNG annotations & reports
  >Different Wait time utilized
  >Click events
  >Java Robot to disappear mouse
  >Selenium Grid provision
  >Readable console output
  >JavaScriptExecutor configured
  >Select
  >Switch tabs
  >Windows management


Selenium Grid:
>Start the HUB:
java -jar selenium-server-4.2.2.jar hub

>Node in same machine:
java -jar selenium-server-4.2.2.jar node --detect-drivers true

>Node in different machine:
java -"Dwebdriver.chrome.driver"="C:/Users/Admin/eclipse-workspace/ClipboardHealth/chromedriver.exe" -jar selenium-server-4.2.2.jar node -hub http://10.89.67.22:4444/grid/register

Maintenance:
  >Check for selenium-server updates

