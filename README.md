# intercom-test
This README outlines the details of spring boot application.

## Technical Problem :
We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

You must use the first formula from this Wikipedia article to calculate distance. Don't forget, you'll need to convert degrees to radians.

The GPS coordinates for our Dublin office are 53.339428, -6.257664.

You can find the Customer list here. (https://s3.amazonaws.com/intercom-take-home-test/customers.txt)

## Languages/Framework used:
* Java 8
* Spring 5.0.6
* Spring boot 2.0.2
* Maven 3.2
* Junit 4.12

## Installation required to run the application:
1. Java 8
2. Maven
3. Git(to clone the repo)


## Steps to run the application:
1. Clone the git repository in your local and run below commands to build and run tests :

   1.``` mvn clean install ```
   2. Run as->Spring boot app
   
2. Url to hit the application : http://localhost:8080/intercom-web/getCustomerData

