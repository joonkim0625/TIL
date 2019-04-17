# Binary Search Tree(이진 탐색 트리)!

Tree 데이터 구조는 데이터를 담는 방법 중 하나로써, 시각화하면 나무처럼 보이기 때문에 저렇게 이름이 지어졌다.

데이터의 꼭지점들은 노드(node)라고 불리며, 트리의 맨 위에 위치한 노드는 root node라고 불린다. Root node로부터 노드들이 가지를 치듯이 뻗어나가게 되는데, 부모 노드가 있으면 그 밑으로 자식 노드들이 있는 형태가 구성된다. Leaf node는 자식 노드가 없는 가지 맨 끝에 위치한 노드들을 뜻한다.

Binary Search Tree는 노드 하나가 두 개의 branch만을 가질 수 있다. 또한, 이 데이터 구조는 순서를 가지고있는 구조로써, left-subtree는 부모 노드보다 순서값이 작거나 같아야 하고, right-subtree는 부모 노드보다 값이 크거나 같다. 또한, 값이 중복된 노드가 없어야 한다.

## 탐색 과정 ([참고](https://blog.naver.com/whdgml1996/221411993736))

Binary Search Tree에서 자신이 찾고자 하는 값 A가 있다고 하자. 하나의 노드에 접근했을 때, 해당 노드의 값이 A와 같다면 A를 리턴하고 다르다면 하위 노드를 탐색한다. 이 때, A의 값이 현재 노드의 값 보다 작으면 왼쪽 노드로 가서 값을 비교하고, 크다면 오른쪽 노드에서 탐색을 한다. 

Binary Search Tree의 장점은 레벨의 수만큼 비교를 하면 원하는 값을 찾는다는 것이다. 먄약 3레벨 짜리의 트리를 탐색한다고 하면 `2^(레벨 수) - 1`번 만큼만 비교해서 탐색을 완료시킬 수 있다. 만약 노드의 수가 1023개라면 2^10 - 1번인 10번만 비교를 하면 되기에, 노드의 수가 많아질수록 효율적이다. 

---

```js
// 이진 탐색 

class Node {
  constructor(data, left = null, right = null) {
    // 저장하려는 데이터
    this.data = data;
    // 왼쪽 노드
    this.left = left;
    // 오른쪽 노드
    this.right = right;
  }
}

class BST {
  constructor() {
    this.root = null
  }

  add(data) {
    const node = this.root
    if (node === null) {
      this.root = new Node(data)
      return
    } else {
      // 재귀 함수: 노드를 위치시킬 적합한 곳을 찾을 때까지 계속 함수의 반복
      const searchTree = function(node) {
        // 들어온 데이터의 크기가 이미 들어있는 데이터의 크기보다 작으면, 왼쪽 노드로 보낸다
        if (data < node.data) {
          // 결국 null인 곳을 찾을 때까지 함수의 반복
          if (node.left === null) {
            node.left = new Node(data)
            return
          } else if (node.left !== null) {
            return searchTree(node.left)
          } 
        } else if (data > node.data) {
          if (node.right === null) {
            node.right = new Node(data)
            return
          } else if (node.right !== null) {
            return searchTree(node.right)
          }
        } else {
          // 만약 값이 적거나 크지 않다면(같다면) 바로 반환
          return null
        }
      }
      return searchTree(node)
    } 
  }

  findMin() {
    let current = this.root
    while (current.left !== null) {
      current = current.left
    }
    return current.data
  }

  findMax() {
    let current = this.root

    while (current.right !== null) {
      current = current.right
    }
    return current.data
  }

  find(data) {
    let current = this.root

    while (current.data !== data) {
      if (data < current.data) {
        current = current.left
      } else {
        current = current.right
      }
      if (current === null) {
        return null
      }
    }
    return current
  }

  isPresent(data) {
    let current = this.root

    while (current) {
      if (data === current.data) {
        return true
      }
      if (data < current.data) {
        current = current.left
      } else {
        current = current.right
      }
    }
    return false
  }

  remove(data) {
    const removeNode = function(node, data) {
      if (node == null) {
        return null
      }


      if (data == node.data) {
         // node의 참조값을 변경하는 것

        // 노드에 자식이 없을 경우
        if (node.left == null && node.right == null) {
          return null
        }
        // 노드 왼쪽 줄기에 자식이 없을 경우
        if (node.left == null) {
          return node.right
        }
        // 노드 오른쪽 줄기에 자식이 없을 경우
        if (node.right == null) {
          return node.left
        }

        // 노드에 2개의 자식이 있을 경우
        let tempNode = node.right
        while (tempNode.left !== null) {
          tempNode = tempNode.left
        }
        node.data = tempNode.data
        node.right = removeNode(node.right, tempNode.data)
        return node
      } else if (data < node.data) {
        node.left = removeNode(node.left, data)
        return node
      } else {
        node.right = removeNode(node.right, data)
        return node
      }
    }
    this.root = removeNode(this.root, data)
  }
}
```

트리안의 노드를 제거하는 로직이 이해하기 쉽지가 않다.


