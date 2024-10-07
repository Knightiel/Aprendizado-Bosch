def funcao():
    print("Bloco de código")
funcao()

#define a função e parâmetros
def imprime_nome(nome):
    print(f"Nome:{nome}")

 #usando a função passando os valores de entrada
imprime_nome("Erickson")
imprime_nome("Renan")
imprime_nome("Daniel")

def main():
    idade = int(input("Entre com sua idade: "))
    if idade == 18:
        print("Pode tirar sua CNH!")
    else:
        print("Não pode tirar CNH ainda!")
if __name__ == "__main__": #verifica se o script está sendo executado diretamente ou se está sendo importado como um módulo em outro script
    main()