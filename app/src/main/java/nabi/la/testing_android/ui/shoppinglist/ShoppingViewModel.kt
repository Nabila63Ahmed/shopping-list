package nabi.la.testing_android.ui.shoppinglist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nabi.la.testing_android.data.db.entities.ShoppingItem
import nabi.la.testing_android.data.repositories.ShoppingRepository

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}
