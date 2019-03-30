# Queues!

Queue 자료구조는 정보를 담아두는 방법 중 하나인데, stack과 다른 점은 queue는 `first in, first out`의 방식이라는 것이다.

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


또, queue에는 priority queue의 방식으로 큐를 만들어 볼 수 있는데, 이는 큐 내에 요소를 집어넣을 뿐만 아니라 그 요소들 사이에서도 우선순위를 정해준 뒤 큐 안에 넣을 수 있다. 우선순위가 높은 큐는 다른 큐들보다 제일 먼저 위치하게 된다. 큐의 우선순위가 다 같다면, 먼저 넣어진 순서대로 큐가 정렬된다.

```js
// priority queue

function PriorityQueue() {
  let collection = []

  this.printCollection = function() {
    console.log(collection)
  }

  // element는 ['item', priority]
  this.enqueue = function(element) {
    if (this.isEmpty()) {
      collection.push(element)
    } else {
      let added = false
      for (let i = 0; i < collection.length; i++) {
        if (element[1] < collection[i][1]) {
          collection.splice(i, 0, element)
          added = true
          break
        }
      }
      // 만약 added = false로 남아있다면, 즉 위의 for 문에서 priority가 더 위인 요소가 없었다면 그대로 element를 push - 배열의 마지막에 위치하게 된다
      if (!added) {
        collection.push(element)
      }
    }
  }

  this.dequeue = function() {
    let value = collection.shift()
    // value 자체를 리턴하여 item과 우선순위를 보여줄 수 있고, 아니면 밑과 같이 item만 보여줄 수도 있다
    return value[0]
  }

  this.front = function() {
    return collection[0]
  }

  this.size = function() {
    return collection.length
  }

  this.isEmpty = function() {
    return (collection.length === 0)
  }
}

let pq = new PriorityQueue()

pq.enqueue(['둘', 2])
pq.enqueue(['하나', 1])
pq.enqueue(['셋', 3])

pq.printCollection()
pq.dequeue()
pq.printCollection()
pq.size()
```

