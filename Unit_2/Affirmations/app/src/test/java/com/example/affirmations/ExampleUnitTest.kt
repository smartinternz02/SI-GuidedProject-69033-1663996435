package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affimation
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val context=mock(Context::class.java)
    @Test
    fun adapter_size() {
        val data= listOf(
            Affimation(R.string.affirmation1, R.drawable.image1),
            Affimation(R.string.affirmation2, R.drawable.image2)
        )
        val adapter=ItemAdapter(context,data)
        assertEquals("ItemAdapter is not the correct size",data.size,adapter.itemCount)
    }
}