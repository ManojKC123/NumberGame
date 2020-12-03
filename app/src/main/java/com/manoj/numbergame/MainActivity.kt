package com.manoj.numbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnfirst: Button
    private lateinit var btnsecond: Button
    private lateinit var tvresulttext: TextView
    private lateinit var tvresult: TextView
    private lateinit var tvcorrecttext: TextView
    private lateinit var tvcorrect: TextView
    private lateinit var tvincorrecttext: TextView
    private lateinit var tvincorrect: TextView
    private lateinit var btnrestart: Button


    private var rnd1 : Int = 0 // generated random from 1 to 100 included
    private var rnd2 : Int = 0
    private var counter : Int = 0
    private var count : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnfirst = findViewById(R.id.btnfirst)
        btnsecond = findViewById(R.id.btnsecond)
        tvresult = findViewById(R.id.tvresult)
        tvresulttext = findViewById(R.id.tvresulttest)
        tvcorrect = findViewById(R.id.tvcorrect)
        tvcorrecttext = findViewById(R.id.tvcorrecttext)
        tvincorrect = findViewById(R.id.tvincorrect)
        tvincorrecttext = findViewById(R.id.tvincorrecttext)
        btnrestart = findViewById(R.id.btnrestart)

        valueInitialize()

        btnrestart.setOnClickListener{
            resetAll()
        }
    }

    private fun resetAll(){
        count = 0
        counter = 0
        btnfirst.isEnabled = true
        btnsecond.isEnabled = true
        tvresult.visibility = View.GONE
        tvresulttext.visibility = View.GONE
        tvcorrect.visibility = View.GONE
        tvcorrecttext.visibility = View.GONE
        tvincorrect.visibility = View.GONE
        tvincorrecttext.visibility = View.GONE
        btnrestart.visibility = View.GONE
        valueInitialize()

    }

    private fun valueInitialize(){
        counter++
        for (i in counter..11) {
            rnd1 = (0..100).random() // generated random from 1 to 100 included
            rnd2 = (0..100).random()
            if (rnd1 != rnd2) {
                btnfirst.text = rnd1.toString()
                btnsecond.text = rnd2.toString()
            }
        }
        if (counter==11) {
            btnfirst.isEnabled = false
            btnsecond.isEnabled = false
            tvresult.visibility = View.VISIBLE
            tvresulttext.visibility = View.VISIBLE
            tvcorrect.visibility = View.VISIBLE
            tvcorrecttext.visibility = View.VISIBLE
            tvincorrect.visibility = View.VISIBLE
            tvincorrecttext.visibility = View.VISIBLE
            btnrestart.visibility = View.VISIBLE
            var correct = tvcorrect.text.toString().toInt()
            var incorrect = tvincorrect.text.toString().toInt()
            if (correct > incorrect) {
                tvresult.text = "Won"
            }
            else if (correct == incorrect)
            {
                tvresult.text = "Draw"
            }
            else {
                tvresult.text = "Lost"
            }

        }
    }


    fun onClickbtn1(view: View) {
        var first = btnfirst.text.toString().toInt()
        var second = btnsecond.text.toString().toInt()
        if(first>second){
            count++
        }
        valueInitialize()
        tvcorrect.text = count.toString()
        var incorrect = 10-count
        tvincorrect.text = incorrect.toString()
    }



    fun onClickbtn2(view: View) {
        var first = btnfirst.text.toString().toInt()
        var second = btnsecond.text.toString().toInt()
        if(second>first){
            count++
        }
        valueInitialize()
        tvcorrect.text = count.toString()
        var incorrect = 10-count
        tvincorrect.text = incorrect.toString()
    }

}