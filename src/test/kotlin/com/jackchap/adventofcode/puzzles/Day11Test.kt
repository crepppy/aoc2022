package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.InputReader
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day11Test {

    private val input = Day11.parseInput(InputReader.readDay(11))

    @Test
    fun `monkey in the middle part one`() {
        assertEquals(10605, Day11.partOne(input))
    }

    @Test
    fun `monkey in the middle part two`() {
        assertEquals(2713310158, Day11.partTwo(input))
    }
}