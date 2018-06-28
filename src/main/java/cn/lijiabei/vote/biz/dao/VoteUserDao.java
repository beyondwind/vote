package cn.lijiabei.vote.biz.dao;

import cn.lijiabei.vote.biz.bo.QueryVoteUserBO;
import cn.lijiabei.vote.biz.domain.VoteUserDO;

public interface VoteUserDao {

	public VoteUserDO selectVoteUserById(QueryVoteUserBO query);

	public int insertVoteUser(VoteUserDO voteUser);

	public int updateVoteUser(VoteUserDO voteUser);

}
