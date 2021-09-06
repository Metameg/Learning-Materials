
def prime_factors(n): 
    
    prime = 2
    result_string = ""
    result_list = []

    while (prime*prime <= n):
        if n % prime == 0:
            n = n / prime
            result_list.append(prime)  
        else:
            prime += 1
           
    else:
        result_list.append(int(n))
    
    while len(result_list) > 0:
        prime_count = result_list.count(result_list[0])

        if prime_count == 1:
            result_string += "(" + str(result_list[0]) + ")"
        else:
            result_string += "(" + str(result_list[0]) + "**" + str(prime_count) + ")"

        del result_list[0:prime_count]

    return result_string

print(prime_factors(76587634333))

