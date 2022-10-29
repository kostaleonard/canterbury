package model.deck

import model.card.capital.RomeCapital
import model.card.resource.TwoFoodCard
import model.civilization.Rome
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DeckSpec extends AnyFlatSpec with Matchers {

  "A Deck" should "have the correct civilization" in {
    val cards = RomeCapital +: List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)
    val deck = Deck.withCards(cards)
    assert(deck.isSuccess)
    assert(deck.get.civilization == Rome)
  }

  it should "fail to be constructed when provided the wrong number of cards" in {
    val cards = List(RomeCapital)
    val deck = Deck.withCards(cards)
    assert(deck.isFailure)
  }

  it should "fail to be constructed when missing a capital card" in {
    val cards = List.fill(Deck.DECK_SIZE)(TwoFoodCard)
    val deck = Deck.withCards(cards)
    assert(deck.isFailure)
  }

  it should "fail to be constructed if it contains multiple capital cards" in {
    val cards = List(RomeCapital, RomeCapital) ++ List.fill(Deck.DECK_SIZE - 2)(
      TwoFoodCard
    )
    val deck = Deck.withCards(cards)
    assert(deck.isFailure)
  }
}
