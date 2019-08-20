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

Doing this will print the whole value of its strings:

```py
course = "Python for Beginners"

print(course[0:]) # this prints Python for Beginners
print(course[1:]) # this prints ython for Beginners

# if we don't provide the start index, then it will assume that the start index is zero.

print(course[:5]) # this prints Pytho
```

So, if we run something like this, what will be the result? :

```py
name = "Jennifer"
print(name[1:-1])
```

The start index `1` points to the letter `e`, and the index of `-1` will be the last letter of a string value which is `r`. But the last index is not included, so the program will print `ennife` which is from the index of `1` to the index of `-1`.

### Formatted string

This is just like using ' `` ' to use variables dynamically in JavaScript.

```py
first = "John"
last = "Smith"

message = first + " [" + last + "] is a coder"

# in order to use the formatted string,
# you can prefix your strings with an F and then use curly braces to use the defined variables.
# this allows you to insert values dynamically into the strings.

msg = f"{first} [{last}] is a coder."

print(msg)
```

There are built-in functions like `len` or `print` which are called `general purpose functions` that they do not belong to other kind of objects, numbers or strings.

```py
course = 'Python for Beginners'

print(len(course)) # 20

# if you want to covert all the letters to uppercase letters:

print(course.upper()) # PYTHON FOR BEGINNERS

```

So, functions like `string.upper()` or `string.lower()` are called `methods`. `method` is a term in object oriented programming that we use when a function belongs to something else, or is specific to some kind of object.

There is a `find` methond for strings.

```py
course = 'Python for Beginners'
print(course.find('o')) # this returns 4

```

This `find` method is not only case sensitive, but it returns the index number of the characters that you are trying to find. Also:

```py
course = 'Python for Beginners'
print(course.find('J')) # this returns -1 since there is no 'J'
print(course.find('Beginners')) # this returns 11 because the word 'beginners' starts with index 11
```

There is a `replace` method to replace a character or a sequence of characters.

```py
course = "Python for Beginners"

print(course.replace("P", "J")) # Jython for Beginners

print(course.replace("Beginners", "Absolute Beginners")) # Python for Absolute Beginners

print(course.replace("beginners", "Absolute Beginners")) # this will print 'Python for Beginners' because there is no match for 'beginners' to replace with
```

There is an operator called `in` to check the existence of a character or sequence of characters in your string.

```py
course = "Python for Beginners"

print('Python' in course) # True
print('python' in course) # False
```

---

## Numbers & arithmetic operations

There are two types of numbers in Python. There are integers which are whole numbers like 10. They do not have a decimal point.

There are also floating point numbers or floats. These are numbers with a decimal point.

Let's look at the arithmetic operations supported in Python. We can add, subtract and multiply numbers and so on:

```py
print(10 + 3)
print(10 - 3)
print(10 * 3)

# there are two kinds of division

print(10 / 3) # we get a floating point number which is 3.3333333333333335

print(10 // 3) # we get an inter '3'

print(10 % 3) # we get the remainder of the division '1'

print(10 ** 3) # this means 10 to the power of 3 -> '1000'
```

If we want to increment a variable:

```py
x = 10
x = x + 3
print(x) = 13
```

But, if we use the augmented assignment operator:

```py
x = 10
x += 3
(print(x)) # 13
```

Because of the operator precendence when calculating:

```py
x = 10 + 3 * 2 # this returns 16 because multiplication operator has a higher precendence.
# this means 3 * 2 is executed first and then it addes 10.
```

The operator precendence is:

- parenthesis `()`
- exponentiation such as 2 \*\* 3
- multiplication or division
- addition or subtraction

So, `10 + 3 * 2 ** 2`'s result will be 22.

Here are some useful functions when working with numbers:

```py
x = 2.9
print(round(x))  # 2
print(abs(-2.9))  # 2.9

```

If you want to write a program that involves complex mathematical calculations, you need to import the math module. A `module` in Python is a separate file with some reusable code. We use these moudles to organize our code into different files. 

In order to use the math moudle, we need to import the module:

```py
import math  # all lower cases
```

Now math is an object like a string, so we can access its functions or more accurately its methods using the dot operator. 

```py
import math

print(math.ceil(2.9))  # 3
print(math.floor(2.9))  # 2

```

For a better understanding, refer to the official documentation!!!

---

## IF Statment 



