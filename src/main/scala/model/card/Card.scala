package model.card

/** A playing card.
  *
  * Cards are the central element of the game. Players build decks out of cards.
  * Each card produces effects or sets conditions in the game.
  */
abstract class Card {
  val name: String

  /** Returns the actions that should occur when the card is played.
    *
    * Actions are in order. Subclasses may override.
    */
  def whenPlayedActions: List[CardAction] = List.empty

  /** Returns the actions that should occur every turn that the card is in play.
    *
    * Actions are in order. Subclasses may override.
    */
  def everyTurnActions: List[CardAction] = List.empty
}
