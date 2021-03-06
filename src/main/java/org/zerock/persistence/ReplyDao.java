package org.zerock.persistence;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

import java.util.List;

/**
 * Created by dw on 2016. 3. 22..
 */
public interface ReplyDao {
    public List<ReplyVo> list(Integer bno) throws Exception;

    public void create(ReplyVo vo) throws Exception;

    public void update(ReplyVo vo) throws Exception;

    public void delete(Integer rno) throws Exception;

    public List<ReplyVo> listPage(Integer bno, Criteria cri) throws Exception;

    public int count(Integer bno) throws Exception;
}
