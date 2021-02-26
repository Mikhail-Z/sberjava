package com.company.sql

case class Response(country: String, age_midpoint: Option[Double], occupation: String, salary_midpoint: Option[Double]) {
  override def toString: String = s"country: ${country}, age_midpoint: ${if (age_midpoint.isDefined) age_midpoint.get else null}, occupation: ${occupation}, salary_midpoint: ${salary_midpoint}"
}
