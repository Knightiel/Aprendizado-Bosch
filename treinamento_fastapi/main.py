from fastapi import FastAPI, HTTPException, status, Depends
from model import Futebol
from typing import Optional, Any

app = FastAPI(title="Api de JVL", version="0.0.1", description="Uma api feita por JVL")

times = {
    1:{
        "nome_time" : "Athletico Paranaense",
        "data_fundacao": "21/03/1924",
        "qtd_titulos": 200,
        "estadio": "Ligga Arena"
    },
    2:{
        "nome_time" : "Corinthians",
        "data_fundacao": "01/09/1910",
        "qtd_titulos": 54,
        "estadio": "Neo Quimica Arena"
    },
}

def fake_db():
    try:
        print("Conectando")
    finally:
        print("Fechando")

@app.get("/")
async def raiz():
    return {"msg" : "Funcionou!"}

@app.get("/times")
async def get_times(db: Any = Depends(fake_db)):
    return times

@app.get("/times")
async def get_times():
    return times

@app.get("/times/{time_id}")
async def get_time(time_id:int):
    try:
        time = times[time_id]
        return time
    except KeyError:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="Time não encontrado")

@app.post("/times", status_code=status.HTTP_201_CREATED)
async def post_time(time: Optional[Futebol] = None):
    next_id = len(times) + 1
    times[next_id] = time
    del time.id
    return time

@app.put("/times/{time_id}")
async def put_time(time_id:int, time:Futebol):
    if time_id in times:
        times[time_id] = time
        time.id = time_id
        del time.id
        return time
    else:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=f'Não existe um time com o ID {time_id}')
    
@app.delete("/times/{time_id}", status_code=status.HTTP_204_NO_CONTENT)
async def delete_time(time_id:int):
    if time_id in times:
        del times[time_id]
    else:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=f'Não existe um time com o ID {time_id}')

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host="127.0.0.1", port=8000, log_level="info", reload=True)