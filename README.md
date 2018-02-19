# Base Android app
This is the app that should be use in every new project:

This app uses:

- Kotlin <3
- BuildVariants
- Data binding
- Contraint Layouts
- Lifecycle architecture components library
- MVVM architecture for presentation layer
- RxJava2 
- Networking: Retrofit with RxJava2
- Dagger2
- Image Loading: Glide
- Logs: Timber

**To make your own project from this one, you should do:**

- rename base package to your own: me.fleka.base to me.hipotekarna.presto
- in app gradle ( inner build gradle, not the project one) you should rename applicationID
- in app gradle ( inner build gradle, not the project one) you should rename prefixes for different build variants 