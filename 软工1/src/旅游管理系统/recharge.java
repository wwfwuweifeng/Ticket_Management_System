package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class recharge extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private management travel = new management(null);
	private FuctionOperation fuctionOperation = new FuctionOperation();
	private FileOperation fileOperation = new FileOperation();
	private Vector<String> vc_user = new Vector<String>();
		
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recharge frame = new recharge();
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
	public recharge() {
		setTitle("\u5145\u503C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 198);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5145\u503C\u91D1\u989D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 22, 93, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(96, 68, 128, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		System.out.println("==============in");
		JButton btnNewButton = new JButton("\u786E \u5B9A");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(textField.getText().equals("")){
//					JOptionPane.showMessageDialog(null, "请输入要充值的金额", "友情提示", JOptionPane.INFORMATION_MESSAGE);
//				}
//				else{
////					travel.save(travel.tfusername.getText(), textField.getText(), 6 , 7);
////					travel.save(travel.tfusername.getText(), textField.getText(), 4 , 7);
//					dispose();
//				}
//			}
//		});
		btnNewButton.setBounds(198, 126, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u5143");
		lblNewLabel_1.setBounds(234, 68, 32, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u53D6 \u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(95, 126, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
