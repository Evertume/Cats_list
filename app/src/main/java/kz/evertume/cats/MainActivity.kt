package kz.evertume.cats

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.evertume.cats.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)




        val adapter = CatAdapter()

        binding.catList.adapter = adapter
        binding.catList.layoutManager = LinearLayoutManager(this)

        binding.searchView.setOnEditorActionListener { it, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                RetrofitInstance.apiService.getCatsByName(it.text.toString()).enqueue(object :
                    Callback<List<Cat>> {
                    override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                        if (response.isSuccessful) {
                            adapter.submitList(response.body())
                        }
                    }
                    override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                })
                true
            } else false
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}