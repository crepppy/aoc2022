package com.jackchap.adventofcode.puzzles

import com.jackchap.adventofcode.rotate

typealias CargoStacks = List<List<Char>>

object Day05 : Day<Pair<CargoStacks, List<Instruction>>>(5, "Supply Stacks") {
    private fun <T> MutableList<List<T>>.prependFrom(
        to: Int,
        from: Int,
        take: Int,
        transform: (List<T>) -> List<T> = { it }
    ) {
        this[to] = transform(this[from]
            .take(take)
            .also { this[from] = get(from).drop(take) }) + this[to]
    }


    override fun parseInput(lines: List<String>): Pair<CargoStacks, List<Instruction>> {
        val horizontalStacks = lines.takeWhile(String::isNotBlank).dropLast(1)
        val numberOfStacks = lines[horizontalStacks.size].trim().takeLastWhile { it != ' ' }.toInt()

        val stacks = horizontalStacks.map { stack ->
            stack.toCharArray().filterIndexed { index, _ -> (index - 1) % 4 == 0 }
        }.rotate(numberOfStacks).map { it.filterNot(Char::isWhitespace) }

        val instructions = lines.drop(horizontalStacks.size + 2).map {
            it.split(" ").let { words -> Instruction(words[1].toInt(), words[3].toInt(), words[5].toInt()) }
        }

        return stacks to instructions
    }

    private fun moveCrates(input: Pair<CargoStacks, List<Instruction>>, method: (List<Char>) -> List<Char> = { it }) =
        input.first.toMutableList().apply {
            input.second.forEach { instruction ->
                prependFrom(instruction.to - 1, instruction.from - 1, instruction.take, method)
            }
        }.joinToString("") { "${it.getOrNull(0) ?: " "}" }

    override fun partOne(input: Pair<CargoStacks, List<Instruction>>) = moveCrates(input) { it.reversed() }

    override fun partTwo(input: Pair<CargoStacks, List<Instruction>>) = moveCrates(input)
}

data class Instruction(
    val take: Int,
    val from: Int,
    val to: Int
)