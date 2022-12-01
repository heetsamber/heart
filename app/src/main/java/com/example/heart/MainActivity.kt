package com.example.heart

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.heart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val TAG : String = "Log"
    var isLiked : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        isLiked = false


            binding.LikeBtn.setOnClickListener{
                Log.d(TAG, "MainActivity - onCreate() / isLiked :${!isLiked}")

                if(isLiked == false){
                    val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(1000)

                    animator.addUpdateListener {
                        binding.LikeBtn.setProgress(
                            animator.getAnimatedValue() as Float
                        )
                    }
                    animator.start()
                    isLiked = true
                }else{
                    val animator = ValueAnimator.ofFloat(1f, 0f).setDuration(500)

                    animator.addUpdateListener {
                        binding.LikeBtn.setProgress(
                            animator.getAnimatedValue() as Float
                        )
                    }
                    animator.start()

                    isLiked = false
                }

            }





    }
}