package com.problem

object Zip {
  def solution(a: Int, b: Int): Int = {
    var res = a.toString.dropWhile(_ == '0').zipAll(b.toString, "", "").flatMap {
      case (a, b) => a + String.valueOf(b)
    } mkString

    val L = res.length
    if (L > 10 || (L == 10 && res != "1000000000"))
      return -1

    res.toInt
  }
}