package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the EditText and Button elements
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Set an onClickListener for the login button
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Check if credentials are correct
            if (username == "admin" && password == "admin") {
                // If correct, navigate to ListFoodActivity
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
                finish() // Optional: close MainActivity so it can't be navigated back to
            } else {
                // Show a toast if credentials are incorrect
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
