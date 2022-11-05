package model.deck

import exceptions.InvalidDeckException
import model.card.Card
import model.card.capital.CapitalCard
import model.civilization.{Civilization, CivilizationSpecific}

import scala.util.{Failure, Success, Try}

/** Deck companion object. */
object Deck {
  val DECK_SIZE = 60

  /** Returns a new Deck containing the given cards.
    *
    * @param cards
    *   The cards in the deck. There must initially be exactly DECK_SIZE cards
    *   in the deck, including exactly one capital card defining the
    *   civilization.
    * @return
    *   A new Deck containing the given cards. Fails if there are not DECK_SIZE
    *   cards, if there is not exactly one capital card, or if the deck contains
    *   cards from multiple civilizations.
    */
  def withInitialCards(cards: List[Card]): Try[Deck] = {
    val partition = cards.partition {
      case _: CapitalCard => true
      case _              => false
    }
    val capitalCards = partition._1
    val drawableCards = partition._2
    if (capitalCards.length != 1)
      Failure(
        new InvalidDeckException("A deck must have exactly one capital card")
      )
    else
      withInitialCardsPartitioned(
        capitalCards.head.asInstanceOf[CapitalCard],
        drawableCards
      )
  }

  /** Returns a new Deck containing the given cards.
    *
    * @param capitalCard
    *   The capital card.
    * @param drawableCards
    *   The cards in the deck that can be drawn; excludes the capital card.
    * @return
    *   A new Deck containing the given cards. Fails if there are not DECK_SIZE
    *   cards or if the deck contains cards from multiple civilizations.
    */
  def withInitialCardsPartitioned(
      capitalCard: CapitalCard,
      drawableCards: List[Card]
  ): Try[Deck] =
    if (drawableCards.length != DECK_SIZE - 1)
      Failure(
        new InvalidDeckException(s"A deck must have exactly $DECK_SIZE cards")
      )
    else if (getUniqueCivilizations(capitalCard +: drawableCards).size != 1)
      Failure(
        new InvalidDeckException("A deck must have exactly one civilization")
      )
    else Success(new Deck(capitalCard, drawableCards))

  /** Returns the set of unique civilizations represented in the cards.
    *
    * @param cards
    *   The cards to filter.
    */
  private def getUniqueCivilizations(cards: List[Card]): Set[Civilization] =
    cards.collect { case card: CivilizationSpecific =>
      card.civilization
    }.toSet
}

/** A deck of cards.
  *
  * There must initially be exactly DECK_SIZE cards in the deck, including
  * exactly one capital card defining the civilization.
  *
  * @param capitalCard
  *   The capital card.
  * @param drawableCards
  *   The cards in the deck that can be drawn; excludes the capital card.
  */
class Deck private (capitalCard: CapitalCard, drawableCards: List[Card])
    extends CivilizationSpecific {
  override val civilization: Civilization = capitalCard.civilization

  /** Returns the top card and a new deck with the top card removed. */
  def drawCard: (Card, Deck) = (head, new Deck(capitalCard, drawableCards.tail))

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
}
