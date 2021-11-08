package com.martialcoder.mathongo.ui.add_score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.martialcoder.mathongo.models.AddScoreModel
import com.martialcoder.mathongo.models.PatchScoreModel
import com.martialcoder.mathongo.repository.NetworkRepository
import com.martialcoder.mathongo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AddScoreActivityViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel(){
    fun addScoreCards(scoreCard : AddScoreModel) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.addScoreCard(scoreCard)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }

    fun updateScoreCards(scoreId : String, scoreCard : PatchScoreModel) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.updateScoreCard(scoreId,scoreCard)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }

    fun fetchTestSeries() = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.fetchTestSeries()
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }
}