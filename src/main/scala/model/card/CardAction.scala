package model.card

sealed trait CardAction

case class NetFood(amount: Int) extends CardAction
case class NetGold(amount: Int) extends CardAction
