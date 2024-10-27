package lat.pam.utsproject

import android.content.Intent
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

        foodList = listOf(
            Food(1, "Batagor", "Authentic tasty Batagor from Bandung", R.drawable.batagor, 15.0),
            Food(2, "Black Salad", "Fresh salad made to order", R.drawable.black_salad, 12.0),
            Food(3, "Cappuccino", "Original cappuccino made from Arabica coffee", R.drawable.cappuchino, 20.0),
            Food(4, "Cheesecake", "Sweet cheesecake as sweet as you", R.drawable.cheesecake, 25.0),
            Food(5, "Cireng", "Delicious crispy fried tapioca from Garut", R.drawable.cireng, 10.0),
            Food(6, "Donut", "Delicious donuts that rival famous brands", R.drawable.donut, 15.0),
            Food(7, "Black Coffee", "Strong black coffee to keep you awake", R.drawable.kopi_hitam, 10.0),
            Food(8, "Fried Noodles", "Unique fried noodles unlike any other", R.drawable.mie_goreng, 12.0),
            Food(9, "Fried Rice", "Authentic and tasty fried rice from Padang", R.drawable.nasigoreng, 20.0),
            Food(10, "Sparkling Tea", "Refreshing drink to keep you alert", R.drawable.sparkling_tea, 15.0)
        )



        adapter = FoodAdapter { food ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("FOOD_NAME", food.name)
            }
            startActivity(intent)
        }
        adapter.setFoods(foodList)
        recyclerView.adapter = adapter

        // Set up edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
