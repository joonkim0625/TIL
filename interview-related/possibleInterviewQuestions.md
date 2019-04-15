## BMP, JPG, PNG 각각의 특징에 대해서 설명하라.

몇 가지 개념들

Raster(Bitmap) vs. Vector ([출처](http://jinyongjeong.github.io/2016/05/29/image_type/))

```
Raster(Bitmap) : Raster 이미지는 전체 그림을 구성하는 '픽셀' 데이터의 배열을 통해 이미지를 형성 및 저장한다. 이는 대부분의 디지털 이미지가 사용하는 방식이지만, 본래 정해진 크기 이상으로 확대하면 곡선고 대각선에서 aliasing이라 불리는 계단현상이 일어날 수 있다. 

Vector : Vector 이미지는 기준점에서 수학적인 벡터 좌표법으로 이미지를 형성하고 저장하는 방식이다. 수학적 계산에 근거한 상대좌표 데이터이기 때문에 확대나 축소를 해도 이미지가 깨지는 현상이 없다. 하지만 이러한 특징은 실사 사진에는 적합하지 않다.
```

Lossy vs Lossless compression ([출처](https://www.thewindowsclub.com/png-jpg-gif-bmp-tif-image-file-formats))

**Lossy compression** 

  이미지를 효과적으로 압축할 수 있으나, 모든 정보를 인코딩하지 않기 때문에 이미지로 복원(압축의 해제)되었을 때 원본과 똑같이 표현되지는 않는다. 실사에는 적합하나 그림이나 illustration 등에는 적합하지 않다. 이 경우는 압축을 할수록 이미지의 퀄리티는 손상이 된다.

**Losslss compression** 

  원본으로부터 모든 정보를 인코딩하기 때문에 압축을 풀게 되었을 때 원본과 똑같게 복원된다. 즉, 이미지 퀄리티의 손상이 없다.

---
**BMP** 
 
 마이크로소프트에서 개발한 무손실 bitmap 이미지 파일 컨테이너. 윈도우 시스템에서 주로 사용된다. 주로 반복 문자열 제거라는 압축 기법을 이용한 무손실 압축 상태로 사용되기 때문에, 압축 효율은 그리 높지 못하다. 그렇기 때문에 이미지 크기에 비해 용량이 매우 큰 편이라는 단점이 있지만 반대로 호환성은 매우 높다.

**JPGm JPEG, JPE, JFIF**

  합동사진전문가단체(JPEG, Joint Photographic Exports Group)에서 지정한 정지화상을 위한 표준으로 용량대비 화질이 뛰어나다. 많은 분야에서 사용되고 있는 손실 압축 기반의 비트맵 이미지 파일 컨테이너로 RGB 신호를 그대로 사용하지 않고 비디오에서 많이 사용하는 YCbCr 방식으로 변환해 처리하는 것이 특징이다. 하지만 이런 특성 때문에 화질 설정을 최대치로 설정해도 RGB와 YCbCr을(영상 시스템에서 사용되는 색공간의 일종) 오가며 변환하는 과정에서 미미하지만 이미지 손상이 발생하며 수정을 반복하면 할수록 화질 손상이 증폭되는 단점이 있기 때문에 작업용으로 사용할 때는 주의해야 한다.

**PNG**

  PNG(Portable Network Graphics)는 W3C(World Wide Web Consortium)에서 GIF의 법적인 문제와 단점을 극복하기 위해 개발된 무손실 압축 비트맵 이미지 파일 컨테이너이다. 트루 컬러와 8비트 알파채널을 지원하면서 대부분 GIF보다 좋은 압축률을 보여 준다. 하지만 GIF처럼 애니메이션은 지원하지 않는다. 무손실 압축을 사용하기 때문에 JPEG보다는 압축 효을이 나쁘기 때문에 일반적으로 더 큰 용량을 갖게 된다.


---

## 웹페이지 Redirect의 다양한 구현법에 대해서 설명하라.

**Redirections in HTTP** ([출처](https://developer.mozilla.org/en-US/docs/Web/HTTP/Redirections))

  URL redirection(또는 URL forwarding)은 페이지, 폼 또는 전체 웹 앱에 하나 이상의 URL 주소를 주는 기술이다. HTTP는 여러가지 목적들을 위해 사용될 이 작업을 수행하기 위해 특별한 방식의 response를 제공한다.
  - 일시적인 redirection : 웹사이트가 점검 중일 때 일시적인 페이지로 redirect 시킨다
  - 영구적인 redirection : 사이트의 구조를 바꾼 뒤에 외부 링크들을 계속 작동시키기 위해
  - 파일 업로드 시에 진행 상태 페이지로의 이동

Redirect 방법들을 알아보자 ([출처](https://www.hostgator.com/blog/ways-redirect-website-url/)). 

**301 Redirect**

  Redirect는 검색 엔진과 웹사이트 사용자들에게 해당 페이지나 인덱스가 더 이상 존재하지 않는다는 것을 알려주는 가장 효율적인 방법 중 하나이다. 이런 상황에서, redirect는 404 에러를 발생시키지 않고 새로운 페이지로 이동을 시켜줄 수 있게 해준다.





**302 Redirect**

  302 redirect가 301 redirect와 다른 점은 301 redirect는 주소의 영구적인 이동을 뜻하는 반면, 302 redirect는 일시적인 이동을 뜻한다.

**Meta Refresh**

  Meta refresh는 서버 레벨의 redirect보단 페이지 레벨에서의 redirect라고 볼 수 있다. 이 방법은 대게 좀 더 느리고, SEO를 고려한다면 추천되지 않는 방법이다. 이 방법은 '만약 5초 안에 rediret되지 않는다면, 여기를 클릭하세요.'등의 문구와 가장 흔하게 사용된다. Meta refresh도 약간의 link equity(ranking power)를 통과하기는 하나, 위에 언급되었던 것 처럼 안좋은 사용성과 link equity를 충분히 통과하지 못하기 때문에 추천되지 않는 방법이다.
   


## Unicode와 UTF-8에 대해서 설명하라 - [출처](https://medium.com/@jeongdowon/unicode%EC%99%80-utf-8-%EA%B0%84%EB%8B%A8%ED%9E%88-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-b6aa3f7edf96).

**Unicode**

  유니코드는 국제적으로 전세계 언어를 모두 표시할 수 있는 표준코드이다. 유니코드는 글자와 코드가 1:1로 mapping되어 있는 '[코드표](https://ko.wikipedia.org/wiki/%EC%9C%A0%EB%8B%88%EC%BD%94%EB%93%9C_%EC%98%81%EC%97%AD)'이다. 

**UTF-8**

  UTF-8은 유니코드를 인코딩하는 방식이다. 유니코드는 가변 인코딩방식, 즉 글자마다 byte 길이가 다르다는 것이다. 예를 들어, 'a'는 1 byte이고 '가'는 3 byte이다. 가변을 구분하기 위해 첫 바이트에 표식을 넣었는데, 2 byte는 110으로 시작하고 3 byte는 1110으로 시작한다. 나머지 바이트는 10으로 시작한다.

- 유니코드는 국제표준 문자표이고 UTF-8는 이 유니코드를 인코딩하는 방식이다.

## Map/Reduce에 대해서 설명하라. 
[출처](https://helloworldjavascript.net/pages/190-array.html)

**Map** 

  반복문을 돌며 배열안의 각 요소들을 1대1로 짝지어 주는 것이다. 그리고 기존 객체를 수정하지 않는다. 이 뜻은 반환값을 요소로 갖는 새로운 배열을 만든다는 것이다. forEach와 비슷하지만, 새로운 배열을 만든다는 점이 다르다.

**reduce**

  모든 요소의 값을 종합해서 하나의 값으로 계산한다. 배열의 많은 메소드들이 reduce를 통해서 다시 구현될 수 있다.

## CSS의 다양한 Selector들에 대해서 설명하라.

  [당신이 알아야하는 20가지 CSS 선택자들](https://designtheway.com/20-css-selectors-you-must-know/)

  1. A + B
  ```css
  div + span{
  color:orange;
  }
  ```
  
  인접한 형제 선택자를 가리킨다. 이는 안에 선언된 선택자가 아닌, 첫 요소 다음에 작성된 형제 레벨의 선택자를 가리킨다.


  2. A > B
  ```css
  div > p{
  background:#000;
  color:#fff;
  }
  ```

  이것은 자식 선택자라고 불리며, 선택된 요소가 포함하는 바로 다음에 오는 자식 선택자들을 가리킨다. 
  
  ```html
  <div>
  <p>I am a paragraph in a div</p>
  <p>I am a paragraph in a div</p>
  <ul>
    <li><p>I am a paragraph inside li</p></li>
  </ul>
  </div>
  ```

  3. A[attribute]
  ```css
  input[type="email"]{
  border:1px solid green;
  }
  ```

  이는 속성 선택자로써, 특정된 속성을 가진 요소를 선택한다.

  ```html
  <form>
  <input type="text" placeholder="Name">
  <input type="email" placeholder="Email">
  </form>
  ```
  위의 코드는 email 타입 속성이 있는 input 태그만을 선택할 것이다.

  4. A:checked
  ```css
  input:checked + label{
  color:orange;
  }

  ```

  css3의 수도 클래스로써, 오직 체크가 된 요소들만을 가리킨다. Radio button과 checkbox에만 적용된다.


  5. A:disabled
  ```css
  input[type="email"]:disabled {
    background: #dddddd;
  }
  ```

  또 다른 css3의 수도 클래스로써, disable이 활성화 된 모든 요소들을 가리킨다. `form`을 스타일링할 때 주로 사용된다.





## Multi-Column Index에 대해서 설명하라.

  

17. 비대칭키를 사용한 암호화에 대해서 설명하라.
## Callback Hell을 피할 수 있는 방법에 대해서 설명하라.

  1. 함수들을 작성할 때, nesting을 하지말고 이름을 선언한 뒤에 프로그램 가장 맨 위에 위치시켜라. 또는 함수 호이스팅을 이용해서 함수들을 맨 아래에 작성할 수 있다.

  2. 모든 에러들을 직접 관리해라.
  ```js
   var fs = require('fs')

  fs.readFile('/Does/not/exist', handleFile)

  function handleFile (error, file) {
    if (error) return console.error('Uhoh, there was an error', error)
    // otherwise, continue on and use `file` in your code
  }
  ```

  3. 재사용 가능한 함수들을 만들어서 모듈에 넣은 뒤 사용해라. 이는 코드를 좀 더 쪼갤 수 있게 도와주고, 테스트를 작성할 때나 리팩토링을 할 때 도움을 줄 것이다.

  4. Promise 패턴을 사용한 라이브러리들을 사용하거나, ES2015에 포함된 promise를 사용한다.

## Reflow가 발생하는 이유와 방지 방법에 대해서 설명하라. [출처](https://wit.nts-corp.com/2017/06/05/4571)

  일단, reflow란 생성된 DOM 노드의 레이아웃(너비, 높이 등) 변경 시 영향받는 모든 노드(자식, 부모)의 수치를 다시 계산하여 렌더 트리를 재생성하는 작업입니다.

  **reflow를 피하거나 최소화하는 방법**

  1. 클래스 변화에 따른 스타일 변화를 원할 경우, 최대한 DOM구조 상 끝단에 위치한 노드에 추가한다.
    ```html
    <!-- 여기서는 가장 안에 nested된 div에 적용시키는 것 -->
    <html>
    <body>
        <div id="first">
    
            <div>
                <!-- div 약 100개 중첩 -->
            </div>
            <div>
                <!-- div 약 100개 중첩 -->
            </div>
            <div id="second">
              <!-- div 약 100개 중첩 -->
              <div>
                <div id="change">
                    블록
                </div>
              </div>
            </div>
        </div>
    </body>
    </html>
    ```

  2. 애니메이션이 들어간 엘리먼트는 가급적 position: fixed 또는 position: absolute로 지정한다.

    - 위치 이동을 구현한 애니메이션(넓이나 높이값 변경 등)은 reflow가 짧은 시간 내 반복적으로 일어나게 된다. 그래서 사용하지 않는 것이 가장 바람직하나 반드시 사용해야 한다면 애니메이션이 들어간 요소에 position: absolute 혹은 position: fixed 속성을 적용한다. 다른 요소에는 영향을 끼치지 않으므로 페이지 전체가 아닌 해당 요소만 reflow가 발생한다.

  3. JS를 통해 스타일변화를 주어야 할 경우, 가급적 한번에 처리한다.

  4. 인라인 스타일을 최대한 배제한다.

  5. 테이블 레이아웃을 피하는 것이 좋다.

  6. CSS 하위선택자는 필요한 만큼 정리하는 것이 좋다.

21. TypeScript의 장단점에 대해 설명하라.
## JSON Web Token에 대해 설명하라. [참고](https://velopert.com/2389)

  JSON Web Token이란:

    JSON Web Token (JWT) 은 웹표준 (RFC 7519) 으로서 두 개체에서 JSON 객체를 사용하여 가볍고 자가수용적인 (self-contained) 방식으로 정보를 안전성 있게 전달해준다.


## 프론트엔드 개발이 Functional로 가고 있는 이유를 설명하라. [참고](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#programs-are-written-at-a-higher-level-and-are-therefore-easier-to-comprehend)

  어느 언어를 사용하던, functional 프로그래밍이 줄 수 있는 장점은:

  1. 순수 함수들은 이해하기가 더 쉽다(데이터 통신이나 숨겨진 인풋들이 없기 때문에).
  2. 테스트 하기가 더 쉽고, 순수 함수들은 property-based 테스트에 적합하다.
  3. 디버깅이 쉽다.
  4. 프로그램이 더욱 탄탄해진다(변수 충돌 혹은 불변 관련 등 문제들을 방지)
  5. 이렇게 작성된 앱은 당연히 이해하기 더 쉽다. 
  6. 순수 함수들은 의미가 있다(다른 부작용들이 없기 때문에 어떤 기능이나 부작용에 대한 추측을 할 필요가 없다).
  7. 평행적/공존적 프로그래밍이 작성하기 더 쉽다.


## apk 파일 내부 구조에 대해서 설명하라.
## HTTP/2에 대해서 설명하라. [참고](https://developers.google.com/web/fundamentals/performance/http2/?hl=ko) 

  HTTP/2는 이전에 애플리케이션 내에서 수행되던 상당수의 HTTP/1.1 임시 방편을 실행취소하고 이러한 문제를 전송 계층 내에서 해결할 수 있도록 함으로써 애플리케이션을 더 빠르고, 단순하고, 강력하게 만들어준다. 게다가 애플리케이션을 최적화하고 성능을 개선할 수 있는 새로운 기회를 다양하게 제공한다.

26. Android 또는 ios의 GC의 동작에 대해서 설명하라.
27. JS Profiler를 사용한 경험에 대해서 얘기하라.
28. 선형 변환에 대해서 설명하라.
29. B+ Tree에 대해서 설명하라.