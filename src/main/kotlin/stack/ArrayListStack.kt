package org.example.stack

import org.example.list.CustomArrayList
import org.example.list.SingleLinkedList

class ArrayListStack(private val initialCapacity: Int = 10): Stack {
    private var storage = CustomArrayList(initialCapacity)

    override val isEmpty: Boolean
        get() = storage.size == 0

    override fun push(value: Int) {
        storage.addFirst(value)
    }

    override fun pop(): Int {
        if (this.isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        val elem : Int = storage.get(0)
        storage.remove(elem)
        return elem
    }

    override fun peek(): Int {
        if (this.isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return storage.get(0)
    }

    override fun get(index: Int): Int = storage.get(index)
    override fun set(index: Int, value: Int): Int = storage.set(index, value)
    override fun add(element: Int) = storage.add(element)
    override fun iterator(): Iterator<Int> = storage.iterator()
    override val size: Int get() = storage.size
    override fun remove(element: Int): Boolean = storage.remove(element)
    override fun indexOf(element: Int): Int = storage.indexOf(element)
    override fun addFirst(element: Int) = storage.addFirst(element)

}