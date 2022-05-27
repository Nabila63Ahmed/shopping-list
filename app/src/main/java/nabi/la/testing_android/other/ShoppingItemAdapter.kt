package nabi.la.testing_android.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nabi.la.testing_android.R
import nabi.la.testing_android.data.db.entities.ShoppingItem
import nabi.la.testing_android.databinding.ActivityShoppingBinding
import nabi.la.testing_android.databinding.ShoppingItemBinding
import nabi.la.testing_android.ui.shoppinglist.ShoppingActivity
import nabi.la.testing_android.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        val binding = ShoppingItemBinding.bind(holder.itemView)
        binding.tvName.text = currentShoppingItem.name
        binding.tvAmount.text = "${currentShoppingItem.amount}"

        binding.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        binding.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.insert(currentShoppingItem)
        }

        binding.ivMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.insert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}