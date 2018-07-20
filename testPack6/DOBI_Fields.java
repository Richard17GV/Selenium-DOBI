package testPack6;

public class DOBI_Fields {
	
	public static FieldMaker globalDepartmentDropdown() {
	FieldMaker globalDepartmentDropdown = new FieldMaker();
	globalDepartmentDropdown.setFieldName("global Department dropdown");
	globalDepartmentDropdown.setTheXpath("//*[@id='departmentDropdownList']");
	globalDepartmentDropdown.setxPathDescription("'" + globalDepartmentDropdown.getFieldName() + "'  on the 'Add/Edit Purchase Order' page");
	return globalDepartmentDropdown;
	}

}
