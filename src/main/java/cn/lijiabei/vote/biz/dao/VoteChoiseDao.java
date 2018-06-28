package cn.lijiabei.vote.biz.dao;

import java.util.List;

import cn.lijiabei.vote.biz.bo.QueryVoteChoiseBO;
import cn.lijiabei.vote.biz.domain.VoteChoiseDO;

public interface VoteChoiseDao {

	public List<VoteChoiseDO> selectVoteChoiseList(QueryVoteChoiseBO query);

	public int insertVoteChoise(VoteChoiseDO voteChoise);

	public int updateVoteChoise(VoteChoiseDO voteChoise);

	public int deleteVoteChoise(VoteChoiseDO voteChoise);
}
