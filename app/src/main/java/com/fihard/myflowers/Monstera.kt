package com.fihard.myflowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*


class Monstera : AppCompatActivity() {


    lateinit var back : ImageView

    lateinit var rv_data : RecyclerView
    lateinit var apiService2: ServiceInterface2
    private var ambilData2: ArrayList<DataTanaman2> = arrayListOf()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monstera)

        rv_data = findViewById(R.id.rv_data)
        apiService2 = Repository.getDataAPI().create(ServiceInterface2::class.java)
        apiService2.getData().enqueue(object : Callback<List<DataTanaman2>> {
            override fun onResponse(
                call: retrofit2.Call<List<DataTanaman2>>,
                response: Response<List<DataTanaman2>>
            ) {
                if (response.isSuccessful){
                    val res = response.body()
                    ambilData2.addAll(res!!)
                    rv_data.layoutManager = LinearLayoutManager(this@Monstera)
                    rv_data.adapter = Adapter2(ambilData2)
                }
            }
            override fun onFailure(call: retrofit2.Call<List<DataTanaman2>>, t: Throwable) {
            }
        })

        back = findViewById(R.id.back)
        back.setOnClickListener {

            val pindah = Intent(this, MainActivity::class.java)
            startActivity(pindah)
        }



    }


}