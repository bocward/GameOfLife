package com.bocward.plot

import java.awt.BorderLayout
import javax.swing.JFrame

class MainFrame(title: String?) : JFrame(title) {

    init {
        setTitle(title)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        layout = BorderLayout(0,5)
    }
}