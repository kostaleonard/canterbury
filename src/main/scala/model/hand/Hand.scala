package model.hand

import model.card.Card

/** A hand of cards. */
case object Hand {

  /** Returns an empty hand. */
  def empty: Hand = Hand(List.empty)
}

/** A hand of cards.
  *
  * @param cards
  *   The cards in the hand. Order matters for display purposes and,
  *   potentially, the effects of some cards (e.g., "your opponent discards the
  *   top card in their hand").
  */
case class Hand(cards: List[Card]) {

  /** Returns true if there are no cards in the hand. */
  def isEmpty: Boolean = cards.isEmpty

  /** Returns true if there are cards in the hand. */
  def nonEmpty: Boolean = !isEmpty
}
