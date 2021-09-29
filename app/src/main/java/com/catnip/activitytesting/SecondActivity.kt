package com.catnip.activitytesting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.catnip.activitytesting.data.Person

class SecondActivity : AppCompatActivity() {
    private val TAG = SecondActivity::class.java.simpleName

    companion object {
        const val EXTRAS_KEY_MESSAGE = "EXTRAS_KEY_MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.btn_navigate).setOnClickListener {
//            ThirdActivity.startActivity(this,"Jarvis", "Please Turn on the light !")
            ThirdActivity.startActivity(this, Person("Jarvis", "Please Turn on the light !"))
        }
        findViewById<Button>(R.id.btn_finish_result).setOnClickListener {
            val intentData = Intent()
            intentData.putExtra(EXTRAS_KEY_MESSAGE,"Hello this is Message !")
            setResult(Activity.RESULT_OK,intentData)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $TAG")
    }
}