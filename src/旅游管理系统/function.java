package 旅游管理系统;

import java.util.Calendar;
import java.util.Vector;

import org.eclipse.osgi.container.namespaces.EclipsePlatformNamespace;
import org.omg.CORBA.StringHolder;

import com.ibm.icu.util.BytesTrie.Result;

public class function {
	
	public int address_data=1,address_time=2,address_start=3,address_end=4,address_name=5,address_tel=6,address_people=7,
			address_money=8,address_remarks=9,address_order=11;
		public FileOperation file_operation=new FileOperation();
	//用于从一长串字符串中，提取对应位置的字符串
	public String Get_Text(String first_s,int address){
		int i=address;
		String t=first_s;
		while(i>1)
		{
			i--;
			t=t.substring(t.indexOf('-')+1);
		}
		t=t.substring(0, t.indexOf('-'));
		
		return t;
	}
	
	//判断登录信息是否正确
	public String Login_Judge(Vector<String> file_getname,String tx_get){
		String single_user;
		String user_information="";
		for(int i=0;i<file_getname.size();i++)
		{
			//账号-密码-类型
			single_user=Get_Text(file_getname.get(i),1)+"-"+Get_Text(file_getname.get(i),2)+"-"+Get_Text(file_getname.get(i),3)+"-";
			if(tx_get.equals(single_user)){
				user_information=Get_Text(file_getname.get(i),1)+"-"+Get_Text(file_getname.get(i),4);
				return user_information;
			}
		}
		return "no";
	}
	
	//注册的提交
	public int Register_Submit(Vector<String> file_getname,String tx_get){
		tx_get=tx_get.replaceAll(" ", "");
		String[] s=tx_get.split("-");
		if(s.length==5){
			if(s[3].equals(s[4])){
				for(int i=0;i<file_getname.size();i++){
					if(s[0].equals(Get_Text(file_getname.get(i),1))){
						return -1;       //该账号已经被注册
					}
				}
				return 1;                //输入合法，且该账号未注册
			}
			return 0;       //两次输入的密码不一致
		}
		return 2;   //输入格式非法	
	}


	//查询面板中的查询功能
	public Vector<Integer> Query_Find(Vector<String> file_getinformation,String query_condition,String query_word){
		Vector<Integer> t=new Vector<Integer>();
		int flag=1;//用于判断是否有找到对应的元素
		switch (query_condition) {
		case "按日期":
			for(int i=0;i<file_getinformation.size();i++){
				if(Get_Text(file_getinformation.get(i),address_data).equals(query_word)){
					t.add(i);
					flag=0;
				}
			}
		break;
		case "按路线":
			String road_name;
			for(int i=0;i<file_getinformation.size();i++){
				road_name=Get_Text(file_getinformation.get(i), address_start)+"-"+Get_Text(file_getinformation.get(i),address_end);
				if(road_name.equals(query_word)){
					t.add(i);
					flag=0;
				}
			}
			break;
		case "manager":
			//订单查找
			if(query_word.length()>=3&&query_word.substring(0, 2).equals("wh")){
				for(int i=0;i<file_getinformation.size();i++){
					if(query_word.equals(Get_Text(file_getinformation.get(i), address_order))){
						flag=0;
						t.add(i);
						break;
					}
				}
				
			}else if(query_word.length()>=7){  //大于等于7认定为手机号码，小于7认定为姓名
				for(int i=0;i<file_getinformation.size();i++){
					if(Get_Text(file_getinformation.get(i),address_tel).equals(query_word)){
						t.add(i);
						flag=0;
					}
				}
			}else {
				for(int i=0;i<file_getinformation.size();i++){
					if(Get_Text(file_getinformation.get(i),address_name).equals(query_word)){
						t.add(i);
						flag=0;
					}
				}
			}
			break;
		default:
			break;
		}
		if(flag==1){
			t.add(-1);
		}
		return t;
	}
	
