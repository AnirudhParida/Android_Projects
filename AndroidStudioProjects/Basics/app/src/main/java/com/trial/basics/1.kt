package com.trial.basics

fun main() {
    var arr = arrayListOf(1,3,5,8,97,45)
    //print(arr[0])
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }
}

