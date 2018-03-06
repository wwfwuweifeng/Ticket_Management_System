package ���ι���ϵͳ;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComboBoxUI;
import javax.tools.Diagnostic;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class Total_Calander extends JPanel {
	
	public JTextField tx_data=new JTextField();
	public JPanel paCalendar;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JLabel[] lbls = new JLabel[7];
	private JToggleButton[] toggles = new JToggleButton[42];
	private Border border;
	private int width = 150, height = 25;  //���ô�С�Ĺؼ�����
	private int year;
	private int month;
	private int date;
	private int dayOfWeek;
	private String[] week = { "��", "һ", "��", "��", "��", "��", "��" };
	public JDialog dil_calander=new JDialog();
	public boolean show;
	public JButton bt_query_data = new JButton("");
	public Calendar show_data = Calendar.getInstance();
	public int select;
	/**
	 * Create the panel.
	 */
	public Total_Calander(int select) {
		
		this.select=select;
		setLayout(null);
		tx_data.setBackground(Color.WHITE);
		tx_data.setHorizontalAlignment(SwingConstants.CENTER);
		tx_data.setBounds(0, 0, 102, 28);
		add(tx_data);
		tx_data.setColumns(10);
		bt_query_data.setBackground(Color.WHITE);
		tx_data.setEditable(false);
		bt_query_data.setIcon(new ImageIcon(Total_Calander.class.getResource("/resours/\u6309\u94AE.png")));
		bt_query_data.setBounds(101, 0, 27, 28);
		add(bt_query_data);
		creat_dialog();
		bt_query_data.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (show == false)
				{
					dil_calander.setVisible(true);
					dil_calander.setAlwaysOnTop(true);
					dil_calander.setLocation(tx_data.getLocationOnScreen().x, tx_data.getLocationOnScreen().y+22);
				}else{
					dil_calander.dispose();
				}
				show=!show;
			}
		});
	}
	
	public void creat_dialog(){
		
	show=false;
	dil_calander.setBackground(new Color(245, 245, 220));
	dil_calander.setUndecorated(true);
	paCalendar = new JPanel(new BorderLayout());
	paCalendar.setBorder(this.border);
	paCalendar.setBackground(new Color(245, 245, 220));
	dil_calander.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	int borderWidth = 3;
	// ��ʼ���������������������µ�ѡ��
	JPanel paHeader = new JPanel(new GridLayout(1, 2, borderWidth, borderWidth));
	paHeader.setBackground(new Color(245, 245, 220));
	paHeader.setOpaque(false);
	paHeader.setPreferredSize(new Dimension(width,height+borderWidth));
	paHeader.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, borderWidth, borderWidth));
	paHeader.add(cboYear = new JComboBox());
	cboYear.setBackground(new Color(245, 245, 220));
	paHeader.add(cboMonth = new JComboBox());
	cboMonth.setBackground(new Color(245, 245, 220));
	initYearModel();
	initMonthModel();
	paCalendar.add(paHeader, BorderLayout.NORTH);

	// ��ʼ���������
	JPanel paDay = new JPanel();
	paDay.setBackground(new Color(245, 245, 220));
	paDay.setOpaque(false);
	paDay.setPreferredSize(new Dimension(height * 7, height * 7));
	initDate(paDay);
	paCalendar.add(paDay, BorderLayout.CENTER);
	///////////////////////////////////
	dil_calander.setContentPane(paCalendar);
	dil_calander.pack();
	dil_calander.addWindowFocusListener(new WindowAdapter()
	{
		public void windowLostFocus(WindowEvent e)
		{
			dil_calander.dispose();
		}
	});		
}

	

//��ʾ�������
	private void initYearModel()
	{
		int y ;
		if(select==2){
			y=2015;
		}else{
			y=show_data.get(Calendar.YEAR);
		}
		for (; y < 2020; y++)
			cboYear.addItem(y);
		cboYear.setSelectedItem(year);
		cboYear.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				year = Integer.parseInt(cboYear.getSelectedItem().toString());
				updateComponent();
			}

		});
	}

	
