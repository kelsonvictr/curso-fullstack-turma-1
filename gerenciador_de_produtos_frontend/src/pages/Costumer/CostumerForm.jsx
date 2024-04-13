import React, { useState, useEffect } from 'react';
import axios from '../../api';
import { useNavigate, useParams } from 'react-router-dom';

const CostumerForm = () => {
    const [costumer, setCostumer] = useState({
        name: '',
        cpf: '',
        email: '',
        costumerAddressRequest: {
            street: '',
            number: '',
            neighborhood: '',
            city: '',
            state: '',
            country: '',
            zipCode: ''
        }
    });
    const navigate = useNavigate();
    const { id } = useParams();
    const [cepLoading, setCepLoading] = useState(false);

    useEffect(() => {
        if (id) {
            axios.get(`/costumers/${id}`)
                .then(response => {
                    setCostumer({ ...response.data, costumerAddressRequest: { ...response.data.costumerAddressRequest } });
                })
                .catch(error => console.error('Erro ao buscar cliente:', error));
        }
    }, [id]);

    function handleChange(event) {
        const { name, value } = event.target;
        if (name in costumer) {
            setCostumer(prevState => ({ ...prevState, [name]: value }));
        } else {
            setCostumer(prevState => ({
                ...prevState,
                costumerAddressRequest: {
                    ...prevState.costumerAddressRequest,
                    [name]: value
                }
            }));
        }
    }

    function handleSubmit(event) {
        event.preventDefault();
        const method = id ? 'put' : 'post';
        const url = id ? `/costumers/${id}` : '/costumers';

        axios[method](url, costumer)
            .then(() => {
                alert(`Cliente ${id ? 'atualizado' : 'adicionado'} com sucesso!`);
                navigate('/listar-clientes'); // Assumindo que você tem uma rota para listar clientes
            })
            .catch(error => console.error("Erro ao salvar o cliente:", error));
    }

    function handleCepBlur(event) {
        const cep = event.target.value.replace(/\D/g, '');
        if (cep.length !== 8) {
            alert("CEP deve ter 8 dígitos");
            return;
        }

        setCepLoading(true);

        axios.get(`https://viacep.com.br/ws/${cep}/json/`)
            .then(response => {
                if (response.data.erro) {
                    alert("CEP não encontrado.");
                    setCepLoading(false);
                    return;
                }

                setCostumer(prevState => ({
                    ...prevState,
                    costumerAddressRequest: {
                        ...prevState.costumerAddressRequest,
                        street: response.data.logradouro,
                        neighborhood: response.data.bairro,
                        city: response.data.localidade,
                        state: response.data.uf,
                        country: 'Brasil',
                        zipCode: cep
                    }
                }));

                setCepLoading(false);
            })
            .catch(error => {
                console.error("Erro ao buscar o CEP:", error);
                setCepLoading(false);
            });
    }

    return (
        <div className="container mt-5">
            <h2>{id ? 'Editar Cliente' : 'Adicionar Cliente'}</h2>
            <form onSubmit={handleSubmit}>
                {/* Campos do cliente */}
                <div className="form-group">
                    <label htmlFor="name">Nome do Cliente</label>
                    <input type="text" className="form-control" id="name" name="name" value={costumer.name} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="cpf">CPF do Cliente</label>
                    <input type="text" className="form-control" id="cpf" name="cpf" value={costumer.cpf} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email do Cliente</label>
                    <input type="email" className="form-control" id="email" name="email" value={costumer.email} onChange={handleChange} required />
                </div>
                {/* Campos do endereço do cliente */}
                <div className="form-group">
                    <label htmlFor="zipcode">CEP</label>
                    <input type="text" className="form-control" id="zipcode" name="zipCode" value={costumer.costumerAddressRequest.zipCode} onChange={handleChange} onBlur={handleCepBlur} required />
                    {cepLoading && <p>Buscando CEP...</p>}
                </div>
                <div className="form-group">
                    <label htmlFor="street">Rua/Logradouro</label>
                    <input type="text" className="form-control" id="street" name="street" value={costumer.costumerAddressRequest.street} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="number">Número</label>
                    <input type="text" className="form-control" id="number" name="number" value={costumer.costumerAddressRequest.number} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="neighborhood">Bairro</label>
                    <input type="text" className="form-control" id="neighborhood" name="neighborhood" value={costumer.costumerAddressRequest.neighborhood} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="city">Cidade</label>
                    <input type="text" className="form-control" id="city" name="city" value={costumer.costumerAddressRequest.city} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="state">Estado</label>
                    <input type="text" className="form-control" id="state" name="state" value={costumer.costumerAddressRequest.state} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <label htmlFor="country">País</label>
                    <input type="text" className="form-control" id="country" name="country" value={costumer.costumerAddressRequest.country} onChange={handleChange} required />
                </div>
                <button type="submit" className="btn btn-success">{id ? 'Atualizar' : 'Adicionar'}</button>
            </form>
        </div>
    );
}

export default CostumerForm;
