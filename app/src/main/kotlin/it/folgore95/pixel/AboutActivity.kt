package it.folgore95.pixel

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View

import androidx.appcompat.app.AppCompatActivity

/**
 * @author Cantoni Giorgio - giorgio.canto98@gmail.com on 4/04/19.
 */

class AboutActivity : AppCompatActivity() {

    // Costants for debug
    private val VERSION = android.os.Build.VERSION.RELEASE
    private val DEVICE = android.os.Build.DEVICE
    private val MODEL = android.os.Build.MODEL
    private val APPCODE = BuildConfig.VERSION_CODE
    private val APPVERSION = BuildConfig.VERSION_NAME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pixel_activity_about)
    }

    /**
     * Back to GACtivity with sw/hw back button
     */
    override fun onBackPressed() {
        val intent = Intent(this, PixelActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    /**
     * Back to GActivity with ActionBar back button
     * @param item
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            val intent = Intent(this, PixelActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Rate App
     * @param view
     */
    fun rateApp(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.app_link)))
        startActivity(browserIntent)
    }

    /**
     * Website
     * @param view
     */
    fun webSite(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.website_link)))
        startActivity(browserIntent)
    }

    /**
     * Bug Report
     */
    fun bugReport(view: View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "giorgio.canto98@gmail.com", null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Theme Substratum Bug Report")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Giorgio! \n\n Issue/Suggestion: ...\n\nDevice: " + DEVICE + "\n Model: " + MODEL + "\n Android Version: " +
                VERSION + "\nVersion: " + APPVERSION + " " + "(" + APPCODE + ")")
        startActivity(Intent.createChooser(emailIntent, "Send bug report with..."))
    }

    /**
     * Libraries and Materials
     * @param view
     */
    fun library1(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_library1_link)))
        startActivity(browserIntent)
    }

    fun library2(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_library2_link)))
        startActivity(browserIntent)
    }

    fun library3(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_library3_link)))
        startActivity(browserIntent)
    }

    fun library4(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_library4_link)))
        startActivity(browserIntent)
    }

    fun library5(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_library5_link)))
        startActivity(browserIntent)
    }

}