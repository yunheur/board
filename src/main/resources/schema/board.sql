CREATE TABLE t_board (
  board_idx INT(11) NOT NULL AUTO_INCREMENT COMMENT '글 번호',
  title VARCHAR(300) NOT NULL COMMENT '제목',
  contents TEXT NOT NULL COMMENT '내용',
  hit_cnt SMALLINT(10) NOT NULL DEFAULT '0' COMMENT '조회수',
  created_datetime DATETIME NOT NULL COMMENT '작성시간',
  creator_id VARCHAR(50) NOT NULL COMMENT '작성자',
  updated_datetime DATETIME DEFAULT NULL COMMENT '수정시간',
  updater_id VARCHAR(50) DEFAULT NULL COMMENT '수정자',
  deleted_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
  PRIMARY KEY (board_idx)
);

CREATE TABLE t_file (
  idx INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  board_idx INT(10) UNSIGNED NOT NULL COMMENT '게시글 번호',
  original_file_name VARCHAR(255) NOT NULL COMMENT '원본 파일 이름',
  stored_file_path VARCHAR(500) NOT NULL COMMENT '파일 저장 경로',
  file_size INT(15) UNSIGNED NOT NULL COMMENT '파일 크기',
  creator_id VARCHAR(50) NOT NULL COMMENT '작성자 아이디',
  created_datetime DATETIME NOT NULL COMMENT '작성시간',
  updator_id VARCHAR(50) DEFAULT NULL COMMENT '수정자 아이디',
  updated_datetime DATETIME DEFAULT NULL COMMENT '수정시간',
  deleted_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
  PRIMARY KEY (idx)
);