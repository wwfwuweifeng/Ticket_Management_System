package 旅游管理系统;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.net.ssl.SSLContext;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.ui.internal.ShowFastViewContribution;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Window;
import java.util.Calendar;
import java.util.Map;
import java.util.Vector;
import java.util.jar.Attributes.Name;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.beancontext.BeanContextChildSupport;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.UIManager;

public class manager {

	private JFrame frame;
	private final JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
	private JLabel lb_name;
	public  String account;
	private JLabel lblNewLabel_1;
	private JPanel select_pane;
	private JToggleButton tgbt_manager;
	private JToggleButton tgbt_query;
	private ButtonGroup bg_tgbt=new ButtonGroup();
	private ButtonGroup bg_tgbt_query=new ButtonGroup();
	private JTextField tx_manager;
	private JTextField tx_total_money;
	private JTextField tx_total_people;
	public Vector<String> file_getinformation=new Vector<String>();
	public Vector<String> file_getroad=new Vector<String>();
	public function FCT=new function();
	public Vector<Integer> manager_result=new Vector<Integer>();
	public Vector<String> manager_del=new Vector<String>();
	public Vector<String> manager_order=new Vector<String>();
	public Vector<String> file_getnum_order=new Vector<String>();
	public FileOperation file_operation=new FileOperation();
	public Total_Calander road_calander=new Total_Calander(1); //1表示的日历有选择的时间限制
	public Total_Calander query_calander=new Total_Calander(2);//2表示的日历无选择的时间限制
	private JTextField tx_road_start;
	private JTextField tx_road_end;
	private JTextField tx_road_money;
	private JTextField tx_road_num;
	public Vector<String> comb_get_road=new Vector<String>();	
	private JTextField tx_manager_name;
	private JTextField tx_manager_tel;
	private JTextField tx_manager_remind;
	private JTextField tx_manager_money;
	private JTextField tx_manager_account;
	public  int new_or_old;
	public  String order_num="";
	public  int change_row_num;
	private JTextField tx_user_peopel;
	private JTextField tx_user_account;
	private JTextField tx_user_surplus;
	private JTextField tx_user_add_money;
	public Vector<String> file_getname=new Vector<String>();
	public Vector<String> user_information=new Vector<String>();
	public Vector<String> manager_change_order=new Vector<String>();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		String name=null;
//		name=args[0];
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					manager window = new manager(name);
//					window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public static void show(String s){
		manager window = new manager(s);
		window.frame.setVisible(true);
	}
	public manager(String name) {
		initialize(name);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 772, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(0, 0, 138, 84);
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 56, 33);
		panel_1.add(label);
		
		frame.setResizable(false);
		String[] t=name.split("-");
		account=t[0];
		lb_name = new JLabel(t[1]);
		lb_name.setFont(new Font("宋体", Font.BOLD, 13));
		lb_name.setBackground(Color.LIGHT_GRAY);
		lb_name.setHorizontalAlignment(SwingConstants.LEFT);
		lb_name.setBounds(48, 1, 106, 32);
		panel_1.add(lb_name);
		
		lblNewLabel_1 = new JLabel("Welcome\uFF01");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 33, 118, 24);
		panel_1.add(lblNewLabel_1);
		
		JButton bt_return = new JButton("\u8FD4\u56DE\u767B\u5F55");
		bt_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login.main(null);
			}
		});
		bt_return.setBackground(new Color(248, 248, 255));
		bt_return.setBounds(20, 61, 93, 23);
		panel_1.add(bt_return);
		
		select_pane = new JPanel();
		select_pane.setBorder(new TitledBorder(null, "\u64CD\u4F5C\u9009\u62E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		select_pane.setBackground(Color.WHITE);
		select_pane.setBounds(0, 85, 138, 282);
		frame.getContentPane().add(select_pane);
		select_pane.setLayout(null);
		
		tgbt_manager = new JToggleButton("\u7BA1\u7406\u8BA2\u5355");
		tgbt_manager.setBackground(SystemColor.inactiveCaptionBorder);
		tgbt_manager.setBounds(0, 73, 128, 33);
		select_pane.add(tgbt_manager);
		
		tgbt_query = new JToggleButton("\u67E5\u8BE2");

		tgbt_query.setForeground(new Color(0, 0, 0));
		tgbt_query.setBackground(SystemColor.inactiveCaptionBorder);
		tgbt_query.setBounds(0, 20, 128, 33);
		select_pane.add(tgbt_query);
		
		JToggleButton tgbt_statistics = new JToggleButton("\u7EDF\u8BA1\u4FE1\u606F");
		tgbt_statistics.setBackground(SystemColor.inactiveCaptionBorder);

		tgbt_statistics.setBounds(0, 126, 128, 33);
		select_pane.add(tgbt_statistics);
		
		JToggleButton tgbt_road = new JToggleButton("\u7BA1\u7406\u8DEF\u7EBF");
		tgbt_road.setBackground(SystemColor.inactiveCaptionBorder);
		
		tgbt_road.setBounds(0, 179, 128, 33);
		select_pane.add(tgbt_road);
		bg_tgbt.add(tgbt_road);
		bg_tgbt.add(tgbt_statistics);
		bg_tgbt.add(tgbt_query);
		bg_tgbt.add(tgbt_manager);
		
		JToggleButton tgbt_user = new JToggleButton("\u7BA1\u7406\u7528\u6237");
		tgbt_user.setBackground(SystemColor.inactiveCaptionBorder);
		tgbt_user.setBounds(0, 232, 128, 33);
		select_pane.add(tgbt_user);
		bg_tgbt.add(tgbt_user);
		
		JPanel card_panel = new JPanel();
		card_panel.setBounds(137, 0, 629, 367);
		frame.getContentPane().add(card_panel);
		
		CardLayout card=new CardLayout();
		card_panel.setLayout(card);
		
		JPanel first_panel = new JPanel();
		first_panel.setBackground(Color.WHITE);
		first_panel.setLayout(null);
		
		JPanel query_panel = new JPanel();
		query_panel.setBackground(new Color(245, 255, 250));
		query_panel.setBounds(256, 5, -29, 184);
		query_panel.setLayout(null);

		JPanel manager_panel = new JPanel();
		manager_panel.setBackground(Color.WHITE);
		manager_panel.setBounds(286, 5, -35, 24);
		
		manager_panel.setLayout(null);
		
		JPanel statistics_panel = new JPanel();
		statistics_panel.setBackground(Color.WHITE);
		statistics_panel.setBounds(286, 5, 10, 10);

		statistics_panel.setLayout(null);
		
		JPanel bt_road_panel = new JPanel();
		bt_road_panel.setBackground(Color.WHITE);
		bt_road_panel.setBounds(301, 5, 10, 10);

		bt_road_panel.setLayout(null);
		
		card_panel.add("0",first_panel);
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5A01\u6D77\u9AD8\u6821\u65C5\u6E38\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 10, 361, 44);
		first_panel.add(lblNewLabel);
		
		JLabel lb_time = new JLabel("");
		lb_time.setFont(new Font("宋体", Font.BOLD, 16));
		lb_time.setBounds(433, 21, 125, 29);
		first_panel.add(lb_time);
		card_panel.add("1",query_panel);
		
		JButton bt_query = new JButton("\u67E5\u8BE2");
		bt_query.setFont(new Font("宋体", Font.PLAIN, 13));
		bt_query.setBackground(new Color(245, 255, 250));
		
		bt_query.setBounds(509, 49, 79, 25);
		query_panel.add(bt_query);
		
		JTextArea tx_are_query=new JTextArea();
		tx_are_query.setFont(new Font("宋体", Font.PLAIN, 16));
		tx_are_query.setEditable(false);
		JScrollPane jsp=new JScrollPane(tx_are_query);
		jsp.setBounds(26, 132, 574, 206);
		tx_are_query.setLineWrap(true);
		
		card_panel.add("2",manager_panel);
		
		
		card_panel.add("3",statistics_panel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.ORANGE);
		lblNewLabel_4.setIcon(new ImageIcon(manager.class.getResource("/resours/logo2.png")));
		lblNewLabel_4.setBounds(10, 10, 139, 112);
		statistics_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5F53\u524D\u6536\u5165\u91D1\u989D\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(224, 22, 108, 27);
		statistics_panel.add(lblNewLabel_5);
		
		tx_total_money = new JTextField();
		tx_total_money.setHorizontalAlignment(SwingConstants.CENTER);
		tx_total_money.setBounds(339, 24, 143, 24);
		statistics_panel.add(tx_total_money);
		tx_total_money.setColumns(10);
		tx_total_money.setEditable(false);
		
		JLabel label_1 = new JLabel("\u5143");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(492, 22, 108, 27);
		statistics_panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5F53\u524D\u603B\u4EBA\u6570\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(234, 59, 84, 24);
		statistics_panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EBA");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(492, 59, 108, 27);
		statistics_panel.add(label_3);
		
		tx_total_people = new JTextField();
		tx_total_people.setHorizontalAlignment(SwingConstants.CENTER);
		tx_total_people.setColumns(10);
		tx_total_people.setBounds(339, 58, 143, 24);
		statistics_panel.add(tx_total_people);
		tx_total_people.setEditable(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 250, 240));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u5730\u70B9\u5206\u7C7B\u67E5\u770B\u7EDF\u8BA1\u4FE1\u606F", "\u6309\u65E5\u671F\u5206\u7C7B\u67E5\u770B\u7EDF\u8BA1\u4FE1\u606F"}));
		comboBox.setBounds(312, 93, 180, 27);
		statistics_panel.add(comboBox);
		
		
		
		JTextArea tx_are_statistics=new JTextArea();
		tx_are_statistics.setEditable(false);
		JScrollPane jsp_statistic=new JScrollPane(tx_are_statistics);
		jsp_statistic.setBounds(196, 169, 423, 188);
		tx_are_statistics.setLineWrap(true);
		statistics_panel.add(jsp_statistic);
		
		JButton bt_statistic_see = new JButton("\u67E5\u770B");
		bt_statistic_see.setBackground(new Color(245, 255, 250));
		
		bt_statistic_see.setBounds(301, 130, 93, 25);
		statistics_panel.add(bt_statistic_see);
		
		JButton bt_statistics_clear = new JButton("\u6E05\u7A7A");
		bt_statistics_clear.setBackground(new Color(245, 255, 250));
		
		bt_statistics_clear.setBounds(415, 130, 93, 25);
		statistics_panel.add(bt_statistics_clear);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 169, 176, 188);
		JList list_statistics = new JList();
		scrollPane_1.add(list_statistics);
		statistics_panel.add(scrollPane_1);
		scrollPane_1.setViewportView(list_statistics);
		
		JButton bt_statistics_total = new JButton("\u67E5\u770B\u8BE6\u60C5");
		bt_statistics_total.setBackground(new Color(245, 255, 250));
		bt_statistics_total.setBounds(37, 132, 117, 27);
		statistics_panel.add(bt_statistics_total);
		
		card_panel.add("4",bt_road_panel);
		
		JScrollPane jsp_table_road=new JScrollPane();
		DefaultTableModel tableModel_road;
		String[] road_rowname={"日期","时间","起点","终点","金额","额定人数","已预订人数","剩余人数"};
		String[][]  road_information={};
		tableModel_road=new DefaultTableModel(road_information, road_rowname);
		Diy_jtable2 table_road=new Diy_jtable2(tableModel_road);
		table_road.setBackground(new Color(240, 248, 255));
	
	
		
		table_road.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel_road));  
        jsp_table_road.setViewportView(table_road);  
        bt_road_panel.add(jsp_table_road);
        jsp_table_road.setBounds(10, 167, 590, 172);
        
        JButton bt_road_save = new JButton("\u4FDD\u5B58");
        bt_road_save.setBackground(new Color(245, 255, 250));
      
        bt_road_save.setBounds(417, 134, 72, 23);
        bt_road_panel.add(bt_road_save);
        
        JButton bt_road_cancel = new JButton("\u53D6\u6D88");
        bt_road_cancel.setBackground(new Color(245, 255, 250));
      
        bt_road_cancel.setBounds(515, 134, 72, 23);
        bt_road_panel.add(bt_road_cancel);
        
        JLabel lb_road = new JLabel("");
        lb_road.setFont(new Font("宋体", Font.PLAIN, 14));
        lb_road.setBounds(10, 134, 302, 23);
        bt_road_panel.add(lb_road);
        
        JButton bt_road_del = new JButton("\u5220\u9664");
        bt_road_del.setBackground(new Color(245, 255, 250));
    
        bt_road_del.setBounds(322, 134, 72, 23);
        bt_road_panel.add(bt_road_del);
        
        JPanel panel_card_mother2 = new JPanel();
        panel_card_mother2.setBounds(10, 10, 590, 114);
        bt_road_panel.add(panel_card_mother2);
        CardLayout card_road=new CardLayout();
        panel_card_mother2.setLayout(card_road);
        
        JPanel panel_road_first = new JPanel();
        panel_road_first.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u65B0\u8DEF\u7EBF\u6DFB\u52A0", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_card_mother2.add(panel_road_first, "name_474407780565727");
        panel_road_first.setLayout(null);
        

        road_calander.setBounds(109, 20, 130, 28);
        panel_road_first.add(road_calander);
        
        JButton bt_road_add = new JButton("\u6DFB\u52A0");
   
        bt_road_add.setBounds(493, 89, 87, 23);
        panel_road_first.add(bt_road_add);
        bt_road_add.setBackground(new Color(245, 255, 250));
        
        JComboBox comb_road_hour = new JComboBox();
        comb_road_hour.setBackground(new Color(245, 255, 250));
        comb_road_hour.setFont(new Font("宋体", Font.PLAIN, 14));
        comb_road_hour.setBounds(238, 20, 54, 28);
        panel_road_first.add(comb_road_hour);
        
        JLabel lblNewLabel_6 = new JLabel("\u65F6");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(293, 20, 17, 28);
        panel_road_first.add(lblNewLabel_6);
        
        JComboBox comb_road_mim = new JComboBox();
        comb_road_mim.setBackground(new Color(245, 255, 250));
        comb_road_mim.setFont(new Font("宋体", Font.PLAIN, 14));
        comb_road_mim.setBounds(314, 20, 61, 28);
        panel_road_first.add(comb_road_mim);
         
        JLabel label_4 = new JLabel("\u5206");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setFont(new Font("宋体", Font.PLAIN, 14));
        label_4.setBounds(368, 20, 27, 28);
        panel_road_first.add(label_4);
        
        JLabel lblNewLabel_7 = new JLabel("\u51FA\u53D1\u65E5\u671F\uFF1A");
        lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(10, 20, 122, 28);
        panel_road_first.add(lblNewLabel_7);
        
        JLabel label_5 = new JLabel("\u8D77\u70B9\uFF1A");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        label_5.setFont(new Font("宋体", Font.PLAIN, 14));
        label_5.setBounds(45, 58, 87, 28);
        panel_road_first.add(label_5);
        
        tx_road_start = new JTextField();
        tx_road_start.setHorizontalAlignment(SwingConstants.CENTER);
        tx_road_start.setBounds(109, 58, 75, 25);
        panel_road_first.add(tx_road_start);
        tx_road_start.setColumns(10);
        
        JLabel label_6 = new JLabel("\u7EC8\u70B9\uFF1A");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setFont(new Font("宋体", Font.PLAIN, 14));
        label_6.setBounds(223, 58, 87, 28);
        panel_road_first.add(label_6);
        
        tx_road_end = new JTextField();
        tx_road_end.setHorizontalAlignment(SwingConstants.CENTER);
        tx_road_end.setColumns(10);
        tx_road_end.setBounds(293, 58, 75, 25);
        panel_road_first.add(tx_road_end);
        
        JLabel label_7 = new JLabel("\u91D1\u989D\uFF1A");
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setFont(new Font("宋体", Font.PLAIN, 14));
        label_7.setBounds(45, 86, 87, 28);
        panel_road_first.add(label_7);
        
        tx_road_money = new JTextField();
        tx_road_money.setHorizontalAlignment(SwingConstants.CENTER);
        tx_road_money.setColumns(10);
        tx_road_money.setBounds(109, 86, 75, 25);
        panel_road_first.add(tx_road_money);
        
        JLabel label_8 = new JLabel("\u989D\u5B9A\u4EBA\u6570\uFF1A");
        label_8.setHorizontalAlignment(SwingConstants.RIGHT);
        label_8.setFont(new Font("宋体", Font.PLAIN, 14));
        label_8.setBounds(205, 86, 87, 28);
        panel_road_first.add(label_8);
        
        JLabel label_9 = new JLabel("\u5143");
        label_9.setHorizontalAlignment(SwingConstants.RIGHT);
        label_9.setFont(new Font("宋体", Font.PLAIN, 14));
        label_9.setBounds(185, 86, 17, 28);
        panel_road_first.add(label_9);
        
        tx_road_num = new JTextField();
        tx_road_num.setHorizontalAlignment(SwingConstants.CENTER);
        tx_road_num.setColumns(10);
        tx_road_num.setBounds(291, 86, 75, 25);
        panel_road_first.add(tx_road_num);
        
        JLabel label_10 = new JLabel("\u4EBA");
        label_10.setHorizontalAlignment(SwingConstants.RIGHT);
        label_10.setFont(new Font("宋体", Font.PLAIN, 14));
        label_10.setBounds(368, 86, 17, 28);
        panel_road_first.add(label_10);
        
        JLabel lblNewLabel_11 = new JLabel("\u6E29\u99A8\u63D0\u793A\uFF1A\r\n");
        lblNewLabel_11.setBounds(405, 20, 143, 23);
        panel_road_first.add(lblNewLabel_11);
        
        JLabel label_18 = new JLabel("\u64CD\u4F5C\u5B8C\u6210\u540E\uFF0C\u8BB0\u5F97\u70B9\u51FB\u4FDD\u5B58");
        label_18.setBounds(405, 42, 175, 23);
        panel_road_first.add(label_18);
        	
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(manager.class.getResource("/resours/\u65E0\u4E3A\u4F1F.png")));
		lblNewLabel_2.setBounds(20, 68, 538, 289);
		first_panel.add(lblNewLabel_2);
		query_panel.add(jsp);
		
		JButton bt_clear = new JButton("\u6E05\u7A7A");
		bt_clear.setFont(new Font("宋体", Font.PLAIN, 13));
		
		bt_clear.setBounds(509, 84, 79, 25);
		query_panel.add(bt_clear);
		
		
		
		JScrollPane jsp_table_manager=new JScrollPane();
		DefaultTableModel tableModel;
		String[] rowname={"日期","时间","起点","终点","姓名","手机","人数","金额","备注","账号","单号"};
		String[][]  people_information={};
		tableModel=new DefaultTableModel(people_information, rowname);
		Diy_jtable table_manager=new Diy_jtable(tableModel);
		table_manager.setBackground(new Color(248, 248, 255));
		table_manager.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));  
        jsp_table_manager.setViewportView(table_manager);  
        manager_panel.add(jsp_table_manager);
        jsp_table_manager.setBounds(10, 172, 609, 185);
		
		table_manager.getColumnModel().getColumn(0).setPreferredWidth(140);
		table_manager.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(3).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(4).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_manager.getColumnModel().getColumn(6).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(7).setPreferredWidth(80);
		table_manager.getColumnModel().getColumn(8).setPreferredWidth(200);
		table_manager.getColumnModel().getColumn(9).setPreferredWidth(160);
		table_manager.getColumnModel().getColumn(10).setPreferredWidth(80);
       String info="请输入待管理人的姓名或手机或单号";
       
       JButton bt_manager_del = new JButton("\u5220\u9664");
       bt_manager_del.setBackground(new Color(245, 245, 220));
       bt_manager_del.setFont(new Font("宋体", Font.PLAIN, 13));
      
       bt_manager_del.setBounds(95, 139, 93, 23);
       manager_panel.add(bt_manager_del);
       
       JButton bt_magager_add = new JButton("\u6DFB\u52A0");
       bt_magager_add.setBackground(new Color(245, 245, 220));
       bt_magager_add.setFont(new Font("宋体", Font.PLAIN, 13));
      
       bt_magager_add.setBounds(198, 139, 93, 23);
       manager_panel.add(bt_magager_add);
       
       JButton bt_manager_cancel = new JButton("\u53D6\u6D88");
       bt_manager_cancel.setBackground(new Color(245, 245, 220));
       bt_manager_cancel.setFont(new Font("宋体", Font.PLAIN, 13));
      
       bt_manager_cancel.setBounds(507, 139, 93, 23);
       manager_panel.add(bt_manager_cancel);
       
       JButton bt_manager_change = new JButton("\u4FEE\u6539");
       bt_manager_change.setFont(new Font("宋体", Font.PLAIN, 13));
       bt_manager_change.setBackground(new Color(245, 245, 220));
       bt_manager_change.setBounds(301, 139, 93, 23);
       manager_panel.add(bt_manager_change);
       
       JPanel panel_manager_mother = new JPanel();
       panel_manager_mother.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
       panel_manager_mother.setBounds(10, 0, 609, 135);
       manager_panel.add(panel_manager_mother);
       CardLayout card_manager_mother=new CardLayout();
       panel_manager_mother.setLayout(card_manager_mother);
       
       JPanel panel_manager_card_1 = new JPanel();
       panel_manager_mother.add("1",panel_manager_card_1);
       panel_manager_card_1.setLayout(null);
       JPanel panel_manager_card_2= new JPanel();
       panel_manager_mother.add("2",panel_manager_card_2);
       panel_manager_card_2.setLayout(null);
       
       JLabel lblNewLabel_10 = new JLabel("\u65E5\u671F\uFF1A");
       lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 13));
       lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
       lblNewLabel_10.setBounds(0, 47, 44, 27);
       panel_manager_card_2.add(lblNewLabel_10);
       
       JLabel label_11 = new JLabel("\u8DEF\u7EBF\uFF1A");
       label_11.setHorizontalAlignment(SwingConstants.CENTER);
       label_11.setFont(new Font("宋体", Font.PLAIN, 13));
       label_11.setBounds(0, 10, 44, 27);
       panel_manager_card_2.add(label_11);
       
       JComboBox comb_manager_road = new JComboBox();
       comb_manager_road.setBounds(45, 11, 130, 24);
       panel_manager_card_2.add(comb_manager_road);
       
       JLabel label_12 = new JLabel("\u65F6\u95F4\uFF1A");
       label_12.setHorizontalAlignment(SwingConstants.CENTER);
       label_12.setFont(new Font("宋体", Font.PLAIN, 13));
       label_12.setBounds(0, 84, 44, 27);
       panel_manager_card_2.add(label_12);
       
       JComboBox comb_manager_time = new JComboBox();
       comb_manager_time.setBounds(45, 84, 70, 24);
       panel_manager_card_2.add(comb_manager_time);
       
       JLabel label_13 = new JLabel("\u4EBA\u6570\uFF1A");
       label_13.setHorizontalAlignment(SwingConstants.CENTER);
       label_13.setFont(new Font("宋体", Font.PLAIN, 13));
       label_13.setBounds(125, 84, 44, 27);
       panel_manager_card_2.add(label_13);
       
       JComboBox comb_manager_num = new JComboBox();
       comb_manager_num.setBounds(165, 84, 70, 24);
       panel_manager_card_2.add(comb_manager_num);
       
       JLabel label_14 = new JLabel("\u59D3\u540D\uFF1A");
       label_14.setHorizontalAlignment(SwingConstants.CENTER);
       label_14.setFont(new Font("宋体", Font.PLAIN, 13));
       label_14.setBounds(335, 10, 44, 27);
       panel_manager_card_2.add(label_14);
       
       tx_manager_name = new JTextField();
       tx_manager_name.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager_name.setBounds(379, 12, 86, 24);
       panel_manager_card_2.add(tx_manager_name);
       tx_manager_name.setColumns(10);
       
       JLabel label_15 = new JLabel("\u624B\u673A\uFF1A");
       label_15.setHorizontalAlignment(SwingConstants.CENTER);
       label_15.setFont(new Font("宋体", Font.PLAIN, 13));
       label_15.setBounds(304, 47, 44, 27);
       panel_manager_card_2.add(label_15);
       
       tx_manager_tel = new JTextField();
       tx_manager_tel.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager_tel.setColumns(10);
       tx_manager_tel.setBounds(345, 49, 122, 24);
       panel_manager_card_2.add(tx_manager_tel);
       
       JLabel label_16 = new JLabel("\u5907\u6CE8\uFF1A");
       label_16.setHorizontalAlignment(SwingConstants.CENTER);
       label_16.setFont(new Font("宋体", Font.PLAIN, 13));
       label_16.setBounds(245, 84, 70, 27);
       panel_manager_card_2.add(label_16);
       
       tx_manager_remind = new JTextField();
       tx_manager_remind.setText("\u65E0");
       tx_manager_remind.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager_remind.setColumns(10);
       tx_manager_remind.setBounds(302, 86, 278, 24);
       panel_manager_card_2.add(tx_manager_remind);
       
       JButton bt_card_manager_cancle = new JButton("\u53D6\u6D88");

       bt_card_manager_cancle.setFont(new Font("宋体", Font.PLAIN, 13));
       bt_card_manager_cancle.setBackground(new Color(245, 245, 220));
       bt_card_manager_cancle.setBounds(487, 49, 93, 23);
       panel_manager_card_2.add(bt_card_manager_cancle);
       
       JButton bt_manager_card_yes = new JButton("\u786E\u5B9A");
    
       bt_manager_card_yes.setFont(new Font("宋体", Font.PLAIN, 13));
       bt_manager_card_yes.setBackground(new Color(245, 245, 220));
       bt_manager_card_yes.setBounds(487, 12, 93, 23);
       panel_manager_card_2.add(bt_manager_card_yes);
       
       JComboBox comb_manager_data = new JComboBox();
       comb_manager_data.setBounds(45, 48, 130, 24);
       panel_manager_card_2.add(comb_manager_data);
       
       JLabel label_17 = new JLabel("\u91D1\u989D\uFF1A");
       label_17.setHorizontalAlignment(SwingConstants.CENTER);
       label_17.setFont(new Font("宋体", Font.PLAIN, 13));
       label_17.setBounds(185, 47, 44, 27);
       panel_manager_card_2.add(label_17);
       
       tx_manager_money = new JTextField();
       tx_manager_money.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager_money.setColumns(10);
       tx_manager_money.setBounds(224, 49, 44, 24);
       panel_manager_card_2.add(tx_manager_money);
       
       JLabel label_19 = new JLabel("\u8D26\u53F7\uFF1A");
       label_19.setHorizontalAlignment(SwingConstants.CENTER);
       label_19.setFont(new Font("宋体", Font.PLAIN, 13));
       label_19.setBounds(185, 10, 44, 27);
       panel_manager_card_2.add(label_19);
       
       tx_manager_account = new JTextField();
       tx_manager_account.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager_account.setColumns(10);
       tx_manager_account.setBounds(224, 13, 101, 24);
       panel_manager_card_2.add(tx_manager_account);
       tx_manager_account.setEditable(false);
       
       JLabel label_20 = new JLabel("\u5143");
       label_20.setHorizontalAlignment(SwingConstants.CENTER);
       label_20.setFont(new Font("宋体", Font.PLAIN, 13));
       label_20.setBounds(262, 47, 32, 27);
       panel_manager_card_2.add(label_20);
       
       JLabel lb_manager_remind_2 = new JLabel("");
       lb_manager_remind_2.setHorizontalAlignment(SwingConstants.CENTER);
       lb_manager_remind_2.setFont(new Font("宋体", Font.PLAIN, 13));
       lb_manager_remind_2.setBounds(240, 111, 340, 19);
       panel_manager_card_2.add(lb_manager_remind_2);
       
       
       
       tx_manager = new JTextField(11);
       tx_manager.setBounds(113, 31, 292, 29);
       panel_manager_card_1.add(tx_manager);
       tx_manager.setHorizontalAlignment(SwingConstants.CENTER);
       tx_manager.setColumns(10);
       tx_manager.setText(info);
       tx_manager.addFocusListener(new MyFocusListener(info, tx_manager));
       
       JButton bt_manager_find = new JButton("\u641C\u7D22");
       bt_manager_find.setBounds(420, 31, 93, 29);
       panel_manager_card_1.add(bt_manager_find);
       bt_manager_find.setBackground(new Color(245, 255, 250));
       
       JLabel lblNewLabel_3 = new JLabel("\uFF08\u63D0\u793A\uFF1A\u5728\u8868\u683C\u4E2D\u9009\u62E9\u5F85\u64CD\u4F5C\u884C\uFF0C\u70B9\u51FB\u6309\u94AE\u8FDB\u884C\u76F8\u5E94\u64CD\u4F5C\uFF09");
       lblNewLabel_3.setBounds(83, 69, 344, 23);
       panel_manager_card_1.add(lblNewLabel_3);
       lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 13));
       
       JLabel lb_manager_remind = new JLabel("");
       lb_manager_remind.setBounds(72, 102, 355, 23);
       panel_manager_card_1.add(lb_manager_remind);
       lb_manager_remind.setHorizontalAlignment(SwingConstants.LEFT);
       lb_manager_remind.setFont(new Font("宋体", Font.PLAIN, 14));
       
       JButton bt_manager_save = new JButton("\u4FDD\u5B58");
       bt_manager_save.setBounds(404, 139, 93, 23);
       manager_panel.add(bt_manager_save);
       bt_manager_save.setBackground(new Color(245, 245, 220));
       bt_manager_save.setFont(new Font("宋体", Font.PLAIN, 13));
       
   
  
       
       //管理面板，未写完、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、
       bt_manager_find.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		int manager_row=table_manager.getRowCount();
       		for(int i=0;i<manager_row;i++){
       			tableModel.removeRow(0);
       		}
       		file_getinformation.clear();
       		file_getinformation=file_operation.read("ticket");
       	manager_result.clear();
       	lb_manager_remind.setText("");
       	manager_result=FCT.Query_Find(file_getinformation, "manager",tx_manager.getText());
       	if(manager_result.get(0)<0){
       		lb_manager_remind.setText("没有查询到相关信息！");
       	}else{
       		lb_manager_remind.setText("");
       		for(int i=0;i<manager_result.size();i++){
       			String t=file_getinformation.get(manager_result.get(i));
       			manager_order.add(t);
       			String[] s_add=t.split("-");
       			tableModel.addRow(s_add);
       		}
       	}
       	}
       });
 /////////////////////////////////////////////////////////////点击事件的书写区域      =====================
       
     
		bt_clear.setBackground(new Color(245, 255, 250));
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tx_are_query.setText("");
			}
		});
       
       	Calendar show_data = Calendar.getInstance();
		lb_time.setText(show_data.get(Calendar.YEAR)+"年"+(show_data.get(Calendar.MONTH)+1)+"月"+show_data.get(Calendar.DAY_OF_MONTH)+"日");
		
		//combox的初始化
	       for(int i=0;i<24;i++){
	    	   if(i<10){
	    		   comb_road_hour.addItem("0"+i);
	    	   }else{
	    	   comb_road_hour.addItem(i);
	    	   }
	       }
	       for(int j=0;j<60;j++){
	    	   if(j<10){
	    		   comb_road_mim.addItem("0"+j);
	    	   }else {
	    		   comb_road_mim.addItem(j);
		       }
	       }
	       
	       //卡片的切换、、、、、、、、、、、、、、、、、、、、
		tgbt_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(card_panel,"1");
				
			}
		});
		tgbt_manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(card_panel,"2");
				Vector<String> road_name=new Vector<String>();
	       		road_name.clear();
	       		road_name=FCT.Get_Road();
	       		comb_manager_road.removeAllItems();
	       		for(int i=0;i<road_name.size();i++){
	       			comb_manager_road.addItem(road_name.get(i));
	       		}
	       		String data=FCT.Get_Road_Data(comb_manager_road.getSelectedItem().toString());
	    		String[] road_data=data.split("-");
	    		comb_manager_data.removeAllItems();
	    		for(int i=0;i<road_data.length;i++){
	    			comb_manager_data.addItem(road_data[i]);
	    		}
	    		String time=FCT.Get_Road_Time(comb_manager_road.getSelectedItem().toString(),comb_manager_data.getSelectedItem().toString());
	    		String[] road_time=time.split("-");
	    	//	System.out.println(road_time[0]);
	    		comb_manager_time.removeAllItems();
	    		for(int i=0;i<road_time.length;i++){
	    			comb_manager_time.addItem(road_time[i]);
	    		}
	    		int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
	    		comb_manager_road.getSelectedItem().toString());
	    		comb_manager_num.removeAllItems();
	    		for(int i=1;i<=num;i++){
	    			comb_manager_num.addItem(i);
	    		}
			}
		});
		tgbt_statistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				file_getinformation.clear();
