package com.mbougar.ejerciciopmdmmanuelbouza.model

data class Producto(
    val nombre: String,
    val imageRes: Int,
    val categoria: String,
    val comercio: String,
    val precio: Double,
    val novedad: Boolean,
    val precioRebaja: Double?,
    val descripcion: String
)