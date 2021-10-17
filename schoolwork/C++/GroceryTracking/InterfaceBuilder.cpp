#define NOMINMAX
#define _CRT_SECURE_NO_WARNINGS
#include <cstdlib>
#include <Python.h>
#include <iostream>
#include <Windows.h>
#include <cmath>
#include <string>
#include <fstream>
#include <vector>
#include <iomanip>
#include "InterfaceBuilder.h"

using namespace std;

/*
Description:
	To call this function, simply pass the function name in Python that you wish to call.
Example:
	callProcedure("printsomething");
Output:
	Python will print on the screen: Hello from python!
Return:
	None
*/
void InterfaceBuilder::CallProcedure(string pName)
{
	char* procname = new char[pName.length() + 1];
	std::strcpy(procname, pName.c_str());

	Py_Initialize();
	PyObject* my_module = PyImport_ImportModule("GroceryTracking");
	PyErr_Print();
	PyObject* my_function = PyObject_GetAttrString(my_module, procname);
	PyObject* my_result = PyObject_CallObject(my_function, NULL);
	Py_Finalize();

	delete[] procname;
}

/*
Description:
	To call this function, pass the name of the Python functino you wish to call and the string parameter you want to send
Example:
	int x = callIntFunc("PrintMe","Test");
Output:
	Python will print on the screen:
		You sent me: Test
Return:
	100 is returned to the C++
*/
int InterfaceBuilder::callIntFunc(string proc, string param)
{
	char* procname = new char[proc.length() + 1];
	std::strcpy(procname, proc.c_str());

	char* paramval = new char[param.length() + 1];
	std::strcpy(paramval, param.c_str());


	PyObject* pName, * pModule, * pDict, * pFunc, * pValue = nullptr, * presult = nullptr;
	// Initialize the Python Interpreter
	Py_Initialize();
	// Build the name object
	pName = PyUnicode_FromString((char*)"GroceryTracking");
	// Load the module object
	pModule = PyImport_Import(pName);
	// pDict is a borrowed reference 
	pDict = PyModule_GetDict(pModule);
	// pFunc is also a borrowed reference 
	pFunc = PyDict_GetItemString(pDict, procname);
	if (PyCallable_Check(pFunc))
	{
		pValue = Py_BuildValue("(z)", paramval);
		PyErr_Print();
		presult = PyObject_CallObject(pFunc, pValue);
		PyErr_Print();
	}
	else
	{
		PyErr_Print();
	}
	//printf("Result is %d\n", _PyLong_AsInt(presult));
	Py_DECREF(pValue);
	// Clean up
	Py_DECREF(pModule);
	Py_DECREF(pName);
	// Finish the Python Interpreter
	Py_Finalize();

	// clean 
	delete[] procname;
	delete[] paramval;


	return _PyLong_AsInt(presult);
}

/*
Description:
	To call this function, pass the name of the Python functino you wish to call and the string parameter you want to send
Example:
	int x = callIntFunc("doublevalue",5);
Return:
	25 is returned to the C++
*/
int InterfaceBuilder::callIntFunc(string proc, int param)
{
	char* procname = new char[proc.length() + 1];
	std::strcpy(procname, proc.c_str());

	PyObject* pName, * pModule, * pDict, * pFunc, * pValue = nullptr, * presult = nullptr;
	// Initialize the Python Interpreter
	Py_Initialize();
	// Build the name object
	pName = PyUnicode_FromString((char*)"GroceryTracking");
	// Load the module object
	pModule = PyImport_Import(pName);
	// pDict is a borrowed reference 
	pDict = PyModule_GetDict(pModule);
	// pFunc is also a borrowed reference 
	pFunc = PyDict_GetItemString(pDict, procname);
	if (PyCallable_Check(pFunc))
	{
		pValue = Py_BuildValue("(i)", param);
		PyErr_Print();
		presult = PyObject_CallObject(pFunc, pValue);
		PyErr_Print();
	}
	else
	{
		PyErr_Print();
	}
	//printf("Result is %d\n", _PyLong_AsInt(presult));
	Py_DECREF(pValue);
	// Clean up
	Py_DECREF(pModule);
	Py_DECREF(pName);
	// Finish the Python Interpreter
	Py_Finalize();

	// clean 
	delete[] procname;

	return _PyLong_AsInt(presult);
}

// Displays Menu for user choice selection
void InterfaceBuilder::DisplayMenu() {
	cout << "\nSelect an option" << endl;
	cout << " 1. Print All Item Frequencies " << endl;
	cout << " 2. Print Specefic Item Frequency" << endl;
	cout << " 3. Print Item Histogram" << endl;
	cout << " 4. Exit" << endl;
}

void InterfaceBuilder::PrintSpeceficItemFrequency() {
	string item;
	int frequency;

	// Get user input
	cout << "Search: ";
	cin >> item;

	// Store value of frequency for item
	frequency = callIntFunc("GetSpeceficItemFrequency", item);

	// GetSpeceficItemFrequency returns -1 if item is not in grocery list
	if (frequency == -1) {
		cout << "\n" << item << " was not found in grocery list" << endl;
	}
	else {
		cout << "\n" << item << " found..." << endl;
		cout << "Total Purchases: " << frequency << endl;
	}
}

// Sets font color based on int value
void InterfaceBuilder::SetColor(int value) {
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), value); 
}

// Prints formatted histogram to console
void InterfaceBuilder::PrintHistogram() {
	ifstream inFile;     // input file stream
	string item;
	int freq;
	
	cout << "HISTOGRAM OF ITEMS PURCHASED" << endl;
	cout << "(red = low frequency, white = med frequency, green = high frequency)" << endl << endl;

	try {
		inFile.open("frequency.dat"); // open file for reading from

		if (!inFile.is_open()) {
			throw runtime_error("Could not open file frequency.dat");
		}

		inFile >> item; // Read first item
		while (!inFile.fail()) {
			// Continue while item is succesfully read

			// attempt to read frequency
			inFile >> freq;

			if (inFile.fail()) {
				throw runtime_error("Error reading frequency for item.");
			}

			else {
				// set gap between item name and frequency bar
				int gap = 15 - (int)item.length();

				// Set font colors based on frequency value
				if (freq <= 3) {
					SetColor(RED);
				}
				else if (freq > 3 && freq <= 7) {
					SetColor(WHITE);
				}
				else {
					SetColor(GREEN);
				}

				// print gap
				cout << item << setw(gap) << "";

				// print frequency bar
				for (int i = 0; i < freq; ++i) {
					cout << " *";
				}
				cout << endl;
			}
			inFile.ignore(); // clear newline
			inFile >> item;  // Read next item
		}
	}

	catch (runtime_error& excpt) {
		cout << excpt.what() << endl;
		cout << " " << item;
	}
	SetColor(WHITE);
	inFile.close();
}