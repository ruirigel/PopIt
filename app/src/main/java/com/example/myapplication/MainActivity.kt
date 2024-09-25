package com.example.myapplication

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
import kotlinx.coroutines.delay
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

    private val currentVersion = 20240925

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        auth = Firebase.auth

        if (isonline(this)) {
            val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val countryCodeValue = tm.networkCountryIso
            val ldt = LocalDateTime.now().toString()
            signInAnonymously()
            firsttime()
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
                this,
                "No internet connection. Not having an internet connection does not invalidate playing on the app, it will just stop adding up the score board.",
                Toast.LENGTH_LONG
            ).show()
        }

        var mpb = MediaPlayer.create(this, R.raw.popit)
        playSong(songList, 0)
        plays()

        val btnClick20 = findViewById<Button>(R.id.button20)
        btnClick20.setOnClickListener {
            if (mps) {
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
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
                mpb.start()
            }
            vibratePhone()
            showscore()
            btnClick39.setBackgroundColor(Color.parseColor("#5587ED"))
        }

        val btnClick40 = findViewById<Button>(R.id.button40)
        btnClick40.setOnClickListener {
            if (mps) {
                mpb.start()
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
            mpb.start()
            vibratePhone()
            Thread.sleep(200)
            if (mps) {
                btnClick41.setBackgroundColor(Color.parseColor("#3F51B4"))
                mpb.stop()
                mps = false
            } else {
                btnClick41.setBackgroundColor(Color.parseColor("#4CAF50"))
                mpb = MediaPlayer.create(this, R.raw.popit)
                mpb.start()
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
            button.setTextColor(Color.GREEN)
        }
        val mpbs = MediaPlayer.create(this, R.raw.colorbubbles)
        if (numberofplays == redrandomofplays) {
            val minRedBubble = 0
            val maxRedBubble = 17
            numberr = (minRedBubble..maxRedBubble).random()
            val buttonsr = findViewById<Button>(buttonIds[numberr])
            buttonsr.setBackgroundColor(Color.RED)
            buttonsr.text = "+30"
            buttonsr.textSize = 24f
            buttonsr.setTextColor(Color.parseColor("#2B2D30"))
            buttonsr.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            mpbs.start()
        }
        if (numberofplays == orangerandomofplays) {
            val minOrangeBubble = 0
            val maxOrangeBubble = 17
            numbero = (minOrangeBubble..maxOrangeBubble).random()
            val buttonso = findViewById<Button>(buttonIds[numbero])
            buttonso.setBackgroundColor(Color.parseColor("#FFC107"))
            buttonso.text = "+15"
            buttonso.textSize = 24f
            buttonso.setTextColor(Color.parseColor("#2B2D30"))
            buttonso.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            mpbs.start()
        }
        if (numberofplays == grayrandomofplays) {
            val minGrayBubble = 0
            val maxGrayBubble = 17
            numberg = (minGrayBubble..maxGrayBubble).random()
            val buttonsg = findViewById<Button>(buttonIds[numberg])
            buttonsg.setBackgroundColor(Color.GRAY)
            buttonsg.text = "+10"
            buttonsg.textSize = 24f
            buttonsg.setTextColor(Color.parseColor("#2B2D30"))
            buttonsg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            mpbs.start()
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
            mpbs.start()
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
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")

                myRef.child("times").addListenerForSingleValueEvent(object : ValueEventListener {
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

    @SuppressLint("HardwareIds")
    private fun savedatetime(arg1: String) {
        if (isonline(this)) {
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

    @SuppressLint("HardwareIds")
    private fun saveFastSequence(newFastSequence: String) {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")

                myRef.child("fast_sequence").get().addOnSuccessListener { snapshot ->
                    val currentFastSequenceStr = snapshot.getValue(String::class.java)
                    val currentFastSequence =
                        currentFastSequenceStr?.toDoubleOrNull() ?: Double.MAX_VALUE
                    val newFastSequenceValue = newFastSequence.toDoubleOrNull() ?: Double.MAX_VALUE
                    if (newFastSequenceValue < currentFastSequence) {
                        val textView3: TextView = findViewById(R.id.textView3)
                        textView3.text = "${newFastSequence}ms"
                        myRef.child("fast_sequence").setValue(newFastSequence)
                            .addOnSuccessListener {
                            }.addOnFailureListener { exception ->
                                Log.e(
                                    "saveFastSequence",
                                    "Error updating value: ${exception.message}"
                                )
                            }
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

    @SuppressLint("HardwareIds")
    private fun savecountrycode(arg1: String) {
        if (isonline(this)) {
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

    @SuppressLint("HardwareIds")
    private fun savescore(arg1: String) {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")
                myRef.child("score").addListenerForSingleValueEvent(object : ValueEventListener {
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

                            //delayscore(numanow, resultnow)

                        } else {
                            Log.e("saveScore", "Value string is empty or null")

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle any errors or cancellation
                    }
                })
            } catch (e: Exception) {
                Log.e("saveScore", "Error: ${e.message}")
            }
        }
    }

    private fun delayscore(arg1: Int, arg2: Int) {
        val textView1: TextView = findViewById(R.id.textView1)
        CoroutineScope(Dispatchers.Main).launch {
            for (i in arg1..arg2) {
                delay(100)
                textView1.text = "$i"
            }
        }
    }

    @SuppressLint("HardwareIds")
    @Suppress("SameParameterValue")
    private fun savestars(arg1: String) {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")
                myRef.child("stars").addListenerForSingleValueEvent(object : ValueEventListener {
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

    @SuppressLint("InflateParams")
    private fun showscore() {
        if (isonline(this)) {
            try {
                val rootRef = FirebaseDatabase.getInstance().reference
                val usersRef = rootRef.child("data")
                val builder = AlertDialog.Builder(this)
                val customTitle = layoutInflater.inflate(R.layout.custom_dialog_title, null)
                builder.setCustomTitle(customTitle)
                usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val namesList = mutableListOf<Pair<String, Int>>()
                        val nameToUserIdMap = mutableMapOf<String, String>()

                        for (userSnapshot in snapshot.children) {
                            val userId = userSnapshot.key
                            if (userSnapshot.child("name").exists() && userSnapshot.child("score")
                                    .exists()
                            ) {
                                val name = userSnapshot.child("name").getValue(String::class.java)
                                val scoreStr =
                                    userSnapshot.child("score").getValue(String::class.java)

                                if (name != null && scoreStr != null && userId != null) {
                                    val score = scoreStr.toIntOrNull() ?: 0
                                    namesList.add(Pair(name, score))
                                    nameToUserIdMap[name] = userId
                                }
                            }
                        }

                        val sortedList = namesList.sortedByDescending { it.second }
                        val top10List = sortedList.take(7)

                        val adapter = object : ArrayAdapter<Pair<String, Int>>(
                            this@MainActivity,
                            R.layout.custom_list_item,
                            top10List
                        ) {
                            override fun getView(
                                position: Int,
                                convertView: View?,
                                parent: ViewGroup
                            ): View {
                                val view = convertView ?: layoutInflater.inflate(
                                    R.layout.custom_list_item,
                                    null
                                )

                                val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
                                val scoreTextView = view.findViewById<TextView>(R.id.scoreTextView)
                                val rankTextView = view.findViewById<TextView>(R.id.rankTextView)

                                val (name, score) = top10List[position]

                                nameTextView.text = name
                                scoreTextView.text = getString(R.string.score_text, score)
                                rankTextView.text = getString(R.string.rank_text, position + 1)

                                return view
                            }
                        }

                        builder.setAdapter(adapter) { _, which ->
                            val selectedName = top10List[which].first
                            val userId = nameToUserIdMap[selectedName]
                            if (userId != null) {
                                showUserProfileDialog(userId)
                            }
                        }

                        builder.setNegativeButton("Close") { dialog, _ ->
                            dialog.cancel()
                        }

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
                this,
                "No internet connection. To see the score board.",
                Toast.LENGTH_LONG
            ).show()
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

                    val reputation =
                        ((score.toInt() * 0.5) + (stars.toInt() * 2) - (times * 0.2) + (1000 / fastSequence.toInt())).toInt()

                    val messageName = """
                    <font color="#FFFFFF"><b>$name</b></font>
                """.trimIndent()

                    textViewName.text = Html.fromHtml(messageName)

                    val messageText = """
                    <font color="#ADADAD">Score: $score </font><br><br>
                    <font color="#ADADAD">Stars: $stars </font><br>
                    <font color="#ADADAD">Reputation: $reputation </font><br>
                    <font color="#ADADAD">Fast sequence ever: $fastSequence ms</font><br>
                    <font color="#ADADAD">Times played: $times</font>
                """.trimIndent()
                    textView.text = Html.fromHtml(messageText)

                    imageView.setImageResource(R.drawable.userprofile)

                    builder.setView(view)
                    builder.setNegativeButton("Close") { dialog, _ ->
                        dialog.dismiss()
                        Handler(Looper.getMainLooper()).post {
                            showscore()
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
    private fun getpublicipaddress() {
        if (isonline(this)) {
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
                    Toast.makeText(this, "No internet connection?", Toast.LENGTH_SHORT).show()
                }
            }.start()
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
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            val device = Build.MODEL
            myRef.child("device").setValue(device)
        }
    }

    @SuppressLint("HardwareIds")
    private fun firsttime() {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")
                myRef.child("name").addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (!snapshot.exists()) {
                            askforusername()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle any errors or cancellation
                    }
                })
            } catch (e: Exception) {
                Log.e("firstTime", "Error: ${e.message}")
            }
        }
    }

    @SuppressLint("HardwareIds", "InflateParams")
    private fun askforusername() {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")

                val view = layoutInflater.inflate(R.layout.user_registration_layout, null)

                val emailInput = view.findViewById<EditText>(R.id.email_input)
                val usernameInput = view.findViewById<EditText>(R.id.username_input)
                val passwordInput = view.findViewById<EditText>(R.id.password_input)

                val builder = AlertDialog.Builder(this)
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

    private fun isonline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
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

    private fun playSong(songList: List<Int>, flag: Int) {
        val randomIndex = songList.indices.random()
        player = MediaPlayer.create(this, songList[randomIndex])
        val maxVolume = 100.0f
        val currVolume = 5.0f
        player.setVolume(currVolume / maxVolume, currVolume / maxVolume)
        if (player.isPlaying) {
            player.stop()
            player.reset()
            player.release()
            player.start()
            Toast.makeText(
                baseContext,
                composer + resources.getResourceEntryName(songList[randomIndex]),
                Toast.LENGTH_LONG,
            ).show()
        } else {
            player.start()
            Toast.makeText(
                baseContext,
                composer + resources.getResourceEntryName(songList[randomIndex]),
                Toast.LENGTH_LONG,
            ).show()
        }
        player.setOnCompletionListener {
            val nextFlag = if (flag == songList.lastIndex) 0 else flag + 1
            playSong(songList, nextFlag)
        }
    }

    private fun checkButtonColor(arg1: CharSequence) {
        val imageView: ImageView = findViewById(R.id.imageView)
        val textView2: TextView = findViewById(R.id.textView2)
        val textView1: TextView = findViewById(R.id.textView1)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val fadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out_score)

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
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                savescore("10")
            }

            arg1 == "+15" -> {
                imageView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                savescore("15")
            }

            arg1 == "+30" -> {
                imageView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                textView1.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                savescore("30")
            }

            arg1.contains("⭐") -> {
                imageView.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
                    )
                )
                textView2.startAnimation(
                    AnimationUtils.loadAnimation(
                        this,
                        R.anim.fade_in_out_score
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
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInAnonymously:success")
                    val user = auth.currentUser
                    updateUI(user)
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
        if (isonline(this)) {
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
                        val scoreString = userSnapshot.child("score").getValue(String::class.java)
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

    private fun checkVersion() {
        if (isonline(this)) {
            val rawUrl =
                "https://raw.githubusercontent.com/ruirigel/popit/master/app/build.gradle.kts"

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    if (!hasActiveInternetConnection()) {
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
    }

    private fun hasActiveInternetConnection(): Boolean {
        return try {
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

    private fun onTopUserOvertaken(
        oldUserName: String,
        oldScore: Int,
        newUserName: String,
        newScore: Int
    ) {
        Toast.makeText(
            this,
            "User $newUserName has reached first place now with a score of $newScore pts",
            Toast.LENGTH_LONG
        ).show()
    }

}

