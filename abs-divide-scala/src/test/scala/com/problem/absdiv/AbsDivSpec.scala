package com.problem.absdiv

import org.scalatest.FunSuite
import org.scalatest.Matchers
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.Matcher

class AbsDivSpec extends FunSuite with Matchers {

  def resultIn(right: Int) = new Matcher[Array[Int]] {
    def apply(left: Array[Int]) = {
      val converted = AbsDiv solve left
      MatchResult(
        right equals converted,
        s"""Expected "$right", but resulted in "$converted"""",
        s""""$left" was correctly resulted in "$converted""""
      )
    }
  }

  info("Absolute divide")

  test("Should be 0") {
    Array(6, 6) should resultIn (0)
  }

  test("Should be 4") {
    Array(4, 3, 2, 5, 1, 1) should resultIn (4)
  }

  test("Should be 6") {
    Array(1, 3, -3) should resultIn (6)
  }

  test("Should be 12") {
    Array(-6, 6) should resultIn (12)
  }
}