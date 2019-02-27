package com.sapple.attendanceapp.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.sapple.attendanceapp.datamodel.LoginData

@Dao
interface AttendanceDao {

    @Insert(onConflict = REPLACE)
    fun insertEmployeeLoginData(login : LoginData)

    @Query("SELECT * from employeeInfo")
    fun getData(): List<LoginData>

    @Delete
    fun deleteUsers(vararg users: LoginData)
}