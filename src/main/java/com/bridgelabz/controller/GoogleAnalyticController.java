package com.bridgelabz.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.csvfileCreator.AppReopenCSvCreator;
import com.bridgelabz.csvfileCreator.MainCsvCreator;
import com.bridgelabz.csvfileCreator.SummaryReportcsvandelelementAssigner;
import com.bridgelabz.dao.HibernateDao;
import com.bridgelabz.inputReader.GaReprtInfoArrayList;
import com.bridgelabz.model.AppOpenModel;
import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseElementModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;

@Controller
public class GoogleAnalyticController {
	
	
	private static final String UPLOAD_DIRECTORY = "/home/bridgeit/Desktop/GoogleAnalyticwebproject/GoogleAnalyticReportingWeb/src/main/webapp/WEB-INF/FilePath/";

	@Resource(name="hibernateDao")
	private HibernateDao hibernateDaoObject;
	@RequestMapping("/uploadform")
	public ModelAndView uploadForm() {
		System.out.println("File upload get method");
		return new ModelAndView("uploadform");
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveJsonFile(@RequestParam MultipartFile file, HttpSession session) throws Exception {
		System.out.println("File upload post method");
		FileCopyUtils.copy(file.getBytes(), new FileOutputStream(UPLOAD_DIRECTORY + "/" + file.getOriginalFilename()));

		try {
			MainCsvCreator mainCsvCreatorObject= new MainCsvCreator();
			AppReopenCSvCreator appReopenCSvCreatorObject= new AppReopenCSvCreator();
			// creating object of GaReportResponseFetcher
			GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher();
			// creating object of DirectCsvFileCreator
			SummaryReportcsvandelelementAssigner summaryReportcsvandelelementAssignerObject = new SummaryReportcsvandelelementAssigner();

			// taking JSON file path
			String jsonfilepath = UPLOAD_DIRECTORY + "/" + file.getOriginalFilename();

			// creating object GaReprtInfoArrayList
			GaReprtInfoArrayList GaReprtInfoArrayListObject = new GaReprtInfoArrayList();
			
			// creating object of appOpenModelArrayList
			ArrayList<AppOpenModel> appOpenModelArrayList= new ArrayList<AppOpenModel>();
			//creating object of appReOpenModelArrayList
			ArrayList<AppReOpenModel> appReOpenModelArrayList = new ArrayList<AppReOpenModel>();
			
			// passing JSONpath and getting ArrayList of GaInputInfo
			ArrayList<GaReportInputModel> gaReportInputInfoArrayList = GaReprtInfoArrayListObject
					.readInputJsonFile(jsonfilepath);

			for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {

				// making ArrayList of response after passing JSON input info
				ArrayList<ResponseModel> responseModelArrayList = gaReportResponseFetcherObject
						.getResponse(gaReportInputInfoArrayList.get(i));

				// creating csv file by passing input info and response
				ArrayList<ResponseElementModel> responseElementModelArrayList = summaryReportcsvandelelementAssignerObject.responseElementmodelAssigner(gaReportInputInfoArrayList.get(i),
						responseModelArrayList.get(i));
			 appOpenModelArrayList=	mainCsvCreatorObject.mainCsvCreator(responseElementModelArrayList, gaReportInputInfoArrayList.get(i));
			 appReOpenModelArrayList= appReopenCSvCreatorObject.appReopenCSvCreator(responseElementModelArrayList, gaReportInputInfoArrayList.get(i));
				hibernateDaoObject.allElementSave(responseElementModelArrayList);
				
			}
			hibernateDaoObject.appOpenModelSave(appOpenModelArrayList);
			hibernateDaoObject.appReOpenModelSave(appReOpenModelArrayList);
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return new ModelAndView("uploadform", "filesuccess", "File successfully saved!");
	}
}