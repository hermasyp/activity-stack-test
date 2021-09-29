package com.catnip.activitytesting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.catnip.activitytesting.data.Person

class ThirdActivity : AppCompatActivity() {
    private val TAG = ThirdActivity::class.java.simpleName

    companion object {
        const val EXTRAS_TAG_PERSON = "EXTRAS_TAG_PERSON"

        @JvmStatic
        fun startActivity(context: Context?, person: Person) {
            val intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra(EXTRAS_TAG_PERSON, person)
            context?.startActivity(intent)
        }
/*
        const val EXTRAS_TAG_NAME_THIRD = "EXTRAS_TAG_NAME_THIRD"
        const val EXTRAS_TAG_MESSAGE_THIRD = "EXTRAS_TAG_MESSAGE_THIRD"

        @JvmStatic
        fun startActivity(context: Context?, name : String, message : String){
            val intent = Intent(context,ThirdActivity::class.java)
            intent.putExtra(EXTRAS_TAG_NAME_THIRD,name)
            intent.putExtra(EXTRAS_TAG_MESSAGE_THIRD,message)
            context?.startActivity(intent)
        }
*/
    }

    private fun getIntentData() {/*
        val name = intent.extras?.getString(EXTRAS_TAG_NAME_THIRD)
        val message = intent.extras?.getString(EXTRAS_TAG_MESSAGE_THIRD)
        Toast.makeText(this, "$name , $message", Toast.LENGTH_SHORT).show()*/

        val person = intent.extras?.getParcelable<Person>(EXTRAS_TAG_PERSON)
        Toast.makeText(this, "${person?.name} , ${person?.message}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        getIntentData()
        findViewById<Button>(R.id.btn_clear_backstack).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_activity_fourth).setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
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