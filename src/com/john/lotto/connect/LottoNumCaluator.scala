package com.john.lotto.connect

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Real on 2015-03-29.
 */
object LottoNumCaluator {
  private val ballNoPopPattern = "ballNoPop\\[([0-9]+)\\][\\s]*=[\\s]*\\'([0-9]+)\\'".r
  private val ballCntPopPattern = "drwtNoPop\\[([0-9]+)\\][\\s]*=[\\s]*\\'([0-9]+)\\'".r
  
  def getIndexNumList(iter :  Iterator[String]): ArrayBuffer[Tuple2[String, String]] = {
    val result = ArrayBuffer[Tuple2[String, String]]()
    for (i <- iter) {
      val ballNum = for (m <- ballNoPopPattern findFirstMatchIn i) yield (m group 1, m group 2)
      if (!ballNum.equals(None))
        result += new Pair(ballNum.get._1.toString, ballNum.get._2.toString)
    }
    result
  }

  def getCountList(iter :  Iterator[String], numList : ArrayBuffer[Tuple2[String, String]]): ArrayBuffer[Tuple3[String, String, String]] = {
    val result = ArrayBuffer[Tuple3[String, String, String]]()
    for (i <- iter) {
      val ballCnt = for (m <- ballCntPopPattern findFirstMatchIn i) yield (m group 1, m group 2)
      if (!ballCnt.equals(None)) {
        val index = ballCnt.get._1
        val cnt = ballCnt.get._2

        for (tu <- numList) {
          if (tu._1.toString equals index.toString) {
            result += new Triple(index, tu._2.toString, cnt)
          }

        }
      }
    }
    result
  }

  def tupleSorting(list : ArrayBuffer[Tuple3[String, String, String]]):  Array[Tuple3[String, String, String]] = {
    scala.util.Sorting.stableSort(list, (e1: Tuple3[String, String, String], e2: Tuple3[String, String, String]) => Integer.parseInt(e1._3) > Integer.parseInt(e2._3))
  }
}
