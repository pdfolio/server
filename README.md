# PD-Folio

## 서비스

### Playdata 부트캠프 수강생들끼리 만든 미니 프로젝트를 공유하고,

### 사이드 프로젝트 및 스터디를 구인하는 사이트

작업기간 : 8월 15일 ~ 8월 25일

---

## 기술스택

### 백엔드

- Java 17, Spring Boot 3.x.x
- Spring Data Jpa, Query Dsl
- MySql

### 프론트엔드

- Javascript(es6)
- React, Bootstrap

---

## 구성원

총 4명

프론트, 백 구분 없이 기능을 맡고, 맡은 부분에 대한 프론트를 구현


---

## ERD

![image](https://github.com/pdfolio/server/assets/71807768/878995a4-dedb-4670-97d6-a53f63621fc9)

---

## 중요하게 생각한 점

### 쿼리 고민하기

- 쿼리 성능 최적화
- N + 1 문제에 대한 해결

### ⭐ 팀원 모두의 참여

- Spring boot, JPA, QueryDsl, React에 익숙해지기 위한 취지의 프로젝트
- 기능별로 역할을 나누지 않고, 특히 모두가 다양한 쿼리를 작성해 볼 수 있도록 분배

---

## 개선점

### 1. 테스트 코드

- 테스트 코드가 미비해서 서로가 작성한 기능이 온전히 동작하는지 명확하게 알 수 없음
- 프로젝트에 대한 전체적인 리팩토링을 진행하고 싶으나 사이드 이펙트 예상이 쉽지 않음

### 2. 게시글 이미지 처리

- 현재는 화면에서 작성된 게시글과 사진을 base64 인코딩과 md양식으로 변환하여 RDB에 통으로 저장
- 이를 스토리지 서비스를 사용하거나, 조회용 NoSQL을 사용하여 분리

---

## 시연

### 메인페이지
![image (1)](https://github.com/pdfolio/server/assets/71807768/305f47b5-c57a-4310-8758-e246b71c1114)


### 게시글 상세보기
![image (2)](https://github.com/pdfolio/server/assets/71807768/bcc927ff-11e6-4024-aac0-486cbe66ab6b)

