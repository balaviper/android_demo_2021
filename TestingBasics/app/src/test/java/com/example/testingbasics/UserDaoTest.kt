package com.example.testingbasics

import com.example.testingbasics.dao.UserDao
import com.example.testingbasics.domain.User
import com.google.common.truth.Truth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserDaoTest {

    @Mock
    lateinit var dao : UserDao

    @Test
    fun test_findRecentUser_Normal() {

        Mockito.`when`(
            dao.findRecentUser()
        ).thenReturn(
            User(1, "abc")
        )

        val obj = dao.findRecentUser()
        Truth.assertThat(obj.id).isEqualTo(1)
    }

    @Test
    fun test_findUserById_Negative() {
        Mockito.`when`(
            dao.findUserById(-1)
        ).thenThrow(
            RuntimeException("Bad User Id")
        )

        Assert.assertThrows("Bad User Id", RuntimeException::class.java) {
            dao.findUserById(-1)
        }
    }
}