package nabi.la.testing_android.ui.shoppinglist

import nabi.la.testing_android.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}