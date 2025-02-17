package com.divingseagull.emergencyseagulladmin.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divingseagull.emergencyseagulladmin.R
import com.divingseagull.emergencyseagulladmin.ui.theme.pretendard

val busanDistricts = listOf(
    "중구",
    "서구",
    "동구",
    "영도구",
    "부산진구",
    "동래구",
    "남구",
    "북구",
    "해운대구",
    "사하구",
    "금정구",
    "강서구",
    "연제구",
    "수영구",
    "사상구",
    "기장군"
)

val classificationMap = mapOf(
    "FIRE" to "화재 신고",
    "RESCUE" to "구조 신고",
    "MEDICAL" to "구급 신고",
    "SAFETY" to "생활안전 신고"
)

@Composable
fun Topbar(district: String, onClick: () -> Unit) {
    Spacer(modifier = Modifier.height(50.dp))
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 15.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .border(
                    width = 1.5.dp,
                    color = Color(0xFFE2E4EC),
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .padding(0.75.dp)
                .weight(1f)
                .height(48.dp)
                .background(color = Color(0xFFFAFAFB), shape = RoundedCornerShape(size = 12.dp))
                .padding(start = 20.dp, top = 6.dp, end = 16.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = district,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF686D78),
                ),
                modifier = Modifier.weight(1f)
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.btn_downward_arrow),
                contentDescription = "dropdown",
                modifier = Modifier.clickable {
                    onClick()
                }
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_bell),
            contentDescription = "notification",
            modifier = Modifier.clickable {

            }
        )
    }
}

@Composable
fun ClassificationTab(
    mModifier: Modifier,
    heightValue: Dp = 157.dp,
    icon: Int = R.drawable.ic_fireextinguisher,
    title: String = "Test",
    description: String = "Test",
    onClick: () -> Unit
) {
    Box(
        modifier = mModifier
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(size = 14.dp),
                spotColor = Color(0x0F000000),
                ambientColor = Color(0x0F000000)
            )
            .clip(RoundedCornerShape(size = 14.dp))
            .height(heightValue)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 14.dp))
            .padding(
                start = 16.dp,
                top = if (icon != 0) 20.dp else 0.dp,
                end = 16.dp,
                bottom = if (icon != 0) 20.dp else 0.dp
            )
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (icon != 0) Arrangement.Bottom else Arrangement.Center
        ) {
            if (icon != 0) {
                Image(
                    imageVector = ImageVector.vectorResource(id = icon),
                    contentDescription = "fireExtinguisher",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF323439),
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF858C9A),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistrictBottomSheet(
    onIsClicked: () -> Unit,
    onClick: (String) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { onIsClicked() },
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        containerColor = Color.White,
        dragHandle = {
            Box(
                Modifier
                    .padding(top = 8.dp, bottom = 11.dp)
                    .width(48.dp)
                    .height(5.dp)
                    .background(
                        color = Color(0xFFE2E4EC),
                        shape = RoundedCornerShape(size = 12.dp)
                    )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                busanDistricts.forEach { district ->
                    Text(
                        text = district,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = pretendard,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF323439),
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 10.dp)
                            .clickable {
                                onClick(district)
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun ReportBox(
    specification: String,
    location: String,
    description: String
) {
    var isVisible by remember { mutableStateOf(true) }
    var isButtonVisible by remember { mutableStateOf(false) }
    if (isVisible) {
        Column(
            modifier = Modifier
                .shadow(
                    elevation = 18.dp,
                    shape = RoundedCornerShape(size = 14.dp),
                    spotColor = Color(0x0F000000),
                    ambientColor = Color(0x0F000000)
                )
                .clip(RoundedCornerShape(size = 14.dp))
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 14.dp)
                )
                .padding(start = 26.dp, top = 24.dp, end = 26.dp, bottom = 24.dp)
                .clickable {
                    isButtonVisible = !isButtonVisible
                }
        ) {
            Text(
                text = specification,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFD51713),
                ),
                modifier = Modifier.padding(bottom = 6.dp)
            )
            Text(
                text = location,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF858C9A),
                    textAlign = TextAlign.Center,
                )
            )
            Box(
                modifier = Modifier
                    .padding(vertical = 14.dp)
                    .width(290.dp)
                    .height(1.dp)
                    .background(color = Color(0xFFF3F4F8))
            )
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF686D78),
                ),
                modifier = Modifier.padding(bottom = 14.dp)
            )
            CommonButton(
                text = "수락하기",
                buttonColor = Color(0xFFD51713),
                textColor = Color.White,
                onClick = { isVisible = false }
            )
        }
    }
}