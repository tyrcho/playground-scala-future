package com.worldline.future.using

import org.scalatest._
import org.scalatest.concurrent.Eventually

import scala.concurrent.Future

class TestUsing extends FlatSpec with Matchers with Eventually {

  "FileIo" should "get file content asynchronously" in {
    val data: Future[Array[Byte]] = FileIo.read("build.sbt")
    data.isCompleted shouldBe false
    eventually(data.isCompleted shouldBe true)
  }

}
