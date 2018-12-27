# React: udemny online lecture

강의와 관련된 개발환경 설정

JSX : 부분적인 템플릿 혹은 변형된 자바스크립트로써, 자바스크립트 안에 HTML의 소스코드를 사용할 수 있게 해준다. 바벨과 같은 컴파일러를 통해서 바닐라 자바스크립트로 변환된 뒤에 화면에 표시된다.

React component를 화면에 그리기 위해서는:

1. React라는 라이브러리를 불러와야 하기 때문에 `import React from 'react';`를 해주는 것을 잊어서는 안된다.
2. 그리고 App.js(혹은 index.js)를 DOM에 붙인 뒤 화면에 그려주어야 하기 때문에 ReactDOM을 `'react-dom'`으로 부터 import를 해와야 한다.

DOM에 컴포넌트를 렌더하기 위해서는 컴포넌트를 인스턴스화 해야한다. 인스턴스화를 하기 위해서는 ReactDOM.render()안에 `<App />`이라는 인스턴스(App이라는 클래스가 아닌)를 렌더하라고 지정해주어야 한다.

인스턴스를 지정해주었다고 해서, 렌더가 되는 것이 아니다. 그 이유는 어디에다가 렌더를 해주어야 하는 지도 지정해주어야 하기 때문이다. 이는 index.html내에 있는 root를 찾아서 지정해주면 된다.

<!-- 섹션 1, 챕터 12 부터 시작 -->

# 2018-12-27

우리가 app을 만들 때, 어떻게 컴포넌트를 구성할 지 정해야 한다.

1. app 상단의 검색 바 컴포넌트

- 이는 검색하는 기능을 가지고 있고, 검색 바를 렌더링 할 것이다

2. app 중간에 비디오를 플레이하는 컴포넌트

- 역시 기능과 렌더링

3. 비디오의 프리뷰를 보여주는 컴포넌트

- 비디오의 프리뷰 썸네일과 타이틀을 포함

4. 3번의 비디오 프리뷰들을 포함하는 리스트를 보여주는 컴포넌트

5. 그리고 위의 4가지 모두를 포함할 하나의 전체 컴포넌트

파일 당 하나의 컴포넌트를 만들어야 한다.

## Youtube API를 사용해서 비디오 재생하는 컴포넌트의 생성

npm을 통해 youtube-api-search를 설치. 설치 시에 `--save`를 선언하면, 이는 package.json에 파일을 자동으로 저장해달라는 의미이다.

컴포넌트를 생성한 뒤에 export를 하지 않으면, 다른 컴포넌트에서 불러와 사용할 수가 없다. 그렇기 때문에 export를 하는 것을 잊지 말자!

```js
// 무언가를 export 할 때,

const SearchBar = () => {
  return <input />;
};

const foo = 5;

export default SearchBar;

// 위와 같은 선언은 foo는 제외한 SearchBar만 export 한다.
```

무언가를 import 해올 때, npm에서 설치된 패키지같은 경우에는 `from 패키지 이름`만 선언해줘도 되지만, 컴포넌트 같은 경우에는 import를 하려고 하는 파일의 상대 경로를 지정해서 불러와주어야 한다.

index.js에 search_bar.js를 렌더링 한다. index.js는 search_bar.js를 렌더링하고, 이 렌더링의 결과를 App 컴포넌트 안에 렌더링 한다. 이 App.js 컴포넌트는 div에 렌더링 할 것이고, 이 div는 index.js파일의 container라는 컨테이너 안에 위치한다.

리액트 컴포넌트의 형태

1. 함수형 컴포넌트
2. 클래스 컴포넌트

함수형 컴포넌트보다 클래스 컴포넌트가 더 많은 기능(상태라던지..)을 포함할 수 있다.

```js
// class component의 생성
// extends React.Component는 말 그대로
// 리액트 컴포넌트로부터 모든 기능을 제공받으라는 것이다
class SearchBar extends React.Component {}
```

함수형 컴포넌트로 시작할 지, 클래스형 컴포넌트로 시작할 지에 대한 고민은 무척 어렵다...

## Detecting handling events

`<input />` 안에:
`onChange`: 모든 HTML 인풋 요소에 change event가 발생하면 `onChange={함수}` 함수가 실행된다. 여기서 `onChange`는 prop이고 이 안에 함수를 쓰게 된다.

이벤트 핸들러 안에 들어갈 요소로써 이벤트 객체가 있는데 이는 e 또는 event라 정의할 수 있고, 어떠한 이벤트가 발생했는지를 알기 위해서는 `event.target.value` 등의 선언을 통해 입력이 되고있는 input 등을 바로 확인할 수 있다.

핸들러를 정의해줄 수도 있으나, 바로 적용시킬 수도 있다.

```js
// input 컴포넌트 내에 바로 적용시킨 것
class SearchBar extends Component {
  render() {
    return <input onChange={e => console.log(e.target.value)} />;
  }
}
```

## 상태 관리

함수형 컴포넌트는 상태를 가질 수 없고, 오직 클래스형 컴포넌트만 상태를 가질 수 있다.

```js
constructor(props) {
    super(props);

    this.state = {
      term: ""
    };
  }
```

위는 React component에서 상태를 정의하고 싶을 때 만드는 contructor이다.
Component가 constructor 함수를 가질 때:

- 부모 클래스에 메소드를 미리 정의했을 때 => component:
  - super를 호출하면서 이 부모 클래스의 메소드를 호출할 수 있다.

<!-- 챕터 18부터 다시 시작 -->
