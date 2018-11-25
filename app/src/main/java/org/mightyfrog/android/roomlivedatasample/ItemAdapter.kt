package org.mightyfrog.android.roomlivedatasample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Shigehiro Soejima
 */
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val list: MutableList<Long> = mutableListOf()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int) = list[position]

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)

        return ItemAdapter.ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.textView.text = list[position].toString()
    }

    fun add(time: Long) {
        if (!list.contains(time)) {
            list.add(0, time)
//            notifyItemInserted(0)
            notifyDataSetChanged()
        }
    }

    fun deleteAll() {
        list.clear()
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }
}