# 항해 ING_V2
항해 ING_V1에 로그인/회원가입 기능과 댓글 기능을 추가였습니다
<details>
<summary><a href="https://github.com/hyemco/hh99_diary">항해 ING_V1</a></summary>
<div markdown="1">
  
 # 항해 ING
 + 항해99의 여정을 기록하고 공유하는 공간입니다.

<br>

# 설명
+ 처음으로 스프링부트를 이용하여 CRUD 기능이 포함된 웹서비스를 만들었습니다
+ 이름 : 항해 ING
+ 개발 인원 : 1명
+ 개발 기간 : 2022.3.19 ~ 2022.3.23
+ 구현 기능 : 게시글 CRUD, 전체 게시글 조회
+ Thymleaf를 이용한 페이지 이동

<br>

<h2> 📌 API 설계 📌 </h2>

![image](https://user-images.githubusercontent.com/98294357/159862014-526ada47-d55d-49c8-81a8-bc7f11b6d9a3.png)

<br>

<h2> 📷 화면 구현 📷 </h2>

**첫 페이지**
+ 전체 일지 조회
+ 일지 삭제

<img src="https://user-images.githubusercontent.com/98294357/159818456-754edd1e-032a-44ac-9665-a5a0fb2fa6db.png" width="800px">

**일지 작성 페이지**
+ 일지 작성
+ 일지 저장

<img src="https://user-images.githubusercontent.com/98294357/159818641-817494be-7e0f-404f-846f-6e29bd81656c.png" width="800px">

**상세 페이지**
+ 일지 상세 조회
+ 일지 수정
+ 일지 삭제

<img src="https://user-images.githubusercontent.com/98294357/159818781-ca4c4435-f261-4792-ab7f-89d9231925bb.png" width="800px">

<br>

<h2>🛠 사용한 기술 🛠</h2>

<h4>언어</h4>
<p float="left">
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=CSS&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
</p>

<h4>프레임워크 / 플랫폼 / 라이브러리</h4>
<p float="left">
<img src="https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white">
</p>

<h4>에디터</h4>
<img src="https://img.shields.io/badge/IntelliJ IDEA-143?style=for-the-badge&logo=IntelliJ IDEA&logoColor=black&color=black&labelColor=brightgreen">

<h4>관리 툴</h4>
<p float="left">
<img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/Notion-ff00ff?style=for-the-badge&logo=Notion&logoColor=white">
</p>

<h4>데이터베이스</h4>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

<h4>호스팅<h4><img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white">
</div>
</details>  
<br>  
  
# 요구사항
<details>
<summary>스프링 숙련 주차 요구사항</summary>
<div markdown="1">
 
  1. 회원 가입 페이지
     - 회원가입 버튼을 클릭하기
     - 닉네임, 비밀번호, 비밀번호 확인을 입력하기 (O)
     - 닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기 (O)
     - 비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기 (O)
     - 비밀번호 확인은 비밀번호와 정확하게 일치하기 (O)
     - 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." 라는 에러메세지를 프론트엔드에서 보여주기 (O)
     - 회원가입 버튼을 누르고 에러메세지가 발생하지 않는다면 `로그인 페이지`로 이동시키기 (O)
    

2. 로그인 페이지
    - 로그인, 회원가입 버튼을 만들기 (O)
    - 닉네임, 비밀번호 입력란 만들기 (O)
    - 로그인 버튼을 누른 경우 닉네임과 비밀번호가 데이터베이스에 등록됐는지 확인한 뒤, 하나라도 맞지 않는 정보가 있다면 "닉네임 또는 패스워드를 확인해주세요"라는 메세지를 프론트엔드에서 보여주기 (O)
    - 로그인 버튼을 눌러서 에러 메세지가 발생하지 않는다면 `전체 게시글 목록 조회 페이지`로 이동시키기 (O)


3. 로그인 검사
    - `아래 페이지를 제외하고` 모두 로그인 한 경우만 볼 수 있도록 하기 (O)
        - 회원가입 페이지
        - 로그인 페이지
        - 게시글 목록 조회 페이지
        - 게시글 조회 페이지
    - 로그인을 하지 않거나 올바르지 않은 경로로 접속한 사용자가 로그인이 필요한 경로에 접속한 경우 "로그인이 필요합니다." 라는 메세지를 프론트엔드에서 띄워주고 `로그인 페이지`로 이동시키기 (O)
    - 로그인 한 사용자가 로그인 페이지 또는 회원가입 페이지에 접속한 경우 "이미 로그인이 되어있습니다."라는 메세지를 띄우고 `전체 게시글 목록 조회 페이지`로 이동시키기 (O)


4. 소셜 로그인 기능 만들기
    - 카카오 소셜 로그인이 가능하도록 하기 (O)
   

5. 게시글 조회 페이지 > 댓글 목록 조회
    - 로그인 하지 않은 사용자도 댓글 목록 조회가 가능하도록 하기 
    - 현재 조회중인 게시글에 작성된 모든 댓글을 목록 형식으로 볼 수 있도록 하기(O)
    - 댓글 목록 위에 댓글 작성란 만들기 (O)
        - 댓글 작성에 관한 기능은 5번 요구사항으로 연결하기
    - 댓글 목록 중, 내가 작성한 댓글인 경우 댓글 수정, 댓글 삭제 버튼 만들기 (O)
        - 댓글 수정 버튼을 누르면 6번 요구사항으로 연결하기
        - 댓글 삭제 버튼을 누르면 7번 요구사항으로 연결하기
    - 제일 최근 작성된 댓글을 맨 위에 띄우기 (O)
   

6. 게시글 조회 페이지 > 댓글 작성
    - 로그인 한 사용자만 댓글 작성이 가능하도록 하기 (O)
    - 게시글 조회 페이지 하단에 댓글 내용을 입력할 수 있는 댓글 작성 버튼 만들기 (O)
    - 로그인 하지 않은 사용자가 댓글 작성란을 누르면 "로그인이 필요한 기능입니다." 라는 메세지를 띄우고 `로그인 페이지`로 이동시키기 (O)
    - 댓글 내용란을 비워둔 채 댓글 작성 버튼을 누르면 "댓글 내용을 입력해주세요" 라는 메세지를 띄우기 (O)
    - 댓글 내용을 입력하고 댓글 작성 버튼을 누른 경우 작성한 댓글을 추가하기 (O)
   

7. 게시글 조회 페이지 > 댓글 수정 
    - 내가 작성한 댓글만 수정 가능하도록 하기 (O)
    - 댓글 본문이 사라지고, 댓글 내용, 저장 버튼 생성하기 (O)
    - 댓글 내용에는 이전에 입력했던 댓글 내용을 기본 값으로 채우기 (O)
    - 수정할 댓글 내용은 비어 있지 않도록 하기 (O)
    - 저장 버튼을 누른 경우 기존 댓글의 내용을 새로 입력한 댓글 내용으로 바꾸기 (O)
   

8. 게시글 조회 페이지 > 댓글 삭제
    - 내가 작성한 댓글만 삭제 가능하도록 하기 (O)
    - "정말로 삭제하시겠습니까?" 메세지를 띄우고, 확인/취소 버튼 중 "확인" 버튼을 누른 경우 목록에서 해당 댓글을 삭제하기 (O)
    - 취소를 누른 경우 삭제되지 않고 그대로 유지하기 (O)
   

9. 회원가입 테스트 코드 작성 (△)
    - 회원가입시 구현한 아래 조건을 검사하는 테스트 코드를 작성하기
        - 닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 이루어져 있어야 합니다.
        - 비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`합니다.
        - 비밀번호 확인은 비밀번호와 정확하게 일치해야 합니다.
        - 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." 라는 에러메세지가 발생합니다.
    - 테스트 코드 실행 시 실제로는 데이터베이스에 연결되지 않도록 하기
    - 각 조건 별로 2개 이상의 테스트 케이스가 존재하도록 하기
</div>
</details>
<br>
  
<h2> 📌 API 설계 📌 </h2>
<img src="https://user-images.githubusercontent.com/98294357/161047492-09280d8c-02e1-4022-81ab-6871542f28b3.png">
<img src="https://user-images.githubusercontent.com/98294357/161047835-e9a4c9a4-c1f3-419f-ba41-f4b87e83e778.png">
<img src="https://user-images.githubusercontent.com/98294357/161047997-5c229b17-eff1-4b96-9a6f-138769f352d9.png">

<h2> 📷 화면 구현 📷 </h2>

**첫 페이지**
+ 전체 일지 조회
+ 로그인
+ 회원가입

<img src="https://user-images.githubusercontent.com/98294357/161049309-3a2a4a2c-d1bc-45f9-b22f-e251d9b20f4b.png" width="800px">

**회원가입 페이지**
+ 닉네임과 비밀번호, 비밀번호 확인을 입력받아 회원가입 진행
  + 유효성 검사 통과시 로그인 페이지로 이동
  + 유효성 검사 통과 못할시 에러 메시지

<img src="https://user-images.githubusercontent.com/98294357/161049570-6333aad5-ede2-433f-a55d-fba8604ea3e5.png" width="800px">

**로그인 페이지**
+ 소셜 로그인 기능
+ 일반 유저 로그인 기능

<img src="https://user-images.githubusercontent.com/98294357/161050035-a8aaf223-9fff-469a-93ab-c67742956169.png" width="800px">

**게시글 작성 페이지**
+ 제목, 내용 입력
+ 게시글 등록
  + 로그인 하지 않는 사용자가 게시글 등록시 로그인 페이지로 넘어감

<img src="https://user-images.githubusercontent.com/98294357/161050264-1716ca25-2f3d-46c7-a35f-a202e854cd00.png" width="800px">

**게시글 상세 페이지**
+ 게시글 내용 조회
+ 댓글 작성
  + 로그인한 사용자만 작성 가능
  + 본인 댓글만 수정/삭제
  + 로그인 하지 않는 사용자가 게시글 등록시 로그인 페이지로 넘어감

<img src="https://user-images.githubusercontent.com/98294357/161051221-fe2c59f8-d79c-4bfb-afdd-42283176a229.png" width="800px">
