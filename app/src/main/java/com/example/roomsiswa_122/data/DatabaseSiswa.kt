package com.example.roomsiswa_122.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase(){
    abstract fun siswaDao() : SiswaDao

    companion object{
        private var Instance: DatabaseSiswa? =null

        fun getDatabese(context: Context): DatabaseSiswa {
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabaseSiswa::class.java,
                    "siswa_Database").build().also { Instance =it }
            })
        }
    }
}