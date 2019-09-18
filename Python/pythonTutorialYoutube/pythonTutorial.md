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

## if statments

`if` statements are very important in programming and they allow us to build programs that can make decisions based on some condition.

**a practice problem**

```py
price_of_house = 1000000

is_credit_good = False

if is_credit_good:
    down_payment = price_of_house * 0.1

else:
    down_payment = price_of_house * 0.2


print(f"Down payment: {down_payment}")

# my question: although you did not declare a variable before the if statement,
# the variable that is assinged inside the if statement still exists and you can use it??
# and you can re-assign values into a variable?
# not like JavaScript where if you declare a variable with const, then you won't be able to re-assign a value?

```

---

## Logical operators

We use `logical operators` in situations where we have multiple conditions. This is not specific to Python programming language, pretty much to any programming language.

```py
has_high_income = True
has_good_credit = True

if has_high_income and has_good_credit:
    print("Eligible for loan")

# this pritns the string.
# if one of the variables is 'False', it won't print anything.

if has_high_income or has_good_credit:
    print("Eligible for loan")

# this will work as long as one of the variables' condition is True.

```

So, three situations are:

- AND: both
- OR: at least one
- NOT: inverses any boolean value

this is an example of `not` operator:

```py
has_good_credit = True
has_criminal_record = False

if has_good_credit and not has_criminal_record:
    print("Eligible for loan")

# since has_criminal_record is False, 'not has_criminal_record' becomes True.
# therefore, the 'and' operator will print the string.

```

---

## Comparison operators

We use `comparison operators` in situations where we want to compare a variable with a value. For example, let's say there is a statement that says:

```
if temperature is greater than 30
  it's a hot day
otherwise if it's less than 10
  it's a cold day
otherwise
  it's neither hot nor cold
```

```py

temperature = 30

if temperature >= 30:
    print("it is a hot day")
elif temperature <= 10:
    print("it is a cold day")
else:
    print("it is neither")

```

Comparison operators:

- `>` or `>=`
- `==`
- `!=`

**equality operator**
`==` must be used to compare between values. `=` is the assignment operator.

An exercise on the video:

```py

name = "JAEJJEAJDFJASDF"

if len(name) < 3:
    print("name must be at least 3 characters")
elif len(name) > 50:
    print("name should be a maximum of 50 characters")
else:
    print("name looks good")

```

Another exercise - wrtie a program that an user types an input, and then the result varies depending on the unit that the user selects.

my solution:

```py
weight = input("Weight: ")

unit = input("(L)bs or (K)g: ")

lower_cased_unit = unit.lower()

if lower_cased_unit == "l":
    print(f"your weight is {int(weight) * 0.45} kg.")
elif lower_cased_unit == "k":
    print(f"your weight is {int(weight) / 0.45} pounds.")
else:
    print("please select between L or K")
    # will I able to go back to a certain point of code line if this is the case?

```

Mosh's solution:

```py
weight = int(input('Weight: '))
unit = input('(L)bs or (K)g: ')

if unit.upper() == "L":
    converted = weight * 0.45
    print(f"You are {converted} kilos")
else:
     converted = weight / 0.45
    print(f"You are {converted} pounds")
```

---

## while loops

We can use while loops to execute a block of code multiple times. There are often useful in building interactive programs and games.

Here is an example:

```py
i = 1

while i <= 5:
    print(i)
    i += 1

print('done')
# 1
# 2
# ...
# 5
# done

```

The code is going to run until i becomes 6. Once i becomes 6, while loop will stop because i is greater than 5 which makes the statement false. The code gets out of the while loop and go to the next line which is printing 'done'.

A quick exercise using while loop

- Build a program that lets user guess 3 times.
- If the answer is given in 3 attempts, it is going to say 'you win'
- If the answer is not given in 3 attempts, it is going to say 'try again'

**my solution**

```py
answer = 9
attempt = 1

while attempt <= 3:

    guess = int(input("Guess: "))

    if guess == answer:
        print("You are right!!!")
        break
    elif attempt == 3:
        print("Try again!")

    attempt += 1

```

**Mosh's solution**

```py
secret_number = 9
guess_count = 0
guess_limit = 3

while guess_count < guess_limit:
    guess = int(input("Guess: "))
    guess_count += 1

    if guess == secret_number:
        print("You won!")
        break

else:
    print("Sorry, you failed!")

```

After looking at the solution

- I did not know that while loop could have the else statement!!!
- It would have been better to have a variable such as guess_limit. Not just using a number.
- The location of incrementation should be located soon as the while loop starts. That makes more sense...

