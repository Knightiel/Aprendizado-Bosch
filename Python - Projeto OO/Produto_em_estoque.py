from Produto import Produto
from Entrada_saida import Entrada_saida
from Validacao import Validacao


class Produto_em_estoque(Produto):
    def __init__(self):
        self.__produto = None
        self.__quantidade_atual = None
        self.__quantidade_min = None
        self.__produto_faltando = None

    def get_produto(self):
        return self.__produto

    def set_produto(self, produto):
        self.__produto = produto

    def get_quantidade_atual(self):
        return self.__quantidade_atual

    def set_quantidade_atual(self, quantidade_atual):
        self.__quantidade_atual = quantidade_atual

    def get_quantidade_min(self):
        return self.__quantidade_min

    def set_quantidade_min(self, quantidade_min):
        self.__quantidade_min = quantidade_min

    def get_produto_faltando(self):
        return self.__produto_faltando

    def set_produto_faltando(self, produto_faltando):
        self.__produto_faltando = produto_faltando

    def cadastrar_estoque(self, produto):

        self.set_codigo(produto.get_codigo())
        self.set_nome(produto.get_nome())
        self.set_tipo(produto.get_tipo())
        self.set_preco(produto.get_preco())
        self.set_tamanho(produto.get_tamanho())
        self.set_marca_produto(produto.get_marca_produto())
        self.set_cor(produto.get_cor())

        validacao = Validacao()
        entrada_saida = Entrada_saida()

        n = True
        while n:
            try:
                while True:
                    self.set_quantidade_min(int(entrada_saida.cadastrar_dado("a quantidade mínima do produto em estoque")))
                    if validacao.validar_inteiro(self.get_quantidade_min() != False):
                        n = False
                        break
            except:
                n = True

        n = True
        while n:
            try:
                while True:
                    self.set_quantidade_atual(int(entrada_saida.cadastrar_dado("a quantidade atual do produto no estoque")))
                    if validacao.validar_inteiro(self.get_quantidade_atual() != False):
                        n = False
                        break
            except:
                n = True

        self.set_produto_faltando(validacao.validar_produto_faltando(self.get_quantidade_min(), self.get_quantidade_atual()))

    def validar_baixa(self):
        if self.get_quantidade_atual() < self.get_quantidade_min():
            self.set_produto_faltando(True)

