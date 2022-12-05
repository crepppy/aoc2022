package com.jackchap.adventofcode.puzzles

typealias StrategyGuide = List<Pair<Sign, Sign>>

object Day02 : Day<StrategyGuide>(2, "Rock Paper Scissors") {
    override fun parseInput(lines: List<String>) =
        lines.map { it.toCharArray().let { c -> Sign.values()[c[0] - 'A'] to Sign.values()[c[2] - 'X'] } }

    override fun partOne(input: StrategyGuide) = input.sumOf { (theirs, response) ->
        response.score + when (response) {
            theirs -> 3
            theirs.winningSign -> 6
            else -> 0
        }
    }

    override fun partTwo(input: StrategyGuide) = partOne(input.map {
        it.first to when (it.second) {
            Sign.PAPER -> it.first
            Sign.SCISSORS -> it.first.winningSign
            Sign.ROCK -> it.first.winningSign.winningSign
        }
    })

}

enum class Sign(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    val winningSign
        get() = when(this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
}