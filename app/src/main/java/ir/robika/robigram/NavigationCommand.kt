package ir.robika.robigram

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController

abstract class NavigationCommand {

    abstract fun navigate(activity: Activity?)
    abstract class To(val data: Bundle? = null) : NavigationCommand()
    class ToAction(
        val actionId: Int,
        val popDestId: Int? = null,
        val popExclusive: Boolean = false
    ) : To() {
        override fun navigate(activity: Activity?) {
            activity?.findNavController(R.id.nav_host_fragment)?.navigate(actionId, data)
        }
    }

    class ToActivity(
        private val destinationActivity: Class<out Activity>,
        extraData: Bundle? = null
    ) :
        To(extraData) {
        override fun navigate(activity: Activity?) {
            val intent = Intent(activity, destinationActivity)
            intent.putExtras(data ?: Bundle())
            activity?.startActivity(intent)
        }
    }
}
