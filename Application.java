package toDoList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
	
	public static ArrayList<String> tasks = new ArrayList<String>();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	  
		
		int choice;
		
		while(true) {
		System.out.println("1.Add task");
		System.out.println("2.Edit task");
		System.out.println("3.Complete task");
		System.out.println("4.View tasks");
		System.out.println("5.Exit ");
		
		
		try {
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				addTask();
				break;
			case 2:
				editTask();
				break;
			case 3:
				completeTask();
				break;
			
			case 4:
				viewTasks();
		        break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid choice, please try again.");
				break;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter a number.");
			scanner.nextLine();
		}
	}
		
	}
	
	public static void addTask() {
		
		System.out.println("Enter task: ");
		tasks.add(scanner.next());
		System.out.println("Task added!");
	}
	
	public static void completeTask() {
		viewTasks();
		System.out.println("Enter the task number you would like to complete:");
		int choice = scanner.nextInt();
		if(choice > tasks.size() || choice <= 0 ) {
			System.out.println("Task doesn't exist.");
		}
		tasks.remove(choice);
	}
	
	public static void editTask() {
		int taskNum;
        String newTask;

        viewTasks();
        System.out.print("Enter task number to edit: ");
        try {
            taskNum = scanner.nextInt();
            if (taskNum <= 0 || taskNum > tasks.size()) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("Enter new task description: ");
            newTask = scanner.next();
            tasks.set(taskNum-1, newTask);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
	}
	
	public static void viewTasks() {
		
		if(tasks.isEmpty()) {
			System.out.println("No tasks available.");
			System.exit(0);
		}else {
			for(int i=0; i < tasks.size();i++) {
				System.out.println(i+1 + "." + tasks.get(i));
			}
		}
	}
	
	
	public static void exit() {
		System.out.println("Exiting program.");
		System.exit(0);
	}

}
