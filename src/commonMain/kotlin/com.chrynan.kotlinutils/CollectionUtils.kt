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

@Suppress("UNCHECKED_CAST")
inline fun <reified K, reified V> mapOfNotNull(vararg pairs: Pair<K, V?>): Map<K, V> =
    pairs.filter { it.second != null }.toMap() as Map<K, V>