package com.example.roomsiswa_122.repositori

import android.content.Context
import com.example.roomsiswa_122.data.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}
class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabese(context).siswaDao())
    }
}