package com.jackchap.adventofcode

typealias Coord = Pair<Int, Int>

fun <T> List<List<T>>.rotate(columns: Int) =
    (0 until columns).map { row -> this.mapNotNull { it.getOrNull(row) } }

operator fun Pair<Int, Int>.plus(pair: Pair<Int, Int>) = (first + pair.first) to (second + pair.second)
operator fun Pair<Int, Int>.minus(pair: Pair<Int, Int>) = (first - pair.first) to (second - pair.second)

fun Int.rangeAround(radius: Int) = minus(radius)..plus(radius)