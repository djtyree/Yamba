package mobility.spawar.yamba;

public class Profile {
	protected String username,email,name;
	
	
	public Profile() {
		// Choose an appropriate creation strategy.
		username = "test.user";
		email = "test.user@fusion.local";
		
	}
	
	public String getUserName() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setUserName(String name) {
		this.username = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String mail) {
		this.email = mail;
	}
}
