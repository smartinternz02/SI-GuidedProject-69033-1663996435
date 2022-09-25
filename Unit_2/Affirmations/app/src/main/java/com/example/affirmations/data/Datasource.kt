package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affimation

class Datasource {
    fun loadAffirmations(): List<Affimation> {
        return listOf<Affimation>(
            Affimation(R.string.affirmation1, R.drawable.image1),
            Affimation(R.string.affirmation2, R.drawable.image2),
            Affimation(R.string.affirmation3, R.drawable.image3),
            Affimation(R.string.affirmation4, R.drawable.image4),
            Affimation(R.string.affirmation5, R.drawable.image5),
            Affimation(R.string.affirmation6, R.drawable.image6),
            Affimation(R.string.affirmation7, R.drawable.image7),
            Affimation(R.string.affirmation8, R.drawable.image8),
            Affimation(R.string.affirmation9, R.drawable.image9),
            Affimation(R.string.affirmation10, R.drawable.image10)
        )
    }
}