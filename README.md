# Homeforus
SER322 HomeforUS<br />

rdbm.properties located at /src/main/resources<br /> 
Update with username and password for database.<br />

No Gradle installed:<br />

Windows<br />
gradlew.bat clean<br />
gradlew.bat build<br />
gradlew.bat run<br />

Linux<br />
gradlew clean<br />
gradlew build<br />
gradlew run<br />

Gradle Installed:<br />
gradle clean<br />
gradle build<br />
gradle run<br />

Prepare Database
java Main -DPrepareDatabase=/PathtoImages

=====================================================================

HomeForUs is an application for realtors and consumers to streamline the home buying process.

There are two different types of users: Consumers and Realtors, one is focused on buying a house
(consumer) while the other is focused on selling a house. 

A user can log in to HomeForUs and according to the type of user, will have certain permissions

Consumers have the ability to search for homes based on certain attributes such as
the number of bedrooms and bathrooms, the number of floors, square footage, the cost, the location.
The consumer can query the database to find houses according to these attributes. 
Realtors are able to list these homes and display their attributes as well as consider the applicaations 
of consumers that are intereseted in purchasing the homes.

Once a consumer has logged into the system they can query the database according to certain fields: city, state,
address, city, state, zip code, price, number of beds/baths, square footage, days listed, year built, or  number of floors

When a consumer is interested in a home, they can put in an appplication to purchase the home which will 
be considered by a user of the realtor type. 

A realtor has the ability to list a home for consideration by a consumer and then consider consumer applications to purchase.

Only realtors can add/delete house listings to the database by interfacing with applications which are added to the database 
by consumers. 

This application is similar in many aspects to many online realtor platforms that we see in today's marketplace.