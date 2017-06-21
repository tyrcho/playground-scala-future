package com.yourself

import org.scalatest._

class TestUniverse extends FlatSpec with Matchers {

  "countAllStars" should "sum stars" in {
    assert(Universe.countAllStars(List(2, 3)) == 5)
    assert(Universe.countAllStars(List(9, -3)) == 6)
    if (io.Source.fromFile("./src/main/scala/com/yourself/Universe.scala").getLines.exists(_.contains("galaxies.sum"))) {
      msg("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ");
      msg("My personal Yoda, you are. 🙏", "           　★ °  ☆ ¸. ¸ 　★　 :.　 .   ");
      msg("My personal Yoda, you are. 🙏", "__.-._     ° . .　　　　.　☾ ° 　. *   ¸ .");
      msg("My personal Yoda, you are. 🙏", "'-._ 7'      .　　° ☾  ° 　¸.☆  ● .　　　");
      msg("My personal Yoda, you are. 🙏", " /'.-c    　   * ●  ¸.　　°     ° 　¸.    ");
      msg("My personal Yoda, you are. 🙏", " |  /T      　　°     ° 　¸.     ¸ .　　  ");
      msg("My personal Yoda, you are. 🙏", "_)_/LI");
    } else {
      msg("Kudos 🌟", "Did you know all the feature of the collection API? Try it!");
      msg("Kudos 🌟", "");
      msg("Kudos 🌟", "val galaxies = List(37, 3, 2);");
      msg("Kudos 🌟", "val totalStars = galaxies.sum // 42");
    }

  }

  def success(success: Boolean) = println(s"TECHIO> success $success")
  def msg(channel: String, msg: String) = println(s"""TECHIO> message --channel "$channel" "$msg" """)
}
