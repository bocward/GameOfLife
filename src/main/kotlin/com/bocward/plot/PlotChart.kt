package com.bocward.plot

import com.bocward.Player
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.ui.ApplicationFrame
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection


class PlotChart(title: String, players: MutableList<Player>) : ApplicationFrame(title) {

    init {
        val seriesList = mutableListOf<XYSeries>()
        val playersByStrategy = players.groupBy { it.strategy.javaClass.simpleName }
        playersByStrategy.keys.forEach{
            var i: java.lang.Integer = Integer(1)
            val series = XYSeries(it)
            playersByStrategy.get(it)!!.forEach {
                series.add(i, it.score)
                i = Integer(i.toInt() + 1)
            }
            seriesList.add(series)
        }
        val data = XYSeriesCollection()
        seriesList.forEach { data.addSeries(it) }
        val chart = ChartFactory.createXYLineChart(
                title,
                "X",
                "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        )

        val chartPanel = ChartPanel(chart)
        chartPanel.preferredSize = java.awt.Dimension(1000, 750)
        contentPane = chartPanel

    }
}
