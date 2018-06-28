package cn.lijiabei.vote.biz.dao;

import java.util.List;

import cn.lijiabei.vote.biz.bo.QueryVoteEventBO;
import cn.lijiabei.vote.biz.domain.VoteEventDO;

public interface VoteEventDao {

	public List<VoteEventDO> selectVoteEventList(QueryVoteEventBO query);

	public int insertVoteEvent(VoteEventDO voteEvent);

}