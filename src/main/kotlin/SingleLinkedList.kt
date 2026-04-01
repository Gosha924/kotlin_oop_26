package org.example

class SingleLinkedList : CustomList {

    private class Node (var value: Int, var next: Node?=null)

    private var head: Node? = null
    private var tail: Node? = null
    private var sizeList: Int = 0

    override val size: Int
        get() = sizeList

     override fun isEmpty() :Boolean {
         return size == 0
     }

    override fun add(element: Int) {
        val newNode = Node(element)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        sizeList++

    }

    override operator fun set(index: Int, value: Int) : Int {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        var current = head
        var currentIndex: Int = 0
        while (current != null) {
            if (currentIndex == index) {
                val oldValue = current.value
                current.value = value
                return oldValue
            }
            currentIndex++
            current = current.next
        }
        throw IllegalStateException("Element not found")
    }

    override fun addFirst(element: Int) {
        head = Node(element, next = head)
        if (tail == null) {
            tail = head
        }
        sizeList++
    }

    override operator fun get(index: Int): Int {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        var current = head
        var currentIndex: Int = 0
        while (current != null) {
            if (index == currentIndex) {
                return current.value
            }
            currentIndex++
            current = current.next
        }
        throw IllegalStateException("Element not found")
    }

    override fun indexOf(element: Int): Int {
        var index = 0
        var current = head
        while (current != null) {
            if (current.value == element) {
                return index
            }
            index++
            current = current.next
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        if (isEmpty()) {
            return false
        }
        var current = head
        var prev: Node? = null
        while (current != null) {
            if (current.value == element) {
                if (prev == null) {
                    head = current.next
                } else {
                    prev.next = current.next
                }
                sizeList--
                return true
            }
            prev = current
            current = current.next
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current = head
            override fun hasNext(): Boolean {
                return current != null
            }
            override fun next(): Int {
                val value = current?.value ?: throw NoSuchElementException()
                current = current?.next
                return value
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}