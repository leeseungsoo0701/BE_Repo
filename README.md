# Backend_Repo


### 📬커밋 종류
> 수정한 종류에 따라 커밋 메시지를 선택

|메시지명|설명|
|---|---|
|feat|새로운 기능 추가 관련|
|fix|버그 수정|
|test|테스트 코드, 리팩토링 테스트 코드 추가|
|refactor|코드 리팩토링(기능향상)|
|chore|빌드 업무 수정, 패키지 매니저 수정|
|docs|문서 수정(md, git관련 파일, 이미지파일 수정)|
|style|코드 formatting, 세미콜론(;) 누락, 코드 변경이 없는 경우|


### 🎨이모지(Emoji)

- 🎨 : 코드의 형식 / 구조를 개선 할 때  
- 📰 : 새 파일을 만들 때  
- 📝 : 사소한 코드 또는 언어를 변경 할 때  
- 🐎 : 성능을 향상 시킬 때  
- 📚 : 문서를 쓸 때  
- 🚑 : 버그를 고칠 때
- 🔥 : 코드 또는 파일을 제거 할 때
- 🚜 : 파일 구조를 변경 할 때
- 🔨 : 코드를 리팩토링 할 때  
- ☔️ : 테스트를 추가 할 때  
- 🔬 : 코드 범위를 추가 할 때   
- 🤝 : 파일을 병합 할 때  

### 📢관련 이슈  
> 작성한 커밋과 관련된 이슈 번호를 매핑  
```
< 예시 >
[feat] 📰 add api #1
```

### 🔐보안 관련

- **(중요)** 어떠한 KEY값이나 DB 접속 정보가 포함된 커밋을 날리지 않는다.

<br>

## 🌳Branch / PR / Issue 규칙

### Branch

- `main` 브랜치에서는 버젼 배포 외에는 작업하지 않는다.
- 브랜치 이름은 `feature-1` 이런 식으로 이슈의 번호를 명시해서 생성한다.
- `devlop` 브랜치에는 이슈단위로 기능이 구현한후에 코드리뷰후 PR한다.
- 테스트 브랜치나 더이상 안쓰는 브랜치는 삭제한다.

### Pull Request

- `develop` 브랜치에만 merge한다.
- 자신이 계획한 기능이 완료됐을 경우에만 PR 작성
- 팀원과 협의 후 PR을 작성하며 독자적으로 PR 생성 후 merge하지 않는다. 

### Issue

- 앞으로 할 일이나 버그 등을 기록한다.

<br>
