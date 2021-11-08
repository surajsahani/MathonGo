package com.martialcoder.mathongo.models

import com.google.gson.annotations.SerializedName
import com.martialcoder.mathongo.models.AddScoreModel

data class PatchScoreModel(
    @SerializedName("scores") val scores : AddScoreModel.Score
)