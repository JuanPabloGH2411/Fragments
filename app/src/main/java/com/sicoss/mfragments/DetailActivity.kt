package com.sicoss.mfragments

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import es.dmoral.toasty.Toasty

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var detailParam =intent.getStringExtra(DETAIL_PARAM)
        val dialog =AlertDialog.Builder(this)
        dialog.setTitle(R.string.app_name)
        dialog.setMessage("Ocurrió algo en $detailParam")
        dialog.setNeutralButton("Entendido",object: DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
            }

        })
        dialog.create()
        dialog.show()
    }
}
