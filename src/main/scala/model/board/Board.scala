package model.board

import model.card.Card
import model.player.Player

/** The game board. */
object Board {

  /** Returns an empty board. */
  def empty: Board = Board(Map.empty)
}

/** The game board.
  *
  * @param inPlayCards
  *   The cards currently in play.
  */
case class Board(inPlayCards: Map[Player, Card])
