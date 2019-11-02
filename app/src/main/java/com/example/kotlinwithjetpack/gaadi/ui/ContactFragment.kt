package com.example.kotlinwithjetpack.gaadi.ui

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.kotlinwithjetpack.databinding.LayoutDialogBinding


class ContactFragment : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = LayoutDialogBinding.inflate(LayoutInflater.from(inflater.context), container, false)

        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)


        binding.cancel.setOnClickListener {
            dismiss()
            childFragmentManager.popBackStackImmediate()

        }

        binding.send.setOnClickListener {

            if (binding.name.text.isEmpty() || binding.message.text.isEmpty()) {
                Toast.makeText(context, "Please enter valid details", Toast.LENGTH_LONG).show()

            } else {

                val mIntent = Intent(Intent.ACTION_MAIN)
                // put recipient email in intent
                /* recipient is put as array because you may wanna send email to multiple emails
                   so enter comma(,) separated emails, it will be stored in array*/
                mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("developer@aigen.tech"))
                //put the Subject in the intent
                mIntent.putExtra(Intent.EXTRA_SUBJECT, "You hav one query from " + binding.name.text)
                //put the message in the intent
                mIntent.putExtra(Intent.EXTRA_TEXT, binding.message.text)
                mIntent.addCategory(Intent.CATEGORY_APP_EMAIL)


                try {
                    //start email intent
                    startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
                } catch (e: Exception) {
                    //if any thing goes wrong for example no email client application or any exception
                    //get and show exception message
                    Toast.makeText(context, "Error in email sent", Toast.LENGTH_LONG).show()
                }

                dismiss()
                childFragmentManager.popBackStackImmediate()

            }


        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ActionBar.LayoutParams.MATCH_PARENT
        params.height = 1000
        dialog!!.window!!.attributes = params as android.view.WindowManager.LayoutParams
    }
}
