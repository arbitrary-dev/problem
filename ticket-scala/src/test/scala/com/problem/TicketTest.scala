package com.problem

import org.scalatest.FunSuite
import org.scalatest.Matchers
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.Matcher

class TicketTest extends FunSuite with Matchers {
  
  def resultIn(right: Int) = new Matcher[List[Int]] {
    def apply(left: List[Int]) = {
      val result = Ticket process left
      MatchResult(
        right equals result,
        s"""Expected "$right", but resulted in "$result"""",
        s""""$left" correctly resulted in "$result""""
      )
    }
  }
  
  info("Tickets testing")
  
  test("Empty list") {
    List.empty should resultIn (0)
  }
  
  test("Should result in 11") {
    List(1, 2, 4, 5, 7, 29, 30) should resultIn (11)
    List(1, 2, 24, 26, 27, 29, 30) should resultIn (11)
  }
  
  test("Should result in 24") {
    List(1, 3, 5, 9, 10, 13, 14, 15,
				 17, 19, 21, 23, 24, 27) should resultIn (24)
  }
  
  test("Should result in 25") {
    List(1, 3, 5, 7, 9, 11, 13, 15,
				 17, 19, 21, 23, 25, 27, 29) should resultIn (25)
  }
  
}