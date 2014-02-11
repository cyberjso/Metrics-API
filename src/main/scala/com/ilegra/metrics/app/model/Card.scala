package com.ilegra.metrics.app.model

case class Card(id: String, name: String, points: String, startDate: String, endDate: String, leadTime: Map[String, Integer], testInfo: Map[String, Integer])
