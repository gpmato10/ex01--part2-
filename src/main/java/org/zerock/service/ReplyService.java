package org.zerock.service;

import org.zerock.domain.ReplyVo;

import java.util.List;

/**
 * Created by dw on 2016. 3. 22..
 */
public interface ReplyService {
    public void addReply(ReplyVo vo) throws Exception;

    public List<ReplyVo> listReply(Integer bno) throws Exception;

    public void modifyReply(ReplyVo vo) throws Exception;

    public void removeReply(Integer rno) throws Exception;
}
