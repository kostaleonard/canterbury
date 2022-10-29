package model.card.capital
import model.civilization.{Civilization, Spain}

/** A Madrid card. */
object Madrid extends CapitalCard {
  override val name: String = "Madrid"
  override val civilization: Civilization = Spain
}
