package com.jackchap.adventofcode.puzzles

object Day07 : Day<File>(7, "No Space Left On Device") {
    override fun parseInput(lines: List<String>): File {
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
        return root
    }

    private fun countSum(root: File): Long =
        (root.totalSize.takeIf { it <= 100_000 } ?: 0) + root.values.filter { it.isDir }.sumOf { countSum(it) }

    override fun partOne(input: File) = countSum(input)

    private fun smallestDirToFree(root: File, spaceToClear: Long): File =
        root.values
            .filter { it.isDir && it.totalSize >= spaceToClear }
            .minOfOrNull { smallestDirToFree(it, spaceToClear) } ?: root

    override fun partTwo(input: File): Long {
        val spaceToClear = 30000000L + input.totalSize - 70000000L
        return smallestDirToFree(input, spaceToClear).totalSize
    }
}

data class File(
    val parent: File?,
    val fileSize: Long = 0,
    val isDir: Boolean = false,
) : Comparable<File>, MutableMap<String, File> by mutableMapOf() {
    val totalSize: Long
        get() = fileSize + values.sumOf { it.totalSize }

    override fun compareTo(other: File) = totalSize.compareTo(other.totalSize)
}