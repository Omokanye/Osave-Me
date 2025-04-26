package com.ivy.disclaimer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.ivy.data.repository.LegalRepository
import com.ivy.navigation.Navigation
import com.ivy.ui.ComposeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisclaimerViewModel @Inject constructor(
    private val navigation: Navigation,
    private val legalRepo: LegalRepository,
) : ComposeViewModel<DisclaimerViewState, DisclaimerViewEvent>() {

    private var checkboxes by mutableStateOf(LegalCheckboxes)

    @Composable
    override fun uiState(): DisclaimerViewState {
        return DisclaimerViewState(
            checkboxes = checkboxes,
            agreeButtonEnabled = checkboxes.all(CheckboxViewState::checked),
        )
    }

    override fun onEvent(event: DisclaimerViewEvent) {
        when (event) {
            DisclaimerViewEvent.OnAgreeClick -> handleAgreeClick()
            is DisclaimerViewEvent.OnCheckboxClick -> handleCheckboxClick(event)
        }
    }

    private fun handleAgreeClick() {
        viewModelScope.launch {
            legalRepo.setDisclaimerAccepted(accepted = true)
            navigation.back()
        }
    }

    private fun handleCheckboxClick(event: DisclaimerViewEvent.OnCheckboxClick) {
        checkboxes = checkboxes.mapIndexed { index, item ->
            if (index == event.index) {
                item.copy(
                    checked = !item.checked
                )
            } else {
                item
            }
        }.toImmutableList()
    }

    companion object {
        // LEGAL text - do NOT extract or translate
        val LegalCheckboxes = listOf(
            CheckboxViewState(
                text = "Osave Me is a record-keeping and networking platform, " +
                        "not a financial institution or investment advisor. We do " +
                        "not guarantee the accuracy, completeness, or reliability of " +
                        "any financial data, investment opportunities, or transactions " +
                        "conducted through our platform. Users acknowledge that all " +
                        "decisions are made at their own risk, and Osave Me bears no " +
                        "responsibility for any losses incurred.",
                checked = false,
            ),
            CheckboxViewState(
                text = "Osave Me does not verify, endorse, or manage any investments or " +
                        "financial transactions made through the platform. Users must conduct " +
                        "their own independent research (DYOR) before engaging in any investment " +
                        "or business transaction. By using this platform, you accept full responsibility " +
                        "for your financial decisions.",
                checked = false
            ),
            CheckboxViewState(
                text = " Osave Me does not provide legal, financial, or investment advice. " +
                        "Any information provided on the platform is for general informational purposes " +
                        "only and should not be considered financial guidance.",
                checked = false,
            ),
            CheckboxViewState(
                text = "By using this platform, you waive any legal claims against Osave Me, its developers, " +
                        "partners, contributors, and affiliated entities for any losses, fraud, " +
                        "misrepresentations, or damages resulting from platform use. Osave Me is not responsible " +
                        "for security breaches, fraudulent schemes, or third-party interactions.",
                checked = false,
            ),
            CheckboxViewState(
                text = "Investing and business networking involve risks, including the potential loss of money. " +
                        "Osave Me does not hold or manage funds, nor does it guarantee the legitimacy of " +
                        "investors or business owners. Users should take extra precautions before committing " +
                        "financially.",
                checked = false,
            ),
            CheckboxViewState(
                text = "Osave Me does not offer refunds or facilitate dispute resolution between users. Users " +
                        "engage in transactions at their own discretion and must handle conflicts independently.",
                checked = false,
            ),
            CheckboxViewState(
                text = "By clicking \"I Agree,\" you confirm that you have read, understood, and accepted this agreement, releasing " +
                        "Osave Me from any liability related to your use of the platform.",
                checked = false
            )

        ).toImmutableList()
    }
}