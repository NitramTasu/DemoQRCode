package com.example.martinschwans.demoqrcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        ytVideo.initialize("AIzaSyDFC0h9X3i6Xocr-49GBIPo5fkmfIuJyDo", this)
    }

    override fun onInitializationSuccess(
            provider: YouTubePlayer.Provider,
            player: YouTubePlayer,
            wasRestored: Boolean) {
        if (!wasRestored) {
            youTubePlayer = player
            youTubePlayer?.setFullscreen(true)
            youTubePlayer?.setShowFullscreenButton(false)
            player.cueVideo(intent.getStringExtra("YOUTUBE_CODE")); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            //player.loadVideo("https://www.youtube.com/watch?v=fhWaJi1Hsfo")
        }
    }
    override fun onInitializationFailure(provider: YouTubePlayer.Provider, errorReason: YouTubeInitializationResult) {
        val error = String.format("Erro", errorReason.toString())
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}
