package org.zerock.persistence;

import org.zerock.domain.BoardVO;

import java.util.List;

/**
 * Created by dw on 2016. 2. 7..
 */
public interface BoardDAO {
    public void create(BoardVO vo) throws Exception;

    public BoardVO read(Integer bno) throws Exception;

    public void update(BoardVO vo) throws Exception;

    public void delete(Integer bno) throws Exception;

    public List<BoardVO> listAll() throws Exception;
}
