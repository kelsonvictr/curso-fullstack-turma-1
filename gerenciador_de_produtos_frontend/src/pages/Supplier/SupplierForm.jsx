import React, { useEffect } from 'react'
import { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from '../../api'

const SupplierForm = () => {

    const [supplier, setSupplier] = useState({ name: '', cnpj: '', email: ''})
    const [errorMessage, setErrorMessage] = useState('')
    const navigate = useNavigate()
    const { id } = useParams()

    useEffect(() => {
        if (id) {
            axios.get(`/suppliers/${id}`)
            .then(response => {
                setSupplier(response.data)
            })
            .catch(error => {
                console.error('Erro ao buscar fornecedor', error)
                handleErrors(error)
            })
        } else {
            setSupplier({ name: '', cnpj: '', email: ''})
        }
    }, [id])

    function handleChange(event) {
        const { name, value } = event.target
        setSupplier(prevState => ({ ...prevState, [name]: value }))
    }

    function handleSubmit(event) {
        event.preventDefault()
        const method = id ? 'put' : 'post'
        const url = id ? `/suppliers/${id}` : '/suppliers'

        axios[method](url, supplier)
        .then(() => {
            alert(`Fornecedor ${id ? 'atualizado' : 'adicionado'} com sucesso!`)
            navigate("/listar-fornecedores")
        })
        .catch(error => {
            console.error("Ocorreu um erro: ",error)
            handleErrors(error)
        } )
    }

    function handleErrors(error) {
        if (error.response) {
            if (error.response.status === 400) {
                if (Array.isArray(error.response.data)) {
                    setErrorMessage(error.response.data.join(', '))
                } else {
                    setErrorMessage(error.response.data.message || 'Ocorreu um erro desconhecido')
                }
            }
        }
    }

  return (
    <div className="container mt-5">
        <h2>{id ? 'Editar Fornecedor' : 'Adicionar Fornecedor'}</h2>
        {errorMessage && (
            <div className="alert alert-danger" role="alert">
                {errorMessage}
            </div>
        )}
        <form onSubmit={handleSubmit}>
            <div className="form-group">
                <label htmlFor="name">Nome do fornecedor:</label>
                <input type="text" className="form-control" id="name" name="name" value={supplier.name} onChange={handleChange} required />
            </div>
            <div className="form-group">
                <label htmlFor="cnpj">CNPJ do fornecedor:</label>
                <input type="text" className="form-control" id="cnpj" name="cnpj" value={supplier.cnpj} onChange={handleChange} required />
            </div>
            <div className="form-group">
                <label htmlFor="email">Email do fornecedor:</label>
                <input type="text" className="form-control" id="email" name="email" value={supplier.email} onChange={handleChange} required />
            </div>
            <button type="submit" className="btn btn-success">Adicionar</button>
        </form>

    </div>
  )
}

export default SupplierForm