/*
 * Copyright 2020 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.google.mlkit.showcase.vidastraduki

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.showcase.vidastraduki.java.VidasTradukiService
import com.google.mlkit.showcase.vidastraduki.main.MainFragment

class MainActivity : AppCompatActivity() {
    var doclose: Boolean = false


    public override fun onStart() {
        super.onStart()
        // Bind to LocalService
        val intent = Intent(this, VidasTradukiService::class.java)
        intent.putExtra("times", 1)
        startService(intent)


        bindService(intent, mConnection, BIND_AUTO_CREATE)
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_tradukishowcase_activity)
        if (savedInstanceState == null) {
         //   Toast.makeText(app, "createnilt", Toast.LENGTH_SHORT).show()
            val intent = intent
            val bundle = getIntent().extras
            val data = intent?.data
            if (data != null) {
                Toast.makeText(app, "do  fermi data", Toast.LENGTH_SHORT).show()

            }

            if (bundle != null) {
                var s=bundle.getString("strName")
                if (s == "captura") {
                  //  doclose = true
                    //        Toast.makeText(app, "do  fermi", Toast.LENGTH_SHORT).show()


                } else

                if (s != null) {
                    doclose = true
            //        Toast.makeText(app, "do  fermi", Toast.LENGTH_SHORT).show()

                    //TODO here get the string stored in the string variable and do
                    // setText() on userName
                }

                // Handle intents with image data
            }
            var main:MainFragment=MainFragment.newInstance()
            main.app=app
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, main)
                .commitNow()
        }  else {
            val intent = intent

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
            //String dat = intent.getData();
            Toast.makeText(app, "connected in intent", Toast.LENGTH_SHORT).show()

            // if (dat!="")
            run {
                doclose = true
            }
        }
    }

    var mService: Messenger? = null
    var mBound: Boolean = false
    var app: AppCompatActivity = this
    val TAG: String = "MainActivity"



    private val mConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.

            mService = Messenger(service)
            mBound = true
            Log.v(TAG, "connected is true")
            Toast.makeText(app, "Konektita", Toast.LENGTH_SHORT).show()
            // runClick();

            if (doclose) {
                val intent = Intent()
                intent.putExtra("texto", "ok")
                setResult(RESULT_OK, intent)
               // setResult(RESULT_OK);
                app.finish()
                // Handle intents with image data
            }
        }

        override fun onServiceDisconnected(className: ComponentName) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null
            mBound = false
            Log.v(TAG, "SenKonekta!")
            Toast.makeText(app, "SenKonekta", Toast.LENGTH_SHORT).show()

        }

    }



    val mMessenger: Messenger = Messenger(IncomingHandler())


    internal inner class IncomingHandler : Handler() {
        override fun handleMessage(msg: Message) {

        }
    }


    public override fun onStop() {
        super.onStop()
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection)
            mBound = false
        }
    }


    companion object {
        const val MSG_SET_INT_VALUE: Int = 3
        const val MSG_SET_STRING_VALUE: Int = 4
        const val MSG_SAY_HELLO_DELPHI: Int = 123
        const val MSG_RESPONSE_HELLO_DELPHI: Int = 321
    }


}







