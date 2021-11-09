package com.example.testingbasics

import com.example.testingbasics.util.EmailValidator
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class EmailTest {

    @Test
    fun check_isEmailValid() {
        assertThat(EmailValidator.isValidMail("aaa@bbb.com")).isTrue()
    }
    @Test
    fun check_second(){
        assertThat(EmailValidator.isValidMail("aaa@bbb.ac.in")).isTrue()
    }
    @Test
    fun check_symbols(){
        assertThat(EmailValidator.isValidMail("a;a/a@bbb.ac.in")).isFalse()
    }

    @Test
    fun getEven(){
        var x = arrayOf(3,5,2,7)
        assertThat(EmailValidator.firstEven(x)).isEqualTo(2)
    }

}

