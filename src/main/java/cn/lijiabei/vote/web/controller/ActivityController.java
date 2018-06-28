package cn.lijiabei.vote.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.lijiabei.vote.web.vo.VoteActivityVO;
import cn.lijiabei.vote.web.vo.VoteChoiseVO;

@LoginAnnotation
@Controller
@RequestMapping("/")
public class ActivityController extends BaseController {

	@Autowired
	private ActivityService activityService;

	/**
	 * @Title: activity
	 * @Description: 活动详情查看
	 * @param id 活动id
	 */
	@RequestMapping("/activity.htm")
	public ModelAndView activity(HttpServletRequest request, @RequestParam(value = "activityId", defaultValue = "") String activityId) {
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

		// 查询活动详情（包含投票项以及投票）
		VoteActivityDO voteActivityDO = activityService.queryActivityDetail(activityIdLong);
		if (null == voteActivityDO) {
			modelAndView.setViewName("/screen/user");
			return modelAndView;
		}

		// 是否已经投票
		List<VoteEventDO> voteEventList = voteActivityDO.getVoteEventList();
		// 校验投票选项是否是对应活动
		List<VoteChoiseDO> voteChoiseList = voteActivityDO.getVoteChoiseList();

		// 渲染视图对象
		VoteActivityVO activityVO = new VoteActivityVO();
		activityVO.setActivityContent(voteActivityDO.getActivityContent());
		activityVO.setActivityTitle(voteActivityDO.getActivityTitle());
		activityVO.setChoiseType(voteActivityDO.getChoiseType());
		activityVO.setId(voteActivityDO.getId());
		Map<Long, VoteChoiseVO> choiseMap = new HashMap<Long, VoteChoiseVO>();
		for (VoteChoiseDO voteChoiseDO : voteChoiseList) {
			VoteChoiseVO choiseVO = new VoteChoiseVO();
			choiseVO.setDetail(voteChoiseDO.getDetail());
			choiseVO.setId(voteChoiseDO.getId());
			choiseMap.put(voteChoiseDO.getId(), choiseVO);
		}

		List<VoteChoiseVO> voteChoiseVOList = new ArrayList<VoteChoiseVO>();

		// 有过投票
		if (CollectionUtils.isNotEmpty(voteEventList)) {
			boolean voted = false;
			for (VoteEventDO voteEventDO : voteEventList) {
				VoteChoiseVO choiseVO = choiseMap.get(voteEventDO.getChoiseId());
				// 没有选项，异常情况，无视掉
				if (null == choiseVO) {
					continue;
				}
				// 票数加一
				choiseVO.setAmount(choiseVO.getAmount() + 1);
				// 当前账号投的票
				if (voteEventDO.getUserId().longValue() == userId) {
					voted = true;
					choiseVO.setVoted(true);
				}
			}
			activityVO.setVoted(voted);
			activityVO.setAmount(voteEventList.size());
		}

		voteChoiseVOList.addAll(choiseMap.values());
		activityVO.setVoteChoiseList(voteChoiseVOList);

		if (activityVO.getAmount() > 0) {
			for (VoteChoiseVO voteChoiseVO : voteChoiseVOList) {
				voteChoiseVO.setPercent(voteChoiseVO.getAmount() * 100 / activityVO.getAmount());
			}
		}

		modelAndView.addObject("activity", activityVO);
		modelAndView.setViewName("/screen/activity");
		return modelAndView;
	}

}
