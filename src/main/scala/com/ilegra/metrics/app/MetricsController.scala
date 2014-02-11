package com.ilegra.metrics.app

import java.net.URI
import java.util.Date
import com.ilegra.metrics.app.model.Board
import com.ilegra.metrics.app.model.Queue
import com.twitter.finatra.Controller
import com.ilegra.metrics.app.model.Card
import scala.collection.immutable.HashMap
import java.net.URL
import java.text.SimpleDateFormat
import com.twitter.finatra.Request

class MetricsController extends Controller {
	val hostName = "http://localhost:7070"
	val baseUrl = "/api/v1/teams/"
	  
	get(baseUrl + "boards") { request =>
	  render.json(List(new URL(hostName + baseUrl + "boards/1"), 
			  		   new URL(hostName + baseUrl + "boards/2"), 
			  		   new URL(hostName + baseUrl + "boards/3"))).toFuture
	}
	
	get(baseUrl + "boards/:boardId") {request =>
		render.json(Board(id = getParameterValue(request, "boardId"), 
		    			  name = "Board Name", 
		    			  queues = List(new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "/queues/1"),
		    					  	    new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "/queues/2")))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues") {request =>
		render.json(List(new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "/queues/1"),
						 new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "/queues/2"))).toFuture
	}

	get(baseUrl + "boards/:boardId/queues/:queueId") { request =>
	  render.json(Queue(id    = getParameterValue(request, "queueId"), 
	      				name  = "Some Queue Name", 
	      				cards = List(new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") +  "/queues/" + getParameterValue(request, "queueId") + "/cards/1"),
	      							 new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") +  "/queues/" + getParameterValue(request, "queueId") + "/cards/2")))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues/:queueId/cards")	 {request =>
		  render.json(List(new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "queues/" + getParameterValue(request, "queueId") + "/cards/1"),
				  		   new URI(hostName + baseUrl + "boards/" + getParameterValue(request, "boardId") + "queues/" + getParameterValue(request, "queueId") +"/cards/2"))).toFuture
	}
	
	get(baseUrl + "boards/:boardId/queues/:queueId/cards/:cardId") {request =>
		  def getMockedDate() = new SimpleDateFormat("dd-MMM-yyyy").format(new Date(System.currentTimeMillis()))
		  
		  render.json(Card(id = getParameterValue(request, "cardId"), 
		      			   name      = "Some user story name", 
		      			   points    = "3", 
		      			   startDate = getMockedDate(),
		      			   endDate   = getMockedDate(),
		      			   leadTime  = HashMap("testAndCode" -> 3, "codeReview" -> 4, "acceptance" -> 1 ), 
		      			   testInfo  = HashMap("unitTests" -> 1, "integrationTests" -> 4, "integrationTestsFixed" -> 0 )
		      			   )).toFuture
	}
	
	def getParameterValue(request: Request, parameterName: String) =  request.routeParams.get(parameterName).get
	
}
