import React from 'react'

const RenderizandoComFuncoes = () => {

    function escolhaDeRenderizacao(oQueRenderizar) {
        if (oQueRenderizar === "PB") {
            return <h1>Paraíba</h1>
        } else {
            return <h2>João Pessoa</h2>
        }
    }

  return (
    <div>
        {escolhaDeRenderizacao("PB")}
        {escolhaDeRenderizacao("JP")}
    </div>
  )
}

export default RenderizandoComFuncoes