package com.devventure.whatdidilearn.data.database

import androidx.room.TypeConverter
import com.devventure.whatdidilearn.view.adapters.UnderstandingLevel

class Converters {

    /**
     * Função que transforma nosso tipo de dado para um tipo primitivo par ao Room utilizar o dados.
     * Converter o UnderstandingLevel para o id da cor
     */
    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int {
        return level.ordinal
    }

    /**
     * Função que transforma nosso tipo primitivo para um tipo customizado criado.
     * Converter o id da cor para UnderstandingLevel
     */
    @TypeConverter
    fun intToLevel(ordinalInt: Int): UnderstandingLevel {
        return when(ordinalInt) {
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }

}