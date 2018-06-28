package cn.lijiabei.vote.biz.domain;

import java.util.Date;

/**
 * @ClassName: VoteChoise
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 * 
 */
public class VoteChoiseDO {

	/**投票选项 ( 主键 )  */
	private Long id;
	/**对应活动   */
	private Long activityId;
	/**投票项内容   */
	private String detail;
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

	public void setActivityId(Long activityId){
		this.activityId = activityId;
	}

	public Long getActivityId(){
		return activityId;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
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