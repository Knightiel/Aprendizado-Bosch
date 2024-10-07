#Exemplo de uma classe com atributos e métodos
class Pessoa:
    def __init__(self, nome, idade, telefone, endereco):
        self.nome = nome
        self.idade = idade
        self.telefone = telefone
        self.endereco = endereco

    def apresentar(self):
        print(f"Olá, meu nome é {self.nome} e tenho {self.idade} anos.")
        print(f"Meu telefone é {self.telefone} e meu endereço é: {self.endereco}")
    
#Criando um objeto da classe Pessoa
pessoa1 = Pessoa("João", 30, "(47)99999-6542", "Rua de casa - 167")
pessoa1.apresentar()
