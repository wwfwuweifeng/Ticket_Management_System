package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.concurrent.Exchanger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.Position;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.AbstractListModel;
import java.awt.Font;

public class management extends JFrame {

	private JPanel contentPane;
	private JTextField tFusername;
	private JTextField tFusertele;
	private JTextField tFtotal;
	public  static JTextField tfusername=new JTextField();
	private JTextField tftime;
	private JTextField tfname;
	private JTextField tftelephone;
	public static JTextField tflevel=new JTextField();
	private JTextField tfcredit;
	public  static JTextField tfbalance=new JTextField();
	//public Total_Calander total_Calander = new Total_Calander(1);
	private JTextField tfpassword;
	private JPasswordField passwordField;
	public function f_Function=new function();
	private tool tool = new tool();
	private static FuctionOperation fuctionOperation = new FuctionOperation();
	private static FileOperation fileOperation = new FileOperation();
	public  String happening = "";
	private static Vector<String> vc_user = new Vector<String>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public int select=0;
	public String select_order="";
	
	/**
	 * Launch the application.
	 */
// 	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					management frame = new management();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
 	public static void show(String username){
 		management frame = new management(username);
		frame.setVisible(true);
 	}
	public management(String name) {
		setTitle("\u65C5\u6E38\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(138, 0, 471, 382);
		contentPane.add(cardPanel);
		CardLayout card = new CardLayout();
		cardPanel.setLayout(card);
		
		// ~~~~~~~~~~~账户信息~~~~~~~~~~~
		JPanel card_1 = new JPanel();
		card_1.setToolTipText("");
		card_1.setBackground(new Color(248, 248, 255));
		card_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8D26\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cardPanel.add("0", card_1);
		card_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u7528\u6237\u4FE1\u606F", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 21, 451, 143);
		card_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("\u59D3 \u540D");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(30, 29, 54, 15);
		panel.add(lblNewLabel_7);
		
		tfname = new JTextField();
		tfname.setBackground(new Color(255, 255, 255));
		tfname.setHorizontalAlignment(SwingConstants.CENTER);
		tfname.setEditable(false);
		tfname.setBounds(94, 26, 66, 21);
		panel.add(tfname);
		tfname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u7535 \u8BDD");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(203, 29, 54, 15);
		panel.add(lblNewLabel_8);
		
		tftelephone = new JTextField();
		tftelephone.setBackground(new Color(255, 255, 255));
		tftelephone.setHorizontalAlignment(SwingConstants.CENTER);
		tftelephone.setBounds(282, 26, 96, 21);
		panel.add(tftelephone);
		tftelephone.setColumns(10);
		
		JButton btnchange = new JButton("\u4FDD \u5B58");
		btnchange.setBounds(375, 25, 66, 23);
		panel.add(btnchange);
		
		JLabel lblNewLabel_9 = new JLabel("\u79EF \u5206");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(30, 67, 54, 15);
		panel.add(lblNewLabel_9);
		
		tflevel.setBackground(new Color(255, 255, 255));
		tflevel.setHorizontalAlignment(SwingConstants.CENTER);
		tflevel.setEditable(false);
		tflevel.setBounds(94, 64, 66, 21);
		panel.add(tflevel);
		tflevel.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u4FE1\u7528\u7A0B\u5EA6");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(30, 103, 54, 15);
		panel.add(lblNewLabel_10);
		
		tfcredit = new JTextField();
		tfcredit.setBackground(new Color(255, 255, 255));
		tfcredit.setHorizontalAlignment(SwingConstants.CENTER);
		tfcredit.setEditable(false);
		tfcredit.setBounds(94, 100, 66, 21);
		panel.add(tfcredit);
		tfcredit.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("\u4F59 \u989D");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(203, 67, 54, 15);
		panel.add(lblNewLabel_12);
		tfbalance.setBackground(new Color(255, 255, 255));
		tfbalance.setHorizontalAlignment(SwingConstants.CENTER);
		tfbalance.setEditable(false);
		tfbalance.setBounds(282, 64, 96, 21);
		panel.add(tfbalance);
		tfbalance.setColumns(10);
		
		JButton btnrecharge = new JButton("\u5145 \u503C");
		btnrecharge.setBounds(375, 63, 66, 23);
		panel.add(btnrecharge);
		
		JLabel lblNewLabel_13 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(203, 103, 54, 15);
		panel.add(lblNewLabel_13);
		
		tfpassword = new JPasswordField();
		tfpassword.setBackground(new Color(255, 255, 255));
		tfpassword.setHorizontalAlignment(SwingConstants.CENTER);
		tfpassword.setToolTipText("");
		tfpassword.setBounds(282, 100, 96, 21);
		panel.add(tfpassword);
		tfpassword.setColumns(15);
		
		JButton btnmodity = new JButton("\u4FDD \u5B58");
		btnmodity.setBounds(375, 99, 66, 23);
		panel.add(btnmodity);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8DEF\u7EBF\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(248, 248, 255));
		panel_4.setBounds(10, 174, 451, 198);
		card_1.add(panel_4);
		panel_4.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setToolTipText("");
		textPane.setBounds(10, 22, 431, 166);
		panel_4.add(textPane);
		textPane.setText(get_infor());
		
		// ~~~~~~~~~~~订单填写~~~~~~~~~~~
		JPanel card_2 = new JPanel();
		card_2.setBackground(new Color(248, 248, 255));
		card_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8BA2\u5355\u586B\u5199", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		cardPanel.add("1", card_2);
		card_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u65C5\u6E38\u8DEF\u7EBF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(81, 124, 318, 158);
		card_2.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbBroute = new JComboBox();
		cbBroute.setBackground(new Color(255, 255, 255));
		cbBroute.setBounds(95, 24, 172, 21);
		panel_1.add(cbBroute);
		JComboBox cbBdata = new JComboBox();
		cbBdata.setBackground(new Color(255, 255, 255));
		cbBdata.setBounds(94, 68, 173, 21);
		panel_1.add(cbBdata);
		
		JComboBox cbBtime = new JComboBox();
		cbBtime.setBackground(new Color(255, 255, 255));
		cbBtime.setBounds(95, 107, 67, 21);
		panel_1.add(cbBtime);
		
		JComboBox cbBnumber = new JComboBox();
		cbBnumber.setBackground(new Color(255, 255, 255));
		cbBnumber.setBounds(223, 107, 44, 21);
		panel_1.add(cbBnumber);
		
		JLabel lblNewLabel_3 = new JLabel("\u8DEF \u7EBF");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 27, 54, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u65E5 \u671F");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(30, 68, 54, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u65F6 \u95F4");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(31, 110, 54, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u4EBA \u6570");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(169, 110, 54, 15);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u6E38\u5BA2\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(248, 248, 255));
		panel_2.setBounds(81, 33, 318, 90);
		card_2.add(panel_2);
		panel_2.setLayout(null);
		
		tFusername = new JTextField();
		tFusername.setHorizontalAlignment(SwingConstants.CENTER);
		tFusername.setBounds(94, 22, 90, 21);
		panel_2.add(tFusername);
		tFusername.setColumns(10);
		
		tFusertele = new JTextField();
		tFusertele.setHorizontalAlignment(SwingConstants.CENTER);
		tFusertele.setBounds(94, 59, 90, 21);
		panel_2.add(tFusertele);
		tFusertele.setColumns(10);
		
		tFtotal = new JTextField();
		tFtotal.setHorizontalAlignment(SwingConstants.CENTER);
		tFtotal.setBackground(new Color(255, 255, 255));
		tFtotal.setEditable(false);
		tFtotal.setBounds(227, 59, 66, 21);
		panel_2.add(tFtotal);
		tFtotal.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3 \u540D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 25, 54, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7535 \u8BDD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 62, 54, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u91D1 \u989D");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(229, 25, 64, 15);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u5907\u6CE8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(new Color(248, 248, 255));
		panel_3.setBounds(81, 281, 318, 57);
		card_2.add(panel_3);
		panel_3.setLayout(null);
		
		JEditorPane edPremarks = new JEditorPane();
		edPremarks.setBounds(10, 20, 298, 27);
		panel_3.add(edPremarks);
		
		JButton bntconfirm = new JButton("\u786E \u8BA4");
		bntconfirm.setBounds(356, 349, 93, 23);
		card_2.add(bntconfirm);
		
		// ~~~~~~~~~~~路线查询~~~~~~~~~~~
		JPanel card_3 = new JPanel();
		card_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8DEF\u7EBF\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		card_3.setBackground(new Color(248, 248, 255));
		cardPanel.add("2", card_3);
		card_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u67E5\u627E\u65B9\u5F0F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(44, 26, 257, 127);
		panel_5.setBackground(new Color(248, 248, 255));
		card_3.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel findcard = new JPanel();
		findcard.setBounds(34, 83, 201, 34);
		panel_5.add(findcard);
		findcard.setLayout(new CardLayout(0, 0));
		CardLayout cardbyway = new CardLayout();
		findcard.setLayout(cardbyway);
		
		JPanel timecard = new JPanel();
		findcard.add("0", timecard);
		timecard.setBackground(new Color(248, 248, 255));
		timecard.setBorder(new TitledBorder(null, "\u65F6\u95F4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timecard.setLayout(null);
		
		Total_Calander total_Calander = new Total_Calander(1);
		total_Calander.setBounds(37, 10, 154, 21);
		timecard.add(total_Calander);
		total_Calander.setBackground(new Color(248, 248, 255));
		
		JPanel caddresscard = new JPanel();
		findcard.add("1", caddresscard);
		caddresscard.setBorder(new TitledBorder(null, "\u5730\u70B9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		caddresscard.setBackground(new Color(248, 248, 255));
		caddresscard.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(36, 10, 155, 21);
		caddresscard.add(comboBox_1);
		comboBox_1.setBackground(new Color(248, 248, 255));
		
		//按钮合并
		ButtonGroup btgfindbyway=new ButtonGroup();
		
		JRadioButton rdbfindbytime = new JRadioButton("\u6309\u65F6\u95F4\u67E5\u627E");
		rdbfindbytime.setSelected(true);
		rdbfindbytime.setBounds(34, 25, 97, 23);
		panel_5.add(rdbfindbytime);
		rdbfindbytime.setBackground(new Color(248, 248, 255));
		rdbfindbytime.setHorizontalAlignment(SwingConstants.CENTER);
		btgfindbyway.add(rdbfindbytime);
		
		JRadioButton rdbfindbyaddress = new JRadioButton("\u6309\u5730\u70B9\u67E5\u627E");
		rdbfindbyaddress.setBounds(138, 25, 97, 23);
		panel_5.add(rdbfindbyaddress);
		rdbfindbyaddress.setBackground(new Color(248, 248, 255));
		rdbfindbyaddress.setHorizontalAlignment(SwingConstants.CENTER);
		btgfindbyway.add(rdbfindbyaddress);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(248, 248, 255));
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(44, 163, 397, 209);
		card_3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 377, 133);
		panel_6.add(scrollPane_1);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(list_1);
		
		JButton btnfororder = new JButton("\u53BB\u4E0B\u8BA2\u5355");
		btnfororder.setBounds(294, 176, 93, 23);
		panel_6.add(btnfororder);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("E:\\workplace\\\u8F6F\u5DE51\\logo2.png"));
		lblNewLabel_11.setBounds(311, 26, 134, 127);
		card_3.add(lblNewLabel_11);
		
		// ~~~~~~~~~~~订单查询~~~~~~~~~~~
		JPanel card_4 = new JPanel();
		card_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8BA2\u5355\u670D\u52A1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		card_4.setBackground(new Color(248, 248, 255));
		cardPanel.add("3", card_4);
		card_4.setLayout(null);
		
		JPanel panel_ = new JPanel();
		panel_.setBackground(new Color(248, 248, 255));
		panel_.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_.setBounds(10, 136, 451, 236);
		card_4.add(panel_);
		panel_.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 431, 181);
		panel_.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8BA2\u5355\u64CD\u4F5C", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBackground(new Color(248, 248, 255));
		panel_7.setBounds(10, 26, 284, 100);
		card_4.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnchangeorder = new JButton("\u4FEE\u6539\u8BA2\u5355");
		btnchangeorder.setBackground(new Color(255, 255, 255));
		btnchangeorder.setBounds(166, 26, 93, 23);
		panel_7.add(btnchangeorder);
		
		JButton btndelateorder = new JButton("\u53D6\u6D88\u8BA2\u5355");
		btndelateorder.setBackground(new Color(255, 255, 255));
		btndelateorder.setBounds(166, 59, 93, 23);
		panel_7.add(btndelateorder);
		
		//按钮合并
		ButtonGroup btgfindbyorder=new ButtonGroup();
		
		JRadioButton rdbIncompleteorder = new JRadioButton("\u672A\u5B8C\u6210\u8BA2\u5355");
		rdbIncompleteorder.setBackground(new Color(255, 255, 255));
		rdbIncompleteorder.setHorizontalAlignment(SwingConstants.CENTER);
		rdbIncompleteorder.setBounds(31, 26, 121, 23);
		panel_7.add(rdbIncompleteorder);
		btgfindbyorder.add(rdbIncompleteorder);
		rdbIncompleteorder.setSelected(true);
		JRadioButton rdbcompleteorder = new JRadioButton("\u5DF2\u5B8C\u6210\u8BA2\u5355");
		rdbcompleteorder.setBackground(new Color(255, 255, 255));
		rdbcompleteorder.setHorizontalAlignment(SwingConstants.CENTER);
		rdbcompleteorder.setBounds(31, 59, 121, 23);
		panel_7.add(rdbcompleteorder);
		btgfindbyorder.add(rdbcompleteorder);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("E:\\workplace\\\u8F6F\u5DE51\\logo2.png"));
		lblNewLabel_14.setBounds(323, 26, 138, 116);
		card_4.add(lblNewLabel_14);
		
		
		// ~~~~~~~~~~~修改订单~~~~~~~~~~~
		JPanel card_5 = new JPanel();
		card_5.setBackground(new Color(248, 248, 255));
		cardPanel.add("4", card_5);
		card_5.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u79EF\u5206\u5151\u6362", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setBackground(new Color(248, 248, 255));
		panel_8.setBounds(50, 26, 377, 276);
		card_5.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("\u4FE1\u8A89+10");
		lblNewLabel_15.setBounds(53, 90, 61, 15);
		panel_8.add(lblNewLabel_15);
		
