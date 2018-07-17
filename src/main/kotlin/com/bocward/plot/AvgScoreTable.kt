package com.bocward.plot

import javax.swing.JTable

class AvgScoreTable(averages: List<Pair<String, Double>>) : JTable(averages.size, 2){
    val preferredWidth = 200

    init{
        var row = 0
        averages.forEach{
            setValueAt(it.first, row, 0)
            setValueAt(it.second, row, 1)
            row++
        }
        columnModel.getColumn(0).preferredWidth = preferredWidth
    }
}