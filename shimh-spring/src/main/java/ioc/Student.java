package ioc;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class Student {

	private String name;

	private Integer age;

	private String location;

	private Dog dog;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, Dog dog) {
		this.name = name;
		this.dog = dog;
	}

	public Student() {
	}

	public void eat() {
		System.out.println("Student 开始吃饭了");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
