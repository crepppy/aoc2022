package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private const val DOLLAR = "$"

class Day07Test {
    private val input = Day07.parseInput("""
        $DOLLAR cd /
        $DOLLAR ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $DOLLAR cd a
        $DOLLAR ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $DOLLAR cd e
        $DOLLAR ls
        584 i
        $DOLLAR cd ..
        $DOLLAR cd ..
        $DOLLAR cd d
        $DOLLAR ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent().lines())

    @Test
    fun partOne() {
        assertEquals(95437, Day07.partOne(input))
    }

    @Test
    fun partTwo() {
        assertEquals(24933642, Day07.partTwo(input))
    }
}