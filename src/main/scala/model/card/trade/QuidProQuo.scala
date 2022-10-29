package model.card.trade

import model.civilization.{Civilization, CivilizationSpecific, Rome}

/** A Quid Pro Quo card. */
object QuidProQuo extends TradeCard with CivilizationSpecific {
  override val name: String = "Quid Pro Quo"
  override val civilization: Civilization = Rome
}
