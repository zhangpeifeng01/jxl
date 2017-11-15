package com.example.pactera.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((MainActivity) this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        } new ExcelDataLoader().execute("test.xls");

    }
    class ExcelDataLoader extends AsyncTask<String,Void,ArrayList<CountryModel>> {

        @Override
        protected void onPostExecute(ArrayList<CountryModel> countryModels) {
            super.onPostExecute(countryModels);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        public ExcelDataLoader() {
            super();
        }

        @Override
        protected void onCancelled(ArrayList<CountryModel> countryModels) {
            super.onCancelled(countryModels);
        }

        @Override
        protected ArrayList<CountryModel> doInBackground(String... params) {
            GetExcel getExcel = new GetExcel();


            String path = Environment.getExternalStorageDirectory().getPath()
;
            ArrayList<CountryModel> modelArrayList = getExcel.GetCountry(path+"/test.xls",params[0] , 0);
            Log.d("ExcelDataLoader",modelArrayList.toString());
            return modelArrayList;
        }
    }
}
