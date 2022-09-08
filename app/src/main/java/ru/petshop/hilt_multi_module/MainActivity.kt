package ru.petshop.hilt_multi_module

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.pensource.data.CapitalizeText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import ru.petshop.data.SharedActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var api: Api
    @Inject
    lateinit var capitalizeText: CapitalizeText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.next_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, SharedActivity::class.java))
        }
        lifecycleScope.launch(Dispatchers.IO) {
                    api.getCoins(0)
                    delay(2000)
                    launch(Dispatchers.Main) {
                        findViewById<TextView>(R.id.title_tv).text = capitalizeText.capitalize("data is loaded!")
                    }
        }
    }
}