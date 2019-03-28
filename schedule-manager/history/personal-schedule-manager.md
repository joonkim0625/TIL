

# 이번 프로젝트를 진행하며 느낀 점들을 적어봅니다.

1. 리덕스를 사용해보았다!
  - 물론, 간단한 정보의 추가, 삭제, 업데이트 정도지만 조금 더 익숙해지는 계기가 될 수 있었다.

  - 이번에 구현한 작은 규모의 프로젝트에선 리덕스가 굳이 필요가 없다는 것을 느꼈다. 하지만 규모가 어느 정도 있고, 집적적인 관계가 없는 컴포넌트들 사이에서 공통의 상태를 공유해야 할 때는 리덕스가 매우 유용할 것이라 느낀다. 기회가... 된다면!!! 조기요 프로젝트에 리덕스를.. 적용해보고 싶다는 생각이 들었다.

2. Context API를 이용하여 현재 날짜의 정보를 컴포넌트들에 제공해보았다.

  - 데이터 통신이 아닌 내부 상태의 공유이기 때문에 Context의 사용이 적절하다고 생각했다. 
  
  - 사용하면서 배운 것은 잦은 데이터의 전송이 Context를 통해 이루어지면 좋지 않기에, redux와 같은 상태 관리 라이브러리를 사용하는 것이 권장된다.

3. Material-UI의 사용과 JS 내에서의 CSS 작성 

  - Material-UI에서는 이제 JSS(CSS의 작성을 JavaScript에서 하도록 도와주는 도구)를 사용하는 시대가 도래할 것이라고 다큐멘테이션에 언급했다.

  - 인라인 스타일과 CSS in JS는 다른 것이다!

  ```js

    // 예를 들어보면, 인라인 스타일 작성 시 

  const textStyles = {
    color: white,
    backgroundColor: black
  }

  <p style={textStyles}>inline style!</p>

  // 위의 결과는 아래와 같이 DOM node에 작성할 것이다 

  <p style="color: white; backgrond-color: black;">inline style!</p>


  // 하지만 JSS에서는,

  import styled from 'styled-components';

  const Text = styled.div`
    color: white,
    background: black
  `

  <Text>Hello CSS-in-JS</Text>

  // 이렇게 작성하면 DOM node에는,

  <style>
  .hash136s21 {
    background-color: black;
    color: white;
  }
  </style>

  // 이렇게 작성이 될 것이다!

  <p class="hash136s21">Hello CSS-in-JS</p>
  ```

  - 컴포넌트 내에 CSS를 작성하는 것이니 다른 CSS 스타일들과 혼동 될 일이 적을 것이라는 장점이 있다.


