## SQL TEST

### INDEX
> INDEX 검색(SELECT) 차이 비교
```sql
-- 인덱스 생성 전: 1(0.005초) 데이터가 적어서 짧지만 줄어든거 확인할 수 있음
SELECT * FROM MEMBER WHERE USER_NAME = '김동민';
-- 인덱스 생성 후: 1(0.003초)
CREATE INDEX idxIndexName on MEMBER(USER_NAME);
SELECT * FROM MEMBER WHERE USER_NAME = '김동민';
```

+ PK 컬럼 검색속도가 일반 컬럼 검색속도보다 월등히 빠르다. (PK는 자동으로 INDEX를 생성하기 떄문)
> 장/단점
+ 검색 처리 속도를 향상시킨다.
+ 비용이 비싸다 -> 인덱스를 CREATE 해주어야 하기 때문
> 인덱스를 사용해야 하는 경우
+ 테이블 행의 개수가 많은 경우(검색해야 하는 데이터가 많은 경우) 
+ 인덱스를 적용한 컬럼이 WHERE 절에서 많이 사용되는 경우 ★★★★★
+ JOIN 할 때 사용하는 컬럼(ON 부모테이블.PK = 자식테이블.FK) ★★★★★
+ 검색 결과가 원본 테이블 데이터 2~4%에 해당하는 경우 ★★★★★
+ 해당 컬럼이 NULL을 포함하는 경우(색인에 NULL이 제외)
> 인덱스를 사용하면 좋지않은 경우
+ 테이블의 행의 개수가 적은 경우(CREATE 비용 발생)
+ 검색 결과가 원본테이블의 많은 비중을 차지하는 경우
+ 원본 테이블의 삽입, 수정, 삭제가 빈번한 경우 ★★★★★

### JOIN (INNER, OUTER, LEFT, RIGHT, SELF)
> JOIN 예제
```sql
-- JOIN TEST
SELECT * FROM EMPLOYEE;      -- E.DEPT_CODE = D.DEPT_ID,  E.JOB_CODE = J.JOB_CODE(JOB_NAME)
SELECT * FROM DEPARTMENT;    -- D.LOCATION_ID = L.LOCAL_CODE(NATIONAL_CODE, LOCAL_NAME)
SELECT * FROM LOCATION;      -- N.NATIONAL_CODE = L.NATIONAL_CODE(NATIONAL_NAME)
SELECT * FROM JOB;           -- E.JOB_CODE = J.JOB_CODE(JOB_NAME)
SELECT * FROM NATIONAL;      -- N.NATIONAL_CODE = L.NATIONAL_CODE(NATIONAL_NAME)

-- 1. JOIN (INNER JOIN)
-- EMPLOYEE와 DEPARTMENT 테이블의 공통적인 요소가 출력된다.(둘 중 값이 NULL인 부분은 제외)
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 2. LEFT JOIN
-- EMPLOYEE에서 부서는 없지만 사원이름 출력
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 3. RIGHT JOIN
-- DEPARTMENT에서 사원은 없지만 모든 부서 출력
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 4. SELF JOIN
-- 두 개 이상의 서로 다른 테이블을 연결하는 것이 아닌 같은 테이블을 조인하는 것
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE, E.MANAGER_ID, M.EMP_NAME
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;
```
### UNION
> UNION 예제
```SQL 
-- 1. UNION 예제가 없네..
-- 두 개의 SELECT 결합 중복제거
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
UNION
SELECT DEPT_TITLE, DEPT_ID FROM DEPARTMENT;
-- 2. UNION ALL
-- 두 개의 SELECT 결합 중복포함
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
UNION ALL
SELECT DEPT_TITLE, DEPT_ID FROM DEPARTMENT;
```
+ 정규화되지 않은 테이블을 서로 합치기 위해서 사용

### PL/SQL
> PL/SQL 예제
+ PL/SQL을 자체적으로 사용불가능하게 하는 회사도 있다고 함(오남용 방지??)
+ 유지보수하는 회사들이 주로 사용한다는것 같다.
```SQL
-- PL/SQL
-- Procefural Language extension to SQL의 약자로 오라클 자체에 내장되어 있는 절차적 언어
-- SQL 단점을 보완하여 SQL문장 내에서 변수의 정의, 조건처리, 반복처리 등 지원
-- 선언부(DECALRE SECTION), 실행부(EXECUTABLE SECTION), 예외처리부(EXCEPTION SECTION)로 나누어져 있음
SET SERVEROUTPUT ON; -- DEFAULT OFF
SHOW ERRORS; -- 에러확인

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
/

-- 타입 변수 선언 : 변수의 선언과 초기화, 변수 값 출력
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);    
END;
/
```
> PL/SQL 장점
+ 블록 구조를 가지고있어서 SQL 구문이 한번에 서버로 전송되므로 수행속도가 향상되고 통신량도 줄일 수 있다.
+ 블록안에 블록 형식으로 코드를 모듈화 할 수 있다.
+ 조건문/반복문/예외처리(을)를 사용할 수 있다.
