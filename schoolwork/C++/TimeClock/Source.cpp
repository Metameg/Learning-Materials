// Name                : P1clock.cpp
// Author              : Alex Metzger 


#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <iomanip>
#include <ctime> 

using namespace std;


void DisplayMenu() {
	// Displays the optios to the user.
	cout << "Select an option" << endl;
	cout << setfill('*') << setw(20) << "" << endl;
	cout << " 1. Add one hour" << endl;
	cout << " 2. Add one minute" << endl;
	cout << " 3. Add one second" << endl;
	cout << " 4. Exit" << endl;
	cout << setfill('*') << setw(20)<< "" << endl;

}

void DisplayClocks(tm *tm_local) {
	// Displays the two clocks

	int hour12; // 12-hour clock hour number

	// if hours on 24-hour clock is > 12, change the value of hours on 12-hour clock
	// special case is on the hour 24, at which point the 24-hour clock should roll 
	// back to 0 and the 12-hour clock should equal 12
	if (tm_local->tm_hour == 24) {
		tm_local->tm_hour = 0;
		hour12 = 12;
	}
	else if (tm_local->tm_hour > 12) {
		hour12 = (tm_local->tm_hour) - 12;
	}

	else {
		hour12 = tm_local->tm_hour;
	}

	// Prints top border made of *'s
	cout << setfill('*') << setw(25) << "" << setfill(' ') << setw(12) << "" << setfill('*') << setw(25) << "" << endl; 

	// changes fill back to empty spaces
	cout << setfill(' '); 

	// Clock Labels
    cout << setw(6) << "" << "12 hour clock" << setw(25) << "" << "24 hour clock" << endl;
	// 12 hour clock
	cout << setw(8) << "" << hour12 << ":" << tm_local->tm_min << ":" << tm_local->tm_sec << setw(12) << "";
	// 24 hour clock
	cout << setw(19) << "" << tm_local->tm_hour << ":" << tm_local->tm_min << ":" << tm_local->tm_sec << endl;

	// Prints bottom border made of *'s
	cout << setfill('*') << setw(25) << "" << setfill(' ') << setw(12) << "" << setfill('*') << setw(25) << "" << endl;

}

void AddHour(tm *tm_local) {
	
	// add an hour if the hours in tm_local is < 24, else subtract 24 from tm_local->hour
	// to display correct hour on 24-hour clock. 12-hour clock time is handled in
	// DisplayClocks()
	if (tm_local->tm_hour < 24) {
	tm_local->tm_hour += 1;
	}
	else {
		tm_local->tm_hour -= 24;
	}

	cout << endl; // add space

	DisplayClocks(tm_local); // show the clocks 
	
	cout << endl << endl; // add spaces

	DisplayMenu();  // show menu
}

void AddMinute(tm *tm_local) {
	
	// special case when minute is 59, an hour should be added once function is called
	if (tm_local->tm_min == 59) {
		AddHour(tm_local);

	}
	
	// add a minute until tm_local->minute is 59, at which point roll back to 0 
	// by subtracting 59
	if (tm_local->tm_min < 59) {
		tm_local->tm_min += 1;
	}
	else {
		tm_local->tm_min -= 59;
	}

	cout << endl; // add space

	DisplayClocks(tm_local); // show the clocks 

	cout << endl << endl; // add spaces

	DisplayMenu();  // show menu
}

void AddSecond(tm *tm_local) {
	// special case when second is 59, a minute should be added once function is called
	if (tm_local->tm_sec == 59) {
		AddMinute(tm_local);

	}

	// add a second until tm_local->second is 59, at which point roll back to 0 
	// by subtracting 59
	if (tm_local->tm_sec < 59) {
		tm_local->tm_sec += 1;
	}

	else {
		tm_local->tm_sec -= 59;
	}

	cout << endl; // add space

	DisplayClocks(tm_local); // show the clocks 

	cout << endl << endl; // add spaces

	DisplayMenu();  // show menu
}

int main() {

	int userChoice;
	bool valid = true;

	time_t current_time = time(0);

	// sets local time from ctime's time() function and stores it into pointer variable
	tm *tm_local = localtime(&current_time);  

	DisplayClocks(tm_local);
	cout << endl << endl;
	DisplayMenu();


    while (valid) {
		cin >> userChoice;  // take in user input

		// while choice is invalid, print error and ask for input  
		while (!cin || userChoice >= 5) { 

			cin.clear();    // clears cin so the next user input will work correctly

			cout << "Not a valid number. Please try again.\n" << endl;   // error message

			// ignores all the current characters in the input buffer up to and including the newline character
			cin.ignore(numeric_limits<streamsize>::max(), '\n');   

			cin >> userChoice;
		}

		// call function based on user's input
		switch (userChoice) {
			case 1:
				AddHour(tm_local);
				break;
			case 2:
				AddMinute(tm_local);
				break;
			case 3:
				AddSecond(tm_local);
				break;
			case 4:
				cout << "Exitting..." << endl;
				valid = false;
				break;
		}
	}

	return 0;
}

