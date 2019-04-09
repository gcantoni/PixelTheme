package it.folgore95.pixel

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import android.content.ComponentName

/**
 * @author Cantoni Giorgio - giorgio.canto98@gmail.com on 4/04/19.
 */

class PixelActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Constants
    private lateinit var floatingActionButton: ExtendedFloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pixel_activity)
        floatingActionButton = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomAppBar)
        setSupportActionBar(bottomAppBar)

        // fab
        floatingActionButton.setOnClickListener { applyTheme() }

    }

    /**
     * Create the bottom app bar
     * @param menu
     * @return
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar, menu)
        return true
    }

    /**
     * Necessary method to avoid this class abstract
     * @param item
     * @return
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        return true
    }

    /**
     * Method to handle the menu
     * @param item
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            // about
            R.id.about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                finish()
            }
        }
        return true
    }

    /**
     * Apply theme method with package checking
     */
    private fun applyTheme() {
        val i: Intent?
        val manager = packageManager
        // launch app if his package is founded
        try {
            i = manager.getLaunchIntentForPackage("projekt.substratum")
            if (i == null)
                throw PackageManager.NameNotFoundException()
            i.addCategory(Intent.CATEGORY_LAUNCHER)
            startActivity(i)
        } // if the package is not founded show a dialog with the option to download it
        catch (e: PackageManager.NameNotFoundException) {
            val message = AlertDialog.Builder(this@PixelActivity, R.style.DialogApp)
            message.setIcon(R.drawable.ic_attention)
            message.setTitle(R.string.attention)
            message.setMessage(getString(R.string.launch_error))
            message.setCancelable(false)

            message.setPositiveButton(getString(R.string.download)) { dialog, id ->
                // move the user to download the app
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.sub_link)))
                startActivity(browserIntent)
            }

            val alert = message.create()
            alert.show()
        }

    }

    /**
     * Method for support chat
     */
    fun supportChat(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.support_chat_link)))
        startActivity(browserIntent)
    }

    /**
     * Method for hiding app icon
     */
    fun hideAppIcon(view: View) {
        val pm = this.packageManager
        // dialog
        val message = AlertDialog.Builder(this, R.style.DialogApp)
        message.setIcon(R.drawable.ic_attention)
        message.setTitle(R.string.attention)
        message.setMessage(getString(R.string.hide_text))
        message.setCancelable(false)
        // yes hides the app
        message.setPositiveButton(getString(R.string.hide_ok)) { dialog, id ->
            pm.setComponentEnabledSetting(ComponentName("it.folgore95.pixel",
                    "it.folgore95.pixel.SplashActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP)
            // close the app
            finish()
            // show a toast
            Toast.makeText(this@PixelActivity, getString(R.string.hide_success), Toast.LENGTH_LONG).show()
        }
        // negative button
        message.setNegativeButton(R.string.hide_no, null)
        val alert = message.create()
        alert.show()
    }

}