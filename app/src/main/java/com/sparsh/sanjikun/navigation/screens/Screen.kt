package com.sparsh.sanjikun.navigation.screens

sealed class Screen {
    fun deeplink(): String {
        val prefix = "skun://"
        var screenName = ""
        val className = this.javaClass.simpleName

        className.forEachIndexed { index, char ->
            screenName += if (char.isUpperCase() && index == 0) {
                char.lowercase()
            } else if (char.isUpperCase()) {
                "_${char.lowercase()}"
            } else {
                char
            }
        }

        return prefix + screenName
    }
}