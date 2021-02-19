import uk.gov.hmrc.DefaultBuildSettings._

lazy val libName = "time"

lazy val root = Project(libName, file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning, SbtArtifactory)
  .settings(defaultSettings(): _*)
  .settings(
    majorVersion := 3,
    makePublicallyAvailableOnBintray := true,
  )
  .settings(
    scalaVersion := "2.12.10",
    crossScalaVersions := Seq("2.11.12", "2.12.10"),
    resolvers += "PBD-3014 Spike Snapshots" at "https://pbd-3014-spike.s3.eu-west-2.amazonaws.com/snapshots/",
    libraryDependencies ++= Seq(
      "com.github.nscala-time"  %% "nscala-time"      % "2.22.0",
      "com.vladsch.flexmark"    % "flexmark-all"      % "0.35.10"  % Test,
      "org.scalatest"           %% "scalatest"        % "3.1.1"    % Test,
      "uk.gov.hmrc"             %% "http-verbs"       % "14.0.0"
    )
  )
