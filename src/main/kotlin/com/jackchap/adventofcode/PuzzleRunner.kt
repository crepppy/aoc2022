package com.jackchap.adventofcode

import com.jackchap.adventofcode.puzzles.Day

fun main() {
    Day::class.sealedSubclasses.mapNotNull { it.objectInstance }.forEach {
        println("""
            ---
            Day ${it.number}: ${it.name}
            Part 1: ${it.runPartOne()}
            Part 2: ${it.runPartTwo()}
            
        """.trimIndent())
    }
}