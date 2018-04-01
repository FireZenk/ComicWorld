package org.firezenk.comicworld.ui.extensions

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

@DslMarker
annotation class AdapterDSL

@AdapterDSL
class AdapterBuilder<M> {

    lateinit var itemView: () -> BindableView<M>
    lateinit var comparator: Comparator<M>

    fun build(): DSLAdapter<M> = DSLAdapter<M>(itemView, comparator)
}

@AdapterDSL
fun <M> adapterDSL(setup: AdapterBuilder<M>.() -> Unit): DSLAdapter<M> = with(AdapterBuilder<M>()) {
    setup()
    build()
}

class DSLAdapter<M>(private val itemView: () -> BindableView<M>, private val comparator: Comparator<M>)
    : RecyclerView.Adapter<DSLAdapter.ViewHolder<M>>() {

    private val collection: MutableList<M> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<M> {
        val rootView = itemView()
        val layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        (rootView as View).layoutParams = layoutParams
        return ViewHolder<M>(rootView)
    }

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder<M>, position: Int) {
        holder.bind(collection[position])
    }

    fun addAll(newCollection: List<M>) {
        diffDSL<M> {
            oldList = collection
            newList = newCollection
            comparable = comparator
        }
    }

    class ViewHolder<in M>(private val item: BindableView<M>) : RecyclerView.ViewHolder(item as View) {
        fun bind(vm: M) = item.bind(vm)
    }
}

interface BindableView<M> {

    fun bind(model: M)
}