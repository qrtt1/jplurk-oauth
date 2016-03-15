JPlurk-OAuth is the Plurk API implementation for Plurk API 2.0.

## Installation

In gradle build script, add the following repositories and the dependencies of the jplurk-oauth

```groovy
repositories {
    jcenter()
    maven {
        url  "http://dl.bintray.com/qrtt1/jplurk-maven"
    }
}

dependencies {
    compile 'com.google.jplurk:jplurk-oauth:2.0.11'
}
```
