package cn.lijiabei.vote.biz.domain;

import java.util.Date;

/**
 * @ClassName: VoteEvent
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 * 
 */
public class VoteEventDO {

	/**主键 ( 主键 )  */
	private Long id;
	/**投票用户   */
	private Long userId;
	/**所属活动   */
	private Long activityId;
	/**选择项id   */
	private Long choiseId;
	/**   */
	private Date gmtCreate;
	/**   */
	private Date gmtModified;
	
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getUserId(){
		return userId;
	}

	public void setActivityId(Long activityId){
		this.activityId = activityId;
	}

	public Long getActivityId(){
		return activityId;
	}

	public void setChoiseId(Long choiseId){
		this.choiseId = choiseId;
	}

	public Long getChoiseId(){
		return choiseId;
	}

	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate(){
		return gmtCreate;
	}

	public void setGmtModified(Date gmtModified){
		this.gmtModified = gmtModified;
	}

	public Date getGmtModified(){
		return gmtModified;
	}

}