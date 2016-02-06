## 새로운 게시물 등록에 사용하는 sql
insert into tbl_board(title, content, writer) values('제목입니다', '내용입니다', 'user00');

## 게시물 조회
select * from table_board where bno = 1;

## 게시물 전체목록 조회
select * from tbl_board where bno > 0 order by bno desc;

## 게시물 수정 SQL
update tbl_board set title='수정된 제목' where bno = 1;

## 게시물 삭제 SQL
delete from tbl_board where bno = 1;