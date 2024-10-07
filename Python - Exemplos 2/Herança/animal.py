class Animal:
    def __init__(self, nome):
        self.nome = nome
    
    def fazer_som(self):
        pass

class Cachorro(Animal):
    def __init__(self, nome, raca):
        super().__init__(nome)
        self.raca = raca

    def fazer_som(self):
        return "Au au!"
    
    def abanar_rabo(self):
        return "Rabo abanando!"
    
class Gato(Animal):
    def __init__(self, nome, cor_pelagem):
        super().__init__(nome)
        self.cor_pelagem = cor_pelagem
    
    def fazer_som(self):
        return "Miau!"
    
    def afiar_garras(self):
        return "Garras sendo afiadas!"
    
#Uso de herança
cachorro = Cachorro("Rex", "Labrador")
gato = Gato("Whiskers", "Cinza")

#Acesso a atributos específicos 
print(cachorro.raca)        #Atributo específico de Cachorro
print(gato.cor_pelagem)     #Atributo específico de Gato

#Uso de métodos específicos
print(cachorro.abanar_rabo())   #Método específico de Cachorro
print(gato.afiar_garras())      #Método específico de Gato