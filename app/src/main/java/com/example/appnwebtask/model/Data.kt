package com.example.appnwebtask.model
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("employee_age")
    val employeeAge: Int,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("profile_image")
    val profileImage: String
)