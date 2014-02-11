package com.ilegra.metrics.app

import com.twitter.finatra.FinatraServer

object MainApp extends FinatraServer {
	register(new MetricsController());
}