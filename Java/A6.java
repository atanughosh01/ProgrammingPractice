//package java_assignment_2.assignment_6;

import java.util.*;
class Address
{
    private int premises_no;
    private String street;
    private String city;
    private int pin;
    private String state;
    void setAddress()
    {
        System.out.println("Input Adress Details-----");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter premises number = ");
        premises_no=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter street name = ");
        street=sc.nextLine();
        System.out.print("Enter city name = ");
        city=sc.nextLine();
        System.out.print("Enter pin number = ");
        pin=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter state name = ");
        state=sc.nextLine();
    }
    void printAddress()
    {
        System.out.println("Address Details-----");
        System.out.println("Premises number = "+premises_no);
        System.out.println("Street name = "+street);
        System.out.println("City name = "+city);
        System.out.println("PIN number = "+pin);
        System.out.println("State name = "+state);
    }
    void changeAddress()
    {
        int check;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nInput choices-----\n1.Change premises number\n2.Change street\n3.Change city\n4.Change PIN\n5.Change state\n6.Update all\nInput = ");
        check=sc.nextInt();
        sc.nextLine();
        switch(check)
        {
            case 1:
                System.out.print("Input premises number = ");
                premises_no=sc.nextInt();
                break;
            case 2:
                System.out.print("Input street name = ");
                street=sc.nextLine();
                break;
            case 3:
                System.out.print("Input city name = ");
                city=sc.nextLine();
                break;
            case 4:
                System.out.print("Input pin number = ");
                pin=sc.nextInt();
                break;
            case 5:
                System.out.print("Input state name = ");
                state=sc.nextLine();
                break;
            case 6:
                setAddress();
                break;
            default:
                System.out.println("Please enter valid choice");
                break;
        }
    }
}
abstract class Person
{
    protected String name;
    protected Address home;
    protected long phone_no;
    protected String email_id;
    Person()
    {
        home=new Address();
    }
    void setPersonDeatils()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input name of the person = ");
        name=sc.nextLine();
        home.setAddress();
        System.out.print("Input phone number = ");
        phone_no=sc.nextLong();
        sc.nextLine();
        System.out.print("Input email id = ");
        email_id=sc.nextLine();
    }
    void showPersonDetails()
    {
        System.out.println("Details-----");
        System.out.println("Name = "+name);
        System.out.println("Phone number = "+phone_no);
        System.out.println("Email ID = "+email_id);
        home.printAddress();
    }
    void update()
    {
        int check;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nInput choices-----\n1.Update name\n2.Update address\n3.Update phone number\n4.Update Email ID\nInput = ");
        check=sc.nextInt();
        sc.nextLine();
        switch(check)
        {
            case 1:
                System.out.print("Input name of the person = ");
                name=sc.nextLine();
                break;
            case 2:
                home.changeAddress();
                break;
            case 3:
                System.out.print("Input phone number = ");
                phone_no=sc.nextLong();
                break;
            case 4:
                System.out.print("Input email id = ");
                email_id=sc.nextLine();
                break;
            default:
                System.out.println("Please input valid choice");
                break;
        }
    }
}
class Student extends Person
{
    private final int roll;
    private final String course;
    Student(int r)
    {
        super();
        setPersonDeatils();
        roll=r;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input course of the student = ");
        course=sc.nextLine();
    }
    void showStudent()
    {
        System.out.print("\nStudent ");
        showPersonDetails();
        System.out.println("Roll = "+roll);
        System.out.println("Course = "+course);
    }
    int getRoll()
    {
        return roll;
    }
}
class StudentRegister
{
    private Student[] student_list;
    private int no_of_student;
    private boolean[] sid_generator;
    private int max_no_of_student;
    private int sidGeneration()
    {
        for(int i=0;i<max_no_of_student;i++)
        {
            if(!sid_generator[i])
            {
                sid_generator[i]=true;
                return (i+1);
            } 
        }
        return 0;
    }
    private int searchStudent(int r)
    {
        for(int i=0;i<no_of_student;i++)
        {
            if(student_list[i].getRoll()==r)
                return i;
        }
        return -1;
    }
    StudentRegister()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input the maximum number of students = ");
        max_no_of_student=sc.nextInt();
        student_list=new Student[max_no_of_student];
        sid_generator=new boolean[max_no_of_student];
        for(int i=0;i<max_no_of_student;i++)
        {
            sid_generator[i]=false;
        }
        no_of_student=0;
    }
    void newStudent()
    {
        if(no_of_student==max_no_of_student)
        {
            System.out.println("Student register is already full!!!");
            return;
        }
        Student s=new Student(sidGeneration());
        student_list[no_of_student]=s;
        no_of_student++;
        System.out.println("Student record entered successfully");
    }  
    void showStudent()
    {
        int r;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input roll of the student = ");
        r=sc.nextInt();
        int i=searchStudent(r);
        if(i!=-1)
        {
            student_list[i].showStudent();
        }
        else
            System.out.println("There is no student with this roll number");
    }
    void updateStudent()
    {
        int r;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input roll of the student = ");
        r=sc.nextInt();
        int i=searchStudent(r);
        if(i!=-1)
        {
            student_list[i].update();
            System.out.println("Student record updated successfully");
        }
        else
            System.out.println("There is no student with this roll number");
    }
    void deleteStudent()
    {
        int r;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input roll of the student = ");
        r=sc.nextInt();
        int i=searchStudent(r);
        if(i!=-1)
        {
            sid_generator[student_list[i].getRoll()-1]=false;
            for(int j=i;j<(no_of_student-1);j++)
            {
                student_list[j]=student_list[j+1];
            }
            no_of_student--;
            System.out.println("Student record deleted successfully");
        }
        else
            System.out.println("There is no student with this roll number");
    }
}
class Faculty extends Person
{
    private final int id;
    private final String department;
    private String specialisation;
    Faculty(int r)
    {
        super();
        setPersonDeatils();
        id=r;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input department of the faculty = ");
        department=sc.nextLine();
        System.out.print("Input specialisation of the faculty = ");
        specialisation=sc.nextLine();
    }
    void showFaculty()   
    {
        System.out.print("\nFaculty ");
        showPersonDetails();
        System.out.println("Employee ID = "+id);
        System.out.println("Department = "+department);
        System.out.println("Specialisation = "+specialisation);
    }
    void update()
    {
        int check;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nInput choice-----\n1.Update personal details\n2.Update specialisation\nInput = ");
        check=sc.nextInt();
        sc.nextLine();
        switch(check)
        {
            case 1:
                super.update();
                break;
            case 2:
                System.out.print("Input specialisation = ");
                specialisation=sc.nextLine();
                break;
            default:
                System.out.println("Please enter valid input");
                break;
        }
    }
    int getID()
    {
        return id;
    }
}
class FacultyRegister
{
    private Faculty[] faculty_list;
    private int no_of_faculty;
    private boolean[] fid_generator;
    private int max_no_of_faculty;
    private int fidGeneration()
    {
        for(int i=0;i<max_no_of_faculty;i++)
        {
            if(!fid_generator[i])
            {
                fid_generator[i]=true;
                return (i+1);
            }
        }
        return 0;
    }
    private int searchFaculty(int id)
    {
        for(int i=0;i<no_of_faculty;i++)
        {
            if(faculty_list[i].getID()==id)
                return i;
        }
        return -1;
    }
    FacultyRegister()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input the maximum number of faculty = ");
        max_no_of_faculty=sc.nextInt();
        faculty_list=new Faculty[max_no_of_faculty];
        fid_generator=new boolean[max_no_of_faculty];
        for(int i=0;i<max_no_of_faculty;i++)
        {
            fid_generator[i]=false;
        }
        no_of_faculty=0;
    }
    void newFaculty()
    {
        if(no_of_faculty==max_no_of_faculty)
        {
            System.out.println("The faculty register is already full!!!");
            return;
        }
        Faculty f=new Faculty(fidGeneration());
        faculty_list[no_of_faculty]=f;
        no_of_faculty++;
        System.out.println("Faculty record entered successfully");
    }
    void showFaculty()
    {
        int id;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input employee ID of the faculty = ");
        id=sc.nextInt();
        int i=searchFaculty(id);
        if(i!=-1)
        {
            faculty_list[i].showFaculty();
        }
        else
            System.out.println("There is no faculty with this employee ID");
    }
    void updateFaculty()
    {
        int id;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input employee ID of the faculty = ");
        id=sc.nextInt();
        int i=searchFaculty(id);
        if(i!=-1)
        {
            faculty_list[i].update();
            System.out.println("Faculty record updated successfully");
        }
        else
            System.out.println("There is no faculty with this employee ID");
    }
    void deleteFaculty()
    {
        int id;
        Scanner sc=new Scanner(System.in);
        System.out.print("Input employee ID of the faculty = ");
        id=sc.nextInt();
        int i=searchFaculty(id);
        if(i!=-1)
        {
            fid_generator[faculty_list[i].getID()-1]=false;
            for(int j=i;j<(no_of_faculty-1);j++)
            {
                faculty_list[j]=faculty_list[j+1];
            }
            no_of_faculty--;
            System.out.println("Faculty record deleted successfully");
        }
        else
            System.out.println("There is no faculty with this employee ID");
    }
}
class Institute
{
    
