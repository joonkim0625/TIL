# Stacks!

스택을 책 쌓기로 비교해보면, 가장 맨 위에 쌓여있는 책은 가장 나중에 놓인 책이라고 볼 수 있다. 가장 맨 위에 있는 책을 제거하면, 그 바로 밑에 놓여있던 책이 가장 맨 위에 위치하는 것이다. 이것을 `last in, first out` 타입의 서비스라고 한다.

이 서비스가 사용된 예로는 브라우저의 뒤로가기 기능을 생각할 수 있다. 만약 페이스북 페이지를 방문하게 되면, 페이지 히스토리 맨 위에 페이스북 페이지가 저장되게 될 것이다. 그리고 뒤로가기를 누르면 가장 맨 위에 위치한 페이스북을 pop 메소드로 제거하고, 그 전에 놓여있던 다른 페이지가 가장 맨 위에 위치하며 그 페이지를 불러오는 방식이다.

스택의 기능들: 
- push : 스택에 새로운 요소를 집어넣을 때
- pop : 스택 맨 위에 위치한 요소를 제거할 때
- peek : 가장 맨 위에 위치한 요소를 보여주는 
- length or size : 요소의 길이 혹은 크기를 보여주는

자바스크립트에서는 배열이 위와 같은 메소드들이 이미 구현되어 있어서, 배열을 이용하여 스택을 구현해볼 수 있다.

필란드롬을 배열을 사용해서 구현해보는 것도 스택의 성질을 이용해서 구현하는 것이라고 볼 수 있다.

```js
// 필란드롬

let letters = [] // 이것이 스택인 것이다!!

const word = 'racecar'

let rword = ''

for (let i = 0; i < word.length; i++) {
  letters.push(word[i])
}


for (let i = 0; i < word.length; i++) {
  rword += letters.pop()
}


if (rword === word) {
  console.log(word + ' is a palindrome!')
} else {
  console.log(word + ' is not a palindrome!')
}
```

그렇다면 스택을 생성자를 이용해 구현해보자

```js

function Stack() {
  this.count = 0
  this.storage = {}

  Stack.prototype.push = function(value) {
     this.storage[this.count] = value
     this.count++
  }

  Stack.prototype.pop = function() {

    if (this.count === 0) {
      return undefined
    }

    this.count--
    let result = this.storage[this.count]
    delete this.storage[this.count]
    return result

  }

  Stack.prototype.size = function() {
    return this.count
  }
 
  Stack.prototype.peek = function() {
    return this.storage[this.count - 1]
  }
  
}

const myStack = new Stack()
```

클래스를 이용한 스택의 구현

```js


class Stack {
  constructor() {
    this.count = 0
    this.storage = {}
  }

  push(value) {
    this.storage[this.count] = value
    this.count++
  }

  pop() {
    if (this.count === 0) {
      return undefined 
    }

    this.count--
    let result = this.storage[this.count]
    delete this.storage[this.count]

    return result
  }

  size() {
    return this.count
  }

  peek() {
    return this.storage[this.count - 1]
  }
}

const myStack = new Stack()

myStack.push(1)
myStack.push(2)
myStack.push(3)
myStack.push('hello world!')

console.log(myStack.peek(), myStack.size()) // hello world! 4
```