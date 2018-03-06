package ���ι���ϵͳ;

import java.util.Calendar;
import java.util.Vector;

import org.eclipse.osgi.container.namespaces.EclipsePlatformNamespace;
import org.omg.CORBA.StringHolder;

import com.ibm.icu.util.BytesTrie.Result;

public class function {
	
	public int address_data=1,address_time=2,address_start=3,address_end=4,address_name=5,address_tel=6,address_people=7,
			address_money=8,address_remarks=9,address_order=11;
		public FileOperation file_operation=new FileOperation();
	//���ڴ�һ�����ַ����У���ȡ��Ӧλ�õ��ַ���
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
	
	//�жϵ�¼��Ϣ�Ƿ���ȷ
	public String Login_Judge(Vector<String> file_getname,String tx_get){
		String single_user;
		String user_information="";
		for(int i=0;i<file_getname.size();i++)
		{
			//�˺�-����-����
			single_user=Get_Text(file_getname.get(i),1)+"-"+Get_Text(file_getname.get(i),2)+"-"+Get_Text(file_getname.get(i),3)+"-";
			if(tx_get.equals(single_user)){
				user_information=Get_Text(file_getname.get(i),1)+"-"+Get_Text(file_getname.get(i),4);
				return user_information;
			}
		}
		return "no";
	}
	
	//ע����ύ
	public int Register_Submit(Vector<String> file_getname,String tx_get){
		tx_get=tx_get.replaceAll(" ", "");
		String[] s=tx_get.split("-");
		if(s.length==5){
			if(s[3].equals(s[4])){
				for(int i=0;i<file_getname.size();i++){
					if(s[0].equals(Get_Text(file_getname.get(i),1))){
						return -1;       //���˺��Ѿ���ע��
					}
				}
				return 1;                //����Ϸ����Ҹ��˺�δע��
			}
			return 0;       //������������벻һ��
		}
		return 2;   //�����ʽ�Ƿ�	
	}


