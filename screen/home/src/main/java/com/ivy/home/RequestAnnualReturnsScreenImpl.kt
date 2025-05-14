package com.ivy.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivy.navigation.navigation

@Composable
fun RequestAnnualReturnsScreenImpl(
    modifier: Modifier = Modifier,
) {

    var businessRegNumber by remember { mutableStateOf("") }
    var businessName by remember { mutableStateOf("") }
    var businessNature by remember { mutableStateOf("") }
    var registeredAddress by remember { mutableStateOf("") }
    var branchAddress by remember { mutableStateOf("") }
    var proprietorInfo by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }


    val nav = navigation()

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = nav::back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = stringResource(com.ivy.ui.R.string.osave_me),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF008000)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Request Annual Returns Filing",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(16.dp))


            Column {
                Text(
                    text = "Business registration number"
                )
                OutlinedTextField(
                    value = businessRegNumber,
                    onValueChange = { businessRegNumber = it },
                    label = { Text(text = "Business registration number") },
                    modifier = Modifier.fillMaxWidth()
                )

            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "Business name"
                )
                OutlinedTextField(
                    value = businessName,
                    onValueChange = { businessName = it },
                    label = { Text(text = "Business name") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "General nature of your business"
                )
                OutlinedTextField(
                    value = businessNature,
                    onValueChange = { businessNature = it },
                    label = { Text(text = "General nature of your business") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "The registered address of your business"
                )
                OutlinedTextField(
                    value = registeredAddress,
                    onValueChange = { registeredAddress = it },
                    label = { Text(text = "Registered Address of Your Business") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "Branch address (if any) of your business"
                )
                OutlinedTextField(
                    value = branchAddress,
                    onValueChange = { branchAddress = it },
                    label = { Text(text = "Branch address (if any) of your business") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "Information about the proprietor and partners of the business"
                )
                OutlinedTextField(
                    value = proprietorInfo,
                    onValueChange = { proprietorInfo = it },
                    label = { Text(text = "Proprietor and Partners Information") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "Year annual return relates to"
                )
                OutlinedTextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text(text = "Year Annual Return Relates To") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008000)
                ),
                shape = RoundedCornerShape(25)
            ) {
                Text(text = "Get quotation")
            }
        }
    }

}