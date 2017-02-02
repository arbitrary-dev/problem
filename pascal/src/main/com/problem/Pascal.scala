package com.problem

import scala.collection.mutable.ListBuffer

object Pascal {

  def build(size: Int): List[List[Int]] = {
    if (size <= 0)
      return Nil

    val res: ListBuffer[List[Int]] = new ListBuffer

    for (r <- 0 until size) {
      val row: ListBuffer[Int] = new ListBuffer

      for (c <- 0 to r)
        row += num(c, r, res)

      res += row.toList
    }

    return res.toList
  }

  private def num(c: Int, r: Int, t: ListBuffer[List[Int]]): Int = {
    if (c == 0 || c == r) 1
    else t.last(c - 1) + t.last(c)
  }
}