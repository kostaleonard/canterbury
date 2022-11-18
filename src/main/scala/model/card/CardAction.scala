package model.card

/** The actions that cards cause. */
sealed trait CardAction

/** A net change in food, positive or negative. */
case class NetFood(amount: Int) extends CardAction

/** A net change in gold, positive or negative. */
case class NetGold(amount: Int) extends CardAction
