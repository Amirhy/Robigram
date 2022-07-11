package ir.robika.robigram.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.robika.robigram.NavigationCommand
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    val navigationCommand = MutableLiveData<NavigationCommand>()
    val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->
        showDefaultError(exception)
    }

    fun launchCoroutine(
        executorDispatcher: CoroutineDispatcher = Dispatchers.Main,
        useDefaultExceptionHandling: Boolean = true,
        action: suspend () -> Unit
    ) {
        var context =
            if (useDefaultExceptionHandling) defaultExceptionHandler else EmptyCoroutineContext
        context += executorDispatcher
        viewModelScope.launch(context) { action() }
    }

    private fun showDefaultError(exception: Throwable) {
        exception.printStackTrace()
    }
}