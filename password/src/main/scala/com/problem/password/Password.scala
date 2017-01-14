package com.problem.password

object Password {
  
  val re = """\D*[A-Z]\D*""".r
  
  def process(s: String): Int = {
    if (s.isEmpty) return -1
    val ls = re findAllIn s map (_.length)
    if (ls.isEmpty) return -1
    ls.max
  }
}