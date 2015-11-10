package firsttestngpackage;

import java.io.File;

import org.testng.annotations.Test;

public class FileHandling {
  @Test
  public void f() {
	
			try{
		        // create new file
		       
		        File f = new File("D:\\Selenium\\TestData\\test.xls");
		        
		        // tries to create new file in the system
		        boolean bool = f.createNewFile();
		        // prints
		        System.out.println("File created: "+bool);
		        // deletes file from the system
		        f.delete();
		        
		        // delete() is invoked
		        System.out.println("delete() method is invoked");
		        
		        // tries to create new file in the system
		        bool = f.createNewFile();
		        
		        // print
		        System.out.println("File created: "+bool);
		        //Create folder
		        File folder = new File("D:\\Selenium\\TestData\\Subfolder");
		        folder.mkdir();
		        System.out.println("Folder created: "+folder);
		        folder.delete();
		        System.out.println("Folder deleted: "+folder);
		     }catch(Exception e){
		        e.printStackTrace();
		     }
		}
	


  }