//				file_getinformation=file_operation.read("ticket");
				card.show(card_panel,"3");
				list_statistics.setListData(file_getinformation);
				tx_are_statistics.setText("");
				tx_total_money.setText("");
				tx_total_people.setText("");
//				String[] s=FCT.Statistics_Total(file_getinformation).split("-");
//				tx_total_money.setText(s[1]);
//				tx_total_people.setText(s[0]);
			}
		});
//////////////////////////////////////		
		
     //查询面板=============================================================================

   	
   	//管理面板====================================================================
    bt_manager_del.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		int num=table_manager.getSelectedRows().length;
    		int[] manager_row=table_manager.getSelectedRows();
    		if(num<=0){
    			lb_manager_remind.setText("请选择要删除的对象");
    			lb_manager_remind_2.setText("请选择要删除的对象");
    		}else if(num>1){
    		for(int i=0;i<num;i++){
    			manager_del.add((String) tableModel.getValueAt(manager_row[i]-i, 10));
    			tableModel.removeRow(manager_row[i]-i);  //注意随着删除的进行，行号也随着变化
    		}
    		}else{
    			manager_del.add((String) tableModel.getValueAt(manager_row[0], 10));
    			tableModel.removeRow(manager_row[0]);
    		}
       	}
       });
    
    bt_magager_add.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		new_or_old=0; //0表示是new
       		FCT.Remove_Dead_Road();
       		lb_manager_remind_2.setText("");
       		card_manager_mother.show(panel_manager_mother,"2");
       		Vector<String> road_name=new Vector<String>();
       		road_name.clear();
       		tx_manager_account.setText(account);
       		road_name=FCT.Get_Road();
       		comb_manager_road.removeAllItems();
       		for(int i=0;i<road_name.size();i++){
       			comb_manager_road.addItem(road_name.get(i));
       		}
       		String data=FCT.Get_Road_Data(comb_manager_road.getSelectedItem().toString());
    		String[] road_data=data.split("-");
    		comb_manager_data.removeAllItems();
    		for(int i=0;i<road_data.length;i++){
    			comb_manager_data.addItem(road_data[i]);
    		}
    		String time=FCT.Get_Road_Time(comb_manager_road.getSelectedItem().toString(),comb_manager_data.getSelectedItem().toString());
    		String[] road_time=time.split("-");
    	//	System.out.println(road_time[0]);
    		comb_manager_time.removeAllItems();
    		for(int i=0;i<road_time.length;i++){
    			comb_manager_time.addItem(road_time[i]);
    		}
    		int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
    		comb_manager_road.getSelectedItem().toString());
    		comb_manager_num.removeAllItems();
    		for(int i=1;i<=num;i++){
    			comb_manager_num.addItem(i);
    		}
    		double money=FCT.Get_Road_Money(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
					comb_manager_road.getSelectedItem().toString())*Integer.parseInt(comb_manager_num.getSelectedItem().toString());
    		money=((int)(money*100))/100;	
    		tx_manager_money.setText(money+"");
       	}
       });
   
    bt_manager_change.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		lb_manager_remind.setText("");
       		lb_manager_remind_2.setText("");
       		int row_num=table_manager.getSelectedRows().length;
       		if(row_num!=1){
       			lb_manager_remind.setText("请选择要修改的单行数据");
       			lb_manager_remind_2.setText("请选择要修改的单行数据");
    //   		}else if(){
       			
       		}else{
       			new_or_old=1;
       			change_row_num=table_manager.getSelectedRow();
       			if(FCT.Judge_Ticket(tableModel.getValueAt(change_row_num, 0)+"-"+tableModel.getValueAt(change_row_num, 1)+"-")){
       				lb_manager_remind.setText("要修改的票已过期");
       			}else{
       			card_manager_mother.show(panel_manager_mother,"2");
       			Vector<String> road_name=new Vector<String>();
           		road_name.clear();
           		road_name=FCT.Get_Road();
           		comb_manager_road.removeAllItems();
           		for(int i=0;i<road_name.size();i++){
           			comb_manager_road.addItem(road_name.get(i));
           		}
           		comb_manager_road.setSelectedItem((String)tableModel.getValueAt(change_row_num, 2)+"-"+(String)tableModel.getValueAt(change_row_num, 3));
           		int num_1=Integer.parseInt((String) tableModel.getValueAt(change_row_num,6));
           		String data=FCT.Get_Road_Data(comb_manager_road.getSelectedItem().toString());
        		String[] road_data=data.split("-");
        		comb_manager_data.removeAllItems();
        		for(int i=0;i<road_data.length;i++){
        			comb_manager_data.addItem(road_data[i]);
        		}
        		comb_manager_data.setSelectedItem((String)tableModel.getValueAt(change_row_num, 0));
        		String time=FCT.Get_Road_Time(comb_manager_road.getSelectedItem().toString(),comb_manager_data.getSelectedItem().toString());
        		String[] road_time=time.split("-");
        	//	System.out.println(road_time[0]);
        		comb_manager_time.removeAllItems();
        		for(int i=0;i<road_time.length;i++){
        			comb_manager_time.addItem(road_time[i]);
        		}
        		comb_manager_time.setSelectedItem((String)tableModel.getValueAt(change_row_num, 1));
        		int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
        		comb_manager_road.getSelectedItem().toString());
        		num=num+num_1;
        		comb_manager_num.removeAllItems();
        		for(int i=1;i<=num;i++){
        			comb_manager_num.addItem(i);
        		}
        	//	comb_manager_time.setSelectedItem((String)tableModel.getValueAt(change_row_num, 6));
        		comb_manager_num.setSelectedItem(num_1);
        		tx_manager_account.setText((String)tableModel.getValueAt(change_row_num, 9));
        		tx_manager_money.setText((String)tableModel.getValueAt(change_row_num, 7));
        		tx_manager_name.setText((String)tableModel.getValueAt(change_row_num, 4));
        		tx_manager_tel.setText((String)tableModel.getValueAt(change_row_num, 5));
        		tx_manager_remind.setText((String)tableModel.getValueAt(change_row_num, 8));
       			}
       		}		
       	}
       });
    
    JPanel panel_2 = new JPanel();
    panel_2.setBackground(new Color(245, 245, 245));
    panel_2.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u9009\u62E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel_2.setBounds(26, 10, 574, 112);
    query_panel.add(panel_2);
    panel_2.setLayout(null);
    
    
    JPanel panel_query_mother = new JPanel();
    panel_query_mother.setBounds(63, 39, 373, 63);
    panel_2.add(panel_query_mother);
    CardLayout card_query=new CardLayout();
    panel_query_mother.setLayout(card_query);
    
    JPanel card_query_data = new JPanel();
    card_query_data.setBackground(new Color(245, 245, 245));
    JPanel card_query_road = new JPanel();
    card_query_road.setBackground(new Color(245, 245, 245));
    panel_query_mother.add("1",card_query_data);
    card_query_data.setLayout(null);
    query_calander.setBackground(new Color(245, 245, 245));
    
    query_calander.setBounds(175, 10, 188, 36);
    card_query_data.add(query_calander);
    
    JLabel lblNewLabel_8 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65E5\u671F\uFF1A");
    lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 14));
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_8.setBounds(28, 10, 148, 28);
    card_query_data.add(lblNewLabel_8);
    panel_query_mother.add("2",card_query_road);
    card_query_road.setLayout(null);
    
    JComboBox comb_query_road = new JComboBox();
    comb_query_road.setBackground(new Color(245, 245, 220));
    comb_query_road.setFont(new Font("宋体", Font.PLAIN, 13));
    comb_query_road.setBounds(162, 10, 155, 30);
    card_query_road.add(comb_query_road);
    
    JLabel lblNewLabel_9 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u8DEF\u7EBF\uFF1A");
    lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 14));
    lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_9.setBounds(29, 10, 123, 30);
    card_query_road.add(lblNewLabel_9);
    
    JRadioButton rbt_address = new JRadioButton("\u6309\u8DEF\u7EBF");
    rbt_address.setBounds(300, 16, 91, 25);
    panel_2.add(rbt_address);
    rbt_address.setFont(new Font("宋体", Font.PLAIN, 14));
    rbt_address.setBackground(new Color(245, 245, 245));
    rbt_address.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			comb_get_road.clear();
			FCT.Remove_Dead_Road();
			card_query.show(panel_query_mother,"2");
			comb_get_road=FCT.Get_Road();
			comb_query_road.removeAllItems();
			for(int i=0;i<comb_get_road.size();i++){
				comb_query_road.addItem(comb_get_road.get(i));
			}
		}	
	});
    bg_tgbt_query.add(rbt_address);
    
    JRadioButton rbt_data = new JRadioButton("\u6309\u65E5\u671F");
    rbt_data.setBounds(130, 16, 91, 25);
    panel_2.add(rbt_data);
    rbt_data.setSelected(true);
    rbt_data.setFont(new Font("宋体", Font.PLAIN, 14));
    rbt_data.setBackground(new Color(245, 245, 245));
    
    rbt_data.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			card_query.show(panel_query_mother,"1");
   		}
   	});
    bg_tgbt_query.add(rbt_data);
   // tx_user_account.setEditable(false);
  //  tx_user_surplus.setEditable(false);
    table_manager.getTableHeader().setReorderingAllowed(false);   //不可整列移动   
    table_manager.getTableHeader().setResizingAllowed(false);   //不可拉动表格
    
    table_road.getTableHeader().setReorderingAllowed(false);   //不可整列移动   
    table_road.getTableHeader().setResizingAllowed(false);   //不可拉动表格
    JPanel user_panel=new JPanel();
    user_panel.setBackground(new Color(245, 255, 250));
    card_panel.add("5",user_panel);
    user_panel.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 127, 202, 230);
    user_panel.add(scrollPane);
    
    JList list_user = new JList();
    list_user.setFont(new Font("宋体", Font.PLAIN, 12));
    list_user.setToolTipText("");
    scrollPane.setViewportView(list_user);
    
    JLabel lblNewLabel_12 = new JLabel("\u5DF2\u6CE8\u518C\u7528\u6237\uFF1A");
    lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 14));
    lblNewLabel_12.setBounds(10, 25, 84, 29);
    user_panel.add(lblNewLabel_12);
    
    tx_user_peopel = new JTextField();
    tx_user_peopel.setHorizontalAlignment(SwingConstants.CENTER);
    tx_user_peopel.setBounds(112, 27, 77, 25);
    user_panel.add(tx_user_peopel);
    tx_user_peopel.setColumns(10);
    
    JLabel lblNewLabel_13 = new JLabel("\u4EBA");
    lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 14));
    lblNewLabel_13.setBounds(194, 30, 54, 22);
    user_panel.add(lblNewLabel_13);
    
    JTextArea tx_are_user = new JTextArea();
   // user_panel.add(tx_are_user);
    JScrollPane jsp_user=new JScrollPane(tx_are_user);
    user_panel.add(jsp_user);
    tx_are_user.setEditable(false);
    tx_are_user.setLineWrap(true);
    jsp_user.setBounds(222, 127, 397, 230);
 //  jsp_user.setViewportView(tx_are_user);
   
    
    JButton bt_user_query = new JButton("\u67E5\u770B");
    bt_user_query.setBackground(new Color(240, 255, 255));
    bt_user_query.setBounds(10, 94, 77, 23);
    user_panel.add(bt_user_query);
    
    JButton bt_user_remove = new JButton("\u79FB\u9664");
    bt_user_remove.setBackground(new Color(240, 255, 255));

    bt_user_remove.setBounds(112, 94, 77, 23);
    user_panel.add(bt_user_remove);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(245, 245, 220));
    panel.setBorder(new TitledBorder(null, "\u5145\u503C\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel.setBounds(255, 10, 364, 112);
    user_panel.add(panel);
    panel.setLayout(null);
    
    JLabel lblNewLabel_14 = new JLabel("\u8D26\u53F7\uFF1A");
    lblNewLabel_14.setBounds(26, 23, 54, 24);
    panel.add(lblNewLabel_14);
    
    tx_user_account = new JTextField();
    tx_user_account.setHorizontalAlignment(SwingConstants.CENTER);
    tx_user_account.setFont(new Font("宋体", Font.PLAIN, 13));
    tx_user_account.setBounds(70, 25, 111, 22);
    panel.add(tx_user_account);
    tx_user_account.setColumns(10);
    tx_user_account.setEditable(false);
    JLabel label_21 = new JLabel("\u4F59\u989D\uFF1A");
    label_21.setFont(new Font("宋体", Font.PLAIN, 13));
    label_21.setHorizontalAlignment(SwingConstants.CENTER);
    label_21.setBounds(191, 23, 54, 24);
    panel.add(label_21);
    
    tx_user_surplus = new JTextField();
    tx_user_surplus.setColumns(10);
    tx_user_surplus.setBounds(242, 25, 66, 22);
    panel.add(tx_user_surplus);
    tx_user_surplus.setEditable(false);
    JLabel label_22 = new JLabel("\u5143");
    label_22.setHorizontalAlignment(SwingConstants.CENTER);
    label_22.setBounds(310, 23, 25, 24);
    panel.add(label_22);
    
    JLabel label_23 = new JLabel("\u5145\u503C\u91D1\u989D\uFF1A");
    label_23.setBounds(26, 57, 80, 24);
    panel.add(label_23);
    
    tx_user_add_money = new JTextField();
    tx_user_add_money.setFont(new Font("宋体", Font.PLAIN, 13));
    tx_user_add_money.setHorizontalAlignment(SwingConstants.CENTER);
    tx_user_add_money.setColumns(10);
    tx_user_add_money.setBounds(91, 59, 66, 22);
    panel.add(tx_user_add_money);
    
    JLabel label_24 = new JLabel("\u5143");
    label_24.setHorizontalAlignment(SwingConstants.CENTER);
    label_24.setBounds(156, 57, 25, 24);
    panel.add(label_24);
    
    JButton bt_user_add_money = new JButton("\u5145\u503C");
    bt_user_add_money.setBackground(new Color(240, 255, 255));
 
    bt_user_add_money.setBounds(252, 58, 77, 23);
    panel.add(bt_user_add_money);
    
    JLabel lb_user_add_remind = new JLabel("");
    lb_user_add_remind.setFont(new Font("宋体", Font.PLAIN, 13));
    lb_user_add_remind.setBounds(36, 90, 288, 15);
    panel.add(lb_user_add_remind);
    
    JLabel lb_user_remind = new JLabel("");
    lb_user_remind.setFont(new Font("宋体", Font.PLAIN, 13));
    lb_user_remind.setBounds(10, 64, 184, 20);
    user_panel.add(lb_user_remind);
    
    bt_manager_cancel.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		int manager_num=table_manager.getRowCount();
       		manager_del.clear();
       		manager_change_order.clear();
    		for(int i=0;i<manager_num;i++){
    			tableModel.removeRow(0);
    		}
    		for(int i=0;i<manager_order.size();i++){
       			String[] s_add=manager_order.get(i).split("-");
       			tableModel.addRow(s_add);
       			
    	}
       	}
       });
    
    bt_manager_save.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		file_getinformation.clear();
       		file_getinformation=file_operation.read("ticket");
       		file_getnum_order=file_operation.read("order");
       		int num_order=Integer.parseInt(file_getnum_order.get(0).substring(2)); //////
      // 		int num_order_last=num_order;
       		int manager_row=table_manager.getRowCount();
    		int manager_column=table_manager.getColumnCount();
    //		System.out.println(road_column);
    	//	file_.clear();
    		manager_order.clear();
    		for(int i=0;i<manager_row;i++){
    			String s_manager_row="";
    			for(int j=0;j<manager_column;j++){
    				if(j==10){
    					String s=(String)tableModel.getValueAt(i, j);
    		//			System.out.println(s);
    					if(s==null){
    					//	System.out.println("new order");
    						num_order++;
    		//				System.out.println("======"+num_order);
    						s_manager_row=s_manager_row+"wh"+num_order+"-";
    						
    					}else{
    						s_manager_row=s_manager_row+(String)tableModel.getValueAt(i, j)+"-";
    					
    					}
    				}else{

    					s_manager_row=s_manager_row+(String)tableModel.getValueAt(i, j)+"-";
    				}
    		}
    			manager_order.add(s_manager_row);
    		}
   
    //删除=================================		
    		for(int i=0;i<manager_del.size();i++){
    			int k=FCT.find_num_order(file_getinformation, manager_del.get(i),2);
    			if(k!=-1){
    				file_operation.write_singel_ticket(file_getinformation.get(k),FCT.Get_Text(file_getinformation.get(k),10),1,1);
    				file_getinformation.remove(k);
    			}
    		}
    		//将修改的先删除
