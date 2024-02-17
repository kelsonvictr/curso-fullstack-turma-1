import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Inicial from './pages/Inicial'
import Afaculdade from './pages/Afaculdade'
import DpoLgpd from './pages/DpoLgpd'
import Noticias from './pages/Noticias'
import VisualizarNoticia from './pages/VisualizarNoticia'

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <h1>Uniesp - Centro Universitário</h1>
        <Routes>
          <Route path='/' element={<Inicial />} />
          <Route path='/a-faculdade' element={<Afaculdade />} />
          <Route path='/dpo-lgpd' element={<DpoLgpd />} />
          <Route path='/noticias' element={<Noticias />} />
          <Route path='/visualizar-noticia/:id' element={<VisualizarNoticia />} />
        </Routes>
      </BrowserRouter>
      
    </div>
  )
}

export default App