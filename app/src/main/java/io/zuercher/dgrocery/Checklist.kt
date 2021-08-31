package io.zuercher.dgrocery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Checklist : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    // var checklistAdaper: ChecklistAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checklist_activity)
        if (savedInstanceState == null) {
            //supportFragmentManager.beginTransaction()
            //    .replace(R.id.container, ChecklistFragment.newInstance())
            //    .commitNow()
        }

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        var checklistAdaper = ChecklistAdapter(getData(), applicationContext, ChecklistClickListener {
            print("Hello World");
        });

        recyclerView?.setAdapter(checklistAdaper);
        recyclerView?.layoutManager = LinearLayoutManager(this);
    }

    private fun getData() : List<ChecklistItem> {
        var list = ArrayList<ChecklistItem>();

        list.add(ChecklistItem("Name 1", "Some info", "message"));
        list.add(ChecklistItem("Name 2", "Some info", "message"));
        list.add(ChecklistItem("Name 3", "Some info", "message"));

        return list;
    }
}