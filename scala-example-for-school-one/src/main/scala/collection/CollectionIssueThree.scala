package collection
import java.time.LocalDate
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */
object CollectionIssueThree {

  def main(args: Array[String]): Unit = {
    val rawStockInfoLinesWithHeaders = readStocksInfo("hdata_stock.csv")
    printStocksInfo(rawStockInfoLinesWithHeaders)
    val stockInfoLines = rawStockInfoLinesWithHeaders.drop(1).map(x => parseStocksInfo(x))
    val stockPrices = stockInfoLines.map(x => (x._2, x._3, x._4, x._5))
    val avgStockPricesByCompany = getAvgStocksPrice(stockPrices)
    println(avgStockPricesByCompany)
  }

  def readStocksInfo(fileName: String): Array[Tuple5[String, String, String, String, String]] = {
    val bufferedSource = io.Source.fromFile(fileName)
    val stockInfoLines = bufferedSource.getLines()
      .map(line => line.split(";").map(x => x.trim))
      .filter(x => x.length == 5)
      .map{
        case Array(col1, col2, col3, col4, col5) => (col1, col2, col3, col4, col5)
      }.toArray
    //todo разобраться, почему этот вариант не работает
    /*for (line <- bufferedSource.getLines()) {
      val a = line.split(";")
        .map(s => s.trim)
        .collect{ case Array(col1, col2, col3, col4, col5) => (col1, col2, col3, col4, col5)}
      }*/
    bufferedSource.close
    stockInfoLines
  }

  def parseStocksInfo(stocksInfoPerDay: Tuple5[String, String, String, String, String]) = {
    val dft = new DateTimeFormatterBuilder()
      .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm"))
      .appendOptional(DateTimeFormatter.ofPattern("M/dd/yyyy kk:mm:ss"))
      .toFormatter();
    val dt = LocalDate.parse(stocksInfoPerDay._1, dft)
    (dt,
      BigDecimal(stocksInfoPerDay._2),
      BigDecimal(stocksInfoPerDay._3),
      BigDecimal(stocksInfoPerDay._4),
      BigDecimal(stocksInfoPerDay._5))
  }

  def printStocksInfo(stocksInfoWithHeaders: Array[Tuple5[String, String, String, String, String]]): Unit = {
    stocksInfoWithHeaders.foreach(x => println(x))
  }

  def getAvgStocksPrice(stockPrices: Array[Tuple4[BigDecimal, BigDecimal, BigDecimal, BigDecimal]]) = {
    val initAcc = (BigDecimal(0), BigDecimal(0), BigDecimal(0), BigDecimal(0))
    val sum = stockPrices.scanLeft(initAcc){
      case ((acc1, acc2, acc3, acc4), (value1, value2, value3, value4)) => (
        value1 + acc1,
        value2 + acc2,
        value3 + acc3,
        value4 + acc4)}
      .last
    (sum._1/stockPrices.length, sum._2/BigDecimal(stockPrices.length), sum._3/stockPrices.length, stockPrices.length)
  }
}
