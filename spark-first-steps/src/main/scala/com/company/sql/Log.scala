package com.company.sql

case class Log(host: String, logname: String, time: Long, method: String, url: String, response: Int, bytes: Int)
