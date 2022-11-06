import model.Model
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.discardpile.DiscardPile
import model.player.Player

/** Runs the game. */
object Main extends App {
  val player1 = Player(
    "Alice",
    Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)),
    DiscardPile.empty
  )
  val player2 = Player(
    "Bob",
    Deck(Madrid, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)),
    DiscardPile.empty
  )
  var model = Model(List(player1, player2), 0)
  println(model)
}
