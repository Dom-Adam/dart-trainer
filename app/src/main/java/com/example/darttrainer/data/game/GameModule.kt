package com.example.darttrainer.data.game

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class GameModule {

    @Singleton
    @Binds
    abstract fun bindGameDatabase(impl: LocalGameDataSource): GameDataSource
}