//    		for(int i=0;i<manager_order.size();i++){
//    			int k=FCT.find_num_order(file_getinformation, manager_order.get(i),1);
//    			if(k>=0){
//    				file_getinformation.remove(k);
//    				}
//    		}
    		file_operation.write(file_getinformation, "ticket");
    		//将修改的和新添加的进行排序添加
    		for(int i=0;i<manager_order.size();i++){
    			int k=FCT.find_num_order(file_getinformation, manager_order.get(i),1);
    			if(k>=0){
    				FCT.Sort_Ticket(manager_order.get(i));
    				if(FCT.find_num_order(manager_change_order, manager_order.get(i), 4)==1){ //是修改的
    				file_operation.write_singel_ticket(manager_order.get(i),FCT.Get_Text(manager_order.get(i),10), 2,1);
    				}else{
    				file_operation.write_singel_ticket(manager_order.get(i),FCT.Get_Text(manager_order.get(i),10), 0,1);
    				}
    			}else{
    				FCT.Sort_Ticket(manager_order.get(i));
    				file_operation.write_singel_ticket(manager_order.get(i),FCT.Get_Text(manager_order.get(i),10), 0,1);
    				//调用排序函数
    				//更新订单数的上限
    			//	num_order_last++;
    			}
    		}
    		for(int i=0;i<manager_row;i++){
				tableModel.removeRow(0);
			}
    		for(int i=0;i<manager_order.size();i++){
       			String[] s_add=manager_order.get(i).split("-");
       			tableModel.addRow(s_add);
    		}
    		file_getnum_order.clear();
    		file_getnum_order.add("wh"+num_order);
    		file_operation.write(file_getnum_order, "order");
    		manager_del.clear();
    		manager_change_order.clear();
    		FCT.Updata_road();
       	}
       });
    
    bt_manager_card_yes.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		String single_ticket=comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
       	comb_manager_road.getSelectedItem().toString()+"-"+tx_manager_name.getText()+"-"+tx_manager_tel.getText()+"-"+comb_manager_num.getSelectedItem().toString()+"-"+
       				tx_manager_money.getText()+"-"+tx_manager_remind.getText()+"-"+tx_manager_account.getText()+"-";
       		String[] judge=single_ticket.split("-");
       		int k=0;
       		for(;k<judge.length;k++){
       			if(judge[k].equals("")){
       				break;
       			}
       		}
