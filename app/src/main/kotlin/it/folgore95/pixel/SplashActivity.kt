package it.folgore95.pixel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Cantoni Giorgio - giorgio.canto98@gmail.com on 4/04/19.
 */

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // launch app
        startActivity(Intent(this, PixelActivity::class.java))
        finish()
    }
}