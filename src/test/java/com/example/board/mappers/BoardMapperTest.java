package com.example.board.mappers;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board -> log.info(board.toString()));
    }

    @Test
    public void testInsert() {

            BoardVO board = new BoardVO();
            board.setTitle("새로 작성한 글 제목");
            board.setContent("새로 작성한 글 내용");
            board.setWriter("user009");
            mapper.insert(board);

    }
    @Test
    public void testInsertSelectKey_bno() {

            BoardVO board = new BoardVO();
            board.setTitle("새로 작성한 글 제목");
            board.setContent("새로 작성한 글 내용");
            board.setWriter("user009");
            mapper.insertSelectKey_bno(board);

    }
    @Test
    //게시글 상세보기(게시글 한 개 가져오기)
    public void testRead() {
        mapper.read(6L);
    }

    @Test
    //게시글 수정
    public void testUpdate() {

        if (mapper.read(6L) == null) {
            log.info("*****No such Board*****");
        } else {
            BoardVO board = new BoardVO();
            board.setTitle("수정한 글 제목");
            board.setContent("수정한 글 내용");
            board.setBno(6L);
            log.info("Update Count : " + mapper.update(board));
        }
    }

    //게시글 삭제
    @Test
    public void delete() {
        if (mapper.read(6L) == null) {
            log.info("*****No such Board*****");
        } else {
            log.info("Update Count : " + mapper.delete(6L));
        }
    }
}
