// Name                : main.cpp
// Author              : Alex Metzger 

#include <iostream>
#include <string>
#include <fstream>
#include "InterfaceBuilder.h"
using namespace std;


int main()
{
	ifstream groceryList;  // input filestream
	int userChoice;
	bool valid = true;
	string userItem;
	InterfaceBuilder screen;

	screen.DisplayMenu();

	while (valid) {
		cin >> userChoice;  // take in user input

		// while choice is invalid, print error and ask for input  
		while (!cin || userChoice <= 0 || userChoice >= 5) {

			cin.clear();    // clears cin so the next user input will work correctly
			cout << "Not a valid selection. Please try again.\n" << endl;   // error message

			// ignores all the current characters in the input buffer up to and including the newline character
			cin.ignore(numeric_limits<streamsize>::max(), '\n');

			cin >> userChoice;
		}

		// call function based on user's input
		switch (userChoice) {
		case 1:
			screen.CallProcedure("PrintItemFrequencies");
			screen.DisplayMenu();  // Go back to menu
			break;

		case 2:
			screen.PrintSpeceficItemFrequency();
			screen.DisplayMenu();  // Go back to menu
			break;

		case 3:
			screen.CallProcedure("CreateFrequencyFile");
			screen.PrintHistogram();
			screen.DisplayMenu();  // Go back to menu
			break;

		case 4:
			cout << "Exitting..." << endl;
			valid = false;
			break;
		}

	}

	return 0;
}

