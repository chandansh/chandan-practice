package mypack;

public class Emp {
	private int id;
	private String name, job;
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Emp() {
		super();
	}
	

	public Emp(String name, String job, int salary) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
	}


	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
