package com.sicoss.mfragments


import android.content.Context
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_discount.*

/**
 * A simple [Fragment] subclass.
 */

const val ARG_TITLE = "arg_title"

class DiscountFragment : Fragment() {


    var title: String? = null
    lateinit var discountEventListener: DiscountEventListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is DiscountEventListener) {
            discountEventListener = context
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WelcomeLabel.text = title
        btnCalculate.setOnClickListener {
            tvResult.text = calculateDiscount(
                edtAmount.text.toString().toDouble(),
                edtDiscount.text.toString().toDouble()
            ).toString()
            discountEventListener.showResult(tvResult.text.toString())
        }
    }


    fun calculateDiscount(amount: Double, discount: Double) = amount - (amount * (discount / 100))

    companion object {
        fun newInstance(title: String) =
            DiscountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                }
            }

    }
}
