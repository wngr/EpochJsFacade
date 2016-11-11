package de.wngr.epochjs

import de.wngr.epochjs.EpochTimeLine._
import de.wngr.epochjs.epoch._

import scala.scalajs.js.JSApp
import org.querki.jquery._
import scala.concurrent.duration._
import scala.scalajs.js
import scala.util.Random
import scala.scalajs.js.{Date, timers}
import js.JSConverters._

object TestChart extends JSApp {
  def main(): Unit = {

    val data = (1 to 6).map { i =>
      ChartData(s"a$i", Seq(DataPoint(System.currentTimeMillis(), Random.nextInt(100))), Some {
        if (i % 2 == 0) "range-l" else "range-r"
      })
    }
    val co = ChartOptions("time.line",
      data.toJSArray,
      ticks = Option(TickConfiguration(Some(5))),
      axes = Some(Seq("left", "bottom", "right")),
      tickFormats = Some(TickFormatConfiguration(bottom = Some((d: Double) => new Date(d * 1000).toLocaleTimeString()))),
      range = Some(RangeConfiguration(Some("range-l"), Some("range-r")))
    )

    val a = $("#area").epoch(co)
    println(a.toString)
    var i = 0
    //    timers.setInterval(1.seconds) {
    while (i < 250) {
      val c: IndexedSeq[DataPoint] = (1 to 6).map(_ => DataPoint(System.currentTimeMillis(), Random.nextInt(100)))
      a.push(c.toJSArray)
      i = i + 1
    }
  }
}
