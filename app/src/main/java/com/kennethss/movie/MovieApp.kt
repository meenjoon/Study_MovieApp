package com.kennethss.movie

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//hilt로 di를 시작하기 위해서 필수로 해줘야함
@HiltAndroidApp
class MovieApp : Application()
