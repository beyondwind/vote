package cn.lijiabei.vote.biz.service.impl;

import cn.lijiabei.vote.biz.bo.QueryVoteUserBO;
import cn.lijiabei.vote.biz.dao.VoteUserDao;
import cn.lijiabei.vote.biz.domain.VoteUserDO;
import cn.lijiabei.vote.biz.service.UserService;

public class UserServiceImpl implements UserService {

	private VoteUserDao voteUserDao;

	@Override
	public VoteUserDO queryUserByPlatId(String platId, int userFrom) {
		QueryVoteUserBO query = new QueryVoteUserBO();
		query.setPlatId(platId);
		query.setUserFrom(userFrom);
		return voteUserDao.selectVoteUserById(query);
	}

	@Override
	public boolean createUser(VoteUserDO userDO) {
		VoteUserDO exist = queryUserByPlatId(userDO.getPlatId(), userDO.getUserFrom());
		if (null != exist) {
			return true;
		}
		return voteUserDao.insertVoteUser(userDO) > 0;
	}

	public void setVoteUserDao(VoteUserDao voteUserDao) {
		this.voteUserDao = voteUserDao;
	}

}
