package 旅游管理系统;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Add_Money extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField tx_add_money;
	public JLabel lb_remind = new JLabel("");
	public FuctionOperation fct=new FuctionOperation();
//	public management travel=new management(null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Add_Money dialog = new Add_Money();
			dialog.setUndecorated(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setAlwaysOnTop(true);
			dialog.setLocation(management.tfbalance.getLocationOnScreen().x,management.tfbalance.getLocationOnScreen().y+22);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Add_Money() {
		setBounds(100, 100, 259, 149);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("充值");
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u91D1\u989D\uFF1A");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 20, 75, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			tx_add_money = new JTextField();
			tx_add_money.setBounds(67, 21, 107, 24);
			contentPanel.add(tx_add_money);
			tx_add_money.setColumns(10);
		}
		{
			JLabel label = new JLabel("\u5143");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("宋体", Font.PLAIN, 14));
			label.setBounds(170, 20, 42, 24);
			contentPanel.add(label);
		}
		{
			JButton btnNewButton = new JButton("\u786E\u5B9A");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String get_tx=tx_add_money.getText();
					if(get_tx.equals("")){
					lb_remind.setText("请输入充值金额");
					}else{
						management.save(management.tfusername.getText(), tx_add_money.getText(), 6 , 7);
						management.save(management.tfusername.getText(), tx_add_money.getText(), 4 , 7);
						double money_1=Double.parseDouble(get_tx);
						double money_2=Double.parseDouble(management.tfbalance.getText());
						double leve=Double.parseDouble(management.tflevel.getText());
						management.tflevel.setText((leve+money_1)+"");
						management.tfbalance.setText((money_1+money_2)+"");
						dispose();
					}
				}
			});
			btnNewButton.setBounds(10, 80, 93, 24);
			contentPanel.add(btnNewButton);
		}
		{
			JButton button = new JButton("\u53D6\u6D88");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setBounds(113, 80, 93, 24);
			contentPanel.add(button);
		}
		{
			
			lb_remind.setHorizontalAlignment(SwingConstants.CENTER);
			lb_remind.setBounds(20, 54, 183, 18);
			contentPanel.add(lb_remind);
		}
		
		
	}

}
