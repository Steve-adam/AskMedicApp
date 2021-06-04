package com.example.askmedic

import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var context: Context, var data:ArrayList<Doctor>): BaseAdapter() {

    private class ViewHolder(row:View?){
        var doctorName:TextView
        var speciality:TextView
        var institution:TextView
        var myLinearLayout:LinearLayout


        init {
            this.doctorName = row?.findViewById(R.id.tvName) as TextView
            this.speciality = row?.findViewById(R.id.tvSpecialty) as TextView
            this.institution = row?.findViewById(R.id.tvInstitution) as TextView
            this.myLinearLayout = row?.findViewById(R.id.tvlinearlayout) as LinearLayout




        }
    }
    override fun getCount(): Int {
        return data.count()
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View?
        val viewHolder:ViewHolder
        if(convertView == null){
            val layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.items,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view= convertView
            viewHolder = view.tag as ViewHolder
        }
        val doctor:Doctor = getItem(position) as Doctor
        viewHolder.doctorName.text = doctor.doctorname
        viewHolder.speciality.text = doctor.specialty
        viewHolder.institution.text = doctor.institution



        return view as View
    }
}