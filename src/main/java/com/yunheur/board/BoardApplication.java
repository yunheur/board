package com.yunheur.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EntityScan(
		// 자바 8에서 JSR-310이라는 표준 명세로 날짜와 시간에 관련된 새로운 API가 추가됨
		// 자바8의 날짜 및 시간 관련 클래스를 그대로 사용할 경우 문제가 발생하므로 아래 Converter를 추가함
		basePackageClasses = {Jsr310JpaConverters.class},
		// 패키지 하위에서 JPA 엔티티(@Entity)를 검색
		basePackages = {"com.yunheur.board"})
// 첨부 파일과 관련된 설정은 자동 구성하지 않도록 처리
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
