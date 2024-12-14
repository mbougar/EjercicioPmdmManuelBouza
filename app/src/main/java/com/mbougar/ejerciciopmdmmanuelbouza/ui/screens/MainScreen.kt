package com.mbougar.ejerciciopmdmmanuelbouza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mbougar.ejerciciopmdmmanuelbouza.model.Producto
import com.mbougar.ejerciciopmdmmanuelbouza.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel = viewModel()) {
    val search by viewModel.search.observeAsState("")

    Column(modifier = Modifier.background(Color(0xFF4CAF50))) {
        Header(search = search, onSearchChange = { viewModel.onSearchChange(it) })

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(viewModel.searchProductos) { producto ->
                BannerProducto(producto)
            }
        }
    }
}

@Composable
fun BannerProducto(producto: Producto) {
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .clickable { showDialog = true }
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = producto.imageRes),
                contentDescription = "Imagen del producto",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = producto.nombre,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = ("Precio: " + producto.precio.toString() + "€"),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    if (showDialog) {
        ProductoDialog(producto = producto, onDismiss = { showDialog = false })
    }
}

// He tenido que hacer la pantalla del producto un dialog, porque android no me aceptaba la implementacion de serialization
@Composable
fun ProductoDialog(producto: Producto, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(300.dp)
                .height(400.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = producto.imageRes),
                    contentDescription = "Imagen del producto",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = ("Nombre: " + producto.nombre)
                )

                Text(
                    text = if (producto.precioRebaja != null) ("Precio: " + producto.precioRebaja.toString() + "€") else ("Precio: " + producto.precio.toString() + "€")
                )

                Text(
                    text = producto.descripcion,
                )
            }
        }
    }
}

@Composable
fun Header(
    search: String,
    onSearchChange: (String) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                }

                OutlinedTextField(
                    value = search,
                    onValueChange = { onSearchChange(it) },
                    label = { Text("Buscar") },
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Shopping")
                }
            }
        }
    }
}