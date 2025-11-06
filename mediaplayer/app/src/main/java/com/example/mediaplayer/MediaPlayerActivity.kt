package com.example.mediaplayer
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class MediaPlayerActivity : AppCompatActivity() {
    lateinit var mp: MediaPlayer
    lateinit var play: Button
    lateinit var pause: Button
    lateinit var next: Button
    lateinit var prev: Button
    lateinit var bar: SeekBar
    lateinit var title: TextView
    var songs = listOf(
        R.raw.song1,
        R.raw.song2,
        R.raw.song3
    )
    var names = listOf(
        "Кукла Колдуна - КиШ",
        "Лесник - КиШ",
        "Frozen - Cilver"
    )
    var current = 0
    var thread = Thread()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        play = findViewById(R.id.playbutton)
        pause = findViewById(R.id.pausebutton)
        next = findViewById(R.id.nextbutton)
        prev = findViewById(R.id.prevbutton)
        bar = findViewById(R.id.bar)
        title = findViewById(R.id.tracktitle)
        title.text = names[current]
        mp = MediaPlayer.create(this, songs[current])
        bar.max = mp.duration
        thread = Thread {
            try {
                while (true) {
                    if (mp.isPlaying) {
                        val pos = mp.currentPosition
                        runOnUiThread {
                            bar.progress = pos
                        }
                    }
                    Thread.sleep(500)
                }
            } catch (e: Exception) {}
        }
        thread.start()
        play.setOnClickListener {
            mp.start()
        }
        pause.setOnClickListener {
            mp.pause()
        }
        next.setOnClickListener {
            mp.stop()
            mp.release()
            current++
            if (current >= songs.size) current = 0
            mp = MediaPlayer.create(this, songs[current])
            title.text = names[current]
            bar.max = mp.duration
            mp.start()
        }
        prev.setOnClickListener {
            mp.stop()
            mp.release()
            current--
            if (current < 0) current = songs.size - 1
            mp = MediaPlayer.create(this, songs[current])
            title.text = names[current]
            bar.max = mp.duration
            mp.start()
        }
        bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mp.seekTo(progress)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        mp.release()
    }
}
