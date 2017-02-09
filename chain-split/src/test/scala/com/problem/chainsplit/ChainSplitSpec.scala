package com.problem.chainsplit

import org.scalatest.FunSuite
import org.scalatest.Matchers
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.Matcher

class ChainSplitSpec extends FunSuite with Matchers {

  def resultIn(right: Int) = new Matcher[Array[Int]] {
    def apply(left: Array[Int]) = {
      val result = ChainSplit minSplit left
      MatchResult(
        right equals result,
        s"""Expected "$right", but resulted in "$result"""",
        s""""$left" was correctly resulted in "$result""""
      )
    }
  }

  info("ChainSplit find minimum")

  test("Minimal split is 5") {
    Array(5, 2, 4, 6, 3, 7) should resultIn (5)
  }

  test("Minimal split is 11") {
    Array(2, 5, 4, 6, 7, 3) should resultIn (11)
  }
}
