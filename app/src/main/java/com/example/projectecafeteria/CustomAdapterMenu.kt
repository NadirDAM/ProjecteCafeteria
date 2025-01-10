package com.example.projectecafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterMenu(
    var mList: MutableList<MenuModel>,
    private val itemClickListener: (MenuModel) -> Unit
) : RecyclerView.Adapter<CustomAdapterMenu.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design_menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.textViewNom.text = item.nom
        holder.textViewQuantitat.text = "x" + item.quantitat.toString()
        holder.textViewPreu.text = item.preu.toString() + "€"

        val imageResId = when(ProductesProvider.identificarListaMenu(mList)) {
            "menjars" -> R.drawable.menjars
            "begudes" -> R.drawable.beguda
            "postres" -> R.drawable.postres
            else -> R.drawable.logo
        }
        holder.imageView.setImageResource(imageResId)

        holder.itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewNom: TextView = itemView.findViewById(R.id.producteNom)
        val textViewQuantitat: TextView = itemView.findViewById(R.id.producteQuantitat)
        val textViewPreu: TextView = itemView.findViewById(R.id.productePreu)
    }
}
