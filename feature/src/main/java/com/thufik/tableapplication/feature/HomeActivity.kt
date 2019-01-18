package com.thufik.tableapplication.feature

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONObject
import java.util.*

class HomeActivity : AppCompatActivity() {

    var animals = ArrayList<JSONObject>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.supportActionBar?.title = "Animals list"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.actionBar?.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        this.actionBar?.addTab(this.actionBar?.newTab()?.setText("Tab 1"))

        val fragmentPagerAdapter = MyPagerAdapter(supportFragmentManager)

        viewPager.adapter = fragmentPagerAdapter

        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu,menu)

        val item = menu?.findItem(R.id.search)

        val actionViewSearch = item?.actionView

        val implementaAInterfaceSearchView = ISearchView()

        if (actionViewSearch as android.widget.SearchView != null){
            actionViewSearch.setOnQueryTextListener(implementaAInterfaceSearchView)
        }


        val shareItem = menu.findItem(R.id.share)

        val shareActionProvider = MenuItemCompat.getActionProvider(shareItem) as android.support.v7.widget.ShareActionProvider

        val intent = Intent(Intent.ACTION_SEND)

        shareActionProvider.setShareIntent(intent)


        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

//        val id = item?.itemId
//
//        if (id == R.id.item3){
//
//            val intent = Intent(this,AnimalDetail::class.java)
//            intent.putExtra("name","teste")
//
//            startActivity(intent)
//        }else if (id == R.id.share){
//            val intent = Intent(Intent.ACTION_MEDIA_SHARED)
//
//            startActivity(intent)
//        }

        return  true
    }

    inner class ISearchView : android.widget.SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            val toast = Toast.makeText(this@HomeActivity,"O usuário digitou" + query, Toast.LENGTH_SHORT)
            toast.show()


            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {

            return  true
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
