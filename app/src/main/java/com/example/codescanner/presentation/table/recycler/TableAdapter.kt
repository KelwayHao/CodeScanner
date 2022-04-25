package com.example.codescanner.presentation.table.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.presentation.listener.ShareListener

class TableAdapter(private val onClickShare: ShareListener) : RecyclerView.Adapter<TableViewHolder>() {

    private var items: List<CodeScan> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder.newInstance(parent, onClickShare)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<CodeScan>) {
        items = listItem
        notifyDataSetChanged()
    }
}