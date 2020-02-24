package com.yunheur.board.board.repository;

import java.util.List;

import com.yunheur.board.board.entity.BoardEntity;
import com.yunheur.board.board.entity.BoardFileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// CrudRepository 인터페이스는 리포지터리에서 사용할 도메인 클래스와 도메인의 id 타입을 파라미터로 받음
public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer>{

	List<BoardEntity> findAllByOrderByBoardIdxDesc();

	@Query("SELECT file FROM BoardFileEntity file WHERE board_idx = :boardIdx AND idx = :idx")
	BoardFileEntity findBoardFile(@Param("boardIdx") int boardIdx, @Param("idx") int idx);
}
