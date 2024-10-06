package com.android.mcandroidsystemservice


import com.android.mcandroidsystemservice.*
import android.util.Log

public const val TAG = "[MCAndroidSystemService]:"
    
class IMCAndroidSystemServiceImpl: IMCAndroidSystemService.Stub() {

    override fun printMessage(){        
        Log.d(TAG, "This is printed serivce of MCAndroidSystemServiceManager")
    }

}