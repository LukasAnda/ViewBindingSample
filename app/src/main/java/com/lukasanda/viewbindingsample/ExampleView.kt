package com.lukasanda.viewbindingsample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.lukasanda.viewbindingsample.databinding.ExampleViewBinding

class ExampleView @JvmOverloads constructor(context: Context,
                                            attrs: AttributeSet? = null,
                                            defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = ExampleViewBinding.inflate(LayoutInflater.from(context), this, true)
}