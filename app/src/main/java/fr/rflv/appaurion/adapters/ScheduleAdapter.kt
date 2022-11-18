package fr.rflv.appaurion.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.rflv.appaurion.R
import fr.rflv.appaurion.services.aurion.data.Course

class ScheduleAdapter (private val Courses : Array<Course>) : RecyclerView.Adapter<ScheduleAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = View.inflate(parent.context, R.layout.fragment_schedule, null)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCourse = Courses[position]
        holder.titleBegin.text = currentCourse.startDateTime.toString()
        holder.titleEnd.text = currentCourse.endDateTime.toString()
        holder.titleSubject.text = currentCourse.name
        holder.titleType.text = currentCourse.courseType
        holder.titleLocalisation.text = currentCourse.rooms.joinToString(" ")
        holder.titleTeacher.text = currentCourse.teachers.joinToString(" ")
    }

    override fun getItemCount(): Int {
        return Courses.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleBegin: TextView = itemView.findViewById(R.id.beginning)
        val titleEnd: TextView = itemView.findViewById(R.id.end)
        val titleSubject: TextView = itemView.findViewById(R.id.subject)
        val titleType: TextView = itemView.findViewById(R.id.type)
        val titleLocalisation: TextView = itemView.findViewById(R.id.subject2)
        val titleTeacher: TextView = itemView.findViewById(R.id.teacher)
    }
}