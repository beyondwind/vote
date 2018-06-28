package cn.lijiabei.vote.biz.service;

import cn.lijiabei.vote.biz.domain.VoteUserDO;

public interface AuthService {

	/**
	 * @Title: queryAuthBaseUrl
	 * @Description: 获取基础用户信息授权链接
	 */
	String queryAuthBaseUrl(String redirect);

	/**
	 * @Title: queryAuthBaseUrl
	 * @Description: 获取基户信息授权链接，用于接口调用
	 */
	String queryAuthUserUrl(String redirect);

	/**
	 * @Title: queryPlatId
	 * @Description: 获取平台用户id
	 * @param authCode
	 * @return String 返回类型
	 */
	String queryPlatId(String authCode);

	/**
	 * @Title: queryAccessToken
	 * @Description: 获取授权令牌
	 * @param authCode
	 */
	String queryAccessToken(String authCode);

	/**
	 * @Title: queryUser
	 * @Description: 根据授权令牌获取用户信息
	 * @param accessToken
	 */
	VoteUserDO queryUser(String accessToken);
}
