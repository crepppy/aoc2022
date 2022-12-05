package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day04Test {

    private val input = Day04.parseInput("""
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent())

    @Test
    fun `camp cleanup part one`() {
        assertEquals(2, Day04.partOne(input))
    }

    @Test
    fun `camp cleanup part two`() {
        assertEquals(4, Day04.partTwo(input))
    }
}