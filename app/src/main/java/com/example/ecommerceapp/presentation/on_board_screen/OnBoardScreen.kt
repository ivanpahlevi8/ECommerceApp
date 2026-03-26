package com.example.ecommerceapp.presentation.on_board_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.ecommerceapp.presentation.on_board_screen.component.OnBoardItem
import kotlinx.coroutines.launch

@Composable
fun OnBoardScreen(
    onEvent : (OnBoardScreenEvent) -> Unit
){
    // create state of pager
    val pagerState = rememberPagerState(initialPage = 0) { onBoardItemList.size }

    // create coroutine scope
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        state = pagerState
    ) {
        index : Int ->
        // get on board data ite
        val getOnBoard : OnBoardItemModel = onBoardItemList[index]

        // show on board item
        OnBoardItem(
            image = getOnBoard.imageId,
            title = getOnBoard.title,
            content = getOnBoard.content,
            showNextButton = pagerState.currentPage == 0 || pagerState.currentPage < (onBoardItemList.size - 1),
            showBackButton = pagerState.currentPage > 0,
            showFinishButton = pagerState.currentPage == (onBoardItemList.size - 1),
            onNext = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        page = pagerState.currentPage + 1
                    )
                }
            },
            onBack = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        page = pagerState.currentPage - 1
                    )
                }
            },
            onFinish = {
                onEvent(
                    OnBoardScreenEvent.OnBoardEvent
                )
            }
        )
    }
}