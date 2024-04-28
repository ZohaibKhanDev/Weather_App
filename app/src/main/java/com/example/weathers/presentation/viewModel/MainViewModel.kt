package com.example.weathers.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathers.domain.model.Weather.Weather
import com.example.weathers.domain.repositiry.Repository
import com.example.weathers.domain.usecase.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {

    private val _allWeather= MutableStateFlow<ResultState<Weather>>(ResultState.Loading)
    val allWeather:StateFlow<ResultState<Weather>> =_allWeather.asStateFlow()

    fun getAllWeather(){
        viewModelScope.launch {
            _allWeather.value=ResultState.Loading
            try {
                val response=repository.getWeather()
                _allWeather.value=ResultState.Success(response)
            }catch (e:Exception){
                _allWeather.value=ResultState.Error(e)
            }
        }
    }
}