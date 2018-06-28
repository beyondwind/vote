package cn.lijiabei.vote.web.vo;

import java.util.List;

/**
 * @ClassName: VoteActivityVO
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 */
public class VoteActivityVO {

	/** 自增主键 ( 主键 )  */
	private long id;
	/** 活动名称   */
	private String activityTitle;
	/** 活动内容   */
	private String activityContent;
	/** 选项类型 0单选 1复选   */
	private int choiseType;
	/** 当前用户是否投票过 */
	private boolean voted;
	/** 投过的票数 */
	private int amount;
	/** 投票选项 */
	private List<VoteChoiseVO> voteChoiseList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public int getChoiseType() {
		return choiseType;
	}

	public void setChoiseType(int choiseType) {
		this.choiseType = choiseType;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<VoteChoiseVO> getVoteChoiseList() {
		return voteChoiseList;
	}

	public void setVoteChoiseList(List<VoteChoiseVO> voteChoiseList) {
		this.voteChoiseList = voteChoiseList;
	}

}
