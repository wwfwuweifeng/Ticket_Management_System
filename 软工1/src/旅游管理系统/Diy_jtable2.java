package ���ι���ϵͳ;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Diy_jtable2 extends JTable {
	
	public Diy_jtable2(DefaultTableModel tableModel_road) {
		// TODO �Զ����ɵĹ��캯�����
		super(tableModel_road);
	}

	public boolean isCellEditable(int row,int column){
		if(column==4||column==5)
		{
			return true;
		}else{
			return false;
		}
	}
}
