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
interface BoxDao {

    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Box>>

    @Query("DELETE FROM items")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(box: Box)

}