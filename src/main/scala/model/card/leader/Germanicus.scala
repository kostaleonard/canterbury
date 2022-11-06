package model.card.leader
import model.civilization.{Civilization, Rome}

/** A Germanicus card. */
case object Germanicus extends LeaderCard {
  override val name: String = "Germanicus"
  override val civilization: Civilization = Rome
}
