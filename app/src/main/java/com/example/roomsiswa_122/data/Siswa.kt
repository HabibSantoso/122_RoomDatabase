package com.example.roomsiswa_122.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblSiswa")
data class Siswa(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val alamat : String,
    val telpon : String
)
