package cn.lijiabei.vote.biz.domain;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: VoteActivity
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 */
public class VoteActivityDO {

	/** 自增主键 ( 主键 )  */
	private Long id;
	/** 活动名称   */
	private String activityTitle;
	/** 活动内容   */
	private String activityContent;
	/** 用户id   */
	private Long userId;
	/** 选项类型 0单选 1复选   */
	private Integer choiseType;
	private Date gmtCreate;
	private Date gmtModified;

	/** 投票选项 */
	private List<VoteChoiseDO> voteChoiseList;
	/** 投票事件  */
	private List<VoteEventDO> voteEventList;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setChoiseType(Integer choiseType) {
		this.choiseType = choiseType;
	}

	public Integer getChoiseType() {
		return choiseType;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public List<VoteChoiseDO> getVoteChoiseList() {
		return voteChoiseList;
	}

	public void setVoteChoiseList(List<VoteChoiseDO> voteChoiseList) {
		this.voteChoiseList = voteChoiseList;
	}

	public List<VoteEventDO> getVoteEventList() {
		return voteEventList;
	}

	public void setVoteEventList(List<VoteEventDO> voteEventList) {
		this.voteEventList = voteEventList;
	}

}
