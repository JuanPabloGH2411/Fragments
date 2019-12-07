package com.sicoss.mfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(),DiscountEventListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer,DiscountFragment.newInstance(getString(R.string.app_name)))
            .commit()

        //Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show()

    }


    override fun showResult(result: String) {
        Toasty.success(this,"El resultado es $result",Toasty.LENGTH_LONG).show()
    }
}