		JButton btnNewButton = new JButton("\u5151 \u6362");
		btnNewButton.setBounds(263, 86, 93, 23);
		panel_8.add(btnNewButton);
		
		JLabel lblNewLabel_17 = new JLabel("\u7528\u6237\u53EF\u51ED\u501F\u5DF2\u7ECF\u83B7\u53D6\u7684\u79EF\u5206\u5728\u8BA1\u5206\u5546\u57CE\u4E2D\u6D88\u8D39");
		lblNewLabel_17.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(20, 30, 293, 30);
		panel_8.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("\u6655\u8F66\u7247");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(53, 136, 54, 15);
		panel_8.add(lblNewLabel_18);
		
		JButton btnNewButton_1 = new JButton("\u5151 \u6362");
		btnNewButton_1.setBounds(263, 132, 93, 23);
		panel_8.add(btnNewButton_1);
		
		JLabel lblNewLabel_20 = new JLabel("\u906E\u9633\u4F1E");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(53, 179, 54, 15);
		panel_8.add(lblNewLabel_20);
		
		JButton btnNewButton_2 = new JButton("\u5151 \u6362");
		btnNewButton_2.setBounds(263, 175, 93, 23);
		panel_8.add(btnNewButton_2);
		
		JLabel label = new JLabel("\u9632\u8D5B\u971C");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(53, 225, 54, 15);
		panel_8.add(label);
		
