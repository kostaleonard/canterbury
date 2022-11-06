package model.card.unit

import model.civilization.{Civilization, CivilizationSpecific, Rome}

/** A legion card. */
case object Legion extends UnitCard with CivilizationSpecific {
  override val name: String = "Legion"
  override val civilization: Civilization = Rome
}
