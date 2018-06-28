package cn.lijiabei.vote.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.lijiabei.vote.biz.domain.VoteActivityDO;
import cn.lijiabei.vote.biz.domain.VoteChoiseDO;
import cn.lijiabei.vote.biz.domain.VoteEventDO;
import cn.lijiabei.vote.biz.service.ActivityService;
import cn.lijiabei.vote.web.annotation.LoginAnnotation;

@LoginAnnotation
@Controller
@RequestMapping("/")
public class VoteController extends BaseController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/vote.htm")
	public ModelAndView activity(HttpServletRequest request, @RequestParam(value = "activityId") String activityId, @RequestParam(value = "choiseIds") String[] choiseIds) {
		ModelAndView modelAndView = new ModelAndView();

		long userId = getUserId(request.getSession());
		// 参数校验
		long activityIdLong = 0L;
		try {
			activityIdLong = Long.parseLong(activityId);
		} catch (Exception e) {
		}
		if (activityIdLong < 1L) {
			modelAndView.setViewName("/screen/user");
			return modelAndView;
		}
		if (null == choiseIds || choiseIds.length < 1) {
			modelAndView.setViewName("/screen/user");
			return modelAndView;
		}
		// 封装投票事件
		List<VoteEventDO> choiseList = new ArrayList<VoteEventDO>();
		for (String choiseIdString : choiseIds) {
			try {
				Long choiseId = Long.parseLong(choiseIdString);
				VoteEventDO vote = new VoteEventDO();
				vote.setActivityId(activityIdLong);
				vote.setChoiseId(choiseId);
				vote.setUserId(userId);
				choiseList.add(vote);
			} catch (Exception e) {
				modelAndView.setViewName("/screen/user");
				return modelAndView;
			}
		}

		// 查询活动详情（包含投票项以及投票）
		VoteActivityDO voteActivityDO = activityService.queryActivityDetail(activityIdLong);
		if (null == voteActivityDO) {
			modelAndView.setViewName("/screen/user");
			return modelAndView;
		}

		// 单选，投票项不能超过1
		if (voteActivityDO.getChoiseType().intValue() == 0 && choiseList.size() > 1) {
			modelAndView.setViewName("/screen/user");
			return modelAndView;
		}

		// 是否已经投票
		List<VoteEventDO> voteEventList = voteActivityDO.getVoteEventList();
		if (CollectionUtils.isNotEmpty(voteEventList)) {
			for (VoteEventDO voteEventDO : voteEventList) {
				if (checkVoted(userId, voteEventDO)) {
					modelAndView.setViewName("/screen/user");
					return modelAndView;
				}
			}
		}

		// 校验投票选项是否是对应活动
		List<VoteChoiseDO> voteChoiseList = voteActivityDO.getVoteChoiseList();
		for (VoteEventDO voteEventDO : choiseList) {
			if (!checkChoise(voteEventDO.getChoiseId(), voteChoiseList)) {
				modelAndView.setViewName("/screen/user");
				return modelAndView;
			}
		}

		// 投票
		for (VoteEventDO voteEventDO : choiseList) {
			activityService.voteActivity(voteEventDO);
		}

		// 投票成功
		modelAndView.setViewName("redirect:/activity.htm?activityId=" + activityId);
		return modelAndView;
	}

	// 是否投过票
	private boolean checkVoted(long userId, VoteEventDO eventDO) {
		return eventDO.getUserId().longValue() == userId;
	}

	// 是否是活动范围内的投票
	private boolean checkChoise(long choiseId, List<VoteChoiseDO> voteChoiseList) {
		if (CollectionUtils.isEmpty(voteChoiseList)) {
			return false;
		}
		for (VoteChoiseDO voteChoiseDO : voteChoiseList) {
			if (choiseId == voteChoiseDO.getId().longValue()) {
				return true;
			}
		}
		return false;
	}
}
