package model.deck

import model.card.Card
import model.card.capital.CapitalCard
import model.civilization.{Civilization, CivilizationSpecific}
import model.deck.Deck.DECK_SIZE

/** A deck of cards. */
object Deck {
  val DECK_SIZE = 60
}

/** A deck of cards.
  *
  * There must initially be exactly DECK_SIZE cards in the deck, including
  * exactly one capital card defining the civilization. Cards may be
  * civilization-generic or match the civilization of the capital card.
  *
  * @param capitalCard
  *   The capital card.
  * @param drawableCards
  *   The cards in the deck that can be drawn; excludes the capital card.
  */
case class Deck(capitalCard: CapitalCard, drawableCards: List[Card])
    extends CivilizationSpecific {
  override val civilization: Civilization = capitalCard.civilization

  /** Returns true if the deck is in a valid start game state, false otherwise.
    *
    * To be valid in the start game state, a deck must satisfy the following
    * properties.
    *   1. It must have exactly DECK_SIZE cards, including the capital card.
    *   1. There must be exactly one capital card.
    *   1. All civilization-specific cards in the deck must match the capital
    *      card's civilization.
    */
  def isValidInitialDeck: Boolean =
    drawableCards.length == DECK_SIZE - 1 && isValidDeck

  /** Returns true if the deck is in a valid state, false otherwise.
    *
    * To be valid, a deck must satisfy the following properties.
    *   1. It must have DECK_SIZE or fewer cards, including the capital card.
    *   1. There must be exactly one capital card.
    *   1. All civilization-specific cards in the deck must match the capital
    *      card's civilization.
    */
  def isValidDeck: Boolean =
    drawableCards.length <= DECK_SIZE - 1 &&
      drawableCardsContainNoCapitalCards &&
      drawableCardsMatchCapitalCardCivilization

  /** Returns true if the drawable cards contain no capital cards. */
  private def drawableCardsContainNoCapitalCards: Boolean =
    drawableCards.forall {
      case _: CapitalCard => false
      case _              => true
    }

  /** Returns true if the drawable cards match the capital card civilization. */
  private def drawableCardsMatchCapitalCardCivilization: Boolean =
    drawableCards.forall {
      case civilizationSpecific: CivilizationSpecific =>
        civilizationSpecific.civilization == capitalCard.civilization
      case _ => true
    }

  /** Returns the top card and a new deck with the top card removed. */
  def drawCard: (Card, Deck) = (head, Deck(capitalCard, drawableCards.tail))

  /** Returns the card on top of the deck. */
  def head: Card = drawableCards.head

  /** Optionally returns the card on top of the deck. */
  def headOption: Option[Card] = drawableCards.headOption

  /** Returns all cards after the top card. */
  def tail: List[Card] = drawableCards.tail

  /** Returns true if the deck is empty, false otherwise. */
  def isEmpty: Boolean = drawableCards.isEmpty

  /** Returns false if the deck is empty, true otherwise. */
  def nonEmpty: Boolean = !isEmpty

  /** Returns the number of drawable cards in the deck. */
  def numDrawableCards: Int = drawableCards.length
}
