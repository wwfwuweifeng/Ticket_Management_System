package 旅游管理系统;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Diy_jtable2 extends JTable {
	
	public Diy_jtable2(DefaultTableModel tableModel_road) {
		// TODO 自动生成的构造函数存根
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
