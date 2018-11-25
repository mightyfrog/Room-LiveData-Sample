package org.mightyfrog.android.roomlivedatasample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author Shigehiro Soejima
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Long>>

    @Query("DELETE FROM items")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)
}