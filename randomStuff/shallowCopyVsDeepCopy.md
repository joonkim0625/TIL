```js
const example = {
  name: 'Kim', 
  age: 25,
  title: 'Front End Developer'
}


const example1 = example // shallow copy

example1.name = 'Park'
// 위는 example 객체 내의 name도 바꿔버릴텐데, 그 이유는 example1의 참조값이 example에 있기 때문이다

// 위를 방지하고 deep copy를 하고 싶다면,

const example2 = {
  name: example.name,
  age: example.age,
  title: example.title
}

// example의 각 속성 값을 할당해주면, example2.name = "Lee"과 같이 변경해도 example에 영향을 더 이상 주지 않는다

```