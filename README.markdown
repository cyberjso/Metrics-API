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
	
## Boards

This is the less granular entity on the model. Everything starts by here. Teams have boards where they organize their work. Here are some request examples:

	http://[serverName]:[port]/api/v1/teams/boards - Returns back all boards available on the system.
	http://[serverName]:[port]/api/v1/teams/boards/1 - Returns back information about a specific board
	
## Queues

They are used to organize the teams work. One board can has several queues. Teams user stories will pass through them. They basically represent the team workflow. Here are some request examples:

	http://[serverName]:[port]/api/v1/teams/boards/1/queues - Returns back all queues inside a given board
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1 - Returns back all cards inside a given queue
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1?from=01-Feb-2014&to=08-Feb-2014 -  Returns back all cards inside a given queue that were on the queue between the date interval
	
## Cards

This is the most granular unit on the model. One cards represent a unit of work in a queue. Cards will pass through queues, once they are the team workflow. Here are some request examples:

	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1/cards - Returns back all cards inside a queue in a given board
	http://[serverName]:[port]/api/v1/teams/boards/1/queues/1/cards/1 - Returns back detailed information from a specific card
	