	//用于查找订单号的位置
	public int find_num_order(Vector<String> file_getinformation,String order,int select){
		String t_order;
		if(select==1){ //传入的是整个的字符串
			t_order=Get_Text(order, address_order);
		}else{
			t_order=order;
		}
		if(select!=4){
		int i;
		if(select==3){
			t_order=Get_Text(order, address_order);
			i=1;
		}else{
			i=0;
		}
		for(;i<file_getinformation.size();i++){
			if(file_getinformation.get(i).equals("=====")){
				continue;
			}else{
			String s=Get_Text(file_getinformation.get(i), address_order);
			if(t_order.equals(s)){
				return i;
			}
			}
		}
		}else{
			t_order=Get_Text(order, address_order);
			for(int j=0;j<file_getinformation.size();j++){
				if(file_getinformation.get(j).equals(t_order)){
					return 1;
				}
			}
		}
		return -1;
	}
	
	//统计面板中的总人数和金额
	public String Statistics_Total(Vector<String> file_getinformation){
		int num_peopele=0;
		double num_money=0;
		String t_people;
		String t_money;
		for(int i=0;i<file_getinformation.size();i++){
			t_people=Get_Text(file_getinformation.get(i), address_people); //获取单笔订单的人数
			t_money=Get_Text(file_getinformation.get(i), address_money); //获取单笔订单的金额
			num_money=num_money+Double.parseDouble(t_money);
			num_peopele=num_peopele+Integer.parseInt(t_people);
		}
		num_money=((int)(num_money*100))/100;	
		return (num_peopele+"-"+num_money);
	}
	
	//寻找匹配路线对应的详细信息
	public Vector<String> Get_Statistics_Ticket(String road){
		Vector<String> file_getticket=new Vector<String>();
		Vector<String> ticket=new Vector<String>();
		file_getticket=file_operation.read("ticket");
		for(int i=0;i<file_getticket.size();i++){
			if(Compare_Road(file_getticket.get(i), road)){
				ticket.add(file_getticket.get(i));
			}
		}
		return ticket;
	}
	
