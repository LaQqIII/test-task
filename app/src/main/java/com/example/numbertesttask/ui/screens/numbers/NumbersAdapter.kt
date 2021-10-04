package com.example.numbertesttask.ui.screens.numbers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numbertesttask.R
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.extension.inflate
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.item_number.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class NumbersAdapter
@Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<NumbersAdapter.ViewHolder>() {

    var collection: List<Number> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    var clickListener: (Number) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_number), context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val number = collection[position]
        holder.bind(number, clickListener)
    }

    override fun getItemCount(): Int = collection.size

    class ViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(number: Number, onClickListener: (number: Number) -> Unit) {
            itemView.numberTextView.text =
                context.getString(R.string.numberIs, number.value.toString())
            itemView.setOnClickListener { onClickListener(number) }
        }
    }
}