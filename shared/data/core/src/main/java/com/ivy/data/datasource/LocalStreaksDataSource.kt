package com.ivy.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalStreaksDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        private val streaksKey = intPreferencesKey("streaks_count")
    }

    suspend fun getStreaksCount(): Int {
        return dataStore.data.map { it[streaksKey] }.firstOrNull() ?: 0
    }

    suspend fun setStreaksCount(newCount: Int) {
        dataStore.edit {
            it[streaksKey] = newCount
        }
    }



}