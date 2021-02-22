package com.example.studytime

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studytime.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegisterActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            val email = binding.emailText.text.toString()
            val pw = binding.passwordText.text.toString()
            val confirmPw = binding.confirmPasswordText.text.toString()
            if(email.isNotEmpty() && pw.isNotEmpty() && confirmPw.isNotEmpty()) {
                if(!isEmail(email)) {
                    Toast.makeText(applicationContext, "이메일을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                }
                else if(pw != confirmPw) {
                    Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
                else {
                    auth.createUserWithEmailAndPassword(email, pw).addOnCompleteListener {
                        if(it.isSuccessful) {
                            Toast.makeText(applicationContext, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                            finish()
                        }
                        else Toast.makeText(applicationContext, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun isEmail(email: String?): Boolean {
        var returnValue = false
        val regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"
        val p: Pattern = Pattern.compile(regex)
        val m: Matcher = p.matcher(email)
        if (m.matches()) {
            returnValue = true
        }
        return returnValue
    }
}
