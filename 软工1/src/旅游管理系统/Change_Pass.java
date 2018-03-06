package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Change_Pass extends JFrame {

	private JPanel contentPane;
	private JTextField tx_account;
	private JTextField tx_name;
	private JTextField tx_pass;
	private JTextField tx_pass_2;
	public function fct=new function();
	public JLabel lb_remind = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Pass frame = new Change_Pass();
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
	public Change_Pass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout card=new CardLayout();
		contentPane.setLayout(card);
		
		JPanel panel_start = new JPanel();
		panel_start.setBackground(new Color(248, 248, 255));
		contentPane.add(panel_start, "name_259706478998841");
		panel_start.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(19, 26, 73, 26);
		panel_start.add(lblNewLabel);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(19, 62, 73, 26);
		panel_start.add(label);
		
		tx_account = new JTextField();
		tx_account.setHorizontalAlignment(SwingConstants.CENTER);
		tx_account.setBounds(89, 27, 112, 26);
		panel_start.add(tx_account);
		tx_account.setColumns(10);
		
		tx_name = new JTextField();
		tx_name.setHorizontalAlignment(SwingConstants.CENTER);
		tx_name.setColumns(10);
		tx_name.setBounds(89, 62, 112, 26);
		panel_start.add(tx_name);
		
	
		lb_remind.setFont(new Font("宋体", Font.PLAIN, 13));
		lb_remind.setHorizontalAlignment(SwingConstants.CENTER);
		lb_remind.setBounds(46, 167, 231, 26);
		panel_start.add(lb_remind);
		
		JLabel lblNewLabel_2 = new JLabel("\uFF08\u6CE8\u518C\u65F6\u586B\u5199\u7684\uFF09");
		lblNewLabel_2.setBounds(211, 65, 110, 20);
		panel_start.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(19, 98, 73, 26);
		panel_start.add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(19, 134, 73, 26);
		panel_start.add(label_2);
		
		tx_pass = new JPasswordField();
		tx_pass.setHorizontalAlignment(SwingConstants.CENTER);
		tx_pass.setColumns(10);
		tx_pass.setBounds(89, 98, 112, 26);
		panel_start.add(tx_pass);
		
		tx_pass_2 = new JPasswordField();
		tx_pass_2.setHorizontalAlignment(SwingConstants.CENTER);
		tx_pass_2.setColumns(10);
		tx_pass_2.setBounds(89, 134, 112, 26);
		panel_start.add(tx_pass_2);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		
		btnNewButton.setBounds(66, 203, 73, 26);
		panel_start.add(btnNewButton);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login.main(null);
			}
		});
		button.setBounds(172, 203, 73, 26);
		panel_start.add(button);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				lb_remind.setText("");
				String s=tx_account.getText()+"-"+tx_name.getText()+"-"+tx_pass.getText()+"-"+tx_pass_2.getText()+"-";
				int n=fct.Judge_account(s);
				if(n==1){
					lb_remind.setText("请将信息填写完整");
				}else if(n==2){
					lb_remind.setText("该账号不存在");
					
				}else if(n==3){
					lb_remind.setText("账号对应姓名错误");
				}else if(n==4){
					lb_remind.setText("两次密码不一致");
				}else{
					fct.Change_Pass(s);
					dispose();
					Login.main(null);
				}
			}
		});
	}
}
