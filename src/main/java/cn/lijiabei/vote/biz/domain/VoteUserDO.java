package cn.lijiabei.vote.biz.domain;

import java.util.Date;

/**
 * @ClassName: VoteUser
 * @Description: by CodeGenerate
 * @author lijiabei
 * @date Jul 19, 2017
 * 
 */
public class VoteUserDO {

	/**用户id ( 主键 )  */
	private Long id;
	/**用户来源,1支付宝   */
	private Integer userFrom;
	/**平台唯一id   */
	private String platId;
	/**昵称   */
	private String nickName;
	/**头像   */
	private String avatar;
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

	public void setUserFrom(Integer userFrom){
		this.userFrom = userFrom;
	}

	public Integer getUserFrom(){
		return userFrom;
	}

	public void setPlatId(String platId){
		this.platId = platId;
	}

	public String getPlatId(){
		return platId;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return nickName;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
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