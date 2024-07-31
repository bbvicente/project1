import { useState } from 'react'
import './App.css'
import Navbar from './components/Navbar'
import Warehouses from './pages/Warehouses'
import Inventory from './pages/Inventory'
import { Routes, Route } from 'react-router-dom'


function App() {

  return (
  <>
        <Navbar/>
        <div className='main-body'>
          <Routes>
            <Route path='/' element={<Warehouses/>}></Route>
            <Route path='/inventory' element={<Inventory/>}></Route>
          </Routes>
        </div>
        
  </>)
}
export default App
