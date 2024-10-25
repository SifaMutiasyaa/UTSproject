package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Retrieve and display the selected food name
        val foodName = intent.getStringExtra("FOOD_NAME")
        findViewById<TextView>(R.id.etFoodName).text = foodName

        // Set up edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // "Place Order" button click listener
        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            // Navigate to ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java)
            startActivity(intent)
        }
    }
}
