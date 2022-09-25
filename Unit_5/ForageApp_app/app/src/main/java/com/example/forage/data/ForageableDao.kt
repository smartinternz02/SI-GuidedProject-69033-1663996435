package com.example.forage.data

import androidx.room.*
import com.example.forage.model.Forageable
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for database interaction.
 */
@Dao
interface ForageableDao {

    @Query("SELECT * FROM forageable ORDER BY name DESC")
    fun getForageables() : Flow<List<Forageable>>

    @Query("SELECT * FROM forageable WHERE id = :id")
    fun getForageable(id: Long) : Flow<Forageable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forageable: Forageable)

    @Update
    suspend fun update(forageable: Forageable)

    @Delete
    suspend fun delete(forageable: Forageable)
}
