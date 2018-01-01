package me.ngrid

import java.util
import java.util.Calendar

import com.twitter.finagle.Http
import com.twitter.server.TwitterServer
import com.twitter.util.Await
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._

object Main extends TwitterServer {
  case class Locale(language: String, country: String)
  case class Time(local: Locale, time: String)

  def currentTime(l: java.util.Locale): String = {
    Calendar.getInstance(l).getTime.toString
  }

  def main(): Unit = {

    val time: Endpoint[Time] = post("/time" :: jsonBody[Locale]) {l: Locale =>
      Ok(Time(l, currentTime(new util.Locale(l.language, l.country))))
    }

    val server = Http.server.serve(":8080", (time).toService)
    Await.ready(server)
    ()
  }
}
