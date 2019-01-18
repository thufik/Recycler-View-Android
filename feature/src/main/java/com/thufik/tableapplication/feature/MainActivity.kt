package com.thufik.tableapplication.feature

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val btn = findViewById<Button>(R.id.btnAccess)
        val txtMail = findViewById<EditText>(R.id.txtMail)
        val txtPass = findViewById<EditText>(R.id.txtPassword)

        btn.setOnClickListener {

            var toast = Toast.makeText(this, "Email ou senha vazios", Toast.LENGTH_SHORT)

            if (txtMail.text.isEmpty() || txtPass.text.isEmpty()){
                toast.show()
            }else{
                this.makeRequest(txtMail.text.toString(), txtPass.text.toString())
            }
        }
    }

    private fun makeRequest(mail : String, pass : String){
        val url = "http://10.0.2.2:8080/login"

        var text : String = ""

        val queue = Volley.newRequestQueue(this@MainActivity)

        val body = JSONObject()
        body.put("mail",mail)
        body.put("password", pass)

        val progressBar = findViewById<ProgressBar>(R.id.pgBar)

        progressBar.visibility = View.VISIBLE

        val request = JsonObjectRequest(Request.Method.POST,url,body, Response.Listener {

            val intent = Intent(this@MainActivity, HomeActivity::class.java)

            progressBar.visibility = View.INVISIBLE

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

            startActivity(intent)

        },Response.ErrorListener {
            var toast = Toast.makeText(this@MainActivity, "ERRO", Toast.LENGTH_SHORT)
            progressBar.visibility = View.INVISIBLE
            toast.show()
        })

        queue.add(request)
    }
}

