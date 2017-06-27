package com.example.venkatesh.pyrolam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by venkatesh on 23-04-2017.
 */
public class CountryLists extends Activity{
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.country_list_activity);
            String[] countries = {"Australia-Newzeland","Europe","North-Central-Africa","Russia-Asia","Southern Africa","South America","South Asia","South-East Asia","USA-Hawai"};
            ListAdapter customListAdapter = new CustomAdapter(this, countries);
            ListView customListView = (ListView)findViewById(R.id.listView);
            customListView.setAdapter(customListAdapter);


            customListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String food = String.valueOf(parent.getItemAtPosition(position));

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://projectpyrolam.000webhostapp.com/"+food+".html"));

                            startActivity(browserIntent);
                        }
                    }
            );
        }

}
