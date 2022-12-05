package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.InputReader

sealed class Day<T>(val number: Int, val name: String) {
    abstract fun parseInput(lines: List<String>): T

    abstract fun partOne(input: T): Any?

    abstract fun partTwo(input: T): Any?

    fun runPartOne() = partOne(parseInput(InputReader.readDay(number)))
    fun runPartTwo() = partTwo(parseInput(InputReader.readDay(number)))
}