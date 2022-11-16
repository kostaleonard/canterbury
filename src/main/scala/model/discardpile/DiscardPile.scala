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
case class DiscardPile(cards: List[Card]) {

  /** Returns true if there are no cards in the discard pile. */
  def isEmpty: Boolean = cards.isEmpty

  /** Returns true if there are cards in the discard pile. */
  def nonEmpty: Boolean = !isEmpty
}
