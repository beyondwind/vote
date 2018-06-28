package cn.lijiabei.vote.web.vo;

public class UserInfoVO {

	/** 支付宝用户的userId */
	private String userId;
	/** 用户头像地址 */
	private String avatar;
	/** 用户类型（1/2） 1代表公司账户2代表个人账户 */
	private String userType;
	/** 公司账户/个人账户 */
	private String userTypeTxt;
	/** 用户状态（Q/T/B/W）。 Q代表快速注册用户 T代表已认证用户 B代表被冻结账户 W代表已注册，未激活的账户 */
	private String userStatus;
	/** 快速注册用户/已认证用户/被冻结账户/未激活 */
	private String userStatusTxt;
	/** 省 */
	private String province;
	/** 市 */
	private String city;
	/** 昵称 */
	private String nickName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTypeTxt() {
		return userTypeTxt;
	}

	public void setUserTypeTxt(String userTypeTxt) {
		this.userTypeTxt = userTypeTxt;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserStatusTxt() {
		return userStatusTxt;
	}

	public void setUserStatusTxt(String userStatusTxt) {
		this.userStatusTxt = userStatusTxt;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
