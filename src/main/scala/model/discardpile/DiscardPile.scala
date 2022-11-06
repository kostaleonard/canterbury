package model.discardpile

import model.card.Card

/** A discard pile. */
object DiscardPile {

  /** Returns an empty discard pile. */
  def empty: DiscardPile = DiscardPile(List.empty)
}

/** A discard pile.
  *
  * @param cards
  *   The cards in the pile.
  */
case class DiscardPile(cards: List[Card])
