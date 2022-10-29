package model.civilization

/** A civilization.
  *
  * Certain cards are tied to a specific civilization. Leader cards and capital
  * cards, for instance, are civilization-specific. Other cards may be
  * civilization-specific.
  *
  * The player must have civilization-specific cards belonging to exactly one
  * civilization, as well as civilization-generic cards. At the least, the
  * player must have a capital, which is civilization-specific.
  */
sealed trait Civilization {
  val name: String
}

case object Rome extends Civilization {
  override val name: String = "Rome"
}
