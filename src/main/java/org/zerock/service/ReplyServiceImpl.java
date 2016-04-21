package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;
import org.zerock.persistence.ReplyDao;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dw on 2016. 3. 22..
 */

@Service
public class ReplyServiceImpl implements ReplyService {
    @Inject
    private ReplyDao dao;

    @Override
    public void addReply(ReplyVo vo) throws Exception {
        dao.create(vo);
    }

    @Override
    public List<ReplyVo> listReply(Integer bno) throws Exception {
        return dao.list(bno);
    }

    @Override
    public void modifyReply(ReplyVo vo) throws Exception {
        dao.update(vo);
    }

    @Override
    public void removeReply(Integer rno) throws Exception {
        dao.delete(rno);
    }

//    ReplyService 페이징 처리
    @Override
    public List<ReplyVo> listReplyPage(Integer bno, Criteria criteria) throws Exception {

        return dao.listPage(bno, criteria);
    }

    @Override
    public int count(Integer bno) throws Exception {
        return dao.count(bno);
    }
}
