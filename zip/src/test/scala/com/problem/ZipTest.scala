package com.problem

import org.scalatest.Matchers
import org.scalatest.FunSuite
import org.scalatest.matchers.Matcher
import org.scalatest.matchers.MatchResult

class ZipTest extends FunSuite with Matchers {

  def resultIn(right: Int) = new Matcher[(Int, Int)] {
    def apply(left: (Int, Int)) = {
      val result = Zip.solution(left._1, left._2)
      MatchResult(
        right == result,
        s"""Expected "$right", but resulted in "$result"""",
        s""""$left" correctly resulted in "$result""""
      )
    }
  }

  info("Numbers zipping")

  test("Zeroes") {
    (0, 0) should resultIn (0)
    (0, 123) should resultIn (123)
    (123, 0) should resultIn (1023)
  }

  test("Equal zip") {
    (123, 456) should resultIn (142536)
  }

  test("Unequal zip") {
    (12345, 678) should resultIn (16273845)
    (123, 67890) should resultIn (16273890)
  }

  test("Overflow") {
    (0, 1000000000) should resultIn (1000000000)
    (1, 1000000000) should resultIn (-1)
    (1, 100000000) should resultIn (-1)
  }
}