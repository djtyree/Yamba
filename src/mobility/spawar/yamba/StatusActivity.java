package mobility.spawar.yamba;

import mobility.spawar.yamba.RestClient.RequestMethod;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class StatusActivity extends Activity implements OnClickListener {
	EditText editStatus;
	TextView editPullStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		editStatus = (EditText) findViewById(R.id.edit_update_status);
		editPullStatus = (TextView) findViewById(R.id.edit_pull_status);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status, menu);
		return true;
	}

	public void onClick(View v) {
		String statusText = editStatus.getText().toString();

		Log.d("Status Activity", "onClicked with: " + statusText);
		/*
		RestClient client = new RestClient(
				"http://fusion.local/services/api/rest/xml/?method=wire.get_posts&limit=2&offset=2&username=admin");

		try {
			client.Execute(RequestMethod.GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String response = client.getResponse();
		Log.d("Status Activity", "response with: " + response);
		*/
	}
	
	public void onClickPull(View v) {
		String statusText = "Testing";
		Log.d("Status Activity", "pull test with: " + statusText);
		editPullStatus.setText(statusText);
	}

}
