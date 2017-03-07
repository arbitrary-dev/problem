package com.problem

object Pascal {

  def build(size: Int): List[List[Int]] = {
    if (size <= 0)
      return Nil

    (0 until size).foldLeft(List[List[Int]]()) { (res, r) =>
      (0 to r).foldRight(List[Int]()) { (c, row) =>
        num(c, r, res) :: row
      } :: res
    } reverse
  }

  private def num(c: Int, r: Int, t: List[List[Int]]): Int = {
    if (c == 0 || c == r) 1
    else t.head(c - 1) + t.head(c)
  }
}