package com.company.window

import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.scala.function.WindowFunction
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.util.Collector
import com.company.util._

/**
 * TODO Рассмотрите пример, запустите его и объясните результат.
 */
object AverageSensorReadings extends App {
  import org.apache.flink.api.scala.createTypeInformation
  val env = StreamExecutionEnvironment.createLocalEnvironment(1)

  env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
  env.getConfig.setAutoWatermarkInterval(1000L)

  val sensorData: DataStream[SensorReading] = env
    .addSource(new SensorSource)
    .assignTimestampsAndWatermarks(new SensorTimeAssigner)

  val avgTemp: DataStream[SensorReading] = sensorData
    // конвертируем Градусы Фаренгейта в Градусы Цельсия
    .map( r =>
      SensorReading(r.id, r.timestamp, (r.temperature - 32) * (5.0 / 9.0)) )
    // разбиваем по sensorId
    .keyBy(_.id)
    // окно 1 секунда
    .timeWindow(Time.seconds(1))
    // считаем среднюю температуру, используем оконную функцию
    .apply(new TemperatureAverager)

  avgTemp.print()

  env.execute("Compute average sensor temperature")
}

/** Пользовательская оконная функция (WindowFunction) для вычисления средней температуры SensorReadings */
class TemperatureAverager extends WindowFunction[SensorReading, SensorReading, String, TimeWindow] {

  /** apply() выполняется для каждого окна */
  override def apply(
                      sensorId: String,
                      window: TimeWindow,
                      vals: Iterable[SensorReading],
                      out: Collector[SensorReading]): Unit = {

    val (cnt, sum) = vals.foldLeft((0, 0.0))((c, r) => (c._1 + 1, c._2 + r.temperature))
    val avgTemp = sum / cnt

    out.collect(SensorReading(sensorId, window.getEnd, avgTemp))
  }
}
