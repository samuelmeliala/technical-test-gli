package com.samuel.technicaltest2

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProfile: ImageView = itemView.findViewById(R.id.profileImageView)
        val textViewName: TextView = itemView.findViewById(R.id.nameTextView)
        val textViewAddress: TextView = itemView.findViewById(R.id.addressTextView)
        val cardView: View = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]

        holder.textViewName.text = student.name
        holder.textViewAddress.text = student.address

        // Load profile picture using Glide
        Glide.with(holder.imageViewProfile.context)
            .load(student.profilePicture)
            .placeholder(R.drawable.default_profile)
            .circleCrop()
            .into(holder.imageViewProfile)

        // Set click listener for the entire card
        holder.cardView.setOnClickListener {
            try {
                showStudentDetailsDialog(it.context, student)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount() = students.size

    private fun showStudentDetailsDialog(context: Context, student: Student) {
        val builder = Dialog(context)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCancelable(true)
        builder.setContentView(R.layout.dialog_student_details)

        // Find views in dialog
        val dialogImageView: ImageView = builder.findViewById(R.id.dialogImageViewProfile)
        val dialogNameView: TextView = builder.findViewById(R.id.dialogTextViewName)
        val dialogAddressView: TextView = builder.findViewById(R.id.dialogTextViewAddress)

        // Set data
        dialogNameView.text = student.name
        dialogAddressView.text = student.address

        // Load image
        Glide.with(context)
            .load(student.profilePicture)
            .placeholder(R.drawable.default_profile)
            .circleCrop()
            .into(dialogImageView)

        // Set dialog properties
        val window = builder.window
        if (window != null) {
            window.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        // Show dialog
        builder.show()
    }
}