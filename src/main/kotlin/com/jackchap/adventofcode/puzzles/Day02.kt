package com.jackchap.adventofcode.puzzles

typealias StrategyGuide = List<Pair<Char, Char>>

object Day02 : Day<StrategyGuide>(2, "Rock Paper Scissors") {
    override fun parseInput(input: String) =
        input.lines().map { it.toCharArray().let { c -> c[0] + 23 to c[2] } }

    private fun winningChar(char: Char): Char = when (char) {
        'X' -> 'Y'
        'Y' -> 'Z'
        'Z' -> 'X'
        else -> throw IllegalStateException()
    }

    override fun partOne(input: StrategyGuide) = input.fold(0) { acc, (theirs, response) ->
        acc + (response - 'W') + when (response) {
            theirs -> 3
            winningChar(theirs) -> 6
            else -> 0
        }
    }

    override fun partTwo(input: StrategyGuide) = partOne(input.map {
        it.first to when (it.second) {
            'X' -> winningChar(winningChar(it.first))
            'Y' -> it.first
            'Z' -> winningChar(it.first)
            else -> throw IllegalStateException()
        }
    })

}