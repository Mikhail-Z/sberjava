package collection

import java.util.Date

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */

class StockData( val date: Date,
                 val googleStockPrice: BigDecimal,
                 val microsoftStockPrice: BigDecimal,
                 val amazonStockPrice: BigDecimal,
                 val facebookStockPrice: BigDecimal) {
}

object CollectionIssueThree {

  def main(args: Array[String]): Unit = {
    printlnStocksInfo("hdata_stock.csv")
  }

  def printlnStocksInfo(fileName: String): Unit = {
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines()) {
      val stock_prices = line.split(";").map(s => s.trim)
      stock_prices match {
        case Array(date, google, microsoft, amazon, facebook) => println(date, google, microsoft, amazon, facebook)
        case _ =>
      }
    }
    bufferedSource.close
  }
}
