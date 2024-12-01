package com.example.lekarskaordinacija.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.lekarskaordinacija.Domain.DoctorsModel
import com.example.lekarskaordinacija.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter(val items: MutableList<DoctorsModel>) : RecyclerView.Adapter<TopDoctorAdapter.Viewholder>() {
    private var context: Context? = null

    class Viewholder(val binding: ViewholderTopDoctorBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding =
            ViewholderTopDoctorBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.nameText.text = items[position].Name
        holder.binding.specialText.text = items[position].Special.toString()
        holder.binding.yearText.text = items[position].Experiese.toString() + " Year"

        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.img)
    }
}
