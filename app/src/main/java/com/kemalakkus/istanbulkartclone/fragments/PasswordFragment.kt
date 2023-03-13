package com.kemalakkus.istanbulkartclone.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.Editable
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.databinding.FragmentPasswordBinding


class PasswordFragment : Fragment() {
    //private val correctPassword = "123456"
    private lateinit var binding: FragmentPasswordBinding

    private lateinit var sharedPreferences: SharedPreferences


    var isTime:Boolean=false
    var currentFocus: View? = null
    private var lastClickTime: Long = 0

    // EditTextlerin listesi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPasswordBinding.inflate(inflater, container, false)




        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.exit.setOnClickListener {
            findNavController().navigate(R.id.action_passwordFragment_to_homeFragment2)
        }


        binding.etDigit1.requestFocus()

        binding.etDigit2.apply {
            isFocusableInTouchMode = false
            isClickable=false
        }
        binding.etDigit3.apply {
            isFocusableInTouchMode = false
            isClickable=false
        }
        binding.etDigit4.apply {
            isFocusableInTouchMode = false
            isClickable=false
        }
        binding.etDigit5.apply {
            isFocusableInTouchMode = false
            isClickable=false
        }
        binding.etDigit6.apply {
            isFocusableInTouchMode = false
            isClickable=false
        }

        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etDigit1, InputMethodManager.SHOW_IMPLICIT)

        passwordChange()

    }

    private fun passwordChange() {

        val editTextList = arrayListOf(binding.etDigit1, binding.etDigit2, binding.etDigit3, binding.etDigit4, binding.etDigit5, binding.etDigit6)

        for (i in 0 until editTextList.size) {
            editTextList[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (before == 0 && count == 1) {
                        // Kullanıcı bir karakter yazdığında bir sonraki editText'e geç
                        if (i < editTextList.size - 1) {
                            editTextList[i + 1].requestFocus()
                        }else{
                            val password = binding.etDigit1.text.toString() + binding.etDigit2.text.toString() + binding.etDigit3.text.toString() +
                                    binding.etDigit4.text.toString() + binding.etDigit5.text.toString() + binding.etDigit6.text.toString()
                            editTextList.forEach{
                                it.text.clear()
                                it.setBackgroundResource(R.drawable.edit_text_box)
                                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow(editTextList[i].windowToken, 0)
                            }
                            if(password=="123456"){
                                binding.cdForget.visibility=View.GONE

                                findNavController().navigate(R.id.action_passwordFragment_to_myCardsFragment)
                            }else{
                                binding.cdForget.visibility=View.VISIBLE

                            }
                        }
                    }
    }

                override fun afterTextChanged(s: Editable?) {

                }
            })
            editTextList[i].setOnKeyListener(object : View.OnKeyListener {
                override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                    if (keyCode == KeyEvent.KEYCODE_DEL && event?.action == KeyEvent.ACTION_DOWN) {
                        // Backspace tuşuna basıldığında, önceki editText'e geç ve içeriğini sıfırla
                        if (i > 0) {
                            editTextList[i - 1].requestFocus()
                            editTextList[i - 1].setText("")
                        }
                    }
                    return false
                }
            })

            binding.etDigit1.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit1.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit1.text.toString().isNotEmpty()) {
                        binding.etDigit1.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit1.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }

            binding.etDigit2.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit2.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit2.text.toString().isNotEmpty()) {
                        binding.etDigit2.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit2.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }

            binding.etDigit3.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit3.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit3.text.toString().isNotEmpty()) {
                        binding.etDigit3.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit3.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }
            binding.etDigit4.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit4.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit4.text.toString().isNotEmpty()) {
                        binding.etDigit4.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit4.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }
            binding.etDigit5.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit5.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit5.text.toString().isNotEmpty()) {
                        binding.etDigit5.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit5.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }

            binding.etDigit6.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.etDigit6.setBackgroundResource(R.drawable.edit_text_selected_box)
                } else {
                    if (binding.etDigit6.text.toString().isNotEmpty()) {
                        binding.etDigit6.setBackgroundResource(R.drawable.edit_text_full_box)
                    } else {
                        binding.etDigit6.setBackgroundResource(R.drawable.edit_text_box)                }
                }
            }

        }
    }


}






/*private fun navigateToMyCardsFragment() {
// Şifre doğruysa MyCardsFragment'a geçiş yapılır.
findNavController().navigate(R.id.action_passwordFragment_to_myCardsFragment)
}
private fun clearEditTexts() {
// Şifre yanlış ise edittext kutucukları temizlenir.
binding.etDigit1.text.clear()
binding.etDigit2.text.clear()
binding.etDigit3.text.clear()
binding.etDigit4.text.clear()
binding.etDigit5.text.clear()
binding.etDigit6.text.clear()
}*/
/*for ((index, editText) in editTextList.withIndex()) {
           editText.addTextChangedListener(object : TextWatcher {
               override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

               override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

               override fun afterTextChanged(s: Editable?) {
                   // Edittext'e rakam girildiğinde diğer edittext'e geçiş yapar.
                   if (s?.length == 1 && index < 5) {
                       editTextList[index + 1].requestFocus()
                   }

                   // Tüm edittext kutucukları dolu ise şifrenin doğruluğunu kontrol eder.
                   if (editTextList.all { it.text.isNotEmpty() }) {
                       val enteredPassword = editTextList.joinToString("") { it.text.toString() }
                       if (enteredPassword == correctPassword) {
                           navigateToMyCardsFragment()
                       } else {
                           binding.cdForget.visibility = View.VISIBLE
                           clearEditTexts()
                       }
                       // Klavyeyi otomatik olarak kapat
                       //val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                       //inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
                   }
               }
           })
       }*/







