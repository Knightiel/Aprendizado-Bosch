
from Entrada_saida import Entrada_saida
from Validacao import Validacao
import string
import random
from Marca import Marca
import os

class Produto:
    def __init__(self):
        self.__nome = None
        self.__codigo = None
        self.__tipo = None
        self.__preco = None
        self.__tamanho = None
        self.__marca_produto = None
        self.__cor = None
        
    def get_nome(self):
        return self.__nome

    def set_nome(self, nome):
        self.__nome = nome

    def get_codigo(self):
        return self.__codigo

    def set_codigo(self, codigo):
        self.__codigo = codigo

    def get_tipo(self):
        return self.__tipo

    def set_tipo(self, tipo):
        self.__tipo = tipo

    def get_preco(self):
        return self.__preco

    def set_preco(self, preco):
        self.__preco = preco

    def get_tamanho(self):
        return self.__tamanho

    def set_tamanho(self, tamanho):
        self.__tamanho = tamanho

    def get_marca_produto(self):
        return self.__marca_produto

    def set_marca_produto(self, marca_produto):
        self.__marca_produto = marca_produto

    def get_cor(self):
        return self.__cor

    def set_cor(self, cor):
        self.__cor = cor

    def cadastrar_produto(self,loja):
        os.system("cls")
        codigo_valido = True
        validacao = Validacao()
        entrada_saida = Entrada_saida()

        while True:
            def random_generator(size=5, chars=string.ascii_uppercase + string.digits):
                return ''.join(random.choice(chars) for _ in range(size))

            self.set_codigo(random_generator())
            codigo_valido = validacao.validar_existe_codigo(self.get_codigo(),loja)
            if codigo_valido:
                break
        
        self.set_nome(entrada_saida.cadastrar_dado("o nome do produto"))

        opcoes = ["camisa","camiseta","calça","shorts","tênis","acessórios"]
        resposta_valida=True
        while resposta_valida:
            self.set_tipo(entrada_saida.escolher_nome("camisa","camiseta","calça","shorts","tênis","acessórios"))
            for tipo in opcoes:
              if tipo == self.get_tipo():
                resposta_valida = False
                break
            
        n = True
        while n:
            try:
                self.set_preco(float(entrada_saida.cadastrar_dado("o preço do produto")))
                if validacao.validar_decimal(self.get_preco()) != False:
                    n = False
            except:
                n = True
        
        n = True
        while n:
            if self.get_tipo() == "tênis":
                try:
                    self.set_tamanho(int(entrada_saida.cadastrar_dado("o tamanho do produto")))
                    if validacao.validar_inteiro(self.get_tamanho()) != False:
                        n = False
                except:
                    n = True
            else:
                opcoes2 = ["PP","P","M","G","GG","XG"]
                self.set_tamanho(entrada_saida.escolher_nome("PP","P","M","G","GG","XG"))
                for tamanho in opcoes2:
                    if tamanho == self.get_tamanho().upper():
                        n = False

        marca_produto = Marca()

        marca_produto.set_nome_marca(entrada_saida.cadastrar_dado("a marca do produto"))
        self.set_marca_produto(marca_produto)
        loja.inserir_marca(marca_produto)

        cores = ["Azul", "Preto", "Branco", "Vermelho", "Colorido"]
        n = True
        while n:
            self.set_cor(entrada_saida.escolher_nome("Azul", "Preto", "Branco", "Vermelho", "Colorido"))
            for cor in cores:
                if cor == self.get_cor():
                    n = False
                    break
                else:
                    n = True
        
