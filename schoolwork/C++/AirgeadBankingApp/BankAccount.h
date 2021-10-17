#ifndef AIRGEADBANKINGAPP_BankAccount_H_
#define AIRGEADBANKINGAPP_BankAccount_H_

#include <string>

class BankAccount {
public:
	BankAccount(); // constructor
	
	// Accessor Functions
	double getInitialInvestment() {
		return m_initialInvestment;
	}
	double getMonthlyDeposit() {
		return m_monthlyDeposit;
	}
	double getAnnualInterest() {
		return m_annualInterest;
	}
	double getNumYears() {
		return m_numYears;
	}

	void displayInputField() const;
	void setInputs();
	void generateReportWithDeposits(double t_deposit = 0.0);
	void printHeader(bool t_titleWithDeposits) const;
	
private:
	double m_initialInvestment;
	double m_monthlyDeposit;
	double m_annualInterest;
	double m_numYears;

	void validateInput(std::string t_message, double& t_input);
	double convertYearsToMonths(double t_years);
	void printReportRow(int t_month, double t_total, double t_totalInterest);
	
};

#endif
