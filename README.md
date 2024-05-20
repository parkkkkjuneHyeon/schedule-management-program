# schedule-management-program
일정 관리 프로그램 만들어 보기 


# 요구사항
일정 관리 프로그램의 요구사항은 다음과 같습니다.

# 일정의 유형
  - "미팅", "할 일", "방해 금지 시간", "외출"에 대한 일정을 관리할 수 있다.
    - 미팅 : `meeting`
    - 할 일 : `to-do`
    - 방해 금지 시간 : `no-disturbance`
    - 외출 : `out-of-office`

# 등록 (Create)
  - 일정을 등록할 수 있다.
      - 겹치는 일정이 존재하면 일정을 등록할 수 없다.
  - 일정을 `.csv` 파일로 대량 등록할 수 있다.

# 검색/조회 (Read)
  - 일정을 ID, 이름, 기간으로 검색할 수 있다.
  - 특정 일자를 입력하면 해당 일자를 조회 할 수 있다.

# 수정 (UPdate)
  - 일정을 수정할 수 있다.
  - 삭제된 일정은 수정할 수 없다.

# 삭제 (Delete)
  - 일정을 삭제할 수 있다.
  - Soft-delelte 로 처리한다.
