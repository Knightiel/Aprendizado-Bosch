area = "ETS"
anos = 60
print(area, "POSSUI", anos, "ANOS DE TRADIÇÃO!")
type(area) #tipagem de dados
type(anos)
preco = 99.99
v_f = True

print("Tipagem dinâmica")
print(type(area))
print(area)

pais = 644
print(type(pais))

nome = "Alice"
idade = 30
mensagem = f"Olá, meu nome é {nome} e tenho {idade} anos.\n" #{} são espaços reservados que são substituidos na ordem que são fornecidos para a função f-string
print(mensagem)

print("Ordem dos parâmetros:")
numero_1 = 10
numero_2 = 20
print("Esse é o segundo parâmetro: {1} \
    Esse é o primeiro parâmetro: {0}.\n".format(numero_1, numero_2))

print("Formatação de floats:")
#primeiro sem dizer para a função que é um float
peso = 70.12
print("João pesa {} kg.".format(peso))
#agora, passando para a função que trata-se de um float
print("João pesa {:f} kg.".format(peso))
#queremos que após o ponto tenha apenas dois números
peso = 70.123
print("João pesa {:.2f} kg.".format(peso))
#queremos que após o ponto tenha apenas dois números e precisamos dizer quantos caracteres o número terá no máximo
peso = 170.120
print("João pesa {:6.2f} kg.".format(peso))
#se quisermos preencher os espacos em branco com zeros, é só passar um 0 antes
peso = 70.12
print("João pesa {:06.2f} kg.".format(peso))

print("\nFormatação de Inteiros")
dia = 8
mes = 1
ano = 2024
print("Data de hoje {:02d}/{:02d}/{:d}".format(dia, mes, ano)) #numeros inteiros passamos a letra d

#Formatted String Literals
empresa = 'Robert Bosch Ltda.'
print(f'Trabalho na {empresa}')
#também pode ser utilizada com funções e métodos
print(f'Trabalho na {empresa.lower()}') #lower - converte em minúsculas
print(f'Trabalho na {empresa.upper()}\n') #upper - converte em maiúsculas

area = "Engineering Technical School"
empresa = "Robert Bosch Ltda."
print(area + empresa) # + concatena as strings, mas não crias espaços
print(area, empresa)
