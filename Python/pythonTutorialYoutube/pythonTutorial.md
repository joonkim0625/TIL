# Learning Python

Taking notes as I go over the youtube video.

The materials -> [Programming with Mosh](https://www.youtube.com/watch?v=_uQrJ0TkZlc&t=211s)

---

## Defining a variable

```py
# try to print 10 on the terminal

# price(identifier) = value(10)
price = 10 
print(10)

# print('10') will print a text '10', not the variable price
```

When we store number 10 in the computer's memory, first it get coverted to it's binary representation which consists of 0s and 1s. Then it will get stored in the computer's memory. 

We can also define numbers with decimal points. In programming, we refer to this kind of number a floating point number or float.

```py
# an example of a floating number
rating = 4.9
```

Setting a string value 

```py
name = 'Joon'
```

Boolean

```py
# True or False
is_published = True 
```

**NOTE** : Python is a case sensitive language. So when defining variables, we should always use lowercase letters, but false and true are speical keywords in the language, we must use uppercase letters to start with these special words.

---

## Activity - 18:00 ~

**Difference between 'input' and 'print'**
  - both are functions that are built in Python.
  - These are functions for commom tasks such as printing messages, receiving input and so on.
  - There are many other built-in functions in Python.

### Using 'input' to ask a name and print the input in the terminal:

```py
name = input("What is your name? ")
print("Hi, " + name)
```

### Asking for a name and a favorite color to print in the terminal:

```py
name = input("What is your name? ")
favorite_color = input("What is your favorite color? ")

print(name + " likes " + favorite_color)
```

---

## Different types when defining a variable

Let's write a code that calculates someone's age.

```py
birth_year = input("Birth year: ")
# let's say a user gives an input of 1989
age = 2019 - birth_year

print(age)
```

If we run the code above, it will throw a type error that says `TypeError: unsupported operand type(s) for -: 'int' and 'str'`. This is because the input we got, although numbers were typed into input, is a string. Python cannot execute a calculation between numbers and strings.

At run time, which means when we run our program, the expression(line2) on the right side of the assignment operator is going to look like `2019 - '1989'`. What we need to is to convert 1989 to an integer.

All we have to do is:

```py
birth_year = input("Birth year: ")
# use int() function to convert a string value to an integer value
age = 2019 - int(birth_year)

print(age)
```

### How to get a type of a variable

```py
birth_year = input("Birth year: ")
print(type(birth_year)) # <class 'str'>
age = 2019 - int(birth_year)
print(type(age)) # <class 'int'>

print(age)
```

---

## Strings

In Python, you can define a string that spans multiple lines. 

```py
# using ''' ...  '''
course = """ 
Hi John,

Here is our first email to you.

Thank you!
"""
print(course)
```

Also, the strings are indexed and you can use the index numbers to select a specific string from a value.

```py
course = "Python for Beginners"

print(course[0])  # this prints P
print(course[1])  # this prints y
```

Python does have negative index:

```py
course = "Python for Beginners"

print(course[-1])  # this prints s
print(course[-2])  # this prints r 
```

If you want only a part of a string value, you could do:

```py
course = "Python for Beginners"

print(course[0:3])  # this prints Pyt. The last index number will not be printed.
```






