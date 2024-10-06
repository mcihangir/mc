package com.android.mcandroidsystemservice


import android.app.Application
import android.os.ServiceManager
import android.util.Log
import com.android.mcandroidsystemservice.IMCAndroidSystemService

//class MCAndroidSystemService : Service() {
class MCAndroidSystemServiceApplication : Application() {
    private var serviceImpl: IMCAndroidSystemServiceImpl? = null
    companion object {
        private val REMOTE_SERVICE_NAME: String = IMCAndroidSystemService::class.java.getName()
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "v1.0 onCreate method for MCAndroidSystemService so the servis will be registred to the system by ServiceManager.addService(REMOTE_SERVICE_NAME, serviceImpl)")        
        serviceImpl = IMCAndroidSystemServiceImpl() // Servis implementasyonunu burada başlatıyoruz
        if (serviceImpl != null) {
            ServiceManager.addService(REMOTE_SERVICE_NAME, serviceImpl)
        } else {
            Log.e(TAG, "ServiceImpl is null")
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //override fun onBind(intent: Intent): IBinder {
    //    Log.d(TAG, "onBind: $intent")
    //    return serviceImpl!!.asBinder()
    //}
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onTerminate() {
        super.onTerminate()
    }
}