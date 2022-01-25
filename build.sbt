inThisBuild(
  List(
    organization := "org.polyvariant",
    homepage := Some(url("https://github.com/polyvariant/doobie-quill")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "kubukoz",
        "Jakub Kozłowski",
        "kubukoz@gmail.com",
        url("https://blog.kubukoz.com"),
      )
    ),
    Compile / doc / sources := Seq(),
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    sonatypeRepository := "https://s01.oss.sonatype.org/service/local",
  )
)

val Scala212 = "2.12.15"
val Scala213 = "2.13.7"

def crossPlugin(x: sbt.librarymanagement.ModuleID) = compilerPlugin(x.cross(CrossVersion.full))

val compilerPlugins = List(
  crossPlugin("org.typelevel" % "kind-projector" % "0.13.2"),
  crossPlugin("org.polyvariant" % "better-tostring" % "0.3.13"),
)

ThisBuild / versionScheme := Some("early-semver")

ThisBuild / scalaVersion := Scala213
ThisBuild / crossScalaVersions := Seq(Scala212, Scala213)

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches += RefPredicate.StartsWith(Ref.Tag("v"))
ThisBuild / githubWorkflowBuildPreamble ++= Seq(
  WorkflowStep.Run(
    List(
      "docker-compose up -d"
    )
  )
)
ThisBuild / githubWorkflowBuildPostamble ++= Seq(
  WorkflowStep.Run(
    List(
      "docker-compose down"
    )
  )
)
ThisBuild / githubWorkflowPublish := Seq(
  WorkflowStep.Sbt(
    List("ci-release"),
    env =
      List(
        "PGP_PASSPHRASE",
        "PGP_SECRET",
        "SONATYPE_PASSWORD",
        "SONATYPE_USERNAME",
      ).map { envKey =>
        envKey -> s"$${{ secrets.$envKey }}"
      }.toMap,
  )
)

val root = project
  .in(file("."))
  .settings(
    name := "doobie-quill",
    libraryDependencies ++= Seq(
      "io.getquill" %% "quill-jdbc" % "3.14.0",
      "org.tpolecat" %% "doobie-core" % "1.0.0-RC1",
      "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC1" % Test,
      "org.scalameta" %% "munit" % "0.7.29" % Test,
    ) ++ compilerPlugins,
    Test / fork := true,
  )
