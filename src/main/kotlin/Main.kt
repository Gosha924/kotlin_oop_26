package org.example

import org.example.list.SingleLinkedList.Companion.singleLinkedListOf
import org.example.list.CustomArrayList.Companion.customArrayListOf
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack

fun main() {
    val t = singleLinkedListOf(1, 2, 3)
    val a = customArrayListOf(4, 5, 6)
    val b : ArrayListStack = ArrayListStack()
    b.push(1)
    b.push(2)
    b.push(3)
    val c : SingleLinkedStack = SingleLinkedStack()
    c.push(4)
    c.push(5)
    c.push(6)
    println("singleLinkedListOf")
    ListPrinter.printList(t)
    println("\ncustomArrayListOf")
    ListPrinter.printList(a)
    println("\nArrayListStack")
    ListPrinter.printList(b)
    println("\nSingleLinkedStack")
    ListPrinter.printList(c)

}