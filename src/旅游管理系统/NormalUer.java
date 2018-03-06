package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class NormalUer extends JFrame {

	private JPanel contentPane;
	private JPanel panel_myorder;
	public JTextField tx_buy_money;
	public JTextField tx_buy_name;
	public JTextField tx_buy_phone;
	public JTextField tx_buy_remind;
	public JTextField tx_buy_account;
	public JComboBox comb_buy_road = new JComboBox();
	public JComboBox comb_buy_time = new JComboBox();
	public JComboBox comb_buy_data = new JComboBox();
	public JComboBox comb_buy_num = new JComboBox();
	public FileOperation file_operation=new FileOperation();
	public function FCT=new function();
	public static String account=new String();
	public Vector<String> file_get=new Vector<String>();
	public JLabel lb_buy_remind = new JLabel("");
	public Calendar show_data = Calendar.getInstance();
	public String user_name="";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NormalUer frame = new NormalUer();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void show(String s){
		account=s;
		NormalUer frame = new NormalUer();
		frame.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public NormalUer() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7528\u6237\u540D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 15, 117, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_name = new JLabel("");
		lb_name.setHorizontalAlignment(SwingConstants.CENTER);
		lb_name.setBounds(10, 23, 97, 24);
		panel.add(lb_name);
		file_get.clear();
//		System.out.println(account);
		file_get=file_operation.read(account);
		String[] s_name=file_get.get(0).split("-");
		user_name=s_name[1];
		file_get.clear();
		lb_name.setText(user_name);
	//	System.out.println("test");
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u529F\u80FD\u533A\u57DF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 95, 117, 239);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton bt_buy = new JButton("\u8D2D\u7968");
		bt_buy.setBackground(new Color(240, 255, 240));
		bt_buy.setBounds(10, 26, 97, 92);
		panel_1.add(bt_buy);
		
		JButton bt_myorder = new JButton("\u6211\u7684\u8BA2\u5355");
		bt_myorder.setBackground(new Color(240, 255, 240));
		bt_myorder.setBounds(10, 128, 97, 92);
		panel_1.add(bt_myorder);
		
		JPanel panel_mother = new JPanel();
		panel_mother.setBounds(127, 10, 555, 324);
		contentPane.add(panel_mother);
		CardLayout card=new CardLayout();
		panel_mother.setLayout(card);
		
		JPanel panel_buy = new JPanel();
		panel_buy.setBorder(new TitledBorder(null, "\u8D2D\u7968\u9875\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_mother.add("0",panel_buy);
		panel_buy.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8DEF\u7EBF\u9009\u62E9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 25, 535, 118);
		panel_buy.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8DEF\u7EBF\uFF1A");
		lblNewLabel.setBounds(10, 21, 46, 30);
		panel_3.add(lblNewLabel);
		
		JLabel label = new JLabel("\u65F6\u95F4\uFF1A");
		label.setBounds(364, 19, 46, 34);
		panel_3.add(label);
		
		
		comb_buy_time.setBounds(396, 23, 105, 26);
		panel_3.add(comb_buy_time);
		
		JLabel label_1 = new JLabel("\u65E5\u671F\uFF1A");
		label_1.setBounds(192, 19, 46, 34);
		panel_3.add(label_1);
		
		comb_buy_road.setBounds(43, 23, 139, 26);
		panel_3.add(comb_buy_road);
		
		JLabel label_2 = new JLabel("\u4EBA\u6570\uFF1A");
		label_2.setBounds(10, 65, 46, 34);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EBA");
		label_3.setBounds(135, 65, 46, 34);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("\u603B\u91D1\u989D\uFF1A");
		label_4.setBounds(195, 65, 62, 34);
		panel_3.add(label_4);
		
		tx_buy_money = new JTextField();
		tx_buy_money.setHorizontalAlignment(SwingConstants.CENTER);
		tx_buy_money.setBounds(252, 69, 78, 27);
		panel_3.add(tx_buy_money);
		tx_buy_money.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5143");
		label_5.setBounds(340, 65, 46, 34);
		panel_3.add(label_5);
		
	
		comb_buy_num.setBounds(58, 72, 67, 26);
		panel_3.add(comb_buy_num);
		

		comb_buy_data.setBounds(225, 23, 125, 26);
		panel_3.add(comb_buy_data);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u4E58\u5BA2\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 153, 535, 128);
		panel_buy.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_6 = new JLabel("\u59D3\u540D\uFF1A");
		label_6.setBounds(10, 22, 46, 34);
		panel_4.add(label_6);
		
		tx_buy_name = new JTextField();
		tx_buy_name.setHorizontalAlignment(SwingConstants.CENTER);
		tx_buy_name.setColumns(10);
		tx_buy_name.setBounds(48, 29, 97, 27);
		panel_4.add(tx_buy_name);
		
		JLabel label_7 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_7.setBounds(155, 22, 69, 34);
		panel_4.add(label_7);
		
		tx_buy_phone = new JTextField();
		tx_buy_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tx_buy_phone.setColumns(10);
		tx_buy_phone.setBounds(216, 26, 143, 27);
		panel_4.add(tx_buy_phone);
		
		JLabel label_8 = new JLabel("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		label_8.setBounds(10, 69, 79, 34);
		panel_4.add(label_8);
		
		tx_buy_remind = new JTextField();
		tx_buy_remind.setHorizontalAlignment(SwingConstants.CENTER);
		tx_buy_remind.setBounds(73, 76, 452, 27);
		panel_4.add(tx_buy_remind);
		tx_buy_remind.setColumns(10);
		
		JLabel label_9 = new JLabel("\u8D2D\u7968\u8D26\u53F7\uFF1A");
		label_9.setBounds(369, 22, 69, 34);
		panel_4.add(label_9);
		
		tx_buy_account = new JTextField();
		tx_buy_account.setHorizontalAlignment(SwingConstants.CENTER);
		tx_buy_account.setColumns(10);
		tx_buy_account.setBounds(428, 29, 97, 27);
		panel_4.add(tx_buy_account);
		
		JButton bt_buy_buy = new JButton("\u8D2D\u4E70");
		bt_buy_buy.setBounds(337, 291, 93, 23);
		panel_buy.add(bt_buy_buy);
		
		JButton bt_buy_cancel = new JButton("\u53D6\u6D88");
		bt_buy_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InPutInformation();
			}
		});
		bt_buy_cancel.setBounds(452, 291, 93, 23);
		panel_buy.add(bt_buy_cancel);
		
		panel_myorder = new JPanel();
		panel_myorder.setBorder(new TitledBorder(null, "\u6211\u7684\u8BA2\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_mother.add("1",panel_myorder);
		panel_myorder.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u672A\u51FA\u884C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 26, 535, 142);
		panel_myorder.add(panel_5);
		panel_5.setLayout(null);
		
		JTextArea tx_are_new = new JTextArea();
		JScrollPane jsp_new=new JScrollPane(tx_are_new);
		jsp_new.setBounds(10, 21, 515, 111);
		panel_5.add(jsp_new);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5DF2\u5B8C\u6210", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(10, 178, 535, 146);
		panel_myorder.add(panel_6);
		
		JTextArea tx_are_old = new JTextArea();
		JScrollPane jsp_old=new JScrollPane(tx_are_old);
		jsp_old.setBounds(10, 25, 515, 111);
		panel_6.add(jsp_old);
		tx_are_new.setEditable(false);
		tx_are_old.setEditable(false);
		tx_are_old.setLineWrap(true);
		tx_are_new.setLineWrap(true);
		tx_buy_account.setEditable(false);
		
		
		lb_buy_remind.setHorizontalAlignment(SwingConstants.CENTER);
		lb_buy_remind.setBounds(31, 291, 282, 23);
		panel_buy.add(lb_buy_remind);
		InPutInformation();
		tx_are_new.setEditable(false);
		tx_are_old.setEditable(false);
		
		
		
	//////////////////////////////////////
		bt_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_mother,"0");
				InPutInformation();
			}
		});
		
		bt_myorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_mother, "1");
				FCT.Updata_User_Information(account);
				tx_are_new.setText("");
				tx_are_old.setText("");
				file_get.clear();
				file_get=file_operation.read(account);
				int i=1;
				for(;i<file_get.size();i++){
					if(!file_get.get(i).equals("=====")){
						tx_are_new.append(file_get.get(i)+"\r\n");
					}else{
						break;
					}
				}
				i++;
				for(;i<file_get.size();i++){
					tx_are_old.append(file_get.get(i)+"\r\n");
				}
				
			}
		});
		
		bt_buy_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> order_num=file_operation.read("order");
				int num=Integer.parseInt(order_num.get(0).substring(2))+1;
				String ticket_total="";
				String ticket_account="";
				ticket_total=comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
				       	comb_buy_road.getSelectedItem().toString()+"-"+tx_buy_name.getText()+"-"+tx_buy_phone.getText()+"-"+comb_buy_num.getSelectedItem().toString()+"-"+
	       				tx_buy_money.getText()+"-"+tx_buy_remind.getText()+"-"+tx_buy_account.getText()+"-";
	       		String[] judge=ticket_total.split("-");
	       		int k=0;
	       		for(;k<judge.length;k++){
	       			if(judge[k].equals("")){
	       				break;
	       			}
	       		}
	       		if(k==10){
	       			ticket_total=ticket_total+"wh"+num+"-";
	       			String data=show_data.get(Calendar.YEAR)+"/"+(show_data.get(Calendar.MONTH)+1)+"/"+show_data.get(Calendar.DAY_OF_MONTH);
	       			ticket_account=ticket_total+data+"-";
	       			FCT.Sort_Ticket(ticket_total);
	       			file_operation.write_singel_ticket(ticket_account, account,0, 1);
	       			file_get.clear();
	       			file_get.add("wh"+num);
	       			file_operation.write(file_get, "order");
	       			FCT.Updata_road();
	       			lb_buy_remind.setText("购买成功");
	       		}else{
	       			lb_buy_remind.setText("请将信息填写完整");
	       		}
			}
		});
		
