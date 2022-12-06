package com.jackchap.adventofcode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day06Test {

    @Test
    fun `tuning trouble part one`() {
        assertEquals(7, Day06.partOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, Day06.partOne("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, Day06.partOne("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, Day06.partOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, Day06.partOne("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun `tuning trouble part two`() {
        assertEquals(19, Day06.partTwo("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, Day06.partTwo("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, Day06.partTwo("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, Day06.partTwo("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, Day06.partTwo("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}