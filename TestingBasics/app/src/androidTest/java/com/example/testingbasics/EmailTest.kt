package com.example.testingbasics

import com.example.testingbasics.util.EmailValidator
import com.google.common.truth.Truth.*
import org.junit.Test

class InstEmailTest {

    @Test
    fun check_email_valid() {
        assertThat(EmailValidator.isValid("aaa@bbb.com")).isTrue()
    }
    @Test
    fun check_email_valid2() {
        assertThat(EmailValidator.isValid("balaviper555@gmail.com")).isTrue()
    }
}