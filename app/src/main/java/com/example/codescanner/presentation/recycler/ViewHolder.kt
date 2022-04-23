package com.example.codescanner.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codescanner.databinding.ItemRowBinding
import com.example.codescanner.domain.models.CodeScan

class ViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup) = ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun bindItem(codeScan: CodeScan) {
        with(codeScan){
            binding.rowCode.text = link
            binding.rowDate.text = date
            binding.rowTime.text = time
        }
    }
}