//��ʼ���·ݣ����·�����������
	private void initMonthModel()
	{
		int m;
		if(select==1){
		if(	cboYear.getSelectedItem().toString().equals(show_data.get(Calendar.YEAR)+"")){
			m=(show_data.get(Calendar.MONTH)+1);
		}else{
			m=1;
		}
		}else{
			m=1;
		}
		for (; m <= 12; m++)
			cboMonth.addItem(m);
		cboMonth.setSelectedItem(month);
		cboMonth.addItemListener(new ItemListener()
		{

			public void itemStateChanged(ItemEvent e)
			{
				month = Integer.parseInt(cboMonth.getSelectedItem().toString());
				updateComponent();
			}
		});
	}
	
	//����ؼ����ִ���-------------------------
	private void initDate(JPanel pa)  //����жϱ�ǩ���Ƿ񱻵��
	{
		pa.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		// ��ʾ�����ı�ǩ��
		for (int i = 0; i < week.length; i++)
		{
			lbls[i] = new JLabel(week[i]);
			lbls[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbls[i].setOpaque(true);
			lbls[i].setBackground(Color.WHITE);
			lbls[i].setPreferredSize(new Dimension(25,25));
			pa.add(lbls[i]);
		}
		// ����������ť
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < 42; i++)
		{
			toggles[i] = new JToggleButton();
			toggles[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			toggles[i].setPreferredSize(new Dimension(this.height, this.height));
			toggles[i].setBackground(new Color(240, 230, 140));
			toggles[i].addActionListener(new ActionListener()   ////////////////����toggles�ĵ���¼�
			{
				public void actionPerformed(ActionEvent e)
				{
					
					date = Integer.parseInt(((JToggleButton) e.getSource()).getText().toString());
					dil_calander.dispose();
					show=!show;
					updateField();
				}
			});
			group.add(toggles[i]);
			pa.add(toggles[i]);
		}
		updateComponent();
	}

	//����ȷ�������ļ�����ť�ǿ�ѡ���
	private void updateComponent()
	{
		if (cboYear == null || cboMonth == null)
			return;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		// ���ݵ��µĵ�һ�������ڼ����ж�������ť�����ָôӵڼ�����ť��ʼ��ʾ
		int off = cal.get(Calendar.DAY_OF_WEEK) - 1;
		// ���㵱���ܹ��м���
		int end = 30;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			end = 31;
		if (month == 2)
		{
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				end = 29;
			else
				end = 28;
		}
		
		//�ⲿ�������Ƿ��ѡ�񣬸Ķ��Ĺؼ����ִ���  
		for (int i = 0; i < 42; i++)
		{
			if (i >= off && i <= end + off - 1)
			{
				int day = i - off + 1;
				toggles[i].setText(day + "");
				if(cboYear.getSelectedItem().toString().equals(show_data.get(Calendar.YEAR)+"")&&
						cboMonth.getSelectedItem().toString().equals(show_data.get(Calendar.MONTH+1)+"")&&day<show_data.get(Calendar.DAY_OF_MONTH)&&select==1){
					toggles[i].setEnabled(false);
				}else{
					toggles[i].setEnabled(true);
				}
			} else
			{
				toggles[i].setText("");
				toggles[i].setEnabled(false);
			}
		}
		// ʹ����İ�ť���ֱ����µ�Ч��
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + off - 1;
		toggles[day].setSelected(true);
	}
	
	// �����ı����ڵ�����  
	public void updateField()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(cboYear.getSelectedItem().toString()+".");
		builder.append(cboMonth.getSelectedItem().toString() +".");
		builder.append(this.date + "");
//		Calendar cal = Calendar.getInstance();
//		cal.set(this.year, this.month - 1, this.date);
//		builder.append(" ����" + week[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		tx_data.setText(builder.toString());
	}
	
	public void setDateButtonUI(String clzUIName)
	{
		try
		{
			for (int i = 0; i < 42; i++)
				toggles[i].setUI((ButtonUI) Class.forName(clzUIName).newInstance());
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setComboBoxUI(String clzUIName)
	{
		try
		{
			cboYear.setUI((ComboBoxUI) Class.forName(clzUIName).newInstance());
			cboMonth.setUI((ComboBoxUI) Class.forName(clzUIName).newInstance());
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}
}
