import { Route, Routes } from 'react-router-dom'
import './App.css'
import Layout from './components/Layout'
import Homepage from './pages/Homepage'
import Borrow from './pages/Borrow'
import Return from './pages/Return'

function App() {
  return (
  <Layout>
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route path="/Borrow" element={<Borrow />} />
      <Route path="/Return" element={<Return />} />
    </Routes>
  </Layout>
  )
}

export default App
