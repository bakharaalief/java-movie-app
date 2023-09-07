# Java-Movie-App
Indivara Android Developer Technical Test<br>

## Video preview
[youtube](https://youtube.com/shorts/TcQ09SKIw1I?feature=share)

## Feature
- See Now Playing, Popular, and Top Rated movies
- See Detail Movie
- using java language
- support in dark theme mode

## How to run locally ?
Clone project
```
git clone https://github.com/bakharaalief/java-movie-app.git
```
Open this project on your android studio. Wait the configuration and after that you can use this app.

## Project Structure
I use clean architecture for this app and divide the app into several folders
- [data](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/data) - Handle the data from API
- [domain](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/domain) - Handle business logic of this app
- [di](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/di) -  Handle dependency Injection
- [presentation](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/presentation) - Handle view
- [helper](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/Helper) - Handle tools for mapping and utils
- [base](https://github.com/bakharaalief/java-movie-app/tree/main/app/src/main/java/com/bakhdev/java_movie_app/base) - Make easier handle some file

## Dependencies
- [Retrofit & Gson](https://github.com/square/retrofit) - Call API and converter
- [rxJava2](https://github.com/ReactiveX/RxJava) - Reactive programming
- [Glide](https://github.com/bumptech/glide) - Show and caching image from url
- [CircleImageView](https://github.com/hdodenhof/CircleImageView) - Make image in circle shape
- [Dagger Hilt](https://github.com/google/dagger) - Handle dependency Injection
- [Lottie](https://github.com/airbnb/lottie-android) - Animation in splash screen

## Screenshot
<img src="./preview/preview-1.png"/>
