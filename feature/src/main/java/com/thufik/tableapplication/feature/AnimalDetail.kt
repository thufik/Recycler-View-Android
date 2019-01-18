package com.thufik.tableapplication.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class AnimalDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        this.supportActionBar?.title = "Animal details"

        val txtAnimal = findViewById<TextView>(R.id.txtAnimalName)

        val animalName = this.intent.getStringExtra("name")

        txtAnimal.text = animalName
    }
}

