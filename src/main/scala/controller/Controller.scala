package controller

import model.Model
import model.card.Card

/** Makes updates to the model based on game rules.
  *
  * @param model
  *   The model representing the game state.
  */
case class Controller(model: Model) {

  /** Returns a new controller with a model that has advanced one turn. */
  def advanceTurn: Controller = copy(model = model.advanceTurn)

  /** Returns a new controller with the model after playing the card.
    *
    * @param card
    *   The card to play. This card belongs to the current player.
    */
  def playCard(card: Card): Controller = ???
}
