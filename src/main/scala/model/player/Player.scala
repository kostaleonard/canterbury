package model.player

import model.deck.Deck
import model.discardpile.DiscardPile

/** A player in the game.
  *
  * @param name
  *   The name of the player.
  * @param deck
  *   The player's deck.
  * @param discardPile
  *   The player's discard pile.
  */
case class Player(name: String, deck: Deck, discardPile: DiscardPile, food: Int, gold: Int)
