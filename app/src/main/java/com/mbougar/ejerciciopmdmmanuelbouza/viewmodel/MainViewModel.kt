package com.mbougar.ejerciciopmdmmanuelbouza.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbougar.ejerciciopmdmmanuelbouza.R
import com.mbougar.ejerciciopmdmmanuelbouza.model.Producto

class MainViewModel : ViewModel() {

    private val _search = MutableLiveData("")
    val search: LiveData<String> get() = _search

    private val productos = mutableListOf<Producto> (
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Pera", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Platano", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Manzana", R.drawable.moto_background, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),

    )

    var searchProductos = productos

    fun onSearchChange(search: String) {
        _search.value = search

        searchProductos = productos.filter { it.nombre.contains(search) }.toMutableList()
    }
}