# Write a program that remove all vowels from the input word and generate a brief version of it.
import math


def remove_vowels(word):
    for char in word:
        if(char == 'a' or char == 'e' or char == 'o' or char == 'u' or char == 'i'):
            word = word.replace(char,"")
        return word
print(remove_vowels("asaad"))

# Character Locator
def char_locator(word,letter,list):
    for i in range(len(word)):
        if (word[i] == letter):
            list.append(i)
    return list
print(char_locator("asaad",'a',[]))

# Multiplication Table
def multiplication_table(number,result):
    for i in range(1,number+1):
        list1 = []
        for j in range(1,i+1):
            list1.append(j * i)
        result.append(list1)
    return result
print(multiplication_table(3,[]))

# Calculate Area
# Write a function that calculate the area of these shapes:
# triangle = (0.5 * base * height), rectangle = (width * height), Circle= (PI * radius ^ 2)
def calc_area(shape,*args):
    if (shape == 't'):
        return 0.5 * args[0] * args[1]
    elif (shape == 'r'):
        return args[0] * args[1]
    elif (shape == 'c'):
        return math.pi * (args[0] ** 2)
    elif (shape == 's'):
        return args[0] ** 2
    else:
        return "shape not supported"
print(calc_area("s", 10))
print(calc_area("t", 10, 20))
print(calc_area("c", 10))
print(calc_area("r", 10, 20))
print(calc_area("z", 10, 20))

# Write a program convert a list of names into sorted dictionary which key is the Alpha. and value
# is a list of names corresponding to this alpha.
def names_dic(nameslist, dic):
    nameslist.sort()
    for name in nameslist:
        key = name.lower()[0]
        if key in dic:
            dic[key].append(name)
        else:
            dic[key] = [name]
    return dic

print(names_dic(["Asaad", "Ahmed", "Zain", "Ali", "Sara", "Sami"], {}))

# Write a program that build a Mario pyramid 
def right_aligned_triangle(number):
    for i in range(1, number + 1):
        for j in range(number - i):
            print(' ', end='')
        for k in range(i):
            print('*', end='')
        print()  

right_aligned_triangle(5)
