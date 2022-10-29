package model.card.capital
import model.civilization.{Civilization, Rome}

/** A Rome card. */
object RomeCapital extends CapitalCard {
  override val name: String = "Rome"
  override val civilization: Civilization = Rome
}
