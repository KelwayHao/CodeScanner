package com.example.codescanner.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codescanner.domain.models.CodeScan

class Adapter(): RecyclerView.Adapter<ViewHolder>() {

    private var items: List<CodeScan> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<CodeScan>) {
        items = listItem
        notifyDataSetChanged()
    }
}