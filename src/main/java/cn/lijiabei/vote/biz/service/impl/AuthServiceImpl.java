package cn.lijiabei.vote.biz.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.lijiabei.vote.biz.domain.VoteUserDO;
import cn.lijiabei.vote.biz.service.AuthService;
import cn.lijiabei.vote.common.utils.EncryptUtils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

public class AuthServiceImpl implements AuthService {

	protected Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	private static final String APP_ID = "2017071607775315";
	private static final String APP_PRIVATE_KEY = null;
	private static final String ALIPAY_PUBLIC_KEY = null;
	
	private AlipayClient alipayClient;

	public void init() {
		alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2");
	}

	@Override
	public String queryAuthBaseUrl(String redirect) {
		StringBuffer url = new StringBuffer();
		url.append("https://openauth.alipay.com/oauth2/publicAppAuthorize.htm");
		url.append("?app_id=").append(APP_ID);
		url.append("&scope=").append("auth_base");
		url.append("&redirect_uri=").append("http://vote.lijiabei.cn/vote/auth.htm");

		if (StringUtils.isNotEmpty(redirect)) {
			JSONObject json = new JSONObject();
			json.put("redirect", redirect);
			String state = EncryptUtils.encodeBase64(json.toJSONString());
			url.append("&state=").append(state);
		}

		return url.toString();
	}

	@Override
	public String queryAuthUserUrl(String redirect) {
		StringBuffer url = new StringBuffer();
		url.append("https://openauth.alipay.com/oauth2/publicAppAuthorize.htm");
		url.append("?app_id=").append(APP_ID);
		url.append("&scope=").append("auth_user");
		url.append("&redirect_uri=").append("http://vote.lijiabei.cn/vote/auth.htm");

		JSONObject json = new JSONObject();
		json.put("user", "new");
		if (StringUtils.isNotEmpty(redirect)) {
			json.put("redirect", redirect);
		}
		String state = EncryptUtils.encodeBase64(json.toJSONString());
		
		url.append("&state=").append(state);
		return url.toString();
	}

	@Override
	public String queryPlatId(String authCode) {
		AlipaySystemOauthTokenRequest alipaySystemOauthTokenRequest = new AlipaySystemOauthTokenRequest();
		alipaySystemOauthTokenRequest.setCode(authCode);
		alipaySystemOauthTokenRequest.setGrantType("authorization_code");
		try {
			AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(alipaySystemOauthTokenRequest);
			return oauthTokenResponse.getUserId();
		} catch (Exception e) {
			logger.error("获取用户id错误", e);
		}
		return null;
	}

	@Override
	public String queryAccessToken(String authCode) {
		AlipaySystemOauthTokenRequest alipaySystemOauthTokenRequest = new AlipaySystemOauthTokenRequest();
		alipaySystemOauthTokenRequest.setCode(authCode);
		alipaySystemOauthTokenRequest.setGrantType("authorization_code");
		try {
			AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(alipaySystemOauthTokenRequest);
			return oauthTokenResponse.getAccessToken();
		} catch (Exception e) {
			logger.error("授权错误", e);
		}
		return null;
	}

	@Override
	public VoteUserDO queryUser(String accessToken) {
		AlipayUserInfoShareRequest alipayUserInfoShareRequest = new AlipayUserInfoShareRequest();
		try {
			AlipayUserInfoShareResponse userResponse = alipayClient.execute(alipayUserInfoShareRequest, accessToken);
			if (userResponse.isSuccess()) {
				VoteUserDO userInfo = new VoteUserDO();
				userInfo.setPlatId(userResponse.getUserId());
				userInfo.setAvatar(userResponse.getAvatar());
				userInfo.setNickName(userResponse.getNickName());
				userInfo.setUserFrom(1);
				return userInfo;
			}
		} catch (Exception e) {
			logger.error("接口调用错误", e);
		}
		return null;
	}

}
