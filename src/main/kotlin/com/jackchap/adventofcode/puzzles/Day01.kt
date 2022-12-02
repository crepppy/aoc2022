package com.jackchap.adventofcode.puzzles

private typealias Inventory = List<List<Int>>

object Day01 : Day<Inventory>(1, "Calorie Counting") {
    private val SPLIT_PATTERN = Regex("^\\s+", RegexOption.MULTILINE)

    override fun parseInput(input: String) = input.split(SPLIT_PATTERN).map { it.lines().mapNotNull(String::toIntOrNull) }

    override fun partOne(input: Inventory) = input.maxOfOrNull { it.sum() }

    override fun partTwo(input: Inventory) = input.map { it.sum() }.sortedDescending().take(3).sum()
}