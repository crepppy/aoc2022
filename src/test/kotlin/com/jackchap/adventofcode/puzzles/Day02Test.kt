package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day02Test {

    private val input = Day02.parseInput("""
        A Y
        B X
        C Z
    """.trimIndent())

    @Test
    fun `rock paper scissors part one`() {
        assertEquals(15, Day02.partOne(input))
    }

    @Test
    fun `rock paper scissors part two`() {
        assertEquals(12, Day02.partTwo(input))
    }
}