package ru.petshop.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.pensource.data.CapitalizeText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SharedActivity : AppCompatActivity() {
    @Inject
    lateinit var capitalizeText: CapitalizeText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        lifecycleScope.launch(Dispatchers.IO) {
            delay(1500)
            launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.title_tv).text = capitalizeText.capitalize("TEST_BIGGER")
            }
        }
    }
}