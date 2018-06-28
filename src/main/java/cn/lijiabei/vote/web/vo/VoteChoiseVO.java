package cn.lijiabei.vote.web.vo;

/**
 * @ClassName: VoteChoiseVO
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 */
public class VoteChoiseVO {

	/** 投票选项 ( 主键 )  */
	private long id;
	/** 投票项内容   */
	private String detail;
	/** 票数 */
	private int amount = 0;
	/** 票数占比 百分制 */
	private int percent = 0;
	/** 当前用户是否投了当前这选项 */
	private boolean voted = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

}
