package nabi.la.testing_android

import android.app.Application
import nabi.la.testing_android.data.db.ShoppingDatabase
import nabi.la.testing_android.data.repositories.ShoppingRepository
import nabi.la.testing_android.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

class ShoppingApplication: Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind { singleton { ShoppingDatabase(instance()) } }
        bind { singleton { ShoppingRepository(instance()) } }
        bind { provider {
            ShoppingViewModelFactory(instance())
        } }
    }
}