	//统计面板中查看统计信息
	public Vector<String> Statistics_Find(Vector<String> file_getinformation,String statistics_word){
		Vector<String> t=new Vector<String>();
		int first_flag=1;//用于标记是否找到相关信息
		if(file_getinformation.size()==0){
			t.add("没有查询到相关信息");
			return t;
		}
		switch (statistics_word) {
		case "按地点分类查看统计信息":
			String address="";
			String data="";  //记录日期
			String time="";	//记录时间
			int flag=1;   //用来做一个标记
			int num_people=0;  //用来记录人数
			while(file_getinformation.size()>0){
				address=Get_Text(file_getinformation.get(0), address_start)+"-"+Get_Text(file_getinformation.get(0),address_end);
		//		t.add(address+":");  //先把该地点存入
				for(int i=0;i<file_getinformation.size();i++){
					if(address.equals(Get_Text(file_getinformation.get(i), address_start)+"-"+Get_Text(file_getinformation.get(i),address_end))){
						if(flag==1){
							data=Get_Text(file_getinformation.get(i),address_data);
							time=Get_Text(file_getinformation.get(i),address_time);
							flag=0;
						}
						if(data.equals(Get_Text(file_getinformation.get(i), address_data))){
							if(time.equals(Get_Text(file_getinformation.get(i),address_time))){
								num_people=num_people+Integer.parseInt(Get_Text(file_getinformation.get(i),address_people));
								file_getinformation.remove(i);
								i--;
							}else{
								t.add(data+"-"+time+"-"+address+"-"+num_people+"人");
								i--;
								flag=1;
								num_people=0;
							}
						}else{
							t.add(data+"-"+time+"-"+address+"-"+num_people+"人");
							i--;
							flag=1;
							num_people=0;
						}
					}
				}
				t.add(data+"-"+time+"-"+address+"-"+num_people+"人");  //将最后一次的数据存入
				flag=1;
				num_people=0;
			}
	//		System.out.println("1");
			break;
		case "按日期分类查看统计信息":
	//		System.out.println("2");
			String data_data="";        //用来记录日期 
			String data_place="";  //记录不同地点
			String data_time="";	//记录时间
			int data_flag=1;   //用来做一个标记
			int data_people=0;  //用来记录人数
			for(int j=0;j<file_getinformation.size();j++){
				//获取日期和时间
				if(data_flag==1){
					data_data=Get_Text(file_getinformation.get(j), address_data);
					data_time=Get_Text(file_getinformation.get(j), address_time);
			//		t.add(data_data+"-"+data_time+"：");
					data_flag=2;
				}
				//日期相等
				if(data_data.equals(Get_Text(file_getinformation.get(j), address_data))){
					//时间相等
					if(data_time.equals(Get_Text(file_getinformation.get(j), address_time))){
						//获取地点
						if(data_flag==2){
							data_place=Get_Text(file_getinformation.get(j), address_start)+"-"+Get_Text(file_getinformation.get(j),address_end);
							data_flag=0;
						}
						//终点相等
						if(data_place.equals(Get_Text(file_getinformation.get(j), address_start)+"-"+Get_Text(file_getinformation.get(j),address_end))){
				//====================================================================================此处需要修改			
							
							data_people=data_people+Integer.parseInt(Get_Text(file_getinformation.get(j),address_people));
						}else{
							//地点不等
							j--;
							t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"人");
							data_flag=2;
							data_people=0;
						}
					}else{
						//时间不等
						j--;
						t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"人");
						data_people=0;
						data_flag=1;
					}
				}else{
					//日期不等
					j--;
					t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"人");
					data_people=0;
					data_flag=1;
				}
			}
			t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"人"); //将最后一次的数据存入
			break;
		default:
			break;
		}
		return t;
	}
	
	//获取随机验证码
	public String Get_Random(){
		
		int count=4;
		String s="";
		while(count>0){
			int num=48+(int)(Math.random()*75);
			if(num<=57||(num>=65&&num<=90)||(num>=97&&num<=122)){
				s=s+((char)num);
				count--;
			}
		}
		return s;
	}

	// s_1是已经存在里面的，s_2是将要插入的
	//比较日期
	public int Compare_Data(String s_1,String s_2){
		String t_1,t_2;
		int year_1=Integer.parseInt(s_1.substring(0,s_1.indexOf(".")));
		int year_2=Integer.parseInt(s_2.substring(0,s_2.indexOf(".")));
		t_1=s_1.substring(s_1.indexOf(".")+1);
		t_2=s_2.substring(s_2.indexOf(".")+1);
		int moth_1=Integer.parseInt(t_1.substring(0,t_1.indexOf(".")));
		int moth_2=Integer.parseInt(t_2.substring(0,t_2.indexOf(".")));
		t_1=t_1.substring(t_1.indexOf(".")+1);
		t_2=t_2.substring(t_2.indexOf(".")+1);
	//	System.out.println(t_1+"============");
		int data_1=Integer.parseInt(t_1.substring(0,t_1.indexOf("-")));
		int data_2=Integer.parseInt(t_2.substring(0,t_2.indexOf("-")));
		int num_1=year_1*10000+moth_1*100+data_1;
		int num_2=year_2*10000+moth_2*100+data_2;
//		System.out.println(num_1);
//		System.out.println(num_2);
		if(num_1>num_2){
			return 1;
		}else if(num_1==num_2){
			return 0;
		}else{
			return -1;
		}
	}
	//比较地点
	public boolean Compare_Address(String s_1,String s_2){
		String address_1=Get_Text(s_1, 3)+"-"+Get_Text(s_1, 4);
		String address_2=Get_Text(s_2, 3)+"-"+Get_Text(s_2, 4);
		if(address_1.equals(address_2)){
			return true;
		}else{
			return false;
		}
	}
	//比较时间
	public int Compare_Time(String s_1,String s_2){
		String[] time_1=Get_Text(s_1, address_time).split(":");
		String[] time_2=Get_Text(s_2, address_time).split(":");
		int min_1=Integer.parseInt(time_1[0])*60+Integer.parseInt(time_1[1]);
		int min_2=Integer.parseInt(time_2[0])*60+Integer.parseInt(time_2[1]);
		if(min_1>min_2){
			return 1; //如果要插入的时间比已经在里面的小
		}else if(min_1==min_2){
			return 0;//相等
		}else{
			return -1;
		}
	}
	
	//路线排序
	public Vector<String> Sort_Road(Vector<String> road){

		Vector<String> road_result=new Vector<String>();
		for(int i=0;i<road.size();i++){
			//第一条数据
			if(road_result.size()==0){
				road_result.add(road.get(0));
			}else{
				for(int j=0;j<road_result.size();j++){
					//地点相同
					if(Compare_Address(road_result.get(j), road.get(i))){
						//要加入的时间比已经存在的小或相等的时候，直接插入
						if(Compare_Data(road_result.get(j), road.get(i))>=0){
							road_result.insertElementAt(road.get(i),j);
							break;
						}else{
							//已经到达相同地点的末尾
							if((j+1)<road_result.size()&&!Compare_Address(road_result.get(j+1), road.get(i))){
								road_result.insertElementAt(road.get(i),j+1);
								break;
							}else if(j==(road_result.size()-1)){ //已经到达末尾了
								road_result.add(road.get(i));
								break;
							}else{
								continue;
							}
						}
					}else{
						//到达末尾了，还没找到相同地点，直接插入
						if((j+1)==road_result.size()){
							road_result.add(road.get(i));
							break;
						}else{
							continue;
						}
					}
				}
			}
		}
		return road_result;	
	}
	
	//判断是否是同一班次
	public boolean Compare_Road(String informatinon,String road){
		String s_1=Get_Text(informatinon, address_data)+Get_Text(informatinon, address_time)+Get_Text(informatinon, address_start)+Get_Text(informatinon, address_end);
		String s_2=Get_Text(road, address_data)+Get_Text(road, address_time)+Get_Text(road, address_start)+Get_Text(road, address_end);
//		System.out.println(s_1);
//		System.out.println(s_2+"===");
		if(s_1.equals(s_2)){
			return true;
		}else{
			return false;
		}
	}
	
	//对路线名单进行更新
	public void Updata_road(){
		Vector<String> file_getroad=new Vector<String>();
		Vector<String> file_getinformation=new Vector<String>();
		file_getroad=file_operation.read("road_information");
		file_getinformation=file_operation.read("ticket");
		int num_people;
		int flag;
		for(int i=0;i<file_getroad.size();i++){
			num_people=0;//已经预定的
			flag=1; //标识是否找到地点
			for(int j=0;j<file_getinformation.size();j++){
				//路线相同
				if(Compare_Road(file_getinformation.get(j),file_getroad.get(i))){
					flag=0;
					num_people=num_people+Integer.parseInt(Get_Text(file_getinformation.get(j), address_people));
					file_getinformation.remove(j);
					j--;
				}else{
					//已经到达相同路线的最后一个的下一个了
					if(flag==0){
						String road_new="";
						String[] s=file_getroad.get(i).split("-");
						int total_people=Integer.parseInt(s[5]);
						int rest_people=total_people-num_people;
						s[6]=num_people+"";
						s[7]=rest_people+"";
						for(int k=0;k<8;k++){
							road_new=road_new+s[k]+"-";
			//				System.out.println(k+road_new);
						}
						file_getroad.remove(i);
						file_getroad.insertElementAt(road_new, i);
						flag=2;
						break;
					}
				}	
			}
			if(flag==0){
				String road_new="";
				String[] s=file_getroad.get(i).split("-");
				int total_people=Integer.parseInt(s[5]);
				int rest_people=total_people-num_people;
				s[6]=num_people+"";
				s[7]=rest_people+"";
				for(int k=0;k<8;k++){
					road_new=road_new+s[k]+"-";
			//		System.out.println(k+road_new);
				}
				file_getroad.remove(i);
				file_getroad.insertElementAt(road_new, i);
				flag=2;
			}
		}
		
		file_operation.write(file_getroad, "road_information");
		
	}
	//添加新的路线时的一些判断
	public String Add_New_Road(String new_road){
		new_road=new_road.replaceAll(" ", "");
	//	System.out.println(new_road);
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH);
		int hour=show_data.get(Calendar.HOUR_OF_DAY);
		int min=show_data.get(Calendar.MINUTE);
		int time_1=hour*60+min;   //当前的时间
		String[] road_start=new_road.split("-");
		String[] time=road_start[1].split(":");
		int time_2=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);   //要添加路线的时间
		String road_last="";
		String road_time="";
		Vector<String> file_getroad=new Vector<String>();
		file_getroad=file_operation.read("road_information");
	//	System.out.println(new_road+"===========");
		for(int j=0;j<file_getroad.size();j++){
			if(Compare_Road(new_road, file_getroad.get(j))){
				System.out.println(new_road);
				road_last="old-";
				return road_last;
			}
		}
		road_time=time[0]+":"+time[1];
