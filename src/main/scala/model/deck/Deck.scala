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
    *   The cards in the deck. There must be exactly DECK_SIZE cards in the
    *   deck, including exactly one capital card defining the civilization.
    * @return
    *   A new Deck containing the given cards. Fails if there are not DECK_SIZE
    *   cards, or if there is not exactly one capital card.
    */
  def withCards(cards: List[Card]): Try[Deck] = {
    if (cards.length != DECK_SIZE)
      Failure(
        new InvalidDeckException(s"A deck must have exactly $DECK_SIZE cards")
      )
    else if (getCapitalCards(cards).length != 1)
      Failure(
        new InvalidDeckException("A deck must have exactly one capital card")
      )
    else if (getUniqueCivilizations(cards).size != 1)
      Failure(
        new InvalidDeckException("A deck must have exactly one civilization")
      )
    else Success(new Deck(cards))
  }

  /** Returns a list of the capital cards from the list of cards.
    *
    * @param cards
    *   The cards to filter.
    */
  private def getCapitalCards(cards: List[Card]): List[CapitalCard] =
    cards.collect { case capitalCard: CapitalCard =>
      capitalCard
    }

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
  * @param cards
  *   The cards in the deck. There must be exactly DECK_SIZE cards in the deck,
  *   including exactly one capital card defining the civilization.
  */
class Deck private (cards: List[Card]) extends CivilizationSpecific {
  val capitalCard: CapitalCard = Deck.getCapitalCards(cards).head
  override val civilization: Civilization = capitalCard.civilization
}
