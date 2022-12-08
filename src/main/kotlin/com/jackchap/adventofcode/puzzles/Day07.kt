package com.jackchap.adventofcode.puzzles

private const val STORAGE_REQUIRED = 40_000_000L
private const val MINIMUM_COUNT_SIZE = 100_000

object Day07 : Day<List<Long>>(7, "No Space Left On Device") {
    override fun parseInput(lines: List<String>): List<Long> {
        val root = File(null, isDir = true)
        var current = root
        for (out in lines) {
            if (out.startsWith("$")) {
                val cmd = out.drop(2).split(" ", limit = 2)
                if (cmd[0] != "cd") continue
                current = when (val args = cmd[1]) {
                    "/" -> root
                    ".." -> current.parent ?: throw IllegalStateException("Cannot go up a directory")
                    else -> current.getOrPut(args) { File(current, isDir = true) }
                }
                continue
            }

            val (size, file) = out.split(" ", limit = 2)
            if (size == "dir") continue
            current[file] = File(null, fileSize = size.toLong())
        }

        return root.allDirectories.map(File::totalSize)
    }

    override fun partOne(input: List<Long>) = input.sumOf { it.takeIf { it <= MINIMUM_COUNT_SIZE } ?: 0 }

    override fun partTwo(input: List<Long>): Long {
        val spaceToClear = input.max() - STORAGE_REQUIRED
        return input.filter { it >= spaceToClear }.min()
    }
}

data class File(
    val parent: File?,
    val fileSize: Long = 0,
    val isDir: Boolean = false,
) : Comparable<File>, MutableMap<String, File> by mutableMapOf() {
    val totalSize: Long
        get() = fileSize + values.sumOf { it.totalSize }

    val allDirectories: List<File>
        get() = values.filter { it.isDir }.flatMap(File::allDirectories) + this

    override fun compareTo(other: File) = totalSize.compareTo(other.totalSize)
}