package resours;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComboBoxUI;

public class Rili extends JPanel
{
//	private JTextField tfDate;
//	private JButton button;
	public JDialog dlg;
	private JPanel paCalendar;
	private boolean show;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JLabel[] lbls = new JLabel[7];
	private JToggleButton[] toggles = new JToggleButton[42];
	private Border border;
//	private Color bgColor;
	private int width = 150, height = 25;
	private int year;
	private int month;
	private int date;
	private int dayOfWeek;
	private String[] week = { "��", "һ", "��", "��", "��", "��", "��" };
	private JButton btnNewButton;

	public Rili()
	{
		year = Calendar.getInstance().get(Calendar.YEAR);
		month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		date = Calendar.getInstance().get(Calendar.DATE);
		dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		initUI();
		initDateDialog();
		updateField();
	}

	private void initUI()
	{
//		tfDate = new JTextField();
//	tfDate.setEditable(false);
//		tfDate.setBackground(Color.WHITE);
//		border = tfDate.getBorder();
//		tfDate.setBorder(null);

//   	button = new JButton();
//		button.setPreferredSize(new Dimension(height, height));
		
//����¼���������ʾ�������˴���Ҫ�޸�
//		button.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				if (show == false)
//				{
				//dialog�����ã�����λ�ã�������Զ����ǰ��
//					dlg.setLocation(Rili.this.getLocationOnScreen().x, Rili.this.getLocationOnScreen().y + Rili.this.height);
//					dlg.setAlwaysOnTop(true);
//					dlg.setVisible(true);
				
//				} else
//				{
//					dlg.dispose();
//				}
				updateField();
//				show = !show;
//			}
//		});
//
//		this.bgColor = this.getBackground();
//
//		this.setOpaque(false);
//		this.setLayout(new BorderLayout(0, 0));
//		this.setBorder(border);
//	//	this.add(tfDate, BorderLayout.CENTER);          �ı�����ȥ===============================
//		this.add(button, BorderLayout.EAST);
//	}
	}
	private void initDateDialog()
	{
		dlg = new JDialog();
		dlg.setBackground(new Color(245, 245, 220));
		dlg.setUndecorated(true);
		paCalendar = new JPanel(new BorderLayout());
		paCalendar.setBorder(this.border);
		paCalendar.setBackground(new Color(245, 245, 220));

		int borderWidth = 3;
		// ��ʼ���������������������µ�ѡ��
		JPanel paHeader = new JPanel(new GridLayout(1, 2, borderWidth, borderWidth));
		paHeader.setBackground(new Color(245, 245, 220));
		paHeader.setOpaque(false);
		paHeader.setPreferredSize(new Dimension(150, 28));
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
		paDay.setPreferredSize(new Dimension(25 * 7, 25 * 7));
		initDate(paDay);
		paCalendar.add(paDay, BorderLayout.CENTER);
		///////////////////////////////////
		dlg.setContentPane(paCalendar);
		dlg.pack();
		dlg.addWindowFocusListener(new WindowAdapter()
		{
			public void windowLostFocus(WindowEvent e)
			{
				dlg.dispose();
			}
		});
	}

	
	
//��ʾ�������
	private void initYearModel()
	{
		for (int y = 2016; y < 2030; y++)
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
		for (int m = 1; m <= 12; m++)
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
	private void initDate(JPanel pa)
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
			toggles[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					date = Integer.parseInt(((JToggleButton) e.getSource()).getText().toString());
					dlg.dispose();
					updateField();
				}
			});
			group.add(toggles[i]);
			pa.add(toggles[i]);
		}
		updateComponent();
	}

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
		for (int i = 0; i < 42; i++)
		{
			if (i >= off && i <= end + off - 1)
			{
				int day = i - off + 1;
				toggles[i].setText(day + "");
				toggles[i].setEnabled(true);
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

	// �����ı����ڵ�����    ->  ��Ϊ������ѡ����
	public String updateField()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(this.year + "��");
		builder.append(this.month + "��");
		builder.append(this.date + "��");
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month - 1, this.date);
		builder.append(" ����" + week[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		return builder.toString();
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(this.width, this.height);
	}

	public void setPreferredSize(Dimension preferredSize)
	{
		super.setPreferredSize(preferredSize);
		this.width = (int) preferredSize.getWidth();
		this.height = (int) preferredSize.getHeight();
	}

//	public void setBackground(Color bg)
//	{
//		super.setBackground(bg);
//		this.bgColor = bg;
//	}

	public void setBorder(Border border)
	{
		super.setBorder(border);
		if (paCalendar != null)
			paCalendar.setBorder(border);
	}

	
	//�ⲿ�ֻ���֪���ô�================================================
//	public void setButtonUI(String clzUIName)
//	{
//		try
//		{
//			button.setUI((ButtonUI) Class.forName(clzUIName).newInstance());
//		}
//		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//	}

	//��ʼ���������button����ʾ������     ��������������������������������
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

	public void setLableColor(Color fg, Color bg)
	{
		for (int i = 0; i < lbls.length; i++)
		{
			lbls[i].setForeground(fg);
			lbls[i].setBackground(bg);
		}
	}

//	public void setIcon(Image icon)
//	{
//		button.setIcon(new ImageIcon(icon));
//	}

	public int getYear()
	{
		return this.year;
	}

	public int getMonth()
	{
		return this.month;
	}

	public int getDateOfWeek()
	{
		return this.date;
	}

	public Date getDate()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month, this.date);
		return cal.getTime();
	}
}
