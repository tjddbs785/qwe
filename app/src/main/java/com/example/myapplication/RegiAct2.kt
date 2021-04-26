package com.example.myapplication

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class RegiAct2 : AsyncTask<String?, Void?, String?>() {
    var receiveMsg: String? = null
    protected override fun doInBackground(vararg strings: String?): String? {
      try {
          var str: String?
          val url = URL("http://ip:포트/JSPTEST/dbConTest.jsp")
          val conn = url.openConnection() as HttpURLConnection
          conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
          conn.requestMethod = "POST"
          val osw = OutputStreamWriter(conn.outputStream, "UTF-8")

          osw.flush()

          if (conn.responseCode == HttpURLConnection.HTTP_OK) {
              val tmp = InputStreamReader(conn.inputStream, "UTF-8")
              val reader = BufferedReader(tmp)
              val buffer = StringBuffer()

              while (reader.readLine().also { str = it } != null) {
                  buffer.append(str)
              }
              receiveMsg = buffer.toString()
          } else {

          }
      }catch (e: MalformedURLException) {
          e.printStackTrace()
      }
    return receiveMsg

  }
}



