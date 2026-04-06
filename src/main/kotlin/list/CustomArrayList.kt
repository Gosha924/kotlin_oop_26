package org.example.list

class CustomArrayList(size: Int): CustomList {
    var capasity : Int = size * 2 + 1
    var inner = IntArray(capasity)
    var currentSize : Int = 0

    override val size: Int
        get() = currentSize

    override fun add(element: Int) {
        if (currentSize >= capasity) {
            this.resize(capasity * 2)
        }
        inner[currentSize] = element
        currentSize++
    }

    private fun resize(newSize: Int) {
        inner = inner.copyOf(newSize)
        capasity = newSize
    }

    override fun addFirst(element: Int) {
        if (currentSize >= capasity) {
            this.resize(capasity * 2)
        }
        for (i in currentSize downTo 1) {
            inner[i] = inner[i - 1]
        }
        inner[0] = element
        currentSize++
    }

    override fun remove(element: Int): Boolean {
        val indexElem : Int = this.indexOf(element)
        if (indexElem < 0) {
            return false
        }
        for (i in indexElem until currentSize - 1) {
            inner[i] = inner[i+1]
        }
        currentSize--
        return true
    }

     override fun indexOf(element: Int): Int {
         var currentIndex : Int = 0
         while (currentIndex < currentSize) {
             if (inner[currentIndex] == element) {
                 return currentIndex
             }
             currentIndex ++
         }
         return -1
     }

    override operator fun get(index: Int): Int {
        if (index < 0 || index >= currentSize) {
            throw  IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        return inner[index]
    }

    override operator fun set(index: Int, value: Int): Int {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        val oldValue : Int = inner[index]
        inner[index] = value
        return oldValue
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var index = 0  // текущая позиция в массиве

            override fun hasNext(): Boolean = index < currentSize

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                return inner[index++]
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}