package com.problem.password

import org.scalatest.matchers.Matcher
import org.scalatest.Matchers
import org.scalatest.FunSuite
import org.scalatest.matchers.MatchResult

class PasswordTest extends FunSuite with Matchers {
  
  def resultIn(right: Int) = new Matcher[String] {
    def apply(left: String) = {
      val result = Password process left
      MatchResult(
        right == result,
        s"""Expected "$right", but resulted in "$result"""",
        s""""$left" correctly resulted in "$result""""
      )
    }
  }
  
  info("Longest password")
  
  test("Empty input") {
    "" should resultIn (-1)
  }
  
  test("Longest is 4") {
    "u1aBBa2bbccdd" should resultIn (4)
  }
  
  test("None found") {
    "u1abba2bbccdd" should resultIn (-1)
  }
}