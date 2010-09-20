import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val lift_mongo = "net.liftweb" % "lift-mongodb" % "2.0"
}
