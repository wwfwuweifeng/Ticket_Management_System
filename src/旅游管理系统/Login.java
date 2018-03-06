package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tx_name;
	private JPasswordField tx_passdword;
	private ButtonGroup login_btg=new ButtonGroup();
	private Vector<String> file_getname=new Vector<String>();
	private function FCT=new function();
	public FileOperation file_operation=new FileOperation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		setTitle("旅游管理系统");
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		
		JButton bt_login = new JButton("\u767B\u5F55");
		bt_login.setBackground(SystemColor.inactiveCaptionBorder);
		bt_login.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		bt_login.setBounds(102, 183, 97, 23);
		contentPane.add(bt_login);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u767B\u5F55");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(135, 10, 134, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(47, 52, 65, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(47, 96, 65, 34);
		contentPane.add(label);
		
		tx_name = new JTextField();
		tx_name.setBounds(125, 54, 172, 34);
		contentPane.add(tx_name);
	//	contentPane.add(test);
		tx_name.setColumns(10);
		
		tx_passdword = new JPasswordField();
		tx_passdword.setBounds(125, 98, 172, 34);
		contentPane.add(tx_passdword);
		
		JButton bt_register = new JButton("\u6CE8\u518C");
		bt_register.setBackground(SystemColor.inactiveCaptionBorder);
		bt_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rigester.main(null);
			}
		});
		bt_register.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		bt_register.setBounds(227, 183, 97, 23);
		contentPane.add(bt_register);
		
		JRadioButton login_rbt_nomal = new JRadioButton("\u666E\u901A\u7528\u6237");
		login_rbt_nomal.setBackground(new Color(245, 255, 250));
		login_rbt_nomal.setSelected(true);
		login_rbt_nomal.setFont(new Font("宋体", Font.PLAIN, 14));
		login_rbt_nomal.setBounds(97, 145, 121, 23);
		contentPane.add(login_rbt_nomal);
		
		JRadioButton login_rbt_manager = new JRadioButton("\u7BA1\u7406\u5458");
		login_rbt_manager.setBackground(new Color(245, 255, 250));
		login_rbt_manager.setFont(new Font("宋体", Font.PLAIN, 14));
		login_rbt_manager.setBounds(218, 145, 121, 23);
		contentPane.add(login_rbt_manager);
		login_btg.add(login_rbt_manager);
		login_btg.add(login_rbt_nomal);
		
		JLabel lblNewLabel_4 = new JLabel("\u7248\u672C\u53F7\uFF1A1.1.1");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(214, 246, 182, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lb_login_remind = new JLabel("");
		lb_login_remind.setHorizontalAlignment(SwingConstants.CENTER);
		lb_login_remind.setBounds(66, 216, 302, 19);
		contentPane.add(lb_login_remind);
		
		JButton btnNewButton = new JButton("\u5FD8\u4E86\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Change_Pass.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.setBounds(303, 109, 93, 23);
		contentPane.add(btnNewButton);
		file_operation.read("order");
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//有问题，要改
				file_getname.clear();
				file_getname=file_operation.read("username");
				Vector<String> file_getroad=new Vector<String>();
				String rbt_select=null;
				String tx_get;
				if(login_rbt_nomal.isSelected()){
					rbt_select="普通用户";
				}else if(login_rbt_manager.isSelected()){
					rbt_select="管理员";
				}
				tx_get=tx_name.getText()+"-"+tx_passdword.getText()+"-"+rbt_select+"-";
				String user_information=FCT.Login_Judge(file_getname, tx_get);
				if(!user_information.equals("no")){
					if(login_rbt_nomal.isSelected()){
						//调用普通用户程序
						file_getroad.clear();
						file_getroad=file_operation.read("road_information");
						if(file_getroad.size()==0){
							lb_login_remind.setText("目前没有可预订路线，暂不对外开放");
							
						}else{
							NormalUer.show(tx_name.getText());
							dispose();
						}
					}else if(login_rbt_manager.isSelected()){
						
						manager.show(user_information);
						dispose();
					}
				}else{
					lb_login_remind.setText("用户名或密码或用户类别错误！请重新输入");
				}
			
			}
		});
	}
}
