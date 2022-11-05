package model.card.unit

import model.civilization.{Civilization, CivilizationSpecific, Spain}

/** A conquistador card. */
case object Conquistador extends UnitCard with CivilizationSpecific {
  override val name: String = "Conquistador"
  override val civilization: Civilization = Spain
}
