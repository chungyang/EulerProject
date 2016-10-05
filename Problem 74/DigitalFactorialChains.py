#!/usr/bin/python

factorials = {'0': 1,'1': 1,'2': 2,'3': 6,'4': 24,'5': 120,'6': 720,'7': 5040,'8':40320,'9':362880}
isCalculated = []
calculated_chains_length = []

#Initialize
for i in range(0,1000000):
        isCalculated.append(False)
        calculated_chains_length.append(0)

def getNextNumber(number):
    number_string = str(number)
    next_number = 0
    for index in range(len(number_string)):
        next_number += factorials[number_string[index]]
        
    return next_number;
    

def calculateChainLength(number):
    number_in_chain = [number]
    chain_length = 0
    is_repeated = False

    while(is_repeated != True):

            next_number = getNextNumber(number_in_chain[chain_length])

            if(next_number < 1000000):
                if(isCalculated[next_number] == True):
                    isCalculated[number] = True
                    calculated_chains_length[number] = chain_length + calculated_chains_length[next_number] + 1
                    return  calculated_chains_length[number]
    
            #print("next number is " + str(next_number) + "\n")
            for index in range(len(number_in_chain)):
                
                #print(str(number_in_chain[index]) + "\n")
                if(number_in_chain[index] == next_number):
                    #print("repeated\n")
                    is_repeated = True
                    break;
                #else:
                   #print("not repeated\n")

            if(is_repeated != True):
                number_in_chain.append(next_number)
                chain_length += 1

    #plus one to compenstate for the first number added to the chain
    isCalculated[number] = True
    calculated_chains_length[number] = chain_length + 1
    return calculated_chains_length[number]

def solve():
    
    sol = 0
    
    for index in range (0,1000000):
        length = calculateChainLength(index)
        if(length == 60):
            sol += 1
           
    return sol        
    
print(str(solve()))
        
