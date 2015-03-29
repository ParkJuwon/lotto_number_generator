import java.util

import com.john.lotto.connect.{LottoNumCaluator, LottoSiteConnector}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Random
import scala.util.control.Breaks._

/**
 * Created by Real on 2015-03-29.
 */
object TestLotto extends App{

  val iter1 = LottoSiteConnector.getNumberIteration;
  val iter2 = LottoSiteConnector.getNumberIteration;

  val indexNumberList = LottoNumCaluator.getIndexNumList(iter1);
  val resultList = LottoNumCaluator.getCountList(iter2, indexNumberList);

  val result = LottoNumCaluator.tupleSorting(resultList)
  val rnd = new Random();


for(i <- 0 until 5) {
  val indexList = ArrayBuffer[Int]()
  breakable {
    while(true) {
      val idx = rnd.nextInt(12)

      val value = Integer.parseInt(result(idx)._1)

      var flag = true;
      for(i <- indexList) {
        if(i equals value) flag = false;
      }

      if(flag) indexList += value

      if(indexList.size == 3) break
    }
  }

  breakable {
    while(true) {
      val idx = rnd.nextInt(33) + 12

      val value = Integer.parseInt(result(idx)._1)

      var flag = true;
      for(i <- indexList) {
        if(i equals value) flag = false;
      }

      if(flag) indexList += value

      if(indexList.size == 6) break
    }
  }
  val lottoResult = scala.util.Sorting.stableSort(indexList, (e1: Int, e2:Int) => e1 < e2)
  println(lottoResult.mkString(" "))

  // TODO: 당첨된 이력이 있는지 확인하고 없으면 보여줌

  /**
   * - http://www.nlotto.co.kr/lotto645Confirm.do?method=allWin&nowPage=99
      http://www.nlotto.co.kr/lotto645Stat.do?method=statByNumber
   */
}



}
