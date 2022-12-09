package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day08Test {

    private val input = Day08.parseInput("""
        30373
        25512
        65332
        33549
        35390
    """.trimIndent().lines())

    @Test
    fun `treetop tree house part one`() {
        assertEquals(21, Day08.partOne(input))
    }

    @Test
    fun `treetop tree house part two`() {
        assertEquals(8, Day08.partTwo(input))
    }
}