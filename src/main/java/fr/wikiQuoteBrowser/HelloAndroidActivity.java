package fr.wikiQuoteBrowser;

import fr.kaplux.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "testAndroid";
    
 // Create an anonymous implementation of OnClickListener
    private OnClickListener searchListener = new OnClickListener() {
        public void onClick(View v) {
        	WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
        	TextView searchCriteria= (TextView)findViewById(R.id.searchCriteria);
			String result=wiki.searchQuote(searchCriteria.getText().toString());
			WebView searchResult= (WebView)findViewById(R.id.searchResult);
			String html = "<html><body>some html here</body></html>"; 
			searchResult.loadData(result, "text/html", "UTF-8");


			
        }
    };

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		
        setContentView(R.layout.main);
        // Capture our button from layout
	    Button button = (Button)findViewById(R.id.searchButton);
	    // Register the onClick listener with the implementation above
	    button.setOnClickListener(searchListener);
    }

 

}

