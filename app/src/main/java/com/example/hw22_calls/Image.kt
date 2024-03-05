package com.example.hw22_calls


class Image(
    var name: String,
    var number: String,
    var comment: String
) {
    override fun toString(): String {
        return "$name, $number"
    }
}

