@file:Suppress("unused")

package com.chrynan.kotlinutils

fun <T> Collection<T>.doForEach(block: (T) -> Unit): Collection<T> {
    forEach(block)
    return this
}

fun <T> Collection<T>.doForEachIndexed(block: (Int, T) -> Unit): Collection<T> {
    forEachIndexed(block)
    return this
}