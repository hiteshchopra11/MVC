package com.example.mvc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc.model.Model
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    // creating object of Model class
    var myModel: Model? = null

    // creating object of Button class
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating relationship between the
        // observable Model and the
        // observer Activity
        myModel = Model()
        myModel!!.addObserver(this)

        // assigning button IDs to the objects
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)


        // transfer the control to Onclick() method
        // when a button is clicked by passing
        // argument "this"
        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
    }

    // calling setValueAtIndex() method
    // by passing appropriate arguments
    // for different buttons
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> myModel?.setValueAtIndex(2)
        }
    }



//     function to update the view after
//     the values are modified by the model
    @SuppressLint("SetTextI18n")
    override fun update(arg0: Observable, arg1: Any?) {
        // changing text of the buttons
        // according to updated values
        button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
        button2!!.text = "Count: " + myModel!!.getValueAtIndex(1)
        button3!!.text = "Count: " + myModel!!.getValueAtIndex(2)
    }
}