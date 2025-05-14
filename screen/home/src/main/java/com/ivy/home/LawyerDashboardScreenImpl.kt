package com.ivy.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivy.design.l0_system.UI
import com.ivy.design.l0_system.style
import com.ivy.wallet.ui.theme.Gradient
import com.ivy.wallet.ui.theme.White

@Composable
fun LawyerDashboardScreenImpl(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp)
                .padding(paddingValues)
        ) {
            HeaderWithBell("Osave ME", "Lawyer • MBA • Lagos, Nigeria")
            Spacer(Modifier.height(24.dp))
            CardSection("Client Requests") {
                Text("No new requests", color = Color.Gray)
            }
            Spacer(Modifier.height(16.dp))
            CardSection("Upcoming Appointments") {
                Text("Zoom Meeting", style = MaterialTheme.typography.bodyMedium)
                Text("May 16, 2024 at 2:00 PM", fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(Modifier.height(16.dp))
            RemindersSection()
            Spacer(Modifier.height(16.dp))
            DraftsSection()
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDFF1E5))
            ) {
                Text(text = "List A distress Asset", color = Color.Black)
            }
        }
    }

}

@Composable
fun HeaderWithBell(name: String, titleLocation: String, modifier: Modifier = Modifier) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(name, style = MaterialTheme.typography.titleLarge)
            Text(titleLocation, color = Color.Gray)
        }
        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.Gray)
    }
}

@Composable
fun CardSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9FAFB), RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
    ) {
        Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        content()
    }
}

@Composable
fun RemindersSection(
    modifier: Modifier = Modifier
) {
    CardSection("Reminders") {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.CalendarToday, contentDescription = null, tint = Color(0xFF305C4D))
            Spacer(Modifier.width(8.dp))
            Column {
                Text("Anual Return Filing", style = MaterialTheme.typography.bodyMedium)
                Text("Due for Review", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun DraftsSection(
    modifier: Modifier = Modifier
) {
    CardSection("Drafts") {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Icon(Icons.Default.Description, contentDescription = null, tint = Color(0xFF305C4D))
            Spacer(Modifier.width(8.dp))
            Text("Will", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { /* TODO: Upload Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDFF1E5)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Upload Legal Document", color = Color.Black)
        }
    }
}


@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(true) }
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Daniels Ayomikun", style = MaterialTheme.typography.titleLarge)
            Text("Corporate Lawyer", color = Color.Gray)
            Text("Lagos, NG", color = Color.Gray)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Switch(checked = checked, onCheckedChange = { checked = it }) // Available toggle
            Text("Available for\nconsultation", textAlign = TextAlign.Center, fontSize = 12.sp)
        }
    }
}

@Composable
fun ClientRequestsSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text("Client Requests", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Text(
                "Business wants help filing annual return",
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun DocumentAndConsultationSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Document Center", textAlign = TextAlign.Center, fontSize = 24.sp)
            Spacer(Modifier.height(8.dp))
            Icon(Icons.Default.Folder, contentDescription = "Document", tint = Color(0xFF305C4D))
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Scheduled\nConsultations", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(8.dp))
            Text("Adebayo,—", fontSize = 12.sp)
            Text("May 8, 2024", fontSize = 12.sp)
            Spacer(Modifier.height(8.dp))
            Icon(Icons.Default.Videocam, contentDescription = null)
        }
    }
}

@Composable
fun BankruptcySection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Bankruptcy Opportunities", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .background(Color(0xFF305C4D), RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text("PREMIUM", color = Color.White, fontSize = 10.sp)
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.BusinessCenter, contentDescription = null, tint = Color(0xFF305C4D))
            Spacer(Modifier.width(8.dp))
            Text("Buyout distressed company")
        }
    }
}

@Composable
fun BottomActionBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomAction(icon = Icons.Default.Description, label = "Draft Legal Docs")
        BottomAction(icon = Icons.Default.Event, label = "Schedule Consult")
        BottomAction(icon = Icons.Default.Shield, label = "File for Client")
        BottomAction(icon = Icons.Default.AttachMoney, label = "View Earnings")
    }
}

@Composable
fun BottomAction(icon: ImageVector, label: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = label,
            tint = Color(0xFF305C4D),
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier
) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.AccountBalanceWallet, contentDescription = "Goals") },
            label = { Text("Goals") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Receipt, contentDescription = "Transactions") },
            label = { Text("Transactions") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Insights, contentDescription = "Insights") },
            label = { Text("Insights") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.MoreHoriz, contentDescription = "More") },
            label = { Text("More") }
        )
    }
}

//Investor
@Composable
fun InvestorDashboardScreenImpl(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp)
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            GreetingHeader("David")
            PortfolioAmountSection("$50,250", "April 17")
            Spacer(Modifier.height(24.dp))
            SlideCarousel(modifier = Modifier.fillMaxWidth().height(200.dp))

            Spacer(Modifier.height(24.dp))
            ActionButtonsSection()
            Spacer(Modifier.height(24.dp))
            WriteWillSection()

        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SlideCarousel(
    modifier: Modifier = Modifier
) {
    // We will have two slides
    val pageCount = 3
    // Create the state to control the current page
    val pagerState = rememberPagerState(pageCount = {pageCount})



    Column(modifier = modifier) {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->

            when (page) {
                0 -> FundedSection()
                1 -> SlideContentImpl(
                    text = "Wealth is the measure of cashflow from the asset column compared with the expense column.",
                    backgroundColor = Gradient(UI.colors.pureInverse, UI.colors.gray)
                )

            }
        }
    }
}

@Composable
private fun SlideContentImpl(
    text: String,
    backgroundColor: Gradient,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = backgroundColor.asHorizontalBrush(),
                shape = UI.shapes.r3
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
            style = UI.typo.c.style(
                color = White,
                fontWeight = FontWeight.ExtraBold,
            )
        )
    }
}

@Composable
fun GreetingHeader(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello, $name",
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun PortfolioAmountSection(amount: String, date: String, modifier: Modifier = Modifier) {
    Column {
        Text("Total Portfolio", style = MaterialTheme.typography.titleMedium)
        Text(
            text = amount,
            color = Color(0xFF1C6B4D),
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text("Last updated: $date", color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun FundedSection(
    modifier: Modifier = Modifier
) {
    Column {
        Text("Funded", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.BusinessCenter,
                    contentDescription = null,
                    tint = Color(0xFF1C6B4D),
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFE3F4EB), CircleShape)
                        .padding(8.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Green Energy Inc.", fontWeight = FontWeight.Bold)
                    Text("$10,000", color = Color.Black)
                    Text("Investment Date: Mar 24", color = Color.Gray, fontSize = 12.sp)
                }
                Button(
                    onClick = { /* Handle details */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C6B4D))
                ) {
                    Text("View Details", color = Color.White)
                }
            }
        }

        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun ActionButtonsSection(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        ActionButton("FUND")
        ActionButton("GIVE GRANT")
        ActionButton("DONATE")
    }
}

@Composable
fun ActionButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* TODO */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C6B4D)),
        modifier = Modifier
    ) {
        Text(text, color = Color.White)
    }
}

@Composable
fun WriteWillSection(
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = { /* TODO */ },
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0xFF1C6B4D)),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1C6B4D))
    ) {
        Icon(
            imageVector = Icons.Default.EditNote,
            contentDescription = null,
            tint = Color(0xFF1C6B4D)
        )
        Spacer(Modifier.width(8.dp))
        Text("Write or Review My Will")
    }
}