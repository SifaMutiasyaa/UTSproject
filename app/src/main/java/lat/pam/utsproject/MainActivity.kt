package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Retrieve stored username and password from SharedPreferences
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val storedUsername = sharedPreferences.getString("username", null)
            val storedPassword = sharedPreferences.getString("password", null)

            // Check if the credentials match
            if (username == storedUsername && password == storedPassword) {
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
                finish() // Close MainActivity
            } else {
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
