package com.samuel.technicaltest2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        recyclerView = findViewById(R.id.studentRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load sample data (you can replace this with network call or local database)
        val students = loadSampleData()

        val adapter = StudentAdapter(students)
        recyclerView.adapter = adapter
    }

    private fun loadSampleData(): List<Student> {
        return listOf(
            Student("Safety", "https://img.game8.co/3871997/7b18fbe016ac57d2edb85d9b347992b6.png/show", "123 Main St"),
            Student("Agent Gulliver", "https://img.game8.co/4070142/a487355631ce354c80f61d7439555557.png/show", "456 Oak Ave"),
            Student("Red Moccus", "https://img.game8.co/3995856/24ac8f31b0d07050a2da8db18301b15f.png/show", "789 Pine Rd"),
            Student("Officer Cui", "https://img.game8.co/3952775/5dcaf7be8a937ad7a75cfc8f27421539.png/show", "321 Elm St"),
            Student("Bangvolver", "https://img.game8.co/3924856/a0101a2df7838796c3cfeae9d4a9574d.png/show", "654 Maple Dr"),
            Student("Resonaboo", "https://img.game8.co/3986481/9e5df821122ae72c4c610b720155a3b1.png/show", "987 Cedar Ln"),
            Student("Plugboo", "https://img.game8.co/3919588/50a529c6d51e2369271dcb84ba8ef909.png/show", "147 Birch Rd"),
            Student("Rocketboo", "https://img.game8.co/3871999/395e83c479b8ef01316ca53af18e7b94.png/show", "258 Walnut Ave"),
            Student("Amillion", "https://img.game8.co/3871996/9ea47ed85f6babc2846e09c7a9dc931c.png/show", "369 Pine St"),
            Student("Butler", "https://img.game8.co/3871994/65301a985d09ceea995ce810e67b7692.png/show", "741 Oak Rd")
        )
    }
}