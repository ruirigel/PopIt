package com.example.myapplication

import android.content.Context
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
import android.text.InputFilter
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var timer: CountDownTimer? = null
    private val songList = listOf(R.raw.stranger0)
    private lateinit var player: MediaPlayer
    private var playermp = true
    private var playermppaused = false
    private var redrandomofplays = 0
    private var grayrandomofplays = 0
    private var orangerandomofplays = 0
    private var numberofplays = 0
    private var mps = true
    private var numberr = 0
    private var numbero = 0
    private var numberg = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        if (isonline(this)) {
            val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val countryCodeValue = tm.networkCountryIso
            savecountrycode(countryCodeValue)
            val ldt = LocalDateTime.now().toString()
            savedatetime(ldt)
            getpublicipaddress()
            devicename()
            savetimes()
            firsttime()
            plays()
        } else {
            Toast.makeText(this, "No internet connection?", Toast.LENGTH_SHORT).show()
        }

        var mpb = MediaPlayer.create(this, R.raw.popit)
        playSong(songList, 0)
        generate()

        val btnClick20 = findViewById<Button>(R.id.button20)
        btnClick20.setOnClickListener {
            if (mps) {
                mpb.start()
            }
            vibratePhone()
            btnClick20.setBackgroundColor(Color.parseColor("#3F51B4"))
            checkButtonColor(btnClick20.text)
            btnClick20.text = null
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
        }

        val btnClick38 = findViewById<Button>(R.id.button38)
        btnClick38.setOnClickListener {
            if (mps) {
                mpb.start()
            }
            vibratePhone()
            generate()
            btnClick38.setBackgroundColor(Color.parseColor("#3F51B4"))
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
            buttons.text = null
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
            }
        }.start()
    }

    private fun savetimes() {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            myRef.child("times").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val timesvalue = snapshot.value.toString()
                    if (timesvalue.isNullOrEmpty()) {
                        try {
                            val num: Int = timesvalue.toInt()
                            val result = num + 1
                            myRef.child("times").setValue(result)
                        } catch (e: NumberFormatException) {
                            Log.e("DetailsFragment", "Error parsing value: ${e.message}")
                        }
                    } else {
                        Log.e("DetailsFragment", "Value string is empty or null")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle any errors or cancellation
                }
            })
        }
    }

    private fun savedatetime(arg1: String) {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            myRef.child("date").setValue(arg1)
        }
    }

    private fun savecountrycode(arg1: String) {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            if (arg1.isNotEmpty()) {
                myRef.child("country").setValue(arg1)
            } else {
                myRef.child("country").setValue("n/a")

            }
        }
    }

    private fun savescore(arg1: String) {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            myRef.child("score").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val scorevalue = snapshot.value.toString()
                    if (scorevalue.isNotEmpty()) {
                        try {
                            val numa: Int = scorevalue.toInt()
                            val numb: Int = arg1.toInt()
                            val result = numa + numb
                            val finalresult = result.toString()
                            myRef.child("score").setValue(finalresult)
                        } catch (e: NumberFormatException) {
                            Log.e("DetailsFragment", "Error parsing value: ${e.message}")
                        }
                    } else {
                        Log.e("DetailsFragment", "Value string is empty or null")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle any errors or cancellation
                }
            })
        }
    }

    private fun showscore() {
        if (isonline(this)) {
            val rootRef = FirebaseDatabase.getInstance().reference
            val usersRef = rootRef.child("data")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Top 10 of Global Score")

            usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val namesArray = arrayOf<String>()
                    val namesList = namesArray.toMutableList()

                    for (userSnapshot in snapshot.children) {
                        val name = userSnapshot.child("name").getValue(String::class.java)
                        val score = userSnapshot.child("score").getValue(String::class.java)
                        namesList.add("$name $score")
                    }

                    val nameAndScoreList: MutableList<Pair<String, Int>> =
                        namesList.map { element ->
                            val (name, score) = element.split(" ")
                            Pair(name, score.toInt())
                        }.toMutableList()
                    val sortedList = nameAndScoreList.sortedByDescending { it.second }

                    sortedList.forEachIndexed { index, (name, score) ->
                        val adjustedIndex = index + 1
                        namesList[index] = "$adjustedIndex - $name $score"
                    }

                    val sortedResult = namesList.toTypedArray()
                    builder.setItems(sortedResult) { _, which ->
                        when (which) {
                            0 -> {
                            }

                            1 -> {
                            }

                            2 -> {
                            }

                            3 -> {
                            }

                            4 -> {
                            }

                            5 -> {
                            }

                            6 -> {
                            }

                            7 -> {
                            }

                            8 -> {
                            }

                            9 -> {
                            }
                        }
                    }
                    builder.setNegativeButton("") { dialog, _ ->
                        dialog.cancel()
                    }
                    val dialog = builder.create()
                    dialog.show()
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle database read error
                    println("Error reading data: ${error.message}")
                }
            })
        }
    }

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

    @Suppress("DEPRECATION")
    private fun vibratePhone() {
        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            v.vibrate(100)
        }
    }

    private fun devicename() {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            val device = Build.MODEL
            myRef.child("device").setValue(device)
        }
    }

    private fun firsttime() {
        if (isonline(this)) {
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
        }
    }

    private fun askforusername() {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("First time")
            builder.setMessage(" Do you want join in Top 10 of global Score?\n Please write a username below.")
            val input = EditText(this)
            val maxLength = 15
            input.filters = arrayOf(InputFilter.LengthFilter(maxLength))
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)
            builder.setPositiveButton("OK") { _, _ ->
                val removespace = input.text.filter { !it.isWhitespace() }
                val mText = removespace.toString()
                myRef.child("name").setValue(mText)
                myRef.child("score").setValue("0")
                myRef.child("times").setValue("0")
            }
            builder.setNegativeButton("Cancel") { dialog, _ ->
                myRef.child("name").setValue("guest")
                myRef.child("score").setValue("0")
                myRef.child("times").setValue("0")
                dialog.cancel()
            }
            builder.show()
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
        val redmaxrandomofplays = 30
        redrandomofplays = (redminrandomofplays..redmaxrandomofplays).random()

        val orangeminrandomofplays = 0
        val orangemaxrandomofplays = 15
        orangerandomofplays = (orangeminrandomofplays..orangemaxrandomofplays).random()

        val grayminrandomofplays = 0
        val graymaxrandomofplays = 10
        grayrandomofplays = (grayminrandomofplays..graymaxrandomofplays).random()


    }

    private fun playSong(songList: List<Int>, flag: Int) {
        player = MediaPlayer.create(this, songList[flag])
        val maxVolume = 100.0f
        val currVolume = 5.0f
        player.setVolume(currVolume / maxVolume, currVolume / maxVolume)
        if (player.isPlaying) {
            player.stop()
            player.reset()
            player.release()
            player.start()
        } else {
            player.start()
        }
        player.setOnCompletionListener {
            val nextFlag = if (flag == songList.lastIndex) 0 else flag + 1
            playSong(songList, nextFlag)
        }
    }

    private fun checkButtonColor(arg1: CharSequence) {
        if (arg1 == "+1") {
            savescore("1")
        } else if (arg1 == "+10") {
            savescore("10")
        } else if (arg1 == "+15") {
            savescore("15")
        } else if (arg1 == "+30") {
            savescore("30")
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

}

