
package virtual_med;

import java.sql.*;
import java.util.*;
public class Virtual_med {

   
    public static void main(String[] args) {
      try{ 
        Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/virtualmed","root",""); 
Statement stmt=con.createStatement(); 

        Scanner s=new Scanner(System.in);
        System.out.println("============WELCOME=================");
        
        while(true)
        {
            System.out.println("1. Create new Profile    2.Patient Details   "
                    + "3.Doctor Details    4.Medicine center    5.Reports    6.Appointment   7.Exit");
            int ch=s.nextInt();
            
            switch(ch)
            {
             case 1:
            //login_details
            System.out.println("enter the login id");     
            int login_id=s.nextInt();
            System.out.println("enter your login password");
            String password=s.next();
            System.out.println("enter your full name");
            String full_name=s.next();
            System.out.println("enter your phone_no");
            String phone_no=s.next();
            Statement st=con.createStatement();       //for connection
            String query="INSERT INTO login_details VALUES('"+login_id+"' ,'"+password+"' ,'"+full_name+"' ,' "+phone_no+" ');";
            st.executeUpdate(query);
            System.out.println("successfully updated the login details of patients");
            break;
            
        case 2: 
             //doctor
             System.out.println("Enter the Doctor's ID:");     
              int doc_id=s.nextInt();
             System.out.println("Enter the Doctor's name:");
             String doc_name=s.next();
             System.out.println("Enter Specialization:");
             String specialization=s.next();
             System.out.println("Enter Hospital name:");
             String hospital=s.next();
             System.out.println("Enter hospital location:");
             String location=s.next();
             Statement st1=con.createStatement();
             String query1="INSERT INTO doctor VALUES('"+doc_id+"','"+doc_name+"','"+specialization+"','"+hospital+"','"+location+"');";
             st1.executeUpdate(query1);
             System.out.println("succesfully dumped information about doctors");
             break;
             
        case 3:
             //for patients
             System.out.println("Enter the Patient ID:");      
            int patient_id=s.nextInt();
            System.out.println("Enter the Patient's name:");
            String patient_name=s.next();
            System.out.println("Enter the Patient's Age:");
            int age=s.nextInt();
            System.out.println("Enter the Patient's blood group:");
            String blood_group=s.next();
            System.out.println("Enter the Patient's disease:");
            String diseases=s.next();
            System.out.println("Registration date");
            String reg_date=s.next();
           
            Statement st2=con.createStatement();
            String query2="INSERT INTO patient VALUES('"+patient_id+"','"+patient_name+"','"+age+"','"+blood_group+"','"+diseases+"','"+reg_date+"');";
            st2.executeUpdate(query2);
             System.out.println("succesfully dumped information about patients");
             break;
             
        case 4:
            //medicine center
            System.out.println("Welcome to medicine center");
            System.out.println("enter the center id of medical store");
            int center_id=s.nextInt();
            System.out.println("enter the state");
            String state=s.next();
            System.out.println("enter the city");
            String city=s.next();
            System.out.println("enter the zipcode");
            String zipcode=s.next();
            System.out.println("enter the dealer name");
            String dealer=s.next();
            System.out.println("enter the contact_no");
            String contact_no=s.next();
            Statement st3=con.createStatement();
            String query3="INSERT INTO medicine_center VALUES(' "+center_id+" ',' "+state+" ',' "+city+" ',' "+zipcode+" ',' "+dealer+" ',' "+contact_no+" ');";
            st3.executeUpdate(query3);
            System.out.println("ssuccessfully updated about medcines");
            break;
            
             case 5:
            //for reports
            System.out.println("reports of patients");
            System.out.println("enter the patient id");
            patient_id=s.nextInt();
            //blood group
            System.out.println("Doctor of patient is :- ");
            Statement stmt1=con.createStatement();
            ResultSet py1=stmt1.executeQuery("select doc_name from reports where patient_id='"+patient_id+"'");
            while(py1.next())
                System.out.println(py1.getString(1));
            
            //patient age code 
            System.out.println("Blood Pressure of patient is :- ");
            Statement stmt0=con.createStatement();
            ResultSet py=stmt0.executeQuery("select bp from reports where patient_id='"+patient_id+"'");
            while(py.next())
                System.out.println(py.getInt(1));
            
            System.out.println("Sugar of patient is :- ");
            Statement stmt2=con.createStatement();
            ResultSet py2=stmt2.executeQuery("select sugar from reports where patient_id='"+patient_id+"'");
            while(py2.next())
                System.out.println(py2.getInt(1));
            
            System.out.println("Complications of patient is :- ");
            Statement stmt3=con.createStatement();
            ResultSet py3=stmt3.executeQuery("select complication from reports where patient_id='"+patient_id+"'");
            while(py3.next())
                System.out.println(py3.getString(1));
            
            System.out.println("Prescription of patient is :- ");
            Statement stmt4=con.createStatement();
            ResultSet py4=stmt4.executeQuery("select prescription from reports where patient_id='"+patient_id+"'");
            while(py4.next())
                System.out.println(py4.getString(1));
            
            System.out.println("Last Visit of patient is :- ");
            Statement stmt5=con.createStatement();
            ResultSet py5=stmt5.executeQuery("select last_visit from reports where patient_id='"+patient_id+"'");
            while(py5.next())
                System.out.println(py5.getString(1));
           break;
           
        case 6:
            // for appointment
            System.out.println(" Appointment Details");
            System.out.println("enter the login id");
            login_id=s.nextInt();
            //patient name for appointment
             System.out.println("Patient who has taken appointment is :- ");
            Statement stmt6=con.createStatement();
            ResultSet py6=stmt6.executeQuery("select patient_name from appointment where login_id='"+login_id+"'");
            while(py6.next())
                System.out.println(py6.getString(1));
            
            //doctor id for appointment
            System.out.println("Doctor appointed for a patient :- ");
            Statement stmt7=con.createStatement();
            ResultSet py7=stmt7.executeQuery("select doc_id from appointment where login_id='"+login_id+"'");
            while(py7.next())
                System.out.println(py7.getInt(1)); 
            
            //appointment date
            System.out.println("appointment date for patients :- ");
            Statement stmt8=con.createStatement();
            ResultSet py8=stmt8.executeQuery("select appointment_date from appointment where login_id='"+login_id+"'");
            while(py8.next())
                System.out.println(py8.getString(1));
            
            //timing
            System.out.println("appointment timing for patients :- ");
            Statement stmt9=con.createStatement();
            ResultSet py9=stmt9.executeQuery("select timing from appointment where login_id='"+login_id+"'");
            while(py9.next())
                System.out.println(py9.getString(1));
    
        case 7:
           System.exit(0 );
            
        default:
            System.out.println("Wrong choice !");        
            
    }
}


//con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
} 

       