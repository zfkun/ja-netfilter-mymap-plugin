# plugin-mymap

A plugin for the [ja-netfilter](https://github.com/ja-netfilter/ja-netfilter), it can replace strings dynamically.

Use the `mvn clean package` command to compile and use `mymap-v1.1.1-jar-with-dependencies.jar` file!

> if you use `ja-netfilter v1.2.0`, you need `mymap-v1.0.1-jar-with-dependencies.jar` fallback  

## Notice

This is just a version for myself use

This project base on decompiling from **jetbra.in**, thanks ~

## Config file

```
[MyMap]
EQUAL,licenseeName->xxxxxxx
EQUAL,gracePeriodDays->30
EQUAL,paidUpTo->5000-12-31
```