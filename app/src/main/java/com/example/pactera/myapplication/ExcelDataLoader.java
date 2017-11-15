package com.example.pactera.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by pactera on 2017/11/10.
 */
public class ExcelDataLoader extends AsyncTask<String,Void,ArrayList<CountryModel>> {

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


        ArrayList<CountryModel> modelArrayList = getExcel.GetCountry("/mnt/sdcard/test.xls", params[0], 1);
        Log.d("ExcelDataLoader",modelArrayList.toString());
        return modelArrayList;
    }
}
