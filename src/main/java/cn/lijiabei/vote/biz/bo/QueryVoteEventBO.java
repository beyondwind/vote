package cn.lijiabei.vote.biz.bo;

import java.util.Date;

import cn.lijiabei.vote.common.bo.BaseQueryBO;

/**
 * @ClassName: VoteEvent查询BO
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 * 
 */
public class QueryVoteEventBO extends BaseQueryBO{

	private Long id;// 主键 ( 主键 ) 
	private Long userId;// 投票用户  
	private Long activityId;// 所属活动  
	private Long choiseId;// 选择项id  
	private Date gmtCreate;//   
	private Date gmtModified;//   
	
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