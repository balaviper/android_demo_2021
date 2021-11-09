package com.example.testingbasics.util


import android.text.TextUtils
import java.util.regex.Pattern

class EmailValidator {
    companion object {

        fun isValidMail(emailAddress: String) =
            Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\$")
                .matcher(emailAddress)
                .matches()

        fun isValid(email: String) = !TextUtils.isEmpty(email) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        fun firstEven(x : Array<Int>): Int {
            for (i in x){
                if(i%2==0)
                    return i
            }
            return 0
        }


    }
}
class AgeCheck{

    companion object{
        fun isAgeValid(age : Int):Boolean{
            if(age in 13..51) {
                if (age == 30)
                    return false
                return true
            }
            return false
        }
    }
}
