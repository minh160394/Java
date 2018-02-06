import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StudentProcess {
	public static void main(String args[]) {
		Student[] students = {
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
				 new Student("John", "White", 47.0, "Media"),
				 new Student("Laney", "White", 62.0, "IT"),
				 new Student("Jack", "Jones", 32.9, "Business"),
				 new Student("Wesley", "Jones", 42.89, "Media")};

		List<Student> list = Arrays.asList(students);
		System.out.println("Task1: \n");
		System.out.print("Complete Student list: \n");
		list.stream().forEach(x -> System.out.println(x));
		//Task1
		System.out.println();
		System.out.println("Task2: \n");
		System.out.print("Complete Student list: \n");
		//Task2
		Stream<Student> task2 = list.stream();
		task2.sorted(Student.GradeComparator)
			.filter(p -> (p.getGrade() >= 50 && p.getGrade() <= 100))
			.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Task3: \n");
		System.out.print("First Student who got 50.0-100.0: \n");
		//Task3
		Optional<Student> task3 = list.stream()
		.filter(p -> (p.getGrade() >= 50 && p.getGrade() <= 100))
		.findFirst();
		System.out.println(task3.get());
		
		
		System.out.println();
		System.out.println("Task4: \n");
		System.out.print("Students in ascending order by last name then first: \n");
		//Task4a
		Stream<Student> task4a = list.stream();
		task4a.sorted(Student.LastNameComparatorAc.thenComparing(Student.FristNameComparatorAc))
		.forEach(p-> System.out.println(p));
		System.out.println();
		System.out.print("Students in descending order by last name then first: \n");
		//Task4b
		Stream<Student> task4b = list.stream();
		task4b.sorted(Student.LastNameComparatorDe.thenComparing(Student.FristNameComparatorDe))
		.forEach(p-> System.out.println(p));
		
		System.out.println();
		System.out.println("Task5: \n");
		System.out.print("Unique Student last names: \n");
		//Task5
		Stream<Student> task5 = list.stream();
		task5.sorted(Student.LastNameComparatorAc)
		.map(p -> p.getLastName())
		.distinct()
		.forEach(p-> System.out.println(p));
		
		System.out.println();
		System.out.println("Task6: \n");
		System.out.print("Student names in order by last name then first name: \n");
		//Task6
		Stream<Student> task6 = list.stream();
		task6.sorted(Student.LastNameComparatorAc.thenComparing(Student.FristNameComparatorAc))
		.map(p-> p.getFullName())
		.forEach(p-> System.out.println(p));
		
		System.out.println();
		System.out.println("Task7: \n");
		System.out.print("Students by department: \n");
		//Task7
		Map<String,List<Student>> task7 = list.stream()
		.collect(Collectors.groupingBy(p-> p.getDepartment(),Collectors.toList()));
		task7.forEach((department,lists)->{
			System.out.println(department);
			lists.forEach(s-> System.out.println("\t"+s));
		});
		
		System.out.println();
		System.out.println("Task8: \n");
		System.out.print("Count of Students by department: \n");
		Map<String,Long> task8= list.stream()
		.collect(Collectors.groupingBy(p-> p.getDepartment(),TreeMap::new,Collectors.counting()));
		//task8
		task8.forEach((department,lists)->{
			
		System.out.println(department +" has " + lists + " Student(s) " );
		
		});
		
		System.out.println();
		System.out.println("Task9: \n");
		//task9
		Stream<Student> task9 = list.stream();
		Double total = task9.mapToDouble(f-> f.getGrade()).sum();
		
		System.out.println("Sum of Students' grades : " + total);
	
		System.out.println();
		System.out.println("Task10: \n");
		//task10
		Stream<Student> task10 = list.stream();
		
		Double total1 = task10.mapToDouble(f-> f.getGrade()).average().getAsDouble();
		
		System.out.println("Average of Students' grades:  " + String.format("%1$.2f",total1));
	}

	 
}
