package com.superheros.ui.main.superheros.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.superheros.core.data.Resource
import com.superheros.core.domain.Superhero
import com.superheros.core.usecases.superheros.GetSuperheros
import com.superheros.ui.utils.BaseUiModel
import com.superheros.ui.utils.Event
import com.superheros.ui.utils.ScopedViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class SuperherosViewModel @ViewModelInject constructor(
    private val getSuperheros: GetSuperheros,
    override val uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _superheros = MutableLiveData<Event<BaseUiModel<List<Superhero>>>>()
    val superheros: LiveData<Event<BaseUiModel<List<Superhero>>>>
        get() = _superheros

    fun getsuperheros() {
        launch {
            _superheros.value = when (val result = getSuperheros.buildUseCaseSingle(Unit)) {
                is Resource.Success -> {
                    Event(BaseUiModel.Success(result.value))
                }
                is Resource.ErrorBody -> {
                    Event(BaseUiModel.Error(result.errorBody))
                }
                is Resource.ErrorException -> {
                    Event(BaseUiModel.ErrorEx(result.exception))
                }
            }

        }
    }


}