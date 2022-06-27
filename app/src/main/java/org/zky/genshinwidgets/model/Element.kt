package org.zky.genshinwidgets.model

import org.zky.genshinwidgets.R

sealed class Element(val name: String, val icon: Int) {

    object Pyro : Element("Pyro", R.drawable.icon_character_pyro)
    object Hydro : Element("Hydro", R.drawable.icon_character_hydro)
    object Anemo : Element("Anemo", R.drawable.icon_character_anemo)
    object Electro : Element("Electro", R.drawable.icon_character_electro)
    object Dendro : Element("Dendro", R.drawable.icon_character_dendro)
    object Cryo : Element("Cryo", R.drawable.icon_character_cryo)
    object Geo : Element("Geo", R.drawable.icon_character_geo)

    companion object {

        val all = listOf(
            Pyro,
            Hydro,
            Anemo,
            Electro,
            Cryo,
            Geo,
            Dendro,
        )

        fun getElementByName(name: String): Element? = when (name) {
            Cryo.name -> Cryo
            Electro.name -> Electro
            Geo.name -> Geo
            Hydro.name -> Hydro
            Pyro.name -> Pyro
            Anemo.name -> Anemo
            Dendro.name -> Dendro
            else -> null
        }

    }
}

