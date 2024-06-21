package com.flipcoindev.flipcoin

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.flipcoindev.flipcoin.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var coin:MediaPlayer
    private var numHeads = 0
    private var numTails = 0
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        onCoinTap()

    }

    private fun onCoinTap() {

        binding.ivCoin.setOnClickListener {
            var randomNum = Random()
            var randomNumber = randomNum.nextInt(2)



            if (randomNumber == 0){
                flipTheCoin(R.drawable.ic_heads, "Heads")

            }else {
                flipTheCoin(R.drawable.ic_tails, "Tails")

            }

        }
    }

    private fun flipTheCoin(imageId: Int, coinSide: String) {


            binding.ivCoin.animate()
            coin = MediaPlayer.create(this, R.raw.coin_flip)
            coin.start()
            binding.ivCoin.animate().setDuration(1000)
            binding.ivCoin.animate().rotationYBy(1800f)
            binding.ivCoin.isClickable = false

            binding.ivCoin.animate().withEndAction {
                coin.stop()
                binding.ivCoin.setImageResource(imageId)
                binding.coinSide.setText(coinSide)
                binding.ivCoin.isClickable = true
                /*if(coinSide.equals("Heads")){
                    ++numHeads
                    binding.textViewHeads.setText("Heads: " + numHeads)
                    binding.textViewTails.visibility=View.GONE
                    binding.textViewHeads.visibility=View.VISIBLE


                }else{
                    ++numTails
                    binding.textViewTails.setText("Tails: " + numTails)
                    binding.textViewHeads.visibility=View.GONE
                    binding.textViewTails.visibility=View.VISIBLE
                }*/
            }
            binding.ivCoin.animate().start()


    }



}