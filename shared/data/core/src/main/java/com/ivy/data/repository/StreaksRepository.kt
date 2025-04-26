package com.ivy.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ivy.base.threading.DispatchersProvider
import com.ivy.data.datasource.LocalStreaksDataSource
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StreaksRepository @Inject constructor(
    private val localStreaksDataSource: LocalStreaksDataSource,
    private val dispatchers: DispatchersProvider
) {

    suspend fun getStreaksCount(): Int {
        return withContext(dispatchers.io) { localStreaksDataSource.getStreaksCount() }
    }

    suspend fun updateStreaksCountFromAd(rewardFromAd: Int) {
        withContext(dispatchers.io) {
            setStreaksCount(getStreaksCount() + rewardFromAd)
        }
    }

    suspend fun setStreaksCount(newCount: Int){
        withContext(dispatchers.io) {
            localStreaksDataSource.setStreaksCount(newCount)
        }
    }

}