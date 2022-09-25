package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG="MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"this is where the app crashed before")
        val helloTextView:TextView=findViewById(R.id.division_textView)
        Log.d(TAG,"This should be logged if the bug is fixed")
        helloTextView.text="Hello, debugging!"
        logging()
        division()
    }

    fun division(){
        val numerator=60
        var denominator=4
        repeat(4){
            Thread.sleep(3000)
            findViewById<TextView>(R.id.division_textView).setText("${numerator/denominator}")
            denominator--
        }
    }

    fun logging(){
        Log.e(TAG,"ERROR: a serious error line an app crash")
        Log.w(TAG,"WARN: warns about the potential for serious errors")
        Log.i(TAG,"INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG,"DEBUG: reporting technical information useful for debugging")
        Log.v(TAG,"VERBOSE: more verbose than DEBUG logs")
    }
}