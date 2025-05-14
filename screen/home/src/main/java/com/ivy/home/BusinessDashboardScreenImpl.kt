package com.ivy.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessDashboardScreenImpl(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .padding(it)
        ) {
            Text(
                text = stringResource(com.ivy.ui.R.string.osave_me),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF008000),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Business Dashboard",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "(Premium User)",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(
                onClick = { /* TODO: Upload previous records */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25)
            ) {
                Icon(
                    imageVector = Icons.Default.FileUpload,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Upload Previous Records",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Upload past records in Excel format",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W300
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Record Daily Income & Expenses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Today, May 1, 2024",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight(450)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Enter income amount") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter expense amount") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LinearProgressIndicator(
                progress = { 55f / 75f },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF008000)
            )
            Text(
                text = "75-day streak - 55 days",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* TODO: Request filing */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008000)
                ),
                shape = RoundedCornerShape(25)
            ) {
                Text(
                    text = "Request Annual Returns Filing",
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Request business funding */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008000)
                ),
                shape = RoundedCornerShape(25)
            ) {
                Text(
                    text = "Request Business Funding",
                    fontSize = 18.sp
                )
            }
        }
    }

}