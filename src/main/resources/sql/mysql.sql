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

## 샘플데이터 삽입
insert into tbl_board(title, content, writer) VALUES ("제목1", "본문1", "작가1");
insert into tbl_board(title, content, writer) VALUES ("제목2", "본문2", "작가2");
insert into tbl_board(title, content, writer) VALUES ("제목3", "본문3", "작가3");
insert into tbl_board(title, content, writer) VALUES ("제목4", "본문4", "작가4");
## 데이터 불리기
insert into tbl_board(title, content, writer) (select title, content, writer from tbl_board);
select count(*) from tbl_board;

## page 258 limit 20, 20  테스트 결과 확인하기.
select * from tbl_board where bno > 0 order by bno desc limit 20,20;

## 9.4 연습중
## http://localhost:8080/board/listPage?page=6

## p370
create table tbl_reply(
  rno int not null AUTO_INCREMENT,
  bno int not null default 0,
  replytext varchar(1000) not null,
  replyer varchar(50) not null,
  regdate TIMESTAMP not null DEFAULT  now(),
  updatedate TIMESTAMP not null DEFAULT  now(),
  PRIMARY KEY (rno)
);

alter table tbl_reply add CONSTRAINT fk_board FOREIGN KEY (bno) REFERENCES tbl_board(bno);
