

class Validacao:
    def validar_saida(self, saida, atual):
        if (atual - saida) < 0:
            return False
        return True

    def validar_decimal(self, meu_double):
        if(meu_double < 0):
            return False
        return True
    
    def validar_inteiro(self, meu_int):
        if (meu_int < 0):
            return False
        return True
    
    # def validar_produto_existente(nome_produto, lista):
    #     return True
    
    def validar_produto_faltando(self, minima, atual):
        if minima >= atual:
            return True
        return False

    def validar_existe_codigo(self, codigo, loja):
        codigo_valido = True
        for produto in loja.get_produtos():
            if produto.get_codigo() == codigo:
                codigo_valido = False
        return codigo_valido