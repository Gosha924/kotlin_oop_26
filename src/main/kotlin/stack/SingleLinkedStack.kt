package org.example.stack

import org.example.list.SingleLinkedList

class SingleLinkedStack : SingleLinkedList() {

    val isEmpty: Boolean
        get() = size == 0

    fun push(element: Int) {
        this.addFirst(element)
    }

    fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        val topElem = get(0)
        this.remove(topElem)
        return topElem
    }

    fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return this.get(0)
    }

}

