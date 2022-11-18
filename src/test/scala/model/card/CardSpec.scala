package model.card

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CardSpec extends AnyFlatSpec with Matchers {
  case object EmptyCard extends Card {
    override val name: String = "Empty"
  }

  "A Card" should "have no default actions when played" in {
    assert(EmptyCard.whenPlayedActions.isEmpty)
  }

  it should "have no default actions every turn" in {
    assert(EmptyCard.everyTurnActions.isEmpty)
  }
}
