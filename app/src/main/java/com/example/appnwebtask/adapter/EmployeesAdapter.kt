package com.example.appnwebtask.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnwebtask.databinding.EmployeeItemLayoutBinding
import com.example.appnwebtask.model.Data

class EmployeesAdapter(private val employeeList : ArrayList<Data>, private val context: Context)
    : RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>()
{
    inner class EmployeesViewHolder(private val binding: EmployeeItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindEmployeeData(employee: Data) {
            binding.employeeName.text = employee.employeeName
            binding.employeeSalary.text = employee.employeeSalary.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        return EmployeesViewHolder(EmployeeItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.bindEmployeeData(employee)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}