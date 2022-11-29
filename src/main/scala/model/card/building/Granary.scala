package model.card.building
import model.card.{CardAction, NetFood, NetGold, PlaceThisCardOnBoard, RemoveThisCardFromHand}

/** A granary card.
  *
  * Granaries provide food resources to players.
  */
case object Granary extends BuildingCard {
  override val name: String = "Granary"

  //TODO need to test now
  override def whenPlayedActions: List[CardAction] = List(RemoveThisCardFromHand, NetGold(-1), PlaceThisCardOnBoard)

  override def everyTurnActions: List[CardAction] = List(NetFood(2))
}
