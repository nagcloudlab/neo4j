

# create list with 10 numbers

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# create new List with only even numbers

list_even=[]
for number in numbers:
    if number % 2 == 0:
        list_even.append(number)

print(list_even)


# list comprehension

list_even = [number for number in numbers if number % 2 == 0]

print(list_even)
