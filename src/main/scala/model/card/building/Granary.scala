package model.card.building
import model.card.{CardAction, NetFood, NetGold}

/** A granary card.
  *
  * Granaries provide food resources to players.
  */
case object Granary extends BuildingCard {
  override val name: String = "Granary"

  override def whenPlayedActions: List[CardAction] = List(NetGold(-1))

  override def everyTurnActions: List[CardAction] = List(NetFood(2))
}
