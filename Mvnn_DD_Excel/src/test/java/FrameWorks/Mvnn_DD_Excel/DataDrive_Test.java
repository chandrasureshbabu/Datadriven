package FrameWorks.Mvnn_DD_Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





public class DataDrive_Test {

	public static void main(String[] args) throws IOException {
		
		
		DataDriven_Utlility_Complete d= new DataDriven_Utlility_Complete();
		
		
		List<String> list= new ArrayList<String>();
		
		
		list=d.getData("Add profile");
		
		for(Object obj:list)
		{
			System.out.println(obj);
		}
		
	}

}

