package domain;

/*MemberInfo Domain 클래스*/
public class MemberInfo {
	private int u_id;
	private String nickname;
	private String name;
	private String email;
	private String pwd;
	private String address;
	private String imageURL;
	private int point;
	private Pet pet;
	
	public MemberInfo() {

	}

	public MemberInfo(int u_id, String nickname, String name, String email, String pwd, String address, String imageURL,
			int point, Pet pet) {
		super();
		this.u_id = u_id;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
		this.imageURL = imageURL;
		this.point = point;
		this.pet = pet;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
