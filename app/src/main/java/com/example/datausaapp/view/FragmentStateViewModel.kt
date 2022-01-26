package com.example.datausaapp.view


import androidx.lifecycle.*
import com.example.datausaapp.data.model.State
import com.example.datausaapp.data.repository.StateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentStateViewModel() {

    class RecipeDetailsViewModel constructor(
        private val repository: StateRepository,

        ) : ViewModel() {

        private val _states = MutableLiveData<List<State>>()
        val states: LiveData<List<State>>
            get() = _states


        init {
            getStates()

        }

        private fun getStates() {
            viewModelScope.launch(Dispatchers.IO) {
                val response: List<State> = repository.getStates()
                response.let {
                    _states.postValue(it)
                }
            }
        }

        fun updateState(state: State) {
            val list = states.value
            list?.find {
                it.stateId == state.stateId
            }?.let {
                it.state = state.state
                it.population = state.population
                it.year = state.year
                it.slugState = state.slugState
            }
            _states.value = list
        }

        class RecipeDetailViewModelFactory constructor(
            private val repository: StateRepository,

            ) :
            ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return RecipeDetailsViewModel(this.repository) as T
            }
        }
    }
}