package com.devventure.colormyviews

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.devventure.colormyviews.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    private var pincelColor = R.color.grey
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestUserPermissions()
        configureSharedPref()
        configureBoxBackground()
    }

    private fun requestUserPermissions() {
        var isAllPermissionsGranted = true

        val info: PackageInfo =
            packageManager.getPackageInfo(
                applicationContext.packageName,
                PackageManager.GET_PERMISSIONS
            )
        val permissions = info.requestedPermissions
        for (p in permissions) {
            if (ContextCompat.checkSelfPermission(this, p) != PackageManager.PERMISSION_GRANTED)
                isAllPermissionsGranted = false
        }

        if (!isAllPermissionsGranted)
            ActivityCompat.requestPermissions(
                this,
                permissions,
                101
            )
    }

    private fun configureSharedPref() {
        sharedPreferences = getSharedPreferences("colors", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    private fun configureBoxBackground() {
        val boxes = arrayOf(
            binding.boxOne, binding.boxTwo, binding.boxThree,
            binding.boxFour, binding.boxFive
        )
        for (box in boxes) {
            findViewById<View>(box.id).setBackgroundResource(getColorBox(box.id.toString()))
        }
    }

    override fun onStop() {
        super.onStop()
        editor.apply()
    }

    fun setColor(view: View) {
        when (view.id) {
            R.id.btn_red -> pincelColor = R.color.red
            R.id.btn_yellow -> pincelColor = R.color.yellow
            R.id.btn_green -> pincelColor = R.color.green
        }
    }

    fun colorBox(view: View) {
        when (view.id) {
            R.id.boxOne -> {
                binding.boxOne.setBackgroundResource(pincelColor)
                editor.putInt(binding.boxOne.id.toString(), pincelColor)
            }

            R.id.boxTwo -> {
                binding.boxTwo.setBackgroundResource(pincelColor)
                editor.putInt(binding.boxTwo.id.toString(), pincelColor)
            }

            R.id.boxThree -> {
                binding.boxThree.setBackgroundResource(pincelColor)
                editor.putInt(binding.boxThree.id.toString(), pincelColor)
            }

            R.id.boxFour -> {
                binding.boxFour.setBackgroundResource(pincelColor)
                editor.putInt(binding.boxFour.id.toString(), pincelColor)
            }

            R.id.boxFive -> {
                binding.boxFive.setBackgroundResource(pincelColor)
                editor.putInt(binding.boxFive.id.toString(), pincelColor)
            }
        }
    }

    private fun getColorBox(idBox: String): Int {
        return sharedPreferences.getInt(idBox, R.color.grey)
    }

    fun shareScreenScreenshot(view: View) {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        val bitmap = getViewAsBitmap(rootView)
        if (bitmap != null) {
            storeScreenshot(bitmap, "ScreenshotView")
        }
    }

    private fun getViewAsBitmap(mView: View): Bitmap? {
        val bitmap = Bitmap.createBitmap(mView.width, mView.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val bgDraw = mView.background
        if (bgDraw != null)
            bgDraw.draw(canvas)
        else
            canvas.drawColor(Color.WHITE)
        mView.draw(canvas)
        return bitmap
    }

    /**
     * Função salva o Bitmap gerado da view como um file em um diretório privado, utilizando getExternalFilesDir(),
     * portanto os arquivos serão removidos quando o app for desinstalado
     * @param imageBitmap imagem em bitmap a ser salva
     * @param filename nome do arquivo a ser salvo
     * @return Uri do arquivo salvo
     */
    private fun storeScreenshot(imageBitmap: Bitmap, filename: String) {
//        val dirPath = applicationContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        val dirPath = applicationContext.filesDir.absolutePath
        val file = File(dirPath, filename)
        val fileOutputStream = FileOutputStream(file)
        try {
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream)
            fileOutputStream.apply {
                flush()
                close()
            }
            shareImageUri(Uri.fromFile(file))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Shares the PNG image from Uri.
     * @param uri Uri of image to share.
     */
    @SuppressLint("QueryPermissionsNeeded")
    private fun shareImageUri(uri: Uri) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            putExtra(Intent.EXTRA_STREAM, uri)
            type = "image/png"
            setPackage("com.whatsapp")
        }

        applicationContext?.packageManager?.run {
            if (shareIntent.resolveActivity(this) != null)
                startActivity(shareIntent)
            else
                Toast.makeText(applicationContext, "Impossível executar", Toast.LENGTH_LONG).show()
        }
    }
}