package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day03Test {

    private val input = Day03.parseInput("""
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent().lines())


    @Test
    fun `rucksack reorganization part one`() {
        assertEquals(157, Day03.partOne(input))
    }

    @Test
    fun `rucksack reorganization part two`() {
        assertEquals(70, Day03.partTwo(input))
    }
}