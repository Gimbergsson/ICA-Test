package se.dennisgimbergsson.icatest.ui.screens

import androidx.compose.runtime.Immutable
import se.dennisgimbergsson.icatest.data.Post

@Immutable
data class MainViewState(
    val posts: List<Post> = emptyList(),
)