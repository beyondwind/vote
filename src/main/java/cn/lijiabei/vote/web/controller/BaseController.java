package cn.lijiabei.vote.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.lijiabei.vote.biz.domain.VoteUserDO;

public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected long getUserId(HttpSession session) {
		VoteUserDO user = (VoteUserDO) session.getAttribute("voteUser");
		return user.getId();
	}
}
