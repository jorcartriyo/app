package com.example.jorge.ejercicioluisreciclerview
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*
import java.io.IOException
import java.net.URL


class MainActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, FracmentRecicler.OnFragmentInteractionListener, FracmentReciclerclientes.OnFragmentInteractionListener {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun cargarFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_main, FracmentRecicler.newInstance("a","b"), "rageComicList")
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    fun inserta(){
        val intent= Intent(this,inserta::class.java)
        startActivity(intent)
    }
         fun acceso(){
        val intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.motos -> {
                cargarFragment()
            }

            R.id.informacion-> {
                inserta()
            }
            R.id.acceso-> {
                acceso()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun home(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}