		JButton button = new JButton("\u5151 \u6362");
		button.setBounds(263, 221, 93, 23);
		panel_8.add(button);
		
		textField = new JTextField();
		textField.setText("50");
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(143, 87, 66, 21);
		panel_8.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("30");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(143, 133, 66, 21);
		panel_8.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("300");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(143, 176, 66, 21);
		panel_8.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("500");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(143, 222, 66, 21);
		panel_8.add(textField_3);
		
		JLabel lblNewLabel_16 = new JLabel("\u5206");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(207, 86, 27, 23);
		panel_8.add(lblNewLabel_16);
		
		JLabel label_1 = new JLabel("\u5206");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(207, 132, 27, 23);
		panel_8.add(label_1);
		
		JLabel label_2 = new JLabel("\u5206");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(207, 175, 27, 23);
		panel_8.add(label_2);
		
		JLabel lblNewLabel_19 = new JLabel("\u5206");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(207, 221, 27, 19);
		panel_8.add(lblNewLabel_19);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(50, 312, 377, 42);
		editorPane.setText("友情提示 ：\r\n         用户在充值时会获得相应的积分");
		card_5.add(editorPane);
		
		// ~~~~~~~~~~~欢迎界面~~~~~~~~~~~
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u767B\u5165\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		welcomePanel.setBackground(new Color(248, 248, 255));
		welcomePanel.setBounds(0, 0, 138, 120);
		contentPane.add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JButton btnsignout = new JButton("\u8FD4\u56DE\u767B\u5165");
		btnsignout.setBackground(Color.WHITE);
		btnsignout.setBounds(24, 87, 93, 23);
		welcomePanel.add(btnsignout);
		
	
		tfusername.setHorizontalAlignment(SwingConstants.CENTER);
		tfusername.setBackground(Color.WHITE);
		tfusername.setEditable(false);
		tfusername.setBounds(24, 23, 93, 21);
		welcomePanel.add(tfusername);
		tfusername.setColumns(10);
		tfusername.setText(name);
		
