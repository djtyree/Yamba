package mobility.spawar.yamba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class StatusActivity extends Fragment implements OnClickListener {
	EditText editStatus;
	TextView editPullStatus;
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public StatusActivity() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.status,
				container, false);
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.status);

		editStatus = (EditText) rootView.findViewById(R.id.edit_update_status);
		editPullStatus = (TextView) rootView.findViewById(R.id.edit_pull_status);
		return rootView;

	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
*/
	public void onClick(View v) {
		String statusText = editStatus.getText().toString();

		Log.d("Status Activity", "onClicked with: " + statusText);

	}
	
	public void onClickPull(View v) {
		String statusText = "Testing";
		Log.d("Status Activity", "pull test with: " + statusText);
		
		FusionApi api = FusionApi.getInstance();
		api.getUserProfile("admin", new GetResponseCallback() {
			@Override
			void onDataReceived(Profile profile) {
				editPullStatus.setText(profile.getName());
			}
		});
	}

}
