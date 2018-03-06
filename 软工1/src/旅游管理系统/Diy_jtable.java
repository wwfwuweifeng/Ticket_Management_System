package 旅游管理系统;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Diy_jtable extends JTable {
	public Diy_jtable(DefaultTableModel tableModel) {
		// TODO 自动生成的构造函数存根
		super(tableModel);
	}

	public boolean isCellEditable(int row,int column){
		return false;
	}
	
}