		tftime = new JTextField();
		tftime.setHorizontalAlignment(SwingConstants.CENTER);
		tftime.setBackground(Color.WHITE);
		tftime.setEditable(false);
		tftime.setBounds(24, 54, 93, 21);
		welcomePanel.add(tftime);
		tftime.setColumns(10);
		
		// ~~~~~~~~~~~功能选择~~~~~~~~~~~
		JPanel FunctionPanel = new JPanel();
		FunctionPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u529F\u80FD\u9009\u62E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FunctionPanel.setBackground(new Color(248, 248, 255));
		FunctionPanel.setBounds(0, 118, 138, 264);
		contentPane.add(FunctionPanel);
		FunctionPanel.setLayout(null);
		
		JButton bntaccountInf = new JButton("\u8D26\u6237\u4FE1\u606F");
		bntaccountInf.setBounds(35, 29, 93, 33);
		FunctionPanel.add(bntaccountInf);
		
		JButton bntFillOrder = new JButton("\u8BA2\u5355\u586B\u5199");
		bntFillOrder.setBounds(35, 70, 93, 33);
		FunctionPanel.add(bntFillOrder);
		
		JButton bntrouteQuery = new JButton("\u8DEF\u7EBF\u67E5\u8BE2");
		bntrouteQuery.setBounds(35, 113, 93, 33);
		FunctionPanel.add(bntrouteQuery);
		
		JButton bntcheckorder = new JButton("\u67E5\u8BE2\u8BA2\u5355");
		bntcheckorder.setBounds(35, 156, 93, 33);
		FunctionPanel.add(bntcheckorder);
		
		JButton bntchangeorder = new JButton("\u6D3B\u52A8\u5546\u57CE");
		bntchangeorder.setBounds(35, 198, 93, 33);
		FunctionPanel.add(bntchangeorder);
		
