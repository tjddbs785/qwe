package com.example.myapplication

import android.os.AsyncTask
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException
import java.net.MalformedURLException

class RegisterActivity : AsyncTask<String?, Void?, String?>() {
    var receiveMsg : String? = null
    override fun doInBackground(vararg strings: String?): String? {
        try {
            var str: String?

            val url = "http://ip:포트/JSPTEST/dbConTest.jsp"
            val doc = Jsoup.connect(url).timeout(1000 * 10).get()
            val contentData : Elements = doc.select("body p")

            receiveMsg = ""

            for(data in contentData) {
                val element = data.select("p")
                val lank  = element[0].text()

                receiveMsg += lank + "/n"
            }

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return receiveMsg
    }

}