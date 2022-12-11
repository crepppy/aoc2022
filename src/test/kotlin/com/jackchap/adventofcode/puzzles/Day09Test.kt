package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day09Test {

    private val input = Day09.parseInput("""
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent().lines())

    @Test
    fun `rope bridge part one`() {
        assertEquals(13, Day09.partOne(input))
        assertEquals(13, Day09.partOne(input))
    }

    @Test
    fun `rope bridge part two`() {
//        assertEquals(1, Day09.partTwo(input))
        assertEquals(36, Day09.partTwo(Day09.parseInput("""
            R 5
            U 8
            L 8
            D 3
            R 17
            D 10
            L 25
            U 20
        """.trimIndent().lines())))
    }
}