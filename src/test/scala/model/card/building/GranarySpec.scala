package model.card.building

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GranarySpec extends AnyFlatSpec with Matchers {

  "A Granary" should "be named Granary" in {
    val granary = Granary
    assert(granary.name == "Granary")
  }
}
