import model.Model
import model.board.Board
import model.card.capital.{Madrid, RomeCapital}
import model.card.resource.TwoFoodCard
import model.deck.Deck
import model.player.Player

/** Runs the game. */
object Main extends App {
  val player1 = Player(
    "Alice",
    Deck(RomeCapital, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
  )
  val player2 = Player(
    "Bob",
    Deck(Madrid, List.fill(Deck.DECK_SIZE - 1)(TwoFoodCard))
  )
  val model = Model(List(player1, player2), Board.empty, 0)
  println(model)
}
