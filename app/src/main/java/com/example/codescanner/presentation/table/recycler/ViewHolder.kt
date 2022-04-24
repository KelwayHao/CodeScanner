package com.example.codescanner.presentation.table.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codescanner.databinding.ItemRowBinding
import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.presentation.listener.ShareListener

class ViewHolder(
    private val binding: ItemRowBinding,
    private val onClickShareListener: ShareListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup, onClickShareListener: ShareListener) = ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClickShareListener = onClickShareListener
        )
    }

    fun bindItem(codeScan: CodeScan) {
        with(codeScan) {
            binding.rowLink.text = link
            binding.rowDate.text = date
            binding.rowTime.text = time

            binding.rootRow.setOnClickListener {
                onClickShareListener.shareLink(link)
            }
        }
    }
}