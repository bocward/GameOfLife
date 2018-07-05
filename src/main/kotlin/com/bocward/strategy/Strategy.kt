package com.bocward.strategy

import com.bocward.commons.BEHAVIOUR

interface Strategy {
    fun getOwnBehaviour(): BEHAVIOUR
    fun opponentBehaviour(behaviour: BEHAVIOUR): Unit
}