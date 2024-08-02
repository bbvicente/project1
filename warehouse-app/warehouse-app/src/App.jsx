//import { useState } from 'react'
import './App.css'
import Navbar from './components/Navbar'
import Inventory from './pages/Inventory'
import Warehouses from './pages/Warehouses'
import Products from './pages/Products'
import { WarehouseForm } from './components/WarehouseForm'
import { ProductForm } from './components/ProductForm'
import { Routes, Route } from 'react-router-dom'
import { WarehouseUpdateForm } from './components/WarehouseUpdateForm'
import { ProductUpdateForm } from './components/ProductUpdatedForm'
import { SuccessDeletePage } from './pages/SuccessDeletePage'

function App() {

  return (
  <>
        <Navbar/>
        <div className='main-body'>
          <Routes>
            <Route path='/' element={<Warehouses/>}></Route>
            <Route path='/success-delete-page' element={<SuccessDeletePage/>}></Route>
            <Route path='/products' element={<Products/>}></Route>
            <Route path='/inventory' element={<Inventory/>}></Route>
            <Route path='/create-warehouse' element={<WarehouseForm/>}></Route>
            <Route path='/create-product' element={<ProductForm/>}></Route>
            <Route path='/update-warehouse' element={<WarehouseUpdateForm/>}></Route>
            <Route path='/update-product' element={<ProductUpdateForm/>}></Route>
          </Routes>
        </div> 
  </>)
}

export default App
