package ir.robika.domain.useCases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

abstract class BaseUseCase<P, R> {
    var dispatcher: CoroutineDispatcher? = null
    abstract suspend fun onExecute(param: P): R

    suspend fun execute(param: P): R {
        return withContext(dispatcher ?: (coroutineContext + dispatcher!!)) { onExecute(param) }
    }
}