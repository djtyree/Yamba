package mobility.spawar.yamba;

import mobility.spawar.yamba.RestClient.RequestMethod;
import android.os.AsyncTask;

/**
 * An AsyncTask implementation for performing GETs on the Hypothetical REST
 * APIs.
 */
public class GetTask extends AsyncTask<String, String, String> {

	private String mRestUrl;
	private RestTaskCallback mCallback;


    /**
	 * Creates a new instance of GetTask with the specified URL and callback.
	 * 
	 * @param restUrl
	 *            The URL for the REST API.
	 * @param callback
	 *            The callback to be invoked when the HTTP request completes.
	 * 
	 */
	public GetTask(String restUrl, RestTaskCallback callback) {
		this.mRestUrl = restUrl;
		this.mCallback = callback;
	}

	@Override
	protected String doInBackground(String... params) {
		String response = null;		
		RestClient client = new RestClient(mRestUrl);
		
		try {
		    client.Execute(RequestMethod.GET);
		} catch (Exception e) {
		    e.printStackTrace();
		}

		response = client.getResponse();
		// Use HTTP Client APIs to make the call.
		// Return the HTTP Response body here.
		return response;
	}

	@Override
	protected void onPostExecute(String result) {
		mCallback.onTaskComplete(result);
		super.onPostExecute(result);
	}
	

}