		//~~~~~~~~~~~~初始化内容~~~~~~~~~~~~~
		//card_1
		tftime.setText(tool.Gettime());
		tFtotal.setText("0");
		edPremarks.setText("无");
		//从账户文件获取账户信息
		Init_card_1();
		//card_2
		cbBroute.setModel(new DefaultComboBoxModel<String>(Init_card_2_route()));
		cbBdata.setModel(new DefaultComboBoxModel<String>(Init_card_2_others(fuctionOperation.Get_Road_Data(cbBroute.getSelectedItem().toString()))));
		cbBtime.setModel(new DefaultComboBoxModel<String>(
				Init_card_2_others(fuctionOperation.Get_Road_Time(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString()))));
		
		cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
				fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
		tFtotal.setText(cal_amount(cbBroute.getSelectedItem().toString(), cbBnumber.getSelectedItem().toString()));
		//card_3
		f_Function.Remove_Dead_Road();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(Init_card_2_route()));
		
		JButton btnfind = new JButton("\u67E5 \u627E");
		btnfind.setBounds(148, 54, 83, 23);
		panel_5.add(btnfind);
		//~~~~~~~~~~~~ 监听事件~~~~~~~~~~~~~~
		btndelateorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消订单
				deldete_order(list.getSelectedValue());
				//退还金额
				save(tfusername.getText(), fuctionOperation.GetInformation((String)list.getSelectedValue(), 7), 6, 7);
				//信用度相应的公式操作
				credit_delate(2);
				list.setListData(show_order(0));
				JOptionPane.showMessageDialog(null, "您的订单已取消", "友情提示", JOptionPane.INFORMATION_MESSAGE);
			}

			
		});
		btnchangeorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//修改订单， 金额多退少补
				select_order="";
				change_order(list.getSelectedValue());
		//		credit_delate(1);
				select=1;
			}

			private void change_order(Object selectedValue) {
				// TODO Auto-generated method stub
				card.show(cardPanel, "1");
				tFusername.setText(fuctionOperation.GetInformation((String)list.getSelectedValue(), 4));
				tFusertele.setText(fuctionOperation.GetInformation((String)list.getSelectedValue(), 5));
				select_order=fuctionOperation.GetInformation((String) list.getSelectedValue(),10);
			}
		});
		btnfororder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//去下订单
				select=0;
				select_order="";
				cbBroute.setModel(new DefaultComboBoxModel<String>(Init_card_2_route()));
				cbBdata.setModel(new DefaultComboBoxModel<String>(Init_card_2_others(fuctionOperation.Get_Road_Data(cbBroute.getSelectedItem().toString()))));
				cbBtime.setModel(new DefaultComboBoxModel<String>(
						Init_card_2_others(fuctionOperation.Get_Road_Time(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString()))));
				cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
						fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
				tFtotal.setText(cal_amount(cbBroute.getSelectedItem().toString(), cbBnumber.getSelectedItem().toString()));
				tFusername.setText("");
				tFusertele.setText("");
				card.show(cardPanel, "1");
