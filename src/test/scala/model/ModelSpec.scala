package model

import model.board.Board
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.player.Player
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ModelSpec extends AnyFlatSpec with Matchers {

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
}
