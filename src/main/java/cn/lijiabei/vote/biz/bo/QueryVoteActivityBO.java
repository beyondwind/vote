package cn.lijiabei.vote.biz.bo;

import java.util.Date;

import cn.lijiabei.vote.common.bo.BaseQueryBO;

/**
 * @ClassName: VoteActivity查询BO
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 * 
 */
public class QueryVoteActivityBO extends BaseQueryBO{

	private Long id;// 自增主键 ( 主键 ) 
	private String activityTitle;// 活动名称  
	private String activityContent;// 活动内容  
	private Long userId;// 用户id  
	private Integer choiseType;// 选项类型 0单选 1复选  
	private Date gmtCreate;//   
	private Date gmtModified;//   
	
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setActivityTitle(String activityTitle){
		this.activityTitle = activityTitle;
	}

	public String getActivityTitle(){
		return activityTitle;
	}

	public void setActivityContent(String activityContent){
		this.activityContent = activityContent;
	}

	public String getActivityContent(){
		return activityContent;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getUserId(){
		return userId;
	}

	public void setChoiseType(Integer choiseType){
		this.choiseType = choiseType;
	}

	public Integer getChoiseType(){
		return choiseType;
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