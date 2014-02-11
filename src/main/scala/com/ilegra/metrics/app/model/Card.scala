package com.ilegra.metrics.app.model

import java.util.Date

case class Card(id: String, name: String, points: String, startDate: Date, endDate: Date, leadTime: Map[String, Integer], testInfo: Map[String, Integer])
