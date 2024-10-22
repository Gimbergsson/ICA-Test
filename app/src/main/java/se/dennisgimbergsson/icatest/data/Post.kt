package se.dennisgimbergsson.icatest.data

import androidx.compose.runtime.Immutable

@Immutable
data class Post(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val body: String = "",
)
