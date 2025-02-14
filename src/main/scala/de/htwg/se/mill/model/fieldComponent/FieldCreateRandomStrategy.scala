package de.htwg.se.mill.model.fieldComponent

import de.htwg.se.mill.model.fieldComponent.{Cell, Field}

import scala.util.Random

class FieldCreateRandomStrategy extends FieldCreateStrategyTemplate:

  def fill(_field: Field): Field =
    val num = 18
    var field = new Field(_field.size)
    for (i <- 0 until num) {
      field = placeRandomStone(field)
    }
    field

  private def placeRandomStone (field: Field): Field =
    var row = 0
    var col = 0
    while (!field.available(row, col))
    do
      row = Random.nextInt(field.size)
      col = Random.nextInt(field.size)
    if (Random.nextInt(2) == 0) then
      field.set(row, col, Cell("cw"))._1
    else
      field.set(row, col, Cell("cb"))._1
    