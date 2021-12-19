# plugin-mymap

### A plugin for the [ja-netfilter](https://github.com/ja-netfilter/ja-netfilter), it can replace strings dynamically.

#### Use the `mvn clean package` command to compile and use `mymap-v1.0.1-jar-with-dependencies.jar` file!

## Config file

```
[MyMap]
EQUAL,licenseeName->xxxxxxx
EQUAL,gracePeriodDays->30
EQUAL,paidUpTo->5000-12-31

# EQUAL       Use `equals` to compare
# EQUAL_IC    Use `equals` to compare, ignore case
# KEYWORD     Use `contains` to compare
# KEYWORD_IC  Use `contains` to compare, ignore case
# PREFIX      Use `startsWith` to compare
# PREFIX_IC   Use `startsWith` to compare, ignore case
# SUFFIX      Use `endsWith` to compare
# SUFFIX_IC   Use `endsWith` to compare, ignore case
# REGEXP      Use regular expressions to matchh
```