import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Man
{
  public static void main (String args[])
  {
    String url = "jdbc:mysql://localhost:3306/person6";
    String user = "root";
    String pass = "dhivyadinesh";
      try
    {
      Connection myConnection = DriverManager.getConnection (url, user, pass);
      Statement myStatement = myConnection.createStatement ();
      String s = "select * from person6";
      System.out.println ("Enter  The Data in Table");
      System.out.println ("Update The Data in Table");
      System.out.println ("Delete The Data in Table");
      System.out.println ("List   All Data in Table");
      for (int Choice = 1; Choice < 10; Choice++)
	{
	  Scanner sc = new Scanner (System.in);
	    System.out.println ("Enter your Choice");
	    Choice = sc.nextInt ();
	  switch (Choice)
	    {
	    case 1:
	      System.out.println ("Inserting Data");
	      System.out.println ("Enter The Name");
	      String name = sc.next ();
	      String insertQuery ="insert into person6(name) values('" + name + "')";
	      int result = myStatement.executeUpdate (insertQuery);
	      String s1 = "select * from person6";
	      ResultSet rset1 = myStatement.executeQuery (s1);
	      while (rset1.next ())
		{
		  System.out.println (rset1.getInt ("no") + ", " +rset1.getString ("name"));
		}
	      break;
	    case 2:
	      System.out.println ("Updating Process ");
	      ResultSet rset2 = myStatement.executeQuery (s);
	      while (rset2.next ())
		{
		  System.out.println (rset2.getInt ("no") + ", " +rset2.getString ("name"));
		}
	      System.out.println ("Enter The Name To Edit");
	      name = sc.next ();
	      System.out.println ("Enter The No In Data ");
	      int no = sc.nextInt ();
	      String UpdateQuery ="update person6 set name= '" + name + "' where no =" + no +";";
	      myStatement.executeUpdate (UpdateQuery);
	      String s3 = "select * from person6";
	      ResultSet rset3 = myStatement.executeQuery (s3);
	      while (rset3.next ())
		{
		  System.out.println (rset3.getInt ("no") + ", " +rset3.getString ("name"));
		}
	      break;
	    case 3:
	      System.out.println ("Deleting process");
	      System.out.println ("Enter The Name to Delete ");
	      no = sc.nextInt ();
	      String DeleteQuery = "delete from person6 where no=" + no + ";";
	      myStatement.executeUpdate (DeleteQuery);
	      String s4 = "select * from person6";
	      ResultSet rset4 = myStatement.executeQuery (s4);
	      while (rset4.next ())
		{
		  System.out.println (rset4.getInt ("no") + ", " +rset4.getString ("name"));
		}
	      break;
	    case 4:
	      String s5 = "select * from person6";
	      ResultSet rset5 = myStatement.executeQuery (s5);
	      while (rset5.next ())
		{
		  System.out.println (rset5.getInt ("no") + "," +rset5.getString ("name"));
		}
	      break;
	    }
	}
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }
}

