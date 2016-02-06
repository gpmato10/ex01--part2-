package org.zerock.service;

import org.zerock.domain.BoardVO;

import java.util.List;

/**
 * Created by dw on 2016. 2. 7..
 */
public interface BoardService {
    public void regist(BoardVO board) throws Exception ;

    public BoardVO read(Integer bno) throws Exception;

    public void modify(BoardVO board) throws Exception;

    public void remove(Integer bno) throws Exception;

    public List<BoardVO> listAll() throws Exception;
}