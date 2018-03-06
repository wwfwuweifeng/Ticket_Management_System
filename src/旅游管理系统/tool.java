package 旅游管理系统;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class tool {

	//从计算机中获取时间
	public  String Gettime(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		System.out.println(year+"."+month+"."+date);
		return year+"."+month+"."+date;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tool tool =new tool();
		tool.Gettime();
		
	}

}
