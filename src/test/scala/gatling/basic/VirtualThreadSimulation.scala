package gatling.basic

import guru.oleg.boot_vt.VirtualThreadsApplication
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import org.springframework.boot.SpringApplication

class VirtualThreadSimulation extends Simulation {

  before {
    val app = SpringApplication.run(classOf[VirtualThreadsApplication])
    app.registerShutdownHook()
  }

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val vtScenario = scenario("Virtual Thread Scenario").repeat(1000) {
    exec(http("Call the Controller")
      .get("/")
      .check(status.is(200)))
  }

  setUp(
    vtScenario.inject(atOnceUsers(500))
  ).protocols(httpProtocol)

}
