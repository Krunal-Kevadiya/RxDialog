[![API](https://img.shields.io/badge/API-16%2B-red.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![Build Status](https://travis-ci.org/wupdigital/android-maven-publish.svg?branch=master)](https://github.com/Krunal-Kevadiya/RxDialog)
[ ![Download](https://api.bintray.com/packages/kevadiyakrunalk/MyFramework/rxdialog/images/download.svg) ](https://bintray.com/kevadiyakrunalk/MyFramework/rxdialog/_latestVersion) 
[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](https://opensource.org/licenses/Apache-2.0)

# RxDialog

* i have create two type of dialog 1.Prompt and 2.Alert dialog.
* Prompt dialog use for message display purpose with type(INFO, HELP, ERROR/WRONG, SUCCESS, WARNING).
* Alert dialog use for message or customise.
* Code :-

```java
//- Prompt Dialog
    new RxPromptDialog
         .Builder(this)
         .title(R.string.dialog_title) //for dialog title 
         .message(R.string.dialog_message) //for user mnessage
         .cancellable(Boolean.TRUE)
         .type(DialogType.INFO) //type of prompt to given user INFO, SUCCESS, WRONG/FAIL, HELP etc.
         .canceledOnTouchOutside(Boolean.FALSE)
         
          // set dialog button, use Either singleButton or doubleButton
         .singleButton(R.string.dialog_cancel)
         .doubleButton(context.getString(R.string.dialog_ok), context.getString(R.string.dialog_cancel))
         
         // set animation default or custom, use Either setDefaultAnimation or setInAnimation & setOutAnimation
         .setDefaultAnimation(true)
         .setInAnimation(animIn)
         .setOutAnimation(animOut)
         
         .toObservable()
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(new Action1<Integer>() {
             @Override
             public void call(Integer which) {
                 Log.e("Alert", "Which->" + which); 
                 // Button id return for 
                 // two button  - POSITIVE = -1, NEGATIVE = -2
                 // one button  - NEUTRAL = -3
                 // dialog cancel - CANCEL = -4
                 // dialog dismiss - DISMISS = -5
             }
             }
         });
         
//- Alert Dialog
    new RxAlertDialog
          .Builder(this)
          .title(R.string.dialog_title)
          .message(R.string.dialog_message) // for user message
          .image(R.drawable.sample_img) //[optional] with image
          .view(R.layout.custom_dialog) //[optional] set custom view 
          .cancellable(Boolean.FALSE)
          .canceledOnTouchOutside(Boolean.FALSE)
          
          // set dialog button, use Either singleButton or doubleButton
          .singleButton(R.string.dialog_cancel)
          .doubleButton(context.getString(R.string.dialog_ok), context.getString(R.string.dialog_cancel))
          
          // set animation default or custom, use Either setDefaultAnimation or setInAnimation & setOutAnimation
          .setDefaultAnimation(true)
          .setInAnimation(animIn)
          .setOutAnimation(animOut)
         
          .toObservable()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer which) {
                  Log.e("Alert", "Which->" + which);
              }
          })          
//- Progress Dialog 
     new RxProgressDialog
           .Builder(this)
           .message("Please Wait…")
           .cancellable(false)
           .toObservable(zipObservable)
           .compose(dialogFragment.<String>bindUntilEvent(FragmentEvent.PAUSE)) //[optional] for bind progress in activity or fragment life cycle.
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Subscriber<String>() {
               @Override
               public void onCompleted() {

               }

               @Override
               public void onError(Throwable e) {
                   Log.e("RESULT", e.toString());
               }

               @Override
               public void onNext(String s) {
                   Log.e("RESULT", s);
               }
           });
```

-> Gradle
```groovy
//Add Dependencies for app level build.gradle
repositories {
    jcenter()
}
dependencies {
  compile 'com.kevadiyakrunalk:rxdialog:1.0@aar'
}
```
-> Maven
```xml
<dependency>
  <groupId>com.kevadiyakrunalk</groupId>
  <artifactId>rxdialog</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
