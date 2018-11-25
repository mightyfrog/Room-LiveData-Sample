package org.mightyfrog.android.roomlivedatasample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.mightyfrog.android.roomlivedatasample.data.AppDatabase
import org.mightyfrog.android.roomlivedatasample.data.ItemRepository
import org.mightyfrog.android.roomlivedatasample.viewmodels.ItemListViewModel
import org.mightyfrog.android.roomlivedatasample.viewmodels.ItemListViewModelFactory

/**
 * @author Shigehiro Soejima
 */
class MainActivity : AppCompatActivity() {

    private val repository: ItemRepository by lazy {
        ItemRepository.getInstance(AppDatabase.getInstance(this).itemDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            repository.createItem()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter()

        val itemListViewModel = ViewModelProviders
            .of(this, ItemListViewModelFactory(repository))
            .get(ItemListViewModel::class.java)
        itemListViewModel.itemList.observe(this, Observer<List<Long>> {
            if (it.isEmpty()) {
                (recyclerView.adapter as ItemAdapter).deleteAll()
            } else {
                it.forEach { time ->
                    (recyclerView.adapter as ItemAdapter).add(time)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_clear -> {
                repository.deleteAll()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
