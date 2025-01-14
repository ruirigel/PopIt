package com.example.myapplication

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.Html
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException
import java.time.LocalDateTime

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val currentVersion = 20241012

    private var timer: CountDownTimer? = null
    private var composer = "Track: Trell Daniels - "
    private val songList = listOf(
        R.raw.vanilla_sky,
        R.raw.euphoria,
        R.raw.interstate_5,
        R.raw.sanya,
        R.raw.dalia
    )
    private lateinit var player: MediaPlayer
    private var playedSongs = mutableListOf<Int>()
    private var playermp = true
    private var playermppaused = false
    private var redrandomofplays = 0
    private var grayrandomofplays = 0
    private var orangerandomofplays = 0
    private var starrandomofplays = 0
    private var numberofplays = 0
    private var mps = true
    private var numberr = 0
    private var numbero = 0
    private var numberg = 0
    private var numberstar = 0
    private val totalGreenButtons = 8
    private var numberofgreenbubblesclicket = 0
    private var fastSequence = 0
    private lateinit var auth: FirebaseAuth
    private var textViewCount = 0
    private lateinit var soundPool: SoundPool
    private var soundId1: Int = 0
    private var soundId2: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        auth = Firebase.auth

        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val countryCodeValue = tm.networkCountryIso
                val ldt = LocalDateTime.now().toString()
                signInAnonymously()

                devicename()
                getpublicipaddress()
                savecountrycode(countryCodeValue)
                savedatetime(ldt)
                savetimes()
                checkVersion()
                monitorScores()
                fetchFastSequence()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "No internet connection.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        soundPool = SoundPool.Builder().setMaxStreams(2).build()
        soundId1 = soundPool.load(this@MainActivity, R.raw.popit, 1)
        soundId2 = soundPool.load(this@MainActivity, R.raw.colorbubbles, 1)

        playSong()
        plays()

        val btnClick20 = findViewById<Button>(R.id.button20)
        btnClick20.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)
            }
            vibratePhone()
            btnClick20.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick20.text)
            btnClick20.text = null
            dropButton(R.id.button20)
        }

        val btnClick21 = findViewById<Button>(R.id.button21)
        btnClick21.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick21.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick21.text)
            btnClick21.text = null
            dropButton(R.id.button21)
        }

        val btnClick22 = findViewById<Button>(R.id.button22)
        btnClick22.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick22.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick22.text)
            btnClick22.text = null
            dropButton(R.id.button22)
        }

        val btnClick23 = findViewById<Button>(R.id.button23)
        btnClick23.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick23.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick23.text)
            btnClick23.text = null
            dropButton(R.id.button23)
        }

        val btnClick24 = findViewById<Button>(R.id.button24)
        btnClick24.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick24.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick24.text)
            btnClick24.text = null
            dropButton(R.id.button24)
        }

        val btnClick25 = findViewById<Button>(R.id.button25)
        btnClick25.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick25.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick25.text)
            btnClick25.text = null
            dropButton(R.id.button25)
        }

        val btnClick26 = findViewById<Button>(R.id.button26)
        btnClick26.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick26.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick26.text)
            btnClick26.text = null
            dropButton(R.id.button26)
        }

        val btnClick27 = findViewById<Button>(R.id.button27)
        btnClick27.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick27.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick27.text)
            btnClick27.text = null
            dropButton(R.id.button27)
        }

        val btnClick28 = findViewById<Button>(R.id.button28)
        btnClick28.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick28.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick28.text)
            btnClick28.text = null
            dropButton(R.id.button28)
        }

        val btnClick29 = findViewById<Button>(R.id.button29)
        btnClick29.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick29.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick29.text)
            btnClick29.text = null
            dropButton(R.id.button29)
        }

        val btnClick30 = findViewById<Button>(R.id.button30)
        btnClick30.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick30.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick30.text)
            btnClick30.text = null
            dropButton(R.id.button30)
        }

        val btnClick31 = findViewById<Button>(R.id.button31)
        btnClick31.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick31.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick31.text)
            btnClick31.text = null
            dropButton(R.id.button31)
        }

        val btnClick32 = findViewById<Button>(R.id.button32)
        btnClick32.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick32.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick32.text)
            btnClick32.text = null
            dropButton(R.id.button32)
        }

        val btnClick33 = findViewById<Button>(R.id.button33)
        btnClick33.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick33.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick33.text)
            btnClick33.text = null
            dropButton(R.id.button33)
        }

        val btnClick34 = findViewById<Button>(R.id.button34)
        btnClick34.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick34.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick34.text)
            btnClick34.text = null
            dropButton(R.id.button34)
        }

        val btnClick35 = findViewById<Button>(R.id.button35)
        btnClick35.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick35.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick35.text)
            btnClick35.text = null
            dropButton(R.id.button35)
        }

        val btnClick36 = findViewById<Button>(R.id.button36)
        btnClick36.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick36.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick36.text)
            btnClick36.text = null
            dropButton(R.id.button36)
        }

        val btnClick37 = findViewById<Button>(R.id.button37)
        btnClick37.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            btnClick37.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick37.text)
            btnClick37.text = null
            dropButton(R.id.button37)
        }


        val btnClick38 = findViewById<Button>(R.id.button38)
        btnClick38.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            if (numberofgreenbubblesclicket == totalGreenButtons) {
                saveFastSequence(fastSequence.toString())
            }
            generate()
            btnClick38.setBackgroundColor(Color.parseColor("#3F51B4"))
            btnClick38.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
        }

        val btnClick39 = findViewById<Button>(R.id.button39)
        btnClick39.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            showscore()
            btnClick39.setBackgroundColor(Color.parseColor("#5587ED"))
        }

        val btnClick40 = findViewById<Button>(R.id.button40)
        btnClick40.setOnClickListener {
            if (mps) {
                soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            }
            vibratePhone()
            if (player.isPlaying) {
                btnClick40.setBackgroundColor(Color.parseColor("#3F51B4"))
                player.pause()
                playermp = false
                playermppaused = true
            } else {
                btnClick40.setBackgroundColor(Color.parseColor("#009688"))
                player.start()
                playermp = true
                playermppaused = false
            }
        }

        val btnClick41 = findViewById<Button>(R.id.button41)
        btnClick41.setOnClickListener {
            soundPool.play(soundId1, 0.1f, 0.1f, 1, 0, 1f)

            vibratePhone()
            Thread.sleep(200)
            if (mps) {
                btnClick41.setBackgroundColor(Color.parseColor("#3F51B4"))
                val myImageView: ImageView = findViewById(R.id.imageView4)
                myImageView.setImageResource(R.drawable.vibrate)
                mps = false
            } else {
                btnClick41.setBackgroundColor(Color.parseColor("#4CAF50"))
                val myImageView: ImageView = findViewById(R.id.imageView4)
                myImageView.setImageResource(R.drawable.musical_note1)
                mps = true
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun generate() {

        if (numberofplays == 30) {
            numberofplays = 1
            plays()
        }

        val buttonIds = arrayOf(
            R.id.button20,
            R.id.button21,
            R.id.button22,
            R.id.button23,
            R.id.button24,
            R.id.button25,
            R.id.button26,
            R.id.button27,
            R.id.button28,
            R.id.button29,
            R.id.button30,
            R.id.button31,
            R.id.button32,
            R.id.button33,
            R.id.button34,
            R.id.button35,
            R.id.button36,
            R.id.button37,
        )
        for (i in 0..17) {
            val buttons = findViewById<Button>(buttonIds[i])
            buttons.setBackgroundColor(Color.parseColor("#3F51B4"))
            buttons.isEnabled = true
            buttons.isClickable = true
            buttons.text = " "

            buttons.animate()
                .translationY(0f)
                .setDuration(200)
                .start()
        }

        numberofgreenbubblesclicket = 0
        val min = 0
        val max = 17
        val randomIndices = (min..max).shuffled().take(totalGreenButtons)
        for (index in randomIndices) {
            val button = findViewById<Button>(buttonIds[index])
            button.setBackgroundColor(Color.GREEN)
            button.text = "+1"
            button.setTextColor(Color.TRANSPARENT)
        }

        if (numberofplays == redrandomofplays) {
            val minRedBubble = 0
            val maxRedBubble = 17
            numberr = (minRedBubble..maxRedBubble).random()
            val buttonsr = findViewById<Button>(buttonIds[numberr])
            buttonsr.setBackgroundColor(Color.RED)
            buttonsr.text = "+30"
            buttonsr.textSize = 24f
            buttonsr.setTextColor(Color.TRANSPARENT)
            buttonsr.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            soundPool.play(soundId2, 1f, 1f, 1, 0, 1f)
        }
        if (numberofplays == orangerandomofplays) {
            val minOrangeBubble = 0
            val maxOrangeBubble = 17
            numbero = (minOrangeBubble..maxOrangeBubble).random()
            val buttonso = findViewById<Button>(buttonIds[numbero])
            buttonso.setBackgroundColor(Color.parseColor("#FFC107"))
            buttonso.text = "+15"
            buttonso.textSize = 24f
            buttonso.setTextColor(Color.TRANSPARENT)
            buttonso.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            soundPool.play(soundId2, 1f, 1f, 1, 0, 1f)
        }
        if (numberofplays == grayrandomofplays) {
            val minGrayBubble = 0
            val maxGrayBubble = 17
            numberg = (minGrayBubble..maxGrayBubble).random()
            val buttonsg = findViewById<Button>(buttonIds[numberg])
            buttonsg.setBackgroundColor(Color.GRAY)
            buttonsg.text = "+10"
            buttonsg.textSize = 24f
            buttonsg.setTextColor(Color.TRANSPARENT)
            buttonsg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            soundPool.play(soundId2, 1f, 1f, 1, 0, 1f)
        }
        if (numberofplays == starrandomofplays) {
            val minStarBubble = 0
            val maxStarBubble = 17
            numberstar = (minStarBubble..maxStarBubble).random()
            val buttonss = findViewById<Button>(buttonIds[numberstar])
            buttonss.setBackgroundColor(Color.parseColor("#009688"))
            buttonss.text = Html.fromHtml("<font color='#009688'>⭐</font>")
            buttonss.textSize = 44f
            buttonss.setTextColor(Color.parseColor("#2B2D30"))
            buttonss.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            soundPool.play(soundId2, 1f, 1f, 1, 0, 1f)
        }

        numberofplays++
        timer?.cancel()
        timer = null
        mcountdown()
    }

    private fun mcountdown() {
        val btnClick38 = findViewById<Button>(R.id.button38)
        timer = object : CountDownTimer(4000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                btnClick38.text = (millisUntilFinished / 1000).toString()
                fastSequence = 4000 - millisUntilFinished.toInt()
                val totalTime = 4000
                val fraction = 1 - (millisUntilFinished.toFloat() / totalTime)
                val startColor = Color.parseColor("#00FF00")
                val endColor = Color.parseColor("#FF0000")
                val evaluator = ArgbEvaluator()
                val currentColor = evaluator.evaluate(fraction, startColor, endColor) as Int
                btnClick38.setBackgroundColor(currentColor)
            }

            override fun onFinish() {
                val buttonIds = arrayOf(
                    R.id.button20,
                    R.id.button21,
                    R.id.button22,
                    R.id.button23,
                    R.id.button24,
                    R.id.button25,
                    R.id.button26,
                    R.id.button27,
                    R.id.button28,
                    R.id.button29,
                    R.id.button30,
                    R.id.button31,
                    R.id.button32,
                    R.id.button33,
                    R.id.button34,
                    R.id.button35,
                    R.id.button36,
                    R.id.button37
                )
                for (i in 0..17) {
                    val buttons = findViewById<Button>(buttonIds[i])
                    buttons.isEnabled = false
                    buttons.isClickable = false
                }
                btnClick38.setBackgroundColor(Color.parseColor("#3F51B4"))
            }
        }.start()
    }

    private fun dropButton(arg1: Int) {
        val buttons = findViewById<Button>(arg1)
        val animator = ObjectAnimator.ofFloat(buttons, "translationY", 0f, 3000f)
        animator.duration = 300
        animator.start()
    }

    @SuppressLint("HardwareIds")
    private fun fetchFastSequence() {
        val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val rootRef = FirebaseDatabase.getInstance().reference
        val userRef = rootRef.child("/data/$id")

        userRef.child("fast_sequence").addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                val fastSequence = snapshot.getValue(String::class.java)

                if (!fastSequence.isNullOrEmpty()) {
                    val textView3: TextView = findViewById(R.id.textView3)
                    textView3.text = "${fastSequence}ms"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("fetchFastSequence", "Error fetching fast_sequence: ${error.message}")
            }
        })
    }

    @SuppressLint("HardwareIds")
    private fun savetimes() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")

                    myRef.child("times")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val timesvalue = snapshot.value?.toString()

                                if (!timesvalue.isNullOrEmpty() && timesvalue != "null") {
                                    try {
                                        val num: Int = timesvalue.toInt()
                                        val result = num + 1
                                        myRef.child("times").setValue(result)
                                    } catch (e: NumberFormatException) {
                                        Log.e("saveTimes", "Invalid number format: ${e.message}")
                                    }
                                } else {
                                    Log.e("saveTimes", "Value is empty or null")
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e("saveTimes", "Database error: ${error.message}")
                            }
                        })
                } catch (e: Exception) {
                    Log.e("saveTimes", "Error: ${e.message}")
                }
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun savedatetime(arg1: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")
                    myRef.child("date").setValue(arg1)
                } catch (e: Exception) {
                    Log.e("saveDateTime", "Error: ${e.message}")
                }
            }
        }
    }

    @SuppressLint("HardwareIds", "SetTextI18n")
    private fun saveFastSequence(newFastSequence: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")

                    myRef.child("fast_sequence").get().addOnSuccessListener { snapshot ->
                        val currentFastSequenceStr = snapshot.getValue(String::class.java)
                        val currentFastSequence =
                            currentFastSequenceStr?.toDoubleOrNull() ?: Double.MAX_VALUE
                        val newFastSequenceValue =
                            newFastSequence.toDoubleOrNull() ?: Double.MAX_VALUE
                        if (newFastSequenceValue < currentFastSequence) {
                            val textView3: TextView = findViewById(R.id.textView3)
                            textView3.text = "${newFastSequence}ms"
                            val imageView3: ImageView = findViewById(R.id.imageView3)
                            imageView3.startAnimation(
                                AnimationUtils.loadAnimation(
                                    this@MainActivity,
                                    R.anim.fade_in_out_score
                                )
                            )
                            textView3.startAnimation(
                                AnimationUtils.loadAnimation(
                                    this@MainActivity,
                                    R.anim.fade_in_out_score
                                )
                            )

                            compareScoresAndSequences(id, newFastSequence)

                            myRef.child("fast_sequence").setValue(newFastSequence)
                                .addOnSuccessListener {
                                }.addOnFailureListener { exception ->
                                    Log.e(
                                        "saveFastSequence",
                                        "Error updating value: ${exception.message}"
                                    )
                                }
                        } else {
                            val textView4: TextView = findViewById(R.id.textView4)
                            textView4.text = "${newFastSequence}ms"
                            textView4.startAnimation(
                                AnimationUtils.loadAnimation(
                                    this@MainActivity,
                                    R.anim.move_down_fade_out
                                )
                            )
                            textView4.startAnimation(
                                AnimationUtils.loadAnimation(
                                    this@MainActivity,
                                    R.anim.move_down_fade_out
                                )
                            )
                        }
                    }.addOnFailureListener { exception ->
                        Log.e(
                            "saveFastSequence",
                            "Error reading current fast_sequence: ${exception.message}"
                        )
                    }
                } catch (e: Exception) {
                    Log.e("saveFastSequence", "Error: ${e.message}")
                }
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun savecountrycode(arg1: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")
                    if (arg1.isNotEmpty()) {
                        myRef.child("country").setValue(arg1)
                    } else {
                        myRef.child("country").setValue("n/a")

                    }
                } catch (e: Exception) {
                    Log.e("saveCountryCode", "Error: ${e.message}")
                }
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun savescore(arg1: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")

                    myRef.child("score")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val scorevalue = snapshot.value.toString()
                                if (scorevalue.isNotEmpty()) {
                                    val numa: Int = scorevalue.toInt()
                                    val numb: Int = arg1.toInt()

                                    val result: Int = if (numb == 0) {
                                        numa - 10
                                    } else {
                                        numa + numb
                                    }
                                    val finalresult = result.toString()
                                    myRef.child("score").setValue(finalresult)

                                    val textView1: TextView = findViewById(R.id.textView1)
                                    val scorevaluenow: String = textView1.text.toString()
                                    val numanow: Int = scorevaluenow.toInt()
                                    val numbnow: Int = arg1.toInt()

                                    val resultnow: Int = if (numb == 0) {
                                        numanow - 10
                                    } else {
                                        numanow + numbnow
                                    }
                                    textView1.text = resultnow.toString()

                                    if (textView1.text.contains("-")) {
                                        textView1.setTextColor(Color.parseColor("#FF0000"))
                                    } else {
                                        textView1.setTextColor(Color.parseColor("#009688"))
                                    }

                                    val constraintLayout: ConstraintLayout =
                                        findViewById(R.id.constraint_layout)

                                    val textView5: TextView = findViewById(R.id.textView5)

                                    createTextViewWithAnimation(
                                        constraintLayout,
                                        textView5,
                                        scorevaluenow
                                    )

                                    saveReputation()

                                } else {
                                    Log.e("saveScore", "Value string is empty or null")
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e("saveScore", "Error: ${error.message}")
                            }
                        })

                } catch (e: Exception) {
                    Log.e("saveScore", "Error: ${e.message}")
                }
            }
        }
    }

    private fun createTextViewWithAnimation(
        constraintLayout: ConstraintLayout,
        originalTextView: TextView,
        scorevaluenow: String
    ) {
        val newTextView = TextView(this).apply {
            this.id = View.generateViewId()
            this.text = scorevaluenow
            this.textSize = originalTextView.textSize / resources.displayMetrics.scaledDensity
            this.setTextColor(originalTextView.currentTextColor)
            this.typeface = originalTextView.typeface
            this.setPadding(
                originalTextView.paddingLeft,
                originalTextView.paddingTop,
                originalTextView.paddingRight,
                originalTextView.paddingBottom
            )
        }

        textViewCount++

        constraintLayout.addView(newTextView)

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        constraintSet.connect(
            newTextView.id,
            ConstraintSet.START,
            R.id.imageView2,
            ConstraintSet.END
        )
        constraintSet.connect(
            newTextView.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP
        )
        constraintSet.setMargin(
            newTextView.id,
            ConstraintSet.TOP,
            15
        )

        constraintSet.applyTo(constraintLayout)

        val animation =
            AnimationUtils.loadAnimation(this@MainActivity, R.anim.move_down_fade_out_score)
        newTextView.startAnimation(animation)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                newTextView.postDelayed({
                    if (newTextView.parent != null) {
                        constraintLayout.removeView(newTextView)
                    }
                }, 100)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }

    @SuppressLint("HardwareIds")
    @Suppress("SameParameterValue")
    private fun savestars(arg1: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")
                    myRef.child("stars")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val scorestarsvalue = snapshot.value.toString()
                                if (scorestarsvalue.isNotEmpty()) {
                                    val numstarsa: Int = scorestarsvalue.toInt()
                                    val numstarsb: Int = arg1.toInt()
                                    val resultstars = numstarsa + numstarsb
                                    val finalstarsresult = resultstars.toString()
                                    myRef.child("stars").setValue(finalstarsresult)

                                    val textView2: TextView = findViewById(R.id.textView2)
                                    val scorevaluestarsnow: String = textView2.text.toString()
                                    val numastarsnow: Int = scorevaluestarsnow.toInt()
                                    val numbstarsnow: Int = arg1.toInt()
                                    val resultstarsnow = numbstarsnow + numastarsnow
                                    val finalresultstarsnow = resultstarsnow.toString()
                                    textView2.text = finalresultstarsnow

                                    val textView6: TextView = findViewById(R.id.textView6)
                                    textView6.text = scorevaluestarsnow
                                    textView6.startAnimation(
                                        AnimationUtils.loadAnimation(
                                            this@MainActivity,
                                            R.anim.move_down_fade_out
                                        )
                                    )
                                    textView6.startAnimation(
                                        AnimationUtils.loadAnimation(
                                            this@MainActivity,
                                            R.anim.move_down_fade_out
                                        )
                                    )

                                } else {
                                    Log.e("saveStars", "Value string is empty or null")
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                // Handle any errors or cancellation
                            }
                        })
                } catch (e: Exception) {
                    Log.e("saveStars", "Error: ${e.message}")
                }
            }
        }
    }

    data class UserScore(
        val name: String,
        val score: Int,
        val stars: Int,
        val fastSequence: Int,
        val awards: Int,
        val reputation: Int,
        val times: Int
    )

    @SuppressLint("InflateParams")
    private fun showscore() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val usersRef = rootRef.child("data")
                    val builder = AlertDialog.Builder(this@MainActivity)

                    val customView = layoutInflater.inflate(R.layout.custom_dialog_title, null)
                    builder.setView(customView)

                    val btnFilterScore: Button = customView.findViewById(R.id.btn_filter_score)
                    val btnFilterStars: Button = customView.findViewById(R.id.btn_filter_stars)
                    val btnFilterFastSequence: Button =
                        customView.findViewById(R.id.btn_filter_fast_sequence)
                    val btnFilterAwards: Button = customView.findViewById(R.id.btn_filter_awards)
                    val btnFilterReputation: Button =
                        customView.findViewById(R.id.btn_filter_reputation)
                    val btnFilterTimes: Button = customView.findViewById(R.id.btn_filter_times)

                    val scoreListView: ListView = customView.findViewById(R.id.score_list_view)

                    usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val usersList = mutableListOf<UserScore>()
                            val nameToUserIdMap = mutableMapOf<String, String>()

                            for (userSnapshot in snapshot.children) {
                                val userId = userSnapshot.key
                                if (userSnapshot.child("name")
                                        .exists() && userSnapshot.child("score")
                                        .exists() &&
                                    userSnapshot.child("stars")
                                        .exists() && userSnapshot.child("fast_sequence").exists()
                                ) {

                                    val name =
                                        userSnapshot.child("name").getValue(String::class.java)
                                    val scoreStr =
                                        userSnapshot.child("score").getValue(String::class.java)
                                    val starsStr =
                                        userSnapshot.child("stars").getValue(String::class.java)
                                    val fastSequenceStr =
                                        userSnapshot.child("fast_sequence")
                                            .getValue(String::class.java)
                                    val awardsStr =
                                        userSnapshot.child("awards").getValue(String::class.java)
                                    val reputationStr =
                                        userSnapshot.child("reputation")
                                            .getValue(String::class.java)
                                    val timesStr =
                                        userSnapshot.child("times").getValue(Int::class.java)

                                    if (name != null && scoreStr != null && starsStr != null && fastSequenceStr != null && awardsStr != null && reputationStr != null && timesStr != null && userId != null) {
                                        val score = scoreStr.toIntOrNull() ?: 0
                                        val stars = starsStr.toIntOrNull() ?: 0
                                        val fastSequence = fastSequenceStr.toIntOrNull() ?: 0
                                        val awards = awardsStr.toIntOrNull() ?: 0
                                        val reputation = reputationStr.toIntOrNull() ?: 0
                                        val times = timesStr
                                        usersList.add(
                                            UserScore(
                                                name,
                                                score,
                                                stars,
                                                fastSequence,
                                                awards,
                                                reputation,
                                                times
                                            )
                                        )
                                        nameToUserIdMap[name] = userId
                                    }
                                }
                            }

                            fun updateScoreList(filter: String) {
                                val filteredList = when (filter) {
                                    "Score" -> usersList.sortedByDescending { it.score }
                                    "Stars" -> usersList.sortedByDescending { it.stars }
                                    "Fast Sequence" -> usersList.sortedBy { it.fastSequence }
                                    "Awards" -> usersList.sortedByDescending { it.awards }
                                    "Reputation" -> usersList.sortedByDescending { it.reputation }
                                    "Times" -> usersList.sortedByDescending { it.times }

                                    else -> usersList
                                }.take(7)

                                val scoreAdapter = object : ArrayAdapter<UserScore>(
                                    this@MainActivity,
                                    R.layout.custom_list_item,
                                    filteredList
                                ) {
                                    override fun getView(
                                        position: Int,
                                        convertView: View?,
                                        parent: ViewGroup
                                    ): View {
                                        val view = convertView
                                            ?: layoutInflater.inflate(
                                                R.layout.custom_list_item,
                                                null
                                            )

                                        val nameTextView =
                                            view.findViewById<TextView>(R.id.nameTextView)
                                        val scoreTextView =
                                            view.findViewById<TextView>(R.id.scoreTextView)
                                        val rankTextView =
                                            view.findViewById<TextView>(R.id.rankTextView)

                                        val userScore = filteredList[position]

                                        nameTextView.text = userScore.name
                                        scoreTextView.text =
                                            getString(R.string.score_text, userScore.score)
                                        rankTextView.text =
                                            getString(R.string.rank_text, position + 1)

                                        return view
                                    }
                                }

                                scoreListView.adapter = scoreAdapter

                                scoreListView.setOnItemClickListener { _, _, position, _ ->
                                    val selectedName = filteredList[position].name
                                    val userId = nameToUserIdMap[selectedName]
                                    userId?.let { showUserProfileDialog(it) }
                                }
                            }

                            fun toggleButton(selectedButton: Button) {
                                val buttons =
                                    listOf(
                                        btnFilterScore,
                                        btnFilterStars,
                                        btnFilterFastSequence,
                                        btnFilterAwards,
                                        btnFilterReputation,
                                        btnFilterTimes
                                    )

                                for (button in buttons) {
                                    if (button == selectedButton) {
                                        button.setBackgroundColor(Color.parseColor("#4CAF50"))
                                        button.setTextColor(Color.BLACK)
                                    } else {
                                        button.setBackgroundColor(Color.parseColor("#009688"))
                                        button.setTextColor(Color.BLACK)
                                    }
                                }
                            }

                            btnFilterScore.setOnClickListener {
                                toggleButton(btnFilterScore)
                                updateScoreList("Score")
                            }
                            btnFilterStars.setOnClickListener {
                                toggleButton(btnFilterStars)
                                updateScoreList("Stars")
                            }
                            btnFilterFastSequence.setOnClickListener {
                                toggleButton(btnFilterFastSequence)
                                updateScoreList("Fast Sequence")
                            }
                            btnFilterAwards.setOnClickListener {
                                toggleButton(btnFilterAwards)
                                updateScoreList("Awards")
                            }
                            btnFilterReputation.setOnClickListener {
                                toggleButton(btnFilterReputation)
                                updateScoreList("Reputation")
                            }
                            btnFilterTimes.setOnClickListener {
                                toggleButton(btnFilterTimes)
                                updateScoreList("Times")
                            }

                            updateScoreList("Score")

                            toggleButton(btnFilterScore)

                            builder.setNegativeButton("Close") { dialog, _ -> dialog.cancel() }

                            val dialog = builder.create()
                            dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
                            dialog.show()
                            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                                .setTextColor(getResources().getColor(R.color.dialog_buttons))
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.e("showScore", "Error reading data: ${error.message}")
                        }
                    })
                } catch (e: Exception) {
                    Log.e("showScore", "Error: ${e.message}")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "No internet connection. To see the score board.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    private fun showUserProfileDialog(userId: String) {
        val rootRef = FirebaseDatabase.getInstance().reference
        val userRef = rootRef.child("data").child(userId)

        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("InflateParams")
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val builder = AlertDialog.Builder(this@MainActivity)
                    val view = layoutInflater.inflate(R.layout.user_profile_layout, null)
                    val textViewName = view.findViewById<TextView>(R.id.profile_name)
                    val textView = view.findViewById<TextView>(R.id.profile_text)
                    val imageView = view.findViewById<ImageView>(R.id.profile_image)

                    val name = snapshot.child("name").getValue(String::class.java) ?: "N/A"
                    val score = snapshot.child("score").getValue(String::class.java) ?: "N/A"
                    val stars = snapshot.child("stars").getValue(String::class.java) ?: "N/A"
                    val fastSequence =
                        snapshot.child("fast_sequence").getValue(String::class.java) ?: "N/A"
                    val reputation =
                        snapshot.child("reputation").getValue(String::class.java) ?: "N/A"
                    val awards = snapshot.child("awards").getValue(String::class.java) ?: "N/A"
                    val times = snapshot.child("times").let {
                        when (it.value) {
                            is Long -> (it.value as Long).toInt()
                            is String -> try {
                                it.value.toString().toInt()
                            } catch (e: NumberFormatException) {
                                Log.e("UserProfileDialog", "Invalid times format: ${it.value}")
                                0
                            }

                            else -> 0
                        }
                    }

                    val messageName = """
                    <font color="#FFFFFF"><b>$name</b></font>
                """.trimIndent()

                    textViewName.text = Html.fromHtml(messageName)

                    val messageText = """
                    <font color="#ADADAD">Score: $score </font><br><br>
                    <font color="#ADADAD">Stars: $stars </font><br>
                    <font color="#ADADAD">Fast sequence ever: $fastSequence ms</font><br>
                    <font color="#ADADAD">Awards: $awards</font><br>
                    <font color="#ADADAD">Reputation: $reputation </font><br>
                    <font color="#ADADAD">Times played: $times</font>
                """.trimIndent()
                    textView.text = Html.fromHtml(messageText)

                    imageView.setImageResource(R.drawable.userprofile)

                    builder.setView(view)
                    builder.setNegativeButton("Close") { dialog, _ ->
                        dialog.dismiss()
                        Handler(Looper.getMainLooper()).post {
                        }
                    }

                    val dialog = builder.create()
                    dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
                    dialog.show()
                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                        .setTextColor(getResources().getColor(R.color.dialog_buttons))

                } catch (e: Exception) {
                    Log.e("showUserProfileDialog", "Error showing the profile: ${e.message}")
                    e.printStackTrace()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("showUserProfileDialog", "Error accessing user data: ${error.message}")
            }
        })
    }

    @SuppressLint("HardwareIds")
    fun saveReputation() {
        val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val rootRef = FirebaseDatabase.getInstance().reference
        val usersRef = rootRef.child("/data/$id")

        usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("InflateParams")
            override fun onDataChange(snapshot: DataSnapshot) {
                val score = snapshot.child("score").getValue(String::class.java) ?: "N/A"
                val stars = snapshot.child("stars").getValue(String::class.java) ?: "N/A"
                val fastSequence =
                    snapshot.child("fast_sequence").getValue(String::class.java) ?: "N/A"
                val times = snapshot.child("times").let {
                    when (it.value) {
                        is Long -> (it.value as Long).toInt()
                        is String -> try {
                            it.value.toString().toInt()
                        } catch (e: NumberFormatException) {
                            Log.e("saveReputation", "Invalid times format: ${it.value}")
                            0
                        }

                        else -> 0
                    }
                }

                val reputationsvalues =
                    ((score.toInt() * 0.5) + (stars.toInt() * 2) - (times * 0.2) + (1000 / fastSequence.toInt())).toInt()
                usersRef.child("reputation").setValue(reputationsvalues.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("saveReputation", "Error accessing user data: ${error.message}")
            }
        })
    }

    private fun compareScoresAndSequences(id: String, newFastSequence: String) {
        val rootRef = FirebaseDatabase.getInstance().reference
        val userRef = rootRef.child("data").child(id)
        val giftRef =
            rootRef.child("data/winners/gift")

        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(userSnapshot: DataSnapshot) {
                if (userSnapshot.exists()) {
                    val score = userSnapshot.child("score").getValue(String::class.java)
                        ?: "0"
                    val stars = userSnapshot.child("stars").getValue(String::class.java)
                        ?: "0"
                    val reputation = userSnapshot.child("reputation").getValue(String::class.java)
                        ?: "0"
                    val times = userSnapshot.child("times").getValue(Int::class.java)
                        ?: 0

                    giftRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(giftSnapshot: DataSnapshot) {
                            if (giftSnapshot.exists()) {
                                val minScore =
                                    giftSnapshot.child("minscore").getValue(String::class.java)
                                        ?: "0"
                                val minFastSequence = giftSnapshot.child("minfastsequence")
                                    .getValue(String::class.java) ?: "0"
                                val minReputation = giftSnapshot.child("minreputation")
                                    .getValue(String::class.java) ?: "0"
                                val minStars = giftSnapshot.child("minstars")
                                    .getValue(String::class.java) ?: "0"
                                val minTimesPlayed = giftSnapshot.child("mintimesplayed")
                                    .getValue(String::class.java) ?: "0"
                                val sent = giftSnapshot.child("sent").getValue(Boolean::class.java)
                                    ?: false

                                try {
                                    val userScoreInt = score.toInt()
                                    val minScoreInt = minScore.toInt()
                                    val newFastSequenceInt = newFastSequence.toInt()
                                    val minFastSequenceInt = minFastSequence.toInt()
                                    val userStarsInt = stars.toInt()
                                    val userReputationInt = reputation.toInt()
                                    val userTimesInt = times
                                    val minStarsInt = minStars.toInt()
                                    val minReputationInt = minReputation.toInt()
                                    val minTimesPlayedInt = minTimesPlayed.toInt()

                                    if (userScoreInt > minScoreInt && newFastSequenceInt < minFastSequenceInt && userStarsInt > minStarsInt && userReputationInt > minReputationInt && userTimesInt > minTimesPlayedInt && !sent) {
                                        showWinnerDialog(id)
                                    }
                                } catch (e: NumberFormatException) {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Error of conversion of values.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Gift data not found.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Error retrieving gift data: ${error.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                } else {
                    Toast.makeText(this@MainActivity, "User data not found.", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@MainActivity,
                    "Error retrieving user data: ${error.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    @SuppressLint("SetTextI18n", "HardwareIds")
    fun showWinnerDialog(id: String) {
        val builder = AlertDialog.Builder(this@MainActivity)

        val customView = layoutInflater.inflate(R.layout.dialog_winner, null)
        builder.setView(customView)

        val giftCardImageView: ImageView = customView.findViewById(R.id.gift_card_image)
        giftCardImageView.setImageResource(R.drawable.roblox_gift_card)

        val dialog = builder.create()

        val rootRef = FirebaseDatabase.getInstance().reference
        val userRef = rootRef.child("data").child(id)

        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val email = snapshot.child("email").getValue(String::class.java) ?: ""
                    val winnerName = snapshot.child("name").getValue(String::class.java) ?: ""
                    val currentAwards = snapshot.child("awards").getValue(String::class.java) ?: ""
                    val newAwards = currentAwards.toInt() + 1
                    userRef.child("awards").setValue(newAwards.toString())

                    val giftRef = rootRef.child("data/winners/gift")
                    giftRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(giftSnapshot: DataSnapshot) {
                            if (giftSnapshot.exists()) {
                                val giftCardCode =
                                    giftSnapshot.child("code").getValue(String::class.java) ?: ""

                                val messageTextView: TextView =
                                    customView.findViewById(R.id.congratulations_message)
                                messageTextView.text =
                                    "Congratulations $winnerName, you won a gift card!"

                                val winnersRef = rootRef.child("data/winners").child(id).push()
                                val winnerData = mapOf(
                                    "winner" to winnerName,
                                    "email" to email,
                                    "date" to LocalDateTime.now().toString(),
                                    "code" to giftCardCode
                                )
                                winnersRef.setValue(winnerData)

                                giftRef.child("sent").setValue(true)

                                val claimPrizeButton: Button =
                                    customView.findViewById(R.id.btn_claim_prize)
                                claimPrizeButton.setOnClickListener {
                                    val clipboard =
                                        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Gift Card Code", giftCardCode)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Card code copied to clipboard!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    redirectToRobloxRedeem(giftCardCode)
                                    dialog.dismiss()
                                }
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Gift not found in the database.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Error retrieving gift card code: ${error.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Winner not found in the database.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@MainActivity,
                    "Error retrieving user data: ${error.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
        dialog.show()
    }

    private fun redirectToRobloxRedeem(giftCardCode: String) {
        val robloxRedeemUrl = "https://www.roblox.com/redeem?code=$giftCardCode"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(robloxRedeemUrl))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                this@MainActivity,
                "No browser applications installed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("HardwareIds")
    private fun getpublicipaddress() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val url = "https://api.ipify.org/"
                Thread {
                    try {
                        val connection = URL(url).openConnection() as HttpURLConnection
                        connection.requestMethod = "GET"
                        val inputStream = connection.inputStream
                        val reader = BufferedReader(InputStreamReader(inputStream))
                        val publicIP = reader.readLine()
                        reader.close()
                        val database = Firebase.database
                        val myRef = database.getReference("/data/$id")
                        myRef.child("address").setValue(publicIP)
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(
                            this@MainActivity,
                            "No internet connection?",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }.start()
            }
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    @Suppress("DEPRECATION")
    private fun vibratePhone() {
        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            v.vibrate(100)
        }
    }

    @SuppressLint("HardwareIds")
    private fun devicename() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")
                val device = Build.MODEL
                myRef.child("device").setValue(device)
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun firsttime() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")
                    myRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (!snapshot.exists()) {
                                askforusername()
                            } else {
                                val name = snapshot.child("name").getValue(String::class.java)
                                if (name.isNullOrEmpty()) {
                                    askforusername()
                                }
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {

                        }
                    })
                } catch (e: Exception) {
                    Log.e("firstTime", "Error: ${e.message}")
                }
            }
        }
    }

    @SuppressLint("HardwareIds", "InflateParams")
    private fun askforusername() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                try {
                    val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                    val database = Firebase.database
                    val myRef = database.getReference("/data/$id")

                    val view = layoutInflater.inflate(R.layout.user_registration_layout, null)

                    val emailInput = view.findViewById<EditText>(R.id.email_input)
                    val usernameInput = view.findViewById<EditText>(R.id.username_input)
                    val passwordInput = view.findViewById<EditText>(R.id.password_input)

                    val builder = AlertDialog.Builder(this@MainActivity)
                        .setView(view)
                        .setCancelable(false)
                        .setPositiveButton("Submit") { _, _ ->
                            val emailText = emailInput.text.toString().trim()
                            val usernameText = usernameInput.text.toString().trim()
                            val passwordText = passwordInput.text.toString().trim()
                            val currentTimeMillis = System.currentTimeMillis()

                            if (usernameText.isEmpty()) {
                                myRef.child("name").setValue("guest$currentTimeMillis")
                            } else {
                                myRef.child("name").setValue(usernameText)
                            }
                            myRef.child("email").setValue(emailText.ifEmpty { "n/a" })
                            myRef.child("password").setValue(passwordText.ifEmpty { "n/a" })
                            myRef.child("score").setValue("0")
                            myRef.child("times").setValue(1)
                            myRef.child("stars").setValue("0")
                            myRef.child("fast_sequence").setValue("4000")
                            myRef.child("reputation").setValue("0")
                            myRef.child("awards").setValue("0")

                        }
                        .setNegativeButton("Cancel") { dialog, _ ->
                            val currentTimeMillis = System.currentTimeMillis()
                            myRef.child("name").setValue("guest$currentTimeMillis")
                            myRef.child("score").setValue("0")
                            myRef.child("times").setValue(1)
                            myRef.child("stars").setValue("0")
                            myRef.child("fast_sequence").setValue("4000")
                            myRef.child("email").setValue("n/a")
                            myRef.child("password").setValue("n/a")
                            myRef.child("reputation").setValue("0")
                            myRef.child("awards").setValue("0")

                            dialog.cancel()
                        }

                    val dialog = builder.create()
                    dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
                    dialog.show()

                    dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                        .setTextColor(resources.getColor(R.color.dialog_buttons))
                    dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                        .setTextColor(resources.getColor(R.color.dialog_buttons))

                } catch (e: Exception) {
                    Log.e("askForUsername", "Error: ${e.message}")
                }
            }
        }
    }

    private suspend fun isonline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        val isConnected = capabilities != null && (
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                )

        if (isConnected) {
            return withContext(Dispatchers.IO) {
                try {
                    val url = URL("https://clients3.google.com/generate_204")
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "HEAD"
                    connection.connectTimeout = 2000
                    connection.readTimeout = 2000
                    connection.responseCode == 204
                } catch (e: Exception) {
                    false
                }
            }
        }

        return false
    }

    private fun plays() {
        val redminrandomofplays = 0
        val redmaxrandomofplays = 90
        redrandomofplays = (redminrandomofplays..redmaxrandomofplays).random()

        val orangeminrandomofplays = 0
        val orangemaxrandomofplays = 60
        orangerandomofplays = (orangeminrandomofplays..orangemaxrandomofplays).random()

        val grayminrandomofplays = 0
        val graymaxrandomofplays = 30
        grayrandomofplays = (grayminrandomofplays..graymaxrandomofplays).random()

        val starminrandomofplays = 0
        val starmaxrandomofplays = 50
        starrandomofplays = (starminrandomofplays..starmaxrandomofplays).random()
    }

    private fun playSong() {
        if (playedSongs.size == songList.size) {
            playedSongs.clear()
        }

        var randomIndex: Int
        do {
            randomIndex = songList.indices.random()
        } while (playedSongs.contains(songList[randomIndex]))

        playedSongs.add(songList[randomIndex])

        player = MediaPlayer.create(this@MainActivity, songList[randomIndex])
        val maxVolume = 100.0f
        val currVolume = 5.0f
        player.setVolume(currVolume / maxVolume, currVolume / maxVolume)

        player.start()
        Toast.makeText(
            baseContext,
            composer + resources.getResourceEntryName(songList[randomIndex]),
            Toast.LENGTH_LONG
        ).show()

        player.setOnCompletionListener {
            playSong()
        }
    }

    private fun checkButtonColor(arg1: CharSequence) {
        val imageView: ImageView = findViewById(R.id.imageView)
        val textView2: TextView = findViewById(R.id.textView2)
        val textView1: TextView = findViewById(R.id.textView1)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val textView7: TextView = findViewById(R.id.textView7)
        val fadeInOut = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in_out_score)

        when {
            arg1 == " " -> {
                imageView2.startAnimation(fadeInOut)
                textView1.startAnimation(fadeInOut)
                savescore("0")
            }

            arg1 == "+1" -> {
                numberofgreenbubblesclicket++
                savescore("1")
            }

            arg1 == "+10" -> {
                imageView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView7.text = arg1
                textView7.setTextColor(Color.GRAY)
                textView7.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.points_animation
                    )
                )
                savescore("10")
            }

            arg1 == "+15" -> {
                imageView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView7.text = arg1
                textView7.setTextColor(Color.parseColor("#FFC107"))
                textView7.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.points_animation
                    )
                )
                savescore("15")
            }

            arg1 == "+30" -> {
                imageView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView7.text = arg1
                textView7.setTextColor(Color.RED)
                textView7.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.points_animation
                    )
                )
                savescore("30")
            }

            arg1.contains("⭐") -> {
                imageView.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.fade_in_out_score
                    )
                )
                textView7.text = arg1
                textView7.setTextColor(Color.YELLOW)
                textView7.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.points_animation
                    )
                )
                savestars("1")
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (!hasFocus) {
            if (playermp) {
                player.pause()
                playermp = false
            }
        } else {
            if (!playermp && !playermppaused) {
                player.start()
                playermp = true
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun signInAnonymously() {
        auth.signInAnonymously()
            .addOnCompleteListener(this@MainActivity) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInAnonymously:success")
                    val user = auth.currentUser
                    updateUI(user)
                    firsttime()
                } else {
                    Log.w(TAG, "signInAnonymously:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_LONG,
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(@Suppress("UNUSED_PARAMETER") user: FirebaseUser?) {
    }

    companion object {
        private const val TAG = "AnonymousAuth"
    }

    private fun monitorScores() {
        CoroutineScope(Dispatchers.Main).launch {
            val isConnected = isonline(this@MainActivity)
            if (isConnected) {
                val database = FirebaseDatabase.getInstance()
                val usersRef = database.getReference("data")
                var topUser: Pair<String, Int>? = null
                var topUserName: String? = null

                usersRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var highestScore = 0
                        var highestScoreUser: Pair<String, String>? = null

                        for (userSnapshot in snapshot.children) {
                            val userId = userSnapshot.key ?: continue
                            val userName =
                                userSnapshot.child("name").getValue(String::class.java) ?: "Unknown"
                            val scoreString =
                                userSnapshot.child("score").getValue(String::class.java)
                            val score = scoreString?.toIntOrNull() ?: 0

                            if (score > highestScore) {
                                highestScore = score
                                highestScoreUser = Pair(userId, userName)
                            }
                        }

                        highestScoreUser?.let { newTopUser ->
                            topUser?.let { (oldUserId, oldScore) ->
                                if (newTopUser.first != oldUserId && highestScore > oldScore) {
                                    topUserName?.let { oldUserName ->
                                        onTopUserOvertaken(
                                            oldUserName,
                                            oldScore,
                                            newTopUser.second,
                                            highestScore
                                        )
                                    }
                                }
                            } ?: run {
                                topUser = Pair(newTopUser.first, highestScore)
                                topUserName = newTopUser.second
                            }

                            topUser = Pair(newTopUser.first, highestScore)
                            topUserName = newTopUser.second
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("ScoreActivity", "Database error: ${error.message}")
                    }
                })
            }
        }
    }

    private fun checkVersion() {
        val rawUrl =
            "https://raw.githubusercontent.com/ruirigel/popit/master/app/build.gradle.kts"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (!isonline(this@MainActivity)) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "No active internet connection.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    return@launch
                }

                val url = URL(rawUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                if (connection.responseCode == 200) {
                    val content = connection.inputStream.bufferedReader().use { it.readText() }

                    val versionLine = content.lines().find { it.contains("versionCode") }

                    val remoteVersion =
                        versionLine?.substringAfter("versionCode =")?.trim()?.toIntOrNull()

                    withContext(Dispatchers.Main) {
                        if (remoteVersion != null && remoteVersion > currentVersion) {
                            Toast.makeText(
                                this@MainActivity,
                                "New version available in the repo of this app. Version: $remoteVersion",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "Error: failed to check for updates.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                connection.disconnect()
            } catch (e: UnknownHostException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@MainActivity,
                        "Unable to resolve host. Please check your connection.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    private fun onTopUserOvertaken(
        oldUserName: String,
        oldScore: Int,
        newUserName: String,
        newScore: Int
    ) {
        Toast.makeText(
            this@MainActivity,
            "User $newUserName has reached first place now with a score of $newScore pts",
            Toast.LENGTH_LONG
        ).show()
    }

}

