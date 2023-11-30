# Given tuple
num_tuple = input("Enter Elements: ")
my_tuple = tuple(num_tuple.split(","))

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in my_tuple:
    if (num % 5 == 0):
        print(num)
