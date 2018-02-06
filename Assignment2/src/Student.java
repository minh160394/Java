import java.util.Comparator;
public class Student implements Comparable<Student>{
	private String firstName;
	private String lastName;
	private Double grade;
	private String department;

	//CONTRUCTOR
	Student(String firstName, String lastName, Double grade, String department){
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		if (department == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	//Getter
	String getFullName(){
		return this.firstName.concat(" ").concat(this.lastName);
	}
	Double getGrade(){
		return this.grade;
	}
	String getDepartment(){
		return this.department;
	}
	String getLastName(){
		return this.lastName;
	}
	//Setter
	void setFirstName(String newfirstname){
		this.firstName = newfirstname;
	}
	void setLastName(String newlastname){
		this.lastName = newlastname;
	}
	void setGrade(Double newgrade){
		this.grade = newgrade;
	}
	void setDepartment(String newdepartment){
		this.department = newdepartment;
	}
	//HashCode

	public int hashCode(){
		final int prime =31;
		int result = 1;
		result = prime * result +((firstName == null) ? 0 : firstName.hashCode() );
		result = prime * result +((lastName == null) ? 0 : lastName.hashCode() );
		result = prime * result +((department == null) ? 0 : department.hashCode() );
		result = (int)(prime * result + grade);

		return result;

	}
	//Equal
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if(this.getFullName() == null){
			if(other.getFullName() != null)
				return false;
		}
		else if (!getFullName().equals(other.getFullName()))
			return false;

		if(department == null){
			if(other.department != null)
				return false;		  
		}
		else if (!department.equals(other.department)){
			return false;
		}
		if(grade != other.grade){
			return false;
		}

		return true;
	}
	//ToString()
	public String toString(){
		return firstName +"\t" +lastName + "\t" + String.format("%1$.2f",grade ) + "\t" + department  ;
	}

	public static final Comparator<Student> GradeComparator = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return (int) (student1.getGrade() - student2.getGrade());
		}
	};

	public static final Comparator<Student> FristNameComparatorAc = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return student1.firstName.compareTo(student2.firstName);
		}
	};

	public static final Comparator<Student> LastNameComparatorAc = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return student1.lastName.compareTo(student2.lastName);
		}
	};

	public static final Comparator<Student> FristNameComparatorDe = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return student2.firstName.compareTo(student1.firstName);
		}
	};

	public static final Comparator<Student> LastNameComparatorDe = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return student2.lastName.compareTo(student1.lastName);
		}
	};

	public static final Comparator<Student> DepartmentComparator = new Comparator<Student>(){
		@Override
		public int compare(Student student1, Student student2){
			return student1.department.compareTo(student2.department);
		}
	};

	@Override
	public int compareTo(Student o1) {

		return 0;
	}

} 

