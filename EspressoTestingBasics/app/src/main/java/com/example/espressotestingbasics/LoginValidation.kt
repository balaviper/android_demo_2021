package com.example.espressotestingbasics

import java.util.regex.Pattern

class LoginValidations {

    fun isUserNameValid(usNm : String) : Boolean  {
        if(usNm.isEmpty()) return false
        if(usNm.length >= 8) return false
        if(usNm.contains("#")) return false
        return true
    }

    fun isPasswordValid(pass : String): Boolean =
        Pattern.compile("^[a-zA-Z_0-9$%#]{1,10}$")
            .matcher(pass)
            .matches()

}