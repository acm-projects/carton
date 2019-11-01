package com.example.cartonlist

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cartonlist.ColorAdapter
import com.example.cartonlist.ColorDict
import com.example.cartonlist.SimpleAdapter
import com.example.cartonlogintest.R
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*
import kotlinx.android.synthetic.main.content_list.view.*

class LActivity : AppCompatActivity() {

    fun initToolBar() {
        setSupportActionBar(toolbar)
        // Don't use android.R... resources!  They can change without warning.
        //toolbar.setNavigationIcon(android.R.drawable.ic_menu_gallery);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)
    }

    private fun initListView() {
        // XXX Write me
        val adapter = SimpleAdapter(this)
        adapter.addAll(ColorDict.getAll())
        listView.adapter = adapter
        listView.onItemClickListener =
                AdapterView.OnItemClickListener { _, _, i, _ ->
                    adapter.moveToTop(i)
                }
    }

    private fun initRecyclerView() {
        // Define a layout for RecyclerView
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

        // Initialize a new instance of RecyclerView Adapter instance
        val adapter = ColorAdapter(this)
        // Set the adapter for RecyclerView
        recyclerView.adapter = adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initToolBar()
        initListView()
        initRecyclerView()
        // Janky method to allow one Activity to have two different layouts
        // Fragments will make this much better
        listView.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        when (id) {
            R.id.swap -> if (listView.visibility == View.VISIBLE) {
                listView.visibility = View.INVISIBLE
                recyclerView.visibility = View.VISIBLE
            } else {
                listView.visibility = View.VISIBLE
                recyclerView.visibility = View.INVISIBLE
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
