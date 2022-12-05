package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day05Test {

    private val input = Day05.parseInput("""
        |    [D]    
        |[N] [C]    
        |[Z] [M] [P]
        | 1   2   3 
        |
        |move 1 from 2 to 1
        |move 3 from 1 to 3
        |move 2 from 2 to 1
        |move 1 from 1 to 2
    """.trimMargin().lines())

    @Test
    fun `supply stacks part one`() {
        assertEquals("CMZ", Day05.partOne(input))
    }

    @Test
    fun `supply stacks part two`() {
        assertEquals("MCD", Day05.partTwo(input))
    }
}