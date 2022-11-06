package model.board

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BoardSpec extends AnyFlatSpec with Matchers {

  "A Board" should "contain no cards when created empty" in {
    val board = Board.empty
    assert(board.inPlayCards.isEmpty)
  }
}
