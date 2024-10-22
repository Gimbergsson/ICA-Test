package se.dennisgimbergsson.icatest.ui.screens

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import se.dennisgimbergsson.icatest.repositories.PostsDataSource
import se.dennisgimbergsson.icatest.utils.ReduxViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postsRepository: PostsDataSource,
) : ReduxViewModel<MainViewState>(
    initialState = MainViewState()
), DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }
}