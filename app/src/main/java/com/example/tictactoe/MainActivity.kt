package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetbutton: Button

    private var firstplayer = ArrayList<Int>()
    private var secondplayer = ArrayList<Int>()

    private var activeplayer = 1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetbutton=findViewById(R.id.resetbutton)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resetbutton.setOnClickListener{
            button1.isEnabled= true
            button2.isEnabled= true
            button3.isEnabled= true
            button4.isEnabled= true
            button5.isEnabled= true
            button6.isEnabled= true
            button7.isEnabled= true
            button8.isEnabled= true
            button9.isEnabled= true
            firstplayer.clear()
            secondplayer.clear()
            activeplayer=1
            button1.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button2.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button3.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button4.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button5.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button6.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button7.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button8.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button9.setBackgroundColor(Color.parseColor("#FF6200EE"))
            button1.text=""
            button2.text=""
            button3.text=""
            button4.text=""
            button5.text=""
            button6.text=""
            button7.text=""
            button8.text=""
            button9.text=""
        }



    }



    override fun onClick(clickedView: View?) {

        if (clickedView is Button){

            var buttonNumber = 0
             when(clickedView.id) {
                 R.id.button1 -> buttonNumber = 1
                 R.id.button2 -> buttonNumber = 2
                 R.id.button3 -> buttonNumber = 3
                 R.id.button4 -> buttonNumber = 4
                 R.id.button5 -> buttonNumber = 5
                 R.id.button6 -> buttonNumber = 6
                 R.id.button7 -> buttonNumber = 7
                 R.id.button8 -> buttonNumber = 8
                 R.id.button9 -> buttonNumber = 9

             }

            if (buttonNumber != 0 ){
                playGame(buttonNumber, clickedView)

            }

        }

    }


    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activeplayer ==1){
            clickedView.text ="X"
            clickedView.setBackgroundColor(Color.RED)
            firstplayer.add(buttonNumber)
            activeplayer = 2
        } else {

            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondplayer.add(buttonNumber)
            activeplayer = 1

        }
        clickedView.isEnabled = false
        check()

    }
    private fun check() {
        var winnerplayer = 0

        if (firstplayer.contains(1) && firstplayer.contains(2) && firstplayer.contains(3) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(1) && secondplayer.contains(2) && secondplayer.contains(3)){
            winnerplayer= 2

        }

        if (firstplayer.contains(4) && firstplayer.contains(5) && firstplayer.contains(6) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(4) && secondplayer.contains(5) && secondplayer.contains(6)){
            winnerplayer= 2

        }

        if (firstplayer.contains(7) && firstplayer.contains(8) && firstplayer.contains(9) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(7) && secondplayer.contains(8) && secondplayer.contains(9)){
            winnerplayer= 2

        }

        if (firstplayer.contains(1) && firstplayer.contains(4) && firstplayer.contains(7) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(1) && secondplayer.contains(4) && secondplayer.contains(7)){
            winnerplayer= 2

        }

        if (firstplayer.contains(3) && firstplayer.contains(6) && firstplayer.contains(9) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(3) && secondplayer.contains(6) && secondplayer.contains(9)){
            winnerplayer= 2

        }

        if (firstplayer.contains(1) && firstplayer.contains(5) && firstplayer.contains(9) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(1) && secondplayer.contains(5) && secondplayer.contains(9)){
            winnerplayer= 2

        }

        if (firstplayer.contains(3) && firstplayer.contains(5) && firstplayer.contains(7) ) {
            winnerplayer = 1

        }

        if (secondplayer.contains(3) && secondplayer.contains(5) && secondplayer.contains(7)){
            winnerplayer= 2

        }
        if (winnerplayer != 0){
            if (winnerplayer ==1){
                Toast.makeText(this, "X Wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "O Wins!", Toast.LENGTH_LONG).show()
            }
           disableButtons()

        }

    }
    private fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false


    }
    fun reset(){

    }



    }







