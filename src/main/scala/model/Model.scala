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
  *   The current turn. The active player is the player in [[players]] at this
  *   index modulo the number of players.
  */
case class Model(players: List[Player], board: Board, turn: Int) {

  /** Returns the player whose turn it is. */
  def getActivePlayer: Player = players(turn % players.length)
}
