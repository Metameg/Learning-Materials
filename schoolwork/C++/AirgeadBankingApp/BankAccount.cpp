#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#include "BankAccount.h"
using namespace std;

// default constructor
BankAccount::BankAccount() {
	m_initialInvestment = -1;
	m_monthlyDeposit = -1;
	m_annualInterest = -1;
	m_numYears = -1;
}


// ---------------------------- Public Functions -----------------------

// Prompts user to enter input values
void BankAccount::setInputs() {
	
	string inputMessage = "Initial Investment: $";

	// prints header of input field screen
	cout << setfill('*') << endl;
	cout << setw(8) << "" << "Data Input" << setw(12) << "" << endl;

	cout << inputMessage;
	cin >> m_initialInvestment;
	validateInput(inputMessage, m_initialInvestment); // validates input

	inputMessage = "Monthly Deposit: $";
	cout << inputMessage;
	cin >> m_monthlyDeposit;
	validateInput(inputMessage, m_monthlyDeposit);  // validates input

	inputMessage = "Annual Interest: %";
	cout << inputMessage;
	cin >> m_annualInterest;
	validateInput(inputMessage, m_annualInterest);  // validates input

	inputMessage = "Number of Years: ";
	cout << inputMessage;
	cin >> m_numYears;
	validateInput(inputMessage, m_numYears);  // validates input

}

// Prints Input field with user values to console
void BankAccount::displayInputField() const{

	cout << setfill('*') << endl;
	cout << setw(8) << "" << "Data Input" << setw(12) << "" << endl;

	cout << "Initial Investment: $" << this->m_initialInvestment << endl;
	cout << "Monthly Deposit: $" << this->m_monthlyDeposit << endl;
	cout << "Annual Interest: %" << this->m_annualInterest << endl;
	cout << "Number of years: " << this->m_numYears << endl;
}

// Generates report based on user inputs and a monthly compounded interest rate
void BankAccount::generateReportWithDeposits(double t_deposit) {
	double numMonths;
	double total;
	double interestEarned;
	double yearlyInterest = 0.0;
	
	
	numMonths = convertYearsToMonths(getNumYears());
	total = getInitialInvestment();

	for (int currMonth = 0; currMonth < numMonths; ++currMonth) {
		// Updates total amount in account after deposit
		total += t_deposit;
		
		// Calculates interest earned based on total amount and compounded monthly
		interestEarned = (total) * ((getAnnualInterest() / 100) / 12);

		// Add interest to yearly interest counter and total amount in account
		yearlyInterest += interestEarned;
		total += interestEarned;
		
		// Print info to console every 12 months
		if ((currMonth + 1) % 12 == 0) {
			printReportRow((currMonth / 12) + 1, total, yearlyInterest);
			yearlyInterest = 0; // reset yearly interest counter
		}
		
	}
}

// Prints header information to console
void BankAccount::printHeader(bool t_withDeposits) const {
	
	if (t_withDeposits) {
		cout << setfill(' ') << setw(5) << "" << "Balance and Interest With Additional Monthly Deposits" << setw(5) << "" << endl;
	}
	else {
		cout << setfill(' ') << setw(5) << "" << "Balance and Interest Without Additional Monthly Deposits" << setw(5) << "" << endl;
	}
	cout << setfill('~') << setw(64) << "" << endl << endl;
	
	cout << setfill(' ') << "Year" << setw(9) << "" << "Year End Balance" << setw(5) << "" << "Year End Earned Interest" << endl;

	cout << setfill('-') << setw(60) << "" << endl;

	
}



// -------------------- Private Functions ----------------------------------------

// Prints formatted table of bank account information
void BankAccount::printReportRow(int t_month, double t_total, double t_totalInterest) {
	cout << setfill(' ') << setprecision(2) << fixed
		 << setw(3) <<  t_month << setw(24) << t_total << setw(28) << t_totalInterest << endl;
}

double BankAccount::convertYearsToMonths(double t_years) {
	double months = t_years * 12;
	months = ceil(months); // rounds the number of months up to nearest whole number

	return months;
}

// input validity checker
void BankAccount::validateInput(string t_message, double& t_input) {

	// while choice is invalid, print error and ask for input  
	while (!cin || t_input < 0) {

		cin.clear();    // clears cin so the next user input will work correctly

		cout << "Not a valid number. Please try again.\n" << endl;   // error message
		cout << t_message;

		// ignores all the current characters in the input buffer up to and including the newline character
		cin.ignore(numeric_limits<streamsize>::max(), '\n');

		cin >> t_input;
	}

}