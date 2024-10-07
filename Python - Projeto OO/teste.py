from tkinter import *
from tkinter import ttk

""" janela = Tk()
janela.title("Cotação Atual de Moedas")
texto = Label(janela, text="Clique no botão para ver as cotações de moedas")
texto.grid(column=0, row=0, padx=10, pady=10)

botao = Button(janela, text="Buscar cotações")
botao.grid(column=0, row=1, padx=10, pady=10)

texto_resposta = Label(janela, text="")
texto_resposta.grid(column=0, row=2, padx=10, pady=10)


janela.mainloop() """

app = Tk()
app.title("Loja de Marcas")
app.geometry("500x400")

cores = ["Azul", "Preto", "Branco", "Vermelho", "Colorido"]

lb_cores = Label(app, text="Cores")
lb_cores.pack()

cb_cores=ttk.Combobox(app, values=cores)
cb_cores.set("Preto")
cb_cores.pack()

app.mainloop()