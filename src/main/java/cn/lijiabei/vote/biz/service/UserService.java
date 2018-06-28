package cn.lijiabei.vote.biz.service;

import cn.lijiabei.vote.biz.domain.VoteUserDO;

public interface UserService {

	/**
	 * @Title: queryUserByPlatId
	 * @Description: 根据平台id查询用户信息
	 * @param platId 平台id
	 * @param userFrom 用户来源,1支付宝
	 * @return VoteUserDO 返回类型
	 */
	public VoteUserDO queryUserByPlatId(String platId, int userFrom);

	/**
	 * @Title: createUser
	 * @Description:新建用户
	 * @param userDO
	 */
	public boolean createUser(VoteUserDO userDO);
}
