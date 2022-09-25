package com.example.inventory

import android.app.Application
import com.example.inventory.data.ItemRoomDatabase

class InventoryApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}