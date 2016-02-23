package org.zerock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dw on 2016. 2. 7..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class BoardDAOTest {
    @Inject
    private BoardDAO dao;

    private static final Logger log = LoggerFactory.getLogger(BoardDAOTest.class);

    @Test
    public void testCreate() throws Exception {
        BoardVO board = new BoardVO();
        board.setTitle("새로운 글을 넣습니다.");
        board.setContent("새로운 글을 넣습니다.");
        board.setWriter("user00");
        dao.create(board);
    }

    @Test
    public void testRead() throws Exception {
        log.info(dao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        BoardVO board = new BoardVO();
        board.setBno(1);
        board.setTitle("수정된  글 입니다.");
        board.setContent("수정 본문  테스트.");
        dao.update(board);
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(1);
    }

    @Test
    public void testListPage() throws Exception {
        int page = 3;

        List<BoardVO> list = dao.listPage(page);

        for (BoardVO boardVO : list) {
            log.info(boardVO.getBno() + ":" + boardVO.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {
        Criteria cri = new Criteria();
        cri.setPage(2);
        cri.setPerPageNum(20);

        List<BoardVO> list = dao.listCriteria(cri);

        for (BoardVO boardVO : list) {
            log.info(boardVO.getBno() + ":" + boardVO.getTitle());
        }
    }

    @Test
    public void testURI() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/board/read")
                .queryParam("bno", 12)
                .queryParam("perPageNum", 20)
                .build();

        log.info("/board/read?bno=12&pagePerName=20");
        log.info(uriComponents.toString());

    }

    @Test
    public void testURI2() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/{module}/{page}")
                .queryParam("bno", 12)
                .queryParam("perPageNum", 20)
                .build()
                .expand("board", "read")
                .encode();


        log.info("/board/read?bno=12&pagePerName=20");
        log.info(uriComponents.toString());

    }

    @Test
    public void testDynamic1() throws Exception {
        SearchCriteria cri = new SearchCriteria();
        cri.setPage(1);
        cri.setKeyword("글");
        cri.setSearchType("t");

        log.info("===================");

        List<BoardVO> list = dao.listSearch(cri);

        for (BoardVO boardVO : list) {
            log.info(boardVO.getBno() + ": " + boardVO.getTitle());
        }

        log.info("==============");

        log.info("COUNT: " + dao.listSearchCount(cri));
    }
//    p327 coding
}
