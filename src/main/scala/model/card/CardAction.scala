package model.card

/** The actions that cards cause. */
sealed trait CardAction

/** The card is removed from the player's hand. */
case object RemoveThisCardFromHand extends CardAction

/** The card is placed on the board and remains active until removed. */
case object PlaceThisCardOnBoard extends CardAction

/** The card is placed in the player's discard pile. */
case object DiscardThisCard extends CardAction

/** A net change in food, positive or negative. */
case class NetFood(amount: Int) extends CardAction

/** A net change in gold, positive or negative. */
case class NetGold(amount: Int) extends CardAction
