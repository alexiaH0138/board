package com.example.board.beans.dao;


import com.example.board.beans.vo.BoardVO;
import com.example.board.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
//원격에서 수정됨2
@Repository //컴포넌트의 자식 어노테이션. 다오임을 특정지어줌.
@RequiredArgsConstructor //생성자로 주입 --인터페이스에서 구현된 클래스를 찾을 수 없기 때문에 원래는 필드 주입을 해야하지만
                        //Mapper가 xml에서 구현된 부분도 클래스로 인식해서 실행한다. (정상적인 방법은 아님)
public class BoardDAO {

/*    @Autowired
    private final BoardMapper mapper;*/
    private final BoardMapper mapper;

    /*게시글 등록*/
    public void register(BoardVO board){
        mapper.insertSelectKey_bno(board);
    }
    /*특정 게시물 가져오기*/
    public BoardVO get(Long bno){
        return mapper.read(bno);
    }
    /*게시글 수정하기*/
    public boolean modify(BoardVO board){
        return mapper.update(board) == 1;
    }
    /*게시글 삭제*/
    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }
    /*전체 목록*/
    public List<BoardVO> getList(){
        return mapper.getList();
    }
}
