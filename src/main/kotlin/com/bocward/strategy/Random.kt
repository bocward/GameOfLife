package com.bocward.strategy

import com.bocward.commons.BEHAVIOUR
import java.util.Random

class Random : Strategy {
    override fun getOwnBehaviour(): BEHAVIOUR {
        val random: Random = Random()
        if(random.nextBoolean()) return BEHAVIOUR.DOVE
        else return BEHAVIOUR.HAWK
    }

    override fun opponentBehaviour(behaviour: BEHAVIOUR) {
    }

}