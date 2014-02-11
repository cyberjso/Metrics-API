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
	
	http://localhost:7070/api/v1/teams/boards - Returns back all boards available on the system.
	