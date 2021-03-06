package FrameWorks.Mvnn_DD_Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Utlility1 {
	
	public ArrayList<String> getData(String testcasename) throws IOException
	{
		
		ArrayList<String> a=new ArrayList<String>();
		// fis object has access to the file in that path
		FileInputStream fis= new FileInputStream("E:\\Selenium Files_FrameworkPractce\\Dd_Practice1.xlsx");
		//pasing object to give access to workbook
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		// to get count of the sheets , since we may not know how many sheets are in workbook and to access specific sheet we need to have count of sheets
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			// if the specific sheet is found , then goes in the rows of the sheet , to find specific column 
			if(workbook.getSheetName(i).equalsIgnoreCase("dd"))
				
			{
				// if the specific is found , get that sheet by index
				XSSFSheet sheet= workbook.getSheetAt(i);
				// to get specific column we must traverse through the rows first in the specifc sheet
				//identify the column by scanning entire row
				
				Iterator<Row> rows= sheet.iterator();//sheet is collection nof the rows
				
				Row row=rows.next();
				
				Iterator<Cell> cell=row.cellIterator();//row is a collection of cells
				
				int k=0;
				int column= 0;
				while(cell.hasNext())
				{
					Cell value=cell.next();
					
					if(value.getStringCellValue().equalsIgnoreCase("testcases"))
					{
						System.out.println("Testcases column found");
						column=k;
					}
					k++;
				}
				System.out.println(column);
				// once testcase column is identified, we have look FOR PURCHOSE TESTCASE ROW
				while(rows.hasNext())
				{
					Row r=rows.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						
						System.out.println("Scanning for specific row");
						//after u get the purchase test case row then u have to feed  that row into test.
						Iterator<Cell> cv=r.cellIterator();
						
						while(cv.hasNext())
						{
							//System.out.println(cv.next().getStringCellValue());
							
							// adding/sending  values to the arraylist
							/*
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
								
							}else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}*/
							
							
							
							a.add(cv.next().getStringCellValue());
						}
					}
					
				}
				
			}
		}
		return a;
	}



}
