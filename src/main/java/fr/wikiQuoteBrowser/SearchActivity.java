package fr.wikiQuoteBrowser;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import fr.wikiquotebrowser.R;

public class SearchActivity extends Activity {

	private static String TAG = "wikiQuoteBrowser";

	final Activity searchActivity = this;
	
	private OnClickListener searchListener = new OnClickListener() {
		public void onClick(View v) {

			final TextView searchCriteriaView = (TextView) findViewById(R.id.searchCriteria);
			final ProgressDialog progressDialog = ProgressDialog.show(
					searchActivity, "Searching", "please wait", true);
			new AsyncTask<Void, Void, String[]>() {

				@Override
				protected String[] doInBackground(Void... params) {
					return searchQuote(searchCriteriaView.getText());
				}

				protected void onPreExecute() {
					super.onPreExecute();
				}

				protected void onPostExecute(String[] result) {
					progressDialog.dismiss();
					handleSearchResult(result);
				}

			}.execute();

		}
	};

	private String[] searchQuote(final CharSequence searchText) {
		String[] result = new String[0];
		WikiQuoteAccess wiki = new WikiQuoteAccess(
				"http://en.wikiquote.org/w/api.php");
		try {
			result = wiki.searchQuote(searchText.toString());
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
		return result;
	}

	private void handleSearchResult(String[] result) {
		if (result.length == 0) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					searchActivity);
			builder.setMessage("No result found")
					.setCancelable(false)
					.setPositiveButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.dismiss();
								}
							});
			builder.create().show();
		} else if (result.length == 1) {
			Intent intent = new Intent(getApplicationContext(),
					DisplayQuotePageActivity.class);
			Bundle bundle = new Bundle();
			bundle.putCharSequence("selectedPage", result[0]);
			intent.putExtras(bundle);
			startActivity(intent);
		} else {
			Intent intent = new Intent(getApplicationContext(),
					SearchResultActivity.class);
			Bundle bundle = new Bundle();
			bundle.putStringArray("searchResults", result);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		setContentView(R.layout.search_layout);

		// Capture our button from layout
		Button button = (Button) findViewById(R.id.searchButton);
		// Register the onClick listener with the implementation above
		button.setOnClickListener(searchListener);
	}

}
