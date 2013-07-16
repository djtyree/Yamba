package mobility.spawar.yamba;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile {
	protected Integer id;
	protected String username, email, name;

	// JSON Node names

	private static final String TAG_ID = "uid";
	private static final String TAG_NAME = "name";

	public Profile() {
		// Choose an appropriate creation strategy.
		username = "test.user";
		email = "test.user@fusion.local";

	}

	public Integer getID() {
		return id;
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

	public void setID(Integer uid) {
		this.id = uid;
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

	public void parseProfile(JSONObject u) {
		try {
			this.id = u.getInt(TAG_ID);
			this.username = u.getString(TAG_NAME);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
