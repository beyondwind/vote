package cn.lijiabei.vote.biz.service;

import cn.lijiabei.vote.biz.domain.VoteActivityDO;
import cn.lijiabei.vote.biz.domain.VoteEventDO;

public interface ActivityService {

	/** 
	* @Title: queryActivityDetail 
	* @Description: 查询活动详情
	* @param activityId 活动id
	* @return VoteActivityDO    返回类型 
	*/
	public VoteActivityDO queryActivityDetail(long activityId);

	/** 
	* @Title: voteActivity 
	* @Description: 对活动进行投票
	* @param voteEventDO 
	* @return boolean    返回类型 
	*/
	public boolean voteActivity(VoteEventDO voteEventDO);
}
