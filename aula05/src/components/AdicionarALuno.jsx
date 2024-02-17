import React from 'react'
import axios from 'axios'

const AdicionarALuno = () => {

    const addAluno = async () => {
        const response = await axios.post('http://localhost:3000/alunos',
        {
            nome: "Bob Esponja",
            email: "bob@gmail.com"
        }
        );
        console.log(`Foi adicionando o aluno: ${response.data}`)
        alert("Aluno cadastrado com sucesso");
    }

  return (
    <div>
        <button onClick={addAluno}>Adicionar Bob</button>
    </div>
  )
}

export default AdicionarALuno