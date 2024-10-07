class Entrada_saida:

    def escolher_opcao(self, *elementos):
        n = True
        while n:
            try:
                msg = "Insira a opção: "
                for i,elemento in enumerate(elementos):
                    msg += f"\n [{i+1}] - {elemento}"
                escolha = int(input(f"{msg}\nInforme: "))
                n = False
                return escolha 
            except:
                print("\nOpção inválida. Tente novamente.\n")
                n = True

    def escolher_nome(self,*elementos):
        msg = "Digite o nome: "
        for i,elemento in enumerate(elementos):
            msg += f"\n [{elemento}]"
        return input(f"{msg} \nInforme: ")

    def cadastrar_dado(self,dado):
        return input(f"Informe {dado}: ")
    
    def escolher_quantidade_cadastro(self,dado):
        return int(input(f"Digite o número de {dado} que serão cadastrados: "))

    def mostrar(self,msg):
        print(msg)