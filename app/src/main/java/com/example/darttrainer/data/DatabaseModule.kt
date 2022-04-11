package com.example.darttrainer.data

import android.content.Context
import androidx.room.Room
import com.example.darttrainer.data.game.GameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideGameDao(database: DartTrainerDatabase): GameDao {
        return database.gameDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DartTrainerDatabase {
        return Room.databaseBuilder(appContext, DartTrainerDatabase::class.java, "dart_trainer.db")
            .build()
    }
}