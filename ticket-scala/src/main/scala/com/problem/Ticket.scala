package com.problem

import scala.annotation.tailrec

object Ticket {
  
  val T1  = 2
  val T7  = 7
  val T30 = 25
  
  @tailrec def process(ds: List[Int], d: Int = 1, res: Array[Int] = new Array[Int](31)): Int = {
    if (ds.isEmpty) return res(d - 1)
    
    res(d) = res(d - 1)
    
    if (d == ds.head) {
      val sumBefore7 = res(math.max(d - 7, 0));
      val sum7 = math.min(res(d) + T1 - sumBefore7, T7)
      
      res(d) = sumBefore7 + sum7
    }
    
    if (res(d) > T30)
      T30
    else
      process(
        if (d == ds.head) ds.tail else ds,
        d + 1,
        res
      )
  }
}