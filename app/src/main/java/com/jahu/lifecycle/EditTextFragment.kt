package com.jahu.lifecycle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_edittext.*

class EditTextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edittext, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            val viewModel = ViewModelProviders.of(it).get(SeekBarViewModel::class.java)
            viewModel.seekBarValue.observe(it, Observer<Int> { valueEditText.setText(it.toString()) })

            valueEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                    val newValue = text.toString().toInt()
                    if (newValue != viewModel.seekBarValue.value) {
                        viewModel.seekBarValue.postValue(newValue)
                    }
                }

            })
        }

    }
}
