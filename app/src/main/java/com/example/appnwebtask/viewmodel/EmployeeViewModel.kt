package com.example.appnwebtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appnwebtask.model.Data
import com.example.appnwebtask.staticclass.static_members.employee_list
import java.util.ArrayList

class EmployeeViewModel : ViewModel() {
    var employeeLiveData: MutableLiveData<ArrayList<Data>>
    var employeeData: ArrayList<Data>? = null
    private fun init() {
        populateemployeedata()
        employeeLiveData.value = employeeData
    }
    init {
        employeeLiveData = MutableLiveData()
    }
    fun populateemployeedata(){
        employeeData = employee_list
    }
}