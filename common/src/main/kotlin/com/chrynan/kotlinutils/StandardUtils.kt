@file:Suppress("unused")

package com.chrynan.kotlinutils

inline fun <T> T?.perform(block: T.() -> Unit): Unit = this?.run(block) ?: Unit

inline fun perform(block: () -> Unit): Unit = block()

inline fun <T> T.thenDo(block: (T) -> Unit): T = also(block)

val DoNothing: () -> Unit = {}