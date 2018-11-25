package org.mightyfrog.android.roomlivedatasample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.mightyfrog.android.roomlivedatasample.data.ItemRepository

/**
 * @author Shigehiro Soejima
 */
class ItemListViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemListViewModel(repository) as T
    }
}