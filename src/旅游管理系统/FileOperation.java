package ���ι���ϵͳ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileOperation {
	
		 public void write(Vector<String> input_file,String filename){
	//		 String filepath="e:/workplace/��1/src/resours/"+filename;
			 String filepath=filename;
			 try {
				 File file=new File(filepath);
				 if(file.exists()){
					 
				 }else{
					 file.createNewFile();
					 System.out.println("�ļ��Ѵ�������ʼд��");
				 }
				 
				BufferedWriter writer=new BufferedWriter(new FileWriter(file));
				for(int i=0;i<input_file.size();i++){
					writer.write(input_file.get(i));
					writer.newLine();
				}
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println("д�����");
				System.exit(0);
			}
		 }
		 	//select=0,��ʾ�������Ļ�ԭ����Ʊ��select=1��ʾ����ɾ����Ʊ��select=2���޸ĵ�Ʊ,select_2=1 ��ʾ����
		 public void write_singel_ticket(String ticket,String filename,int select,int select_2){
			 	function fct=new function();
				Vector<String> user_information=new Vector<String>();
				user_information=read(filename);
				int address=fct.find_num_order(user_information, ticket, 3);
				System.out.println(address);
				if(select_2==1){
					double money_old;
					double money_new;
					double ticket_money_now=Double.parseDouble(fct.Get_Text(ticket, fct.address_money));
					double ticket_money_old;
					//�ĵĻ����˵�
					if(address!=-1){
						if(select==2){ //�ĵ�
						ticket_money_old=Double.parseDouble(fct.Get_Text(user_information.get(address),fct.address_money));
						double remind=ticket_money_old-ticket_money_now;
						money_old=Double.parseDouble(fct.Get_Text(user_information.get(0),7));
						money_new=money_old+remind;
						if(money_new<=0)money_new=0;
						String[] user_name=user_information.get(0).split("-");
						String single_name="";
						for(int k=0;k<user_name.length;k++){
							if(k==6){
								single_name=single_name+money_new+"-";
							}else{
								single_name=single_name+user_name[k]+"-";
							}
						}
						System.out.println(single_name);
						user_information.remove(0);
						user_information.insertElementAt(single_name, 0);
						}else if(select==1){ //�˵�
							ticket_money_old=Double.parseDouble(fct.Get_Text(user_information.get(address),fct.address_money));
							money_old=Double.parseDouble(fct.Get_Text(user_information.get(0),7));
							money_new=money_old+ticket_money_old;
							String[] user_name=user_information.get(0).split("-");
							String single_name="";
							for(int k=0;k<user_name.length;k++){
								if(k==6){
									single_name=single_name+money_new+"-";
								}else{
									single_name=single_name+user_name[k]+"-";
								}
							}
							System.out.println(single_name);
							user_information.remove(0);
							user_information.insertElementAt(single_name, 0);
						}
					}else{ //�����ӵ�
						ticket_money_old=Double.parseDouble(fct.Get_Text(ticket, fct.address_money));
						money_old=Double.parseDouble(fct.Get_Text(user_information.get(0),7));
						money_new=money_old-ticket_money_old;
						if(money_new<=0)money_new=0;
						String[] user_name=user_information.get(0).split("-");
						String single_name="";
						for(int k=0;k<user_name.length;k++){
							if(k==6){
								single_name=single_name+money_new+"-";
							}else{
								single_name=single_name+user_name[k]+"-";
							}
						}
						System.out.println(single_name);
						user_information.remove(0);
						user_information.insertElementAt(single_name, 0);
					}
					
				}
				if(select==0||select==2){
				if(address!=-1){
					user_information.remove(address);
					if(select==2){
					ticket=ticket+"��ǩ-";
					}
				}
				for(int i=1;i<user_information.size();i++){
					if(user_information.get(i).equals("=====")){
						user_information.insertElementAt(ticket, i);
						break;
					}else{
						//������
			//			System.out.println("==---==="+user_information.get(i));
					if(fct.Compare_Data(user_information.get(i),ticket)>0){
						user_information.insertElementAt(ticket, i);
						break;
						//������ȣ�ʱ����Ȼ�С
					}else if(fct.Compare_Data(user_information.get(i), ticket)==0&&fct.Compare_Time(user_information.get(i),ticket)>=0){
						user_information.insertElementAt(ticket, i);
						break;
					}
				}
				}
				}else{
			//		int address=fct.find_num_order(user_information, ticket, 3);
					if(address!=-1){
						user_information.remove(address);
						ticket=ticket+"��Ʊ-";
					}
					int flag=1;
					for(int i=1;i<user_information.size();i++){
						if(user_information.get(i).equals("=====")){
							flag=0;
						}else if(flag==0){
							//������
						if(fct.Compare_Data(user_information.get(i),ticket)>0){
							flag=-1;
							user_information.insertElementAt(ticket, i);
							break;
							//������ȣ�ʱ����Ȼ�С
						}else if(fct.Compare_Data(user_information.get(i), ticket)==0&&fct.Compare_Time(user_information.get(i),ticket)>=0){
							flag=-1;
							user_information.insertElementAt(ticket, i);
							break;
						}
					}
					}
					if(flag!=-1){
						user_information.add(ticket);
					}
				}
				write(user_information, filename);
		 }
	 public Vector<String> read(String filename){
	//	 String filepath="e:/workplace/��1/src/resours/"+filename;
		 String filepath=filename;
		 if(filename.equals("order")){
			 File file_t=new File(filepath);
			 if(!file_t.exists()){
				 try {
					file_t.createNewFile();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				Vector<String> t=new Vector<String>();
				t.add("wh0");
				write(t, filename);
			 }
		 }
			Vector<String> file_out=new Vector<String>();
			String s_single;
			 try {
				 File file=new File(filepath);
				 if(file.exists()){
			//		 System.out.println("�ļ��Ѵ��ڣ���ʼ��ȡ");
				 }else{
					 file.createNewFile();
					 System.out.println("�ļ��Ѵ�������ʼ��ȡ");
				 }
				BufferedReader reader=new BufferedReader(new FileReader(file));
				s_single=reader.readLine();
				while(s_single!=null){
					file_out.add(s_single);
					s_single=reader.readLine();
				}
				reader.close();
		//		System.out.println("��ȡ���");
			} catch (Exception e) {
				System.out.println("��ȡ����");
				System.exit(0);
			}
			 return file_out;
		 }
	 
	
	 	
}
