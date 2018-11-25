package org.mightyfrog.android.roomlivedatasample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Shigehiro Soejima
 */
@Entity(tableName = "items")
data class Item(@PrimaryKey val created: Long = System.currentTimeMillis())