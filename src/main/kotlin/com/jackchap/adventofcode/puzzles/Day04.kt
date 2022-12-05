package com.jackchap.adventofcode.puzzles

typealias SectionAssignments = List<Pair<IntRange, IntRange>>

object Day04 : Day<SectionAssignments>(4, "Camp Cleanup") {
    private val SECTION_MATCHER = Regex("(\\d+)-(\\d+),(\\d+)-(\\d+)")

    private operator fun <T: Comparable<T>> Iterable<T>.contains(range: Iterable<T>) =
        first() in range && last() in range

    private fun <T: Comparable<T>> Iterable<T>.containsAny(range: Iterable<T>) =
        first() in range || last() in range

    override fun parseInput(lines: List<String>) = lines.mapNotNull {
        SECTION_MATCHER.matchEntire(it)?.groupValues?.mapNotNull(String::toIntOrNull)?.let { matches ->
            matches[0]..matches[1] to matches[2]..matches[3]
        }
    }

    override fun partOne(input: SectionAssignments) =
        input.count { it.first in it.second || it.second in it.first }

    override fun partTwo(input: SectionAssignments) =
        input.count { it.first.containsAny(it.second) || it.second.containsAny(it.first) }
}