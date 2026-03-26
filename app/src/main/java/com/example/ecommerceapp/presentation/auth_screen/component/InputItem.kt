package com.example.ecommerceapp.presentation.auth_screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // Required for Drawable Res
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputItem(
    value: String,
    onChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    leadingIconRes: Int? = null, // Changed to Int for Drawable Res ID
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    readonly : Boolean = false,
) {
    OutlinedTextField(
        readOnly = readonly,
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        label = { Text(text = labelText) },
        placeholder = { Text(text = "Enter $labelText") },
        leadingIcon = leadingIconRes?.let {
            {
                Icon(
                    painter = painterResource(id = it), // Using painterResource for Drawable
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        // Modern look with Rounded Corners
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
        ),
        // Handle password dots
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true
    )
}