package model

import model.player.Player

/** Represents the current state of the game.
  *
  * @param players
  *   The players in the game.
  * @param turn
  *   The current turn.
  */
case class Model(players: List[Player], turn: Int)