comb_buy_road.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){  
				String data=FCT.Get_Road_Data(comb_buy_road.getSelectedItem().toString());
				String[] road_data=data.split("-");
				comb_buy_data.removeAllItems();
				for(int i=0;i<road_data.length;i++){
					comb_buy_data.addItem(road_data[i]);
				}
				String time=FCT.Get_Road_Time(comb_buy_road.getSelectedItem().toString(),comb_buy_data.getSelectedItem().toString());
				String[] road_time=time.split("-");
				comb_buy_time.removeAllItems();
				for(int i=0;i<road_time.length;i++){
					comb_buy_time.addItem(road_time[i]);
				}
				int num=FCT.Get_Road_num(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
				comb_buy_road.getSelectedItem().toString());
				comb_buy_num.removeAllItems();
				for(int i=1;i<=num;i++){
					comb_buy_num.addItem(i);
				}
				double money=FCT.Get_Road_Money(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
						comb_buy_road.getSelectedItem().toString())*Integer.parseInt(comb_buy_num.getSelectedItem().toString());
				money=((int)(money*100))/100;		
				tx_buy_money.setText(money+"");
				}
			}
		});
	    //日期下拉框事件
	    comb_buy_data.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){  
				String time=FCT.Get_Road_Time(comb_buy_road.getSelectedItem().toString(),comb_buy_data.getSelectedItem().toString());
				String[] road_time=time.split("-");
				comb_buy_time.removeAllItems();
				for(int i=0;i<road_time.length;i++){
					comb_buy_time.addItem(road_time[i]);
				}
				int num=FCT.Get_Road_num(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
				comb_buy_road.getSelectedItem().toString());
				comb_buy_num.removeAllItems();
				for(int i=1;i<=num;i++){
					comb_buy_num.addItem(i);
				}
				double money=FCT.Get_Road_Money(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
						comb_buy_road.getSelectedItem().toString())*Integer.parseInt(comb_buy_num.getSelectedItem().toString());
				money=((int)(money*100))/100;	
				tx_buy_money.setText(money+"");
				}
			}
		});
	    
	    //时间下拉框事件
	    comb_buy_time.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){  
				int num=FCT.Get_Road_num(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
						comb_buy_road.getSelectedItem().toString());
						comb_buy_num.removeAllItems();
						for(int i=1;i<=num;i++){
							comb_buy_num.addItem(i);
						}
						double money=FCT.Get_Road_Money(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
								comb_buy_road.getSelectedItem().toString())*Integer.parseInt(comb_buy_num.getSelectedItem().toString());
						money=((int)(money*100))/100;	
						tx_buy_money.setText(money+"");
				}
			}
		});
	    
	    //人数下拉框事件
	    comb_buy_num.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED){
					double money=FCT.Get_Road_Money(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
						comb_buy_road.getSelectedItem().toString())*Integer.parseInt(comb_buy_num.getSelectedItem().toString());
					money=((int)(money*100))/100;	
					tx_buy_money.setText(money+"");
				}
				
			}
		});
	}
	
	public void InPutInformation(){
		FCT.Updata_User_Information(account);
		FCT.Remove_Dead_Road();
		FCT.Updata_road();
   		Vector<String> road_name=new Vector<String>();
   		road_name.clear();
   		road_name=FCT.Get_Road();
   		comb_buy_road.removeAllItems();
   		for(int i=0;i<road_name.size();i++){
   			comb_buy_road.addItem(road_name.get(i));
   		}
   		String data=FCT.Get_Road_Data(comb_buy_road.getSelectedItem().toString());
		String[] road_data=data.split("-");
		comb_buy_data.removeAllItems();
		for(int i=0;i<road_data.length;i++){
			comb_buy_data.addItem(road_data[i]);
		}
		String time=FCT.Get_Road_Time(comb_buy_road.getSelectedItem().toString(),comb_buy_data.getSelectedItem().toString());
		String[] road_time=time.split("-");
	//	System.out.println(road_time[0]);
		comb_buy_time.removeAllItems();
		for(int i=0;i<road_time.length;i++){
			comb_buy_time.addItem(road_time[i]);
		}
		int num=FCT.Get_Road_num(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
		comb_buy_road.getSelectedItem().toString());
		comb_buy_num.removeAllItems();
		for(int i=1;i<=num;i++){
			comb_buy_num.addItem(i);
		}
		double money=FCT.Get_Road_Money(comb_buy_data.getSelectedItem().toString()+"-"+comb_buy_time.getSelectedItem().toString()+"-"+
				comb_buy_road.getSelectedItem().toString())*Integer.parseInt(comb_buy_num.getSelectedItem().toString());
		money=((int)(money*100))/100;	
		tx_buy_money.setText(money+"");
		tx_buy_remind.setText("无");
		tx_buy_name.setText("");
		tx_buy_phone.setText("");
		lb_buy_remind.setText("");
		tx_buy_account.setText(account);
	}
	}
