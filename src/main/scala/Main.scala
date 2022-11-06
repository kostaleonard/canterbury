import model.Model
import model.board.Board
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.discardpile.DiscardPile
import model.player.Player

/** Runs the game. */
object Main extends App {
  val STARTING_FOOD = 3
  val STARTING_GOLD = 3

  val player1 = Player(
    "Alice",
    Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)),
    DiscardPile.empty,
    STARTING_FOOD,
    STARTING_GOLD
  )
  val player2 = Player(
    "Bob",
    Deck(Madrid, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard)),
    DiscardPile.empty,
    STARTING_FOOD,
    STARTING_GOLD
  )
  var model = Model(List(player1, player2), Board.empty, 0)
  println(model)
}
