/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amphibians.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.ApiService
import kotlinx.coroutines.launch

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for the API status
    private val _status = MutableLiveData<AmphibianApiStatus>()
    val status: LiveData<AmphibianApiStatus> get() = _status

    // TODO: Create properties to represent MutableLiveData and LiveData for a list of amphibian objects
    private val _allAmphibians = MutableLiveData<List<Amphibian>>()
    val allAmphibian: LiveData<List<Amphibian>> get() = _allAmphibians

    // TODO: Create properties to represent MutableLiveData and LiveData for a single amphibian object.
    //  This will be used to display the details of an amphibian when a list item is clicked
    private val _amphibians = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> get() = _amphibians

    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine
    /**   init {
     *      getAllAmphibians()
    }**/

    fun getAllAmphibians()= viewModelScope.launch {
        _status.value = AmphibianApiStatus.LOADING
        try {
            _allAmphibians.value = ApiService.amphibianApiService.getAllAmphibian().body()
            _status.value = AmphibianApiStatus.DONE
        }catch (e:Exception){
            _allAmphibians.value = listOf()
            _status.value = AmphibianApiStatus.ERROR
            Log.d("RESTful Error", "Unable to get all Data due to $e")
        }


    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        // TODO: Set the amphibian object
        _amphibians.value = amphibian
    }
}
