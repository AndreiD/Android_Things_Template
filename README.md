Android Things Template
==========================

## This is start-template to save you a little time. RxJava Ready
## Works with Raspberry Pi 3, Intel® Edison, NXP Pico i.MX6UL, Intel® Joule™ 570x, NXP Argon i.MX6UL

![alt text](https://github.com/AndreiD/Android_Things_Template/blob/master/other/preview.gif "How the board looks")

#### What it does:

Blinks a led... it's a template app.

Tip #1: Enter in a terminal: "adb connect ip_of_the_board"

Tip #2: you can run the app after you disconnect from the computer like this

~~~~
$adb shell
rpi3:/ $ am start -n com.androidadvance.thingstest/.MainActivity
Starting: Intent { cmp=com.androidadvance.thingstest/.MainActivity }
rpi3:/ $
~~~~
#### How to use it:

CREATE a file caled locale.properties and in it put the location of the android sdk
ex: sdk.dir=C:\\Users\\admin\\AppData\\Local\\Android\\Sdk

Step 1:

* Create a new blank android project or clone this repo. Add a local.properties with your sdk location.
* Manual mode: Download the zip file for this project.
* Copy paste the app folder
* Copy paste the build.gradle and modify applicationId "com.androidadvance.androidthingsultimatetemplate" to your package name
* Check the compileSdkVersion, and buildToolsVersion to be the latest

##### Attention

* Connect to your board with: "adb connect board_ip"

* IMPORTANT: Remove the libs that you don't need. Add those that you do. Profit!
* Star this repository

Step 2: ???
Step 3: Profit

#### Need more nice stuff ?

- Google, Facebook, Twitter logins -> https://github.com/AndreiD/FacebookTwitterGoogleLogins
- A survey lib for your app -> https://github.com/AndreiD/surveylib

#### Updates, Questions, and Requests

Ping me here :)


#### You like this project ? Check
- https://github.com/AndreiD/SimpleChat - Simple Realtime Room Chat in Android.
- https://github.com/AndreiD/surveylib - A very good looking survey library
- https://github.com/AndreiD/TSnackBar Snackbar from the top


#### License

~~~~
Copyright 2015 AndroidAdvance.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~~
