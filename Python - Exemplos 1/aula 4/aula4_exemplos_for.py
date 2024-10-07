#Laços de repetição
#for var_controle in sequencia: instruções  - var_controle: variavel q controla a interação     -sequencia: objeto de sequencia

numero = int(input("Digite um número para ver a Tabuada: "))
for i in range(11): #A função range é útil qunado precisamos criar sequências de números em um loop ou em uma situação onde é necessário gerar uma série de valores.
    print(numero*i) # O último número do range não é executado
print("fim\n")
total = 0
for num in range(101): #Instrução será repetida 100 vezes
    total = total + num
print(total, "\n")

#Imprimir números em ordem decrescente
for i in range(10, -1, -1):
    print(i)
print("\n")

#Imprimir números pares
for i in range(0, 11, 2):
    print(i)
print("\n")

#Imprimir números ímpares
for i in range(0, 11, 3):
    print(i)
print("\n")

#Função range(start, stop, [step])

#break/continue
temperaturas = [27, 28, 29, 30, 31, 32, 33, 21, 20, 30]
for temperatura in temperaturas:
    if temperatura == 30:
        continue
    print(temperatura)
    if temperatura == 31:
        break

