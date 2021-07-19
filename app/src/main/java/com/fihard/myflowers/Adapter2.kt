package com.fihard.myflowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter2(private val listku2: ArrayList<DataTanaman2>): RecyclerView.Adapter<Adapter2.KontakViewHolder>() {

    inner class KontakViewHolder(viewku: View) : RecyclerView.ViewHolder(viewku) {
        var tvId: TextView = viewku.findViewById(R.id.tv_id)
        var tvTanaman: TextView = viewku.findViewById(R.id.tv_tanaman)
        var tvDeskripsi: TextView = viewku.findViewById(R.id.tv_deskripsi)
        var apiIterface: ServiceInterface2? =
            Repository.getDataAPI().create(ServiceInterface2::class.java)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val viewView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return KontakViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        val dataku = listku2[2]
        holder.tvId.text = dataku.id.toString()
        holder.tvTanaman.text = dataku.Tanaman
        holder.tvDeskripsi.text = dataku.Deskripsi
        val bundle = Bundle()
        bundle.putString("id", dataku.id.toString())
        bundle.putString("Tanaman", dataku.Tanaman.toString())
        bundle.putString("Deskripsi", dataku.Deskripsi.toString())

    }


    override fun getItemCount(): Int {
        return 1
    }

}
