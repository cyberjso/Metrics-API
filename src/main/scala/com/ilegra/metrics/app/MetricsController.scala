package com.ilegra.metrics.app

import java.net.URI
import java.util.Date
import com.ilegra.metrics.app.model.Board
import com.ilegra.metrics.app.model.Queue
import com.twitter.finatra.Controller
import com.ilegra.metrics.app.model.Card
import scala.collection.immutable.HashMap
import java.net.URL

class MetricsController extends Controller {
	val baseUrl = "/api/v1/teams/"
	val hostName = "http://localhost:7070"
	  
	get(baseUrl + "boards") { request =>
	  render.json(List(new URL(hostName + baseUrl + "boards/1"), 
			  		   new URL(hostName + baseUrl + "boards/2"), 
			  		   new URL(hostName + baseUrl + "boards/3"))).toFuture
	}
	
	get(baseUrl + "boards/:boardId") {request =>
	  	val boardId = request.routeParams.get("boardId").get
		render.json(Board(id = boardId, 
		    			  name = "Board Name", 
		    			  queues = List(new URI(hostName + baseUrl + "boards/" + boardId + "/queues/1"),
		    					  	    new URI(hostName + baseUrl + "boards/" + boardId + "/queues/2")))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues") {request =>
	  	val boardId = request.routeParams.get("boardId").get
		render.json(List(new URI(hostName + baseUrl + "boards/" + boardId + "/queues/1"),
						 new URI(hostName + baseUrl + "boards/" + boardId + "/queues/2"))).toFuture
	}

	get(baseUrl + "boards/:boardId/queues/:queueId") { request =>
	  val boardId = request.routeParams.get("boardId").get
	  val queueId = request.routeParams.get("queueId").get
	  render.json(Queue(id    = queueId, 
	      				name  = "Some Queue Name", 
	      				cards = List(new URI(hostName + baseUrl + "boards/" + boardId +  "/queues/" + queueId + "/cards/1"),
	      							 new URI(hostName + baseUrl + "boards/" + boardId +  "/queues/" + queueId + "/cards/2")))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues/:queueId/cards")	 {request =>
		  val boardId = request.routeParams.get("boardId").get
		  val queueId = request.routeParams.get("queueId").get
		  render.json(List(new URI(hostName + baseUrl + "boards/" + boardId + "queues/1/cards/1"),
				  		   new URI(hostName + baseUrl + "boards/" + boardId + "queues/1/cards/2"))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues/:queueId/cards/:cardId") {request =>
		  val cardId = request.routeParams.get("cardId").get
		  render.json(Card(id = cardId, 
		      			   name = "Some user story name", 
		      			   points ="3", 
		      			   startDate = new Date(System.currentTimeMillis()),
		      			   endDate  = new Date(System.currentTimeMillis()),
		      			   leadTime = HashMap("testAndCode" -> 3, "codeReview" -> 4, "acceptance" -> 1 ), 
		      			   testInfo = HashMap("unitTests" -> 1, "integrationTests" -> 4, "integrationTestsFixed" -> 0 )
		      			   )).toFuture
	  
	}
	
	
}
