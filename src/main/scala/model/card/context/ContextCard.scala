package model.card.context

import model.card.Card

/** A context card.
  *
  * Context cards set certain environmental factors such as terrain, weather,
  * and historical atmosphere that affect other actions in the game. Context may
  * be "big" (The Renaissance) or "small" (The Colosseum).
  */
abstract class ContextCard extends Card
