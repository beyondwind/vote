package cn.lijiabei.vote.biz.dao;

import java.util.List;

import cn.lijiabei.vote.biz.bo.QueryVoteActivityBO;
import cn.lijiabei.vote.biz.domain.VoteActivityDO;

public interface VoteActivityDao {

	public VoteActivityDO selectVoteActivityById(QueryVoteActivityBO query);

	public List<VoteActivityDO> selectVoteActivityList(QueryVoteActivityBO query);

	public int insertVoteActivity(VoteActivityDO voteActivity);

	public int updateVoteActivity(VoteActivityDO voteActivity);

	public int deleteVoteActivity(VoteActivityDO voteActivity);
}