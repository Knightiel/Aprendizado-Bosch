from Loja import Loja
from Entrada_saida import Entrada_saida
from Produto import Produto
from Produto_em_estoque import Produto_em_estoque
import os

def main():
    loja = Loja()
    opcao = 0
    entrada_saida = Entrada_saida()
    while True:
        os.system("cls")
        if opcao != 4:
            opcao = entrada_saida.escolher_opcao("Cadastrar produto","Consultar produto","Ver marcas","Sair")
        match opcao:
            case 1:
                produto = Produto() 
                produto.cadastrar_produto(loja)
                produto_em_estoque = Produto_em_estoque()
                produto_em_estoque.cadastrar_estoque(produto)
                loja.inserir_produtos(produto, produto_em_estoque)
            case 2:
                escolha = 0
                while True:
                        if escolha != 5:
                            escolha = entrada_saida.escolher_opcao("Ver todos os produtos","Ver produtos pela marca","Ver um produto","Ver produtos com baixo estoque","Sair")
                            match escolha:
                                case 1:
                                    entrada_saida.mostrar(loja.ver_produtos())
                                    #fazer ver produtos
                                case 2:
                                    marca_escolhida = entrada_saida.cadastrar_dado("a marca")
                                    entrada_saida.mostrar(loja.ver_pela_marca(marca_escolhida))
                                case 3:
                                    codigo_escolhido = entrada_saida.cadastrar_dado("o código do produto")
                                    entrada_saida.mostrar(loja.ver_um_produto(codigo_escolhido))
                                    if loja.ver_um_produto(codigo_escolhido) != "":
                                        produto_escolhido = loja.retornar_nome_produto(codigo_escolhido)
                                        while True:
                                            if escolha != 5:
                                                escolha = entrada_saida.escolher_opcao("Editar dados", "Excluir produto", "Dar baixa","Atualizar Entrada","Sair")
                                            match escolha:
                                                case 1:
                                                    loja.editar_produtos(produto_escolhido,0)
                                                    # pass
                                                case 2:
                                                    loja.excluir_produtos(produto_escolhido)
                                                    break
                                                    # pass
                                                case 3:
                                                    loja.atualizar_baixa(produto_escolhido)
                                                    # pass
                                                case 4:
                                                    loja.atualizar_entrada(produto_escolhido)
                                            if escolha == 5:
                                                break
                                case 4:
                                    entrada_saida.mostrar(loja.ver_produto_em_baixa())
                        if escolha == 5:
                            break
            case 3:
                entrada_saida.mostrar(loja.ver_marcas())
                opcao4 = 0
                marca_escolhida = ""
                while True:
                    try:
                        if opcao4 != 3:
                            opcao4 = entrada_saida.escolher_opcao("Editar marcas","Excluir marcas","Sair")
                        match opcao4:
                            case 1:
                                marca_escolhida = entrada_saida.cadastrar_dado("o nome da marca")
                                loja.editar_nome_marca(marca_escolhida)
                            case 2:
                                marca_escolhida = entrada_saida.cadastrar_dado("o nome da marca")
                                loja.excluir_marca(marca_escolhida)
                                #Usar a função excluir_produto por fora (?)
                                break 
                        if opcao4 == 3:
                            break
                    except:
                        print("opção inválida")
        if opcao == 4:
            break
        print("opção inálida")
        

if __name__ == "__main__":
    main()