//       		System.out.println(single_ticket);
//      		System.out.println("=============="+judge.length);
       		if(k==10){
       			if(new_or_old==1){
       				manager_change_order.add((String) tableModel.getValueAt(change_row_num, 10));
           			for(int i=0;i<judge.length;i++){
           				tableModel.setValueAt(judge[i],change_row_num, i);
           			}
           		}else{
           			tableModel.addRow(judge);
           		}
       			tx_manager_account.setText("");
       			tx_manager_money.setText("");
       			tx_manager_name.setText("");
       			tx_manager_remind.setText("无");
       			tx_manager_tel.setText("");
       			lb_manager_remind.setText("");
       			card_manager_mother.show(panel_manager_mother,"1");
       		}else{
       			lb_manager_remind_2.setText("请将信息填写完整");
       		}
       	}
       });
    
    bt_card_manager_cancle.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		card_manager_mother.show(panel_manager_mother,"1");
       		lb_manager_remind.setText("");
       	}
       });
   	
    list_statistics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBackground(new Color(248, 248, 255));
    panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel_3.setBounds(196, 10, 423, 153);
    statistics_panel.add(panel_3);
   	//统计面板===============================================================
   	bt_statistic_see.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Vector<String> statistics_result=new Vector<String>();
			statistics_result.clear();
			file_getinformation.clear();
			list_statistics.setListData(statistics_result);
			file_getinformation=file_operation.read("ticket");
			statistics_result=FCT.Statistics_Find(file_getinformation,comboBox.getSelectedItem().toString());
			if(statistics_result.get(0).equals("没有查询到相关信息")){
				tx_are_statistics.setText("没有查询到相关信息\r\n");
			}else{
				list_statistics.setListData(statistics_result);
			}
		}
	});
   	
   	bt_statistics_clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			tx_are_statistics.setText("");
			tx_total_money.setText("");
			tx_total_people.setText("");
		}
	});
   
   	bt_statistics_total.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tx_total_money.setText("");
			tx_total_people.setText("");
		  String select_statistics_road=(String) list_statistics.getSelectedValue();
		  if(select_statistics_road==null){
			  tx_are_statistics.setText("请选择查看对象\r\n");
		  }else{
			  Vector<String> road_ticket=new Vector<String>();
			  road_ticket.clear();
			  road_ticket=FCT.Get_Statistics_Ticket(select_statistics_road);
			  String[] total=FCT.Statistics_Total(road_ticket).split("-");
			  tx_total_money.setText(total[1]);
			  tx_total_people.setText(total[0]);
			  for(int i=0;i<road_ticket.size();i++){
				  tx_are_statistics.append(road_ticket.get(i)+"\r\n");
			  }
		  }
		}
	});
   	
   	//管理路线面板 =============================================================
   	tgbt_road.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			card.show(card_panel,"4");
			int num=table_road.getRowCount();
			FCT.Remove_Dead_Road();
			file_getroad.clear();
			FCT.Updata_road();//更新数据
			file_getroad=file_operation.read("road_information");
			for(int i=0;i<num;i++){
				tableModel_road.removeRow(0);
			}
			if(file_getroad.size()==0){
	       		lb_road.setText("目前尚没有相关路线");
	       	}else{
	       		lb_manager_remind.setText("");
	       		for(int i=0;i<file_getroad.size();i++){
	       			String[] s_add=file_getroad.get(i).split("-");
	       			tableModel_road.addRow(s_add);
	       		}
	       	}
		}
	});
   	
    bt_road_del.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		int num=table_road.getSelectedRows().length;
    		int[] road_row=table_road.getSelectedRows();
    		if(num>1){
    		for(int i=0;i<num;i++){
    			tableModel_road.removeRow(road_row[i]-i);  //注意随着删除的进行，行号也随着变化
    		}
    		}else{
    			tableModel_road.removeRow(road_row[0]);
    		}
    	}
    });
    
    bt_road_save.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		Vector<String> road_t=new Vector<String>();
    		road_t.clear();
    		int road_row=table_road.getRowCount();
    		int road_column=table_road.getColumnCount();
    //		System.out.println(road_column);
    		file_getroad.clear();
    		int flag=0;
    		for(int i=0;i<road_row;i++){
    			String s_road_row="";
    			if((Integer.parseInt((String)tableModel_road.getValueAt(i, 5))-Integer.parseInt((String)tableModel_road.getValueAt(i,6)))<0||Double.parseDouble((String)tableModel_road.getValueAt(i, 4))<0){
    				flag=i+1;
    				break;
    			}
    			for(int j=0;j<road_column;j++){
    				s_road_row=s_road_row+(String)tableModel_road.getValueAt(i, j)+"-";
//    				String s_judge=(String)tableModel_road.getValueAt(i, j);
//    				if(s_judge==null){
//    					count++;
//    				}
//    				if(j==6){
//    					String s=(String)tableModel_road.getValueAt(i, j);
//    					if(s==null){
//    						s_road_row=s_road_row+"0-";
//    						s_road_row=s_road_row+(String) tableModel_road.getValueAt(i, 5)+"-";
//    						break;
//    					}else{
//    						s_road_row=s_road_row+(String) tableModel_road.getValueAt(i, j)+"-";
//    					}
//    				}else{
//    					s_road_row=s_road_row+(String) tableModel_road.getValueAt(i, j)+"-";
//    				}
    		}
//    			if(count<=1){
//    				road_t.add(s_road_row);
//    				count=0;
//    			}else{
//    				count=0;
//    			}
    			road_t.add(s_road_row);
    		}
    		if(flag==0){
			for(int i=0;i<road_row;i++){
				tableModel_road.removeRow(0);
			}
			file_getroad=FCT.Sort_Road(road_t);//调整顺序
			file_operation.write(file_getroad, "road_information");//写入
			FCT.Updata_road();//更新数据
			file_getroad.clear();
			file_getroad=file_operation.read("road_information");
    		for(int i=0;i<file_getroad.size();i++){
       			String[] s_add=file_getroad.get(i).split("-");
       			tableModel_road.addRow(s_add);
    		}
    		if(file_getroad.size()>0){
    			lb_road.setText("");
        		}else{
    			lb_road.setText("目前尚没有相关路线");
        		}
    		}else{
    			lb_road.setText("第"+flag+"行数据存在问题，无法保存");
    		}
    	
    		
 
    	//	tableModel_road.setValueAt("1", 0, 6);
