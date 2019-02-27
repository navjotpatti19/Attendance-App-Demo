package com.example.sapple.attendanceapp

import com.sapple.attendanceapp.database.DbHelper
import com.sapple.attendanceapp.database.DbWorkerThread
import com.sapple.attendanceapp.datamodel.LoginData
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var mDbWorkerThread: DbWorkerThread
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
