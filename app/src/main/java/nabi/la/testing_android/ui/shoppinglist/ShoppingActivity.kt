package nabi.la.testing_android.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import nabi.la.testing_android.R
import nabi.la.testing_android.data.db.ShoppingDatabase
import nabi.la.testing_android.data.repositories.ShoppingRepository
import nabi.la.testing_android.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = ShoppingDatabase(this)
        val repository = ShoppingRepository(db)
        val factory = ShoppingViewModelFactory(repository)

        val model: ShoppingViewModel by viewModels { factory }
    }
}