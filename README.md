# JetPackPunkApp


This app displays the data form Punk API an openSource api that displays the list of beers [:beers:]

# Description

My main object was to brush my skills on the jetpack library of androidx which are the recommended architecture pattern by google and most of the companies around the world . This app uses the MVVM [Architectual Pattern] , LiveData, Databinding , Navigation, Offline Mode[ inside setting `loadfromcache`]  and other proven therad safe approach to access the objects. The language used to code is kotline[kotlin_version = "1.3.72"] and many more.


![Overview of app](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)



I have tried to code something close to the above image where the class Name Repository[Named the same way] holds the object of Room and Retrofit in a thread safe way and performs the related operations.



# Technical Spec:

```Kotlin
kotlin_version = "1.3.72"
lifeCycleExtensionVersion = '1.1.1'
supportVersion = '28.0.0'
retrofitVersion = '2.9.0'
glideVersion = '4.9.0'
rxJavaVersion = '2.1.1'
roomVersion = '2.2.6'
navVersion = '2.3.5'
preferencesVersion = '1.1.1'
```




## Demo :



<img src="https://user-images.githubusercontent.com/18009630/116792737-d347af80-aac2-11eb-954b-bb2fc97adffd.gif" alt="demo" style="zoom:25%;" />
