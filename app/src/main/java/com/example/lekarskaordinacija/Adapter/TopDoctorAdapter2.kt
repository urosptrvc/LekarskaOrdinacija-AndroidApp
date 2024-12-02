package com.example.lekarskaordinacija.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.lekarskaordinacija.Activity.DetailActivity
import com.example.lekarskaordinacija.Domain.DoctorsModel
import com.example.lekarskaordinacija.databinding.ViewholderTopDoctor2Binding
import com.example.lekarskaordinacija.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter2(val items: MutableList<DoctorsModel>) : RecyclerView.Adapter<TopDoctorAdapter2.Viewholder>() {
    private var context: Context? = null

    class Viewholder(val binding: ViewholderTopDoctor2Binding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding =
            ViewholderTopDoctor2Binding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.nameTxt.text = items[position].Name
        holder.binding.specialTxt.text = items[position].Special.toString()
        holder.binding.degreeTxt.text = "Sertified Doctor"
        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.img)

        holder.binding.makeBtn.setOnClickListener{
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra("object",items[position])
            context?.startActivity(intent)
        }
    }
}
