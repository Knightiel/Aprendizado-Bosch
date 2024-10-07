from Marca import Marca
from Produto import Produto
from Produto_em_estoque import Produto_em_estoque
from Entrada_saida import Entrada_saida
from Validacao import Validacao

class Loja:
    def __init__(self):
        self.__produtos = []
        self.__produtos_estoque = []
        self.__marcas = []

    def get_produtos(self):
        return self.__produtos

    def set_produtos(self, produto):
        self.__produtos.append(produto)

    def get_produtos_estoque(self):
        return self.__produtos_estoque

    def set_produtos_estoque(self, produto_em_estoque):
        self.__produtos_estoque.append(produto_em_estoque)

    def get_marcas(self):
        return self.__marcas

    def set_marcas(self, marca):
        self.__marcas.append(marca)

    def ver_marcas(self):
        marcas_parceiras = "Marcas parceiras: \n"
        for marca in self.get_marcas(): 
            marcas_parceiras += "\n" + marca.get_nome_marca()
        return marcas_parceiras

    # def cadastrar_marcas(self,marca):
    #     self.get_marcas().append(marca)

    def inserir_produtos(self, produto, produto_em_estoque):
        self.get_produtos().append(produto)
        self.get_produtos_estoque().append(produto_em_estoque)

    def inserir_marca(self, marca_escolhida):
        marca_existe = False
        for marca in self.get_marcas():
            if marca_escolhida.get_nome_marca() == marca.get_nome_marca():
                marca_existe = True
        if marca_existe == False:
            self.get_marcas().append(marca_escolhida)

    def editar_nome_marca(self, marca_escolhida):
        entrada_saida = Entrada_saida()
        for cont,marca in enumerate(self.get_marcas()):
            if marca.get_nome_marca() == marca_escolhida:
                marca.set_nome_marca(entrada_saida.cadastrar_dado("Nome da marca que deseja alterar"))
                entrada_saida.mostrar("dado atualizado")
            elif cont == len(self.get_marcas())-1:
                entrada_saida.mostrar("Marca não encontrada")

    def ver_pela_marca(self,marca_escolhida):
        produtos = ""
        for i, produto in enumerate(self.get_produtos_estoque()):
            if produto.get_marca_produto().get_nome_marca() == marca_escolhida:
                tamanho = str(produto.get_tamanho())
                produtos += f"\n================================================== \
                    \nNome:  {produto.get_nome()} \
                    \n================================================== \
                    \nProduto {i+1}  \
                    \nCodigo: {produto.get_codigo()} \nTipo: {produto.get_tipo()} \
                    \nPreço: R$ {produto.get_preco():.2f} \nTamanho: {tamanho.upper()} \
                    \nMarca: {produto.get_marca_produto().get_nome_marca()} \nCor: {produto.get_cor()} \
                    \nQuantidade atual no estoque: {produto.get_quantidade_atual()} \nQuantidade mínina no estoque: {produto.get_quantidade_min()} \
                    \n==================================================\n"
            elif i == len(self.get_produtos()):
                produtos = "\nMarca não encontrada."
        return produtos

    def excluir_marca(self,marca_escolhida):
        marca_excluida = None
        entrada_saida = Entrada_saida()
        for cont, marca in enumerate(self.get_marcas()):
            if marca.get_nome_marca() == marca_escolhida:
                marca_excluida = marca
                print("sim")
            elif cont == len(self.get_marcas()):
                print("0i")
                entrada_saida.mostrar("Marca não encontrada")
        print("bom dia")
        self.get_marcas().remove(marca_excluida)
        entrada_saida.mostrar(f"A marca {marca_excluida.get_nome_marca()} foi excluida")
        for produto in self.get_produtos():
            if produto.get_marca_produto() == marca_excluida:
                self.excluir_produtos(produto)
    
    def ver_produtos(self):
        produtos = ""
        i = 0
        for produto in self.get_produtos_estoque():
            tamanho = str(produto.get_tamanho())
            produtos += f"\n================================================== \
                    \nNome:  {produto.get_nome()} \
                    \n================================================== \
                    \nProduto {i+1}  \
                    \nCodigo: {produto.get_codigo()} \nTipo: {produto.get_tipo()} \
                    \nPreço: R$ {produto.get_preco():.2f} \nTamanho: {tamanho.upper()} \
                    \nMarca: {produto.get_marca_produto().get_nome_marca()} \nCor: {produto.get_cor()} \
                    \nQuantidade atual no estoque: {produto.get_quantidade_atual()} \nQuantidade mínina no estoque: {produto.get_quantidade_min()} \
                    \n==================================================\n"
        return produtos
    
    def editar_produtos(self, produto_escolhido, opcao_pre_escolhida):
        cont = 0
        n = True
        entrada_saida = Entrada_saida()
        validacao = Validacao()
        
        for i,Produto_em_estoque in enumerate(self.get_produtos_estoque()):
            if Produto_em_estoque.get_nome() == produto_escolhido:
                if opcao_pre_escolhida != 0:
                    opcao = opcao_pre_escolhida
                else:
                    opcao = entrada_saida.escolher_opcao("Nome", "Tipo", "Preço", "Tamanho", "Marca", "Cor")
                match opcao:
                    case 1:
                        n = True
                        while n:
                            try:
                                Produto_em_estoque.set_nome(entrada_saida.cadastrar_dado("nome"))
                                for produto in self.get_produtos():
                                    produto.set_nome(Produto_em_estoque.get_nome())#alterar para todos
                                n = False
                            except:
                                n = True
                        break
                    case 2:
                        Produto_em_estoque.set_tipo(entrada_saida.escolher_nome("camisa","camiseta","calça","shorts","tênis","acessórios"))
                    case 3:
                        n = True
                        while n:
                            try:
                                while True:
                                    Produto_em_estoque.set_preco(entrada_saida.cadastrar_dado("preço",int))
                                    if validacao.validar_decimal(Produto_em_estoque.get_preco() != False):
                                        break
                            except:
                                n = True
                        break
                    case 4:
                        n = True
                        while n:
                            if Produto_em_estoque.get_tipo() == "tênis":
                                try:
                                    Produto_em_estoque.set_tamanho(entrada_saida.cadastrar_dado("o tamanho do Produto_em_estoque"))
                                    n = False
                                except:
                                    n = True
                            else:
                                Produto_em_estoque.set_tamanho(entrada_saida.escolher_nome("PP","P","M","G","GG","XG"))
                                n = False
                        break
                    case 5:
                        Produto_em_estoque.get_marca_produto().set_nome_marca(entrada_saida.cadastrar_dado("a marca"))
                    case 6:
                        Produto_em_estoque.set_cor(entrada_saida.escolher_nome("Azul", "Preto", "Branco", "Vermelho", "Colorido"))
            elif cont == len(self.get_produtos())-1:
                entrada_saida.mostrar("Produto não encontrado")
                        
        #criar lista de produtos
    
    def excluir_produtos(self, produto_escolhido):
        entrada_saida = Entrada_saida()
        for cont,produto in enumerate(self.get_produtos()):
            if produto.get_nome() == produto_escolhido:
                self.get_produtos().remove(produto)
        for produto in self.get_produtos_estoque():
            if produto.get_nome() == produto_escolhido:
                self.get_produtos_estoque().remove(produto)
                entrada_saida.mostrar(f"\nO produto {produto.get_nome()} foi excluido\n")
            elif cont == len(self.get_produtos())-1:
                entrada_saida.mostrar("Produto não encontrado")

    def atualizar_baixa(self, produto_escolhido):
        cont = 0
        saida = 0
        entrada_saida = Entrada_saida()
        validacao = Validacao()
        for produto_estoque in self.get_produtos_estoque():
            cont += 1
            if produto_estoque.get_nome() == produto_escolhido:
                saida = int(entrada_saida.cadastrar_dado("Quantidade de saida"))
                if(validacao.validar_saida(saida, produto_estoque.get_quantidade_atual())):
                    quantidade = produto_estoque.get_quantidade_atual()
                    produto_estoque.set_quantidade_atual(quantidade - saida)
                    produto_estoque.validar_baixa()
                else:
                    entrada_saida.mostrar("Quantidade de saída inválida")
            elif cont == len(self.get_produtos())-1:
                entrada_saida.mostrar("Produto não encontrado")

        
    def atualizar_entrada(self, produto_escolhido):
        entrada = 0
        quantidade = 0
        entrada_saida = Entrada_saida()
        validacao = Validacao()

        for cont,produto_estoque in enumerate(self.get_produtos_estoque()):
            if produto_estoque.get_nome() == produto_escolhido:
                entrada = int(entrada_saida.cadastrar_dado("Quantidade de entrada"))
                if validacao.validar_inteiro(entrada):
                    quantidade = produto_estoque.get_quantidade_atual()
                    produto_estoque.set_quantidade_atual(quantidade + entrada)
                else:
                    entrada_saida.mostrar("Produto não encontrado")
            elif cont == len(self.get_produtos())-1:
                entrada_saida.mostrar("Produto não encontrado")

    def ver_um_produto(self,codigo_produto):
        entrada_saida = Entrada_saida()
        produto = ""
        for i,produto_estoque in enumerate(self.get_produtos_estoque()):
            if produto_estoque.get_codigo() == codigo_produto:
                tamanho = str(produto_estoque.get_tamanho())
                produto = f"\n================================================== \
                    \nNome:  {produto_estoque.get_nome()} \
                    \n================================================== \
                    \nProduto: {i+1}  \
                    \nCodigo: {produto_estoque.get_codigo()} \nTipo: {produto_estoque.get_tipo()} \
                    \nPreço: R$ {produto_estoque.get_preco():.2f} \nTamanho: {tamanho.upper()} \
                    \nMarca: {produto_estoque.get_marca_produto().get_nome_marca()} \nCor: {produto_estoque.get_cor()} \
                    \nQuantidade atual no estoque: {produto_estoque.get_quantidade_atual()} \nQuantidade mínina no estoque: {produto_estoque.get_quantidade_min()} \
                    \n==================================================\n"
            if produto == "":
                produto = ("\nO código solicitado não foi encontrado\n")
        return produto
                    
    def ver_produto_em_baixa(self):
        entrada_saida = Entrada_saida()
        produtos = "Produtos em baixa: "
        i = 0
        for i,produto_estoque in enumerate(self.get_produtos_estoque()):
            if produto_estoque.get_produto_faltando() == True:
                tamanho = str(produto_estoque.get_tamanho())
                produtos += f"\n================================================== \
                    \nNome:  {produto_estoque.get_nome()} \
                    \n================================================== \
                    \nProduto {i+1}  \
                    \nCodigo: {produto_estoque.get_codigo()} \nTipo: {produto_estoque.get_tipo()} \
                    \nPreço: R$ {produto_estoque.get_preco():.2f} \nTamanho: {tamanho.upper()} \
                    \nMarca: {produto_estoque.get_marca_produto().get_nome_marca()} \nCor: {produto_estoque.get_cor()} \
                    \nQuantidade atual no estoque: {produto_estoque.get_quantidade_atual()} \nQuantidade mínina no estoque: {produto_estoque.get_quantidade_min()} \
                    \n==================================================\n"
            elif i == len(self.get_produtos_estoque())-1:
                entrada_saida.mostrar("Não há produtos em baixa no estoque")
        return produtos 
    
    
    def retornar_nome_produto(self, codigo_escolhido):
        resultado = ""
        entrada_saida = Entrada_saida()
        for cont,produto in enumerate(self.get_produtos()):
            if produto.get_codigo() == codigo_escolhido:
                resultado = produto.get_nome()
            elif cont == len(self.get_produtos()):
                entrada_saida.mostrar("Produto não encontrado")
        return resultado