# Jest!!

set 구현해 본 것에 테스트 코드를 작성해 보았는데... 테스트를 해서 일단 패스를 한다는 게 재밌습니다. 물론 제대로 된 테스트인지는 잘 모르겠어요 :(


```js
test(`if 'a' is already in the set, it returns false`, () => {
  const setA = new mySet();
  setA.add("a");
  expect(setA.values()).toEqual(["a"]);
});

test(`setA that has ['a', 'b', 'd'] intersects with setB that has ['a', 'c', 'd'] returns ['a', 'd']`, () => {
  const setA = new mySet();
  const setB = new mySet();

  setA.add("a");
  setA.add("b");
  setA.add("d");
  setB.add("a");
  setB.add("c");
  setB.add("d");

  expect(setA.intersection(setB).values()).toEqual(["a", "d"]);
});
```

어쨌든 기능이 잘 작동하는지 안하는지를 알아보기 위한 테스트라고 생각하고 돌려봤더니 일단 잘 작동하는 것으로 보입니다.

```
 ✓ if 'a' is already in the set, it returns false (4ms)
  ✓ setA that has ['a', 'b', 'd'] intersects with setB that has ['a', 'c', 'd'] returns ['a', 'd'] (1ms)

Test Suites: 1 passed, 1 total
Tests:       2 passed, 2 total
```

