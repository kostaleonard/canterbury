package controller

import model.Model

/** Makes updates to the model based on game rules.
  *
  * @param model
  *   The model representing the game state.
  */
case class Controller(model: Model) {

  /** Returns a new controller with a model that has advanced one turn. */
  def advanceTurn: Controller = copy(model = model.advanceTurn)
}
