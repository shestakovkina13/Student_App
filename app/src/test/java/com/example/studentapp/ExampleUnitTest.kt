package com.example.studentapp

import okhttp3.Credentials
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun credentials_isCorrect() {
        val expected = Credentials.basic("111111", "111111").replace("Basic ", "")
        val actual = "MTExMTExOjExMTExMQ=="
        assertEquals(expected, actual)
    }
}