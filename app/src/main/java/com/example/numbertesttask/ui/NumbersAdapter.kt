package com.example.numbertesttask.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numbertesttask.R
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.databinding.ItemNumberBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.properties.Delegates

class NumbersAdapter
@Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<NumbersAdapter.ViewHolder>() {

    var collection: List<Number> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    var clickListener: (Number) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemNumberBinding = ItemNumberBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemNumberBinding, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection[position], clickListener)

    override fun getItemCount(): Int = collection.size

    class ViewHolder(
        private val itemNumberBinding: ItemNumberBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemNumberBinding.root) {

        fun bind(number: Number, onClickListener: (number: Number) -> Unit) {
            itemNumberBinding.numberTextView.text =
                context.getString(R.string.numberIs, number.value.toString())
            itemView.setOnClickListener { onClickListener(number) }
        }
    }
}