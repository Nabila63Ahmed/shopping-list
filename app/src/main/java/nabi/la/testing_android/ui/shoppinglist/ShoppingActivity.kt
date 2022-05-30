package nabi.la.testing_android.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import nabi.la.testing_android.data.db.entities.ShoppingItem
import nabi.la.testing_android.databinding.ActivityShoppingBinding
import nabi.la.testing_android.other.ShoppingItemAdapter
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class ShoppingActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
    private val factory : ShoppingViewModelFactory by instance()

    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: ShoppingViewModel by viewModels { factory }

        val adapter = ShoppingItemAdapter(listOf(), model)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        model.getAllShoppingItems().observe(this) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }

        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    model.insert(item)
                }
            }).show()
        }
    }
}