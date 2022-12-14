package com.jackchap.adventofcode

object InputReader {
    fun readDay(dayNumber: Int) =
        javaClass.classLoader.getResourceAsStream("Day$dayNumber.txt")!!.use {
            it.bufferedReader().readText().lines()
        }
}