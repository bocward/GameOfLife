package com.bocward.strategy

import com.bocward.commons.BEHAVIOUR

class Dove : Strategy {
    override fun getOwnBehaviour(): BEHAVIOUR {
        return BEHAVIOUR.DOVE
    }

    override fun opponentBehaviour(behaviour: BEHAVIOUR) {
    }

}