//		if(Integer.parseInt(time[0])<10){
//			road_time="0"+time[0]+":";
//		}else{
//			road_time=time[0]+":";
//		}
//		if(Integer.parseInt(time[1])<10){
//			road_time=road_time+"0"+time[1];
//		}else{
//			road_time=road_time+time[1];
//		}
		road_start[1]=road_time;
	//	System.out.println(data);
		if(road_start.length<6){
			road_last="no-";
			return road_last;
		}
		for(int i=0;i<road_start.length;i++){
		//	System.out.println(road_start[i]);
			if(i==0){
				//要添加的路线为当天的
				if(road_start[i].equals(data)){
					//具体发车时间不足一小时
					if(time_1>(time_2-60)){
						road_last="time-";
						return road_last;
					}else{
						road_last=road_last+road_start[i]+"-";
					}
				}else{
					road_last=road_last+road_start[i]+"-";
				}
			}else{
				road_last=road_last+road_start[i]+"-";
			}
		}
			road_last=road_last+"0-"+road_start[road_start.length-1];
			return road_last;
	}
	
	//获取路线
	public Vector<String> Get_Road(){
		Vector<String> road_result=new Vector<String>();
		Vector<String> road=new Vector<String>();
		road=file_operation.read("road_information");
		for(int i=0;i<road.size();i++){
			String single_road=Get_Text(road.get(i),3)+"-"+Get_Text(road.get(i), 4);
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
		file_road=file_operation.read("road_information");
		String result="";
		String single_road;
		String data="";
		for(int i=0;i<file_road.size();i++){
			single_road=Get_Text(file_road.get(i),3)+"-"+Get_Text(file_road.get(i), 4);
			if(single_road.equals(road_name)){
				if(!data.equals(Get_Text(file_road.get(i),1))){
					data=Get_Text(file_road.get(i),1);
					result=result+data+"-";
				}
			}
		}
		return result;	
	}

	//获取路线时间
	public String Get_Road_Time(String road_name,String road_data){
		Vector<String> file_road=new Vector<String>();
		file_road=file_operation.read("road_information");
		String result="";
		String single_road;
		String data;
		String time="";
		for(int i=0;i<file_road.size();i++){
			single_road=Get_Text(file_road.get(i),3)+"-"+Get_Text(file_road.get(i), 4);
			if(single_road.equals(road_name)){
				data=Get_Text(file_road.get(i),1);
				if(data.equals(road_data)){
					if(!time.equals(Get_Text(file_road.get(i), 2))){
						time=Get_Text(file_road.get(i), 2);
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
		file_road=file_operation.read("road_information");
		int num;
		for(int i=0;i<file_road.size();i++){
			singel_road=Get_Text(file_road.get(i), 1)+"-"+Get_Text(file_road.get(i), 2)+"-"+Get_Text(file_road.get(i), 3)+"-"+Get_Text(file_road.get(i), 4);
			if(road_information.equals(singel_road)){
				num=Integer.parseInt(Get_Text(file_road.get(i), 8));
				return num;
			}
		}
		return 0;
	}
	
	//获取该路线的价格
	public Double Get_Road_Money(String road_information){
		String singel_road;
		Vector<String> file_road=new Vector<String>();
		file_road=file_operation.read("road_information");
		double money;
		for(int i=0;i<file_road.size();i++){
			singel_road=Get_Text(file_road.get(i), 1)+"-"+Get_Text(file_road.get(i), 2)+"-"+Get_Text(file_road.get(i), 3)+"-"+Get_Text(file_road.get(i), 4);
			if(road_information.equals(singel_road)){
				money=Double.parseDouble(Get_Text(file_road.get(i), 5));
				return money;
			}
		}
		return 0.0;
	}

	//对票进行排序
	public void Sort_Ticket(String new_ticket){
		Vector<String> file_getticket=new Vector<String>();
		file_getticket=file_operation.read("ticket");
		int ticket_address=find_num_order(file_getticket,new_ticket ,1);
		if(ticket_address>=0){
			file_getticket.remove(ticket_address);
		}
		if(file_getticket.size()==0){
			file_getticket.add(new_ticket);    //第一条数据
		}else{
			int flag=0;
			for(int i=0;i<file_getticket.size();i++){
				//如果要加入的票的日期比已经存在里面的小
				if(Compare_Data(file_getticket.get(i),new_ticket)==1){
					flag=-1;
					file_getticket.insertElementAt(new_ticket, i);
					break;
				}else if(Compare_Data(file_getticket.get(i),new_ticket)==0){ //日期相等
					flag=1;  //有进入日期相等的
					//如果要加入的票的时间比已经存在里面的小
					if(Compare_Time(file_getticket.get(i), new_ticket)==1){
						flag=-1;
						file_getticket.insertElementAt(new_ticket, i);
						break;
						}else if(Compare_Time(file_getticket.get(i), new_ticket)==0){  //日期相等，时间相等
						flag=2; //有进入日期，时间相等的
						//要加入的票的地点和当前比较的相同
						if(Compare_Address(file_getticket.get(i), new_ticket)){
							flag=-1;
							file_getticket.insertElementAt(new_ticket, i);
							break;
						}
					}else if(flag==2){
						//相同日期中，时间不等
						flag=-1;
						file_getticket.insertElementAt(new_ticket, i);
						break;
					}
				}else if(flag==1){
					flag=-1;
					file_getticket.insertElementAt(new_ticket, i);
					break;
				}
			}
			if(flag!=-1){
				file_getticket.add(new_ticket);
			}
		}
		file_operation.write(file_getticket, "ticket");
	}

	//获取用户名单
	public Vector<String> Get_User_Name(){
		Vector<String> file_getusername=new Vector<String>();
		file_getusername=file_operation.read("username");
		Vector<String> user_name=new Vector<String>();
		String single_user="";
		for(int i=0;i<file_getusername.size();i++){
			single_user="账号:"+Get_Text(file_getusername.get(i), 1)+"   姓名:"+Get_Text(file_getusername.get(i),4);
			user_name.add(single_user);
		}
		return user_name;
	}

	//更新余额
	public void Updata_Surpls(String account){
		String[] user=account.split("-");
		Vector<String> file_getusername=new Vector<String>();
		file_getusername=file_operation.read(user[0]);
		String[] old_user=file_getusername.get(0).split("-");
		String new_user="";
		for(int i=0;i<old_user.length;i++){
			if(i==6){
				new_user=new_user+user[1]+"-";
			}else {
				new_user=new_user+old_user[i]+"-";
			}
		}
		file_getusername.remove(0);
		file_getusername.insertElementAt(new_user, 0);
		file_operation.write(file_getusername, user[0]);
	}

	//当移除某用户的时候，更新名单
	public void Updata_User_Name(String account){
		Vector<String> file_getusername=new Vector<String>();
		file_getusername=file_operation.read("username");
		for(int i=0;i<file_getusername.size();i++){
			if(Get_Text(file_getusername.get(i), 1).equals(account)){
				file_getusername.remove(i);
				break;
			}
		}
		file_operation.write(file_getusername, "username");
	}

	//将已经过期的路线移除到指定文件夹
	public void Remove_Dead_Road(){
		Vector<String> dead_road=new Vector<String>();
		Vector<String> alive_road=new Vector<String>();
		dead_road=file_operation.read("dead_road");
		alive_road=file_operation.read("road_information");
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH)+"-";
		String time="-"+show_data.get(Calendar.HOUR_OF_DAY)+":"+show_data.get(Calendar.MINUTE)+"-";
		for(int i=0;i<alive_road.size();i++){
			//日期比现在的小了
			if(Compare_Data(data, alive_road.get(i))>0){
				dead_road.add(alive_road.get(i));
				alive_road.remove(i);
				i--;
			}else if(Compare_Data(data, alive_road.get(i))==0){
				if(Compare_Time(time, alive_road.get(i))>=0){
					dead_road.add(alive_road.get(i));
					alive_road.remove(i);
					i--;
				}
			}
		}
		file_operation.write(alive_road, "road_information");
		file_operation.write(dead_road, "dead_road");
	}

	//判断票是否已过期
	public boolean Judge_Ticket(String change_ticket){
	//	String[] ticket=change_ticket.split("-");
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH)+"-";
		String time="-"+show_data.get(Calendar.HOUR_OF_DAY)+":"+show_data.get(Calendar.MINUTE)+"-";
		if(Compare_Data(data,change_ticket)==1){
			//日期比当前日期小,以过期
			return true;
		}else if(Compare_Data(data,change_ticket)==0&&Compare_Time(time,change_ticket)>=0){
			//日期相等，时间比当前时间小或相等,已过期
			return true;
		}else{
			return false;
		}
		
	}

	//更新指定用户的文件夹
	public void Updata_User_Information(String account){
		Vector<String> file_getuser=new Vector<String>();
		file_getuser=file_operation.read(account);
		int address=0;
		for(int i=1;i<file_getuser.size();i++){
			if(file_getuser.get(i).equals("=====")){
				address=i;
				break;
			}
		}
		Vector<Integer> ticket_address=new Vector<Integer>();
		String single_ticket="";
		for(int j=address-1;j>0;j--){
			if(Judge_Ticket(file_getuser.get(j))){
					single_ticket=file_getuser.get(j)+"已完成-";
					file_getuser.insertElementAt(single_ticket, address+1);
					file_getuser.remove(j);
					address--;
					j--;
				}
			}
		file_operation.write(file_getuser, account);
		}
	
	public int Judge_account(String user){
		Vector<String> file_getname=new Vector<String>();
		String[] single_user=user.split("-");
		file_getname=file_operation.read("username");
		if(single_user.length<4){
			return 1; //信息没填写完整
		}
		int flag_1=0;
		for(int i=0;i<file_getname.size();i++){
			if(Get_Text(file_getname.get(i),1).equals(single_user[0])){
				flag_1=1;
				break;
			}
		}
		if(flag_1!=1){
			return 2;   //账户不存在
		}
		String name=single_user[0]+"-"+single_user[1];
		String name_2="";
		int flag_2=0;
		for(int i=0;i<file_getname.size();i++){
			name_2=Get_Text(file_getname.get(i),1)+"-"+Get_Text(file_getname.get(i), 4);
			if(name.equals(name_2)){
				flag_2=1;
				break;
			}
		}
		if(flag_2!=1){
			return 3;//姓名错误
		}
		
		if(!single_user[2].equals(single_user[3])){
			return 4; //两次密码不一致
		}
		return 5; //一切正确
	}

	public void Change_Pass(String user){
		String[] t=user.split("-");
		String single="";
		Vector<String> file_get=new Vector<String>();
		file_get=file_operation.read("username");
		for(int i=0;i<file_get.size();i++){
			if(Get_Text(file_get.get(i), 1).equals(t[0])){
				String[] s=file_get.get(i).split("-");
				for(int j=0;j<s.length;j++){
					if(j==1){
						single=single+t[2]+"-";
					}else {
						single=single+s[j]+"-";
					}
				}
				file_get.remove(i);
				file_get.insertElementAt(single, i);
				break;
			}
		}
		file_operation.write(file_get, "username");
		file_get.clear();
		file_get=file_operation.read(t[0]);
		String[] s_2=file_get.get(0).split("-");
		String single_2="";
		for(int k=0;k<s_2.length;k++){
			if(k==3){
				single_2=single_2+t[2]+"-";
			}else{
				single_2=single_2+s_2[k]+"-";
			}
		}
		file_get.remove(0);
		file_get.insertElementAt(single_2, 0);
		file_operation.write(file_get, s_2[0]);
		
	}
}

