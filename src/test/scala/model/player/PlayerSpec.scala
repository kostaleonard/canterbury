package model.player

import model.card.capital.RomeCapital
import model.card.resource.TwoFoodCard
import model.deck.Deck
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyFlatSpec with Matchers {

  private def defaultPlayerFixture: Player = Player(
      "Alice",
      Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
    )

  "A player" should "have an empty discard pile by default" in {
    val player = defaultPlayerFixture
    assert(player.discardPile.isEmpty)
  }

  it should "have the expected starting food by default" in {
    val player = defaultPlayerFixture
    assert(player.food == Player.STARTING_FOOD)
  }

  it should "have the expected starting gold by default" in {
    val player = defaultPlayerFixture
    assert(player.gold == Player.STARTING_GOLD)
  }
}
