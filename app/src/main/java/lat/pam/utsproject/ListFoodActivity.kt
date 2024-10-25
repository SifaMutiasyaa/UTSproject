package lat.pam.utsproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Prepare food data
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappuccino", "Kopi cappuccino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheesecake", "Cheesecake manis semanis kamu", R.drawable.cheesecake),
            Food("Cireng", "Cireng enak banget asli garut", R.drawable.cireng),
            Food("Donut", "Donut yang ngga kalah enak dari donsu", R.drawable.donut),
            Food("Kopi hitam", "Kopi hitam yang bikin kamu kuat begadang", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie goreng yang beda dari yang lain", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi goreng asli enak dari Padang", R.drawable.nasigoreng),
            Food("Sparkling_tea", "Minuman segar yang bikin kamu melek", R.drawable.sparkling_tea)
        )

        adapter = FoodAdapter(foodList, this)
        recyclerView.adapter = adapter

        // Set up edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
