# Github 특강 09-05-18

---
## 박조은 강사님 말씀

- 오류를 경험하고 그를 통해 배우자.
- 튜토리얼을 잘 활용하자.
- 다른 사람의 코드를 많이 따라 써보면 좋다.
- 책에서 본 코드도 따라 써보기.

- 오프라인 스프린트를 통해 오픈소스에 기여
  - [오픈소스기여](https://opensource.guide/ko/how-to-contribute/#why-contribute-to-open-source)

- 블로그의 필요성

- 깃헙 튜토리얼이 너무 어렵다면 잘 만들어진 테마를 포크해 오는 것만으로도 정적 블로그를 만들 수 있다.

- svn 보다 git이 더 나은 이유?
  - svn -> 네트워크에 연결이 되어 있어야 한다.
  - git은 그럴 필요 없이 commit을 할 수가 있다.

- **commit log도 중요하다.**
  - commit log : create(현재형으로) git.md
  - description 작성도 중요.

---

## github setting

- profile picture은 무엇이라도 올리는 것이 좋다.
- Wiki`tap`에다가 정리도 가능

- ssh key를 통해 github에 생성된 저장소와 local 저장소를 연결한다.
  - [이와 관련 도움 문서](https://help.github.com/articles/checking-for-existing-ssh-keys/) 
  - [새로운 ssh 키 등록이 자세히 설명된 블로그](http://nickjoit.tistory.com/94)

- ssh 통신을 사용하여 push 하고 pull하는 것이 제일 안정적이다.

- 클론의 ssh 주소를 복사한 뒤 그 폴더가 생성되기 위한 디렉토리에서 git clone <clone 주소>를 복사해오면 알아서 생성된다.
  - 이렇게 생성했을 경우에는 git pull을 사용하지 않아도 up to date 되어 있다.

- git config --global user.name & git config --global user.email
  - 사용자 정보 설정.
- git config --list 
  - 설정한 모든 리스트들이 나열된다.
- git remote -v
  - 원격저장소의 위치 확인 가능.

- local 저장소를 삭제하기 위해서는
  - rm -rf .git

- git pull 혹은 git fetch + git merge로 원격저장소의 내용을 로컬로 불러올 수 있다.
  - git pull -rebase origin master

## 팀 프로젝트 혹은 오픈소스에서 깃헙을 사용할 때
- pull request를 사용해서 마스터에게 자신의 소스코드를 받아달라고 요청을 보낸다.

## branch는 왜 사용할까요?
- 협업을 쉽게 해주는 기능
- [쉽게 설명되어있는 블로그](https://backlog.com/git-tutorial/kr/stepup/stepup1_1.html)

- branch 명은 이슈번호 혹은 JIRA 등 협업 툴에 있는 티켓번호를 포함한다.

- git push u- upstream master
  - fork를 해온 소스에 push하려고 할 때

- git stash
  - upstream 혹은 origin의 최신 소스를 가져오고 싶은데 내 저장소의 내용이 커밋되지 않을 때 :
    - git stash를 사용해 임시로 저장해 둔 뒤에 git stash pop으로 꺼낼 수 있다.

## commit 메세지 작성의 중요성
1. 제목과 본문을 빈 행으로 분리한다
2. 제목 행을 50자로 제한
3. 제목 행 첫 글자는 대문자로 쓴다
4. 제목 행 끝에 마침표를 넣지 않는다
5. 제목 행에 명령문을 사용한다
6. 본문을 72자 단위로 개행한다
7. 어떻게 보다는 무엇과 왜를 설명한다

- git commit --amend : 마지막 커밋 수정
- git rebase -i HEAD~3 : 커밋메세지 여러개 수정(이전 3개의 메세지를 수정할 때의 예)


## git fork

- git guide fork 하기
  - fork 한 후에 나의 페이지에 와서 클론을 하고 싶은 파일을 클론 주소 복사하여 내 로컬에 저장한다.
  - 그 후에 해당 폴더에 가서 git remote add upstream <클론 주소>를 저장해준다.
  - git pull --rebase upstream master를 하면 최신 정보를 가져올 수 있다.
  