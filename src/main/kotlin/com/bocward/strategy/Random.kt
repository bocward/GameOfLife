package com.bocward.strategy

import com.bocward.commons.BEHAVIOUR
import java.util.Random

class RandomStrategy : Strategy {
    override fun getOwnBehaviour(): BEHAVIOUR {
        if(Random().nextBoolean()) return BEHAVIOUR.DOVE
        else return BEHAVIOUR.HAWK
    }

    override fun opponentBehaviour(behaviour: BEHAVIOUR) {
    }

}