package com.problem.phone

object Phone {
  def process(input: String): String = {
    val res = new StringBuilder()

    input
      .filter(Character.isDigit)
      .grouped(3)
      .foreach { group =>
        if (!res.isEmpty) {
          if (group.length > 1)
            res += '-'
          else // corner case for two 2-sized blocks
            res.insert(res.length - 1, '-')
        }

        res ++= group
      }

    res.toString
  }
}
