package com.problem.absdiv

object AbsDiv {

  def solve(a: Array[Int]): Int = {
    val L = a.size
    val b = new Array[Int](L)

    b(L - 1) = a(L - 1) // only base case, to avoid copying all array

    for (i <- (L - 2) to 0 by -1)
      b(i) = b(i + 1).max(a(i)) // purposedly reading current value from 'a'

    for (i <- 1 until L)
      a(i) = a(i - 1).max(a(i))

    (0 until (L - 1))
      .map { i => (a(i) - b(i + 1)).abs }
      .max
  }
}
