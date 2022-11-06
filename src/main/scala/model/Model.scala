package model

import model.board.Board
import model.player.Player

/** Represents the current state of the game.
  *
  * @param players
  *   The players in the game.
  * @param board
  *   The game board.
  * @param turn
  *   The current turn.
  */
case class Model(players: List[Player], board: Board, turn: Int)
