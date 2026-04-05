package org.example

import org.example.list.CustomArrayList
import org.example.list.CustomList

object ListPrinter {
    fun printList(list: Iterable<Int>) {
        println(list.joinToString())
    }
}