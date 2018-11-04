@file:Suppress("unused")

package com.chrynan.kotlinutils

const val INT_TRUE = 1
const val INT_FALSE = 0
const val INT_INVALID_BOOLEAN = -1

val Boolean?.truthy: Boolean
    get() = this == true

val Boolean?.falsy: Boolean
    get() = !truthy

fun Boolean?.isTruthy() = truthy

fun Boolean?.isFalsy() = falsy

fun Boolean?.orTrue() = this ?: true

fun Boolean?.orFalse() = this ?: false

fun Boolean?.or(value: Boolean) = this ?: value

fun Int?.isIntTrueValue(value: Int = INT_TRUE) = this == value

fun Int?.isIntFalseValue(value: Int = INT_FALSE) = this == value

fun Int?.toBooleanOrNull(valueTrue: Int = INT_TRUE, valueFalse: Int = INT_FALSE) =
    when {
        this == valueTrue -> true
        this == valueFalse -> false
        else -> null
    }

fun Boolean?.toInt(valueTrue: Int = INT_TRUE, valueFalse: Int = INT_FALSE, valueNull: Int = INT_INVALID_BOOLEAN) =
    when {
        this == true -> valueTrue
        this == false -> valueFalse
        else -> valueNull
    }

fun Boolean?.toIntOrNull(valueTrue: Int = INT_TRUE, valueFalse: Int = INT_FALSE) =
    when {
        this == true -> valueTrue
        this == false -> valueFalse
        else -> null
    }

fun <T> T?.asTrue() = true

fun <T> T?.asFalse() = false

fun <T> T?.asBoolean(value: Boolean) = value

fun <T, R> (T.() -> R).thenTrue(value: T) = invoke(value).asTrue()

fun <T, R> (T.() -> R).thenFalse(value: T) = invoke(value).asFalse()

fun <T, R> (T.() -> R).thenBoolean(value: T, returnValue: Boolean) = invoke(value).asBoolean(returnValue)

fun <R> (() -> R).thenTrue() = invoke().asTrue()

fun <R> (() -> R).thenBoolean(value: Boolean) = invoke().asBoolean(value)

fun <R> (() -> R).thenFalse() = invoke().asFalse()

inline fun <T, R> T.runThenTrue(block: T.() -> R) = run(block).asTrue()

inline fun <T, R> T.runThenFalse(block: T.() -> R) = run(block).asFalse()

inline fun <T, R> T.runThenBoolean(returnValue: Boolean, block: T.() -> R) = run(block).asBoolean(returnValue)

inline fun <R> runThenTrue(block: () -> R) = run(block).asTrue()

inline fun <R> runThenFalse(block: () -> R) = run(block).asFalse()

inline fun <R> runThenBoolean(returnValue: Boolean, block: () -> R) = run(block).asBoolean(returnValue)

inline fun <T, R> T.letThenTrue(block: (T) -> R) = let(block).asTrue()

inline fun <T, R> T.letThenFalse(block: (T) -> R) = let(block).asFalse()

inline fun <T, R> T.letThenBoolean(returnValue: Boolean, block: (T) -> R) = let(block).asBoolean(returnValue)

inline fun <R> Boolean?.runIfTrue(block: () -> R) = if (this == true) block() else null

inline fun <R> Boolean?.runIfFalse(block: () -> R) = if (this == false) block() else null

inline fun <R> Boolean?.runIfNull(block: () -> R) = if (this == null) block() else null

inline fun <R> Boolean?.runIfFalsy(block: () -> R) = if (isFalsy()) block() else null