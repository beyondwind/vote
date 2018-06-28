package cn.lijiabei.vote.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.lijiabei.vote.biz.domain.VoteUserDO;
import cn.lijiabei.vote.biz.service.AuthService;
import cn.lijiabei.vote.biz.service.UserService;
import cn.lijiabei.vote.common.utils.EncryptUtils;

@Controller
@RequestMapping("/")
public class AuthController extends BaseController {

	@Autowired
	private AuthService authService;
	@Autowired
	private UserService userService;

	@RequestMapping("/auth.htm")
	public String index(HttpServletRequest request) {
		String authCode = request.getParameter("auth_code");
		String state = request.getParameter("state");
		if (StringUtils.isEmpty(authCode)) {
			return "/test";
		}
		// 是否是新用户
		boolean newUser = false;
		// 原业务链接
		String redirectUri = null;

		if (StringUtils.isNotEmpty(state)) {
			state = EncryptUtils.decodeBase64(state);
			JSONObject stateJson = JSON.parseObject(state);
			newUser = stateJson != null && (StringUtils.equals(stateJson.getString("user"), "new"));
			redirectUri = stateJson == null ? null : stateJson.getString("redirect");
		}

		// 新入住用，调用接口获取用户信息，并同步至数据库
		if (newUser) {
			// 获取令牌
			String accessToken = authService.queryAccessToken(authCode);
			if (StringUtils.isEmpty(accessToken)) {
				return "/test";
			}

			// 获取支付宝用户信息
			VoteUserDO voteUserDO = authService.queryUser(accessToken);
			if (null == voteUserDO) {
				return "/test";
			}

			// 同步至数据库
			boolean success = userService.createUser(voteUserDO);
			if (!success) {
				return "/test";
			}

			// 放入session会话
			HttpSession session = request.getSession();
			session.setAttribute("voteUser", voteUserDO);

			// 进入业务页面
			if (StringUtils.isEmpty(redirectUri)) {
				return "redirect:/userInfo.htm";
			} else {
				return "redirect:" + redirectUri;
			}
		} else {
			// 获取支付宝用户id
			String platId = authService.queryPlatId(authCode);

			// 查询用户是否存在
			VoteUserDO voteUserDO = userService.queryUserByPlatId(platId, 1);
			// 存在放入session进去业务页面
			if (null != voteUserDO) {
				// 放入session会话
				HttpSession session = request.getSession();
				session.setAttribute("voteUser", voteUserDO);

				// 进入业务页面
				if (StringUtils.isEmpty(redirectUri)) {
					return "redirect:/userInfo.htm";
				} else {
					return "redirect:" + redirectUri;
				}
			} else {
				// 不存在，则让用户授权
				return "redirect:" + authService.queryAuthUserUrl(redirectUri);
			}
		}
	}

}
