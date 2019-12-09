package xuanke;

public class Course {
	
	private String courseName;
	private String selected;
	
	public Course(String courseName, String selected){
		this.courseName = courseName;
		this.selected = selected;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	

}
