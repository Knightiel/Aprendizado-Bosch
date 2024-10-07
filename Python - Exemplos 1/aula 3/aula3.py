#funções em python
def main():
    print("Entre com ano, mês e dia de nascimento, respectivamente: ")
    ano = int(input("Ano: "))
    mes = int(input("Mês: "))
    dia = int(input("Dia: "))
    ano_dif = 2024 - ano
    mes_dif = 1 - mes
    dia_dif = 10 - dia
    idade = 2024 - ano
    if (idade >= 18):
        print("Pode tirar sua CNH")
    elif (idade < 18):
        print("Não pode tirar CNH ainda")
    else:
        print("Continua...")
if __name__ == "__main__":
    main()
