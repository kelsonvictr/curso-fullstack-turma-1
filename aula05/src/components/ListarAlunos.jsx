import React, { useEffect, useState } from 'react'
import axios from 'axios';

const ListarAlunos = () => {

    const [alunos, setAlunos] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:3000/alunos')
        .then(response => {
            setAlunos(response.data)
        })
        .catch(error => console.error("Ocorreu um erro: ",error))
    }, []);

  return (
    <div>
      {
        alunos.map(item => (
            <p key={item.id}>{item.nome} - {item.email}</p>
        ))
      }  
    </div>
  )
}

export default ListarAlunos