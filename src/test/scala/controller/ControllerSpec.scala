package controller

import model.Model
import model.board.Board
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.player.Player
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ControllerSpec extends AnyFlatSpec with Matchers {

  private def twoPlayerControllerFixture: Controller = {
    val player1 = Player(
      "Alice",
      Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    )
    val player2 = Player(
      "Bob",
      Deck(Madrid, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    )
    val model = Model(List(player1, player2), Board.empty, 0)
    Controller(model)
  }

  "A Controller" should "increment the model's turn" in {
    val controller1 = twoPlayerControllerFixture
    val controller2 = controller1.advanceTurn
    assert(controller2.model.turn == 1)
  }
}
