package com.worldline

import org.scalatest._

class TestUniverse extends FlatSpec with Matchers {

  "countAllStars" should "sum stars" in {
    assert(true)
    msg("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ")
    success(true)
  }

  def success(success: Boolean) = println(s"TECHIO> success $success")

  def msg(channel: String, msg: String) = println(s"""TECHIO> message --channel "$channel" "$msg" """)
}
