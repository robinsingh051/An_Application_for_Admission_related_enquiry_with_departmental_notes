package com.example.faqNnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.core.widget.NestedScrollView
import com.example.myapplication.BotResponse
import com.example.myapplication.MessageSender
import com.example.myapplication.UserMessage
import com.google.android.material.floatingactionbutton.FloatingActionButton
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class chatbot : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var sendBtn: FloatingActionButton
    private val USER = 0
    private val BOT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        val chatScrollView = findViewById<NestedScrollView>(R.id.chatScrollView)
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        editText = findViewById(R.id.edittext_chatbox)
        chatScrollView.post { chatScrollView.fullScroll(ScrollView.FOCUS_DOWN) }
        sendBtn = findViewById(R.id.send_button)
        sendBtn.setOnClickListener{
            sendMessage()
        }
    }
    fun sendMessage(){
        val msg:String = editText.text.toString()
        val okHttpClient = OkHttpClient()
        val retrofit = Retrofit.Builder().baseUrl("http://172.26.240.1:5002/webhooks/rest/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        val userMessage = UserMessage()
        if(msg.trim().isEmpty())
            Toast.makeText(this,"Please enter your query", Toast.LENGTH_SHORT).show()
        else {
            Log.e("MSg","msssage: $msg")
            showTextView(msg, USER)
            editText.setText("")
            userMessage.UserMessage("User",msg)
        }
        val messageSender = retrofit.create(MessageSender::class.java)
        val response = messageSender.sendMessage(userMessage)
        response.enqueue(object : Callback<List<BotResponse>?> {
            override fun onResponse(call: Call<List<BotResponse>?>, response: Response<List<BotResponse>?>) {
                if (response.body() == null || response.body()!!.size == 0) {
                    showTextView("Sorry didn't understand", BOT)
                } else {
                    val botResponse = response.body()!![0]
                    showTextView(botResponse.text,BOT)
                }
            }

            override fun onFailure(call: Call<List<BotResponse>?>, t: Throwable) {
                showTextView("Waiting for message", BOT)
                Toast.makeText(this@chatbot, "" + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun showTextView(message:String,type:Int){
        val inflater = LayoutInflater.from(this@chatbot)
        var frameLayout: FrameLayout? = null
        val linearLayout_main = findViewById<LinearLayout>(R.id.chat_layout)
        when(type){
            USER -> { frameLayout = getUserLayout()
            }
            BOT ->{frameLayout = getBotLayout()
            }
            else->{
                frameLayout = getBotLayout()
            }
        }
        frameLayout?.isFocusableInTouchMode = true
        linearLayout_main.addView(frameLayout)
        val messageTextView = frameLayout?.findViewById<TextView>(R.id.chat_msg)
        messageTextView?.setText(message)
        frameLayout?.requestFocus()
        editText.requestFocus()
        val date = Date(System.currentTimeMillis())
        val dateFormat = SimpleDateFormat("hh:mm aa",Locale.ENGLISH)
        val time = dateFormat.format(date)
        val timeTextView = frameLayout?.findViewById<TextView>(R.id.message_time)
        timeTextView?.setText(time.toString())
    }

    fun getUserLayout(): FrameLayout? {
        val inflater = LayoutInflater.from(this@chatbot)
        return inflater.inflate(R.layout.user_message_box, null) as FrameLayout?
    }

    fun getBotLayout(): FrameLayout? {
        val inflater = LayoutInflater.from(this@chatbot)
        return inflater.inflate(R.layout.bot_message_box, null) as FrameLayout?
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}