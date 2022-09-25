//package com.example.cupcake
//
//import com.example.cupcake.model.OrderViewModel
//import org.junit.Assert.assertEquals
//import org.junit.Rule
//import org.junit.Test
//
//class ViewModelTests {
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//
//    @Test
//    fun quantity_twelve_cupcakes() {
//        val viewModel = OrderViewModel()
//        viewModel.quantity.observeForever {}
//        viewModel.setQuantity(12)
//        assertEquals(12, viewModel.quantity.value)
//    }
//
//    @Test
//    fun price_twelve_cupcakes() {
//        val viewModel = OrderViewModel()
//        viewModel.price.observeForever {}
//        viewModel.setQuantity(12)
//        assertEquals("$27.00", viewModel.price.value)
//    }
//}