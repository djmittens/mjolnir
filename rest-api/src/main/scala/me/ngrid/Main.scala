package me.ngrid

import java.util
import java.util.Calendar

import com.twitter.finagle.Http
import com.twitter.util.Await
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._

object Main {
  case class Locale(language: String, country: String)
  case class Time(local: Locale, time: String)

  def currentTime(l: java.util.Locale): String = {
    Calendar.getInstance(l).getTime.toString
  }


  def main(args: Array[String]): Unit = {

    val time: Endpoint[Time] = post("time" :: jsonBody[Locale]) {l: Locale =>
      Ok(Time(l, currentTime(new util.Locale(l.language, l.country))))
    }

    Await.ready(Http.server.serve(":8080", time.toService))

    ()
  }
}
