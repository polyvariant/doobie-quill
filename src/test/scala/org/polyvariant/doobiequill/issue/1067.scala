package org.polyvariant.doobiequill
package issue

import cats.effect._
import doobie._
import doobie.implicits._
import io.getquill._

// https://github.com/tpolecat/doobie/issues/1067
class `1067` extends munit.FunSuite {

  import cats.effect.unsafe.implicits.global

  lazy val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver",
    "jdbc:postgresql:world",
    "postgres",
    "",
  )

  val dc = new DoobieContext.Postgres(Literal)
  import dc._

  case class Country(name: String, indepYear: Option[Short])

  test("Issue1067 - correctly select many countries, with a null in last position") {
    val stmt = quote(query[Country])
    val actual = run(stmt).transact(xa).unsafeRunSync()
    assertEquals(actual.count(_.indepYear.isDefined), 192)
    assertEquals(actual.count(_.indepYear.isEmpty), 47)
  }

}
