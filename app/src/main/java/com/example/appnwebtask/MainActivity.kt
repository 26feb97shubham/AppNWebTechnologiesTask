package com.example.appnwebtask
import android.arch.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnwebtask.adapter.EmployeesAdapter
import com.example.appnwebtask.apiclient.APIClient
import com.example.appnwebtask.databinding.ActivityMainBinding
import com.example.appnwebtask.model.Data
import com.example.appnwebtask.model.MainModel
import com.example.appnwebtask.staticclass.static_members.employee_list
import com.example.appnwebtask.viewmodel.EmployeeViewModel
import com.example.beebushtestapp.Simple_Divider_Item_Decoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var binding : ActivityMainBinding
    private var employeeList = ArrayList<Data>()
    private lateinit var viewModel: EmployeeViewModel
    private var context = this
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        showEmployeeList()
    }

    private fun showEmployeeList() {
        val call : Call<MainModel> = APIClient.APIClient.employees()
        call.enqueue(object : Callback<MainModel>{
            override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                if (response.isSuccessful){
                    if (response.body()!!.status.equals("success")){
                        employeeList = response.body()!!.data as ArrayList<Data>
                        employee_list = response.body()!!.data as ArrayList<Data>
                        linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        binding.employeeRecyclerView.layoutManager = linearLayoutManager
                        var employeesAdapter = EmployeesAdapter(employeeList, this@MainActivity)
                        binding.employeeRecyclerView.adapter = employeesAdapter
                        employeesAdapter.notifyDataSetChanged()
                    }else{
                        Toast.makeText(this@MainActivity,
                        "Status is false",
                        Toast.LENGTH_LONG)
                            .show()
                    }
                }else{
                    Toast.makeText(this@MainActivity,
                        "Something went Wrong!!!!",
                        Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<MainModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,
                    t.localizedMessage,
                    Toast.LENGTH_LONG)
                    .show()
            }

        })
    }
}