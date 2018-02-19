@file:Suppress("IllegalIdentifier")

package me.factliverpool.tlrof.app.auth

import me.factliverpool.tlrof.androidmanagers.NetManager
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by mladenrakonjac on 09/10/17.
 */
class AuthRepositoryImplTest {

    @Mock lateinit var netManager: NetManager
    @Mock lateinit var localDs: AuthLocalDataSource
    @Mock lateinit var remoteDs: AuthRemoteDataSource
    @InjectMocks lateinit var repository: AuthRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test that remote data source is called when there is internet connection`(){

        Mockito.`when`(netManager.isConnectedToInternet).thenReturn(false)

    }
}