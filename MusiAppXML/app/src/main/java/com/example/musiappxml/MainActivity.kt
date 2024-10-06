package com.example.musiappxml
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var playImageView: ImageView
    private lateinit var pauseImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        playImageView = findViewById(R.id.imageView2)
        pauseImageView = findViewById(R.id.imageView8)

        playImageView.setOnClickListener(this)
        pauseImageView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageView2 -> {
                playImageView.visibility = View.INVISIBLE
                pauseImageView.visibility = View.VISIBLE
            }
            R.id.imageView8 -> {
                pauseImageView.visibility = View.INVISIBLE
                playImageView.visibility = View.VISIBLE
            }
        }
    }
}
