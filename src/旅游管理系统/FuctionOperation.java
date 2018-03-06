package 旅游管理系统;

import java.awt.Paint;
import java.util.Vector;

public class FuctionOperation {
	
	private FileOperation fileOperation = new FileOperation();
	
	public Vector<String> sort_data(Vector<String> vc){
		Vector<String> v_result = new Vector<String>();
		
		return v_result;
	}
	public int find_position(String str,int number){
		int p = 0;
		while(number>0){
			p = str.indexOf("-" , p+1)+1;
			number--;
		}
		return p;
	}
	// (容器为ve_user )      账户=0、姓名=1、电话=2、密码=3、等级=4、信用=5、余额=6、
	public String GetInformation(String s_string, int choice){
		String str = new  String();
		int i = choice;
		int position = 0;
		while(i>0){
			position = s_string.indexOf("-" , position+1)+1;
			i--;
		}
		str = s_string.substring(position, s_string.indexOf("-" , position+1));
		return str;
	}
	
	public String changeinformation(String string ,String s_change , int position,int length){
		String s_result = "";
		int i = 0;
		while(i<length){
			if(i != position){
				s_result = s_result + GetInformation(string, i) + "-";
			}
			else if( i == position && (i == 6 || i==4 || i==5)){
				s_result = s_result + sumString(s_change,GetInformation(string, i)) + "-";
			}
			else{
				s_result = s_result + s_change + "-";
			}
			i++;
		}
		return s_result;
	}
	
	public String sumString(String s_change , String str){
		double num_1 ,num_2;
		num_1 = Double.valueOf(takenumber(s_change));
		num_2 = Double.valueOf(takenumber(str));
		s_change = Double.toString(num_1+num_2);
		return s_change;
	}
	
	public String takenumber(String str){
		String s_result = "";
		char[] deal = str.toCharArray();
		for(int i=0;i<deal.length;i++){
			if(Character.isDigit(deal[i]) || deal[i] == '.' || deal[i]=='-'){
				s_result = s_result +deal[i];
			}
		}
		return s_result;
	}
	
	//获取路线
		public Vector<String> Get_Road(){
			Vector<String> road_result=new Vector<String>();
			Vector<String> road=new Vector<String>();
			road=fileOperation.read("road_information");
			for(int i=0;i<road.size();i++){
				String single_road=GetInformation(road.get(i),2)+"-"+GetInformation(road.get(i), 3)+"-"+GetInformation(road.get(i),4);
				if(road_result.size()==0){
					road_result.add(single_road);
				}else{
					if(!single_road.equals(road_result.get(road_result.size()-1))){
						road_result.add(single_road);
					}
				}
			}
			return road_result;
		}
		
		//获取路线日期
		public String Get_Road_Data(String road_name){
			Vector<String> file_road=new Vector<String>();
			file_road=fileOperation.read("road_information");
			String result="";
			String single_road;
			String data="";
			for(int i=0;i<file_road.size();i++){
				single_road=GetInformation(file_road.get(i),2)+"-"+GetInformation(file_road.get(i), 3)+"-"+GetInformation(file_road.get(i),4);
				if(single_road.equals(road_name)){
					if(!data.equals(GetInformation(file_road.get(i),0))){
						data=GetInformation(file_road.get(i),0);
						result=result+data+"-";
					}
				}
			}
			return result;	
		}

		//获取路线时间
		public String Get_Road_Time(String road_name,String road_data){
			Vector<String> file_road=new Vector<String>();
			file_road=fileOperation.read("road_information");
			String result="";
			String single_road;
			String data;
			String time="";
			for(int i=0;i<file_road.size();i++){
				single_road=GetInformation(file_road.get(i),2)+"-"+GetInformation(file_road.get(i), 3)+"-"+GetInformation(file_road.get(i),4);
				if(single_road.equals(road_name)){
					data=GetInformation(file_road.get(i),0);
					if(data.equals(road_data)){
						if(!time.equals(GetInformation(file_road.get(i), 1))){
							time=GetInformation(file_road.get(i), 1);
							result=result+time+"-";
						}
					}
				}
			}
			return result;	
		}

		//获取该路线人数
		public int Get_Road_num(String road_information){
			String singel_road;
			Vector<String> file_road=new Vector<String>();
			file_road=fileOperation.read("road_information");
			int num;
			for(int i=0;i<file_road.size();i++){
				singel_road=GetInformation(file_road.get(i), 0)+"-"+GetInformation(file_road.get(i), 1)
				+"-"+GetInformation(file_road.get(i), 2)+"-"+GetInformation(file_road.get(i), 3)+"-"+GetInformation(file_road.get(i), 4);
				if(road_information.equals(singel_road)){
					num=Integer.parseInt(GetInformation(file_road.get(i), 7));
					return num;
				}
			}
			return 0;
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
