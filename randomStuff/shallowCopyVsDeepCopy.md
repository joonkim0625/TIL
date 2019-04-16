# 얕은 복사와 깊은 복사

[참고 자료](https://medium.freecodecamp.org/copying-stuff-in-javascript-how-to-differentiate-between-deep-and-shallow-copies-b6d8c1ef09cd)

---

프로그래밍에서는 변수에 `값`들을 저장한다. 복사를 한다는 것은 기존에 있는 `값`을 새로운 변수에 저장한다는 것이다.이 때 고려해야하는 점이 **얕은 복사와 깊은 복사**이다. **깊은 복사**는 새로운 변수에 저장된 값들이 원본의 변수와는 더 이상 연결되지 않는 것을 뜻한다. **얕은 복사**는 어떠한 값들은 여전히 원본의 변수와 연결되어있는 것을 뜻한다.

## Primitive data types (원시 데이터 타입)

원시 데이터 타입은:
  - 숫자(number) - e.g. `1`
  - 문자열(string) - e.g. 'Hello'
  - 불리언(Boolean) - e.g. true
  - undefined
  - null

원시 데이터 타입의 값은 복사를 한다해도 깊은 복사가 되지 않는다(한 번 선언된 값은 그곳에만 존재한다고 생각할 수 있다). 이러한 성질 때문에, 원시 데이터 타입의 복사를 할 때는 이러한 고려를 할 필요가 없다.

```js
const a = 5
let b = a // this is the copy

b = 6

console.log(b) // 6
console.log(a) // 5
```

원본 값인 a는 변경이 되지 않는다.

## 합성 데이터 타입들 - 객체와 배열

배열들도 결국 객체이기 때문에 객체와 같은 작동 원리를 가지게 된다. 객체들이 생성될 때, 이 값들에 고유한 포인터(참조)가 할당이 된다. 만약 `b = a`라는 복사를 한 다음에 b 내의 포함된 어떠한 값을 수정하게 되면, 이 행위는 a 내에 포함한 어떠한 값도 같이 수정하게 된다.

```js
const a = {
  en: 'Hello',
  de: 'Hallo',
  es: 'Hola',
  pt: 'Olà'
}
let b = a
b.pt = 'Oi'
console.log(b.pt) // Oi
console.log(a.pt) // Oi
```

위에 예에서 발생한 복사는 **얕은 복사**이다. 이것은 종종 문제가 될 수 있다. 그 이유는 복사한 값의 변경이 일어날 때 원본의 값이 변하지 않을 것이라고 생각하기 때문이다. 이러한 점들이 디버깅에 있어서 개발자들을 혼란스럽게 할 수도 있다.

그렇다면, 우리가 어떻게 객체와 배열들의 복사를 할 수 있는지 알아보자!

## 객체

자바스크립트에 새롭게 추가된 기능들을 이용하면 여러 방법을 통해 객체를 복사할 수 있다.

### Spread operator

ES2015에 추가된 spread 연산자를 사용하면 객체 안에 들어있는 모든 값들을 새로운 객체로 나열하게 된다.

```js
const a = {
  en: 'Bye',
  de: 'Tschüss'
}
let b = {...a}
b.de = 'Ciao'
console.log(b.de) // Ciao
console.log(a.de) // Tschüss
```

또한 두 개의 객체들을 합칠 수도 있다: `const c = {...a, ...b}`

### Object.assign

이 방법은 spread 연산자가 생기기 전부터 많이 사용되던 방법으로, spread 생성자와 같은 작동 방식을 갖는다. 조심해야 할 점은, `Object.assign()`에 첫번째 인수로 전해지는 값은 수정이 될 수 있다. 그렇기 때문에 복사하고 싶은 객체는 적어도 두 번째 인수로 넘겨주어야 한다. 보통, 첫 번째 인수로 빈 객체를 넘겨줄 수 있다.

```js
const a = {
  en: 'Bye',
  de: 'Tschüss'
}
let b = Object.assign({}, a)
b.de = 'Ciao'
console.log(b.de) // Ciao
console.log(a.de) // Tschüss
```

### 함정: 구조가 있는 객체들

위의 예시들과 같이 객체를 복사할 때 따르는 위험이 있다. 구조가 있는 객체 혹은 배열을 복사할 때, 그 내부에 있는 객체들은 복사가 되지 않을 점이라는 것이다(그 안의 객체들의 참조만 복사하는 것이 되기 때문). 그렇기 때문에, 내부의 객체에 변화를 주게 되면, 이 역시 원본의 객체에도 영향을 줄 것이고 이는 결국 또 다른 얕은 복사가 되어버린다. 

**안좋은 예**
```js
// BAD EXAMPLE
const a = {
  foods: {
    dinner: 'Pasta'
  }
}
let b = {...a}
b.foods.dinner = 'Soup' // changes for both objects
console.log(b.foods.dinner) // Soup
console.log(a.foods.dinner) // Soup
```

이 내부의 객체도 깊은 복사를 하기 위해서는, 모든 객체들(내부에 있는)을 직접 복사하는 것이다.
```js
const a = {
  foods: {
    dinner: 'Pasta'
  }
}
let b = {foods: {...a.foods}}
b.foods.dinner = 'Soup'
console.log(b.foods.dinner) // Soup
console.log(a.foods.dinner) // Pasta
```

만약에 위의 예제보다 더 복잡한 구조라면 어떻게 해야 할까? 그런 상황이라면 spread 연산자의 사용을 극대화할 수 있겠다. `...spread`후에 더 많은 속성들을 넘겨주면, spread 연산자는 원래의 값을 덮어쓰게 된다. 예를 들자면, `const b = {...a, foods: {...a.foods}}`와 같은 식이다. 

### 생각 안하고 깊은 복사하기!

만약에 객체의 구조가 얼마나 깊은지 모른다면, 위와 같은 접근은 매우 복잡해질 수가 있다. 모든 것을 한번에 복사하고 싶으면, `stringify`와 `parse`를 사용할 수 있다.

```js
const a = {
  foods: {
    dinner: 'Pasta'
  }
}
let b = JSON.parse(JSON.stringify(a))
b.foods.dinner = 'Soup'
console.log(b.foods.dinner) // Soup
console.log(a.foods.dinner) // Pasta
```

이 방식은 오직 순수 자바스크립트 값들만 복사할 수 있다는 점을 명심해야 한다.

## 배열

배열을 복사하는 것은 객체를 복사하는 것 만큼 흔하다. 배열도 결국 객체인 만큼 복사하는 과정도 거의 비슷하다.

### Spread 연산자

객체를 복사할 때처럼, 배열도 spread 연산자를 이용하여 복사가 가능하다.

```js
const a = [1,2,3]
let b = [...a]
b[1] = 4
console.log(b[1]) // 4
console.log(a[1]) // 2
```

### 배열 함수들 - map, filter, reduce

이 메소드들은 새로운 배열을 새로운 배열을 반환한다. 새로운 배열을 반환하는 과정에서 값들의 수정도 할 수 있다.

```js
const a = [1,2,3]
let b = a.map(el => el)
b[1] = 4
console.log(b[1]) // 4
console.log(a[1]) // 2
```

복사하는 과정에서 원하는 값의 수정을 할 수 있다.

```js
const a = [1,2,3]
const b = a.map((el, index) => index === 1 ? 4 : el)
console.log(b[1]) // 4
console.log(a[1]) // 2
```

### Array.slice

`array.slice()` 또는 `array.slice(0)`을 사용하면 기존 배열을 복사하게 된다. 

```js
const a = [1,2,3]
let b = a.slice(0)
b[1] = 4
console.log(b[1]) // 4
console.log(a[1]) // 2
```

### 구조가 깊은 배열들

객체와 비슷한 경우로, 위의 방법들로 복사를 하면 내부의 값들은 얕은 복사만 되어버린다. 이를 방지하기 위해 `JSON.parse(JSON.stringify(someArray))`를 사용할 수 있다.

### custom class를 복사하는 법

만약 직접 만든 생성자나 함수들 또는 클래스들을 복사하고 싶다면 단순히 stringify와 parse로는 할 수 없다. 이 방법을 쓴다면 클래스 메소드들을 잃게 되기 때문이다. 대신에, 따로 메소드들을 복사해서 복사할 원본 값들에 추가해줄 수 있다.

```js
class Counter {
  constructor() {
     this.count = 5
  }
  copy() {
    const copy = new Counter()
    copy.count = this.count
    return copy
  }
}
const originalCounter = new Counter()
const copiedCounter = originalCounter.copy()
console.log(originalCounter.count) // 5
console.log(copiedCounter.count) // 5
copiedCounter.count = 7
console.log(originalCounter.count) // 5
console.log(copiedCounter.count) // 7
```

위와 같이 originalCounter라는 새로운 클래스를 생성한 뒤에, 이 안에 있는 메소드를 복사해서 사용할 수 있다.

또한, 밑과 같은 방식도 사용할 수 있다.

```js
class Counter {
  constructor() {
    this.count = 5

    this.add = function() {
      this.count++
    }
  }

  copy() {
    const copy = new Counter()

    Object.keys(this).forEach(key => {
      const value = this[key]

      switch(typeof value) {
        case 'function':
          break
        case 'object':
          copy[key] = JSON.stringify(JSON.parse(value))
          break
        default:
          copy[key] = value
          break
      }
    })
    
    return copy
  }
}
```

위의 방법을 사용한다면, 생성자 안에 몇 개의 메소드들이 있든 간에 모든 내용을 복사할 수 있다.