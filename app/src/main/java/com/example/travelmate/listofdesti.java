package com.example.travelmate;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class listofdesti extends AppCompatActivity {
    ListView SubjectFullFormListView;
    ProgressBar progressBar;
    String HttpURL = "http://masaclouddatabase.x10host.com/travelmate/displayall.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofdesti);
        SubjectFullFormListView = (ListView) findViewById(R.id.listNews);

        new ParseJSonDataClass(this).execute();
    }
    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;
        List<Subject> SubjectFullFormList;

        public ParseJSonDataClass(Context context) {

            this.context = context;
        }
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpServiceClass httpServiceClass = new HttpServiceClass(HttpURL);

            try {
                httpServiceClass.ExecutePostRequest();

                if (httpServiceClass.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClass.getResponse();

                    if (FinalJSonResult != null) {

                        JSONArray jsonArray = null;
                        try {

                            jsonArray = new JSONArray(FinalJSonResult);
                            JSONObject jsonObject;
                            Subject subject;

                            SubjectFullFormList = new ArrayList<Subject>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                subject = new Subject();

                                jsonObject = jsonArray.getJSONObject(i);

                                subject.Subject_Name = jsonObject.getString("destination");
                                subject.Subject_Full_Form = jsonObject.getString("address");
                                subject.SubjectLatitude = jsonObject.getString("latitude");
                                subject.SubjectLongitude = jsonObject.getString("longitude");
                                subject.Subjectfeedback= jsonObject.getString("feedback");

                                SubjectFullFormList.add(subject);
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {

                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            ListAdapter adapter = new ListAdapter(SubjectFullFormList, context);

            SubjectFullFormListView.setAdapter(adapter);

        }
    }
}
