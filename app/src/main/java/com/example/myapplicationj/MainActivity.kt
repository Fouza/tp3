package com.example.myapplicationj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listMot: MutableList<String> = mutableListOf("Why","When,'Whom","Where","What")
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        var points:Int = 0
        var motAleat:String
        var mot:String
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.rcv).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify a viewAdapter (see also next example)
            adapter = viewAdapter

        }


        /*while(true){
            score.text = "Votre score est : "+points
            motAleat = randomExtract(listMot)
            mot = editText.toString()
            if(mot == motAleat){
                points = points+5
                textView2.text = "Bravo !!! Vous avez obtenu 5 points"
            }
            else{
                textView2.text = "Echec !!! Le mot saisi n'est pas bon"
            }
        }*/

    }

    fun randomExtract(liste:List<String>):String{
        var i = (0..liste.size).random()
        return liste[i]
    }

}
