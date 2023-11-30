# Prompt the user to input a list of numbers separated by spaces
numbers = input("Enter a list of numbers separated by spaces: ")
numbers_list = numbers.split()

# Calculate the sum of all numbers
sum_of_numbers = 0
for number in numbers_list:
    sum_of_numbers += int(number)

# Output the sum
print("The sum of all numbers is:", sum_of_numbers)