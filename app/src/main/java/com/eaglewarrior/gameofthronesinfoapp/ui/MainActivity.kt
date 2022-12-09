package com.eaglewarrior.gameofthronesinfoapp.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.eaglewarrior.gameofthronesinfoapp.R
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullNameTextView = findViewById<TextView>(R.id.fullNameTextView)
        val titleTextView = findViewById<TextView>(R.id.titleTextview)
        val familyTextView = findViewById<TextView>(R.id.familyTextView)
        val imageView = findViewById<ImageView>(R.id.imageView)


        //        CoroutineScope(Dispatchers.IO).launch {
//            NetworkLayer.apiClient.getCharacterById(25)
//        }

        val viewModel: SharedViewModel by lazy {
            ViewModelProvider(this).get(SharedViewModel::class.java)
        }

        viewModel.refreshCharacter(34)
//        val response = repository.getCharacterById(characterId)
        viewModel.characterByIdLiveData.observe(this) {
            if (it == null) {
                Toast.makeText(
                    this@MainActivity,
                    "Unsuccessful network call!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            titleTextView.text = it?.title
            fullNameTextView.text = it?.fullName
            familyTextView.text = it?.family

            Picasso.get()
                .load(it?.imageUrl)
                .fit()
                .into(imageView)
            return@observe
        }


//        fireAndIceService.getCharacterById(40).enqueue(object : Callback<CharacterModel> {
//
//            override fun onResponse(call: Call<CharacterModel>, response: Response<CharacterModel>) {
//                Log.i("MainActivity", response.toString())
//
//                if (!response.isSuccessful) {
//                    Toast.makeText(this@MainActivity, "Unsuccessful network call!", Toast.LENGTH_SHORT)
//                    return
//                }
//
//                val body = response.body()!!
//


//
//            }
//
//            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
//                Log.i("MainActivity", t.message ?: "Null message")
//            }
//        })
//
//        fireAndIceService.getCharacters().enqueue(object : Callback<List<CharacterModel>> {
//
//            override fun onResponse(call: Call<List<CharacterModel>>, response: Response<List<CharacterModel>>) {
//                response.isSuccessful
//                Log.i("Characters", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<List<CharacterModel>>, t: Throwable) {
//                Log.i("Continents", t.message.toString())
//            }
//        })
//
//
//        fireAndIceService.getContinentById(2).enqueue(object : Callback<ContinentModel> {
//
//            override fun onResponse(call: Call<ContinentModel>, response: Response<ContinentModel>) {
//                Log.i("Continents", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<ContinentModel>, t: Throwable) {
//                Log.i("Continents", t.message.toString())
//            }
//        })
//
//
//        fireAndIceService.getContinents().enqueue(object : Callback<List<ContinentModel>> {
//            override fun onResponse(call: Call<List<ContinentModel>>, response: Response<List<ContinentModel>>) {
//                Log.i("Continent", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<List<ContinentModel>>, t: Throwable) {
//                Log.i("Content", t.message.toString())
//            }
//        })
    }
}
