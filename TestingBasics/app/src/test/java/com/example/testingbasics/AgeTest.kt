package com.example.testingbasics

import com.example.testingbasics.util.AgeCheck
import com.google.common.truth.Truth
import org.junit.Test

class AgeCheck {
    @Test
    fun age_CheckIs12() {
        Truth.assertThat(AgeCheck.isAgeValid(12)).isFalse()
    }

    @Test
    fun age_CheckIs52() {
        Truth.assertThat(AgeCheck.isAgeValid(52)).isFalse()
    }
    @Test
    fun age_CheckIsNegative() {
        Truth.assertThat(AgeCheck.isAgeValid(-13)).isFalse()
    }
    @Test
    fun age_CheckIs30() {
        Truth.assertThat(AgeCheck.isAgeValid(30)).isFalse()
    }

    @Test
    fun age_CheckIs15() {
        Truth.assertThat(AgeCheck.isAgeValid(15)).isTrue()
    }
    @Test
    fun age_CheckIs51() {
        Truth.assertThat(AgeCheck.isAgeValid(51)).isTrue()
    }
}