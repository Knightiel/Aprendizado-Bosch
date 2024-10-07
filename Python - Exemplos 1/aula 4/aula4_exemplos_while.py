contador = 0
while contador < 5:
    print(contador)
    contador += 1

numero_secreto = 2
print("Adivinhe o número secreto de 0 a 10!")
palpite = int(input("Digite um número de 0 a 10: "))
while palpite != numero_secreto:
    print("Palpite incorreto. Tente novamente!")
    palpite = int(input("Digite um número: "))

print("Parabéns! Você acertou o número secreto.\n")

import time #é uma instrução para importar o módulo time, que fornece várias funcionalidades relacionadas a tempo

def main():
    contagem_regressiva = 10
    while (contagem_regressiva > -1):
        print(contagem_regressiva)
        contagem_regressiva -= 1
        time.sleep(1) #Função sleep é usada para pausar a execução do programa por um determinado número de segundos
        if (contagem_regressiva == 9): break
    print("Contagem finalizada!!!")

if __name__ == "__main__":
    main()

#gerando números aleatórios
import random

numero_aletorio = random.randint(1, 10) #Gerando número aleatório inteiro entre 1 e 10 (inclusive 1 e 10)
print("Apresentação de número aleatório entre 1 e 10:", numero_aletorio)

numero_aletorio_float = random.random() #Gerando número aleatório de ponto flutuante entre 0 e 1 
print("Número aleatório de ponto flutuante entre 0 e 1:", numero_aletorio_float)

#Embaralhando uma lista
lista_original = [1, 2, 3, 4, 5]
random.shuffle(lista_original)
print("Lista embaralhada:", lista_original)

#Escolhendo um elemento aleatório de uma lista
elemento_aleatorio = random.choice(lista_original)
print("Elemento aleatório da lista:", elemento_aleatorio)