package ���ι���ϵͳ;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Diy_jtable extends JTable {
	public Diy_jtable(DefaultTableModel tableModel) {
		// TODO �Զ����ɵĹ��캯�����
		super(tableModel);
	}

	public boolean isCellEditable(int row,int column){
		return false;
	}
	
}
