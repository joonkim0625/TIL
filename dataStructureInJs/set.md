# Sets!

Set 데이터 구조는 배열같지만, 중복된 요소가 없다는 점이 다르고 요소들은 순서가 없이 저장된다. set이 사용되는 흔한 경우는 요소가 존재하는지 안하는지에 대한 확인이다.

ES6에는 set 객체를 추가하긴 했지만, set이 보통 가지고 있는 모든 메소드들을 구현하지는 않았다. 그렇기 때문에 어떠한 메소드들은 직접 구현을 해야 하는 경우도 있다.

```js
function mySet() {
  // set 구성하는 배열인 collection
  let collection = []

  // 이 메소드는 요소가 set안에 있는지 없는지를 검사한 뒤에 true 또는 false를 반환

  this.has = function(element) {
    return (collection.indexOf(element) !== -1)
  }

  // 이 메소드는 set 내에 있는 모든 요소들을 반환

  this.values = function() {
    return collection
  }

  // 이 메소드는 set에 요소를 추가한다

  this.add = function(element) {
    if(!this.has(element)) {
      collection.push(element)
      return true
    }
    return false
  }

  // 이 메소드는 set으로부터 요소를 제거한다 

  this.remove = function(element) {
    if(this.has(element)) {
      let index = collection.indexOf(element)

      collection.splice(index, 1)

      return true
    }
    return false
  }

  // *** 여기까지는 ES6에도 구현이 되어있는 메소드들 ***

  // 이 메소드는 collection의 크기(size)를 반환 
  this.size = function() {
    return collection.length
  }

  // 이 메소드는 2개의 set들을 가지고 작업할 때 사용할 수 있다. 두 개의 set들을 중복되는 것을 제외하고 합치는 메소드

  this.union = function(otherSet) {

    // unionSet은 두 개의 다른 set을 합칠 set
    const unionSet = new mySet()
    // firstSet 위에 선언된 메소드를 사용해 지금 내부의 set을 선언한다
    const firstSet = this.values()
    // 다른 set의 collection 값을 선언한다
    const secondSet = otherSet.values()

    // add 메소드는 has 메소드를 사용하여 중복되는 요소들은 알아서 포함하지 않는다
    firstSet.forEach(function(e) {
      unionSet.add(e)
    })
    secondSet.forEach(function(e) {
      unionSet.add(e)
    })

    return unionSet
  }

  // 이 메소드는 두 개의 다른 set들이 공통적으로 가지고 있는 요소들을 반환한다

  this.intersection = function(otherSet) {
    const intersectionSet = new mySet()

    const firstSet = this.values()

    firstSet.forEach(function(e) {
      if (otherSet.has(e)) {
        intersectionSet.add(e)
      }
    })
  return intersectionSet
  }

  // 이 메소드는 두 set가 가진 서로 다른 요소들을 반환

  this.difference = function(otherSet) {
    const differenceSet = new mySet()
    const firstSet = this.values()

    firstSet.forEach(function(e) {
      if (!otherSet.has(e)) {
        differenceSet.add(e)
      }
    })
    return differenceSet
  }

  // 이 메소드는 set이 different set 내에 완전히 포함되어 있는지를 확인

  this.subset = function(otherSet) {
    const firstSet = this.values()
    // every 메소드를 사용해서 otherSet.has(value)라는 테스트를 firstSet이 가지고 있는 모든 요소들이 통과하는지 확인
    return firstSet.every(function(value) {
      return otherSet.has(value)
    })
  }
}

const setA = new mySet()
const setB = new mySet()

setA.add('a')
setB.add('b')
setB.add('c')
setB.add('a')
setB.add('d')
setB.add('a')

console.log(setB.values())
```

ES6에 추가된 Set에서도 비슷한 기능들을 사용해 볼 수 있다. 다른 점이 있다면, 어느 set에 관한 요소들을 보기 위해 `setD.values()`를 입력하면, 배열을 반환하는 대신 iterator를 반환한다. 

그리고 ES6에 추가된 Set은 요소를 add할 때 true 또는 false를 반환하는 것이 아닌 set 자체를 반환한다.


