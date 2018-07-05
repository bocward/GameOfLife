package com.bocward.commons

//Possible behaviours
enum class BEHAVIOUR {
    HAWK, DOVE
}

val V: Int = 6   //value of the contested resource
val C: Int = 12   //cost of an escalated fight

val gameForm = mutableMapOf(
        Pair(BEHAVIOUR.HAWK, BEHAVIOUR.DOVE) to Pair(V, 0),
        Pair(BEHAVIOUR.DOVE, BEHAVIOUR.DOVE) to Pair(V / 2, V / 2),
        Pair(BEHAVIOUR.DOVE, BEHAVIOUR.HAWK) to Pair(0, V),
        Pair(BEHAVIOUR.HAWK, BEHAVIOUR.HAWK) to Pair((V - C) / 2, (V - C) / 2)
)