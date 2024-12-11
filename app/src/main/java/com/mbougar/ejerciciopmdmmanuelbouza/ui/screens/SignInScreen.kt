package com.mbougar.ejerciciopmdmmanuelbouza.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mbougar.ejerciciopmdmmanuelbouza.ui.components.Header
import com.mbougar.ejerciciopmdmmanuelbouza.ui.components.PasswordVisibilityToggleIcon
import com.mbougar.ejerciciopmdmmanuelbouza.viewmodel.LoginViewModel

@Composable
fun SignInScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val isLoginEnabled by viewModel.isLoginEnabled.observeAsState(false)
    val showPassword by viewModel.showPassword.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("INICIO DE SESIÓN", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("Introduce tus credenciales para iniciar sesión", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onLoginChange(it, password) },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onLoginChange(email, it) },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    PasswordVisibilityToggleIcon(
                        showPassword = showPassword,
                        onTogglePasswordVisibility = { viewModel.togglePasswordVisibility() })
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { if (isLoginEnabled) navController.navigate("mainScreen") },
                modifier = Modifier.fillMaxWidth(),
                enabled = isLoginEnabled,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("INICIAR SESIÓN", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Normal)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(onClick = { }) {
                    Text("¿Olvidaste tu contraseña?", color = Color.Gray)
                }
            }
        }
    }
}