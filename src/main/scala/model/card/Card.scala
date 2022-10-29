package model.card

/** A playing card.
  *
  * Cards are the central element of the game. Players build decks out of cards.
  * Each card produces effects or sets conditions in the game.
  */
abstract class Card {
  val name: String
}
