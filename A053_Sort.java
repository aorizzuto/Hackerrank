/*
With Comparators

Sample Input
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Sample Output
Ashis
Fahim
Samara
Samiha
Rumpa
*/

import java.util.*;

class Checker2 implements Comparator<Stud>{

    @Override
    public int compare(Stud a, Stud b) {
        if (a.getCgpa() != b.getCgpa())
            return Double.compare(b.getCgpa(), a.getCgpa());
        else
            return a.getFname().compareTo(b.getFname());
    }
}

class Stud{
	private int id;
	private String fname;
	private double cgpa;
	public Stud(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class A053_Sort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Stud> studentList = new ArrayList<Stud>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Stud st = new Stud(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}

        Checker2 checker = new Checker2();
        studentList.sort(checker);
      
      	for(Stud st: studentList){
			System.out.println(st.getFname());
		}

        in.close();
	}
}




