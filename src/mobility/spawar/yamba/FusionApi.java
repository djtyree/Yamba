package mobility.spawar.yamba;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

public class FusionApi {
	private String baseUrl;
	
	/**
	 * Entry point into the API.
	 */
	private static FusionApi api = new FusionApi();


	private FusionApi(String url) {
		if(url != null) {
			// need to test for valid url
			baseUrl = url;
			
		} else baseUrl = "http://fusion.local/";
	}

	private FusionApi() {
		baseUrl = "http://fusion.local/";
	}
	
	public static FusionApi getInstance() {
		// Choose an appropriate creation strategy.
		return api;
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	/**
	 * Request a User Profile from the REST server.
	 * 
	 * @param userName
	 *            The user name for which the profile is to be requested.
	 * @param callback
	 *            Callback to execute when the profile is available.
	 */
	public void getUserProfile(String userName,
			final GetResponseCallback callback) {
		
		String restUrl = Utils.constructRestUrlForProfile(userName);
		new GetTask(restUrl, new RestTaskCallback() {
			@Override
			public void onTaskComplete(String response) {
				Profile profile = new Profile();
				try {
					profile = Utils.parseResponseAsProfile(response);
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				callback.onDataReceived(profile);
			}
		}).execute();
	}

	/**
	 * Submit a user profile to the server.
	 * 
	 * @param profile
	 *            The profile to submit
	 * @param callback
	 *            The callback to execute when submission status is available.
	 */
	public void postUserProfile(Profile profile, final PostCallback callback) {
		String restUrl = Utils.constructRestUrlForProfile(profile);
		String requestBody = Utils.serializeProfileAsString(profile);
		new PostTask(restUrl, requestBody, new RestTaskCallback() {
			public void onTaskComplete(String response) {
				callback.onPostSuccess();
			}
		}).execute();
	}
}


