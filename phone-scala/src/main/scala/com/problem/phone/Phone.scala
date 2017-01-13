package com.problem.phone

object Phone {
  def process(input: String): String = {
    val res = new StringBuilder()
    
    input
      .filter(Character.isDigit)
      .grouped(3)
      .foreach(
        group => {
          val nonEmpty = !res.isEmpty
          
          if (nonEmpty && group.length > 1)
            res += '-'
            
          res ++= group
          
          // corner case for two 2-sized blocks
          if (nonEmpty && group.length == 1)
            res.insert(res.length - 2, '-')
        }
      )
      
    res toString
  }
}