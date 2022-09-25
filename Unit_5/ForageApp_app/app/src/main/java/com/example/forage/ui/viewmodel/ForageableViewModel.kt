package com.example.forage.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.forage.data.ForageableDao
import com.example.forage.model.Forageable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Shared [ViewModel] to provide data to the [ForageableListFragment], [ForageableDetailFragment],
 * and [AddForageableFragment] and allow for interaction the the [ForageableDao]
 */

class ForageableViewModel(private val forageableDao: ForageableDao): ViewModel() {

    var forageables: LiveData<List<Forageable>> = forageableDao.getForageables().asLiveData()

    fun getForageable(id: Long) : LiveData<Forageable> = forageableDao.getForageable(id).asLiveData()

    fun addForageable(
        name: String,
        address: String,
        inSeason: Boolean,
        notes: String
    ) {
        val forageable = Forageable(
            name = name,
            address = address,
            inSeason = inSeason,
            notes = notes
        )

        viewModelScope.launch {
            forageableDao.insert(forageable)
        }

    }

    fun updateForageable(
        id: Long,
        name: String,
        address: String,
        inSeason: Boolean,
        notes: String
    ) {
        val forageable = Forageable(
            id = id,
            name = name,
            address = address,
            inSeason = inSeason,
            notes = notes
        )
        viewModelScope.launch(Dispatchers.IO) {
            try {
                forageableDao.update(forageable)
            }
            catch (e: Exception){
                Log.e("ViewModel.update", e.message.toString())
            }
        }
    }

    fun deleteForageable(forageable: Forageable) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                forageableDao.delete(forageable)
            }
            catch (e: Exception){
                Log.e("ViewModel.delete", e.message.toString())
            }
        }
    }

    fun isValidEntry(name: String, address: String): Boolean {
        return name.isNotBlank() && address.isNotBlank()
    }
}

class ForageableViewModelFactory(private val forageableDao: ForageableDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ForageableViewModel::class.java)) {
            return ForageableViewModel(forageableDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}
