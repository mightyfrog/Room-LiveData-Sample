package org.mightyfrog.android.roomlivedatasample.data

import androidx.room.TypeConverter

/**
 * @author Shigehiro Soejima
 */
class Converters {

    @TypeConverter
    fun fromBox(box: Box): String = box.name

    @TypeConverter
    fun toBox(name: String): Box = Box(name)
}