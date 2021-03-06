### 질문에 답을 하지 못했던 것들이나 그로 인해 궁금해진 것들

---

## `typeof` 사용의 장점과 단점 - [도움 된 문서](http://tobyho.com/2011/01/28/checking-types-in-javascript/)
  
`typeof`는 자바스크립트 값의 타입을 반환해준다. 하지만 `[]`의 `typeof`를 보면 `object`가 반환된다. 그렇다면... `null`의 타입을 체크해보았을 때에도 `object`가 반환된다! `typoeof`는 날짜, 정규표현식, 사용자가 직접 정의한 객체들, DOM 요소들 그리고 대부분의 다른 것들을 `object`라고 반환할 것이다. 

그렇기 때문에 `typeof` 연산자는 원시타입(primitive value) 값들을 비교할 때는 유용하나 객체들을 비교할 때는 무용지물이 된다(array와 null을 포함).

### instanceof

`instanceof` 연산자는 객체가 특정 생성자의 인스턴스가 맞는지를 확인할 수 있다.
```js
function Animal(){}
var a = new Animal()
a instanceof Animal // true
```

하지만 이러한 확인법도 두가지의 문제점이 있는데, 하나는 프로토타입 체인에 제대로 연결되지 않는다는 점과, 또 하나는 `null`과 `undefined`에 대하여 제대로 작동하지 않는다는 점이다. 그리고!!! instanceof 는 원시타입의 값들과 작동하지 않는다. 

### Object.prototype.toString 

`Object.prototype.toString`을 통한 타입 확인 방법이 있다.  

### Function.prototype.toString 

---

## 원시 타입(primitive type)과 참조 타입(reference type)

여기서 참조(reference)란, 객체가 컴퓨터 메모리 상에서 어디에 저장되었는지를 가리키는 값. 

### 객체의 같음 (Equality)

```js
{prop: 1} === {prop: 1}; // false
[1, 2, 3] === [1, 2, 3]; // false
```

위의 등호 연산자는 객체의 내용을 비교하는 것이 아니라 객체의 참조를 비교한다. 객체는 매 번 새로 생성되어 각각 메모리의 다른 위치에 저장된다. 내용이 똑같아 보이는 두 객체일지라도 그에 대한 참조는 서로 다른 것이다.



---
## truthy, falsy에 관하여 

- false
- null
- undefined
- 0
- NaN
- ''

위의 것들을 제외한 모든 값들은 truthy.


---

자료구조 - 스택, 큐, 트리...

---

## 동기, 비동기 

동기식 프로그래밍(synchronous programming)
  - 어떤 일이 완료될 때까지 코드의 실행을 멈추고 기다리는 프로그래밍 방식 



비동기 프로그래밍(asyncronous programming) 
  - 어떤 일이 완료되기를 기다리지 않고 다음 코드를 실행해 나가는 프로그래밍 방식 
  - 대게 프로그램의 성능과 응답성을 높이는 데에 도움을 준다. 하지만 코드가 실제로 실행되는 순서가 뒤죽박죽이 되므로, 코드의 가독성을 해치고 디버깅을 어렵게 만든다.
  - 콜백, 프로미스 

