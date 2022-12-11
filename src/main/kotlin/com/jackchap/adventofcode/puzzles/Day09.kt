package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.minus
import com.jackchap.adventofcode.plus
import com.jackchap.adventofcode.rangeAround

object Day09 : Day<List<Direction>>(9, "Rope Bridge") {
    override fun parseInput(lines: List<String>): List<Direction> {
        return lines.map { it.first() to it.drop(2).toInt() }.flatMap { (direction, number) ->
            List(number) {
                when (direction) {
                    'U' -> Direction.UP
                    'D' -> Direction.DOWN
                    'L' -> Direction.LEFT
                    'R' -> Direction.RIGHT
                    else -> throw IllegalStateException("Invalid direction given")
                }
            }
        }
    }

    private fun uniqueTailLocations(ropeSize: Int, instructions: List<Direction>): Int {
        val rope = MutableList(ropeSize) { 0 to 0 }

        return instructions.fold(setOf(rope.last())) { previousLocations, direction ->
            rope.drop(1).also { rope[0] += direction.vector }.forEachIndexed { index, tail ->
                val head = rope[index]
                if (tail.first !in head.first.rangeAround(1) || tail.second !in head.second.rangeAround(1)) {
                    rope[index + 1] = tail + (head - tail).let { (x, y) -> x.coerceIn(-1..1) to y.coerceIn(-1..1) }
                }
            }

            previousLocations + rope.last()
        }.size
    }

    override fun partOne(input: List<Direction>) = uniqueTailLocations(2, input)

    override fun partTwo(input: List<Direction>) = uniqueTailLocations(10, input)
}

enum class Direction(val vector: Pair<Int, Int>) {
    UP(0 to 1),
    DOWN(0 to -1),
    LEFT(-1 to 0),
    RIGHT(1 to 0),
}