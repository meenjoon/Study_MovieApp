package com.kennethss.movie.domain.movie.di

import javax.inject.Qualifier

/*
@Qualifier라는 어노테이션은 설명에 앞서
hilt에서 Corountine은 외부라이브러리 이기때문에 @Moudle,@InstallIn,@Provides을 이용하여 바인딩하는 함수를 만들어야하는데
문제는 Dispatchers.Default, IO, Main, Main.immediate와 같이 상황에 따라 달라야 하는데 코루틴에서 같은 타입 CoroutineDispatcher를 리턴해버리기 때문에 어떤 필요한 상황에 어떤것을 리턴을 하는것인가를 알 수 없는 것이다.
즉, 각 메서드에서 같은 CoroutineDispatcher를 객체를 호출하고 있다는 것이다.
그래서 해결할 수 있는 방법이 @Qualifier 어노테이션을 이용을 해서 각각의 객체를 분리하는데 이것을 하는 클래스 파일이 이 파일인 것이다.
 */

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApplicationScope
