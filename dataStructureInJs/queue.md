# Queues!

Queue 자료구조는 정보를 담아두는 방법 중 하나인데, Stack과 다른 점은 Queue는 `first in, first out`의 방식이라는 것이다.

문서들을 프린트 할 때, 먼저 예약된 문서들이 먼저 프린트되는 것을 예로 들 수 있다.

배열을 이용해서 큐를 직접 구현해보자.

```js
// Queues

function Queue() {
  let collection = []

  this.print = function() {
    console.log(collection)
  }

  this.enqueue = function(element) {
    collection.push(element)
  }

  this.dequeue = function() {
    return collection.shift()
  }

  this.front = function() {
    return collection[0]
  }

 this.size = function() {
   return collection.length
 }

 this.isEmepty = function() {
   return (collection.length === 0)
 }
}

const myQueue = new Queue()

myQueue.enqueue('안녕')

myQueue.front()

```