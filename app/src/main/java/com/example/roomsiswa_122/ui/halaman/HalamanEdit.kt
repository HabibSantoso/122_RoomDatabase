@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.roomsiswa_122.ui.halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomsiswa_122.R
import com.example.roomsiswa_122.model.EditViewModel
import com.example.roomsiswa_122.model.PenyediaViewModel
import com.example.roomsiswa_122.navigasi.DestinasiNavigasi
import com.example.roomsiswa_122.navigasi.SiswaTopAppBar
import kotlinx.coroutines.launch

object ItemEditDestination: DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "itemId"
    val routeWithArgS= "$route/{$itemIdArg}"
}

@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(id = ItemEditDestination.titleRes),
                canNavigateBack =true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) {innerPadding ->
        EntrySiswaBody(
            uiStateSiswa =viewModel.siswaUiState,
            onSiswaValueChange =viewModel::updateUiSate,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateSiswa()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )

    }
}