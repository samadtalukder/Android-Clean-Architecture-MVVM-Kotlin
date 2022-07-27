# Android-Clean-Architecture-MVVM-Kotlin
## Project Overview

This project aims to demonstrate the usage of Android Architecture Components and how this components can be used in an application with a MVVM architecture in Kotlin 

## Let's explore Architecture Components  
According to [Android Documentation](https://developer.android.com/topic/libraries/architecture), Architecture Components are a set of Android libraries for structuring your app in a way that is robust, testable, and maintainable

## Why MVVM :

- ViewModel has Built in LifeCycleOwerness.
- ViewModel doesn't have a reference for View.
- ViewModel survive configuration changes (Saving and restoring the UI state).

## MVVM Best Pratice:

- Avoid references to Views in ViewModels.
- Instead of pushing data to the UI, let the UI observe changes to it.
- Distribute responsibilities, add a domain layer if needed.
- Add a data repository as the single-point entry to your data.
- Expose information about the state of your data using a wrapper or another LiveData.
- Consider edge cases, leaks and how long-running operations can affect the instances in your architecture.
- Don’t put logic in the ViewModel that is critical to saving clean state or related to data. Any call you make from a ViewModel can be the last one.

## LiveData:
- Yes , liveData is easy , powerful , but you should know how to use.
- For livedate which will emit data stream , it has to be in your data layer , and don't inform those observables any thing else like in which thread those will consume , cause it is another
- For livedata which will emit UI binding events, it has to be in your ViewModel Layer.

## Coroutines: 
It is light wight threads for asynchronous programming, Coroutines not only open the doors to asynchronous programming, but also provide a wealth of other possibilities such as concurrency, actors, etc.

## Coroutines benefits:

- Writing an asynchronous code is sequential manner.
- Costing of create coroutines are much cheaper to crate threads.
- Don't be over engineered to use observable pattern, when no need to use it.
- Parent coroutine can automatically manage the life cycle of its child coroutines for you.

### Refrences: ###
- [ِAndroid Documentation](https://developer.android.com/topic/libraries/architecture)
- [source code for the official Google I/O 2018 for Android app](https://android-developers.googleblog.com/2018/08/google-releases-source-for-google-io.html)
- [Architecture Components Code Lab](https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html?index=..%2F..%2Findex#0)



