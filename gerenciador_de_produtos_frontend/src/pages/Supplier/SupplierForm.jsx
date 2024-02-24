import React from 'react'
import { useState } from 'react'

const SupplierForm = () => {

    const [supplier, setSupplier] = useState({ name: '', cnpj: '', email: ''})

  return (
    <div className="container mt-5">
        <h2>Adicionar Fornecedor</h2>
        <form>
            <div className="form-group">

            </div>
        </form>

    </div>
  )
}

export default SupplierForm