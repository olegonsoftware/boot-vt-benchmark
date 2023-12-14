import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

import java.nio.file.Paths

object Engine extends App {

  private val rootDir = Paths.get(getClass.getClassLoader.getResource("gatling.conf").toURI).getParent.getParent.getParent
  private val targetDir = rootDir.resolve("target")
  private val srcTestDir = rootDir.resolve("src").resolve("test")

  val props = new GatlingPropertiesBuilder()
    .resourcesDirectory(srcTestDir.resolve("resources").toString)
    .resultsDirectory(targetDir.resolve("gatling").toString)
    .binariesDirectory(targetDir.resolve("test-classes").toString)

  Gatling.fromMap(props.build)
}