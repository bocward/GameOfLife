package com.bocward.strategy

import com.bocward.commons.BEHAVIOUR

class Hawk : Strategy {
    override fun opponentBehaviour(behaviour: BEHAVIOUR) {
    }

    override fun getOwnBehaviour(): BEHAVIOUR {
        return BEHAVIOUR.HAWK
    }

}