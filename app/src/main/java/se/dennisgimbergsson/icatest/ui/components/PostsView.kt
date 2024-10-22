package se.dennisgimbergsson.icatest.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import se.dennisgimbergsson.icatest.data.Post
import se.dennisgimbergsson.icatest.ui.theme.ICATestTheme

@Composable
fun PostsView(
    posts: List<Post>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(posts) {
            PostView(it)
            HorizontalDivider()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PostsViewPreview() = ICATestTheme {
    PostsView(mockPosts)
}

@Composable
private fun PostView(
    post: Post,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "userId = ${post.userId}")
            Text(text = "id = ${post.id}")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = post.title,
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = post.body,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                lineHeight = 1.2.em
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PostViewPreview() = ICATestTheme {
    PostView(mockPost1)
}

val mockPost1 = Post(1, 1, "title 1", "body 1")
val mockPost2 = Post(1, 2, "title 2", "body 2")
val mockPost3 = Post(2, 3, "title 3", "body 3")
val mockPost4 = Post(1, 4, "title 4", "body 4")
val mockPost5 = Post(2, 5, "title 5", "body 5")
val mockPosts = listOf(mockPost1, mockPost2, mockPost3, mockPost4, mockPost5)