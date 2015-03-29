package com.john.lotto.connect

/**
 * Created by Real on 2015-03-29.
 */
import scala.io.Source._;

object LottoSiteConnector {
  private def getStatByNumber = {
    fromURL("http://www.nlotto.co.kr/lotto645Stat.do?method=statByNumber", "EUC-KR")
  }

  def getNumberIteration = {
    getStatByNumber.getLines()
  }
}
