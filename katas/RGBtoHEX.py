def rgb(r,g,b):
    hex_letter = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    rgb_list = [r,g,b]
    numbers_list = []
    
    for i in rgb_list:
        if i > 255: i = 255
        elif i < 0: i = 0
            
        num1 = i // 16
        num2 = i % 16
        
        numbers_list.append(num1)
        numbers_list.append(num2)
  
    for i in numbers_list:
        if i >= 10:
            temp = numbers_list.index(i) 
            numbers_list[temp] = hex_letter[i]        
        else:
            temp = numbers_list.index(i) 
            numbers_list[temp] = str(i)        
    return ''.join(numbers_list)

