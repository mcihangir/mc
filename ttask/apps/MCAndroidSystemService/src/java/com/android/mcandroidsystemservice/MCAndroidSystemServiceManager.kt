package com.android.mcandroidsystemservice

import android.os.ServiceManager
import android.util.Log

import com.android.mcandroidsystemservice.IMCAndroidSystemService

class MCAndroidSystemServiceManager {

    val REMOTE_SERVICE_NAME: String = IMCAndroidSystemService::class.java.getName()
    private val serviceInterface: IMCAndroidSystemService?

    // Yapıcı fonksiyonu normal (public) yap
    // Constructor
    init {
        serviceInterface = IMCAndroidSystemService.Stub.asInterface(
            ServiceManager.getService(REMOTE_SERVICE_NAME)
        )
        checkNotNull(serviceInterface) { "Failed to find IMCAndroidSystemService by name [$REMOTE_SERVICE_NAME]" }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    companion object {
        // Singleton gibi davranması için bir instance sağlayan bir fonksiyon
        fun getInstance(): MCAndroidSystemServiceManager {
            return MCAndroidSystemServiceManager()
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun printMessage() {
        serviceInterface?.printMessage() // service null olabileceği için güvenli çağrı
    }

}