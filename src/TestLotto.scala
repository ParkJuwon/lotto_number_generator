import java.util

import com.john.lotto.connect.{LottoNumCaluator, LottoSiteConnector}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.matching.Regex
/**
 * Created by Real on 2015-03-29.
 */
object TestLotto extends App{

  val iter1 = LottoSiteConnector.getNumberIteration;
  val iter2 = LottoSiteConnector.getNumberIteration;

  val indexList = LottoNumCaluator.getIndexNumList(iter1);
  val resultList = LottoNumCaluator.getCountList(iter2, indexList);

  val result = LottoNumCaluator.tupleSorting(resultList)

  println(result.mkString("\n"))
}
