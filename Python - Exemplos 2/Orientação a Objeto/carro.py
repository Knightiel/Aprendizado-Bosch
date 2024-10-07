class Carro:
    def __init__(self, modelo, cor, marca, motor): #__init__ é um método especial chamado contrutor, que é executado ao criar um novo objeto Carro.
        self.modelo = modelo #Atribui o valor do parâmetro modelo ao atributo modelo do objeto.
        self.cor = cor
        self.marca = marca
        self.motor = motor

    def dirigir(self): #Define um método chamado dirigir.
        print(f"{self.modelo} cor {self.cor} da {self.marca}, {self.motor} está em movimento.")

#Criando objetos da classe Carro
carro1 = Carro("Sedan", "Preto", "Toyota", "2.0")
carro2 = Carro("SUV", "Branco", "Honda", "2.0")
carro3 = Carro("Caminhonete", "Vermelho", "Fiat", "1.6")

#Chamando o método dirigir para cada carro
carro1.dirigir()
carro2.dirigir()
carro3.dirigir()