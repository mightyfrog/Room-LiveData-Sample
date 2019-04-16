package org.mightyfrog.android.roomlivedatasample.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Shigehiro Soejima
 */
@Entity(
    tableName = "boxes",
    foreignKeys = [ForeignKey(entity = Item::class, parentColumns = ["created"], childColumns = ["name"])]
)
data class Box(
    @PrimaryKey
    val name: String = System.currentTimeMillis().toString()
)
