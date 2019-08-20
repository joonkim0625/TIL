# Java

Going through a youtube video by Mosh Hamedani. The reference is from [here](https://www.youtube.com/watch?v=eIrMbAQSU34).

---

## Function

Functin is the smallest building block in Java programs. You can think of function as a block of code that performs a task.

If you want to code a function in Java, you could do something like this:

```java
// specifying function's return type
ReturnType Name() {
  // ...
}

// so, let's say the return type of a function below is void

void Name() {
  // ...
}

// void is a reserved keyword in Java
// Also, we want to name our function in a descriptive manner so that when others see its name, they would know the purpose of the function.

void sendEmail() {
  // ...
}
```

Inside these parentheses `()`, we add the parameters for this function. We use these parameters to pass values to our function. As you can see above, in Java, you put the left brace on the same line where we define our function.

Every Java program should have at least one function and that function is called `main`. `main` is the entry point to our programs. Whenever we execute a Java program, the main function gets called and the code inside this function gets executed.

So, these functions do not exist on their own. They should always belong to a `class`. `class` is a container for related functions. We use these classes to organize our code. Just like how products are organized in a supermarket. In a supermarket, we have various sections like vegetables, fruits, cleaning products and so on. Each section contains related products.

A `class` in Java contains related functions. Every Java program should have at least onc class that contains the main function:

```java
// this is how you define a 'class' in Java
class Main {

  // functions that are defined inside this class 'Main' belongs to this class 'Main'!!!
  // we refer to these functions as methods.
  
  void main() {
    // ...
  }
}
```

`Method` is a function that is part of a class. In some porgramming languages like Python, we can hav a function that exists outside of a class, so we call that a function. **But when a function belongs to a class, we refer to it as a method of that class.**

In Java, all these classes and methods should have an `access modifier`. An `access modifier` is a special keyword that determines if other classes and methods in this program can access theses classes and methods. We have various access modifiers like `public`, `private` and so on. Most of the time, we use the public access modifier.

```java
// A basic structure of a Java program

// A main class
public class Main {
  
  // A main method
  public void main() {
    // ... 
  }

}
```

In Java, we use different conventions for naming our classes and our methods. To name our classes, we use `the Pascal naming convention` and that basically means the first letter of every word should be uppercase. In contrast to name our methods, we use the 'camel naming convention` and that means the first letter of every word should be uppercase except the first word. 