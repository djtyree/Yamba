package mobility.spawar.yamba;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Utils {
	// constructs the web service request for pulling profile information
	// this currently uses information found in the elgg-web-services
	// documentation
	// more information can be found at
	// https://github.com/markharding/elgg-web-services/blob/master/README.txt
	public static String constructRestUrlForProfile(String username) {
		String webServiceBase = "/services/api/rest/";
		String outputType = "xml/";
		String webServiceMethod = "?method=user.get_profile";
		String usernameString = "&username=" + username;
		FusionApi api = FusionApi.getInstance();

		String url = api.getBaseUrl() + webServiceBase + outputType
				+ webServiceMethod + usernameString;
		return url;

	}

	public static String constructRestUrlForProfile(Profile profile) {
		String webServiceBase = "/services/api/rest/";
		String outputType = "xml/";
		String webServiceMethod = "?method=user.get_profile";
		String usernameString = "&username=" + profile.getUserName();
		FusionApi api = FusionApi.getInstance();

		String url = api.getBaseUrl() + webServiceBase + outputType
				+ webServiceMethod + usernameString;
		return url;

	}

	public static Profile parseResponseAsProfile(String response) throws XmlPullParserException, IOException {
		Profile profile = new Profile();
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();

		xpp.setInput(new StringReader(response));
		int eventType = xpp.getEventType();
		String text = "";
		String field;

		// continue to parse xml until end of document
		while (eventType != XmlPullParser.END_DOCUMENT) {

			if (eventType == XmlPullParser.START_TAG) {
				field = xpp.getName();

				// reads the status of the request. if = 0, the request was successful
				// if = -1, error occurred during request.
				if (field.compareTo("status") == 0) {
					// grab result of status.
					text = xpp.nextText();
					if (text.compareTo("0") != 0) {
						throw new XmlPullParserException("Invalid Request");
					}

				}

				if (field.compareTo("name") == 0) {
					profile.setName(xpp.nextText());
				}
				if (field.compareTo("username") == 0) {
					profile.setUserName(xpp.nextText());
				}
			}
			eventType = xpp.next();
		}


		return profile;
	}

	public static String serializeProfileAsString(Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

}