---

Another quick exercise:

- If user types 'help', it will show the commands that the user can use.
- and the commands will show their own functions as user type their names.

```py
command = ""

while command != "quit":
    command = input("> ").lower()

    if command == "start":
        print("Car Started...")
        command = ""

    elif command == "stop":
        print("Car stopped.")
        command = ""

    elif command == "help":
        print(
            """
        start - to start the car

        """
        )
        command = ""

    elif command == "quit":
        break

    else:
        print("I don't understand.")
        command = ""


```

**Mosh's solution**

```py
command = ""

while True:
    command = input("> ").lower()

    if command == "start":
        print("Car Started...")

    elif command == "stop":
        print("Car stopped.")

    elif command == "help":
        print(
            """
start - to start the car
stop - to stop the car
quit - to quit

        """
        )

    elif command == "quit":
        break

    else:
        print("Sorry, I don't understand.")


```

If you use `while True: ...`, you can have a block of code run until you tell the code to break.

More to the excercise: if the car is already running while user inputs 'start', make it say 'the car is already running'.

```py
command = ""
status = "stopped"

while True:
    command = input("> ").lower()

    if command == "start":

        if status == "started":
            print("it is running")
        elif status == "stopped":

            status = "started"
            print("Car Started...")

    elif command == "stop":

        if status == "stopped":
            print("it isn't running")

        elif status == "started":
            print("Car stopped.")

    elif command == "help":
        print(
            """
start - to start the car
stop - to stop the car
quit - to quit

        """
        )

    elif command == "quit":
        break

    else:
        print("Sorry, I don't understand.")


```

**Mosh's solution**

```py
command = ""
started = False

while True:
    command = input("> ").lower()

    if command == "start":

        if started:
            print("Car is already started")
        else:
            started = True
            print("Car Started...")

    elif command == "stop":

        if not started:
            print("Car is already stopped")
        else:
            started = False
            print("Car stopped.")

    elif command == "help":
        print(
            """
start - to start the car
stop - to stop the car
quit - to quit

        """
        )

    elif command == "quit":
        break

    else:
        print("Sorry, I don't understand.")


```

What I learned:

- how to come up with better variable names and their values.
- need to think more simplely.

---

**Write a program that adds up all the prices in a list**

```py
prices = [10, 20, 30]

total = 0

for item in prices:
    total += item

print(total)

```

**Mosh's solution**

```py
prices = [10, 20, 30]

total = 0

for price in prices:
    total += item

print(f"Total: {total}")
```

- I need to come up with better variable names or naming in general. Even in the for loop, I could have used a better name than 'item'. Also, when I try to print something, it should try to make it like an actual print statement, not just priting a result of something...

---

### Nested loops

Nested loop is basically adding one loop inside of another loop.

Example:

```py
for x in range(5):

    for y in range(5):
        print(f"({x}, {y})")

# code like above will print something like below
# (0, 0)
# (0, 1)
# (0, 2)
# (0, 3)
# (0, 4)
# (1, 0)
# (1, 1)
# (1, 2)
# (1, 3)
# (1, 4) ...

```

**challenge**

Using nested loop to print a letter like below:

```
xxxxx
xx
xxxxx
xx
xx
```

**solution**

```py
numbers = [5, 2, 5, 2, 2]

for x_count in numbers:

    # this resets the output as the first noop runs again
    output = ""

    for count in range(x_count):
        output += "x"

    print(output)

```

- leanred how to better use the nested loop...
- from the example above, you could use `x_count` to set the range.
- nice!!

---

### Lists

```py
names = ['John', 'Bob', 'Mose', 'Sarah', 'Maria']

print(names[0])     # prints John
print(names[-1])    # prints Maria
print(names[-2])    # prints Sarah
print(names[2:])    # ['Mose', 'Sarah', 'Maria']
                    # [2:] => starting from the index of '2'
print(names[2:4])   # pritns ['Mose', 'Sarah']
                    # pritns from index[2] to index[3]. Does not include the last number which is [4]

# if you want to overwrite an item that is in the list:

names[0] = 'Hello'

print(names)    # ['Hello', 'Bob', 'Mose', 'Sarah', 'Maria']

```

---

\*\* Exercise:
find a largest number in a list

**my attempt**

```py
def largest_num(number_list):

    stored_num = number_list[0]

    for number in number_list:

        if stored_num < number:

            stored_num = number

    return stored_num
```

**Mosh's**

```py
# numbers = [ some numbers ...]

max = numbers[0]

for number in numbers:
    if number > max:
        max = number

print(max)
```
