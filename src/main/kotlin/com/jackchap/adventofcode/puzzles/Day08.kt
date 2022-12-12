package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.rotate
import kotlin.math.max

typealias TreeMap = List<List<Int>>

// TODO: Refactor this mess

object Day08 : Day<TreeMap>(8, "Treetop Tree House") {
    override fun parseInput(lines: List<String>) = lines.map { it.toCharArray().map(Char::digitToInt) }

    private fun scanForwards(row: List<IndexedValue<Int>>, y: Int): Set<Pair<Int, Int>> {
        var high = -1
        return row.asSequence()
            .filter { (_, h) -> (h > high).also { _ -> high = max(high, h) } }
            .map { it.index to y }
            .toSet()
    }

    private fun <T> List<T>.reverseScan() = reversed().mapIndexed { index, i -> IndexedValue(size - index - 1, i) }

    private fun scanRow(row: List<Int>, y: Int, function: (List<IndexedValue<Int>>, Int) -> Set<Pair<Int, Int>>) =
        function(row.withIndex().toList(), y).union(function(row.reverseScan(), y))

    private fun scanGrid(input: TreeMap) = input.flatMapIndexed { y, row ->
        scanRow(row, y, ::scanForwards)
    }.union(input.rotate(input[0].size).flatMapIndexed { y, row ->
        scanRow(row, y, ::scanForwards).map { (y, x) -> x to y }
    })

    private fun closestTree(row: List<Int>, height: Int, startIndex: Int): Int {
        return row.drop(startIndex + 1).dropLast(1).takeWhile { it < height }.count()+1
    }

    override fun partOne(input: TreeMap) = scanGrid(input).size

    override fun partTwo(input: TreeMap): Int {
        val rotated = input.rotate(input[0].size)
        return ((1..input.size - 2).flatMap { y -> (1..input[0].size - 2).map { it to y } }).maxOf { (x, y) ->
            closestTree(input[y], input[y][x], x) * closestTree(input[y].reversed(), input[y][x], input[y].size-x-1) *
                    closestTree(rotated[x], input[y][x], y) * closestTree(rotated[x].reversed(), input[y][x], input.size - y-1)
        }
    }
}