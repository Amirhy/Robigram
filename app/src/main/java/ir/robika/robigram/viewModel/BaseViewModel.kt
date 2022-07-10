package ir.robika.robigram.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
open class BaseViewModel : ViewModel() {
    val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->
        showDefaultError(exception)
    }

    fun launchCoroutine(
        action: suspend () -> Unit,
        executorDispatcher: CoroutineDispatcher = Dispatchers.IO,
        useDefaultExceptionHandling: Boolean = true
    ) {
        var context =
            if (useDefaultExceptionHandling) defaultExceptionHandler else EmptyCoroutineContext
        context += executorDispatcher
        viewModelScope.launch(context) { action() }
    }

    private fun showDefaultError(exception: Throwable) {

    }
}