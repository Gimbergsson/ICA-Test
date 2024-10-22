package se.dennisgimbergsson.icatest.repositories

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.isActive
import se.dennisgimbergsson.icatest.data.ApiService
import se.dennisgimbergsson.icatest.data.Post
import javax.inject.Inject

interface PostsDataSource {
    suspend fun fetchPosts(): Flow<List<Post>>
}

class PostsRepository @Inject constructor(
    private val apiService: ApiService,
) : PostsDataSource {

    override suspend fun fetchPosts() = callbackFlow {
        val response = apiService.getPosts()
        if (response.isSuccessful) {
            // Get the posts with an id lower than 50
            val posts = response.body()
                ?.filter { it.id < 50 } ?: emptyList()

            // Emit posts
            if (currentCoroutineContext().isActive) {
                trySend(posts)
            }
        }

        awaitClose {
            channel.close()
        }
    }
}