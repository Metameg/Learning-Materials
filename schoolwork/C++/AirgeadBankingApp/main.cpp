// Name                : main.cpp
// Author              : Alex Metzger 

#include "BankAccount.h"
#include <iostream>
using namespace std;

int main() {
	BankAccount userAccount;
	bool titleWithDeposits = false;
	bool quit = false;
	char input;
	bool valid;
	
	do {
		userAccount.setInputs();  // gets input from user

		// pauses waiting for key to be pressed before continuing
		system("pause");
		cout << endl;

		userAccount.displayInputField();  // prints input field to the screen

		cout << endl;

		// Generate report without monthly deposits
		userAccount.printHeader(titleWithDeposits);
		userAccount.generateReportWithDeposits();

		titleWithDeposits = true; // Change the header title
		cout << endl << endl << endl;

		// Generate report with monthly deposits
		userAccount.printHeader(titleWithDeposits);
		userAccount.generateReportWithDeposits(userAccount.getMonthlyDeposit());

		// Asks if user wants to continue
		// Continue asking for input until either y or n is entered
		valid = false;
		while (!valid) {
			try {
				cout << endl;
				cout << "Try another report? (y/n)" << endl;
				cin >> input;

				if (input == 'y') {
					valid = true;
				}
				else if (input == 'n') {
					// quit system
					cout << "Exitting Application..." << endl;
					quit = true;
					valid = true;
				}
				else {
					// Invalid input throws exception
					throw runtime_error("Enter either 'y' or 'n'.");
				}
			}
			catch (runtime_error& excpt) {
				cout << excpt.what() << endl;
			}

		}
	} while (!quit);
}