//    		int i=table_road.getSelectedRow();
//    		String s=(String) tableModel_road.getValueAt(0, 2);
//    		System.out.println(i+"  "+s);
    	}
    });   
    
    bt_road_cancel.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		file_getroad=file_operation.read("road_information");
    		int road_num=table_road.getRowCount();
    		for(int i=0;i<road_num;i++){
    			tableModel_road.removeRow(0);
    		}
    		for(int i=0;i<file_getroad.size();i++){
       			String[] s_add=file_getroad.get(i).split("-");
       			tableModel_road.addRow(s_add);
    	}
    }
    });
	
    
  list_user.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    bt_road_add.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		lb_road.setText("");
    		String new_road_start;
    		new_road_start=road_calander.tx_data.getText()+"-"+comb_road_hour.getSelectedItem()+":"+comb_road_mim.getSelectedItem()+"-"+
    		tx_road_start.getText()+"-"+tx_road_end.getText()+"-"+tx_road_money.getText()+"-"+tx_road_num.getText();
    		String[] new_road_end=FCT.Add_New_Road(new_road_start).split("-");
    		
    		if(new_road_end[0].equals("no")){
    			lb_road.setText("请将待添加路线信息填写完整");
    		}else if(new_road_end[0].equals("time")){
    			lb_road.setText("该路线距离发车时间不足1小时或已过期");
    		}else if(new_road_end[0].equals("old")) {
    			lb_road.setText("该路线已存在");
    		}else{
    			tableModel_road.addRow(new_road_end);
			}
    	}
    });
    
    tgbt_user.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			card.show(card_panel, "5");
			file_getname.clear();
			file_getname=FCT.Get_User_Name();
			tx_user_peopel.setText(file_getname.size()+"");
			list_user.setListData(file_getname);
			tx_are_user.setText("");
			tx_user_account.setText("");
			tx_user_surplus.setText("");
		}
	});
    bt_user_query.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		lb_user_remind.setText("");
    		lb_user_add_remind.setText("");
    		tx_are_user.setText("");
    		String select_user=(String) list_user.getSelectedValue();
    		if(select_user==null){
    			lb_user_remind.setText("请选择操作的对象");
    		}else{
    		String select_account=select_user.substring(3, select_user.indexOf(" "));
    		user_information.clear();
    		FCT.Updata_User_Information(select_account);
    		user_information=file_operation.read(select_account);
    		String[] user=user_information.get(0).split("-");
    		tx_are_user.append("账号："+user[0]+"\r      "+"姓名："+user[1]+"\r      "+"手机号码："+user[2]+"\r\n");
    		tx_are_user.append("积分："+user[4]+"\r      "+"信用度："+user[5]+"\r\n");
    		tx_user_account.setText(user[0]);
    		tx_user_surplus.setText(user[6]);
    		tx_are_user.append("未完成订单：\r\n");
    		int flag=0;
    		for(int i=1;i<user_information.size();i++){
    			if(user_information.get(i).equals("=====")){
    				if(flag==0){
    					tx_are_user.append("无\r\n");
    					flag=-1;
    					tx_are_user.append("历史订单：\r\n");
    				}else {
    					flag=-1;
						tx_are_user.append("历史订单：\r\n");
					}
    			}else{
    				flag=1;
    				tx_are_user.append(user_information.get(i)+"\r\n");
    			}
    		}
    		if(flag==-1){
    			tx_are_user.append("无\r\n");
    		}
    		}
    	}
    });
    
    bt_user_add_money.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		lb_user_add_remind.setText("");
    		if(tx_user_account.getText().equals("")){
    			lb_user_add_remind.setText("请选择充值账号");
    		}else if(tx_user_add_money.getText().equals("")){
    			lb_user_add_remind.setText("请填写充值金额");
    		}else{
    		double total_money=Double.parseDouble(tx_user_add_money.getText())+Double.parseDouble(tx_user_surplus.getText());
    		total_money=((int)(total_money*100))/100;
    		tx_user_surplus.setText(""+total_money);
    		tx_user_add_money.setText("");
    		FCT.Updata_Surpls(tx_user_account.getText()+"-"+tx_user_surplus.getText());
    	}
    		}
    });
    bt_user_remove.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		file_getname.clear();
    		file_getname=FCT.Get_User_Name();
    		lb_user_remind.setText("");
    		lb_user_add_remind.setText("");
    		tx_user_account.setText("");
    		tx_user_surplus.setText("");
    		tx_user_add_money.setText("");
    		int n=list_user.getSelectedIndex();
    		if(n==-1){
    			lb_user_remind.setText("请选择操作对象");
    		}else{    	
    		//	System.out.println("========="+n);
    			String account=file_getname.get(n);
    		//	System.out.println("========="+account);
    			String select_account=account.substring(3, account.indexOf(" "));
    			file_getname.remove(n);
    			list_user.setListData(file_getname);
    			FCT.Updata_User_Name(select_account);
    			tx_user_peopel.setText(""+file_getname.size());
    		}
    	}
    });
    
 /////////===============================================================   
    //路线的下拉框事件
    comb_manager_road.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO 自动生成的方法存根
			if(e.getStateChange() == ItemEvent.SELECTED){  
			String data=FCT.Get_Road_Data(comb_manager_road.getSelectedItem().toString());
			String[] road_data=data.split("-");
			comb_manager_data.removeAllItems();
			for(int i=0;i<road_data.length;i++){
				comb_manager_data.addItem(road_data[i]);
			}
			String time=FCT.Get_Road_Time(comb_manager_road.getSelectedItem().toString(),comb_manager_data.getSelectedItem().toString());
			String[] road_time=time.split("-");
			comb_manager_time.removeAllItems();
			for(int i=0;i<road_time.length;i++){
				comb_manager_time.addItem(road_time[i]);
			}
			int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
			comb_manager_road.getSelectedItem().toString());
			comb_manager_num.removeAllItems();
			for(int i=1;i<=num;i++){
				comb_manager_num.addItem(i);
			}
			double money=FCT.Get_Road_Money(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
					comb_manager_road.getSelectedItem().toString())*Integer.parseInt(comb_manager_num.getSelectedItem().toString());
			money=((int)(money*100))/100;		
			tx_manager_money.setText(money+"");
			}
		}
	});
    //日期下拉框事件
    comb_manager_data.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO 自动生成的方法存根
			if(e.getStateChange() == ItemEvent.SELECTED){  
			String time=FCT.Get_Road_Time(comb_manager_road.getSelectedItem().toString(),comb_manager_data.getSelectedItem().toString());
			String[] road_time=time.split("-");
			comb_manager_time.removeAllItems();
			for(int i=0;i<road_time.length;i++){
				comb_manager_time.addItem(road_time[i]);
			}
			int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
			comb_manager_road.getSelectedItem().toString());
			comb_manager_num.removeAllItems();
			for(int i=1;i<=num;i++){
				comb_manager_num.addItem(i);
			}
			double money=FCT.Get_Road_Money(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
					comb_manager_road.getSelectedItem().toString())*Integer.parseInt(comb_manager_num.getSelectedItem().toString());
			money=((int)(money*100))/100;	
			tx_manager_money.setText(money+"");
			}
		}
	});
    
    //时间下拉框事件
    comb_manager_time.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO 自动生成的方法存根
			if(e.getStateChange() == ItemEvent.SELECTED){  
			int num=FCT.Get_Road_num(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
					comb_manager_road.getSelectedItem().toString());
					comb_manager_num.removeAllItems();
					for(int i=1;i<=num;i++){
						comb_manager_num.addItem(i);
					}
					double money=FCT.Get_Road_Money(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
							comb_manager_road.getSelectedItem().toString())*Integer.parseInt(comb_manager_num.getSelectedItem().toString());
					money=((int)(money*100))/100;	
					tx_manager_money.setText(money+"");
			}
		}
	});
    
    //人数下拉框事件
    comb_manager_num.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()== ItemEvent.SELECTED){
				double money=FCT.Get_Road_Money(comb_manager_data.getSelectedItem().toString()+"-"+comb_manager_time.getSelectedItem().toString()+"-"+
					comb_manager_road.getSelectedItem().toString())*Integer.parseInt(comb_manager_num.getSelectedItem().toString());
				money=((int)(money*100))/100;	
				tx_manager_money.setText(money+"");
			}
			
		}
	});
	bt_query.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String rbt_select=null;
			Vector<Integer> query_result=new Vector<Integer>();
			query_result.clear();
			file_getinformation.clear();
			file_getinformation=file_operation.read("ticket");
			if(rbt_address.isSelected()){
				rbt_select="按路线";
				query_result=FCT.Query_Find(file_getinformation, rbt_select,comb_query_road.getSelectedItem().toString());
			}else if(rbt_data.isSelected()){
				rbt_select="按日期";
				query_result=FCT.Query_Find(file_getinformation, rbt_select,query_calander.tx_data.getText());
			}
			if(query_result.get(0)>=0){
			for(int i=0;i<query_result.size();i++){
				tx_are_query.append(file_getinformation.get(query_result.get(i))+"\r\n");
			}
			}else{
				tx_are_query.append("未查询到相关信息"+"\r\n");
			}
		}
	});
     
	}
	
	class MyFocusListener implements FocusListener {  
	    String info;  
	    JTextField jtf;  
	    public MyFocusListener(String info, JTextField jtf) {  
	        this.info = info;  
	        this.jtf = jtf;  
	    }  
	    @Override  
	    public void focusGained(FocusEvent e) {//获得焦点的时候,清空提示文字  
	        String temp = jtf.getText();  
	        if(temp.equals(info)){  
	            jtf.setText("");  
	        }  
	    }  
	    @Override  
	    public void focusLost(FocusEvent e) {//失去焦点的时候,判断如果为空,就显示提示文字  
	        String temp = jtf.getText();  
	        if(temp.equals("")){  
	            jtf.setText(info);  
	        }  
	    } 
	}
}