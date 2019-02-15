package org.mightyfrog.android.roomlivedatasample.data

import java.util.concurrent.Executors

/**
 * @author Shigehiro Soejima
 */
class ItemRepository(private val itemDao: ItemDao) {

    private val ioExecutor = Executors.newSingleThreadExecutor()

    companion object {

        @Volatile
        private var instance: ItemRepository? = null

        fun getInstance(itemDao: ItemDao) =
            instance ?: synchronized(this) {
                instance ?: ItemRepository(itemDao).also { instance = it }
            }
    }

    fun createItem() {
        runOnIoThread {
            itemDao.insert(Item())
        }
    }

    fun getItems() = itemDao.getAll()

    fun deleteAll() {
        runOnIoThread {
            itemDao.deleteAll()
        }
    }

    private fun runOnIoThread(f: () -> Unit) {
        ioExecutor.execute(f)
    }
}