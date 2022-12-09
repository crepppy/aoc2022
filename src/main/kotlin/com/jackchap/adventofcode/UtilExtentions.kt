package com.jackchap.adventofcode

fun <T> List<List<T>>.rotate(columns: Int) =
    (0 until columns).map { row -> this.mapNotNull { it.getOrNull(row) } }