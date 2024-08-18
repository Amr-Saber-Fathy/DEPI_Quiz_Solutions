package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import facility.Equipment;
import facility.GymHall;
import papers.ExercisePlan;
import papers.Subscription;
import people.Admin;
import people.Manager;
import people.Trainee;
import people.Trainer;

public class SQLConnection {

	static String url = "jdbc:mysql://localhost:3306/";
	static String user = "Amr";
	static String password = "Amr_12saber";
    
    // Database name to be created
	static String databaseName = "Gym";

    // SQL statement to create a new database
	static String createDatabaseSQL = "CREATE DATABASE " + databaseName;

    // Connection and Statement objects
	static Connection connection = null;
	static Statement statement = null;
    
/////////////////////////////////////////////////////////////////////////////
	
	public static void deleteDB() 
    {
		try {
    		connection = DriverManager.getConnection(url, user, password);
    		// Create a Statement object
            statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE " + databaseName);
            
            //Close the connection
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Deleted Successfully");
    	}
    	catch (SQLException e) {
    		System.out.println("Can't connect to the Database" + e.getMessage());
    	}
    }
	
    public static void createDB() 
    {
    	try {
    		connection = DriverManager.getConnection(url, user, password);
    		// Create a Statement object
            statement = connection.createStatement();
            statement.executeUpdate(createDatabaseSQL);
            
            //Close the connection
            if (statement != null) statement.close();
            if (connection != null) connection.close();
    	}
    	catch (SQLException e) {
    		System.out.println("Can't connect to the Database" + e.getMessage());
    	}
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public static void createTables() 
    {
        // SQL statements to create tables
        String createPersonTable = "CREATE TABLE Person ("
                + "Id INT PRIMARY KEY, "
                + "Name VARCHAR(255), "
                + "Age INT, "
                + "Email VARCHAR(255), "
                + "PhoneNumber VARCHAR(20), "
                + "Password VARCHAR(255)"
                + ");";

        String createTrainerTable = "CREATE TABLE Trainer ("
                + "Id INT PRIMARY KEY, "
                + "WorkingHours INT, "
                + "GymHallId INT, "
                + "Rating DECIMAL(3, 2), "
                + "Salary DECIMAL(10, 2), "
                + "FOREIGN KEY (Id) REFERENCES Person(Id), "
                + "FOREIGN KEY (GymHallId) REFERENCES GymHall(Id)"
                + ");";

        String createTraineeTable = "CREATE TABLE Trainee ("
                + "Id INT PRIMARY KEY, "
                + "SubscriptionId INT, "
                + "ExercisePlanId INT, "
                + "Points INT, "
                + "FOREIGN KEY (Id) REFERENCES Person(Id), "
                + "FOREIGN KEY (SubscriptionId) REFERENCES Subscription(Id), "
                + "FOREIGN KEY (ExercisePlanId) REFERENCES ExercisePlan(Id)"
                + ");";

        String createAdminTable = "CREATE TABLE Admin ("
                + "Id INT PRIMARY KEY, "
                + "FOREIGN KEY (Id) REFERENCES Person(Id)"
                + ");";

        String createManagerTable = "CREATE TABLE Manager ("
                + "Id INT PRIMARY KEY, "
                + "FOREIGN KEY (Id) REFERENCES Person(Id)"
                + ");";

        String createGymHallTable = "CREATE TABLE GymHall ("
                + "Id INT PRIMARY KEY, "
                + "Name VARCHAR(255)"
                + ");";
        
        String createEquipmentTable = "CREATE TABLE Equipment ("
                + "Id INT PRIMARY KEY, "
                + "Name VARCHAR(255), "
                + "Type VARCHAR(255)"
                + ");";


        String createGymHallEquipmentTable = "CREATE TABLE GymHall_Equipment ("
                + "GymHallId INT, "
                + "EquipmentId INT, "
                + "PRIMARY KEY (GymHallId, EquipmentId), "
                + "FOREIGN KEY (GymHallId) REFERENCES GymHall(Id), "
                + "FOREIGN KEY (EquipmentId) REFERENCES Equipment(Id)"
                + ");";

        String createExercisePlanTable = "CREATE TABLE ExercisePlan ("
                + "Id INT PRIMARY KEY, "
                + "Steps TEXT, "
                + "Duration INT"
                + ");";

        String createSubscriptionTable = "CREATE TABLE Subscription ("
                + "Id INT PRIMARY KEY, "
                + "Type VARCHAR(255), "
                + "StartDate DATE, "
                + "EndDate DATE, "
                + "Price DECIMAL(10, 2), "
                + "Discount DECIMAL(5, 2)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url+databaseName, user, password);
             Statement stmt = conn.createStatement()) {

            // Execute SQL statements
        	stmt.executeUpdate(createGymHallTable);
        	stmt.executeUpdate(createExercisePlanTable);
            stmt.executeUpdate(createSubscriptionTable);
            stmt.executeUpdate(createPersonTable);
            stmt.executeUpdate(createTrainerTable);
            stmt.executeUpdate(createTraineeTable);
            stmt.executeUpdate(createAdminTable);
            stmt.executeUpdate(createManagerTable);
            stmt.executeUpdate(createEquipmentTable);
            stmt.executeUpdate(createGymHallEquipmentTable);
            

            System.out.println("Tables created successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error : " + e.getMessage());
        }
    }
    
/////////////////////////////////////////////////////////////////////////////////////////
    
