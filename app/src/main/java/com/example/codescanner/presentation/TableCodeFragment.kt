package com.example.codescanner.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.codescanner.R
import com.example.codescanner.databinding.FragmentTableScannerBinding
import com.example.codescanner.presentation.recycler.Adapter
import com.example.codescanner.presentation.viewmodel.TableCodeViewModel
import javax.inject.Inject

class TableCodeFragment : Fragment(R.layout.fragment_table_scanner) {

    companion object {
        const val TAG = "Table Fragment"
        fun newInstance() = TableCodeFragment()
    }

    @Inject
    lateinit var viewModel: TableCodeViewModel
    private val binding by viewBinding<FragmentTableScannerBinding>()
    private val adapter by lazy { Adapter() }

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