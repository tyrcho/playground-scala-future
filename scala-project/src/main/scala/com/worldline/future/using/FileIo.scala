package com.worldline.future.using

import scala.concurrent.ExecutionContext.Implicits.global

import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.{AsynchronousFileChannel, CompletionHandler}
import java.nio.file.Paths
import java.nio.file.StandardOpenOption._

import scala.concurrent.{Future, Promise}
import scala.util.Try
import scala.util.control.NonFatal

object FileIo {
  def read(file: String): Future[Array[Byte]] = {
    val p = Promise[Array[Byte]]()
    Future {
      try {
        val channel = AsynchronousFileChannel.open(Paths.get(file), READ)
        val buffer = ByteBuffer.allocate(channel.size.toInt)
        channel.read(buffer, 0L, buffer, buildHandler(channel, p))
      }
      catch {
        case NonFatal(t) => p.failure(t)
      }
    }
    p.future
  }

  private def buildHandler(channel: AsynchronousFileChannel, p: Promise[Array[Byte]]) = {
    new CompletionHandler[Integer, ByteBuffer]() {
      def completed(res: Integer, buffer: ByteBuffer): Unit = {
        p.complete(Try {
          buffer.array()
        })
        closeSafely(channel)
      }

      def failed(t: Throwable, buffer: ByteBuffer): Unit = {
        p.failure(t)
        closeSafely(channel)
      }
    }
  }

  private def closeSafely(channel: AsynchronousFileChannel) =
    try {
      channel.close()
    }
    catch {
      case e: IOException =>
    }
}
