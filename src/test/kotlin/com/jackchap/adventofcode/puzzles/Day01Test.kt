package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day01Test {

    private val input = Day01.parseInput("""
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
        """.trimIndent())

    @Test
    fun `calorie counting part one`() {
        assertEquals(24000, Day01.partOne(input))
    }

    @Test
    fun `calorie counting part two`() {
        assertEquals(45000, Day01.partTwo(input))
    }
}