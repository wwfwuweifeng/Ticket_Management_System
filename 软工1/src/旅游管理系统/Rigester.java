package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Rigester extends JFrame {

	private JPanel contentPane;
	private JTextField tx_name;
	private JPasswordField tx_passd;
	private JPasswordField tx_passd_again;
	public Vector<String> file_getname=new Vector<String>();
	public function FCT=new function();
	public FileOperation file_operation=new FileOperation();
	private JTextField tx_code;
	private JTextField tx_tel;
	private JTextField tx_realyname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rigester frame = new Rigester();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rigester() {
		setBackground(Color.WHITE);
		ButtonGroup regiser_btg=new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		setTitle("用户注册");
		JLabel lblNewLabel = new JLabel("\u4FE1\u606F\u586B\u5199");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 10, 179, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
	
		btnNewButton.setBounds(87, 300, 100, 29);
		contentPane.add(btnNewButton);
		
		tx_name = new JTextField();
		tx_name.setBounds(126, 122, 179, 23);
		contentPane.add(tx_name);
		tx_name.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(53, 148, 66, 29);
		contentPane.add(label);
		
		tx_passd = new JPasswordField();
		tx_passd.setBounds(126, 152, 179, 23);
		contentPane.add(tx_passd);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(31, 184, 88, 23);
		contentPane.add(label_1);
		
		tx_passd_again = new JPasswordField();
		tx_passd_again.setBounds(126, 184, 179, 23);
		contentPane.add(tx_passd_again);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBackground(new Color(245, 255, 250));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 14));
		button.setBounds(232, 300, 100, 29);
		contentPane.add(button);
		
		JRadioButton register_rbt_nomal = new JRadioButton("\u666E\u901A\u7528\u6237");
		register_rbt_nomal.setBackground(Color.WHITE);
		register_rbt_nomal.setFont(new Font("宋体", Font.PLAIN, 14));
		
		register_rbt_nomal.setSelected(true);
		register_rbt_nomal.setBounds(101, 246, 100, 23);
		
	////////////////////////////////////////////////////////////////
		contentPane.add(register_rbt_nomal);
		
		JRadioButton register_rbt_manager = new JRadioButton("\u7BA1\u7406\u5458");
		register_rbt_manager.setBackground(Color.WHITE);
		register_rbt_manager.setFont(new Font("宋体", Font.PLAIN, 14));
		register_rbt_manager.setBounds(232, 246, 121, 23);
		contentPane.add(register_rbt_manager);
		regiser_btg.add(register_rbt_nomal);
		regiser_btg.add(register_rbt_manager);
		
		JLabel lb_remind = new JLabel("");
		lb_remind.setFont(new Font("宋体", Font.PLAIN, 14));
		lb_remind.setHorizontalAlignment(SwingConstants.CENTER);
		lb_remind.setBounds(10, 275, 378, 23);
		contentPane.add(lb_remind);
		
		JLabel label_2 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(51, 217, 88, 23);
		contentPane.add(label_2);
		
		JButton bt_refresh = new JButton("\uFF08\u70B9\u51FB\u5237\u65B0\uFF09");
		
		bt_refresh.setFont(new Font("黑体", Font.PLAIN, 12));
		bt_refresh.setBackground(Color.WHITE);
		bt_refresh.setBounds(266, 217, 107, 23);
		contentPane.add(bt_refresh);
		
		JLabel lb_code = new JLabel("");
		lb_code.setFont(new Font("方正舒体", Font.ITALIC, 18));
		lb_code.setBounds(211, 210, 88, 30);
		contentPane.add(lb_code);
		lb_code.setText(FCT.Get_Random());
		
		tx_code = new JTextField();
		tx_code.setBounds(126, 217, 75, 23);
		contentPane.add(tx_code);
		tx_code.setColumns(10);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(31, 92, 88, 23);
		contentPane.add(label_4);
		
		tx_tel = new JTextField();
		tx_tel.setColumns(10);
		tx_tel.setBounds(126, 92, 179, 23);
		contentPane.add(tx_tel);
		
		JLabel label_3 = new JLabel("\u8D26\u53F7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(53, 119, 66, 29);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("\u59D3\u540D\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(53, 53, 66, 29);
		contentPane.add(label_5);
		
		tx_realyname = new JTextField();
		tx_realyname.setColumns(10);
		tx_realyname.setBounds(126, 59, 179, 23);
		contentPane.add(tx_realyname);
		
//		JLabel lblNewLabel_1 = new JLabel("\u6CE8\u518C\u7528\u6237\u7C7B\u578B\uFF1A\u666E\u901A\u7528\u6237");
//		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 13));
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setBounds(87, 250, 234, 23);
//		contentPane.add(lblNewLabel_1);
//		
		//注册按钮的点击事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rbt_select="";
				String tx_get;
				file_getname.clear();
				file_getname=file_operation.read("username");
				if(register_rbt_nomal.isSelected()){
					rbt_select="普通用户";
				}else if(register_rbt_manager.isSelected()){
					rbt_select="管理员";
				}
		//		rbt_select="普通用户";
				tx_get=tx_name.getText()+"-"+tx_realyname.getText()+"-"+tx_tel.getText()+"-"+tx_passd.getText()+"-"+tx_passd_again.getText()+"-";
				int select=FCT.Register_Submit(file_getname, tx_get);
				switch (select) {
				case -1:
					lb_remind.setText("该账号已经被注册！");
					break;
				case 0:
					lb_remind.setText("两次输入密码不一致！");
					break;
				case 2:
					lb_remind.setText("请将未填写资料填写完整，再点击注册！");
					break;
	//此处需要完善			
				case 1:
					if(tx_code.getText().equals(lb_code.getText())){
						Vector<String> new_user=new Vector<String>();
						file_getname.add(tx_name.getText()+"-"+tx_passd.getText()+"-"+rbt_select+"-"+tx_realyname.getText()+"-"+tx_tel.getText()+"-");
						file_operation.write(file_getname,"username");
							String new_user_tx=tx_name.getText()+"-"+tx_realyname.getText()+"-"+tx_tel.getText()+"-"+tx_passd.getText()+"-0-100-0-";
							new_user.add(new_user_tx);
							new_user.add("=====");
							file_operation.write(new_user,tx_name.getText());
						dispose();
						Login.main(null);
					}else{
						System.out.println(tx_code.getText());
						System.out.println(lb_code.getText());
						lb_remind.setText("验证码输入错误！");
						lb_code.setText(FCT.Get_Random());
					}
					break;
				default:
					break;
				}
			}
		});
		bt_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lb_code.setText(FCT.Get_Random());
				lb_remind.setText("");
			}
		});
	}

}
