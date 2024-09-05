package com.example.myapplication

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
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.Html
import android.text.InputFilter
import android.text.InputType
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
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
import java.time.LocalDateTime


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val currentVersion = 20240905

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
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        auth = Firebase.auth

        if (isonline(this)) {
            val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val countryCodeValue = tm.networkCountryIso
            savecountrycode(countryCodeValue)
            val ldt = LocalDateTime.now().toString()
            signInAnonymously()
            savedatetime(ldt)
            getpublicipaddress()
            devicename()
            firsttime()
            savetimes()
            monitorScores()
            checkVersion()

        } else {
            Toast.makeText(
                this,
                "No internet connection. Not having an internet connection does not invalidate playing on the app, it will just stop adding up the score.",
                Toast.LENGTH_LONG
            ).show()
        }

        var mpb = MediaPlayer.create(this, R.raw.popit)
        playSong(songList, 0)
        plays()
        //generate()

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

        val min = 0
        val max = 17
        for (i in 0..7) {
            val number = (min..max).random()
            val buttons = findViewById<Button>(buttonIds[number])
            buttons.setBackgroundColor(Color.GREEN)
            buttons.text = "+1"
            buttons.setTextColor(Color.GREEN)
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
            buttonss.setBackgroundColor(Color.YELLOW)
            buttonss.text = Html.fromHtml("<font color='#009688'>★</font>")
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
        timer = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                btnClick38.text = (millisUntilFinished / 1000).toString()
                when (btnClick38.text) {
                    0.toString() -> btnClick38.setBackgroundColor(Color.parseColor("#ff0000"))
                    1.toString() -> btnClick38.setBackgroundColor(Color.parseColor("#ffa700"))
                    2.toString() -> btnClick38.setBackgroundColor(Color.parseColor("#fff400"))
                    3.toString() -> btnClick38.setBackgroundColor(Color.parseColor("#a3ff00"))
                }
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
        val animator = ObjectAnimator.ofFloat(buttons, "translationY", 0f, 3500f)
        animator.duration = 500
        animator.start()

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
                        val timesvalue = snapshot.value.toString()
                        if (timesvalue.isNotEmpty()) {

                            val num: Int = timesvalue.toInt()
                            val result = num + 1
                            myRef.child("times").setValue(result)

                        } else {
                            Log.e("DetailsFragment", "Value string is empty or null")
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle any errors or cancellation
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
                        val namesArray = arrayOf<String>()
                        val namesList = namesArray.toMutableList()

                        for (userSnapshot in snapshot.children) {
                            if (userSnapshot.child("name").exists() && userSnapshot.child("score")
                                    .exists()
                            ) {
                                val name = userSnapshot.child("name").getValue(String::class.java)
                                val score = userSnapshot.child("score").getValue(String::class.java)
                                namesList.add("$name $score")
                            }
                        }

                        val nameAndScoreList: MutableList<Pair<String, Int>> =
                            namesList.map { element ->
                                val (name, score) = element.split(" ")
                                Pair(name, score.toInt())
                            }.toMutableList()
                        val sortedList =
                            nameAndScoreList.sortedByDescending { it.second }//.take(10)

                        sortedList.forEachIndexed { index, (name, score) ->
                            val adjustedIndex = index + 1
                            namesList[index] = "$adjustedIndex - $name $score"
                        }

                        val sortedResult = namesList.toTypedArray().take(10)

                        val adapter = ArrayAdapter(
                            this@MainActivity,
                            R.layout.custom_list_item,
                            sortedResult
                        )

                        builder.setAdapter(adapter) { _, which ->
                            when (which) {
                                0 -> { /* Handle item click */
                                }

                                1 -> { /* Handle item click */
                                }

                                2 -> { /* Handle item click */
                                }

                                3 -> { /* Handle item click */
                                }

                                4 -> { /* Handle item click */
                                }

                                5 -> { /* Handle item click */
                                }

                                6 -> { /* Handle item click */
                                }

                                7 -> { /* Handle item click */
                                }

                                8 -> { /* Handle item click */
                                }

                                9 -> { /* Handle item click */
                                }
                            }
                        }

                        builder.setNegativeButton("") { dialog, _ ->
                            dialog.cancel()
                        }

                        val dialog = builder.create()
                        dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
                        dialog.show()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        println("Error reading data: ${error.message}")
                    }
                })
            } catch (e: Exception) {
                Log.e("showScore", "Error: ${e.message}")
            }
        } else {
            Toast.makeText(
                this,
                "No internet connection. To see the score table you need an internet connection.",
                Toast.LENGTH_LONG
            ).show()
        }
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

    @SuppressLint("HardwareIds")
    private fun askforusername() {
        if (isonline(this)) {
            try {
                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                val database = Firebase.database
                val myRef = database.getReference("/data/$id")
                val builder = AlertDialog.Builder(this)
                builder.setCancelable(false)
                builder.setTitle("First time")
                builder.setMessage("Do you want join in Top 10 of Global Score?\n\nPlease write a username below.")
                val input = EditText(this)
                val inputlayout = FrameLayout(this)
                inputlayout.setPaddingRelative(50, 15, 50, 0)
                val maxLength = 15
                input.setHint("Username")
                val currentTimeMillis = System.currentTimeMillis()
                input.filters = arrayOf(InputFilter.LengthFilter(maxLength))
                input.inputType = InputType.TYPE_CLASS_TEXT
                inputlayout.addView(input)
                builder.setView(inputlayout)
                builder.setPositiveButton("Submit") { _, _ ->
                    val removespace = input.text.filter { !it.isWhitespace() }
                    val mText = removespace.toString()
                    if (mText.isEmpty()) {
                        myRef.child("name").setValue("guest$currentTimeMillis")
                    } else {
                        myRef.child("name").setValue(mText)
                    }
                    myRef.child("score").setValue("0")
                    myRef.child("times").setValue("1")
                    myRef.child("stars").setValue("0")
                }
                builder.setNegativeButton("Cancel") { dialog, _ ->
                    myRef.child("name").setValue("guest$currentTimeMillis")
                    myRef.child("score").setValue("0")
                    myRef.child("times").setValue("1")
                    myRef.child("stars").setValue("0")


                    dialog.cancel()
                }
                val dialog = builder.create()
                dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
                dialog.show()
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                    .setTextColor(getResources().getColor(R.color.white))
                dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setTextColor(getResources().getColor(R.color.white))

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
        when {
            arg1 == " " -> {
                savescore("0")
            }

            arg1 == "+1" -> {
                savescore("1")
            }

            arg1 == "+10" -> {
                savescore("10")
            }

            arg1 == "+15" -> {
                savescore("15")
            }

            arg1 == "+30" -> {
                savescore("30")
            }

            arg1.contains("★") -> {
                Toast.makeText(this@MainActivity, "is a star", Toast.LENGTH_LONG).show()
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

    private fun checkVersion() {
        val rawUrl = "https://raw.githubusercontent.com/ruirigel/popit/master/app/build.gradle.kts"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL(rawUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                if (connection.responseCode == 200) {
                    val content = connection.inputStream.bufferedReader().use { it.readText() }

                    val versionLine = content.lines().find { it.contains("versionCode") }

                    val remoteVersion = versionLine?.substringAfter("versionCode =")?.trim()?.toIntOrNull()

                    withContext(Dispatchers.Main) {
                        if (remoteVersion != null && remoteVersion > currentVersion) {
                            Toast.makeText(this@MainActivity, "New version available in the repo of this app. Version: $remoteVersion", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Error: failed to check for updates.", Toast.LENGTH_LONG).show()
                    }
                }

                connection.disconnect()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
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
        println("User $newUserName has reached first place now with a score of $newScore")
        Toast.makeText(
            this,
            "User $newUserName has reached first place now with a score of $newScore",
            Toast.LENGTH_LONG
        ).show()
    }

}

