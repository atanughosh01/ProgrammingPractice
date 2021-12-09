import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class MyObjectOutputStream  extends ObjectOutputStream{

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    public void writeStreamHeader() throws IOException{
        return;
    }
}
class Employee implements Serializable
{
    private int empcode;
    private String empname;
    private float basic_salary;
    private char grade;
    private String dept_code;
    void setEmpCode(int ec)
    {
        empcode=ec;
    }
    void setEmpName(String en)
    {
        empname=en;
    }
    void setBasic(float bs)
    {
        basic_salary=bs;
    }
    void setGrade(char g)
    {
        grade=g;
    }
    void setDept(String dc)
    {
        dept_code=dc;
    }
    int getEmpCode()
    {
        return empcode;
    }
    String getEmpName()
    {
        return empname;
    }
    float getBasic()
    {
        return basic_salary;
    }
    char getGrade()
    {
        return grade;
    }
    String getDept()
    {
        return dept_code;
    }
    @Override
    public String toString()
    {
        return("Employee Details------\nEmp Code = "+empcode+"\nEmpname = "+empname+"\nBasic salary = "+basic_salary+"\nGrade = "+grade+"\nDept code = "+dept_code+"\n");
    }
}
class EmployeeRegister
{
    private String filename;
    EmployeeRegister(String fn)
    {
        filename=fn;
        try
        {
            RandomAccessFile ra=new RandomAccessFile(fn,"rw");
            ra.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception messege = "+e.getMessage());
        }
    }
    void addEmployee(Employee e)
    {
        try
        {
            File file=new File(filename);
            FileOutputStream fo=new FileOutputStream(file,true);
            if(file.length()<1)
            {
                ObjectOutputStream obo=new ObjectOutputStream(fo);
                obo.writeObject(e);
                obo.close();
            }
            else
            {
                MyObjectOutputStream mo=new MyObjectOutputStream(fo);
                mo.writeObject(e);
                mo.close();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception messege = "+ex.getMessage());
        }
    }
    Employee searchEmployee(int code)
    {
        Employee e=new Employee();
        try
        {
            FileInputStream fi=new FileInputStream(filename);
            ObjectInputStream obi=new ObjectInputStream(fi);
            try
            {
                while(fi.available()>0)
                {
                    e=(Employee)obi.readObject();
                    if(e.getEmpCode()==code)
                    {
                        obi.close();
                        return e;
                    }
                }
            }
            catch(EOFException ex)
            {
                //System.out.println("Exception messege --1--= "+ex.getMessage());
            }
            obi.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception messege --1--= "+ex.getMessage());
        }
        return null;
    }
}
class MyEmployeeInputFrame extends JFrame
{
    private EmployeeRegister employee_list;
    private Employee e;
    private JLabel l1, l2, l3;
    private JTextField t1, t2, t3;
    private JRadioButton r1, r2, r3;
    private JList l;
    private JButton b1;
    private JPanel p1, p2, p3, p4;
    MyEmployeeInputFrame(EmployeeRegister er)
    {
        super("Input Employee Details");
        employee_list=er;
        e=new Employee();
        setSize(800,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepare_panel_1();
        prepare_panel_2();
        prepare_panel_3();
        prepare_panel_4();
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.SOUTH);
        setVisible(true);
    }
    private void prepare_panel_1()
    {
        p1=new JPanel();
        l1=new JLabel("Input Employee Code");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2=new JLabel("Input Employee Name");
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3=new JLabel("Input Employee Salary");
        l3.setHorizontalAlignment(JLabel.CENTER);
        t1=new JTextField(40);
        t2=new JTextField(40);
        t3=new JTextField(40);
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Basic Info"),BorderFactory.createEmptyBorder(10,0,20,100)));
        p1.setLayout(new GridLayout(3,2));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
    }
    private void prepare_panel_2()
    {
        p2=new JPanel();
        p2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Grades"),BorderFactory.createEmptyBorder(20,150,20,150)));
        r1=new JRadioButton("Grade A");
        r2=new JRadioButton("Grade B");
        r3=new JRadioButton("Grade C");
        p2.setLayout(new GridLayout(3,1));
        ButtonGroup gp=new ButtonGroup();
        gp.add(r1);
        gp.add(r2);
        gp.add(r3);
        p2.add(r1);
        p2.add(r2);
        p2.add(r3);
    }
    private void prepare_panel_3()
    {
        p3=new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("Departments List"));
        p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Departments List"),BorderFactory.createEmptyBorder(20,30,20,30)));
        String[] departments={"Computer Science Engineering","Civil Engineering","Electronics and Communication Engineering","Mechanical Engineering","Chemical Engineering","Electrical Engineering"};
        l=new JList(departments);
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp=new JScrollPane(l);
        p3.add(sp);
    }
    private void prepare_panel_4()
    {
        p4=new JPanel();
        b1=new JButton("SAVE");
        b1.addActionListener(new MyActionListener());
        p4.add(b1);
    }
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e1)
        {
            if(e1.getSource()==b1)
            {
                int n=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(n==JOptionPane.NO_OPTION)
                    return;
                int code;
                try{
                    code=Integer.parseInt(t1.getText());
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Code must be integer!!!");
                    return;
                }
                if(employee_list.searchEmployee(code)!=null)
                {
                    JOptionPane.showMessageDialog(null,"An existing employee has same code!!!");
                    return;
                }
                e.setEmpCode(code);
                e.setEmpName(t2.getText());
                try{
                    e.setBasic(Float.parseFloat(t3.getText()));
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Salary must be float!!!");
                    return;
                }
                if(r1.isSelected())
                    e.setGrade('A');
                if(r2.isSelected())
                    e.setGrade('B');
                if(r3.isSelected())    
                    e.setGrade('C');
                if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Please select a Grade");
                    return;
                }
                int i=l.getSelectedIndex();
                switch(i)
                {
                    case 0:
                        e.setDept("CSE");
                        break;
                    case 1:
                        e.setDept("CE");
                        break;
                    case 2:
                        e.setDept("ECE");
                        break;
                    case 3:
                        e.setDept("ME");
                        break;
                    case 4:
                        e.setDept("ChE");
                        break;
                    case 5:
                        e.setDept("EE");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please choose a department");
                        return;
                }
                employee_list.addEmployee(e);
                JOptionPane.showMessageDialog(null,"Data update successfull!!!");
                OptionSelectionFrame of=new OptionSelectionFrame(employee_list);
                dispose();
            }
        }
    }
}
class MyEmployeeOutputFrame extends JFrame
{
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private JPanel p1, p2;
    private JButton b1;
    private EmployeeRegister er;
    MyEmployeeOutputFrame(Employee e,EmployeeRegister empr)
    {
        super("Employee Details");
        setSize(500,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepare_panel_1(e);
        prepare_panel_2();
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);
        er=empr;
        setVisible(true);
    }
    private void prepare_panel_1(Employee e)
    {
        p1=new JPanel();
        l1=new JLabel("Employee Code ");
        l2=new JLabel(": "+Integer.toString(e.getEmpCode()));
        l3=new JLabel("Employee Name ");
        l4=new JLabel(": "+e.getEmpName());
        l5=new JLabel("Employee Basic Salary ");
        l6=new JLabel(": "+Float.toString(e.getBasic()));
        l7=new JLabel("Employee Grade ");
        l8=new JLabel(": "+Character.toString(e.getGrade()));
        l9=new JLabel("Employee Department Code ");
        l10=new JLabel(": "+e.getDept());
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Employee Info"),BorderFactory.createEmptyBorder(10,10,10,10)));
        p1.setLayout(new GridLayout(5,2));
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(l9);
        p1.add(l10);
    }
    private void prepare_panel_2()
    {
        p2=new JPanel();
        b1=new JButton("OK");
        b1.addActionListener(new MyActionListener());
        p2.add(b1);
    }
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e1)
        {
            if(e1.getSource()==b1)
            {
                OptionSelectionFrame of=new OptionSelectionFrame(er);
                dispose();
            }
        }
    }
}
class SearchFrame extends JFrame
{
    private JLabel l;
    private JTextField t;
    private JPanel p1, p2;
    private JButton b;
    private EmployeeRegister er;
    SearchFrame(EmployeeRegister empr)
    {
        super("Search Employee");
        setSize(450,150);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepare_panel_1();
        prepare_panel_2();
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);
        er=empr;
        setVisible(true);
    }
    private void prepare_panel_1()
    {
        p1=new JPanel();
        l=new JLabel("Input Emp Code of Employee");
        t=new JTextField(10);
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Input"),BorderFactory.createEmptyBorder(10,10,10,10)));
        p1.setLayout(new GridLayout(1,2));
        p1.add(l);
        p1.add(t);
    }
    private void prepare_panel_2()
    {
        p2=new JPanel();
        b=new JButton("SEARCH");
        b.addActionListener(new MyActionListener());
        p2.add(b);
    }
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e1)
        {
            if(e1.getSource()==b)
            {
                int code;
                try
                {
                    code=Integer.parseInt(t.getText());
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Emp Code must be an integer","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Employee e=er.searchEmployee(code);
                if(e==null)
                {
                    JOptionPane.showMessageDialog(null,"No employee is present with this code","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MyEmployeeOutputFrame mo=new MyEmployeeOutputFrame(e,er);
                dispose();
            }
        }
    }
}
class OptionSelectionFrame extends JFrame
{
    private JRadioButton r1, r2, r3;
    private JButton b;
    private JPanel p1, p2;
    private EmployeeRegister er;
    OptionSelectionFrame(EmployeeRegister empr)
    {
        super("Selection List");
        setSize(250,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepare_panel_1();
        prepare_panel_2();
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);
        er=empr;
        setVisible(true);
    }
    private void prepare_panel_1()
    {
        p1=new JPanel();
        r1=new JRadioButton("Input Employee Details");
        r2=new JRadioButton("Search an Employee");
        r3=new JRadioButton("Exit");
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Options"),BorderFactory.createEmptyBorder(20,10,10,20)));
        ButtonGroup gp=new ButtonGroup();
        gp.add(r1);
        gp.add(r2);
        gp.add(r3);
        p1.setLayout(new GridLayout(3,1));
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
    }
    private void prepare_panel_2()
    {
        p2=new JPanel();
        b=new JButton("OK");
        b.addActionListener(new MyActionListener());
        p2.add(b);
    }
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e1)
        {
            if(e1.getSource()==b)
            {
                if(r1.isSelected())
                {
                    MyEmployeeInputFrame mi=new MyEmployeeInputFrame(er);
                }
                if(r2.isSelected())
                {
                    SearchFrame sf=new SearchFrame(er);
                }
                if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected())
                {  
                    JOptionPane.showMessageDialog(null,"Please select an option!!!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                dispose();
            }
        }
    }
}
class Driver_GUI
{
    public static void main(String[] args)
    {
        EmployeeRegister er=new EmployeeRegister("Emp.txt");
        OptionSelectionFrame of=new OptionSelectionFrame(er);
        //System.exit(0);
    }
}