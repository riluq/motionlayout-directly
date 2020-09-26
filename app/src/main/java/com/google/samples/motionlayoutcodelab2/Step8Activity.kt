/*
 *   Copyright (C) 2019 The Android Open Source Project
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.google.samples.motionlayoutcodelab2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_step8.*

class Step8Activity : AppCompatActivity() {

    private val TAG = "Step8Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step8)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        // TODO: set progress of MotionLayout based on an AppBarLayout.OnOffsetChangedListener
        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motion_layout.progress = seekPosition
            Log.d(TAG, "seekPosition : $seekPosition")
            Log.d(TAG, "verticalOffset : $verticalOffset")
            Log.d(TAG, "totalScrollRange : ${appBarLayout.totalScrollRange.toFloat()}")
        }

        appbar_layout.addOnOffsetChangedListener(listener)

    }
}
