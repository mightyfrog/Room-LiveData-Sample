package org.mightyfrog.android.roomlivedatasample.viewmodels

import androidx.lifecycle.ViewModel
import org.mightyfrog.android.roomlivedatasample.data.ItemRepository

/**
 * @author Shigehiro Soejima
 */
class ItemListViewModel(itemRepository: ItemRepository) : ViewModel() {

    val itemList = itemRepository.getItems()
}