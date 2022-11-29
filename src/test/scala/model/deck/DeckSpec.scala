package model.deck

import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.card.unit.Conquistador
import model.civilization.Rome
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DeckSpec extends AnyFlatSpec with Matchers {

  "A Deck" should "have the correct civilization" in {
    val deck = Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    assert(deck.isValidInitialDeck)
    assert(deck.civilization == Rome)
  }

  it should "be an invalid initial deck when it has fewer cards than the limit" in {
    val deck = Deck(RomeCapital, List.empty)
    assert(!deck.isValidInitialDeck)
  }

  it should "be a valid (non-initial) deck when it has fewer cards than the limit" in {
    val deck = Deck(RomeCapital, List.empty)
    assert(deck.isValidDeck)
  }

  it should "be invalid when it has more cards than the limit" in {
    val deck = Deck(RomeCapital, List.fill(Deck.DECK_SIZE)(TwoFoodCard))
    assert(!deck.isValidInitialDeck)
    assert(!deck.isValidDeck)
  }

  it should "be invalid when it contains multiple capital cards" in {
    val deck =
      Deck(RomeCapital, Madrid +: List.fill(Deck.DECK_SIZE - 2)(TwoFoodCard))
    assert(!deck.isValidInitialDeck)
    assert(!deck.isValidDeck)
  }

  it should "be invalid when it contains cards that don't match the capital's civilization" in {
    val deck = Deck(
      RomeCapital,
      Conquistador +: List.fill(Deck.DECK_SIZE - 2)(TwoFoodCard)
    )
    assert(!deck.isValidInitialDeck)
    assert(!deck.isValidDeck)
  }

  it should "remove the capital card from the deck so that it can't be drawn" in {
    var deck = Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    while (deck.nonEmpty) {
      val tup = deck.drawCard
      val card = tup._1
      assert(card != RomeCapital)
      deck = tup._2
    }
  }

  it should "know how many drawable cards it contains" in {
    val deck1 = Deck(RomeCapital, List.empty)
    assert(deck1.numDrawableCards == 0)
    val deck2 = Deck(RomeCapital, List(Conquistador, Conquistador))
    assert(deck2.numDrawableCards == 2)
  }
}
