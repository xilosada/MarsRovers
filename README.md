# MarsRovers

[![Build Status](https://travis-ci.org/xilosada/MarsRovers.svg?branch=develop)](https://travis-ci.org/xilosada/MarsRovers)

## How to Run 
  
### Running application

This application is packaged as a war which has Tomcat 7 embedded. No Tomcat or JBoss installation is necessary

1. Clone this repository 
2. Make sure you are using JDK 1.8 and Maven 3.0+
3. You can build the project and run the tests by running ```mvn clean package```
4. Once successfully built, you can run the application by running

  ```
     java -jar mars-rovers-0.1.jar {path_file}
  ```