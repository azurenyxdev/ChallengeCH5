package id.rich.challengech5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MenuPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_page)

        val playername = intent.getStringExtra("player_name")
        val viewMenuPage = findViewById<ConstraintLayout>(R.id.view_menupage)
        val snackbar = Snackbar.make(viewMenuPage, "Selamat Datang $playername", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Tutup"){
            snackbar.dismiss()
        }
        snackbar.show()
        val iv_p2p = findViewById<ImageView>(R.id.iv_p2p)
        val iv_p2c = findViewById<ImageView>(R.id.iv_p2c)
        val tv_p2p = findViewById<TextView>(R.id.tv_p2p)
        val tv_p2c = findViewById<TextView>(R.id.tv_p2c)
        val intent = Intent(this, GameActivity::class.java)

        tv_p2p.setText("$playername vs Pemain")
        tv_p2c.setText("$playername vs CPU")

        iv_p2p.setOnClickListener {
            intent.putExtra("enemy", "Pemain 2")
            intent.putExtra("player_name", playername)
            startActivity(intent)
        }

        iv_p2c.setOnClickListener {
            intent.putExtra("enemy", "CPU")
            intent.putExtra("player_name", playername)
            startActivity(intent)
        }
    }
}