프로미스 - [출처](http://blog.majestybbong.org/2017/12/04/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EB%8F%99%EA%B8%B0-%EB%B9%84%EB%8F%99%EA%B8%B0/)
  - 콜백 함수들로 이루어진 것.
  - 함수의 실행 시점을 기존 콜백 방식보다 간단하게 제어할 수 있는 자바스크립트 패키지.
  - 개발자가 원하는 함수의 실행 시점을 기존 콜백 방식보다 간단하게 제어할 수 있는 자바스크립트 패키지.

### Ajax

웹 브라우저에서 XMLHttpRequest 혹은 fetch 를 이용해서 보내는 HTTP 요청을 통칭하기도 한다.

#### HTML Form 에서 제일 자주 쓰이는 5 가지 메소드들:

데이터를 관리하는 프로그램을 만들 때,
**CRUD (Create Read Update Delete)**의 요소가 무조건적!!

무언가를 만들 때(create) - POST
무언가를 읽을 때(read) - GET
수정할 때(update) - PUT, PATCH
삭제할 때 (delete) - DELETE

#### Ajax 의 장점

- 화면 전체를 다시 로드하지 않고도 내용을 갱신할 수 있어 더 나은 사용자 경험 제공.
- 서버의 응답을 기다리는 동안에도 여전히 웹 어플리케이션을 사용 가능.
- 필요한 자원만 서버에서 받아오게 되므로 트래픽이 줄어듬.

#### Ajax 의 단점

- 클라이언트 구현이 굉장히 복잡해진다.
---

### CORS

#### Same-origin Policy (동일 출처 정책)

- 웹페이지에서 리소스를 불러올 때, 리소스의 출처가 웹페이지의 출처와 같으면 안전하다고 보고, 출처가 다르면 해당 리소스는 안전하지 않다고 보는 원칙.
- **여기서 '출처'란 '프로토콜 + 도메인 + 포트번호'의 결합을 가리킴. 즉, 세 개가 다 같아야 동일 출처라고 할 수 있고, 셋 중에 하나라도 다르면 동일 출처로 간주되지 않음**
- 웹 보안의 기본 원칙으로, 웹 브라우저의 많은 요소에 적용됨.

---

프론트엔드에서 성능 개선은 어떻게 이루어질 수 있나 - [출처](https://12bme.tistory.com/127)

웹 서비스의 반응 속도를 개선할 수 있는 가장 효과적인 방법은 네트워크 속도의 개선이지만, 이는 단기간에 이루기 힘들기 때문에 네트워크의 사용량을 줄이고 브라우저에서 웹페이지의 실행 속도를 높여 반응 속도를 개선할 수 있다.
  - 웹 페이지 최적화는 브라우저가 네트워크와 통신하는 과정은 물론 브라우저에서 페이지를 표시하는 과정에서의 응답 속도를 개선하는 것이다.


---

## 모던 웹 서비스의 구성요소

### Cookie

서버가 브라우저에게 보내는 전송

#### 쿠키의 필요성

개발 클라이언트의 여러 요청에 걸친 정보의 유지

- 장바구니
- 로그인/ 로그아웃
- 방문 기록

#### HTTP Cookie

- 서버가 응답을 통해 웹 브라우저에 저장하는 이름+값 형태의 정보
- 웹 브라우저는 쿠키를 저장하기 위한 저장소를 가지고 있음
- 저장소는 자료의 유효기간과 접근 권한에 대한 다양한 옵션을 제공

#### 쿠키 전송 절차

1. 서버는 브라우저 저장하고 싶은 정보를 응답과 같이 실어 보낸다(set-Cookor 헤더)

```js
HTTP/1.1 200 OK
Set-Cookie: cookieName=cookieValue; Secure; Max-Age=60000
...
```

- 브라우저는 같은 서버에 요청이 일어날 때마다 해당 정보를 요청에 같이 실어서 서버에 보낸다 (Cookie 헤더)

```js
GET / HTTP/1.1
Cookie: cookieName=cookieValue; anotherName=anotherValue
...
```

#### set-Cookie Options

Expires, Max-Age

- 쿠키의 지속 시간 설정

Secure

- HTTPS 를 통해서만 쿠키가 전송되도록 설정.

HttpOnly

- 자바스크립트에서 쿠키를 읽지 못하도록 설정

Domain, Path

- 쿠키의 scope 설정(쿠키가 전송되는 URL 을 제한)

자바스크립트에서 쿠키에 접근하지 못하도록 HttpOnly 를 항상 설정하는 것이 best practice 이다.

**자바스크립트로는 쿠키를 건드리지 않는 것이 좋다**

#### 쿠키의 한계점

- US-ASCII 밖에 저장하지 못함. 보통 percent encoding 을 사용
- 4000 바이트 내외(영문 4000 자, percent encoding 된 한글 444 자 가량)밖에 저장하지 못함
- 브라우저에 저장됨. 즉, 여러 브라우저에 걸쳐 공유되어야 하는 정보, 혹은 웹 브라우저가 아닌 클라이언트(모바일 앱)에 저장되어야 하는 정보를 다루기에는 부적절

#### 쿠키가 사용되는

사람의 정보 - 로그인, 로그아웃.
인증토큰을 주로 쿠키에 저장한다.
쿠키는 정통적 웹개발에서 많이 쓰인다.


### Access Token & JWT

#### 쿠키의 단점

- 쿠키를 지원하는 클라이언트에서밖에 사용할 수 없음
- 적절히 관리되지 않은 쿠키는 보안에 취약하며, 관리를 하려고 해도 CORS 대응이 복잡함

#### Token Based Auth

- 토큰이란, 사용자의 자격증명(아이디, 패스워드 등)을 통해 인증이 이루어진 후, 특정 자원에 대한 자격증명으로서 대신 사용되는 인증 수단
- 서버에 요청을 할 때마다 토큰을 요청에 직접 포함시켜서 전송 (주로 Authorization 헤더에 넣어서 전송)

#### 토큰 사용의 장점

- 쿠키를 지원하지 않는 클라이언트에서도 편하게 사용할 수 있음
- 쿠키를 사용하지 않음으로써 CORS 관련 문제를 회피할 수 있음

#### 토큰 사용의 단점

- 매 요청에 토큰이 포함되게 되므로 적당히 짧은 길이를 유지해야 함
- 토큰 유출에 대한 대비책이 필요 (토큰에 유효기간을 두거나, 유출된 토큰을 강제로 무효화하는 등의 방법을 사용)
- 쿠키와는 다르게, 클라이언트 개발자가 직접 토큰을 저장하고 관리해야 함

쿠키를 사용하던 로컬스토리지를 사용하던, 이들을 브라우저에 저장하고 있다가 로그인할 때 가져다 사용하는 방식이다.

---

## TDD가 무엇인가? (test driven development) - [출처](https://nesoy.github.io/articles/2017-01/TDD)

소프트웨어 개발 절차로써 매우 짧은 개발 사이클들의 반복(테스트 케이스들을 만들고 그 테스트 케이스들을 통과해야만 한다)에 의존한다. 

실패하는 테스트를 만들고(RED), 테스트에 통과할 만한 작은 코드를 작성하고(GREEN), 반복되는 코드, 긴 메소드, 큰 클래스, 긴 매개변수 목록 등을 좀 더 효율적으로 바꾸는 작업을 한다(REFACTOR).

---

axios는 무엇이며 그 전에는 무엇이 존재? 

### Fetch API

웹 브라우저의 XMLHttpRequest 를 대체하기 위해 만들어진 새로운 HTTP client 표준이며, 비교적 최근에 도입되어 IE 및 구형 안드로이드 브라우저(4.x)는 지원하지 않는다.

최신 문법을 옛날 문법으로 바꿔주는 것이 트랜스파일러이다. 새로운 기능(최신 브라우저 기능)을 사용하고 싶으면 폴리필이라는 라이브러리를 사용해서 이용해야 한다.

#### Axios vs Fetch API

- Axios 는 여러 편의기능(instance 와 같이 설정을 재사용하거나 요청중인 연결을 취소하는 등)을 제공한다.
- 다만, Axios 는 내부적으로 XMLHttpRequest 를 사용하고 있는데 Service Worker 등의 최신 기술이 XMLHttpRequest 를 지원하지 않으므로, Service Worker 를 사용할 예정에 있는 프로젝트에서는 Axios 대신 Fetch API 를 사용해야만 한다.


--- 

**MVC PATTERN**

model view controller의 약자로 개발을 할 때 3가지로 역할을 나누어 개발하는 방법론이다.

`model`은 웹 사이트가 무엇을 할 것인지의 정의 - 처리되는 알고리즘, DB, 데이터 등

`controller`는 모델이 어떻게 처리할 지를 알려주는 것 - 화면의 로직 처리 부분, model과 view를 연결시켜주는 역할. 

`view`는 화면에 무엇인가를 보여주기 위한 것. `controller` 밑에 종속되어 model이나 controller가 보여주려고 하는 모든 것들을 보여줄 것. 사용자의 입력을 받아서 모델의 데이터를 업데이트 한다.

MVC의 한계 
  - 뷰와 모델이 서로 의존성을 띄게 된다.
  - 다수의 view와 model이 의존성을 띄어 복잡하게 연결되면 controller가 커지게 되어 수정 시 테스트가 힘들고 부작용을 일으킬 수 있는 문제점들이 발생.

문제점을 보완한 파생된 패턴들 
- MVP, MVVM, Viper, Clean Architecture, Flux, Redux, RxMVVM….

---

감명깊게 본 UX 사이트 

---

SEO, SPA, PWA(such as geolocation? or mobile related features that are applied to computer web)

### SEO(serach engine optimization)

>검색 엔진 최적화 (영어: search engine optimization, SEO)는 웹 페이지 검색엔진이 자료를 수집하고 순위를 매기는 방식에 맞게 웹 페이지를 구성해서 검색 결과의 상위에 나올 수 있도록 하는 작업을 말한다. 웹 페이지와 관련된 검색어로 검색한 검색 결과 상위에 나오게 된다면 방문 트래픽이 늘어나기 때문에 효과적인 인터넷 마케팅 방법 중의 하나라고 할 수 있다. 기본적인 작업 방식은 특정한 검색어를 웹 페이지에 적절하게 배치하고 다른 웹 페이지에서 링크가 많이 연결되도록 하는 것이다. 

### SPA(single-page application)
>싱글 페이지 애플리케이션(single-page application, SPA, 스파)은 서버로부터 완전한 새로운 페이지를 불러오지 않고 현재의 페이지를 동적으로 다시 작성함으로써 사용자와 소통하는 웹 애플리케이션이나 웹사이트를 말한다. 이러한 접근은 연속되는 페이지들 간의 사용자 경험의 간섭을 막아주고 애플리케이션이 더 데스크톱 애플리케이션처럼 동작하도록 만들어준다. SPA에서 HTML, 자바스크립트, CSS 등 필요한 모든 코드는 하나의 페이지로 불러오거나, 적절한 자원들을 동적으로 불러들여서 필요하면 문서에 추가하는데, 보통 사용자의 동작에 응답하게 되는 방식이다. 문서는 프로세스 중 어떠한 지점에서도 다시 불러들이지 않으며 다른 문서로 제어권을 넘기지 않으나, 위치 해시나 HTML5 히스토리 API를 사용하여 애플리케이션 안에서 개개의 논리 문서의 인식 및 탐색을 제공할 수 있다. 싱글 페이지 애플리케이션과의 소통은 뒷편에 있는 웹 서버와의 동적인 통신을 수반하기도 한다.

### PWA(progressive web app)
[출처](https://developers.google.com/web/fundamentals/codelabs/your-first-pwapp/?hl=ko)

>Progressive Web App은 웹의 장점과 앱의 장점을 결합한 환경입니다. 이것은 사용자가브라우저 탭을 맨 처음 방문할 때부터 유용하며, 설치가 필요 없습니다. 시간의 흐름에 따라 사용자가 앱과의 관계를 점진적으로 쌓아갈수록 성능이 더욱 강력해질 것입니다. 이 웹 앱은 느린 네트워크에서도 빠르게 로드되고, 관련된 푸시 알림을 전송하며, 홈 화면에 아이콘이 있고, 최상위의 전체 화면 환경으로 로드됩니다.

- Progressive Web App의 특징은 다음과 같습니다.
```
프로그레시브 - 점진적인 개선을 통해 작성되므로, 어떤 브라우저를 선택하든 상관없이 모든 사용자에게 적합합니다.
반응형 - 데스크톱, 모바일, 태블릿 등 모든 폼 팩터에 맞습니다.
연결 독립적 - 서비스 워커를 사용하여 오프라인이나 느린 네트워크에서 작동하도록 향상됩니다.
앱과 유사 - 앱 셸 모드에서 작성되기 때문에 앱 스타일의 상호작용 및 탐색 기능을 사용자에게 제공합니다.
최신 상태 - 서비스 워커 업데이트 프로세스 덕분에 항상 최신 상태로 유지됩니다.
안전 - HTTPS를 통해 제공되므로 스누핑이 차단되며, 콘텐츠가 변조되지 않도록 보장합니다.
검색 가능 - W3C 매니페스트 및 서비스 워커 등록 범위 덕분에 '애플리케이션'으로 식별되므로, 검색 엔진에서 검색이 가능합니다.
재참여 가능 - 푸시 알림과 같은 기능을 통해 쉽게 재참여가 가능합니다.
설치 가능 - 앱 스토어에서 씨름할 필요 없이 사용자가 자신에게 가장 유용한 앱을 홈 화면에 유지할 수 있습니다.
링크 연결 가능 - URL을 통해 손쉽게 공유할 수 있으며 복잡한 설치 작업이 불필요합니다.
```

---

**CSS 모듈의 장점**
 - 이름 충돌의 걱정을 할 필요 없다 -> 알아서 서로 다른 클래스 이름으로 변환된다.

CSS 모듈 사용 시
 - `import styles from './Button.module.css';`식으로 임포트 할 때(객체로 저장 됨) styles.error(파일 안에 작성 된 CSS)과 같은 방식으로 사용될 수 있다.
 - 저 객체 안에는, 속성 이름에는 내가 쓴 클래스 이름, 속성 값 부분에는 변환된 클래스 이름이 들어간다.
 
 - `-`이 사용될 시 class이름에 대괄호 표기법을 사용하는 번거로움이 있으니, 여기서는 카멜 케이스로 이름을 작성해 주자.

---

React
  - 사용자가 많다
    신용있는 관련 자료들 혹은 관련 써드 파티 프로그램의 파생 ? 

HTTP method? 

---

버전 관리에는 무엇이?

git을 사용해봤으며 git은 저장소가 자신의 컴퓨터(local)에 있다. git에서는 원격 저장소를 만들 수 있다. 내 컴퓨터에 저장되어 있는 작업들을 add, commit한 후에 원격 저장소로 push할 수 있다.

git은 저장소가 분산되는 구조를 가지고 있어 분산버전관리 시스템이라고 한다(DVCS).

git 장점
- 브랜치 모델
  - 테스트하고 돌아가거나, 병합하기 쉽다 
- 속도, 성능 
- 분산작업 
- 스테이징 단계 

---

`===, == 차이`
 값이 없다고 명시한 null
 ```js
  값이 없는 undefined가
	null == undefined // true
	null === undefined // false.
 ```


---

가상 돔
```
 뷰view 모델에서 발생하는 변경사항을 메모리에서 관리하는 논리적DOM에서 먼저 감지 한 후 실제 DOM의 업데이트를 최소화하여 성능을 향상시키고 UX측면에서 발생하는 문제를 줄임
			 
 => 기존의 비싼 비용의 Native DOM 처리를 JavaScript 상의 diff 알고리즘을 통해 저렴한 비용으로 효율적인 처리가 가능해짐
 ```

---

npm은 무엇인가요?
- npm (노드 패키지 매니저/Node Package Manager)은 자바스크립트 프로그래밍 언어를 위한 패키지 관리자이다. 자바스크립트 런타임 환경 Node.js의 기본 패키지 관리자이다. 
---

클로저는 무엇인가요 ?
- 클로져는 함수 안의 또 다른 함수를 이용해 하나의 독립된 스코프를 생성하는 메카니즘이다.

```js
function counter() {
  let count = 0

  function add() {
    count++
  }
  return add
} 

const increaseNum = count()

increaseNum()
```

---
var, let, const의 차이는 무엇인가요? 
  - 재대입, 재선언 등의 용어를 사용한 설명!

|    | const | let | var |
| --- | --- | --- | --- |
| 스코프 | 블록 | 블록 | 함수 |
| 재대입 | X | O | O |
| 재선언 | X | X | O |
|호이스팅| X | X | O |
|사용 권장| 1 | 2 | 3 |

---




화살표 함수와 일반 함수의 차이는 ?
  - 화살표 함수로 정의될 수 있는 것은 일반 함수로도 가능, 하지만 그 반대는 되지 않는다.

---


map, reduce 등을 사용하지 못하면?
  - for문을 사용해서 구현 



---
Ajax를 간단하게 설명하면? 

Asynchronos 

'비동기적'이라는 것은, 클라이언트에서 서버에 요청을 보낼 때 요청을 보내놓고 프로그램은 계속 돌아간다는 의미이다. 즉, 먼저 요청한 것에 대한 콜백1 함수가 먼저 실행되지 않는다는 것이다.

자바스크립트는 웹 브라우저에 대한 스크립트 언어로 만들어진 언어이다. 웹 브라우저에서 출발했기 때문에 본래 서버와 소통하는 기능은 없었으나 AJAX는 가능하다.



출처: [초보개발자의 공부공간](http://wherethelightis.tistory.com/14 )

Asynchronos Javascript And XML
		 자바스크립트를 통해서 서버에 데이터를 요청하는 것이다. HTML form 태그가 아니라 자바스크립트를 통해서! 따라서 우리는 서버에서 로딩된 데이터를 페이지에 보여주기 위해 새로운 HTML페이지로 갈 필요도 없고 '새로고침'을 할 필요가 없는 것이다. 부분 부분만 로딩되므로 속도가 빠르다.

---

**WebKit은 무엇?**

Every browser is backed by a rendering engine to draw the HTML/CSS web page.

IE → Trident (discontinued)
Edge → EdgeHTML (clean-up fork of Trident)
Firefox → Gecko
Opera → Presto (no longer uses Presto since Feb 2013, consider Opera = Chrome nowadays)
Safari → WebKit
Chrome → Blink (a fork of WebKit).

---

React

#### 불변성

내용이 변경되었을 때, 참조 역시 변경된다면 이는 불변인 값인 것이다. 불변이 아닌 값(가변)이 내용이 바뀌었는 지를 검사하는 것은 매우 비싼 연산이다. 

장점
  - 불변성을 지켜주기 위한 작업(새로운 배열의 생성 등)도 결국 비용이 발생하지만, 다른 방법들 보다는 이 작업이 비용 발생이 가장 적은 것이다.
  - 그렇기 때문에, 어떤 값의 참조가 바뀌었다고 했을 때 이를 원래 불변값과 비교하는 것은 매우 쉬운 연산이다.
  - PureComponent가 참조만 변했는지 검사하는 최적화를 시켜주는 기능이라고 볼 수 있다.

단점
  - 매번 새로운 배열, 객체를 만들어야 한다 -> 메모리 공간을 많이 차지한다.
  - 위의 이유로 속도도 느려진다.
  - 위의 이유들로 성능이 좋지 않다(게임등을 만들 시에는 불변을 사용하지 않는다).

  ---