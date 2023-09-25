val a1 = project
val a2 = project

TaskKey[Unit]("testMatchException") := {
  (a1 / Compile / compile).value
  (a2 / Compile / compile).value
  val xs = Seq(
    (a2 / Compile / classDirectory).value / "example" / "Main.class",
    (a1 / Compile / classDirectory).value / "example" / "F.class",
    (a2 / Compile / classDirectory).value / "example" / "A.class",
    (a2 / Compile / classDirectory).value / "example" / "A$B.class",
    (a2 / Compile / classDirectory).value / "example" / "A$C.class",
  )
  IO.withTemporaryDirectory { dir =>
    xs.foreach { f =>
      IO.copyFile(f, dir / "example" / f.getName)
    }
    sys.process.Process(Seq("java", "example/Main"), dir).!
  }
}
