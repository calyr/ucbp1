package com.calyrsoft.ucbp1

import androidx.compose.ui.graphics.vector.ImageVector
import com.calyrsoft.ucbp1.vectorucb.Android
import com.calyrsoft.ucbp1.vectorucb.HouseTop
import kotlin.collections.List as ____KtList

public object VectorUcb

private var __AllIcons: ____KtList<ImageVector>? = null

public val VectorUcb.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf( Android, HouseTop)
    return __AllIcons!!
  }
