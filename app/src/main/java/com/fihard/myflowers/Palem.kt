package com.fihard.myflowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*


class Palem : AppCompatActivity() {
    lateinit var back : ImageView
    lateinit var rv_data : RecyclerView
    lateinit var apiService3: ServiceInterface3
    private var ambilData3: ArrayList<DataTanaman3> = arrayListOf()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.palem)

        rv_data = findViewById(R.id.rv_data)
        apiService3 = Repository.getDataAPI().create(ServiceInterface3::class.java)
        apiService3.getData().enqueue(object : Callback<List<DataTanaman3>> {
            override fun onResponse(
                call: retrofit2.Call<List<DataTanaman3>>,
                response: Response<List<DataTanaman3>>
            ) {
                if (response.isSuccessful){
                    val res = response.body()
                    ambilData3.addAll(res!!)
                    rv_data.layoutManager = LinearLayoutManager(this@Palem)
                    rv_data.adapter = Adapter3(ambilData3)
                }
            }
            override fun onFailure(call: retrofit2.Call<List<DataTanaman3>>, t: Throwable) {
            }
        })

        back = findViewById(R.id.back)
        back.setOnClickListener {

            val pindah = Intent(this, MainActivity::class.java)
            startActivity(pindah)
        }


    }


}