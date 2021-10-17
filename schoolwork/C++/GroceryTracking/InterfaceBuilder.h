#ifndef INTERFACE_BUILDER_H_
#define INTERFACE_BUILDER_H_

class InterfaceBuilder {
public:
	void DisplayMenu();
	void PrintSpeceficItemFrequency();
	void PrintHistogram();
	void CallProcedure(std::string pName);
	int callIntFunc(std::string proc, std::string param);
	int callIntFunc(std::string proc, int param);

private:
	void SetColor(int value);
	const int RED = 4;
	const int WHITE = 7;
	const int GREEN = 2;
};

#endif
