package com.example.clientsystemservice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

import com.android.mcandroidsystemservice.MCAndroidSystemServiceManager

class MainActivity : ComponentActivity() {
    lateinit var mcservice : MCAndroidSystemServiceManager
    lateinit var myButton : Button
    lateinit var myText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Log.d("[MCClient]:", "twix" );
        mcservice = MCAndroidSystemServiceManager.getInstance();

        myButton = findViewById(R.id.button)
        myText = findViewById(R.id.textView)

        myButton.setOnClickListener {
            myText.setText(21)
            mcservice.printMessage()
        }

    }
    /////////////////////////////////////////////////////////////////////////////
}

