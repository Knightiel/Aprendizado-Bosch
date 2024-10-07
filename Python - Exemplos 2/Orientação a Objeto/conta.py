class Conta:
    def __init__(self, numero, titular, saldo, limite = 1000.0):
        self.__numero = numero #Atributo privado
        self.__titular = titular
        self.__saldo = saldo #Privar um atributo ou método: Prefixar o nome do atributo com dois underlines(__)
        self.__limite = limite

    #Getters
    def get_numero(self):
        return self.__numero
    
    def get_titular(self):
        return self.__titular
    
    def get_saldo(self):
        return self.__saldo
    
    def get_limite(self):
        return self.__limite

    #Setters
    def set_numero(self, numero):
        self.__numero = numero
    
    def set_titular(self, titular):
        self.__titular = titular
    
    def set_saldo(self, saldo):
        self.__saldo = saldo

    def set_limite(self, limite):
        self.__limite = limite
    
    def depositar(self, valor):
        """Realizar um depósito na conta."""
        self.saldo += valor
        print(f"Depósito de R${valor} realizado. Novo saldo: R${self.saldo}")
    
    def __sacar(self, valor): #Método privado
        """Realiza um saque na conta, se houver saldo disponível."""
        if self.saldo - valor >= self.limite:
            self.saldo -= valor
            print(f"Saque de R${valor} realizado. Novo saldo: R${self.saldo}")
        else:
            print("Saldo insuficiente. Operação não realizada.")
        
    def tranferir(self, destino, valor):
        """Transfere um valor para outra conta, se houver saldo disponível"""
        if self.saldo - valor >= -self.limite:
            self.saldo -= valor
            destino.saldo += valor
            print(f"Tranferência de R${valor} realizada para a conta de {destino.titular}.")
            print(f"Novo saldo: R${self.saldo}")
        else:
            print("Saldo insuficiente. Operação não realizada.")

conta = Conta(123, "Fulano", 1000.0)
print(conta.get_numero()) #Imprimke 123

conta.set_numero(456)
print(conta.get_numero()) #Imprime 456

conta.set_saldo(1500.0)
print(conta.get_saldo()) #Imprime 1500.0
