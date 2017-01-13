package com.problem.phone

import org.scalatest.FunSuite
import org.scalatest.Matchers
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.Matcher

class PhoneTest extends FunSuite with Matchers {
  
  def convertTo(right: String) = new Matcher[String] {
    def apply(left: String) = {
      val converted = Phone process left
      MatchResult(
        right equals converted,
        s"""Expected "$right", but converted to "$converted"""",
        s""""$left" was correctly converted to "$converted""""
      )
    }
  }
  
  info("Phone numbers convertion")
  
  test("Smallest number") {
    " - 22 --" should convertTo ("22")
  }
  
  test("One 2-sized block at the end") {
    "00-44  48 5555 8361" should convertTo ("004-448-555-583-61")
  }
  
  test("Two 2-sized blocks at the end") {
    "0 - 22 1985--324" should convertTo ("022-198-53-24")
    " - 23 --32" should convertTo ("23-32")
  }
  
  test("All block are 3-sized") {
    "555372654" should convertTo ("555-372-654")
  }
}