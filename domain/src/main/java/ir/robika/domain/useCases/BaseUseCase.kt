package ir.robika.domain.useCases

abstract class BaseUseCase<P, R> {
    abstract suspend fun onExecute(param: P): R

    suspend fun execute(param: P): R {
        return onExecute(param)
    }
}