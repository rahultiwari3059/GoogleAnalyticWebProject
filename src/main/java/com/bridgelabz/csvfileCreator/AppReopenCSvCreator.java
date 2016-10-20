package com.bridgelabz.csvfileCreator;

import java.io.BufferedWriter;

import java.util.ArrayList;

import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseElementModel;

public class AppReopenCSvCreator {
	ArrayList<AppReOpenModel> appReOpenModelArrayList = new ArrayList<AppReOpenModel>();
	
	
	
	public ArrayList<AppReOpenModel> appReopenCSvCreator(ArrayList<ResponseElementModel> responseElementModelArrayList,
			GaReportInputModel gaReportInputModel)
	{
		try
		{
		if (gaReportInputModel.mGaID.equals("2")) {

			
			for (int i = 0; i < responseElementModelArrayList.size(); i++) {
				AppReOpenModel appReOpenModelObject = new AppReOpenModel();
				
				appReOpenModelObject.setmGaId(gaReportInputModel.getmGaID());

				
				appReOpenModelObject.setmGAdiscription(gaReportInputModel.getmGaDiscription());

				
				appReOpenModelObject.setmDate(responseElementModelArrayList.get(i).getmDate());

				
				appReOpenModelObject.setmAndroidId(responseElementModelArrayList.get(i).getmAndroidId());

				
				appReOpenModelObject
						.setmEventCategory(responseElementModelArrayList.get(i).getmEventCategory());

				appReOpenModelObject.setmTotalEvents(responseElementModelArrayList.get(i).getmTotalEvents());
				
				appReOpenModelArrayList.add(appReOpenModelObject);
			}
			

		}
		
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return appReOpenModelArrayList;
	}
	

}
