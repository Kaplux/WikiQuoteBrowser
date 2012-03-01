package fr.wikiQuoteBrowser;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import fr.kaplux.R;

public class SearchResultActivity extends ListActivity {

    private static String TAG = "testAndroid";
      /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);

    	  setListAdapter(new ArrayAdapter<String>(this, R.layout.search_result_item, this.getIntent().getExtras().getStringArray("searchResults")));

    	  ListView lv = getListView();
    	  lv.setTextFilterEnabled(true);

    	  lv.setOnItemClickListener(new OnItemClickListener() {
    	    public void onItemClick(AdapterView<?> parent, View view,
    	        int position, long id) {
    	      // When clicked, show a toast with the TextView text
    	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
    	          Toast.LENGTH_SHORT).show();
    	    }
    	  });
     
    }

 

}

