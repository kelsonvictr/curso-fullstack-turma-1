import React from 'react'
import axios from '../../api'
import { useState, useEffect } from 'react'

const SupplierList = () => {

    const [suppliers, setSuppliers] = useState([])

    useEffect(() => {
        axios.get('/suppliers')
        .then(response => {
            setSuppliers(response.data)
        })
        .catch(error => console.error("Ocorreu um erro: ",error))
    }, []);

    const fetchSuppliers = () => {
    axios.get('/suppliers')
        .then(response => {
            setSuppliers(response.data)
        })
        .catch(error => console.error("Ocorreu um erro: ",error))
    }

    function deleteSupplier(id) {
        axios.delete(`/suppliers/${id}`)
        .then(() => {
            alert("Fornecedor excluído com sucesso!")
            fetchSuppliers()
        })
        .catch(error => console.error("Ocorreu um erro: ",error))
    }

  return (
    <div className="container mt-5">
        <h2 className="mb-4">Lista de Fornecedores</h2>
        <button className="btn btn-primary mb-2">Adicionar Fornecedor</button>
        <table className="table">
            <thead>
                <tr>
                    <th>Nome:</th>
                    <th>CNPJ:</th>
                    <th>Email:</th>
                    <th>Ações:</th>
                </tr>
            </thead>
            <tbody>
                {
                    suppliers.map(supplier => (
                        <tr key={supplier.id}>
                          <td>{supplier.name}</td>
                          <td>{supplier.cnpj}</td>
                          <td>{supplier.email}</td>
                          <td>
                            <button className="btn btn-sm btn-warning mr-2">Editar</button>
                            <button onClick={() => deleteSupplier(supplier.id)} className="btn btn-sm btn-danger">Excluir</button>
                            
                          </td>        
                        </tr>
                    ))
                }
            </tbody>
        </table>

    </div>
  )
}

export default SupplierList