package com.problem.chainsplit

object ChainSplit {

  def minSplit(a: Array[Int]): Int = {
    val L = a.size
    val b = new Array[Int](L)

    b(L - 2) = a(L - 2)

    // build 'b' prefix mins from right
    for (i <- (L - 3) to 0 by -1)
      b(i) = b(i + 1).min(a(i))

    // build 'a' prefix mins from left
    for (i <- 2 to L - 1)
      a(i) = a(i - 1).min(a(i))

    (2 until (L - 2))
      .map { i => a(i - 1) + b(i + 1) }
      .min
  }
}
