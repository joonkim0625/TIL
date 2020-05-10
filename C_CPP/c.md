# C programming

## pointers

```c

int main() {
    int age = 30;
    // below creates a pointer variable that contains `age`'s memory address
    int *pAge = &age;

    printf("%p", pAge); // prints age's memory address

    return 0;
}


```

## dereferencing pointers

```c
int main() {
    int age = 30;
    int *pAge = &age;

    printf("%d", *pAge); // prints 30

    // or

    printf("%d", *&age); // dereferencing &age to get 30

    return 0;


}

```

Dereferencing can mean that grabbing the actual value that is stored at the memory address that the pointer is pointing to, and in this case, it is 30.

## when using getchar()

I was trying to create a simple while loop menu...

```cpp
int main()
{
    int sel;

    // menu
    while (sel != '4')
    {
        printf("Menu\n");
        // some code...
        printf("Enter Selection: \n");

        sel = getchar();
        getchar();

        printf("\n");

        switch (sel)
        {
        case '1':
        // some code...
        default:
        {
            printf("\n");
            printf("Invalid option\n");
            printf("\n");
        }
        }
    }

}
```

in this case, I have found that if you get an user input by using `sel = getchar()`, then you need to consume the next line by using `getchar()` one more time(this means there will be a carriage return at the end of each input line).

While I was searching for this issue, I also found this [article](http://rabbit.eng.miami.edu/class/een218/getchar.html)(creating a function that lets user continue if they press ENTER).
