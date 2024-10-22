package se.dennisgimbergsson.icatest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import se.dennisgimbergsson.icatest.repositories.PostsDataSource
import se.dennisgimbergsson.icatest.repositories.PostsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindPostsDataSource(postsRepository: PostsRepository): PostsDataSource
}
