package org.zky.genshinwidgets.model

data class SignReward(val month: Int, val awards: MutableList<RewardItem>, val resign: Boolean)

data class RewardItem(val icon: String, val name: String, val cnt: Int)