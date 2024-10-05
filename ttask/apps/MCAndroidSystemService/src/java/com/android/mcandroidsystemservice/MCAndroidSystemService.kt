package com.android.mcandroidsystemservice

import android.os.Bundle
import android.os.ServiceManager
import android.app.Service
import android.content.Intent
import android.os.IBinder

import android.util.Log
import com.android.mcandroidsystemservice.IMCAndroidSystemService

class MCAndroidSystemService : Service() {
    private var serviceImpl: IMCAndroidSystemServiceImpl? = null
    companion object {
        private val REMOTE_SERVICE_NAME: String = IMCAndroidSystemService::class.java.getName()
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate() {
        super.onCreate()        
        serviceImpl = IMCAndroidSystemServiceImpl() // Servis implementasyonunu burada başlatıyoruz
        if (serviceImpl != null) {
            ServiceManager.addService(REMOTE_SERVICE_NAME, serviceImpl)
        } else {
            Log.e(TAG, "ServiceImpl is null")
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind: $intent")
        return serviceImpl!!.asBinder()
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}