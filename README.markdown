# finatra_example

Finatra requires either [maven](http://maven.apache.org/) or [sbt](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html) to build and run your app.

## SBT Instructions

### Runs your app on port 7070

    sbt run

### Testing

    sbt test

### Packaging (fatjar)

    sbt assembly


## Maven Instructions

### Runs your app on port 7070

    mvn scala:run

### Testing

    mvn test

### Packaging (fatjar)

    mvn package


## Heroku

### To put on heroku

    heroku create
    git push heroku master

### To run anywhere else

    java -jar target/*-0.0.1-SNAPSHOT-jar-with-dependencies.jar

	
## API USAGE 

	This tutorial aims to a quick introduction about the data model that this API is exposing.
	
## Board

This is the less granular entity on the model. Everything starts by here. Teams have boards, and there them put their information. The model let you fetch back information from boards like this:
	http://[serverName]:[port]/api/v1/teams/boards - Returns back all boards available on the system.
	http://[serverName]:[port]/api/v1/teams/boards/1 - Returns back information about an specific board
	http://[serverName]:[port]/api/v1/teams/boards/1/cards?startDate=01-Feb-2014&endDate=08-Feb-2014  - Returns back all cards that have startDate and endDate between the given date interval. If no date interval is provided, a default interval is assumed. The default interval is one week (7 days) behind the current date.
	
## QUEUES
It is how boards are organized. One board can has several queues. Teams user stories will pass through them. Here are some examples:
	http://[serverName]:[port]/api/v1/teams/boards/1/queues - Returns back all queues inside a given board
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1 - Returns back all cards inside a given queue
	
## CARDS
This is the most granular unit on the model. A cards is the small unit of work from an agile team. Cards will pass through queues. Here are some examples
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1/cards - Returns back all cards inside a queue in a given board
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1/cards/1 - Returns back detailed information from a specific card
	