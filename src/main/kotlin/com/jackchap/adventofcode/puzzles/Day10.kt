package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.rangeAround

object Day10 : Day<List<Pair<String, Int?>>>(10, "Cathode-Ray Tube") {
    override fun parseInput(lines: List<String>): List<Pair<String, Int?>> =
        lines.map { it.split(" ", limit = 2) }.map { it[0] to it.getOrNull(1)?.toInt() }

    private fun createCycleList(operations: List<Pair<String, Int?>>) = buildList {
        operations.fold(1) { x, (op, num) ->
            add(x)
            if (op == "addx") {
                add(x)
                x + num!!
            } else x
        }
    }

    override fun partOne(input: List<Pair<String, Int?>>) = createCycleList(input)
        .filterIndexed { index, _ -> index % 40 == 19 }
        .withIndex()
        .sumOf { (index, value) -> (index * 40 + 20) * value }

    override fun partTwo(input: List<Pair<String, Int?>>) = "\n" + createCycleList(input)
        .mapIndexed { index, pos -> if (pos % 40 in (index % 40).rangeAround(1)) '#' else '.' }
        .chunked(40)
        .joinToString("\n") { it.joinToString("") }

}