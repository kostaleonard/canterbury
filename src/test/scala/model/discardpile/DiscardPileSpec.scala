package model.discardpile

import model.card.capital.RomeCapital
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DiscardPileSpec extends AnyFlatSpec with Matchers {

  "A DiscardPile" should "be empty when created empty" in {
    val discardPile = DiscardPile.empty
    assert(discardPile.isEmpty)
  }

  it should "not be empty when it contains cards" in {
    val discardPile = DiscardPile(List(RomeCapital))
    assert(discardPile.nonEmpty)
  }
}