    private StudentRegister sr;
    private FacultyRegister fr;
    Institute()
    {
        sr=new StudentRegister();
        fr=new FacultyRegister();
    }
    void studentOperations()
    {
        int check;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nInput choices-----\n1.Add new student\n2.Update details of existing student\n3.Show student details\n4.Delete student record\nInput = ");
        check=sc.nextInt();
        switch(check)
        {
            case 1:
                sr.newStudent();
                break;
            case 2:
                sr.updateStudent();
                break;
            case 3:
                sr.showStudent();
                break;
            case 4:
                sr.deleteStudent();
                break;
            default:
                System.out.println("Please enter valid choice");
                break;
        }
    }
    void facultyOperations()
    {
        int check;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nInput choices-----\n1.Add new faculty\n2.Update details of existing faculty\n3.Show faculty details\n4.Delete faculty record\nInput = ");
        check=sc.nextInt();
        switch(check)
        {
            case 1:
                fr.newFaculty();
                break;
            case 2:
                fr.updateFaculty();
                break;
            case 3:
                fr.showFaculty();
                break;
            case 4:
                fr.deleteFaculty();
                break;
            default:
                System.out.println("Please enter valid choice");
                break;
        }
    }
}
class DriverInstitute
{
    public static void main(String[] args)
    {
        int check;
        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        Institute i=new Institute();
        while(flag)
        {
            System.out.print("\nInput choices-----\n1.Student operations\n2.Faculty operations\nInput = ");
            check=sc.nextInt();
            switch(check)
            {
                case 1:
                    i.studentOperations();
                    break;
                case 2:
                    i.facultyOperations();
                    break;
                default:
                    flag=false;
                    break;
            }
        }
    }
}
