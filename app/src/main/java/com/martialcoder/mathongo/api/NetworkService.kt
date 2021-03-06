package com.martialcoder.mathongo.api

import com.martialcoder.mathongo.models.AddScoreModel
import com.martialcoder.mathongo.models.PatchScoreModel
import com.martialcoder.mathongo.models.ScoreCardModel
import com.martialcoder.mathongo.models.TestSeriesModel
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {

    //Fetch Test Scores
    @Headers("Content-Type: application/json")
    @GET("test-scores")
    suspend fun fetchScoreCards(
        @Query("email") email : String,
        @Query("page") page : String,
        @Query("limit") limit : String,
    ) : Response<ScoreCardModel>

    //Add Test Score
    @Headers("Content-Type: application/json")
    @POST("test-scores")
    suspend fun addScore(
        @Body score : AddScoreModel
    ) : Response<ScoreCardModel>

    //Delete Test Score
    @Headers("Content-Type: application/json")
    @DELETE("test-scores/{id}")
    suspend fun deleteScore(
        @Path("id") testId : String,
    ) : Response<Any>

    // Fetch Test Series
    @Headers("Content-Type: application/json")
    @GET("test-series")
    suspend fun fetchTestSeries(
    ): Response<TestSeriesModel>

    // Update Test Scores
    @Headers("Content-Type: application/json")
    @PATCH("test-scores/{id}")
    suspend fun updateScore(
        @Path("id") testId : String,
        @Body scores : PatchScoreModel
    ) : Response<Any>


}