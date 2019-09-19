package com.example.firstproject

import java.math.BigInteger

class NumberConvertor(num: String, base: Numbering = Numbering.DEC) {
    val _num = num
    val _base = base
    enum class Numbering(val value: Int) {
        HEX(16),
        BIN(2),
        OCT(8),
        DEC(10)
    }

    fun convert(base: Numbering) : String {
        return BigInteger(_num, _base.value).toString(base.value)
    }
}