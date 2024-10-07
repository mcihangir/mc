package com.android.clientsystemservice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

import androidx.core.view.WindowCompat
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




import com.android.mcandroidsystemservice.MCAndroidSystemServiceManager

class MainActivity : ComponentActivity() {
    lateinit var mcservice : MCAndroidSystemServiceManager
    lateinit var myButton : Button
    lateinit var myText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        //Log.d("[MCClient]:", "twix" );
        mcservice = MCAndroidSystemServiceManager.getInstance();

        myButton = findViewById(R.id.button)
        myText = findViewById(R.id.textView)

        myButton.setOnClickListener {
            myText.text = "Pressed"
            mcservice.printMessage()
        }

    }
    /////////////////////////////////////////////////////////////////////////////
}

