package com.jackchap.adventofcode.puzzles

object Day11 : Day<List<Monkey>>(11, "Monkey in the Middle") {
    private val MONKEY_PATTERN = Regex(
        """
        Monkey \d+:
        \s{2}Starting items: ([0-9, ]+)
        \s{2}Operation: new = old ([+*]) (.+)
        \s{2}Test: divisible by (\d+)
        \s{4}If true: throw to monkey (\d+)
        \s{4}If false: throw to monkey (\d+)
    """.trimIndent()
    )

    override fun parseInput(lines: List<String>) =
        MONKEY_PATTERN.findAll(lines.joinToString("\n")).map {
            val (divisor, trueMonkey, falseMonkey) = it.groups.toList().slice(4..6).map { d -> d!!.value.toInt() }

            Monkey(
                it.groups[1]!!.value.split(", ").map(String::toULong).toMutableList(),
                it.groups[2]!!.value,
                it.groups[3]!!.value.toULongOrNull(),
                divisor.toULong(), trueMonkey to falseMonkey
            )
        }.toList()

    private fun simulateRound(monkeys: List<Monkey>, divisor: ULong, sane: Boolean) {
        monkeys.forEach { m ->
            m.items.forEachIndexed { index, i ->
                m.items[index] = if (m.argument == null) i * i
                else if (m.operation == "+") i + m.argument.toULong()
                else (i * m.argument) % divisor
                if (sane) m.items[index] /= 3UL
            }
            m.inspections += m.items.size
            m.items.forEach { i -> monkeys[if (i % m.divisor == 0UL) m.test.first else m.test.second].items += i }
            m.items.clear()
        }
    }

    override fun partOne(input: List<Monkey>) = input.map(Monkey::copy).let { monkeys ->
        val divisor = input.map(Monkey::divisor).reduce(ULong::times)
        repeat(20) { _ -> simulateRound(monkeys, divisor, true) }
        monkeys.map(Monkey::inspections).sortedDescending().let { it[0] * it[1] }
    }

    override fun partTwo(input: List<Monkey>) = input.map(Monkey::copy).let { monkeys ->
        val divisor = input.map(Monkey::divisor).reduce(ULong::times)
        repeat(10000) { _ -> simulateRound(monkeys, divisor, false) }
        monkeys.map(Monkey::inspections).sortedDescending().let { it[0] * it[1] }
    }
}

data class Monkey(
    val items: MutableList<ULong>,
    val operation: String,
    val argument: ULong?,
    val divisor: ULong,
    val test: Pair<Int, Int>
) {
    var inspections = 0L
}