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
import android.text.InputType
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


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var timer: CountDownTimer? = null

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
        } else {
            Toast.makeText(this, "No internet connection?", Toast.LENGTH_SHORT).show()
        }

        val mp = MediaPlayer.create(this, R.raw.popitreset)
        mp.start()
        generate()

        val btnClick20 = findViewById<Button>(R.id.button20)
        val mp20 = MediaPlayer.create(this, R.raw.popit)
        btnClick20.setOnClickListener {
            mp20.start()
            vibratePhone()
            btnClick20.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick21 = findViewById<Button>(R.id.button21)
        val mp21 = MediaPlayer.create(this, R.raw.popit)
        btnClick21.setOnClickListener {
            mp21.start()
            vibratePhone()
            btnClick21.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick22 = findViewById<Button>(R.id.button22)
        val mp22 = MediaPlayer.create(this, R.raw.popit)
        btnClick22.setOnClickListener {
            mp22.start()
            vibratePhone()
            btnClick22.setBackgroundColor(Color.parseColor("#3F51B4"))
        }
        val btnClick23 = findViewById<Button>(R.id.button23)
        val mp23 = MediaPlayer.create(this, R.raw.popit)
        btnClick23.setOnClickListener {
            mp23.start()
            vibratePhone()
            btnClick23.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick24 = findViewById<Button>(R.id.button24)
        val mp24 = MediaPlayer.create(this, R.raw.popit)
        btnClick24.setOnClickListener {
            mp24.start()
            vibratePhone()
            btnClick24.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick25 = findViewById<Button>(R.id.button25)
        val mp25 = MediaPlayer.create(this, R.raw.popit)
        btnClick25.setOnClickListener {
            mp25.start()
            vibratePhone()
            btnClick25.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick26 = findViewById<Button>(R.id.button26)
        val mp26 = MediaPlayer.create(this, R.raw.popit)
        btnClick26.setOnClickListener {
            mp26.start()
            vibratePhone()
            btnClick26.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick27 = findViewById<Button>(R.id.button27)
        val mp27 = MediaPlayer.create(this, R.raw.popit)
        btnClick27.setOnClickListener {
            mp27.start()
            vibratePhone()
            btnClick27.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick28 = findViewById<Button>(R.id.button28)
        val mp28 = MediaPlayer.create(this, R.raw.popit)
        btnClick28.setOnClickListener {
            mp28.start()
            vibratePhone()
            btnClick28.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick29 = findViewById<Button>(R.id.button29)
        val mp29 = MediaPlayer.create(this, R.raw.popit)
        btnClick29.setOnClickListener {
            mp29.start()
            vibratePhone()
            btnClick29.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick30 = findViewById<Button>(R.id.button30)
        val mp30 = MediaPlayer.create(this, R.raw.popit)
        btnClick30.setOnClickListener {
            mp30.start()
            vibratePhone()
            btnClick30.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick31 = findViewById<Button>(R.id.button31)
        val mp31 = MediaPlayer.create(this, R.raw.popit)
        btnClick31.setOnClickListener {
            mp31.start()
            vibratePhone()
            btnClick31.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick32 = findViewById<Button>(R.id.button32)
        val mp32 = MediaPlayer.create(this, R.raw.popit)
        btnClick32.setOnClickListener {
            mp32.start()
            vibratePhone()
            btnClick32.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick33 = findViewById<Button>(R.id.button33)
        val mp33 = MediaPlayer.create(this, R.raw.popit)
        btnClick33.setOnClickListener {
            mp33.start()
            vibratePhone()
            btnClick33.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick34 = findViewById<Button>(R.id.button34)
        val mp34 = MediaPlayer.create(this, R.raw.popit)
        btnClick34.setOnClickListener {
            mp34.start()
            vibratePhone()
            btnClick34.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick35 = findViewById<Button>(R.id.button35)
        val mp35 = MediaPlayer.create(this, R.raw.popit)
        btnClick35.setOnClickListener {
            mp35.start()
            vibratePhone()
            btnClick35.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick36 = findViewById<Button>(R.id.button36)
        val mp36 = MediaPlayer.create(this, R.raw.popit)
        btnClick36.setOnClickListener {
            mp36.start()
            vibratePhone()
            btnClick36.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick37 = findViewById<Button>(R.id.button37)
        val mp37 = MediaPlayer.create(this, R.raw.popit)
        btnClick37.setOnClickListener {
            mp37.start()
            vibratePhone()
            btnClick37.setBackgroundColor(Color.parseColor("#3F51B4"))
        }

        val btnClick38 = findViewById<Button>(R.id.button38)
        val mp38 = MediaPlayer.create(this, R.raw.popitreset)
        btnClick38.setOnClickListener {
            mp38.start()
            vibratePhone()
            generate()
            btnClick38.setBackgroundColor(Color.parseColor("#3F51B4"))
            val num = btnClick38.text.toString()
            savescore(num)

        }

        val btnClick39 = findViewById<Button>(R.id.button39)
        val mp39 = MediaPlayer.create(this, R.raw.popit)
        btnClick39.setOnClickListener {
            mp39.start()
            vibratePhone()
            showscore()
            btnClick39.setBackgroundColor(Color.parseColor("#5587ED"))

        }
    }

    private fun generate() {
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
            R.id.button39
        )
        for (i in 0..17) {
            val buttons = findViewById<Button>(buttonIds[i])
            buttons.setBackgroundColor(Color.parseColor("#3F51B4"))
            buttons.isEnabled = true
            buttons.isClickable = true
        }
        val min = 0
        val max = 17
        for (i in 0..7) {
            val number = (min..max).random()
            val buttons = findViewById<Button>(buttonIds[number])
            buttons.setBackgroundColor(Color.GREEN)
        }
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
                    //btnClick38.text = ""
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
                    val num: Int = timesvalue.toInt()
                    val result = num + 1
                    myRef.child("times").setValue(result)
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
            myRef.child("country").setValue(arg1)
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
                    val numa: Int = scorevalue.toInt()
                    val numb: Int = arg1.toInt()
                    val result = numa + numb
                    val finalresult = result.toString()
                    myRef.child("score").setValue(finalresult)
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
            builder.setTitle("Global Score Board")

            usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var names = arrayOf<String>()
                    val namesList = names.toMutableList()
                    var c = 1
                    var nameb: String
                    var countryb: String
                    var scoreb: String
                    for (userSnapshot in snapshot.children) {
                        val name = userSnapshot.child("name").getValue(String::class.java)
                        val country = userSnapshot.child("country").getValue(String::class.java)
                        val score = userSnapshot.child("score").getValue(String::class.java)
                        if (name != null && country != null && score != null) {
                            nameb = name.toString().padStart(0, ' ')
                            countryb = country.toString().padStart(0, ' ')
                            scoreb = score.toString().padStart(35, ' ')
                            namesList.add("$countryb - $nameb, $scoreb pts")
                            c++
                        }
                    }
                    names = namesList.toTypedArray()
                    builder.setItems(names) { _, which ->
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

    fun askforusername() {
        if (isonline(this)) {
            val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            val database = Firebase.database
            val myRef = database.getReference("/data/$id")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("First time")
            builder.setMessage("Do you want join in global scoreboard?\nPlease write a username below.")
            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)
            builder.setPositiveButton("OK") { _, _ ->
                val mText = input.text.toString()
                myRef.child("name").setValue(mText)
            }
            builder.setNegativeButton("Cancel") { dialog, _ ->
                myRef.child("name").setValue("guest")
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
}