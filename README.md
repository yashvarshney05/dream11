This project is developed in serenity java using page object model.
For serenity you can refer-
https://serenity-bdd.github.io/theserenitybook/latest/index.html

Steps to setup-

unzip file
import project in IDE 
Navigate to directory where pom.xml is present
Run below command-
mvn clean install

To run test enter the below command in directory where pom.xml is present-
mvn clean verify -Dexecute.test=**/*/tests/*Test*

Report is generated under reports folder with index.html