    public static void insertTrainer(Trainer trainer) 
    {
    	 String sqlPerson = "INSERT INTO Person (Id, Name, Age, Email, PhoneNumber, Password) VALUES (?, ?, ?, ?, ?, ?)";
         String sqlTrainer = "INSERT INTO Trainer (Id, WorkingHours, GymHallId, Rating, Salary) VALUES (?, ?, ?, ?, ?)";
         
         try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
             conn.setAutoCommit(false);  // Start transaction
             
             try (PreparedStatement psPerson = conn.prepareStatement(sqlPerson);
                  PreparedStatement psTrainer = conn.prepareStatement(sqlTrainer)) {
                  
                 // Insert into Person table
            	 psPerson.setInt(1, trainer.getPersonID());
                 psPerson.setString(2, trainer.getPersonName());
                 psPerson.setInt(3, trainer.getPersonAge());
                 psPerson.setString(4, trainer.getPersonEmail());
                 psPerson.setString(5, trainer.getPersonPhone());
                 psPerson.setString(6, trainer.getPersonPassword());
                 psPerson.executeUpdate();
                 
                 // Insert into Trainer table
                 psTrainer.setInt(1, trainer.getPersonID());
                 psTrainer.setInt(2, trainer.getWorkingHours());
                 psTrainer.setInt(3, trainer.getAssignedHall().getGymHallID());
                 psTrainer.setDouble(4, trainer.getRating());
                 psTrainer.setDouble(5, trainer.getSalary());
                 psTrainer.executeUpdate();
                 
                 conn.commit();  // Commit transaction
                 System.out.println("Trainer Inserted Successfuly");
             } catch (SQLException e) {
                 conn.rollback();  // Roll back if there's an error
                 System.out.println("Couldn't connect to the Table : " + e.getMessage());
             }
         } catch (SQLException e) {
        	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
         }
    }
    //*************************************************************************************//
    
    public static void insertTrainee(Trainee trainee) 
    {
    	String sqlPerson = "INSERT INTO Person (Id, Name, Age, Email, PhoneNumber, Password) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlTrainer = "INSERT INTO Trainee (Id, SubscriptionId, ExercisePlanId, Points) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psPerson = conn.prepareStatement(sqlPerson);
                 PreparedStatement psTrainer = conn.prepareStatement(sqlTrainer)) {
                 
                // Insert into Person table
           	 	psPerson.setInt(1, trainee.getPersonID());
                psPerson.setString(2, trainee.getPersonName());
                psPerson.setInt(3, trainee.getPersonAge());
                psPerson.setString(4, trainee.getPersonEmail());
                psPerson.setString(5, trainee.getPersonPhone());
                psPerson.setString(6, trainee.getPersonPassword());
                psPerson.executeUpdate();
                
                //"SubscriptionId INT, "
                //+ "ExercisePlanId INT, "
                //+ "Points INT, "
                // Insert into Trainer table
                psTrainer.setInt(1, trainee.getPersonID());
                psTrainer.setInt(2, trainee.getSubcription().getSubscriptionID());
                psTrainer.setInt(3, trainee.getPlan().getEcercisePlanID());
                psTrainer.setInt(4, trainee.getPoints());
                psTrainer.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("Trainee Inserted Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
    //*************************************************************************************//

    public static void insertAdmin(Admin admin) 
    {
    	 String sqlPerson = "INSERT INTO Person (Id, Name, Age, Email, PhoneNumber, Password) VALUES (?, ?, ?, ?, ?, ?)";
         String sqlAdmin = "INSERT INTO Admin (Id) VALUES (?)";
         
         try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
             conn.setAutoCommit(false);  // Start transaction
             
             try (PreparedStatement psPerson = conn.prepareStatement(sqlPerson);
                  PreparedStatement psAdmin = conn.prepareStatement(sqlAdmin)) {
                  
                 // Insert into Person table
            	 psPerson.setInt(1, admin.getPersonID());
                 psPerson.setString(2, admin.getPersonName());
                 psPerson.setInt(3, admin.getPersonAge());
                 psPerson.setString(4, admin.getPersonEmail());
                 psPerson.setString(5, admin.getPersonPhone());
                 psPerson.setString(6, admin.getPersonPassword());
                 psPerson.executeUpdate();
                 
                 // Insert into Trainer table
                 psAdmin.setInt(1, admin.getPersonID());
                 psAdmin.executeUpdate();
                 
                 conn.commit();  // Commit transaction
                 System.out.println("Admin Inserted Successfuly");
             } catch (SQLException e) {
                 conn.rollback();  // Roll back if there's an error
                 System.out.println("Couldn't connect to the Table : " + e.getMessage());
             }
         } catch (SQLException e) {
        	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
         }
    }
    //*************************************************************************************//
    
    public static void insertManager(Manager manager) 
    {
    	 String sqlPerson = "INSERT INTO Person (Id, Name, Age, Email, PhoneNumber, Password) VALUES (?, ?, ?, ?, ?, ?)";
         //String sqlAdmin = "INSERT INTO Admin (Id) VALUES (?)";
         String sqlManager = "INSERT INTO Manager (Id) VALUES (?)";
         
         try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
             conn.setAutoCommit(false);  // Start transaction
             
             try (PreparedStatement psPerson = conn.prepareStatement(sqlPerson);
                  PreparedStatement psManager = conn.prepareStatement(sqlManager)) {
                  
                 // Insert into Person table
            	 psPerson.setInt(1, manager.getPersonID());
                 psPerson.setString(2, manager.getPersonName());
                 psPerson.setInt(3, manager.getPersonAge());
                 psPerson.setString(4, manager.getPersonEmail());
                 psPerson.setString(5, manager.getPersonPhone());
                 psPerson.setString(6, manager.getPersonPassword());
                 psPerson.executeUpdate();
                 
                 // Insert into Manager table
                 psManager.setInt(1, manager.getPersonID());
                 psManager.executeUpdate();
                 
                 conn.commit();  // Commit transaction
                 System.out.println("Manager Inserted Successfuly");
             } catch (SQLException e) {
                 conn.rollback();  // Roll back if there's an error
                 System.out.println("Couldn't connect to the Table : " + e.getMessage());
             }
         } catch (SQLException e) {
        	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
         }
    }
    //*************************************************************************************//
    
    //"Id INT PRIMARY KEY, "
    //+ "Name VARCHAR(255)"
    // + ");";
    public static void insertGymHall(GymHall hall) 
    {
    	String sqlGymHall = "INSERT INTO GymHall (Id, Name) VALUES (?, ?)";
    	try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psGymHall = conn.prepareStatement(sqlGymHall)) {
                 
                // Insert into Person table
            	psGymHall.setInt(1, hall.getGymHallID());
            	psGymHall.setString(2, hall.getGymHallName());
            	psGymHall.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("GymHall Inserted Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
  //*************************************************************************************//
    
    //"Id INT PRIMARY KEY, "
    //+ "Name VARCHAR(255), "
    //+ "Type VARCHAR(255)"
    public static void insertEquipment(Equipment eq) 
    {
    	String sqlEquipment = "INSERT INTO Equipment (Id, Name, Type) VALUES (?, ?, ?)";
    	try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psEquipment = conn.prepareStatement(sqlEquipment)) {
                 
                // Insert into Person table
            	psEquipment.setInt(1, eq.getEquipmentID());
            	psEquipment.setString(2, eq.getEquipmentName());
            	psEquipment.setString(3, eq.getEquipmentType());
            	psEquipment.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("Equipment Inserted Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
  //*************************************************************************************//
    //"GymHallId INT, "
    //+ "EquipmentId INT, "
    
    public static void addEqToHall(Equipment eq, GymHall hall) 
    {
    	String sqlHall_Equipment = "INSERT INTO GymHall_Equipment (GymHallId, EquipmentId) VALUES (?, ?)";
    	try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psHall_Equipment = conn.prepareStatement(sqlHall_Equipment)) {
                 
                // Insert into Person table
            	psHall_Equipment.setInt(1, hall.getGymHallID());
            	psHall_Equipment.setInt(2, eq.getEquipmentID());
            	psHall_Equipment.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("Equipment Added Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
  //*************************************************************************************//
    
//    String createSubscriptionTable = "CREATE TABLE Subscription ("
//            + "Id INT PRIMARY KEY, "
//            + "Type VARCHAR(255), "
//            + "StartDate DATE, "
//            + "EndDate DATE, "
//            + "Price DECIMAL(10, 2), "
//            + "Discount DECIMAL(5, 2)"
//            + ");";
    
    public static void insertSubscription(Subscription sub) 
    {
    	String sqlSubscription = "INSERT INTO Subscription (Id, Type, StartDate, EndDate, Price, Discount) VALUES (?, ?, ?, ?, ?, ?)";
    	try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psSubscription = conn.prepareStatement(sqlSubscription)) {
                
            	// Converting LocalDate to Date
//            	String startDate = sub.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            	String endDate = sub.getEndtDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            	
                // Insert into Person table
            	psSubscription.setInt(1, sub.getSubscriptionID());
            	psSubscription.setString(2, sub.getSubscriptionType());
            	psSubscription.setDate(3, java.sql.Date.valueOf(sub.getStartDate()));
            	psSubscription.setDate(4, java.sql.Date.valueOf(sub.getEndtDate()));
            	psSubscription.setDouble(5, sub.getPrice());
            	psSubscription.setDouble(6, sub.getDiscount());
            	psSubscription.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("Subscripion Inserted Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
  //*************************************************************************************//
    
//  String createExercisePlanTable = "CREATE TABLE ExercisePlan ("
//  + "Id INT PRIMARY KEY, "
//  + "Steps TEXT, "
//  + "Duration INT"
//  + ");";
    
    public static void insertExercisePlan(ExercisePlan exPlan) 
    {
    	String sqlExercisePlan = "INSERT INTO ExercisePlan (Id, Steps, Duration) VALUES (?, ?, ?)";
    	try (Connection conn = DriverManager.getConnection(url+databaseName, user, password)) {
            conn.setAutoCommit(false);  // Start transaction
            
            try (PreparedStatement psExercisePlan = conn.prepareStatement(sqlExercisePlan)) {
                
            	// Converting List of Steps (Strings) into one String
            	String steps = "";
            	for(String step : exPlan.getExerciseSteps()) {
            		steps += step + "\t";
            	}
            	
                // Insert into Person table
            	psExercisePlan.setInt(1, exPlan.getEcercisePlanID());
            	psExercisePlan.setString(2, steps);
            	psExercisePlan.setInt(3, exPlan.getExerciseDuration());
            	psExercisePlan.executeUpdate();
                
                conn.commit();  // Commit transaction
                System.out.println("Exersice Plan Inserted Successfuly");
            } catch (SQLException e) {
                conn.rollback();  // Roll back if there's an error
                System.out.println("Couldn't connect to the Table : " + e.getMessage());
            }
        } catch (SQLException e) {
       	 System.out.println("Couldn't connect to the Database : " + e.getMessage());
        }
    }
}
