package com.lukasanda.viewbindingsample.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.lukasanda.viewbindingsample.databinding.MainActivityBinding

abstract class BaseAdapter<ITEM, HOLDER : BindingViewHolder<ITEM, *>> : RecyclerView.Adapter<HOLDER>() {
    private val items: MutableList<ITEM> = mutableListOf()

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HOLDER, position: Int) = holder.bind(items[position])

    fun swapItems(newItems: List<ITEM>) {
        items.clear()
        items.addAll(newItems)

        notifyDataSetChanged()
    }
}

abstract class BindingViewHolder<in ITEM, BINDING : ViewBinding>(private val binding: BINDING) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: ITEM)
}

inline fun <ITEM, reified VIEW_BINDING : ViewBinding, reified HOLDER : BindingViewHolder<ITEM, VIEW_BINDING>> ViewGroup.create(
    createHolder: (VIEW_BINDING) -> HOLDER,
    inflateFun: (LayoutInflater, ViewGroup, Boolean) -> VIEW_BINDING
): HOLDER {
    val inflater = LayoutInflater.from(context)
    return createHolder(inflateFun(inflater, this, false))
}

class ExampleAdapter : BaseAdapter<String, ExampleHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleHolder = parent.create(::ExampleHolder, MainActivityBinding::inflate)
}

class ExampleHolder(binding: MainActivityBinding): BindingViewHolder<String, MainActivityBinding>(binding){
    override fun bind(item: String) {

    }
}