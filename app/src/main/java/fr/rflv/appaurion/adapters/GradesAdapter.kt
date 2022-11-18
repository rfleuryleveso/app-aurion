package fr.rflv.appaurion.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.rflv.appaurion.R
import fr.rflv.appaurion.services.aurion.data.Mark

class GradesAdapter (private val Grades:Array<Mark>) : RecyclerView.Adapter<GradesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = View.inflate(parent.context, R.layout.fragment_grades, null)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentGrade = Grades[position]
        holder.titleSubject.text = currentGrade.name
        holder.titleMark.text = currentGrade.mark.toString()
        holder.titleCoefficient.text = currentGrade.coefficient.toString()
        holder.titleDate.text = currentGrade.date.toString()
    }

    override fun getItemCount(): Int {
        return Grades.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleSubject: TextView = itemView.findViewById(R.id.specie)
        val titleMark: TextView = itemView.findViewById(R.id.mark)
        val titleCoefficient: TextView = itemView.findViewById(R.id.coefficient)
        val titleDate: TextView = itemView.findViewById(R.id.date)
    }
}