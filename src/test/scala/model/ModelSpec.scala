package model

import model.board.Board
import model.card.Card
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.player.Player
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ModelSpec extends AnyFlatSpec with Matchers {
  sealed trait EmptyCard extends Card {
    override val name: String = "Empty"
  }
  case object CardOne extends EmptyCard
  case object CardTwo extends EmptyCard
  case object CardThree extends EmptyCard

  /** Returns a model with two players. */
  private def twoPlayerModelFixture: Model = {
    val player1 = Player(
      "Alice",
      Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    )
    val player2 = Player(
      "Bob",
      Deck(Madrid, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    )
    Model(List(player1, player2), Board.empty, 0)
  }

  "A Model" should "get the active player based on the turn" in {
    val model1 = twoPlayerModelFixture
    assert(model1.getActivePlayer.name == "Alice")
    val model2 = model1.advanceTurn
    assert(model2.getActivePlayer.name == "Bob")
    val model3 = model2.advanceTurn
    assert(model3.getActivePlayer.name == "Alice")
  }

  it should "increment the turn" in {
    val model1 = twoPlayerModelFixture
    val model2 = model1.advanceTurn
    assert(model2.turn == model1.turn + 1)
  }

  it should "remove cards from the top of the deck to draw players' initial hands" in {
    val player1 = Player(
      "Alice",
      Deck(RomeCapital, List(CardOne, CardTwo, CardThree) ++ List.fill(Deck.DECK_SIZE - 4)(TwoFoodCard))
    )
    val player2 = Player(
      "Bob",
      Deck(Madrid, List(CardThree, CardTwo, CardOne) ++ List.fill(Deck.DECK_SIZE - 4)(TwoFoodCard))
    )
    val model1 = Model(List(player1, player2), Board.empty, 0)
    val numCards = 4
    val model2 = model1.drawInitialHands(numCards)
    assert(model2.players.forall(_.hand.size == numCards))
    assert(model2.players.forall(_.deck.numDrawableCards == Deck.DECK_SIZE - numCards - 1))
    assert(model2.players.head.hand.cards == List(TwoFoodCard, CardThree, CardTwo, CardOne))
    assert(model2.players.tail.head.hand.cards == List(TwoFoodCard, CardOne, CardTwo, CardThree))
  }

  it should "apply a card's actions when it is played" in {
    val model1 = twoPlayerModelFixture
    //TODO need hand
    assert(false)
  }
}
