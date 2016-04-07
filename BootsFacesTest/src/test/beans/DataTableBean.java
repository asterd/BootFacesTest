package test.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.component.dataTable.DataTable.DataTablePropertyType;

@ManagedBean(name = "dt")
@SessionScoped
public class DataTableBean {
	private List<ItemData> itemList;
	private Map<DataTablePropertyType, Object> dp1 = new HashMap<DataTablePropertyType, Object>();;
	private Map<DataTablePropertyType, Object> dp2 = new HashMap<DataTablePropertyType, Object>();;
	
	
	public DataTableBean() {
		buildItemList();
	}
	
	private void buildItemList() {
		itemList = new ArrayList<ItemData>();
		for(int i = 1; i < 100; i++) {
			ItemData item = new ItemData();
			item.setTitle("TITLE_" + i);
			item.setYear(i);
			item.setMonth(i);
			
			itemList.add(item);
		}
		dp1.put(DataTablePropertyType.currentPage, 2);
		dp2.put(DataTablePropertyType.currentPage, 4);
	}

	public List<ItemData> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemData> itemList) {
		this.itemList = itemList;
	}

	public Map<DataTablePropertyType, Object> getDp1() {
		return dp1;
	}

	public void setDp1(Map<DataTablePropertyType, Object> dp1) {
		System.out.println("SET CALLED!");
		System.out.println(dp1.get(DataTablePropertyType.currentPage));
		this.dp1 = dp1;
	}

	public Map<DataTablePropertyType, Object> getDp2() {
		return dp2;
	}

	public void setDp2(Map<DataTablePropertyType, Object> dp2) {
		this.dp2 = dp2;
	}
}
