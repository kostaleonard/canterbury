package model.deck

import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.card.unit.Conquistador
import model.civilization.Rome
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DeckSpec extends AnyFlatSpec with Matchers {

  "A Deck" should "have the correct civilization" in {
    val cards = RomeCapital +: List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)
    val deck = Deck.withInitialCards(cards)
    assert(deck.isSuccess)
    assert(deck.get.civilization == Rome)
  }

  it should "fail to be constructed when provided the wrong number of cards" in {
    val cards = List(RomeCapital)
    val deck = Deck.withInitialCards(cards)
    assert(deck.isFailure)
  }

  it should "fail to be constructed when missing a capital card" in {
    val cards = List.fill(Deck.DECK_SIZE)(TwoFoodCard)
    val deck = Deck.withInitialCards(cards)
    assert(deck.isFailure)
  }

  it should "fail to be constructed if it contains multiple capital cards" in {
    val cards = List(RomeCapital, Madrid) ++ List.fill(Deck.DECK_SIZE - 2)(
      TwoFoodCard
    )
    val deck = Deck.withInitialCards(cards)
    assert(deck.isFailure)
  }

  it should "fail to be constructed if it contains cards that don't match the capital's civilization" in {
    val cards =
      List(RomeCapital, Conquistador) ++ List.fill(Deck.DECK_SIZE - 2)(
        TwoFoodCard
      )
    val deck = Deck.withInitialCards(cards)
    assert(deck.isFailure)
  }

  it should "remove the capital card from the deck so that it can't be drawn" in {
    val cards = RomeCapital +: List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)
    var deck = Deck.withInitialCards(cards).get
    while (deck.nonEmpty) {
      val tup = deck.drawCard
      val card = tup._1
      assert(card != RomeCapital)
      deck = tup._2
    }
  }
}
