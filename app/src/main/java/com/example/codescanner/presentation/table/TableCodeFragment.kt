package com.example.codescanner.presentation.table

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.codescanner.R
import com.example.codescanner.databinding.FragmentTableScannerBinding
import com.example.codescanner.presentation.CodeScannerApplication
import com.example.codescanner.presentation.listener.ShareListener
import com.example.codescanner.presentation.table.recycler.TableAdapter
import javax.inject.Inject

class TableCodeFragment : Fragment(R.layout.fragment_table_scanner) {

    companion object {
        const val TAG = "Table Fragment"
        fun newInstance() = TableCodeFragment()
    }

    @Inject
    lateinit var viewModel: TableCodeViewModel
    private val binding by viewBinding<FragmentTableScannerBinding>()
    private val adapter by lazy { TableAdapter(onClickShare) }

    private val onClickShare = object : ShareListener {
        override fun shareLink(link: String) {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, link)
            }
            val intentChooser = Intent.createChooser(intent, "Share TITLE")
            startActivity(intentChooser)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CodeScannerApplication.appComponent?.inject(this)
        initObserver()
    }

    private fun initObserver() {
        binding.recycler.adapter = adapter
        viewModel.codeScanner.observe(viewLifecycleOwner) { list ->
            adapter.submitItem(list)
        }
    }
}