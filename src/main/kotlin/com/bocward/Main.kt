package com.bocward

import com.bocward.commons.gameForm
import com.bocward.plot.AvgScoreTable
import com.bocward.plot.MainFrame
import com.bocward.plot.PlotChart
import com.bocward.strategy.Dove
import com.bocward.strategy.Hawk
import com.bocward.strategy.RandomStrategy
import com.bocward.strategy.Strategy
import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JPanel



const val numPlayerPerStrategy: Int = 100
val strategies = listOf(Dove::class, Hawk::class, RandomStrategy::class)

data class Player(val strategy: Strategy, var score: Int = 0)

fun main(args: Array<String>) {
    val players = initPlayers()
    players.forEach { player ->
        players.listIterator(players.indexOf(player)).forEach {
            matchPlayers(it, player)
        }
    }
    players.sortBy { it.score }
//    players.forEach{
//        player -> println("Player " + players.indexOf(player) + " Strategy: " + player.strategy + " score: " + player.score)
//    }
    val averages = players.groupBy { it.strategy.javaClass.simpleName }
            .map {
                it.key!! to it.value.map {
                    it.score
                }
            }
            .map { it.first to it.second.average() }
            .sortedByDescending { it.second }
//    averages.forEach{
//        println(it.first + " " + it.second)
//    }
    val table = AvgScoreTable(averages)
    val chart = PlotChart("Game of Life", players)
    val mainFrame = MainFrame("Game of Life")
    mainFrame.add(chart.chartPanel, BorderLayout.CENTER)
    val panel = JPanel(FlowLayout(FlowLayout.RIGHT))
    panel.add(table)
    mainFrame.add(panel, BorderLayout.EAST)
    mainFrame.pack()
    mainFrame.isVisible = true

}

fun initPlayers(): MutableList<Player> {
    val players = mutableListOf<Player>()
    strategies.forEach { strategy ->
        IntProgression.fromClosedRange(0, numPlayerPerStrategy, 1).forEach {
            players.add(Player(strategy.java.newInstance()))
        }
    }
    return players
}

fun matchPlayers(firstPlayer: Player, secondPlayer: Player) {
    val firstPlayerBehaviour = firstPlayer.strategy.getOwnBehaviour()
    val secondPlayerBehaviour = secondPlayer.strategy.getOwnBehaviour()
    firstPlayer.strategy.opponentBehaviour(secondPlayerBehaviour)
    secondPlayer.strategy.opponentBehaviour(firstPlayerBehaviour)
    val scorePair = gameForm.get(Pair(firstPlayerBehaviour, secondPlayerBehaviour))
    firstPlayer.score += scorePair!!.first
    secondPlayer.score += scorePair!!.second

}

