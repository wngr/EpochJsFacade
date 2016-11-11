package de.wngr.epochjs

import de.wngr.epochjs.epoch.{ChartData, ChartOptions, DataPoint}
import org.querki.jquery._

import scalajs.js
import js.annotation._
import js.JSConverters._

@js.native
trait EpochTimeLine extends JQuery {
  def epoch(options: ChartOptions): this.type = js.native

  def push(data: js.Array[DataPoint]) = js.native
}
object EpochTimeLine {
  implicit def jq2epoch(jq: JQuery): EpochTimeLine =
    jq.asInstanceOf[EpochTimeLine]
}

package epoch {
  @js.native
  trait ChartOptions extends js.Object {
    var `type`: String = js.native
    var data: js.Array[ChartData] = js.native
    var axes: js.Array[String] = js.native
    var ticks: TickConfiguration = js.native
    var tickFormats: TickFormatConfiguration = js.native
    var fps: Int = js.native
    var windowSize: Int = js.native
    var historySize: Int = js.native
    var queueSize: Int = js.native
    var margins: MarginConfiguration = js.native
    var width: Int = js.native
    var height: Int = js.native
    var pixelRatio: Int = js.native
  }
  object ChartOptions {
    def apply(
               `type`: String,
               data: Seq[ChartData],
               axes: Option[Seq[String]] = None,
               range: Option[RangeConfiguration] = None,
               ticks: Option[TickConfiguration] = None,
               tickFormats: Option[TickFormatConfiguration] = None,
               fps: Option[Int] = None,
               windowSize: Option[Int] = None,
               historySize: Option[Int] = None,
               queueSize: Option[Int] = None,
               margins: Option[MarginConfiguration] = None,
               width: Option[Int] = None,
               height: Option[Int] = None,
               pixelRatio: Option[Int] = None
             ): ChartOptions = {
      val res = js.Dynamic.literal(`type` = `type`, data = data.toJSArray)
      axes.foreach(seq => res.axes = seq.toJSArray)
      range.foreach(res.range = _)
      ticks.foreach(res.ticks = _)
      tickFormats.foreach(res.tickFormats = _)
      fps.foreach(res.fps = _)
      windowSize.foreach(res.windowSize = _)
      historySize.foreach(res.historySize = _)
      queueSize.foreach(res.queueSize = _)
      margins.foreach(res.margins = _)
      width.foreach(res.width = _)
      height.foreach(res.height = _)
      pixelRatio.foreach(res.pixelRatio = _)
      res.asInstanceOf[ChartOptions]
    }
  }

  @js.native
  trait RangeConfiguration extends js.Object {
    var left: String = js.native
    var right: String = js.native
  }
  object RangeConfiguration {
    def apply(left: Option[String] = None,
              right: Option[String] = None): RangeConfiguration = {
      val res = js.Dynamic.literal()
      left.foreach(res.left = _)
      right.foreach(res.right = _)
      res.asInstanceOf[RangeConfiguration]
    }
  }
  @js.native
  trait MarginConfiguration extends js.Object {
    var left: Int = js.native
    var top: Int = js.native
    var right: Int = js.native
    var bottom: Int = js.native
  }
  object MarginConfiguration {
    def apply(left: Option[Int] = None,
              top: Option[Int] = None,
              right: Option[Int] = None,
              bottom: Option[Int] = None): MarginConfiguration = {
      val res = js.Dynamic.literal()
      left.foreach(res.left = _)
      top.foreach(res.left = _)
      right.foreach(res.left = _)
      bottom.foreach(res.left = _)
      res.asInstanceOf[MarginConfiguration]
    }
  }

  @js.native
  trait TickConfiguration extends js.Object {
    var time: Int = js.native
    var right: Int = js.native
    var left: Int = js.native
  }
  @js.native
  trait TickFormatConfiguration extends js.Object {
    var bottom: js.Function1[Double, String] = js.native
    var left: js.Function1[Double, String] = js.native
    var top: js.Function1[Double, String] = js.native
    var right: js.Function1[Double, String] = js.native
  }
  object TickFormatConfiguration {
    def apply(
               bottom: Option[(Double => String)] = None,
               left: Option[(Double => String)] = None,
               top: Option[(Double => String)] = None,
               right: Option[(Double => String)] = None): TickFormatConfiguration = {
      val res = js.Dynamic.literal()
      bottom.foreach(res.bottom = _)
      left.foreach(res.left = _)
      top.foreach(res.top = _)
      right.foreach(res.right = _)
      res.asInstanceOf[TickFormatConfiguration]
    }
  }
  object TickConfiguration {
    def apply(
               time: Option[Int] = None,
               right: Option[Int] = None,
               left: Option[Int] = None): TickConfiguration = {
      val res = js.Dynamic.literal()
      time.foreach(res.time = _)
      right.foreach(res.right = _)
      left.foreach(res.left = _)
      res.asInstanceOf[TickConfiguration]
    }
  }
  @js.native
  trait DataPoint extends js.Object {
    var time: Double = js.native
    var y: Int = js.native
  }
  object DataPoint {
    def apply(time: Double, y: Int): DataPoint = js.Dynamic.literal(time = time / 1000, y = y).asInstanceOf[DataPoint]
  }
  @js.native
  trait ChartData extends js.Object {
    var label: String = js.native
    var values: js.Array[DataPoint] = js.native
    var range: String = js.native
  }
  object ChartData {
    def apply(label: String, values: Seq[DataPoint], range: Option[String] = None): ChartData = {
      val res = js.Dynamic.literal(label = label, values = values.toJSArray)
      range.foreach(res.range = _)
      res.asInstanceOf[ChartData]
    }
  }

  //  //TODO
  //  @js.native
  //  trait ChartType extends js.Object
}
