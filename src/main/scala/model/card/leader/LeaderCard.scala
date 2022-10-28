package model.card.leader

import model.card.Card
import model.civilization.CivilizationSpecific

/** A leader card.
  *
  * Leader cards provide bonuses for certain playstyles, usually associated with
  * the civilization's other cards in some way.
  * */
abstract class LeaderCard extends Card with CivilizationSpecific
