@file:Suppress("unused")

package com.chrynan.kotlinutils

inline fun <T> T?.perform(block: T.() -> Unit): Unit = this?.run(block) ?: Unit