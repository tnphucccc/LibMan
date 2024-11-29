import { Route, Routes } from 'react-router-dom'
import './App.css'
import Layout from './components/Layout'
import Homepage from './pages/Homepage'
import Books from './pages/Books'
import Authors from './pages/Authors'
import Record from './pages/Record'

function App() {
  return (
  <Layout>
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route path="/Authors" element={<Authors />} />
      <Route path="/Record" element={<Record/>} />
      <Route path='/Books' element={<Books />} />
    </Routes>
  </Layout>
  )
}

export default App
