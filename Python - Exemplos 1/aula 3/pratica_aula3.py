#identificar o maior número
""" def main():
    a = int(input("Digite o primeiro valor: "))
    b = int(input("Digite o segundo valor: "))
    c = int(input("Digite o terceiro valor: "))
    if (a >= b and a >= c):
        print("O maior valor é",a)
    elif(b >= a and b >= c):
        print("O maior valor é",b)
    else:
        print("O maior valor é",c)
    
if __name__ == "__main__":
    main() """

#####################################################

#Verificar a média e identidicar a sua situação
""" def calcular_media():
    nota1 = float(input("Digite a nota 1: "))
    nota2 = float(input("Digite a nota 2: "))
    nota3 = float(input("Digite a nota 3: "))
    media = (nota1 + nota2 + nota3) / 3
    if (media >= 7):
        mensagem = "Aprovado"
    elif (media >= 4):
        mensagem = "Em recuperação"
    else:
        mensagem = "Reprovado"
    return mensagem

print(calcular_media()) """

######################################################

#Calculadora simplificada 
""" def fazer_media(a, b, c):
    media = (a+b+c) / 3.0
    return media

def identificar_maior_menor(a, b, c):
    # if (a >= b and a >= c):
    #     maior = a
    # elif (b >= a and b >= c):
    #     maior = b
    # else:
    #     maior = c
    
    # if(a <= b and a <= c):
    #     menor = a
    # elif(b <= a and b <= c):
    #     menor = b
    # else:
    #     menor = c
    maior = max(a, b, c)
    menor = min(a, b, c)
    return maior, menor

def calcular_ssdm(a, b, c): #ssdm - Soma, Subtração, Divisão, Multiplicação
    soma = a + b + c
    subtracao = a - b - c
    if (a==0 or b==0 or c==0):
        divisao = "A divisão não pode ser realizada devido a presença de um 0"
    else:
        divisao = a / b / c
    
    multiplicacao = a*b*c
    return soma, subtracao, divisao, multiplicacao
        

num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o segundo número: "))
num3 = float(input("Digite o terceiro número: "))

media = fazer_media(num1, num2, num3)
maior, menor = identificar_maior_menor(num1, num2, num3)
soma, subtracao, divisao, multiplicacao = calcular_ssdm(num1, num2, num3)
print(" Soma: {:.2f}\n Subtração: {:.2f}\n Divisão: {:.2f}\n Multiplicação: {:.2f}\n Maior número: {:.2f}\n Menor número: {:.2f}\n Média: {:.2f} \
    ".format(soma, subtracao, divisao, multiplicacao, maior, menor, media)) """

#Calculo do IMC
def calcular_imc():
    peso = float(input("Digite seu peso (kg): "))
    altura = float(input("Digite a sua altura (m): "))
    imc = peso / (altura*altura)

    if(imc > 40):
        mensagem = "Obesidade Grau 3"
    elif(imc >= 35):
        mensagem = "Obesidade Grau 2"
    elif(imc >= 30):
        mensagem = "Obesidade Grau 1"
    elif(imc >= 25):
        mensagem = "Sobrepeso"
    elif(imc >= 18.5):
        mensagem = "Peso normal"
    else:
        mensagem = "Abaixo do peso"
    
    return imc, mensagem

imc, resultado = calcular_imc()
print(f"IMC: {imc:.2f}\nSituação: {resultado}")