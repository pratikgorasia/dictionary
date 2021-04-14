# Dictionary

## System Requirements
java version 1.7 or higher

## Steps to run program
- Download Dictionary.java file to local
- Open a command prompt window and go to the directory where you saved the java file
- Type 'javac Dictionary.java' and press enter to compile your code.
- Now, type 'java Dictionary' to run your program.

## Commands
### KEYS
Returns all the keys in the dictionary.  Order is not guaranteed.
  
Example
```
> ADD foo bar
) Added
> ADD baz bang
) Added
> KEYS
1) foo
2) baz
```

### MEMBERS
Returns the collection of strings for the given key.  Return order is not guaranteed.  Returns an error if the key does not exists.
  
Example:
```
> ADD foo bar
> ADD foo baz
> MEMBERS foo
1) bar
2) baz

> MEMBERS bad
) ERROR, key does not exist.
```

### ADD
Add a member to a collection for a given key. Displays an error if the value already existed in the collection. 
  
```  
> ADD foo bar
) Added
> ADD foo baz
) Added
> ADD foo bar
) ERROR, value already exists
```

### REMOVE
Removes a value from a key.  If the last value is removed from the key, they key is removed from the dictionary. If the key or value does not exist, displays an error. 
  
Example:
```
> ADD foo bar
) Added
> ADD foo baz
) Added

> REMOVE foo bar  
) Removed
> REMOVE foo bar  
) ERROR, value does not exist

> KEYS
1) foo

> REMOVE foo baz
) Removed

> KEYS
) empty set

> REMOVE boom
) ERROR, key does not exist
```
  
### REMOVEALL
Removes all value for a key and removes the key from the dictionary. Returns an error if the key does not exist.
  
Example:
```
> ADD foo bar
) Added
> ADD foo baz
) Added
> KEYS
1) foo

> REMOVEALL foo
) Removed

> KEYS
(empty set)

REMOVEALL foo
) ERROR, key does not exist

```

### SIZE
Returns the number of keys in the dictionary

Example:
```
> ADD foo bar
) Added
> ADD foo baz
) Added
> SIZE
> 1
```
### EXPORT
Exports the dictionary to a csv file

### CLEAR
Removes all keys and all values from the dictionary.

Example:
```
> ADD foo bar
) Added
> ADD bang zip
) Added
> KEYS
1) foo
2) bang

> CLEAR
) Cleared

> KEYS
(empty set)

> CLEAR
) Cleared

> KEYS
(empty set)

```

### KEYEXISTS
Returns whether a key exists or not. 
  
Example:
```
> KEYEXISTS foo
) false
> ADD foo bar
) Added
> KEYEXISTS foo
) true
```
  
### VALUEEXISTS
Returns whether a value exists within a key.  Returns false if the key does not exist.
  
Example:
```
> VALUEEXISTS foo bar
) false
> ADD foo bar
) Added
> VALUEEXISTS foo bar
) true
> VALUEEXISTS foo baz
) false
```

### ALLMEMBERS
Returns all the values in the dictionary.  Returns nothing if there are none. Order is not guaranteed.
  
Example:
```
> ALLMEMBERS
(empty set)
> ADD foo bar
) Added
> ADD foo baz
) Added  
> ALLMEMBERS
1) bar
2) baz
> ADD bang bar
) Added
> ADD bang baz
> ALLMEMBERS
1) bar
2) baz
3) bar
4) baz
```

### ITEMS
Returns all keys in the dictionary and all of their values.  Returns nothing if there are none.  Order is not guaranteed.
  
Example:
```
> ITEMS
(empty set)
> ADD foo bar
) Added
> ADD foo baz
) Added  
> ITEMS
1) foo: bar
2) foo: baz
> ADD bang bar
) Added
> ADD bang baz
> ITEMS
1) foo: bar
2) foo: baz
3) bang: bar
4) bang: baz
```  

### HELP
Returns the list of commands accepted by the program
