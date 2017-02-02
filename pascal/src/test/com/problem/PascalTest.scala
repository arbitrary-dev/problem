package com.problem

import org.scalatest.FunSuite
import org.scalatest.Matchers
import org.scalatest.matchers.Matcher
import org.scalatest.matchers.MatchResult

class PascalTest extends FunSuite with Matchers {

  def resultIn(right: List[List[Int]]) = new Matcher[Int] {
    def apply(left: Int) = {
      val result = Pascal build left
      MatchResult(
        right == result,
        s"""Expected "$right", but resulted in "$result"""",
        s""""$left" correctly resulted in "$result""""
      )
    }
  }

  info("Pascal triangle")

  test("Zero size") {
    0 should resultIn (Nil)
  }

  test("Negative size") {
    -10 should resultIn (Nil)
  }

  test("Size 3") {
    3 should resultIn (List(List(1), List(1, 1), List(1, 2, 1)))
  }

  test("Size 4") {
    4 should resultIn (List(List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1)))
  }
}