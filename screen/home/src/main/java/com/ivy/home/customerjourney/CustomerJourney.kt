package com.ivy.home.customerjourney

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivy.design.l0_system.UI
import com.ivy.design.l0_system.style
import com.ivy.domain.RootScreen
import com.ivy.legacy.ivyWalletCtx
import com.ivy.legacy.rootScreen
import com.ivy.legacy.utils.drawColoredShadow
import com.ivy.navigation.IvyPreview
import com.ivy.navigation.navigation
import com.ivy.ui.R
import com.ivy.wallet.ui.theme.Gradient
import com.ivy.wallet.ui.theme.GradientGreen
import com.ivy.wallet.ui.theme.White
import com.ivy.wallet.ui.theme.components.IvyButton
import com.ivy.wallet.ui.theme.components.IvyIcon
import com.ivy.wallet.ui.theme.dynamicContrast
import com.ivy.wallet.ui.theme.findContrastTextColor
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay

@Composable
fun CustomerJourney(
    customerJourneyCards: ImmutableList<CustomerJourneyCardModel>,
    onDismiss: (CustomerJourneyCardModel) -> Unit,
    modifier: Modifier = Modifier,
    onAdClick: () -> Unit
) {
    val ivyContext = ivyWalletCtx()
    val nav = navigation()
    // Check is added for Paparazzi Test where context is different
    if (LocalContext.current is RootScreen) {
        val rootScreen = rootScreen()

        if (customerJourneyCards.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
        }

        TwoSlideCarousel(
            modifier = Modifier.fillMaxWidth().height(196.dp)
        )
        RewardAdSection(
            onAdClick = onAdClick
        )
    } else {
        Box(modifier)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TwoSlideCarousel(
    modifier: Modifier = Modifier
) {
    // We will have two slides
    val pageCount = 2
    // Create the state to control the current page
    val pagerState = rememberPagerState(pageCount = {pageCount})

    // LaunchedEffect is used to manage the page change after a delay
    LaunchedEffect(Unit) {
        while (true) {
            // Wait for 10 seconds
            delay(5000L)
            // Move to the next page, looping back to the first if needed
            val nextPage = (pagerState.currentPage + 1) % pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
            // Our two slide content
            when (page) {
                0 -> SlideContent(
                    text = "Wealth is how much money your money is making.",
                    backgroundColor = GradientGreen
                )
                1 -> SlideContent(
                    text = "Wealth is the measure of cashflow from the asset column compared with the expense column.",
                    backgroundColor = Gradient(UI.colors.pureInverse, UI.colors.gray)
                )
            }
        }
    }
}

@Composable
fun SlideContent(
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
fun RewardAdSection(
    onAdClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onAdClick) {
            Text("Watch Ad to Get +10 Streak")
        }
    }
}



@Composable
fun CustomerJourneyCard(
    cardData: CustomerJourneyCardModel,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    onCTA: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .drawColoredShadow(cardData.background.startColor)
            .background(cardData.background.asHorizontalBrush(), UI.shapes.r3)
            .clip(UI.shapes.r3)
            .clickable {
                onCTA()
            }
    ) {
        Spacer(Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 16.dp),
                text = cardData.title,
                style = UI.typo.b1.style(
                    fontWeight = FontWeight.ExtraBold,
                    color = findContrastTextColor(cardData.background.startColor)
                )
            )

            if (cardData.hasDismiss) {
                IvyIcon(
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                        }
                        .padding(8.dp), // enlarge click area
                    icon = R.drawable.ic_dismiss,
                    tint = cardData.background.startColor.dynamicContrast(),
                    contentDescription = "prompt_dismiss",
                )

                Spacer(Modifier.width(20.dp))
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 32.dp),
            text = cardData.description,
            style = UI.typo.b2.style(
                fontWeight = FontWeight.Medium,
                color = findContrastTextColor(cardData.background.startColor)
            )
        )

        Spacer(Modifier.height(32.dp))

        if (cardData.cta != null) {
            IvyButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 20.dp)
                    .testTag("cta_prompt_${cardData.id}"),
                text = cardData.cta,
                shadowAlpha = 0f,
                iconStart = cardData.ctaIcon,
                iconTint = cardData.background.startColor,
                textStyle = UI.typo.b2.style(
                    color = cardData.background.startColor,
                    fontWeight = FontWeight.Bold
                ),
                padding = 8.dp,
                backgroundGradient = Gradient.solid(findContrastTextColor(cardData.background.startColor))
            ) {
                onCTA()
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewCard() {
    IvyPreview {
        CustomerJourneyCard(
            cardData = CustomerJourneyCardsProvider.adjustBalanceCard(),
            onCTA = { },
            onDismiss = {}
        )
    }
}