//				String single_road=(String) list_1.getSelectedValue();
//				String select_road=f_Function.Get_Text(single_road, 3)+"-"+f_Function.Get_Text(single_road, 4);
//				String[] road=Init_card_2_others(s_string)
//		//		road=f_Function.Get_Road();
//				cbBdata.removeAllItems();
//				cbBtime.removeAllItems();
//				cbBnumber.removeAllItems();
//				cbBroute.removeAllItems();
//				for(int i=0;i<road.size();i++){
//					cbBroute.addItem(road.get(i)+"-"+);
//				}
//				cbBroute.setSelectedItem(select_road);
//				String data_1=f_Function.Get_Road_Data(select_road);
//				String[] data_2=data_1.split("-");
//				for(int i=0;i<data_2.length;i++){
//					cbBdata.addItem(data_2[i]);
//				}
//				String select_data=f_Function.Get_Text(single_road, 1);
//				cbBdata.setSelectedItem(select_data);
//				String[] time_1=f_Function.Get_Road_Time(select_road, select_data).split("-");
//				for(int i=0;i<time_1.length;i++){
//					cbBtime.addItem(time_1[i]);
//				}
//				String select_time=f_Function.Get_Text(single_road, 2);
//				cbBtime.setSelectedItem(select_time);
//				int num=f_Function.Get_Road_num(single_road);
//				for(int i=1;i<num;i++){
//					cbBnumber.addItem(i);
//				}
			}
		});
		//路线查询
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbfindbytime.isSelected()){
					list_1.setListData(compare(total_Calander.tx_data.getText(),0));
				}
				else{
					list_1.setListData(compare(comboBox_1.getSelectedItem().toString(),1));
				}
			}

			private Vector<String> compare(String text,int choice) {
				// TODO Auto-generated method stub
				vc_user.clear();
				vc_user = fileOperation.read("road_information");
				Vector<String> v_result = new Vector<String>();
				for(int i=0;i<vc_user.size();i++){
					switch (choice) {
					case 0:
						if(text.equals(fuctionOperation.GetInformation(vc_user.get(i), 0))){
							v_result.add(vc_user.get(i));
						}
						break;
					case 1:
						if(text.equals(fuctionOperation.GetInformation(vc_user.get(i), 2)+"-"+
								fuctionOperation.GetInformation(vc_user.get(i), 3)+"-"+fuctionOperation.GetInformation(vc_user.get(i), 4))){
							v_result.add(vc_user.get(i));
						}
						break;
					default:
						break;
					}
				}
				if(v_result.size()==0){
					v_result.add("没有找到相应的路线");
				}
				return v_result;
			}
		});
		cbBroute.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//card_2 ~~~~~路线更改触发事件
				if(e.getStateChange() == ItemEvent.SELECTED);
				cbBdata.setModel(new DefaultComboBoxModel<String>(Init_card_2_others(fuctionOperation.Get_Road_Data(cbBroute.getSelectedItem().toString()))));
				cbBtime.setModel(new DefaultComboBoxModel<String>(
						Init_card_2_others(fuctionOperation.Get_Road_Time(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString()))));
				cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
						fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
				tFtotal.setText(cal_amount(cbBroute.getSelectedItem().toString(), cbBnumber.getSelectedItem().toString()));
			}
		});
		cbBdata.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//card_2 ~~~~日期更改触发事件
				if(e.getStateChange() == ItemEvent.SELECTED);
				cbBtime.setModel(new DefaultComboBoxModel<String>(
						Init_card_2_others(fuctionOperation.Get_Road_Time(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString()))));
				cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
						fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
			}
		});
		cbBtime.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//card_2 ~~~~日期更改触发事件
				if(e.getStateChange() == ItemEvent.SELECTED);
				cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
						fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
			}
		});
		cbBnumber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//card_2 ~~~~~人数更改触发事件
				if(e.getStateChange() == ItemEvent.SELECTED);
				tFtotal.setText(cal_amount(cbBroute.getSelectedItem().toString(), cbBnumber.getSelectedItem().toString()));
			}
		});
		bntconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//订单确认触发事件
				//~~~~~~~~~~可以增加对信息的验证~~~~~~~~~~~
				if(Double.valueOf(tfcredit.getText())<(double)30){
					JOptionPane.showMessageDialog(null, "您的信用程度太低，不可下订单", "友情提示", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(tFusername.getText().equals("") || tFusertele.getText().equals("")){
						JOptionPane.showMessageDialog(null, "我们需要您的完整信息，请您确认下信息是否填写完整", "友情提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(Double.parseDouble(tfbalance.getText())<Double.parseDouble(tFtotal.getText())){
						JOptionPane.showMessageDialog(null, "亲，余额不足请充值后再下订单", "友情提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						int option = JOptionPane.showConfirmDialog(null,showorder(),"请确认订单信息", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
						switch (option) {
						case JOptionPane.YES_NO_OPTION:{
							//订单完成写入文件、写入总文件
							String s_information = deal_information();
							if(select==1){
							select=0;
							fileOperation.write_singel_ticket(s_information, tfusername.getText(),2 ,0);
							int k=f_Function.Get_Road_num(s_information);
							if(k!=-1){
								vc_user.clear();
								vc_user=fileOperation.read("ticket");
							//	vc_user.remove(k);
							}
							}else{
							fileOperation.write_singel_ticket(s_information, tfusername.getText(), 0,0);
							}
						//	writetoaccount(s_information,tfusername.getText());
						//	int p = fuctionOperation.find_position(s_information, 11);
						//	s_information = s_information.substring(0, p);
							f_Function.Sort_Ticket(s_information);
							f_Function.Updata_road();
							cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
									fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
							tFusername.setText("");
							tFusertele.setText("");
							String balance=Double.toString(-Double.parseDouble(tFtotal.getText()));
							save(tfusername.getText(), balance, 6, 7);
							break;
						}
						default:
							break;
						}
					}
				}
				
			}
			

//			private void updata_number(String s_information) {
//				Vector<String> vc_result = new Vector<String>();
//				Vector<String> vc;
//				vc = fileOperation.read("road_information");
//				String[] s_1 = s_information.split("-");
//				for(int i=0;i<vc.size();i++){
//					String[] s_2 = vc.get(i).split("-");
//					if(s_1[0].equals(s_2[0])&&s_1[1].equals(s_2[1])&&s_1[2].equals(s_2[2])&&s_1[3].equals(s_2[3])){
//						vc.insertElementAt(fuctionOperation.changeinformation(vc.get(i), Integer.toString(Integer.valueOf(s_2[7])-Integer.valueOf(s_1[6])), 7, 8),i);
//						vc.remove(i+1);
//						vc.insertElementAt(fuctionOperation.changeinformation(vc.get(i),Integer.valueOf(s_2[6])+Integer.valueOf(s_1[6])+"", 6, 8),i);
//						System.out.println(s_1[6]+"    "+ s_2[6]);
//						System.out.println(Integer.valueOf(s_2[6])+Integer.valueOf(s_1[6]));
//						vc.remove(i+1);
//						vc_result.addElement(vc.get(i));
//					}
//					else{
//						vc_result.addElement(vc.get(i));
//					}
//				}
//				fileOperation.write(vc_result, "road_information");
//			}
			
			private void writetoaccount(String s_information, String file_name) {
				vc_user.clear();
				vc_user = fileOperation.read(file_name);
				vc_user.add(1,s_information);
				fileOperation.write(vc_user, file_name);
			}

			private String deal_information() {
				// TODO Auto-generated method stub
				String s_result="" ;
				String s_ordernum = "";
				Vector<String> v_order =fileOperation.read("order");
				if(v_order.size()==0){
					s_ordernum = "wh"+"1";
					v_order.add("wh1");
					fileOperation.write(v_order, "order");
				}
				else{
					if(select==1){
					s_ordernum=select_order;
					credit_delate(1);
					deldete_order(list.getSelectedValue());
					save(tfusername.getText(), fuctionOperation.GetInformation((String)list.getSelectedValue(), 7), 6, 7);
					}else{
					s_ordernum = "wh"+(Integer.parseInt(v_order.get(0).substring(2))+1);
					v_order.remove(0);
					v_order.add(s_ordernum);
					System.out.println(v_order.get(0));
					fileOperation.write(v_order, "order");
					}
				}
				String[] s_address = cbBroute.getSelectedItem().toString().split("-");
				s_result = cbBdata.getSelectedItem().toString()+"-"+cbBtime.getSelectedItem().toString()+"-"+s_address[0]+"-"+s_address[1]
						+"-"+tFusername.getText()+"-"+tFusertele.getText()+"-"+cbBnumber.getSelectedItem().toString()+"-"+tFtotal.getText()
						+"-"+edPremarks.getText()+"-"+tfusername.getText()+"-"+s_ordernum+"-";
				return s_result;
			}

			private String showorder() {
				String s_result;
				s_result = "路线 ："+cbBroute.getSelectedItem().toString() +"\r\n" +"日期 ：" +cbBdata.getSelectedItem().toString() +"\r\n"
						+"时间 ：" +cbBtime.getSelectedItem().toString() + "      人数  ： " +cbBnumber.getSelectedItem().toString();
				return s_result;
			}

		});
		btnmodity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//密码更改
				save(tfusername.getText(),tfpassword.getText() ,3 , 7);
			}
		});
		btnrecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//余额充值
				Add_Money.main(null);
			}
		});
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//更改电话
				save(tfusername.getText(),tftelephone.getText() ,2 , 7);
			}
		});
		btnsignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//返回登入界面
				Login.main(null);
				dispose();
			}
		});
		rdbIncompleteorder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//按未完成订单
				if(rdbIncompleteorder.isSelected()){
					list.setListData(show_order(0));
					list.setEnabled(true);
				}
				else if(rdbcompleteorder.isSelected()){
					list.setListData(show_order(1));
					list.setEnabled(false);
				}
			}
		});
		rdbcompleteorder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//已完成订单
				if(rdbIncompleteorder.isSelected()){
					list.setListData(show_order(0));
					list.setEnabled(true);
				}
				else if(rdbcompleteorder.isSelected()){
					list.setListData(show_order(1));
					list.setEnabled(false);
				}
			}
		});
		rdbfindbyaddress.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//按路线查找监听
				if(rdbfindbytime.isSelected()){
					cardbyway.show(findcard, "0");
				}
				else if(rdbfindbyaddress.isSelected()){
					cardbyway.show(findcard, "1");
				}
			}
		});
		rdbfindbytime.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//按时间查找监听
				if(rdbfindbytime.isSelected()){
					cardbyway.show(findcard, "0");
				}
				else if(rdbfindbyaddress.isSelected()){
					cardbyway.show(findcard, "1");
				}
			}
		});
		// 按钮触发卡片的变化
		bntaccountInf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "0");
				Init_card_1();
			}
		});
		
		bntFillOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "1");
				f_Function.Remove_Dead_Road();
				cbBroute.setModel(new DefaultComboBoxModel<String>(Init_card_2_route()));
				cbBdata.setModel(new DefaultComboBoxModel<String>(Init_card_2_others(fuctionOperation.Get_Road_Data(cbBroute.getSelectedItem().toString()))));
				cbBtime.setModel(new DefaultComboBoxModel<String>(
						Init_card_2_others(fuctionOperation.Get_Road_Time(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString()))));
				cbBnumber.setModel(new DefaultComboBoxModel<String>(Init_card_2_time(
						fuctionOperation.Get_Road_num(road_information(cbBroute.getSelectedItem().toString(),cbBdata.getSelectedItem().toString(),cbBtime.getSelectedItem().toString())))));
				tFtotal.setText(cal_amount(cbBroute.getSelectedItem().toString(), cbBnumber.getSelectedItem().toString()));
				tFusername.setText("");
				tFusertele.setText("");
				Init_card_1();
			}
		});
		
		bntrouteQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "2");
				f_Function.Remove_Dead_Road();
				comboBox_1.setModel(new DefaultComboBoxModel<String>(Init_card_2_route()));
			}
		});
		
		bntcheckorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "3");
				list.setListData(show_order(0));
				f_Function.Updata_User_Information(tfusername.getText());
			}
		});
		
		bntchangeorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "4");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//积分兑换
				Exchanger(textField.getText());
				save(tfusername.getText(), "10", 5, 7);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Exchanger(textField_1.getText());
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Exchanger(textField_2.getText());
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exchanger(textField_3.getText());
			}
		});
	}
	
	
	public void credit_delate(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case 1:
			save(tfusername.getText(), "-10", 5, 7);
			break;
		case 2:
			save(tfusername.getText(), "-20", 5, 7);
			break;
		default:
			break;
		}
	}

	public void Exchanger(String str) {
		// TODO Auto-generated method stub
		if((Double.valueOf(tflevel.getText())-Double.valueOf(str)>= 0)){
			save(tfusername.getText(), "-"+str, 4, 7);
			JOptionPane.showMessageDialog(null, "您已经兑换成功", "友情提示", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "积分余额不足", "友情提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private String road_information(String string, String string2, String string3) {
		String s_result;
		s_result = string2+"-"+string3+"-"+string;
		return s_result;
	}

	public void Init_card_1() {
		vc_user.clear();
		vc_user = fileOperation.read(tfusername.getText());
		tfname.setText(fuctionOperation.GetInformation(vc_user.get(0), 1));
		tftelephone.setText(fuctionOperation.GetInformation(vc_user.get(0), 2));
		tfpassword.setText(fuctionOperation.GetInformation(vc_user.get(0), 3));
		tflevel.setText(fuctionOperation.GetInformation(vc_user.get(0), 4));
		tfcredit.setText(fuctionOperation.GetInformation(vc_user.get(0), 5));
		tfbalance.setText(fuctionOperation.GetInformation(vc_user.get(0), 6));
		
	}
	
	public String[] Init_card_2_route(){
		Vector<String> s_result = new Vector<String>();
		s_result = fuctionOperation.Get_Road();
		String[] s_reset = new String[s_result.size()];
		for(int i=0; i<s_result.size();i++){
			s_reset[i] = s_result.get(i);
		}
		return s_reset ;
	}
	public Vector<String> show_order(int i) {
		vc_user.clear();
		vc_user = fileOperation.read(tfusername.getText());
		Vector<String> v_result = new Vector<String>();
		switch (i) {
		case 0:
			for(int j=1;j<vc_user.size();j++){
				if(!vc_user.get(j).equals("=====")){
					v_result.add(vc_user.get(j));
				}
				else{
					break;
				}
			}
			if(v_result.size()==0){
				v_result.add("没有未完成订单");
			}
			break;
		case 1:
			int j =1;
			while(!vc_user.get(j).equals("=====")){
				j++;
			}
			for(j=j+1;j<vc_user.size();j++){
				v_result.add(vc_user.get(j));
			}
			if(v_result.size()==0){
				v_result.add("没有已完成订单");
			}
			break;
		default:
			break;
		}
		return v_result;
	}
	
	public String[] Init_card_2_others(String s_string){
		String[] s_result = s_string.split("-");
		return s_result;
	}
	
	public String[] Init_card_2_time(int number){
		String[] s_result = new String[number];
		for(int i=1;i<=number ; i++){
			s_result[i-1] = i +"";
		}
		return s_result;
	}

	public static void save(String string ,String s_change , int position , int length){
		vc_user.clear();
		vc_user = fileOperation.read(string);
		vc_user.add(0, fuctionOperation.changeinformation(vc_user.get(0), s_change, position , length));
		vc_user.remove(1);
		fileOperation.write(vc_user, tfusername.getText());
	}
	
	public String cal_amount(String route , String number){
		String s_result = "";
		String[] s_deal = route.split("-");
		s_result = String.valueOf(Double.valueOf(s_deal[2]) * Double.valueOf(number));
		return s_result;
	}
	
	public void reset(String str){
		tfbalance.setText(str);
	}
	public void deldete_order(Object selectedValue) {
		// TODO Auto-generated method stub
		//用户文件
		vc_user.clear();
		vc_user = fileOperation.read(tfusername.getText());
		int i=0;
		while(i<vc_user.size()){
			if(vc_user.get(i).equals(selectedValue)){
				break;
			}
			i++;
		}
		vc_user.add(fuctionOperation.changeinformation(vc_user.get(i), "已退票", 11, 12));
		vc_user.remove(i);
		fileOperation.write(vc_user, tfusername.getText());
		//ticket
		vc_user.clear();
		vc_user = fileOperation.read("ticket");
		i = 0;
		while(i<vc_user.size()){
			if(selectedValue.equals(vc_user.get(i)+"改签-") || selectedValue.equals(vc_user.get(i))){
				vc_user.remove(i);
				break;
			}
			i++;
		}
		fileOperation.write(vc_user, "ticket");
		f_Function.Updata_road();
	}
	public String get_infor(){
		vc_user.clear();
		vc_user = fileOperation.read("luxiantuijian");
		String s_result = "" ;
		for(int i=0;i<vc_user.size();i++){
			s_result = s_result +vc_user.get(i)+"\r\n";
		}
		return s_result;
	}
}
