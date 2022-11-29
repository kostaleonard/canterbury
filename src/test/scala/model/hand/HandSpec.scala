package model.hand

import model.card.building.Granary
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HandSpec extends AnyFlatSpec with Matchers {

  "A hand" should "be empty when created empty" in {
    val hand = Hand.empty
    assert(hand.isEmpty)
  }

  it should "not be empty when it contains cards" in {
    val hand = Hand(List(Granary))
    assert(hand.nonEmpty)
  }
}
