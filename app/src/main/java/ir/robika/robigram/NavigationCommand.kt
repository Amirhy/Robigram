package ir.robika.robigram

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.fragment.app.Fragment

abstract class NavigationCommand {
    lateinit var appContext: Context
        @dagger.hilt.android.qualifiers.ApplicationContext get

    protected abstract fun navigate()
    abstract class To(val data: Bundle? = null) : NavigationCommand()
    class ToAction(
        val actionId: Int,
        val popDestId: Int? = null,
        val popExclusive: Boolean = false
    ) : To() {
        override fun navigate() {

        }
    }

    class ToActivity(val destinationActivity: Class<out Activity>, extraData: Bundle? = null) :
        To(extraData) {
        override fun navigate() {
            val intent = Intent(appContext, destinationActivity)
            intent.putExtras(data ?: Bundle())
            appContext.startActivity(intent)
        }
    }
}
