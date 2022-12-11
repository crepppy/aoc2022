package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.InputReader
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10Test {

    private val input = Day10.parseInput(InputReader.readDay(10))

    @Test
    fun `cathode-ray tube part one`() {
        assertEquals(13140, Day10.partOne(input))
    }

    @Test
    fun `cathode-ray tube part two`() {
        assertEquals("""
            
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######.....
        """.trimIndent(), Day10.partTwo(input))
    }
}