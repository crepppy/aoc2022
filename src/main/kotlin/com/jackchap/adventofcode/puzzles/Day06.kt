package com.jackchap.adventofcode.puzzles

object Day06 : Day<String>(6, "Tuning Trouble") {
    override fun parseInput(lines: List<String>) = lines.first()

    override fun partOne(input: String) =
        4 + input.windowedSequence(4, 1).indexOfFirst { it.chars().distinct().count() == 4L }

    override fun partTwo(input: String) =
        14 + input.windowedSequence(14, 1).indexOfFirst { it.chars().distinct().count() == 14L }
}