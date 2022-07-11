package ir.robika.robigram.DI

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ir.robika.data.repository.PostsRepositoryImpl
import ir.robika.domain.repository.PostsRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePostModule(repository: PostsRepositoryImpl): PostsRepository
}