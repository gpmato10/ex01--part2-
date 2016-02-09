## book_ex 데이터베이스가 존재하면 삭제하고 만들어도 됨.
## drop DATABASE `book_ex`;
create database `book_ex`;

use book_ex;

create table tbl_member(
  userid varchar(50) not null,
  userpw varchar(50) not null,
  username varchar(50) not null,
  email varchar(50),
  regdate timestamp default now(),
  updatedate timestamp default now(),
  primary key(userid)
);

use book_ex;

create table tbl_board(
  bno int not null AUTO_INCREMENT,
  title varchar(200) not null,
  content text null,
  writer varchar(50) not null,
  regdate timestamp not null default now(),
  viewcnt int default 0,
  PRIMARY KEY (bno)
);

## 데이터 불리기
insert into tbl_board(title, content, writer) (select title, content, writer from tbl_board);
select count(*) from tbl_board;

## page 258 limit 20, 20  테스트 결과 확인하기.
select * from tbl_board where bno > 0 order by bno desc limit 20,20;