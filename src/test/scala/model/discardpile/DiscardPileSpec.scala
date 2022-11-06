package model.discardpile

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DiscardPileSpec extends AnyFlatSpec with Matchers {

  "A DiscardPile" should "contain no cards when created empty" in {
    val discardPile = DiscardPile.empty
    assert(discardPile.cards.isEmpty)
  }
}
