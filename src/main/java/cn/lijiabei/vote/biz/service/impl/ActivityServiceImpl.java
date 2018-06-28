package cn.lijiabei.vote.biz.service.impl;

import java.util.List;

import cn.lijiabei.vote.biz.bo.QueryVoteActivityBO;
import cn.lijiabei.vote.biz.bo.QueryVoteChoiseBO;
import cn.lijiabei.vote.biz.bo.QueryVoteEventBO;
import cn.lijiabei.vote.biz.dao.VoteActivityDao;
import cn.lijiabei.vote.biz.dao.VoteChoiseDao;
import cn.lijiabei.vote.biz.dao.VoteEventDao;
import cn.lijiabei.vote.biz.domain.VoteActivityDO;
import cn.lijiabei.vote.biz.domain.VoteChoiseDO;
import cn.lijiabei.vote.biz.domain.VoteEventDO;
import cn.lijiabei.vote.biz.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

	private VoteActivityDao voteActivityDao;
	private VoteChoiseDao voteChoiseDao;
	private VoteEventDao voteEventDao;

	@Override
	public VoteActivityDO queryActivityDetail(long activityId) {
		QueryVoteActivityBO queryVoteActivityBO = new QueryVoteActivityBO();
		queryVoteActivityBO.setId(activityId);
		VoteActivityDO voteActivityDO = voteActivityDao.selectVoteActivityById(queryVoteActivityBO);
		if (null == voteActivityDO) {
			return null;
		}

		QueryVoteChoiseBO queryVoteChoiseBO = new QueryVoteChoiseBO();
		queryVoteChoiseBO.setActivityId(activityId);
		List<VoteChoiseDO> choiseList = voteChoiseDao.selectVoteChoiseList(queryVoteChoiseBO);
		voteActivityDO.setVoteChoiseList(choiseList);

		QueryVoteEventBO queryVoteEventBO = new QueryVoteEventBO();
		queryVoteEventBO.setActivityId(activityId);
		List<VoteEventDO> eventList = voteEventDao.selectVoteEventList(queryVoteEventBO);
		voteActivityDO.setVoteEventList(eventList);
		return voteActivityDO;
	}

	@Override
	public boolean voteActivity(VoteEventDO voteEventDO) {
		return voteEventDao.insertVoteEvent(voteEventDO) > 0;
	}

	public void setVoteActivityDao(VoteActivityDao voteActivityDao) {
		this.voteActivityDao = voteActivityDao;
	}

	public void setVoteChoiseDao(VoteChoiseDao voteChoiseDao) {
		this.voteChoiseDao = voteChoiseDao;
	}

	public void setVoteEventDao(VoteEventDao voteEventDao) {
		this.voteEventDao = voteEventDao;
	}

}
