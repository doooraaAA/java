package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import device.Electronics;


public class Arrangement {
	int index = 0;
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);
	
	ArrayList<Electronics> device=new ArrayList<Electronics>();
	
	public static void main(String[] args) throws IOException {
		
		Arrangement arr=new Arrangement();
		
		arr.menu();
	}

	private void menu() throws IOException {
		
		int choice = getChoice();
		
		while (choice != 0) {
			
			if (choice == 1) {
				addANewDevice();
			} else if (choice == 2) {
				deleteADevice();
			} else if (choice == 3) {
				showAllDevices();
			} else if (choice == 4) {
				inquireDeviceInformation();
			} else if (choice == 5) {
				
			} else if (choice == 6) {
				
			}

			choice = getChoice();
		}
	}
	
	
	private int getChoice() throws IOException {

		do {

			int input;

			try {
				stdErr.println();
				stdErr.print("[0]  Quit\n"
						   + "[1]  Add a new device\n" 
						   + "[2]  Delete a device\n"
						   + "[3]  Show all devices\n"
						   + "[4]  Inquire device information\n" 
						   + "choice>");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				if (0 <= input && 4 >= input) {

					return input;

				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);
	}
	
	
	private void addANewDevice() {
		Electronics newDevice = new Electronics();
		System.out.println("What's your device's name?");
		newDevice.getName();
		System.out.println("What's your device's Properties?");
		
		System.out.println("Weight:");
		newDevice.getWeight();
		
		System.out.println("Price:");
		newDevice.getprice();
		
		System.out.println("Manufacturer:");
		newDevice.getManufacturer();
		
		System.out.println("PowerConsuption:");
		newDevice.getPowerConsumption();
		
		device.add(newDevice);
	}
	
	private void deleteADevice() {
		System.out.println("What's the device's number?");
		Scanner scan = new Scanner(System.in);
		int ind=scan.nextInt();
		device.remove(ind-1);
		System.out.println("The device is deleted!");
		index--;
	}
	
	private void showAllDevices() {
		for(int i=0;i<device.size();i++) {
			System.out.println(i+1+":"+device.get(i).name);
		}
	}
	
	private void inquireDeviceInformation() {
		int cnt=0;
		System.out.println("What's your device's name?");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		for(int i = 0;i<device.size();i++) {
				if(device.get(i).name.equals(name)) {
					device.get(i).printName();
					cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("The device is not found!");
		}
	}
}