	//��ѯ����еĲ�ѯ����
	public Vector<Integer> Query_Find(Vector<String> file_getinformation,String query_condition,String query_word){
		Vector<Integer> t=new Vector<Integer>();
		int flag=1;//�����ж��Ƿ����ҵ���Ӧ��Ԫ��
		switch (query_condition) {
		case "������":
			for(int i=0;i<file_getinformation.size();i++){
				if(Get_Text(file_getinformation.get(i),address_data).equals(query_word)){
					t.add(i);
					flag=0;
				}
			}
		break;
		case "��·��":
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
			//��������
			if(query_word.length()>=3&&query_word.substring(0, 2).equals("wh")){
				for(int i=0;i<file_getinformation.size();i++){
					if(query_word.equals(Get_Text(file_getinformation.get(i), address_order))){
						flag=0;
						t.add(i);
						break;
					}
				}
				
			}else if(query_word.length()>=7){  //���ڵ���7�϶�Ϊ�ֻ����룬С��7�϶�Ϊ����
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
	
	//���ڲ��Ҷ����ŵ�λ��
	public int find_num_order(Vector<String> file_getinformation,String order,int select){
		String t_order;
		if(select==1){ //��������������ַ���
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
	
	//ͳ������е��������ͽ��
	public String Statistics_Total(Vector<String> file_getinformation){
		int num_peopele=0;
		double num_money=0;
		String t_people;
		String t_money;
		for(int i=0;i<file_getinformation.size();i++){
			t_people=Get_Text(file_getinformation.get(i), address_people); //��ȡ���ʶ���������
			t_money=Get_Text(file_getinformation.get(i), address_money); //��ȡ���ʶ����Ľ��
			num_money=num_money+Double.parseDouble(t_money);
			num_peopele=num_peopele+Integer.parseInt(t_people);
		}
		num_money=((int)(num_money*100))/100;	
		return (num_peopele+"-"+num_money);
	}
	
	//Ѱ��ƥ��·�߶�Ӧ����ϸ��Ϣ
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
	
	//ͳ������в鿴ͳ����Ϣ
	public Vector<String> Statistics_Find(Vector<String> file_getinformation,String statistics_word){
		Vector<String> t=new Vector<String>();
		int first_flag=1;//���ڱ���Ƿ��ҵ������Ϣ
		if(file_getinformation.size()==0){
			t.add("û�в�ѯ�������Ϣ");
			return t;
		}
		switch (statistics_word) {
		case "���ص����鿴ͳ����Ϣ":
			String address="";
			String data="";  //��¼����
			String time="";	//��¼ʱ��
			int flag=1;   //������һ�����
			int num_people=0;  //������¼����
			while(file_getinformation.size()>0){
				address=Get_Text(file_getinformation.get(0), address_start)+"-"+Get_Text(file_getinformation.get(0),address_end);
		//		t.add(address+":");  //�ȰѸõص����
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
								t.add(data+"-"+time+"-"+address+"-"+num_people+"��");
								i--;
								flag=1;
								num_people=0;
							}
						}else{
							t.add(data+"-"+time+"-"+address+"-"+num_people+"��");
							i--;
							flag=1;
							num_people=0;
						}
					}
				}
				t.add(data+"-"+time+"-"+address+"-"+num_people+"��");  //�����һ�ε����ݴ���
				flag=1;
				num_people=0;
			}
	//		System.out.println("1");
			break;
		case "�����ڷ���鿴ͳ����Ϣ":
	//		System.out.println("2");
			String data_data="";        //������¼���� 
			String data_place="";  //��¼��ͬ�ص�
			String data_time="";	//��¼ʱ��
			int data_flag=1;   //������һ�����
			int data_people=0;  //������¼����
			for(int j=0;j<file_getinformation.size();j++){
				//��ȡ���ں�ʱ��
				if(data_flag==1){
					data_data=Get_Text(file_getinformation.get(j), address_data);
					data_time=Get_Text(file_getinformation.get(j), address_time);
			//		t.add(data_data+"-"+data_time+"��");
					data_flag=2;
				}
				//�������
				if(data_data.equals(Get_Text(file_getinformation.get(j), address_data))){
					//ʱ�����
					if(data_time.equals(Get_Text(file_getinformation.get(j), address_time))){
						//��ȡ�ص�
						if(data_flag==2){
							data_place=Get_Text(file_getinformation.get(j), address_start)+"-"+Get_Text(file_getinformation.get(j),address_end);
							data_flag=0;
						}
						//�յ����
						if(data_place.equals(Get_Text(file_getinformation.get(j), address_start)+"-"+Get_Text(file_getinformation.get(j),address_end))){
				//====================================================================================�˴���Ҫ�޸�			
							
							data_people=data_people+Integer.parseInt(Get_Text(file_getinformation.get(j),address_people));
						}else{
							//�ص㲻��
							j--;
							t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"��");
							data_flag=2;
							data_people=0;
						}
					}else{
						//ʱ�䲻��
						j--;
						t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"��");
						data_people=0;
						data_flag=1;
					}
				}else{
					//���ڲ���
					j--;
					t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"��");
					data_people=0;
					data_flag=1;
				}
			}
			t.add(data_data+"-"+data_time+"-"+data_place+"-"+data_people+"��"); //�����һ�ε����ݴ���
			break;
		default:
			break;
		}
		return t;
	}
	
	//��ȡ�����֤��
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

	// s_1���Ѿ���������ģ�s_2�ǽ�Ҫ�����
	//�Ƚ�����
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
	//�Ƚϵص�
	public boolean Compare_Address(String s_1,String s_2){
		String address_1=Get_Text(s_1, 3)+"-"+Get_Text(s_1, 4);
		String address_2=Get_Text(s_2, 3)+"-"+Get_Text(s_2, 4);
		if(address_1.equals(address_2)){
			return true;
		}else{
			return false;
		}
	}
	//�Ƚ�ʱ��
	public int Compare_Time(String s_1,String s_2){
		String[] time_1=Get_Text(s_1, address_time).split(":");
		String[] time_2=Get_Text(s_2, address_time).split(":");
		int min_1=Integer.parseInt(time_1[0])*60+Integer.parseInt(time_1[1]);
		int min_2=Integer.parseInt(time_2[0])*60+Integer.parseInt(time_2[1]);
		if(min_1>min_2){
			return 1; //���Ҫ�����ʱ����Ѿ��������С
		}else if(min_1==min_2){
			return 0;//���
		}else{
			return -1;
		}
	}
	
	//·������
	public Vector<String> Sort_Road(Vector<String> road){

		Vector<String> road_result=new Vector<String>();
		for(int i=0;i<road.size();i++){
			//��һ������
			if(road_result.size()==0){
				road_result.add(road.get(0));
			}else{
				for(int j=0;j<road_result.size();j++){
					//�ص���ͬ
					if(Compare_Address(road_result.get(j), road.get(i))){
						//Ҫ�����ʱ����Ѿ����ڵ�С����ȵ�ʱ��ֱ�Ӳ���
						if(Compare_Data(road_result.get(j), road.get(i))>=0){
							road_result.insertElementAt(road.get(i),j);
							break;
						}else{
							//�Ѿ�������ͬ�ص��ĩβ
							if((j+1)<road_result.size()&&!Compare_Address(road_result.get(j+1), road.get(i))){
								road_result.insertElementAt(road.get(i),j+1);
								break;
							}else if(j==(road_result.size()-1)){ //�Ѿ�����ĩβ��
								road_result.add(road.get(i));
								break;
							}else{
								continue;
							}
						}
					}else{
						//����ĩβ�ˣ���û�ҵ���ͬ�ص㣬ֱ�Ӳ���
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
	
	//�ж��Ƿ���ͬһ���
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
	
	//��·���������и���
	public void Updata_road(){
		Vector<String> file_getroad=new Vector<String>();
		Vector<String> file_getinformation=new Vector<String>();
		file_getroad=file_operation.read("road_information");
		file_getinformation=file_operation.read("ticket");
		int num_people;
		int flag;
		for(int i=0;i<file_getroad.size();i++){
			num_people=0;//�Ѿ�Ԥ����
			flag=1; //��ʶ�Ƿ��ҵ��ص�
			for(int j=0;j<file_getinformation.size();j++){
				//·����ͬ
				if(Compare_Road(file_getinformation.get(j),file_getroad.get(i))){
					flag=0;
					num_people=num_people+Integer.parseInt(Get_Text(file_getinformation.get(j), address_people));
					file_getinformation.remove(j);
					j--;
				}else{
					//�Ѿ�������ͬ·�ߵ����һ������һ����
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
	//����µ�·��ʱ��һЩ�ж�
	public String Add_New_Road(String new_road){
		new_road=new_road.replaceAll(" ", "");
	//	System.out.println(new_road);
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH);
		int hour=show_data.get(Calendar.HOUR_OF_DAY);
		int min=show_data.get(Calendar.MINUTE);
		int time_1=hour*60+min;   //��ǰ��ʱ��
		String[] road_start=new_road.split("-");
		String[] time=road_start[1].split(":");
		int time_2=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);   //Ҫ���·�ߵ�ʱ��
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
				//Ҫ��ӵ�·��Ϊ�����
				if(road_start[i].equals(data)){
					//���巢��ʱ�䲻��һСʱ
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
	
	//��ȡ·��
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
	
	//��ȡ·������
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

	//��ȡ·��ʱ��
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

	//��ȡ��·������
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
	
	//��ȡ��·�ߵļ۸�
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

	//��Ʊ��������
	public void Sort_Ticket(String new_ticket){
		Vector<String> file_getticket=new Vector<String>();
		file_getticket=file_operation.read("ticket");
		int ticket_address=find_num_order(file_getticket,new_ticket ,1);
		if(ticket_address>=0){
			file_getticket.remove(ticket_address);
		}
		if(file_getticket.size()==0){
			file_getticket.add(new_ticket);    //��һ������
		}else{
			int flag=0;
			for(int i=0;i<file_getticket.size();i++){
				//���Ҫ�����Ʊ�����ڱ��Ѿ����������С
				if(Compare_Data(file_getticket.get(i),new_ticket)==1){
					flag=-1;
					file_getticket.insertElementAt(new_ticket, i);
					break;
				}else if(Compare_Data(file_getticket.get(i),new_ticket)==0){ //�������
					flag=1;  //�н���������ȵ�
					//���Ҫ�����Ʊ��ʱ����Ѿ����������С
					if(Compare_Time(file_getticket.get(i), new_ticket)==1){
						flag=-1;
						file_getticket.insertElementAt(new_ticket, i);
						break;
						}else if(Compare_Time(file_getticket.get(i), new_ticket)==0){  //������ȣ�ʱ�����
						flag=2; //�н������ڣ�ʱ����ȵ�
						//Ҫ�����Ʊ�ĵص�͵�ǰ�Ƚϵ���ͬ
						if(Compare_Address(file_getticket.get(i), new_ticket)){
							flag=-1;
							file_getticket.insertElementAt(new_ticket, i);
							break;
						}
					}else if(flag==2){
						//��ͬ�����У�ʱ�䲻��
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

	//��ȡ�û�����
	public Vector<String> Get_User_Name(){
		Vector<String> file_getusername=new Vector<String>();
		file_getusername=file_operation.read("username");
		Vector<String> user_name=new Vector<String>();
		String single_user="";
		for(int i=0;i<file_getusername.size();i++){
			single_user="�˺�:"+Get_Text(file_getusername.get(i), 1)+"   ����:"+Get_Text(file_getusername.get(i),4);
			user_name.add(single_user);
		}
		return user_name;
	}

	//�������
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

	//���Ƴ�ĳ�û���ʱ�򣬸�������
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

	//���Ѿ����ڵ�·���Ƴ���ָ���ļ���
	public void Remove_Dead_Road(){
		Vector<String> dead_road=new Vector<String>();
		Vector<String> alive_road=new Vector<String>();
		dead_road=file_operation.read("dead_road");
		alive_road=file_operation.read("road_information");
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH)+"-";
		String time="-"+show_data.get(Calendar.HOUR_OF_DAY)+":"+show_data.get(Calendar.MINUTE)+"-";
		for(int i=0;i<alive_road.size();i++){
			//���ڱ����ڵ�С��
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

	//�ж�Ʊ�Ƿ��ѹ���
	public boolean Judge_Ticket(String change_ticket){
	//	String[] ticket=change_ticket.split("-");
		Calendar show_data = Calendar.getInstance();
		String data=show_data.get(Calendar.YEAR)+"."+(show_data.get(Calendar.MONTH)+1)+"."+show_data.get(Calendar.DAY_OF_MONTH)+"-";
		String time="-"+show_data.get(Calendar.HOUR_OF_DAY)+":"+show_data.get(Calendar.MINUTE)+"-";
		if(Compare_Data(data,change_ticket)==1){
			//���ڱȵ�ǰ����С,�Թ���
			return true;
		}else if(Compare_Data(data,change_ticket)==0&&Compare_Time(time,change_ticket)>=0){
			//������ȣ�ʱ��ȵ�ǰʱ��С�����,�ѹ���
			return true;
		}else{
			return false;
		}
		
	}

	//����ָ���û����ļ���
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
					single_ticket=file_getuser.get(j)+"�����-";
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
			return 1; //��Ϣû��д����
		}
		int flag_1=0;
		for(int i=0;i<file_getname.size();i++){
			if(Get_Text(file_getname.get(i),1).equals(single_user[0])){
				flag_1=1;
				break;
			}
		}
		if(flag_1!=1){
			return 2;   //�˻�������
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
			return 3;//��������
		}
		
		if(!single_user[2].equals(single_user[3])){
			return 4; //�������벻һ��
		}
		return 5; //һ����ȷ
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

