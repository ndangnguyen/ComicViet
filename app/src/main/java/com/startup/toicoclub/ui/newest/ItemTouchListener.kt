package com.startup.toicoclub.ui.newest

interface ItemTouchListener {
    fun onItemSwipe(position: Int, direction: Int)
    fun onItemMove(positionFrom: Int, positionTo: Int)
}