package com.problem.password

object Password {

  val re = """\D*[A-Z]\D*""".r

  def process(s: String): Int = {
    if (s.isEmpty) return -1
    (re findAllIn s)
      .map(_.length)
      .fold(-1) { (a, b) => if (a < b) b else a }
  }
}