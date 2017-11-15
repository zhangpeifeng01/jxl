package com.example.pactera.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by pactera on 2017/11/10.
 */
public class GetExcel {
    public static GetExcel instance;

    public GetExcel() {
    }

    public static  GetExcel getInstance() {
        if (instance == null) {
            instance = new GetExcel();
        }
        return instance;
    }

    /**
     *@param url   文件路径
     * @param xlsName  excel 表格的名称
     * @param index 第几张表格中的数据
     * @return
     */
    public ArrayList<CountryModel> GetCountry(String url,String xlsName, int index){
        ArrayList<CountryModel> modelArrayList = new ArrayList<CountryModel>();
       ;
        try {
            Workbook workbook = Workbook.getWorkbook(new FileInputStream(new File(url)));
            Sheet sheet = workbook.getSheet(index);
            int sheetNum = workbook.getNumberOfSheets();
            int sheetRows = sheet.getRows();
            int sheetColumns = sheet.getColumns();
            for (int i = 0; i < sheetRows; i++) {
                CountryModel countryModel = new CountryModel();
                countryModel.setName(sheet.getCell(0, i).getContents());

                countryModel.setNum(sheet.getCell(1, i).getContents());

                modelArrayList.add(countryModel);
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }


        return modelArrayList;
    }
}
