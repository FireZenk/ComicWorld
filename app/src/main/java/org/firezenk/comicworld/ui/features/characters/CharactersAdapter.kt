package org.firezenk.comicworld.ui.features.characters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.features.characters.items.CharacterItem

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private lateinit var collection: List<CharacterModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = CharacterItem(parent.context)
        val layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        rootView.layoutParams = layoutParams
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    fun addAll(collection: List<CharacterModel>) {
        this.collection = collection
        notifyDataSetChanged()
    }

    class ViewHolder(private val item: CharacterItem) : RecyclerView.ViewHolder(item) {
        fun bind(vm: CharacterModel) = item.bind(vm)
    }
}