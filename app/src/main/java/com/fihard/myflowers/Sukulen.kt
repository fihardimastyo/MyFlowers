package com.fihard.myflowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response

class Sukulen : AppCompatActivity() {
    lateinit var back : ImageView
    lateinit var rv_data : RecyclerView
    lateinit var apiService: ServiceInterface
    private var ambilData: ArrayList<DataTanaman> = arrayListOf()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sukulen)

        rv_data = findViewById(R.id.rv_data)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getData().enqueue(object : Callback<List<DataTanaman>> {
            override fun onResponse(
                call: retrofit2.Call<List<DataTanaman>>,
                response: Response<List<DataTanaman>>
            ) {
                if (response.isSuccessful){
                    val res = response.body()
                    ambilData.addAll(res!!)
                    rv_data.layoutManager = LinearLayoutManager(this@Sukulen)
                    rv_data.adapter = Adapter(ambilData)
                }
            }
            override fun onFailure(call: retrofit2.Call<List<DataTanaman>>, t: Throwable) {
            }
        })

        back = findViewById(R.id.back)
        back.setOnClickListener {

            val pindah = Intent(this, MainActivity::class.java)
            startActivity(pindah)
        }


    }


}