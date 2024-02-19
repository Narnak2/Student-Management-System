package com.student;

import java.sql.*;

public class studentDao {
    public static boolean insertStudnetToDB(Student st){

        boolean f=false;
        try {
            //jdbc code.....
            Connection con = Cp.createC();
            String q = "insert into students(sname,sphone,scity) values(?,?,?)";
            //PreparedStatement
            PreparedStatement prepareStatement = con.prepareStatement(q);
            //set the value of parameters
            prepareStatement.setString(1, st.getStudentName());
            prepareStatement.setString(2, st.getStudentPhone());
            prepareStatement.setString(3, st.getStudentCity());

            //execute.
            prepareStatement.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }
    public static boolean deleteStudent(int userId)
    {
        boolean f=false;
        try
        {
            //jdbc code.....
            Connection con= Cp.createC();
            String q="delete from students where sid=?";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            //set the value of parameters
            pstmt.setInt(1,userId);


            //execute.
            pstmt.executeUpdate();
            f=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudent() {
        try
        {
            //jdbc code.....
            Connection con= Cp.createC();
            String q="select * from students";
            //PreparedStatement
            Statement stmt=con.createStatement();
          ResultSet set= stmt.executeQuery(q);
          while (set.next())
          {
              int id=set.getInt(1);
              String name=set.getString(2);
              String phone=set.getString(3);
              String city=set.getString("scity");
              System.out.println("ID:"+id);
              System.out.println("Name:"+name);
              System.out.println("Phone:"+phone);
              System.out.println("City:"+city);
              System.out.println("->->->->->->->->->->->->->->->->");
          }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
