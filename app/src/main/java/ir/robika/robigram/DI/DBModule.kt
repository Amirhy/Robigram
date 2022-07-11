package ir.robika.robigram.DI

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.robika.data.dataBase.AppDataBase
import ir.robika.data.dataBase.dao.PostDao

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Provides
    fun provideAppDB(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "appDb")
            .build()
    }

    @Provides
    fun providePostDAO(dataBase: AppDataBase): PostDao = dataBase.postDao()
}