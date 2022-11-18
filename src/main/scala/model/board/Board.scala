package model.board

import model.card.Card

/** The game board. */
object Board {

  /** Returns an empty board. */
  def empty: Board = Board(Set.empty)
}

/** The game board.
  *
  * @param inPlayCards
  *   The cards currently in play.
  */
case class Board(inPlayCards: Set[Card])
