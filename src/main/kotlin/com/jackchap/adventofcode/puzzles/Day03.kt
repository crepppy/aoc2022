package com.jackchap.adventofcode.puzzles

typealias Rucksacks = List<CharArray>

object Day03 : Day<Rucksacks>(3, "Rucksack Reorganization") {
    override fun parseInput(input: String) =
        input.lines().map(String::toCharArray)

    private val Char.priority
        get() = if (this >= 'a') this - 'a' + 1 else this - 'A' + 27

    override fun partOne(input: Rucksacks) = input
        .map { it.take(it.size / 2) to it.drop(it.size / 2) }
        .map { it.first.intersect(it.second.toSet()).single() }
        .sumOf { it.priority }

    override fun partTwo(input: Rucksacks) = input
        .chunked(3)
        .map { it[0].intersect(it[1].intersect(it[2].toSet())).single() }
        .sumOf { it.priority }
}