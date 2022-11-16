package model

import model.board.Board
import model.card.Card
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

  /** Returns the model advanced one turn. */
  def advanceTurn: Model = copy(turn = turn + 1)

  /** Returns the model after playing the card.
    *
    * @param card
    *   The card to play. This card belongs to the current player.
    */
  def playCard(card: Card): Model = ???
}
